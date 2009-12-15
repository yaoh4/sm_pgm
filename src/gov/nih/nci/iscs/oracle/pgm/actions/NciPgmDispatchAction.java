package gov.nih.nci.iscs.oracle.pgm.actions;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.impl.UserServiceImpl;
import gov.nih.nci.iscs.oracle.common.ldap.LDAPUtil;


import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;


import javax.naming.directory.Attributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public abstract class NciPgmDispatchAction extends NciBaseDispatchAction {
    private Logger logger = LogManager.getLogger(NciPgmAction.class);
    private String[] stAttrDirIDs = {
        "nciOracleID", "fullName", "givenName", "sn", "mail", "telephoneNumber",
        "cn"
    };


  /**
   * Sets the user attributes from Ldap, this method is called from the super class
   * after it gets the remote user.
   * @param user
   * @param request
   * @throws java.lang.Exception
   */
    public void setUserAttributes(NciUser user, HttpServletRequest request)
        throws Exception {
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
            } catch (Exception e) {
                logger.error(e);
            }

            try {
                if (attribs.get("nciOracleId").get() != null) {
                    user.setAttribute("nciOracleId",
                        attribs.get("nciOracleId").get());
                } else {
                    user.setAttribute(("nciOracleId"), null);
                }
            } catch (Exception e) {
                logger.error(e);
            }

            try {
                if (attribs.get("givenName").get() != null) {
                    user.setAttribute("givenName",
                        attribs.get("givenName").get());
                } else {
                    user.setAttribute("givenName", null);
                }
            } catch (Exception e) {
                logger.error(e);
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
            } catch(Exception e) {
                logger.error(e);
            }

            try {
                if (attribs.get("fullName").get() != null) {
                    user.setAttribute("fullName", attribs.get("fullName").get());
                } else {
                    user.setAttribute("fullName", null);
                }
            } catch (Exception e) {
                String givenName = (String)user.getAttribute("givenName");
                String lastName = (String)user.getAttribute("lastName");
                if (givenName ==  null) givenName = "";
                if (lastName == null) lastName = "";
                user.setAttribute("fullName",givenName+" "+lastName);
                logger.error(e);
            }
            try
            {
               Set roleSet = getUserDbRoles(request, (String)user.getAttribute("nciOracleId"));
               user.setAttribute("dbRoles", roleSet);
            }
            catch (Exception e)
            {
               logger.error(e);
            }
        }
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
        if ((roleSet == null)||(!(roleSet.contains("CMBB_USER"))))
        {
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
        errors.add(ActionErrors.GLOBAL_ERROR, error);
        this.saveErrors(request, errors);
    }

}
