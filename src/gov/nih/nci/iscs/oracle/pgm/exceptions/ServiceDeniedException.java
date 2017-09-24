package gov.nih.nci.iscs.oracle.pgm.exceptions;

public class ServiceDeniedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ServiceDeniedException() {
		super("You do not have permission to perform the requested operation.");
		
	}

	public ServiceDeniedException(String message) {
		super(message);		
	    //session.setAttribute(ApplicationConstants.ERROR_MESSAGE, message);
		//logger.error(" An exception has occurred \n" + message);
	}
	
}
