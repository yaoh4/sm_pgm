package gov.nih.nci.iscs.oracle.pgm.tag;


//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForm;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
//Application imports

public class FormatSortCriteria extends TagSupport {


  private String formName;
  private RetrieveGrantsForm mForm;

  public static String CANCER_ACTIVITY = "Cancer Activity, ";
  public static String ORGANIZATION = "Institution, ";
  public static String PD_LAST_NAME = "PD, ";
  public static String FULL_GRANT_NUMBER = "IC Code, Activity Code, Serial Number, Support Year, Suffix";
  public static String PROJECT_TITLE = "Project Title, ";
  public static String PD_ORGANIZATION = "Program Director Organization, ";
  public static String FISCAL_YEAR = "Fiscal Year, ";
  public static String NCAB = "NCAB, ";
  public static String PD_START_DATE = "PD Start Date, ";
  public static String ARA_MATCH = "ARA Status Code, ";
  public static String DUAL_CA = "Dual Cancer Activity Code, ";
  public static String CURR_REFERRAL_DATE_SORT = "Referred Date, ";
  public static String PI_LAST_NAME_SORT = "PI, ";
  public static String FISCAL_YEAR_SORT = "FY, ";
  public static String RFA_PA_NUMBER_SORT = "RFA/PA, ";

  public String getFormName() {
	  return this.formName;
  }

  public void setFormName(String formName) {
	  this.formName = formName;
  }

  public int doStartTag() {
    try {

      HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
      JspWriter out = pageContext.getOut();
	  StringBuffer buf = new StringBuffer();
      mForm = (RetrieveGrantsForm) request.getAttribute("retrieveGrantsForReferralForm");
      if(mForm == null) {
         mForm = (RetrieveGrantsForm) request.getAttribute("retrieveGrantsForPDAForm");
      }

      String mSortColumn = mForm.getSortColumn();
      String mSortOrder = mForm.getSortOrder();
      String mResults = null;

      if (mSortColumn.equalsIgnoreCase(ApplicationConstants.CANCER_ACTIVITY_SORT)) {
		  mResults = CANCER_ACTIVITY + FULL_GRANT_NUMBER;
	  }

      if (mSortColumn.equalsIgnoreCase(ApplicationConstants.ORGANIZATION_SORT)) {
		  mResults = ORGANIZATION + FULL_GRANT_NUMBER;
	  }
      if (mSortColumn.equalsIgnoreCase(ApplicationConstants.PD_LAST_NAME_SORT) ||
          mSortColumn.equalsIgnoreCase(ApplicationConstants.PD_FULL_NAME_SORT) ) {
		  mResults = PD_LAST_NAME + FULL_GRANT_NUMBER;
	  }
      if (mSortColumn.equalsIgnoreCase(ApplicationConstants.FULL_GRANT_NUMBER_SORT)) {
		  mResults = FULL_GRANT_NUMBER;
	  }
      if (mSortColumn.equalsIgnoreCase(ApplicationConstants.PROJECT_TITLE_SORT)) {
		  mResults = PROJECT_TITLE + FULL_GRANT_NUMBER;
	  }
      if (mSortColumn.equalsIgnoreCase(ApplicationConstants.PD_ORGANIZATION_SORT)) {
		  mResults = PD_ORGANIZATION + FULL_GRANT_NUMBER;
	  }

      if (mSortColumn.equalsIgnoreCase(ApplicationConstants.FISCAL_YEAR_SORT)) {
		  mResults = FISCAL_YEAR + FULL_GRANT_NUMBER;
	  }
      if (mSortColumn.equalsIgnoreCase(ApplicationConstants.NCAB_SORT)) {
		  mResults = NCAB + FULL_GRANT_NUMBER;
	  }
      if (mSortColumn.equalsIgnoreCase(ApplicationConstants.PD_START_DATE_SORT)) {
		  mResults = PD_START_DATE + FULL_GRANT_NUMBER;
	  }
      if (mSortColumn.equalsIgnoreCase(ApplicationConstants.ARA_SORT)) {
		  mResults = ARA_MATCH + FULL_GRANT_NUMBER;
	  }
      if (mSortColumn.equalsIgnoreCase(ApplicationConstants.DUAL_CA_SORT)) {
		  mResults = DUAL_CA + FULL_GRANT_NUMBER;
	  }
      if (mSortColumn.equalsIgnoreCase(ApplicationConstants.CURR_REFERRAL_DATE_SORT)) {
		  mResults = CURR_REFERRAL_DATE_SORT + FULL_GRANT_NUMBER;
	  }
      if (mSortColumn.equalsIgnoreCase(ApplicationConstants.PI_LAST_NAME_SORT)) {
		  mResults = PI_LAST_NAME_SORT + FULL_GRANT_NUMBER;
	  }
      if (mSortColumn.equalsIgnoreCase(ApplicationConstants.FISCAL_YEAR_SORT)) {
		  mResults = FISCAL_YEAR_SORT + FULL_GRANT_NUMBER;
	  }
      if (mSortColumn.equalsIgnoreCase(ApplicationConstants.RFA_PA_NUMBER_SORT)) {
		  mResults = RFA_PA_NUMBER_SORT + FULL_GRANT_NUMBER;
	  }
	  // did we match?
	  if(mResults == null) {
  	     mResults = FULL_GRANT_NUMBER;
	  }

      buf.append(mResults);
      out.print( buf.toString());
     } catch(Exception e) {
      e.printStackTrace();
     }
   return SKIP_BODY;
  }


}