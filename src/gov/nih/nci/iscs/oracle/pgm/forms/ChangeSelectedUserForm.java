package gov.nih.nci.iscs.oracle.pgm.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class ChangeSelectedUserForm extends ValidatorForm {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selectedUser;

	public String getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(String selectedUser) {
		this.selectedUser = selectedUser;
	}
	
	
	/* public ActionErrors validate(ActionMapping mapping, 
             HttpServletRequest request) {
		  ActionErrors errors = new ActionErrors();
		  
        if(selectedUser == null || selectedUser.trim().equals("")) {
       	 errors.add("selectname", new ActionError("Please Select a user to continue."));
        }
		  
		  return errors;
	  }*/
}