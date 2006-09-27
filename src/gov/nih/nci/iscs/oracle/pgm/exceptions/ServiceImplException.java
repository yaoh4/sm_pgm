package gov.nih.nci.iscs.oracle.pgm.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * This exception is used to mark business rule violations.
 *
 * @author Michelle Engermann
 */
public class ServiceImplException extends RuntimeException {

    protected final Log logger = LogFactory.getLog(getClass());
	public ServiceImplException() {}

	public ServiceImplException(String className, String methodName, String message) {
		super(message);
		String errorMessage =  new ToStringBuilder(this)
		            .append("Implementation Class: ", className )
		            .append("Implemenation Method: ", methodName )
		            .append("Message: ", message )
            .toString();
		logger.error(" An exception has occurred during Grant Retrieveal process \n" + errorMessage);
	}


}
