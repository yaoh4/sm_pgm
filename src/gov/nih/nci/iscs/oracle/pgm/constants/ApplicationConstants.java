package gov.nih.nci.iscs.oracle.pgm.constants;

import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import org.apache.struts.util.LabelValueBean;


public class ApplicationConstants {
	public static final int ALL_PAGES = 999;
	public static final String APPLICATION_KEY = "pgm";
	public static final String USER_LOGIN_FAILURE = "failure";
    public static final String PGM_CONTEXT_FACTORY = "pgmContextFactory";
    public static final String ALL_VALUES = "ALL_VALUES";
	public static final String MY_PORTFOLIO = "PD_NPE_ID";
	public static final String USER_QUERY_LIST = "queryList";
    public static final String MY_CANCER_ACTIVITY = "CAY_CODE";
    public static final String USER_FILTER_INFO = "userFilterInfo";
    public static final String ALL_GRANTS = "All Grants";
    public static final String MY_PORTFOLIOS = "My Portfolio";
    public static final String MY_CANCER_ACTIVITIES = "My Cancer Activity";
    public static final String MY_PORTFOLIOS_VALUE = "PD";
    public static final String MY_CANCER_ACTIVITIES_VALUE = "CA";
	public static final String EMPTY_STRING = "";
	public static final String DEFAULT_DATE_STRING = "01/01/1900";
	public static final Integer DEFAULT_NUMBER = new Integer (0);
	public static final String CANCER_ACTIVITIES_T_LOOKUP = "CancerActivitiesT";
    public static final String LOOKUP_TABLES_HASH = "LookupTables";
    public static final String REFERRAL = "Referral";
    public static final String PD_ASSIGNMENT = "PdAssignment";
    public static final String QUERY_RESULTS = "queryResults";
    public static final String REFERRAL_ACTION_LIST = "referralActionList";
    public static final String PD_ASSIGNMENT_LIST = "pdAssignmentList";
    public static final String PAGINATION_OBJECT = "PaginationObject";
	public static final String CONTINUE_ACTION = "continue";
	public static final String EXT_SEARCH_ACTION = "extSearch";
    public static final String SEARCH_ACTION = "search";
    public static final String REFRESH_ACTION = "refresh";
    public static final String RESET_ACTION = "reset";
    public static final String APPL_CA_HIST_ACTION = "applCAHist";
    public static final String NEXT_ACTION = "next";
    public static final String PREVIOUS_ACTION = "prev";
    public static final String GOTO_PAGE_ACTION = "gotoPage";
    public static final String FILTER_CA_ACTION = "filterCA";
    public static final String SORT_LIST_ACTION = "sortList";
    public static final String GENERATE_REPORT = "generateReport";
	public static final int    DEFAULT_PAGE_SIZE = 100;
	public static final int    FIRST_PAGE = 1;
	public static final String CURRENT_PAGE_SIZE = "currentPageSize";
	public static final String CANCER_ACTIVITY_SORT = "cayCode";
	public static final String CA_SORT = "cancerActivity";
	public static final String DUAL_CANCER_ACTIVITY_SORT = "dualCA";
	public static final String DUAL_POC_SORT = "dualPoc";
	public static final String PI_LAST_NAME_SORT = "lastName";
       //bug fix for PROGRAMMANAGEMENT-190
        public static final String PI_LAST_NAME_PDA__SORT = "lastNamePDA";
	public static final String RFA_PA_NUMBER_SORT = "rfaPaNumber";
	public static final String INST_NAME_SORT = "instName";
	public static final String ORGANIZATION_SORT = "orgName";
	public static final String PD_LAST_NAME_SORT = "pdLastName";
	public static final String PD_FULL_NAME_SORT = "pdFullName";
	public static final String PROJECT_TITLE_SORT = "projectTitle";
	public static final String FULL_GRANT_NUMBER_SORT = "default";
	public static final String CURRENT_POC_SORT = "currentPoc";
	public static final String GRANT_NUMBER_SORT = "fullGrantNum";
	public static final String PHS_ORG_CODE_SORT = "adminPhsOrgCode";
	public static final String ACTIVITY_CODE_SORT = "activityCode";
	public static final String SERIAL_NUM_SORT = "serialNum";
	public static final String SUPPORT_YEAR_SORT = "supportYear";
	public static final String SUFFIX_CODE_SORT = "suffixCode";
	public static final String PD_ORGANIZATION_SORT = "pdOrgName";
	public static final String FISCAL_YEAR_SORT = "fy";
	public static final String NCAB_SORT = "councilMeetingDate";
	public static final String PD_START_DATE_SORT = "pdStartDate";
	public static final String ARA_SORT = "araStatusCode";
	public static final String DUAL_CA_SORT = "dualCayCode";
	public static final String CURR_REFERRAL_DATE_SORT = "currentReferralActivityDate";
	public static final String SORT_ASC = "asc";
	public static final String SORT_DESC = "desc";
	public static final String DEFAULT_SORT = "default";
	public static final String LAST_SORT_COLUMN = "lastSortColumn";
	public static final String LAST_SORT_ORDER = "lastSortOrder";
	public static final String OLD_SEARCH_FORM = "oldSearchForm";
	public static final String ACCEPT_REFERRAL = "accept";
	public static final String REJECT_REFERRAL = "reject";
	public static final String REREFER_REFERRAL = "rerefer";
	public static final String RELEASE_DUAL_REFERRAL = "releaseDual";
	public static final String EXECUTE_ACCEPT = "executeAccept";
	public static final String EXECUTE_REJECT = "executeReject";
	public static final String EXECUTE_REREFER = "executeRerefer";
	public static final String EXECUTE_RELEASE = "executeRelease";
	public static final String UPDATE_SELECTED = "updateSelected";
	public static final String REFERRAL_ACTION_HASH = "referralActionHash";
	public static final String ASSIGNMENT_ACTION_HASH = "assignentActionHash";
	public static final String ACTION_RETURN = "return";
	public static final String ACTION_CANCEL = "cancel";
	public static final String ACTION_COLLAPSE_CRITERIA = "collapse";
	public static final String ACTION_EXPAND_CRITERIA = "expand";
	public static final String APPLY_TO_SELECTED = "applyToSelected";
	public static final String SELECTED_GRANTS = "selectedGrants";
	public static final String CLEAR_ALL = "clearAll";
	public static final String SELECT_ALL = "selectAll";
	public static final String CLEAR_ALL_ON_PAGE = "clearAllOnPage";
	public static final String SELECT_ALL_ON_PAGE = "selectAllOnPage";
	public static final String CHANGE_PAGE_SIZE = "changePageSize";
	public static final String REPORTS_LIST = "applicationReports";
	public static final String REFERRAL_ACTION_MAPPING = "retrieveGrantsForReferralForm";
	public static final int    MAX_GRANT_NUM_INDEX = 4;
    public static final String ASSIGN_PD = "assignPD";
    public static final String ASSIGN_PORTFOLIO = "assignPortfolio";
    public static final String EXECUTE_ASSIGN ="executeAssignment";
    public static final String EXECUTE_PORTFOLIO_ASSIGNMENT ="executePortfolioAssignment";
    //public static final String APPLY_TO_SELECTED ="applyToSelected";
    public static final String FORMAT_SELECT ="formatSelect";
    public static final String FORMAT_TABLE ="formatTable";
    public static final String LOAD_ASSIGNMENTS ="loadAssignments";
    public static final String EXCEPTION_TYPE ="exceptionType";
    public static final String LOGIN_EXCEPTION ="loginException";
    public static final String SEARCH_EXCEPTION ="searchException";
    public static final String REFERRAL_ACTION_EXCEPTION ="referralActionException";

