package gov.nih.nci.iscs.oracle.pgm.actions;


import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import  gov.nih.nci.iscs.oracle.pgm.forms.GrantSearchErrorForm;


import gov.nih.nci.iscs.oracle.common.helper.ApplicationInfo;
import gov.nih.nci.iscs.oracle.util.CommonUtil;
import gov.nih.nci.iscs.oracle.util.EmailManagerOra;
import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.*;
import org.apache.struts.action.*;

public class GrantSearchErrorAction extends Action {

  GrantSearchErrorForm mGrantSearchErrorForm  = null;
  String mAction = null;
  String mReturnAction = null;

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {


       mGrantSearchErrorForm = (GrantSearchErrorForm) form;
       mReturnAction = mGrantSearchErrorForm.getReturnAction();
       mAction = mGrantSearchErrorForm.getRequestAction();
       if( mAction.equalsIgnoreCase("email")){
		   mGrantSearchErrorForm.setRequestAction("email");
           return sendEmail(mapping, form, request, response);
	   }
       if( mAction.equalsIgnoreCase("return")){
           return mapReturnAction(mapping, form, request, response);
	   }
       return mapping.findForward("continue");

   }

   public ActionForward sendEmail (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {

          HttpSession session = request.getSession();
          String errorMessage = (String)session.getAttribute(ApplicationConstants.ERROR_MESSAGE);

          Exception errorException = (Exception)session.getAttribute(ApplicationConstants.ERROR_EXCEPTION);
          NciUser nu = (NciUser)session.getAttribute("nciuser");
          String userName = null;
          String userEmail = null;
          if(nu != null){
              userName = nu.getFullName();
              userEmail = (String)nu.getAttribute("mail");
          }
          //userEmail = "michelle.engermann@oracle.com";
          String browserType = request.getHeader("User-Agent");
          String host = request.getHeader("HOST");
          ApplicationInfo appInfo = (ApplicationInfo)session.getServletContext().getAttribute("applicationInfo");
          EmailManagerOra mailHandler = new EmailManagerOra();
          mailHandler.setHost(appInfo.getApplicationKey("SMTP_SERVER"));
          if(userEmail == null) {
              mailHandler.setFrom(appInfo.getApplicationKey("EMAIL_FROM"));
          }else{
              mailHandler.setFrom(userEmail);
		  }
          mailHandler.setTo(appInfo.getApplicationKey("ERROR_EMAIL"));
          //mailHandler.setTo("michelle.engermann@oracle.com");

          String mSubject = ApplicationConstants.EMPTY_STRING;
          mReturnAction = (String) request.getSession().getAttribute("returnAction");

          if(mReturnAction.equalsIgnoreCase("SearchGrantsForPDA")){
			 mSubject =  appInfo.getApplicationKey("PD_TRANSFER_SUBJECT_LINE_TEXT");
		  }else{
			  if(mReturnAction.equalsIgnoreCase("SearchGrantsForReferral")){
				  mSubject =  appInfo.getApplicationKey("REFERRAL_SUBJECT_LINE_TEXT");
			  }
		  }
          mailHandler.setSubject(mSubject + " Error Message - " + CommonUtil.getDateString(new Date(), "dd-MMM-yyyy hh:mm aaa"));
          StringBuffer error_mesg = new StringBuffer();
          error_mesg.append("\n\nError Message: ");
          error_mesg.append(errorMessage.replaceAll("<BR>", "\n"));
          if(errorException != null){
              error_mesg.append("\n\nLocalised Message: ");
              error_mesg.append(errorException.getLocalizedMessage());
              error_mesg.append("\n\nStack Trace: ");
              CharArrayWriter caw = new CharArrayWriter(1000);
              PrintWriter pw = new PrintWriter(caw);
              errorException.printStackTrace(pw);
              error_mesg.append(caw.toCharArray());
              error_mesg.append("\n\n");
          }
          error_mesg.append("\nUser: ");
          error_mesg.append(userName);
          error_mesg.append("\n\nApplication Values: ");
          error_mesg.append(mGrantSearchErrorForm.getUserMessage());
          error_mesg.append("\n\nBrowser: ");
          error_mesg.append(browserType);
          error_mesg.append("\n\nHost: ");
          error_mesg.append(host);
          mailHandler.setBody(error_mesg.toString());
          mailHandler.sendMessage();
          return mapping.findForward("success");
    }

  public ActionForward mapReturnAction (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {


         ActionForward mForward = null;

         if(mReturnAction.equalsIgnoreCase("SearchGrantsForPDA")){
			 mForward =  mapping.findForward("assign");
		 }
         if(mReturnAction.equalsIgnoreCase("SearchGrantsForReferral")){
			 mForward = mapping.findForward("referralAction");
		 }
		 request.getSession().setAttribute("returnAction", mReturnAction);

         return mForward;

  }


}