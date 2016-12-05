package gov.nih.nci.iscs.oracle.pgm.actions;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.exceptions.UserLoginException;
import gov.nih.nci.iscs.oracle.common.helper.ApplicationInfo;

public class ChangeUserAction extends NciPgmAction {
  
    private Log logger = LogFactory.getLog(ChangeUserAction.class);
    private String user;
   
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws UserLoginException, Exception
    {   
    	HttpSession session = request.getSession(true);
    	ApplicationInfo appInfo = (ApplicationInfo)session.getServletContext().getAttribute("applicationInfo");
        String env = appInfo.getApplicationKey("ENVIRONMENT_INSTANCE");
        if (!"Local Development".equalsIgnoreCase(env) &&                  	
            !"Development".equalsIgnoreCase(env) &&
            !"Test".equalsIgnoreCase(env) &&
            !"Stage".equalsIgnoreCase(env)) {
            return mapping.findForward("success");
        }
        
        if(!verifyUser(request, response)) {
           logger.error( "Error verifying the user permissions and roles required for this application.");
           return mapping.findForward(LOGIN_ERROR);
        }

        return executeAction(mapping, form, request, response);
    }
    
    
    public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) {
    	return mapping.findForward("success");
    }


    public boolean verifyUser(HttpServletRequest request, HttpServletResponse response)
        throws UserLoginException, Exception
    {
    	logger.info("Verifying user for ChangeUser");
    	
    	//This is user entered parameter 'user'
   	 	user = request.getParameter("user");

    	if(StringUtils.isNotEmpty(user)) {
    		return isUserValid(request, response, user);
    	} 	
 
        return false;
    }
      
}
