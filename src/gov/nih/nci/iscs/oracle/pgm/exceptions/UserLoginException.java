package gov.nih.nci.iscs.oracle.pgm.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import gov.nih.nci.iscs.oracle.pgm.forms.GrantSearchErrorForm;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import javax.servlet.http.HttpSession;


/**
 * This exception is used to mark business rule violations.
 *
 * @author Michelle Engermann
 */
public class UserLoginException extends RuntimeException {

    protected final Log logger = LogFactory.getLog(getClass());
	public UserLoginException() {}

	public UserLoginException(String className, String methodName, String message, HttpSession session) {
		super(message);
		formatTags(className, session);
		String errorMessage = formatMessage(className, methodName, message);

	    session.setAttribute(ApplicationConstants.ERROR_MESSAGE, errorMessage);
		logger.error(" An exception has occurred during authetication/authorization process \n" + errorMessage);
	}


     private String formatMessage(String className, String methodName, String message){


	    String errorMessage =  new StringBuffer("")
		            .append(" An exception has occurred during authetication/authorization process")
		            .append("Implementation Class: ")
		            .append(className)
		            .append("<BR>")
		            .append("Implemenation Method: ")
		            .append(methodName)
		            .append("<BR>")
	                .append("Message: ")
		            .append(message)
            .toString();

            return errorMessage;

	 }

     private void formatTags(String className, HttpSession session){


	    if(className.equalsIgnoreCase("SearchGrantsForReferralAction") ||
	       className.equalsIgnoreCase("ExternalReferralAction") ||
	       className.equalsIgnoreCase("gov.nih.nci.iscs.oracle.pgm.actions.ExternalReferralAction") ||
	       className.equalsIgnoreCase("gov.nih.nci.iscs.oracle.pgm.actions.SearchGrantsForReferralAction")){
	       session.setAttribute("returnTag", "Referral Activity Query");
	       session.setAttribute("returnAction", "SearchGrantsForReferral");
	       session.setAttribute("applicationName", "Referral");
	       return;
	    }
	    if(className.equalsIgnoreCase("SearchGrantsForPDAAction") ||
	       className.equalsIgnoreCase("gov.nih.nci.iscs.oracle.pgm.actions.SearchGrantsForPDAAction")){
	       session.setAttribute("returnTag", "PD Assignment Query");
	       session.setAttribute("returnAction", "SearchGrantsForPDA");
	       session.setAttribute("applicationName", "PD");
	       return;
	    }
	    session.setAttribute("returnTag", "PD Assignment Query");
	    session.setAttribute("returnAction", "SearchGrantsForPDA");
	    session.setAttribute("applicationName", "PD");


	 }

}
