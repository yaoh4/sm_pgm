package gov.nih.nci.iscs.oracle.pgm.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

/**
 * This exception is used to mark business rule violations.
 *
 * @author Michelle Engermann
 */
public class PDAssignmentException extends RuntimeException {

    protected final Log logger = LogFactory.getLog(getClass());
	public PDAssignmentException() {}

	public PDAssignmentException(String className, String methodName, String message, HttpSession session) {
		super(message);
		String errorMessage = formatMessage(className, methodName, message);

	    session.setAttribute("returnTag", "PD Assignment Query");
	    session.setAttribute("returnAction", "SearchGrantsForPDA");
	    session.setAttribute(ApplicationConstants.ERROR_MESSAGE, errorMessage);
		logger.error(errorMessage);
	}
	public PDAssignmentException(String className, String methodName, String message,
	        HttpSession session, Exception ex) {
		super(message);
		String errorMessage = formatMessage(className, methodName, message);

        session.setAttribute(ApplicationConstants.ERROR_MESSAGE, errorMessage);
        session.setAttribute(ApplicationConstants.ERROR_EXCEPTION, ex);
	    session.setAttribute("returnTag", "PD Assignment Query");
	    session.setAttribute("returnAction", "SearchGrantsForPDA");

		logger.error(errorMessage);
	}

	public PDAssignmentException(String className, String methodName, String message) {
		super(message);
		String errorMessage = formatMessage(className, methodName, message);

	    //request.setAttribute("returnTag", "Return To PD Assignment");
	    //request.setAttribute("returnAction", "SearchGrantsForPDA");

        //session.setAttribute(ApplicationConstants.ERROR_MESSAGE, errorMessage);
		logger.error(errorMessage);
	}


     private String formatMessage(String className, String methodName, String message){

        String headerMsg = " An exception has occurred during PD Assignment process ";
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
