package gov.nih.nci.iscs.oracle.pgm.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

import javax.servlet.http.HttpSession;

/**
 * This exception is used to mark business rule violations.
 *
 * @author Michelle Engermann
 */
public class ReferralActionException extends RuntimeException {

    protected final Log logger = LogFactory.getLog(getClass());
	public ReferralActionException() {}

	public ReferralActionException(String className, String methodName, String message, HttpSession session) {
		super(message);
		String errorMessage = formatMessage(className, methodName, message);

	    session.setAttribute(ApplicationConstants.ERROR_MESSAGE, errorMessage);
		logger.error(errorMessage);
	}
	public ReferralActionException(String className, String methodName, String message,
	        HttpSession session, Exception ex) {
		super(message);
		String errorMessage = formatMessage(className, methodName, message);

        session.setAttribute(ApplicationConstants.ERROR_MESSAGE, errorMessage);
        session.setAttribute(ApplicationConstants.ERROR_EXCEPTION, ex);

		logger.error(errorMessage);
	}

	public ReferralActionException(String className, String methodName, String message) {
		super(message);
		String errorMessage = formatMessage(className, methodName, message);

        //session.setAttribute(ApplicationConstants.ERROR_MESSAGE, errorMessage);
		logger.error(errorMessage);
	}


     private String formatMessage(String className, String methodName, String message){

        String headerMsg = "";
        if(className.equalsIgnoreCase("AcceptReferralAction") ){
			headerMsg = " An exception has occurred during Accept Referral process ";
		}

        if(className.equalsIgnoreCase("RejectReferralAction") ){
			headerMsg = " An exception has occurred during Reject Referral process ";
		}

        if(className.equalsIgnoreCase("RereferReferralAction") ){
			headerMsg = " An exception has occurred during Rerefer Referral process ";
		}

        if(className.equalsIgnoreCase("ReleaseReferralAction") ){
			headerMsg = " An exception has occurred during Release Referral process ";
		}
	    String errorMessage =  new StringBuffer("")
		            .append(headerMsg)
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


}
