package gov.nih.nci.iscs.oracle.pgm.actions;



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


import org.apache.struts.action.ActionMessages;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CrystalReportAction extends NciPgmAction    {

 private HttpSession oSession;
 private ServletContext oServletContext;
 private ApplicationContext oApplicationContext;
 private RetrieveGrantsForm mRetrieveGrantsForm = null;
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
    String reportType = null;
      mRetrieveGrantsForm = (RetrieveGrantsForm) request.getAttribute("retrieveGrantsForReferralForm");
      reportType = ApplicationConstants.REFERRAL_REPORT;
      if(mRetrieveGrantsForm == null) {
         mRetrieveGrantsForm = (RetrieveGrantsForm) request.getAttribute("retrieveGrantsForPDAForm");
         mContinueForward = "continueForPDA";
         reportType = ApplicationConstants.PD_ASSIGNMENT_REPORT;
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
      List mSortedList =  mSelectedGrants.getSortedSelectedGrants();

      if(!messages.isEmpty() ) {
		   return mapping.findForward(mContinueForward);
	  }


      ReportSelectorServiceImpl mReportSelectorServiceImpl =  new ReportSelectorServiceImpl(oApplicationContext);
      ReportsVw mReportsVw = mReportSelectorServiceImpl.getReportDetails(new Long(mReportSelected), new Long(mReportFormat));
      mReportSelectorServiceImpl.deleteDataForReport(oSession.getId(), reportType, mReportsVw.getCrystalId());
      mReportSelectorServiceImpl.insertDataForReport(mSortedList, reportType, oSession.getId(), mReportsVw.getCrystalId());
      oSession.setAttribute("reportDetails", mReportsVw);
      oSession.setAttribute("reportAction",  "run");




      return mapping.findForward(mContinueForward);

   }


}
