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
public class GrantSearchException extends RuntimeException {

    protected final Log logger = LogFactory.getLog(getClass());
	public GrantSearchException() {}

	public GrantSearchException(String className, String methodName, String message, HttpSession session) {
		super(message);
		String errorMessage = formatMessage(className, methodName, message);

	    session.setAttribute(ApplicationConstants.ERROR_MESSAGE, errorMessage);
		logger.error(errorMessage);
	}
	public GrantSearchException(String className, String methodName, String message,
	        HttpSession session, Exception ex) {
		super(message);
		String errorMessage = formatMessage(className, methodName, message);

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


}
