package gov.nih.nci.iscs.oracle.pgm.forms;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import java.util.ArrayList;
import java.util.*;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm ;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.servlet.http.HttpServletRequest;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;


public class GrantSearchErrorForm extends ValidatorForm   {

    private String userMessage;
    private String requestAction;


    public GrantSearchErrorForm() {
  	    this.userMessage = ApplicationConstants.EMPTY_STRING;
  	    this.requestAction = ApplicationConstants.EMPTY_STRING;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
    }



    public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getUserMessage() {
		if(userMessage == null)
		   return ApplicationConstants.EMPTY_STRING;
		return userMessage;
	}

   public void setRequestAction(String requestAction) {
		this.requestAction = requestAction;
	}

	public String getRequestAction() {
		return requestAction;
	}



    public String toString() {
       return new ToStringBuilder(this)
           .append("userMessage ", getUserMessage())
           .append("requestAction ", getRequestAction())
           .toString();
	}

}
