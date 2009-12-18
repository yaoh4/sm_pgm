package gov.nih.nci.iscs.oracle.pgm.actions;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.impl.UserServiceImpl;
import gov.nih.nci.iscs.oracle.common.ldap.LDAPUtil;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUserImpl;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

import org.apache.struts.action.*;

import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.*;

import javax.naming.directory.Attributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Decoder;


public abstract class NciPgmAction extends Action {
  //  private Logger logger = LogManager.getLogger(NciPgmAction.class);
    private Log logger = LogFactory.getLog(NciPgmAction.class);
    private static String USER_LOGIN_FAILURE = "failure";
    private String[] stAttrDirIDs = {
        "nciOracleID", "fullName", "givenName", "sn", "mail", "telephoneNumber",
        "cn"
    };

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws UserLoginException, Exception
    {   
        ActionForward returnForward = null;
        if(!verifyUser(request, response))
        {
           throw new UserLoginException(this.getClass().getName(), "execute", "Error verifying the user permissions and roles required for this application. ", request.getSession());
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
            String remoteUser = request.getRemoteUser();
            
            if (remoteUser == null) {
                String authUser = request.getHeader("Authorization");
                
                if (StringUtils.isNotEmpty(authUser)) {
                        BASE64Decoder decoder = new BASE64Decoder();

                        authUser = new String(decoder.decodeBuffer(authUser.substring(6)));
                        remoteUser = authUser.substring(0, authUser.indexOf(":"));
               }

            }
            if(remoteUser != null && !remoteUser.equals(""))
            {
                NciUserImpl nui = new NciUserImpl();
                StringBuffer ru = new StringBuffer(50);
                if(remoteUser.indexOf("cn=") >= 0)
                {
                    int cnIdx = remoteUser.indexOf("cn=");
                    for(int i = cnIdx + 3; i < remoteUser.length() && remoteUser.charAt(i) != ','; i++)
                        ru.append(remoteUser.charAt(i));

                } else
                {
                    ru.append(remoteUser);
                }
                nui.setUserId(ru.toString());
                if(setUserAttributes(nui, request)) {
					session.setAttribute("nciuser", nui);
                    returnValue = verifyUserForApp(request, response);
				} else {
				   logger.error("User Priviledges denied - 1!!! ");
					return false;
				}
            }
        }
        return returnValue;
    }
    public abstract ActionForward executeAction(ActionMapping actionmapping, ActionForm actionform, HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws Exception;

  /**
   * Sets the user attributes from Ldap, this method is called from the super class
   * after it gets the remote user.
   * @param user
   * @param request
   * @throws java.lang.Exception
   */
    public boolean setUserAttributes(NciUser user, HttpServletRequest request)
        throws UserLoginException, Exception {
        LDAPUtil ctx = (LDAPUtil) this.getAppAttribute(request, ApplicationConstants.LDAP_SEARCHER);
        String stFDN = null;        
        Attributes attribs =  null;
        

          if ((user != null) && (user.isValid())) {
            try {
                stFDN = ctx.getUserFDN(user.getUserId());

                attribs = ctx.getAttributes(stFDN, stAttrDirIDs);

                if (attribs.get("mail").get() != null) {
                    user.setAttribute("mail", attribs.get("mail").get());
                } else {
                    user.setAttribute("mail", null);
                }
            } catch (Exception ex) {
                logger.error(ex);
                throw new UserLoginException(this.getClass().getName(), "setUserAttributes", "Invalid LDAP User attribute mail. " + ex.getMessage(), request.getSession());
            }

            try {
                if (attribs.get("nciOracleId").get() != null) {
                    user.setAttribute("nciOracleId",
                        attribs.get("nciOracleId").get());
                } else {
                    user.setAttribute(("nciOracleId"), null);
                }
            } catch (Exception ex) {
                logger.error(ex);
    		    throw new UserLoginException(this.getClass().getName(), "setUserAttributes", "Invalid LDAP attribute for nciOracleId. " + ex.getMessage(), request.getSession());
        }

            try {
                if (attribs.get("givenName").get() != null) {
                    user.setAttribute("givenName",
                        attribs.get("givenName").get());
                } else {
                    user.setAttribute("givenName", null);
                }
            } catch (Exception ex) {
                logger.error(ex);
                //throw new UserLoginException("Error verifying the user permissions and roles required for this application.", ex, request.getSession());

            }
            try
            {
                 if (attribs.get("sn").get() != null)
                 {
                     user.setAttribute("lastName", attribs.get("sn").get());
                 }
                 else
                 {
                    user.setAttribute("lastName", null);
                 }
            } catch(Exception ex) {
                logger.error(ex);
				throw new UserLoginException(this.getClass().getName(), "setUserAttributes", "Invalid LDAP attribute for lastName.. " + ex.getMessage(),  request.getSession());
            }

            try {
                if (attribs.get("fullName").get() != null) {
                    user.setAttribute("fullName", attribs.get("fullName").get());
                } else {
                    user.setAttribute("fullName", null);
                }
            } catch (Exception ex) {
                String givenName = (String)user.getAttribute("givenName");
                String lastName = (String)user.getAttribute("lastName");
                if (givenName ==  null) givenName = "";
                if (lastName == null) lastName = "";
                user.setAttribute("fullName",givenName+" "+lastName);
                logger.error(ex);
				//throw new UserLoginException("Error verifying the user permissions and roles required for this application.", ex, request.getSession());
            }
            try
            {
               Set roleSet = getUserDbRoles(request, (String)user.getAttribute("nciOracleId"));
               if(roleSet.size() == 0){
				   throw new UserLoginException(this.getClass().getName(), "setUserAttributes", "Error verifying the user permissions and roles required for this application.", request.getSession());
			   }
               user.setAttribute("dbRoles", roleSet);
            }
            catch (Exception ex)
            {
			   throw new UserLoginException(this.getClass().getName(), "setUserAttributes", "Error verifying the user permissions and roles required for this application." + ex.getMessage(), request.getSession());
            }
        }

        return true;
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

}
