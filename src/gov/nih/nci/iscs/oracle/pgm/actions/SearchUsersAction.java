package gov.nih.nci.iscs.oracle.pgm.actions;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.SearchNedUsersForm;
import gov.nih.nci.iscs.oracle.pgm.hibernate.NciPeopleVw;
import gov.nih.nci.iscs.oracle.pgm.service.impl.UserServiceImpl;

public class SearchUsersAction extends NciPgmAction {
	 ActionMessages messages;

	public ActionForward executeAction(ActionMapping actionmapping, ActionForm actionform,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		 messages = new ActionMessages();
	   	HttpSession session = request.getSession(false);
	   	SearchNedUsersForm myform =(SearchNedUsersForm) request.getAttribute("searchNedUsersForm");
	    String lastname = myform.getLastName();
	    String firstname = myform.getFirstName();
	    if((lastname == null || lastname.trim().equals("")) && (firstname == null || ("").equalsIgnoreCase(firstname))) {
	          super.logErrors(messages, "validation", "errors.no.name");
		   	  this.saveMessages(request, messages);
		   	  session.removeAttribute("searchresults");
		   	 session.removeAttribute("neduserslist");
		   	  return actionmapping.findForward("continue");
		} else {
	    Object mApplicationContext = getAppAttribute(request, ApplicationConstants.PGM_CONTEXT_FACTORY);
	       UserServiceImpl mUserServiceImpl =  new UserServiceImpl(mApplicationContext);
    	List<NciPeopleVw> foundUsers = mUserServiceImpl.searchUser(firstname.trim(), lastname.trim()); 
    	if (foundUsers != null) {
    		String remoteUser = (String) session.getAttribute(ApplicationConstants.REMOTE_USER);
 			NciPeopleVw np = null;
 			 for (final Iterator<NciPeopleVw> i = foundUsers.iterator(); i.hasNext();) {
 				np = i.next();
 				  if (remoteUser.equalsIgnoreCase(np.getNihNetworkId())) {
 					  i.remove();
 				  }
 			 }
 		}
    
    	  if(foundUsers.size() == 0) {
    		session.setAttribute("searchresults", "No Results found for this search");
    	  }
    	  
    	session.setAttribute("neduserslist", foundUsers);
        return actionmapping.findForward("success");
		}
	}

}
