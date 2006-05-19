package gov.nih.nci.iscs.oracle.pgm.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This exception is used to mark business rule violations.
 *
 * @author Michelle Engermann
 */
public class CommandDaoException extends RuntimeException {

    protected final Log logger = LogFactory.getLog(getClass());
	public CommandDaoException() {}

	public CommandDaoException(String message) {
		super(message);
		logger.error(" An application exception has aoocurred!!! " + message);
	}

	//public CommandDaoException(String message, Throwable cause) {
	//	super(message, cause);
	//}

	//public CommandDaoException(Throwable cause) {
	//	super(cause);
	//}
}
