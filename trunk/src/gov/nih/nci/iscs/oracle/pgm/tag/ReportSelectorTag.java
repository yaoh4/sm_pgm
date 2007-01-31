package gov.nih.nci.iscs.oracle.pgm.tag;
//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.hibernate.ReportsVw;
import gov.nih.nci.iscs.oracle.pgm.service.impl.ReportSelectorServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForm;

import java.util.*;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class ReportSelectorTag extends TagSupport
{
  private String   applicationName;
  private String   moduleName;
  private String   action;
  private String   controlName;
  private String   mDefaultkey;
  private RetrieveGrantsForm mForm;
  private ReportsVw mReportsVw;
  private List mReportsList;
  private String param;
  public static String TOP_LITERAL = "top";
  public static String BOTTOM_LITERAL = "bottom";
  public static String REPORT_SELECTED = "reportSelected";
  public static String FORMAT_SELECTED = "formatSelected";
  public static String REFERRAL_ACTION = "Referral Query";
  public static String PD_ASSIGNMENT = "PD Assignment Query";
  public String formName = "retrieveGrantsForReferralForm";


  public void setApplicationName(String applicationName) {
     this.applicationName = applicationName;
  }
  public void setModuleName(String moduleName) {
     this.moduleName = moduleName;
  }
  public void setAction(String action) {
     this.action = action;
  }
  public void setControlName(String controlName) {
     this.controlName = controlName;
  }

  public int doStartTag() {

    JspWriter out = pageContext.getOut();
	mDefaultkey = new String(" ");
    HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
    HttpSession mSession = request.getSession();
    mForm = (RetrieveGrantsForm) request.getAttribute("retrieveGrantsForReferralForm");
    moduleName = REFERRAL_ACTION;
    if(mForm == null) {
       mForm = (RetrieveGrantsForm) request.getAttribute("retrieveGrantsForPDAForm");
       formName = "retrieveGrantsForPDAForm";
       moduleName = PD_ASSIGNMENT;
    }
    // get the list of reports
    mReportsList = getReportsList();
    if(controlName.equalsIgnoreCase(REPORT_SELECTED) ||
       controlName.equalsIgnoreCase(FORMAT_SELECTED) ){
		 param = TOP_LITERAL;
	 } else {
		 param = BOTTOM_LITERAL;
	 }
	String results = null;
    try {
	   if(action.equalsIgnoreCase("reports")){
		   results = getReports(mForm, mSession);
	   } else {
		   results = getFormats();
	   }
      out.print(results);
    } catch(Exception e) {
      e.printStackTrace();
    }
    return SKIP_BODY;
  }

  private String getReports(RetrieveGrantsForm mForm, HttpSession mSession) {

      StringBuffer buf = new StringBuffer();
      // get the list of reports
      mReportsList = getReportsList();
      String mLastRusId = "";
      String mValue = "";
      HashMap mMap = new HashMap(mReportsList.size());
      StringBuffer mFormats = new StringBuffer();

      Iterator mIterator = mReportsList.iterator();
      while(mIterator.hasNext()){
          mReportsVw = (ReportsVw) mIterator.next();
		  if(mReportsVw.getModuleName().trim().equalsIgnoreCase(moduleName)){
		  	  mMap.put(mReportsVw.getRusId().toString(), mReportsVw.getReportName());
		  	  mLastRusId = mReportsVw.getRusId().toString();
		  	  mValue = mReportsVw.getRfrId().toString() + "*" + mReportsVw.getFormatType();
		  	  mFormats.append(mLastRusId + "=" + mValue + "/");
		  }
	  }
     mSession.setAttribute("formats", mFormats.toString() );

      buf.append("<SELECT NAME=\""+ controlName + "\" SIZE=\"1\" onchange=\"refresh(\'" + param + "\', document." + formName + "." + controlName + ".selectedIndex, document." + formName + "." + controlName + ".options[document." + formName + "." + controlName + ".selectedIndex].value);\")\">");
         buf.append("<OPTION SELECTED value=" + mDefaultkey + ">");
         buf.append("Choose a Report.....");
         buf.append("</OPTION>\n");

      for (Iterator iterator = mMap.entrySet().iterator(); iterator.hasNext();) {
          Map.Entry entry = (Map.Entry) iterator.next();
          String key = (String)entry.getKey();
          String value = (String)entry.getValue();
		  if(key.trim().equalsIgnoreCase(mForm.getReportSelected())){
			  buf.append("<OPTION SELECTED value=");
		  } else {
			  buf.append("<OPTION value=");
		  }
			    buf.append( key);
			    buf.append(">");
			    buf.append(value);
              buf.append("</OPTION>\n");

	  }
	  buf.append("</SELECT>");
      return  buf.toString();

}

private String getFormats() {

      StringBuffer buf = new StringBuffer();
      buf.append("<SELECT NAME=\"" + controlName + "\" SIZE=\"1\" onchange=\"refresh(\'" + param + "\')\">");
      if(mForm.getReportSelected().trim().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)){
         buf.append("<OPTION SELECTED value=" + mDefaultkey + ">");
	  } else {
         buf.append("<OPTION value=" + mDefaultkey + ">");
	  }
      buf.append("Choose a Format.....");
      buf.append("</OPTION>\n");

      Iterator mIterator = mReportsList.iterator();
      while(mIterator.hasNext()){
         mReportsVw = (ReportsVw) mIterator.next();

	     if(mReportsVw.getRusId().toString().equalsIgnoreCase(mForm.getReportSelected())) {
            String key = mReportsVw.getRfrId().toString();
            String value = mReportsVw.getFormatType();
            if(mForm.getFormatSelected().trim().equalsIgnoreCase(key)){
			   buf.append("<OPTION SELECTED value=");
			} else {
			   buf.append("<OPTION value=");
			}
			buf.append( key);
			buf.append(">");
			buf.append(value);
            buf.append("</OPTION>\n");

		 }

	 }
	 buf.append("</SELECT>");
     return  buf.toString();

}
public List getReportsList() {

    ArrayList mReportsList = new ArrayList();
      StringBuffer buf = new StringBuffer();
    try {

        HttpSession session = pageContext.getSession();
        mReportsList = (ArrayList) session.getAttribute(ApplicationConstants.REPORTS_LIST);
        //Check if the reports have been selected
        if (mReportsList == null) {
            ServletContext sc = pageContext.getServletContext();
            Object mApplicationContext =   sc.getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
            ReportSelectorServiceImpl mReportSelectorServiceImpl =  new ReportSelectorServiceImpl(mApplicationContext);
	        mReportsList = (ArrayList) mReportSelectorServiceImpl.getReportsForApplication(applicationName);
	        session.setAttribute(ApplicationConstants.REPORTS_LIST, mReportsList);
        }
    } catch(Exception e) {
        e.printStackTrace();
    }
    return mReportsList;

}


}