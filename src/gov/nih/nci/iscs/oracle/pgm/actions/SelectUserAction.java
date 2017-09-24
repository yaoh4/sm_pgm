package gov.nih.nci.iscs.oracle.pgm.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.oracle.pgm.forms.ChangeSelectedUserForm;

public class SelectUserAction extends NciPgmAction {
	ActionMessages messages;

	public ActionForward executeAction(ActionMapping actionmapping, ActionForm actionform,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		messages = new ActionMessages();
		HttpSession session = request.getSession(false);
		ChangeSelectedUserForm myform = (ChangeSelectedUserForm) request.getAttribute("changeSelectedUserForm");
	    String user = myform.getSelectedUser();
	    
	    if((user == null || user.trim().equals(""))) {
	          super.logErrors(messages, "validation", "errors.no.user");
		   	  this.saveMessages(request, messages);
		   	  return actionmapping.findForward("continue");
		} else {
	    if (user.length() > 0 && !user.equalsIgnoreCase("")) {
	    	session.removeAttribute(NciUser.NCI_USER);
	        session.setAttribute("changeUser", user);      
	    }
        return actionmapping.findForward("success");
    }
	}
}


