
package gov.nih.nci.iscs.oracle.pgm.exceptions;

public class NotAuthorizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotAuthorizedException() {
		super("You are not authorized to access the application.");
		
	}

	public NotAuthorizedException(String message) {
		super(message);		
	    //session.setAttribute(ApplicationConstants.ERROR_MESSAGE, message);
		//logger.error(" An exception has occurred \n" + message);
	}
	
}
