package gov.nih.nci.iscs.oracle.pgm.actions;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUserImpl;
import gov.nih.nci.iscs.oracle.common.helper.ApplicationInfo;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.exceptions.NotAuthorizedException;
import gov.nih.nci.iscs.oracle.pgm.exceptions.UserLoginException;
import gov.nih.nci.iscs.oracle.pgm.hibernate.I2eActiveUserRolesVw;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import gov.nih.nci.iscs.oracle.pgm.service.impl.UserServiceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import sun.misc.BASE64Decoder;


public abstract class NciPgmAction extends Action {
  
    private Log logger = LogFactory.getLog(NciPgmAction.class);
    protected static String LOGIN_ERROR = "loginError";
   
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws UserLoginException, Exception
    {   
        ActionForward returnForward = null;
        if(!verifyUser(request, response))
        {
           logger.error( "Error verifying the user permissions and roles required for this application.");
           return mapping.findForward(LOGIN_ERROR);
        }

        returnForward = executeAction(mapping, form, request, response);
        return returnForward;
    }

    public boolean verifyUser(HttpServletRequest request, HttpServletResponse response)
        throws UserLoginException, Exception
    {
        boolean returnValue = false;
        HttpSession session = request.getSession(true);
        NciUser nu = (NciUser)session.getAttribute("nciuser");
        if(nu != null && nu.isValid())
        {
            returnValue = verifyUserForApp(request, response);
        } else
        {
            // get the User header from Site Minder
             String remoteUser = request.getHeader("SM_USER");
            // when deployed locally and authenticated from apache,
            // check the user from remote user  
             if (remoteUser== null){
                 remoteUser = request.getRemoteUser();
             }            
            
            if (remoteUser == null) {
                String authUser = request.getHeader("Authorization");
                
                if (StringUtils.isNotEmpty(authUser)) {
                        BASE64Decoder decoder = new BASE64Decoder();

                        authUser = new String(decoder.decodeBuffer(authUser.substring(6)));
                        remoteUser = authUser.substring(0, authUser.indexOf(":"));
               }

            }
            // setting the remote_user in a session variable.
    		if(!StringUtils.isEmpty(remoteUser)) {
              session.setAttribute(ApplicationConstants.REMOTE_USER, remoteUser);
    		}
    		
    		//getting the remote user from session if it is null.
    		if(StringUtils.isEmpty(remoteUser)) {
    			remoteUser = (String) session.getAttribute(ApplicationConstants.REMOTE_USER);
    		}
    		
            if(StringUtils.isNotEmpty(remoteUser)) {

            	if(isUserValid(request, response, remoteUser)) {
            		
	            	nu = getUser(request);
	            	nu.setAttribute("readOnly", "false");
	            	
	            	if(session.getAttribute("changeUser") != null && !isI2eDeveloper(nu)) {
	            		throw new NotAuthorizedException();
	            	}
	            	
	            	//If logged on user is I2E developer
	            	if(isI2eDeveloper(nu)) {          		
	            		session.setAttribute("devRole","Y");
	            		//If changeUser is set, validate and replace new user in session
	            		if(session.getAttribute("changeUser") != null) {
	            			String changeUser = (String)session.getAttribute("changeUser");
	            			if(isUserValid(request, response, changeUser)) {
	            					nu = getUser(request);
	            					if(!verifyUserForApp(request,response)) {
	            						session.removeAttribute(NciUser.NCI_USER);
	            						throw new NotAuthorizedException();
	            					}
	            					logger.info("Remote User" + remoteUser);
		            				logger.info("Change User to: "+nu.getFullName());
	            			}
	            			else {
	            				throw new NotAuthorizedException();
	            	        }

	            	  }
	            		if(isProdEnv(request)) {
	            			nu.setAttribute("readOnly", "true");
	            			request.getSession().setAttribute(NciUser.NCI_USER, nu);
	            		}
	            		return true;
	            	}
	            		
	            	return verifyUserForApp(request,response);
	            }
            }
            else {
            	throw new Exception("Site Minder did not pass the SM User.");
            }
        }
        return returnValue;
    }
    
