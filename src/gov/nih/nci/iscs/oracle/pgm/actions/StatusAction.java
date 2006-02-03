package gov.nih.nci.iscs.oracle.pgm.actions;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;


import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import  gov.nih.nci.iscs.oracle.pgm.forms.StatusForm;


import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.oracle.common.helper.ApplicationInfo;
import gov.nih.nci.iscs.oracle.util.CommonUtil;
import gov.nih.nci.iscs.oracle.util.EmailManagerOra;
import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import gov.nih.nci.iscs.oracle.common.ldap.LDAPUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Calendar;
import javax.naming.directory.Attributes;
public class StatusAction extends Action {

    private Logger logger = LogManager.getLogger(gov.nih.nci.iscs.oracle.pgm.actions.StatusAction.class);
    private String[] stAttrDirIDs = {
        "nciOracleID", "fullName", "givenName", "sn", "mail", "telephoneNumber",
        "cn"
    };
    StatusForm mStatusForm =  new StatusForm();
  String mAction = null;

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {


       mStatusForm = (StatusForm) form;
       mAction = mStatusForm.getRequestAction();
        try {
		  System.out.println("**** about to prcess getLdapUser *** " );
          String ldapUserId = getLdapUser(request, response);
		  System.out.println("**** complted process getLdapUser *** " + ldapUserId);
          String oracleUserId = checkLdapStatus(request, response, ldapUserId);
		  System.out.println("**** complted process checkLdapStatus *** " + oracleUserId);
          checkPGMStatus(request, response, oracleUserId);
		  System.out.println("**** complted process checkPGMStatus *** ");
        }
        catch(Exception e)
        {
           logError(e, response);
           response.sendError(response.SC_INTERNAL_SERVER_ERROR);
        }
       return mapping.findForward("continue");

   }

  /**
   *  This method gets the generic ldap user, checks access to the properties file.
   */
  private String getLdapUser( HttpServletRequest request, HttpServletResponse response) throws Exception
  {
     try {
          ApplicationInfo ai = (ApplicationInfo) this.getAppAttribute(request, "applicationInfo");
          String ldapUser = ai.getApplicationKey("status.ldap.user");
          return ldapUser;
     }
     catch (Exception e)
     {
        logError((Throwable)new Exception("Error reading properties file."),response);
        throw e;
     }
  }

  /**
   *  Tries to verify the generic ldap user against the ldap server, and then gets the
   *  nciOracleId attribute for that user.
   */
  private String checkLdapStatus(
        HttpServletRequest request, HttpServletResponse response, String userId) throws Exception
  {
        try {
           LDAPUtil ctx = (LDAPUtil) this.getAppAttribute(request, ApplicationConstants.LDAP_SEARCHER);
           String stFDN = null;
           stFDN = ctx.getUserFDN(userId);
           Attributes attribs = ctx.getAttributes(stFDN, stAttrDirIDs);
           String nciOracleId = null;
           if (attribs.get("nciOracleId").get() != null) {
              nciOracleId = (String)attribs.get("nciOracleId").get();
           } else {
              throw new Exception("nciOracleId attributed could not be found for user: ncildap");
           }
           return nciOracleId;
        }
        catch (Exception e)
        {
            logError((Throwable)new Exception("Error verifying the user from LDAP."), response);
            throw e;
        }

  }

    /**
     * This method uses the app connection pool to query the main application view.
     */
    private void checkPGMStatus(HttpServletRequest request,
        HttpServletResponse response, String user) throws Exception  {

        try {

           response.setStatus(response.SC_OK);
        } catch (Exception e) {
            logError((Throwable)new Exception("Error verifying the database connection and query."), response);
            throw e;
        }
    }

   private Object getAppAttribute(HttpServletRequest request, String attrbKey)
        throws Exception {
        HttpSession session = request.getSession();
        ServletContext sc = session.getServletContext();
        return (sc.getAttribute(attrbKey));
  }

  private void logError(Throwable t, HttpServletResponse response)
  {
     logger.error("******* Program Management Status Error ******");
     logger.error(t.getMessage());
     logger.error(t);
     try { //Try writing the error message to the response
       PrintWriter writer = response.getWriter();
       writer.print("\nMessage :"+t.getMessage()+"\n");
       writer.print("***************************************************\n");
       t.printStackTrace(writer);
       response.flushBuffer();
     }
     catch(IOException ie)
     {
        //ignore the exception
     }
  }

}