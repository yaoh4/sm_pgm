package gov.nih.nci.iscs.oracle.pgm.forms;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

public class SearchNedUsersForm extends ValidatorForm {


	private String lastName;
	private String firstName;
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/* public List validate() {
		  ArrayList validationMessages = new ArrayList();
		  if((lastName == null || lastName.trim().equals("")) && (firstName == null || ("").equalsIgnoreCase(firstName))) {
		   		     validationMessages.add("Last or First Name is required for Search.");
			   }
			 return validationMessages;
	  }*/

}