    public static final String ERROR_MESSAGE ="errorMessage";
    public static final String ERROR_EXCEPTION ="errorException";
    public static final String ACTIVEX_VIEWER = "&init=actx:connect";
    public static final String JAVA_VIEWER =  "&init=java:connect";
    public static final String PDF_EXPORT_FORMAT = "&cmd=EXPORT&EXPORT_FMT=U2FPDF:0";
    public static final String EXCEL_EXPORT_FORMAT = "&cmd=EXPORT&EXPORT_FMT=U2FXLS:3";
    public static final String PAGE_SIZES = "pageSizes";
    public static final String REFERRAL_REPORT = "referralReport";
    public static final String PD_ASSIGNMENT_REPORT = "pdAssignmentReport";
    public static final String APP_LINK_LIST = "appLinkList";

    public static final Date  DEFAULT_DATE() {

		try {
			return DateFormat.getDateInstance().parse(DEFAULT_DATE_STRING);

	    } catch (ParseException ex) {
		    return null;
	    }
	}

    public static final List  PAGE_SIZE_LIST() {

		try {
			ArrayList mList = new ArrayList(4);
	        LabelValueBean mLabelValueBean = new LabelValueBean(new String("10"), new String("10"));
			mList.add(mLabelValueBean);
	        LabelValueBean mLabelValueBean1 = new LabelValueBean(new String("25"), new String("25"));
			mList.add(mLabelValueBean1);
	        LabelValueBean mLabelValueBean2 = new LabelValueBean(new String("50"), new String("50"));
			mList.add(mLabelValueBean2);
	        LabelValueBean mLabelValueBean3 = new LabelValueBean(new String("100"), new String("100"));
			mList.add(mLabelValueBean3);

			return mList;

	    } catch (Exception ex) {
		    return new ArrayList();
	    }
	}

   // workbench portlet constant definitions
   public static final String PREV_REFERRAL_ACTIVITY="prevreferralactivity";
   public static final String CURRENT_REFERRAL_ACTIVITY="currentreferralactivity";
   public static final String NEXT_REFERRAL_ACTIVITY ="nextreferralactivity";
   public static final String PREV_COUNCIL="prevcouncil";
   public static final String CURRENT_COUNCIL="currentcouncil";
   public static final String NEXT_COUNCIL ="nextcouncil";
   public static final String REFERRAL_ACTIVITY_URL = "referralactivityurl";

}
