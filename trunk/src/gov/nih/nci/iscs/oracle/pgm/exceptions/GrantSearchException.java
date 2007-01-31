package gov.nih.nci.iscs.oracle.pgm.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

/**
 * This exception is used to mark business rule violations.
 *
 * @author Michelle Engermann
 */
public class GrantSearchException extends RuntimeException {

    protected final Log logger = LogFactory.getLog(getClass());
	public GrantSearchException() {}


	public GrantSearchException(String className, String methodName, String message, HttpSession session) {
		super(message);
		formatTags(className, session);
		String errorMessage = formatMessage(className, methodName, message);

	    session.setAttribute(ApplicationConstants.ERROR_MESSAGE, errorMessage);
		logger.error(errorMessage);
	}
	public GrantSearchException(String className, String methodName, String message,
	        HttpSession session, Exception ex) {
		super(message);
		String errorMessage = formatMessage(className, methodName, message);

		formatTags(className, session);
        session.setAttribute(ApplicationConstants.ERROR_MESSAGE, errorMessage);
        session.setAttribute(ApplicationConstants.ERROR_EXCEPTION, ex);

		logger.error(errorMessage);
	}
	public GrantSearchException(String className, String methodName, String message) {
		super(message);
		String errorMessage = formatMessage(className, methodName, message);

        //session.setAttribute(ApplicationConstants.ERROR_MESSAGE, errorMessage);
		logger.error(errorMessage);
	}




     private String formatMessage(String className, String methodName, String message){


	    String errorMessage =  new StringBuffer("")
		            .append(" An exception has occurred during Grant Search process ")
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

     private void formatTags(String className, HttpServletRequest request){


	    if(className.equalsIgnoreCase("SearchGrantsForReferralAction") ||
	       className.equalsIgnoreCase("ExternalReferralAction")){
	       request.setAttribute("returnTag", "Referral Activity Query");
	       request.setAttribute("returnAction", "SearchGrantsForReferral");
	       return;
	    }
	    if(className.equalsIgnoreCase("SearchGrantsForPDAAction")){
	       request.setAttribute("returnTag", "PD Assignment Query");
	       request.setAttribute("returnAction", "SearchGrantsForPDA");
	       return;
	    }
	    request.setAttribute("returnTag", "PD Assignment Query");
	    request.setAttribute("returnAction", "SearchGrantsForPDA");


	 }

     private void formatTags(String className, HttpSession session){


	    if(className.equalsIgnoreCase("SearchGrantsForReferralAction") ||
	       className.equalsIgnoreCase("ExternalReferralAction")){
	       session.setAttribute("returnTag", "Referral Activity Query");
	       session.setAttribute("returnAction", "SearchGrantsForReferral");
	       return;
	    }
	    if(className.equalsIgnoreCase("SearchGrantsForPDAAction")){
	       session.setAttribute("returnTag", "PD Assignment Query");
	       session.setAttribute("returnAction", "SearchGrantsForPDA");
	       return;
	    }
	    session.setAttribute("returnTag", "PD Assignment Query");
	    session.setAttribute("returnAction", "SearchGrantsForPDA");


	 }

}
