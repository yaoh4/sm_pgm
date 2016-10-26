package gov.nih.nci.iscs.oracle.pgm.actions;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUserImpl;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.exceptions.UserLoginException;
import gov.nih.nci.iscs.oracle.pgm.service.impl.UserServiceImpl;


public class ChangeUserAction extends Action {
  
    private Log logger = LogFactory.getLog(ChangeUserAction.class);
    private static String LOGIN_ERROR = "loginError";
    private String user;
   
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws UserLoginException, Exception
    {   
        ActionForward returnForward = mapping.findForward("success");
        if(!verifyUser(request, response))
        {
           logger.error( "Error verifying the user permissions and roles required for this application.");
           return mapping.findForward(LOGIN_ERROR);
        }
       
        return returnForward;
    }

    public boolean verifyUser(HttpServletRequest request, HttpServletResponse response)
        throws UserLoginException, Exception
    {
    	boolean returnValue = false;
        HttpSession session = request.getSession(true);
    	//This is user entered parameter 'user'
   	 	user = request.getParameter("user");

    	if(StringUtils.isNotEmpty(user)) {

    		NciUserImpl nciUser = getNCIUser(request,user);   		

    		String accessError = "User "+ user +" is not authorized to access PGM application. ";
    		String errorReason = "";
    		
    		if(nciUser == null){
    			logger.error(accessError);
            	navigateToHome(this.getClass().getName(),request.getSession());
            	return false;
    		}
    		
    		//If Email is Null
    		if(StringUtils.isEmpty((String)nciUser.getAttribute("mail"))){
    			errorReason = "Email is Null.";
    		}
    		//If User is Inactive
    		else if("N".equalsIgnoreCase((String)nciUser.getAttribute("activeFlag"))){
    			errorReason = "I2E Account is not Active.";
    		}   

    		//If User is Inactive, then navigate the user to Login Error page.
    		if(StringUtils.isNotEmpty(errorReason)){
    			logger.error(accessError + errorReason);
    			navigateToHome(this.getClass().getName(),request.getSession());
    			return false;
    		}

    		nciUser.setAttribute("dbRoles", getUserDbRoles(request, (String)nciUser.getAttribute("nciOracleId")));
    		session.setAttribute("nciuser", nciUser);
    		returnValue = verifyUserForApp(request, response);

    	} 	
 
        return returnValue;
    }
   
  /**
     * Gets the set of roles a user is granted in the database.
     * @param request
     * @param nciOracleId
     * @return
     */
    public Set getUserDbRoles(HttpServletRequest request, String nciOracleId) throws Exception
    {
       Object mApplicationContext = getAppAttribute(request, ApplicationConstants.PGM_CONTEXT_FACTORY);
       UserServiceImpl mUserServiceImpl =  new UserServiceImpl(mApplicationContext, nciOracleId);
       Set roleSet = mUserServiceImpl.getUserDbRoles(nciOracleId);
       return roleSet;

    }
    
    /**
     * This method retrieves information of logged in user from NciPeopleVw and populates NCIUser.
     * @param userId    
     * @return NciUserImpl
     */
    public NciUserImpl getNCIUser(HttpServletRequest request, String userId) throws Exception
    {
       Object mApplicationContext = getAppAttribute(request, ApplicationConstants.PGM_CONTEXT_FACTORY);
       UserServiceImpl mUserServiceImpl =  new UserServiceImpl(mApplicationContext, userId);
       return  mUserServiceImpl.getNCIUser(userId);
    }
    
    /**
   * Defines the user authorization for this action, this can be overiden by the actual actions
   * if each requires a different authorization.
   * @param request
   * @param response
   * @return
   * @throws java.lang.Exception
   */
    public boolean verifyUserForApp(HttpServletRequest request,
        HttpServletResponse response) throws Exception
    {
        NciUser nu = this.getUser(request);       
        Set roleSet = (Set)nu.getAttribute("dbRoles");
        if ((roleSet == null)){
           return false;
        }
	    if ( !(roleSet.contains("PGM_L1")) & (!(roleSet.contains("PGM_L2")))){
            logger.info("VERIFY USER IS FALSE");
			return false;
		}

        return true;
    }
   /**
   * Returns the NciUser object stored in the session.
   * @param request
   * @return
   * @throws java.lang.Exception
   */
    public NciUser getUser(HttpServletRequest request)
        throws Exception {
        HttpSession session = request.getSession();

        return ((NciUser) session.getAttribute(NciUser.NCI_USER));

    }

   /**
   * Returns any application attribute stored in the Servlet Context.
   * @param request
   * @param attrbKey
   * @return
   * @throws java.lang.Exception
   */
    public Object getAppAttribute(HttpServletRequest request, String attrbKey)
        throws Exception {
        HttpSession session = request.getSession();
        ServletContext sc = session.getServletContext();

        return (sc.getAttribute(attrbKey));
    }   
    
    /**
     * This method decides which application should be displayed :  PD assignment or Referral activity.
     * @param className
     * @param session
     */
    private void navigateToHome(String className, HttpSession session){

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