    protected boolean isUserValid(HttpServletRequest request, 
    		HttpServletResponse response, String remoteUser) throws Exception {
    	NciUserImpl nciUser = getNCIUser(request, remoteUser);
    	
    	String accessError = "User "+ remoteUser +" is not authorized to access PGM application. ";
		String errorReason = "";
		
		if(nciUser == null){
			logger.error(accessError);
        	navigateToHome(this.getClass().getName(),request.getSession());
        	return false;
		}
		
		//If OracleId is Null
		if(StringUtils.isEmpty(nciUser.getOracleId())){
			errorReason = "OracleId is Null.";
		}
		//If Email is Null
        if(StringUtils.isEmpty((String)nciUser.getAttribute("mail"))){
			errorReason = "Email is Null.";
		}
		//If User is Inactive
		else if("N".equalsIgnoreCase((String)nciUser.getAttribute("activeFlag"))){
			errorReason = "I2E Account is not Active.";
		}   
		
        Object mApplicationContext = getAppAttribute(request, ApplicationConstants.PGM_CONTEXT_FACTORY);
        UserServiceImpl mUserServiceImpl =  new UserServiceImpl(mApplicationContext, remoteUser);
        if(mUserServiceImpl.isRestrictedUser(nciUser.getOracleId())) {
          	 errorReason = "User has Restricted access.";
        }
        
		//If User is Inactive, then navigate the user to Login Error page.
		if(StringUtils.isNotEmpty(errorReason)){
			logger.error(accessError + errorReason);
        	navigateToHome(this.getClass().getName(),request.getSession());
        	return false;
		}
    	
        nciUser.setAttribute("dbRoles", getUserDbRoles(request, (String)nciUser.getAttribute("nciOracleId")));
        nciUser.setAttribute("appRoles", mUserServiceImpl.getUserAppRoles(nciUser.getUserId()));
        HttpSession session = request.getSession(true);
        session.setAttribute("nciuser", nciUser);
        
        //setting the user filter info 
        UserFilterInfo mUserFilterInfo = (UserFilterInfo) request.getSession().getAttribute(ApplicationConstants.USER_FILTER_INFO);
        UserServiceImpl mUserServiceImpl1 =  new UserServiceImpl(mApplicationContext, nciUser.getOracleId());
	    mUserFilterInfo = mUserServiceImpl1.getUserFilerInfo(nciUser.getOracleId());
	    request.getSession().setAttribute(ApplicationConstants.USER_FILTER_INFO, mUserFilterInfo);
    	return true;
    }
    
    
	public boolean isI2eDeveloper(NciUser nciUser) {
    	@SuppressWarnings("unchecked")
		List<I2eActiveUserRolesVw> appRoles = (List<I2eActiveUserRolesVw>) nciUser.getAttribute("appRoles");
    	if(appRoles != null) {
    	 for(I2eActiveUserRolesVw role: appRoles) {
    		if(ApplicationConstants.APP_ROLE_CODE_I2E_DEVELOPER.equals(role.getRoleCode())) {
    			return true;
    		}
    	 }
    	}
    	
    	return false;
    }

    public boolean isProdEnv(HttpServletRequest request) {
    	HttpSession session = request.getSession(true);
    	ApplicationInfo appInfo = (ApplicationInfo)session.getServletContext().getAttribute("applicationInfo");
        String env = appInfo.getApplicationKey("ENVIRONMENT_INSTANCE");
        if(!"Local Development".equalsIgnoreCase(env) &&
    			!"Development".equalsIgnoreCase(env) &&
    			!"Test".equalsIgnoreCase(env) &&
    			!"Stage".equalsIgnoreCase(env)) {
    		//This is prod environment, so restrict access
    		return true;
    	}
    	
    	
        /*if("Test".equalsIgnoreCase(env)) {
    		return true;
    	}*/
    	
    	return false;
    }
    
    public abstract ActionForward executeAction(ActionMapping actionmapping, ActionForm actionform, HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws Exception;

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
    	boolean result = true;
    	
        NciUser nu = this.getUser(request);       
        Set roleSet = (Set)nu.getAttribute("dbRoles");
        if ((roleSet == null)){
        	logger.info("RoleSet is null for user " + nu.getUserId());
           result = false;
        }
	    if ( !(roleSet.contains("PGM_L1")) & (!(roleSet.contains("PGM_L2")))){
            logger.info("Required roles for set for user "  +nu.getUserId());
			result =  false;
		}

	    if(result == false) {
	    	navigateToHome(this.getClass().getName(),request.getSession());
	    }
        return result;
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
     * Registers an error with the request, which will be displayed to the user.
     */
    public void registerException(HttpServletRequest request, String errorKey)
        throws Exception {
        ActionErrors errors = new ActionErrors();
        ActionError error = new ActionError(errorKey);
        errors.add(ActionErrors.GLOBAL_MESSAGE, error);
        this.saveErrors(request, errors);
    }

   public void logErrors(ActionMessages messages, String errorKey, String errorMsg) {

	ActionMessage message = new ActionMessage(errorMsg);
	messages.add(errorKey, message);

 }

 public void saveMessages(List validationMessages, HttpServletRequest request) throws Exception {

    //try{

 	   ActionMessages messages = new ActionMessages();
 	   Iterator mIterator = validationMessages.iterator();
 	   while(mIterator.hasNext() ) {
 		   String msg = (String) mIterator.next();
 	       logErrors(messages, "validation", msg);
 	   }

 	   //request.setAttribute("message", messages);
        this.saveMessages(request, messages);

    /*}catch(Exception ex) {
 	   logger.error("An exception occurred during form validation" + ex.toString());
    }*/

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
