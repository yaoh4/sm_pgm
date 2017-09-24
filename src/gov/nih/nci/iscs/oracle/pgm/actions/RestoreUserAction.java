package gov.nih.nci.iscs.oracle.pgm.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUserImpl;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.impl.UserServiceImpl;

public class RestoreUserAction extends NciPgmAction {

	public ActionForward executeAction(ActionMapping actionmapping, ActionForm actionform,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		 HttpSession session = request.getSession(false);
	     session.removeAttribute("changeUser");
    	 String remoteUser = (String) session.getAttribute(ApplicationConstants.REMOTE_USER);
    	   if(StringUtils.isEmpty(remoteUser)) {
    		remoteUser = request.getHeader("SM_USER");
    	   }
       Object mApplicationContext = getAppAttribute(request, ApplicationConstants.PGM_CONTEXT_FACTORY);
       UserServiceImpl mUserServiceImpl =  new UserServiceImpl(mApplicationContext, remoteUser);
   	   NciUserImpl remote_user = mUserServiceImpl.getNCIUser(remoteUser);  
   	   remote_user.setAttribute("dbRoles", mUserServiceImpl.getUserDbRoles((String)remote_user.getAttribute("nciOracleId"))); 
   	   remote_user.setAttribute("appRoles", mUserServiceImpl.getUserAppRoles(remote_user.getUserId()));
   	    if(isI2eDeveloper(remote_user) && isProdEnv(request)) {
	   		remote_user.setAttribute("readOnly", "true");
	   	   }
       session.setAttribute(NciUser.NCI_USER, remote_user);
       
	 return actionmapping.findForward("success");
	}

}
