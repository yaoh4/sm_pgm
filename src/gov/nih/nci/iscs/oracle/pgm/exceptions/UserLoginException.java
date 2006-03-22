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

	public UserLoginException(String message, Exception ex, HttpSession session) {
		super(message);
		System.out.println("*** in UserLoginException and className is *** " );
		GrantSearchErrorForm mGrantSearchErrorForm = new GrantSearchErrorForm();
		mGrantSearchErrorForm.setRequestAction("login");
		/*String errorMessage =  new ToStringBuilder(this)
		            .append("Implementation Class: ", className )
		            .append("Implemenation Method: ", methodName )
		            .append("Message: ", message )
            .toString(); */
        session.setAttribute(ApplicationConstants.ERROR_MESSAGE, message);
        session.setAttribute(ApplicationConstants.ERROR_EXCEPTION, ex);
		logger.error(" An exception has occurred during authetication/authorization process \n" + message);
	}

	public UserLoginException(String message, HttpSession session) {
		super(message);
		System.out.println("*** in UserLoginException and className is *** " );
		GrantSearchErrorForm mGrantSearchErrorForm = new GrantSearchErrorForm();
		mGrantSearchErrorForm.setRequestAction("login");
        System.out.println("*** now in UserLoginException constructor **** ");
		/*String errorMessage =  new ToStringBuilder(this)
		            .append("Implementation Class: ", className )
		            .append("Implemenation Method: ", methodName )
		            .append("Message: ", message )
            .toString(); */
        session.setAttribute(ApplicationConstants.ERROR_MESSAGE, message);
		logger.error(" An exception has occurred during authetication/authorization process \n" + message);
	}
}
