package gov.nih.nci.iscs.oracle.pgm.actions;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUserImpl;

import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import gov.nih.nci.iscs.oracle.pgm.service.impl.UserServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;


import  gov.nih.nci.iscs.oracle.pgm.actions.NciPgmAction;
import  gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForReferralForm;
import  gov.nih.nci.iscs.oracle.pgm.forms.ExternalReferralForm;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.impl.WbReferralActivitiesImpl;
import gov.nih.nci.iscs.oracle.pgm.actions.helper.SearchGrantsActionHelper;
import javax.servlet.http.HttpSession;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;



import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.commons.beanutils.PropertyUtils;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExternalReferralAction extends NciPgmAction{

  private String mAction = null;
  private ExternalReferralForm mExternalReferralForm = null;
  ApplicationContext oApplicationContext;
  private static Logger logger = LogManager.getLogger(SearchGrantsAction.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

      String mappingString = "";
      try{
	    mExternalReferralForm = (ExternalReferralForm) form;
	    mAction = mExternalReferralForm.getRequestAction();
        oApplicationContext =  (ApplicationContext)  request.getSession().getServletContext().getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
        if( mAction.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING ) ) {
           String oracleId = (String)request.getParameter("oracleID");
           Map referralActivities = getWbReferralActivities(oracleId);
           List boards = getBoards();
            request.setAttribute(ApplicationConstants.CURRENT_COUNCIL, boards.get(1));
            request.setAttribute(ApplicationConstants.CURRENT_REFERRAL_ACTIVITY, referralActivities.get( boards.get(1)));
            request.setAttribute(ApplicationConstants.NEXT_COUNCIL, boards.get(2));
            request.setAttribute(ApplicationConstants.NEXT_REFERRAL_ACTIVITY, referralActivities.get(boards.get(2)));
            request.setAttribute(ApplicationConstants.PREV_COUNCIL, boards.get(0));
            request.setAttribute(ApplicationConstants.PREV_REFERRAL_ACTIVITY, referralActivities.get(boards.get(0)));
           String referralActivityUrl = getReferralActivityUrl();
           request.setAttribute(ApplicationConstants.REFERRAL_ACTIVITY_URL, referralActivityUrl);
           mappingString = ApplicationConstants.CONTINUE_ACTION;
        }
        if( mAction.equalsIgnoreCase(ApplicationConstants.EXT_SEARCH_ACTION )){
         mappingString = ApplicationConstants.EXT_SEARCH_ACTION;
         }
	  } catch (Exception ex) {
		  throw new GrantSearchException("ExternalReferralAction", "executeAction", ex.toString(), request.getSession(), ex);
	  }
       return mapping.findForward(mappingString);
   }


 private Map getWbReferralActivities(String oracleId) throws GrantSearchException, Exception {

   Map mWbReferralActivities;
   try {
      UserServiceImpl userServiceImpl = new UserServiceImpl(oApplicationContext, oracleId.toUpperCase());
      UserFilterInfo userFilterInfo = userServiceImpl.getUserFilerInfo(oracleId.toUpperCase());
	    WbReferralActivitiesImpl mWbReferralActivitiesImpl =  new WbReferralActivitiesImpl(oApplicationContext);
	    mWbReferralActivities = mWbReferralActivitiesImpl.getReferralActivitiesMap( userFilterInfo);
   } catch(Exception e) {
	    throw new GrantSearchException("ExternalReferralAction", "getWbReferralActivities", e.toString());
   }

   return mWbReferralActivities;
 }

 private List getBoards() throws GrantSearchException, Exception
 {
   List boards;
   try
   {
      WbReferralActivitiesImpl mWbReferralActivitiesImpl = new WbReferralActivitiesImpl(oApplicationContext);
      boards = mWbReferralActivitiesImpl.getBoards();
   }
   catch (Exception e)
   {
      throw new GrantSearchException("ExternalReferralAction", "getWbReferralActivities", e.toString());
   }
   return boards;
 }

 private String getReferralActivityUrl() throws GrantSearchException, Exception
 {
    String url = "";
     try {
  	    WbReferralActivitiesImpl mWbReferralActivitiesImpl =  new WbReferralActivitiesImpl(oApplicationContext);
  	    url = mWbReferralActivitiesImpl.getApplicationUrl("Referral Activity JAVA");
   } catch(Exception e) {
	    throw new GrantSearchException("ExternalReferralAction", "getWbReferralActivities", e.toString());
   }
   return url;
 }

 public boolean verifyUser(HttpServletRequest request, HttpServletResponse response)
        throws UserLoginException, Exception
    {
		System.out.println("*** now in verifyUser of ExternalReferralAction ***");
        boolean returnValue = false;
        HttpSession session = request.getSession(true);
		System.out.println("*** session is  *** " + session);

        NciUser nu = (NciUser)session.getAttribute("nciuser");
		System.out.println("*** nu is  *** " + nu);
        if(nu != null && nu.isValid())
        {
		    System.out.println("*** nu is not null *** " );
            returnValue = verifyUserForApp(request, response);
        } else
        {
		    System.out.println("*** nu is  null *** " );
            String remoteUser = (String)request.getParameter("ldapID");
            if(remoteUser== null) {
				System.out.println("*** ldapID is null **** ");
				remoteUser = request.getRemoteUser();
			}
		    System.out.println("*** remoteUser is  *** " + remoteUser);
            if(remoteUser != null && !remoteUser.equals(""))
            {
		        System.out.println("*** remoteUser is not null *** " );
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
		            System.out.println("*** nciuser is  *** " + nui);
					session.setAttribute("nciuser", nui);
                    returnValue = verifyUserForApp(request, response);
				} else {
				   logger.error("User Priviledges denied - 1!!! ");
		           System.out.println("*** remoteUser is  null *** " );
					return false;
				}
            }
        }
        return returnValue;
    }

}
