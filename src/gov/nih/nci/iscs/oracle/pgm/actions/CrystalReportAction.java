package gov.nih.nci.iscs.oracle.pgm.actions;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;


import  gov.nih.nci.iscs.oracle.pgm.actions.NciPgmAction;
import  gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForm;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.SelectedGrants;
import gov.nih.nci.iscs.oracle.pgm.service.impl.ReportSelectorServiceImpl;
import javax.servlet.http.HttpSession;
import gov.nih.nci.iscs.oracle.pgm.actions.helper.SearchGrantsActionHelper;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;
import gov.nih.nci.iscs.oracle.pgm.hibernate.ReportsVw;



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
import javax.servlet.http.HttpSession;


public class CrystalReportAction extends NciPgmAction    {

 private HttpSession oSession;
 private ServletContext oServletContext;
 private NciUser oNciUser;
 private ApplicationContext oApplicationContext;
 private String mAction = null;
 private RetrieveGrantsForm mRetrieveGrantsForm = null;
 private static Logger logger = LogManager.getLogger(SearchGrantsAction.class);
 private String mContinueForward = "continueForReferral";

 public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

       if(!SearchGrantsActionHelper.validateSession(request.getSession() )) {
		   throw new GrantSearchException("CrystalReportAction", "execute", "Your session has expired. You have open a new browser window to continue!", request.getSession());
	   }
      oSession = request.getSession();
	  oServletContext = oSession.getServletContext();
      oApplicationContext =  (ApplicationContext) oServletContext.getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
      ActionMessages messages = new ActionMessages();

      mRetrieveGrantsForm = (RetrieveGrantsForm) request.getAttribute("retrieveGrantsForReferralForm");
      if(mRetrieveGrantsForm == null) {
         mRetrieveGrantsForm = (RetrieveGrantsForm) request.getAttribute("retrieveGrantsForPDAForm");
         mContinueForward = "continueForPDA";
	  }

      String mReportFormat = mRetrieveGrantsForm.getFormatSelected();
      String mReportSelected = mRetrieveGrantsForm.getReportSelected();

      if(mReportSelected.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ||
         mReportSelected == null){
	       logErrors(messages, "referralaction", "errors.crystal.report.select");
	   	   this.saveMessages(request, messages);
	  }
      if(mReportFormat.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ||
         mReportSelected == null){
	       logErrors(messages, "referralaction", "errors.crystal.format.select");
	   	   this.saveMessages(request, messages);
	  }

      SelectedGrants mSelectedGrants= (SelectedGrants) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS);
      if(mSelectedGrants.isEmpty()){
	     super.logErrors(messages, "referralaction", "errors.generate.action.select");
	   	 this.saveMessages(request, messages);
		 return mapping.findForward(mContinueForward);
	  }
      List mSortedList = (List) mSelectedGrants.getSortedSelectedGrants();

      if(!messages.isEmpty() ) {
		   return mapping.findForward(mContinueForward);
	  }


      ReportSelectorServiceImpl mReportSelectorServiceImpl =  new ReportSelectorServiceImpl(oApplicationContext);
      ReportsVw mReportsVw = mReportSelectorServiceImpl.getReportDetails(new Long(mReportSelected), new Long(mReportFormat));
      mReportSelectorServiceImpl.deleteDataForReport(oSession.getId(), mReportsVw.getCrystalId());
      mReportSelectorServiceImpl.insertDataForReport(mSortedList, oSession.getId(), mReportsVw.getCrystalId());
      oSession.setAttribute("reportDetails", mReportsVw);
      oSession.setAttribute("reportAction",  "run");




      return mapping.findForward(mContinueForward);

   }


}
