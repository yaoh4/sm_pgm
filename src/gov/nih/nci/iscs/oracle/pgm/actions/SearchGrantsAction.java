package gov.nih.nci.iscs.oracle.pgm.actions;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;


import  gov.nih.nci.iscs.oracle.pgm.actions.NciPgmAction;
import  gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForm;
import  gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForPDAForm;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants;
import gov.nih.nci.iscs.oracle.pgm.service.impl.UserServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper.LookupHelper;
import gov.nih.nci.iscs.oracle.pgm.factory.GrantServiceFactory;
import gov.nih.nci.iscs.oracle.pgm.service.GrantQueryObject;
import gov.nih.nci.iscs.oracle.pgm.service.GrantSearchService;
import gov.nih.nci.iscs.oracle.pgm.service.GrantSearchObject;
import gov.nih.nci.iscs.oracle.pgm.forms.PaginationObject;
import gov.nih.nci.iscs.oracle.pgm.actions.helper.SearchGrantsActionHelper;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.PDASearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.SelectedGrants;
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
import javax.servlet.http.HttpSession;


public class SearchGrantsAction extends NciPgmAction  {

 private ServletContext oServletContext;
 private ApplicationContext oApplicationContext;
 private String timestamp = null;

 public static String USER_LOGIN_FAILURE = "UserLoginFailure";
 public static String DEFAULT_SORT_COLUMN = "default";
 private static Logger logger = LogManager.getLogger(SearchGrantsAction.class);




 public ServletContext getServletContext() {
	 return oServletContext;
 }

 public ApplicationContext getApplicationContext() {
	 return oApplicationContext;
 }


 public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {


       ActionForward mActionForward = null;
       boolean selectAllIndicator = false;
	   if ( !setGlobalVariables(form, request, response, mapping) )
           return mapping.findForward(USER_LOGIN_FAILURE);

       RetrieveGrantsForm mRetrieveGrantsForm = (RetrieveGrantsForm) form;

       String mAction = mRetrieveGrantsForm.getRequestAction();
       //process initial request. requestAction is an empty string
       if(mAction.trim().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ||
          mAction.trim().equalsIgnoreCase(ApplicationConstants.EXT_SEARCH_ACTION) ){
          RetrieveGrantsForm newForm = new RetrieveGrantsForm();
          SearchGrantsActionHelper.resetSession(request.getSession(), newForm, mapping.getName(), true);
          mRetrieveGrantsForm =  (RetrieveGrantsForm) request.getSession().getAttribute(ApplicationConstants.OLD_SEARCH_FORM);
	      form = (ActionForm) mRetrieveGrantsForm;
	      return mActionForward;

	   }


       if(!SearchGrantsActionHelper.validateSession(request.getSession() )) {
		   throw new GrantSearchException("SearchGrantsAction", "executeAction", "Your session has expired. You have open a new browser window to continue!", request.getSession());
	   }


	   Integer mCurrentPage = (Integer) request.getSession().getAttribute(ApplicationConstants.CURRENT_PAGE_SIZE);

	   if(!mAction.equalsIgnoreCase(ApplicationConstants.CHANGE_PAGE_SIZE))
		   mRetrieveGrantsForm.setSelectedPageSize(mCurrentPage.toString());

       // process core requests
       if( mAction.equalsIgnoreCase(ApplicationConstants.SEARCH_ACTION ))
           return search(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.RESET_ACTION ))
           return reset(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.NEXT_ACTION ))
           return next(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.PREVIOUS_ACTION ))
           return previous(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.GOTO_PAGE_ACTION ))
           return gotoPage(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.SELECT_ALL_ON_PAGE ))
           return selectAllOnPage(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.CLEAR_ALL_ON_PAGE ))
           return clearAllOnPage(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.SELECT_ALL ))
           return selectAll(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.CLEAR_ALL ))
           return clearAll(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.CHANGE_PAGE_SIZE ))
           return changePageSize(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.REFRESH_ACTION ))
           return refresh(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.GENERATE_REPORT )) {
           return generate(mapping, form, request, response);
	   }
       if( mAction.equalsIgnoreCase(ApplicationConstants.ACTION_CANCEL ) ||
           mAction.equalsIgnoreCase(ApplicationConstants.ACTION_RETURN ))
           return cancelled(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.ACTION_COLLAPSE_CRITERIA ) ||
           mAction.equalsIgnoreCase(ApplicationConstants.ACTION_EXPAND_CRITERIA  ))
           return mapping.findForward("continue");


       return mActionForward;
   }


   public ActionForward reset (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	   ActionForward mActionForward = null;
       RetrieveGrantsForm newForm = new RetrieveGrantsForm();
       newForm.setListGenerated(ApplicationConstants.EMPTY_STRING);

       SearchGrantsActionHelper.resetSession(request.getSession(), newForm, mapping.getName(), true);


       return mActionForward;

   }


   public   ActionForward search (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	   ActionForward mActionForward = null;
       RetrieveGrantsForm mRetrieveGrantsForm = (RetrieveGrantsForm) form;

       if (mRetrieveGrantsForm.getSortActionSelected() ){
		   SearchGrantsActionHelper.resetSession(request.getSession(), mRetrieveGrantsForm, mapping.getName(), false);
	   }

       PaginationObject mPaginationObject = (PaginationObject) request.getSession().getAttribute(ApplicationConstants.PAGINATION_OBJECT);
       boolean changePageSize = false;
       if ( (Boolean) request.getAttribute("ChangePageSize") != null ) {
		   Boolean temp = (Boolean) request.getAttribute("ChangePageSize");
		   changePageSize = temp.booleanValue();
	   }

       try{
          if(changePageSize) {
	   	     mPaginationObject.setPageSize(new Integer(mRetrieveGrantsForm.getSelectedPageSize() ));
    		 request.getSession().setAttribute(ApplicationConstants.CURRENT_PAGE_SIZE, new Integer(mRetrieveGrantsForm.getSelectedPageSize() ));
      } else {
		     Integer mCurrentPageSize = (Integer) request.getSession().getAttribute(ApplicationConstants.CURRENT_PAGE_SIZE);
		     mRetrieveGrantsForm.setSelectedPageSize(mCurrentPageSize.toString());
	      }
	   } catch (Exception ex) {
		   mRetrieveGrantsForm.setSelectedPageSize(SearchGrantsActionHelper.getDefaultPageSize());
    	   request.getSession().setAttribute(ApplicationConstants.CURRENT_PAGE_SIZE, new Integer(ApplicationConstants.DEFAULT_PAGE_SIZE ));
	   }
       updateSelected (mapping, form,  request, response);
       request.getSession().setAttribute(ApplicationConstants.PAGINATION_OBJECT, mPaginationObject);
       return mActionForward;

   }

   public ActionForward next (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	   ActionForward mActionForward = null;
       updateSelected (mapping, form,  request, response);
       PaginationObject mPaginationObject = (PaginationObject) request.getSession().getAttribute(ApplicationConstants.PAGINATION_OBJECT);
       // get the old form;
       mPaginationObject.setPageNumber(mPaginationObject.getNextPageNumber());
       RetrieveGrantsForm mRetrieveGrantsForm = (RetrieveGrantsForm) form;
       mRetrieveGrantsForm.setSortColumn( (String)  request.getSession().getAttribute(ApplicationConstants.LAST_SORT_COLUMN));
       mRetrieveGrantsForm.setSortOrder( (String)  request.getSession().getAttribute(ApplicationConstants.LAST_SORT_ORDER));
       form = (ActionForm) mRetrieveGrantsForm;
       request.getSession().setAttribute(ApplicationConstants.PAGINATION_OBJECT, mPaginationObject);
       return mActionForward;

   }

   public ActionForward previous (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	   ActionForward mActionForward = null;
       updateSelected (mapping, form,  request, response);
       PaginationObject mPaginationObject = (PaginationObject) request.getSession().getAttribute(ApplicationConstants.PAGINATION_OBJECT);
       mPaginationObject.setPageNumber(mPaginationObject.getPreviousPageNumber());
       RetrieveGrantsForm mRetrieveGrantsForm = (RetrieveGrantsForm) form;
       mRetrieveGrantsForm.setSortColumn( (String)  request.getSession().getAttribute(ApplicationConstants.LAST_SORT_COLUMN));
       mRetrieveGrantsForm.setSortOrder( (String)  request.getSession().getAttribute(ApplicationConstants.LAST_SORT_ORDER));
       form = (ActionForm) mRetrieveGrantsForm;
       request.getSession().setAttribute(ApplicationConstants.PAGINATION_OBJECT, mPaginationObject);
       return mActionForward;

   }

   public ActionForward gotoPage (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	   ActionForward mActionForward = null;
       updateSelected (mapping, form,  request, response);
       RetrieveGrantsForm mRetrieveGrantsForm = (RetrieveGrantsForm) form;
       PaginationObject mPaginationObject = (PaginationObject) request.getSession().getAttribute(ApplicationConstants.PAGINATION_OBJECT);
       mPaginationObject.setPageNumber( new Integer(mRetrieveGrantsForm.getGotoPageNumber()));
       RetrieveGrantsForm mRetrieveOldGrantsForm =  (RetrieveGrantsForm) request.getSession().getAttribute(ApplicationConstants.OLD_SEARCH_FORM);
       // compare the old form and the new form
       if(!SearchGrantsActionHelper.compareForms(mRetrieveOldGrantsForm, mRetrieveGrantsForm)){
		   form = (ActionForm) mRetrieveOldGrantsForm;
	   }
       request.getSession().setAttribute(ApplicationConstants.PAGINATION_OBJECT, mPaginationObject);
       return mActionForward;

   }

   public ActionForward clearAllOnPage (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	   ActionForward mActionForward = null;
       processPageSelect(mapping, form, request, ApplicationConstants.CLEAR_ALL);

       return mActionForward;

   }

   public ActionForward selectAllOnPage (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	   ActionForward mActionForward = null;
       processPageSelect(mapping, form, request, ApplicationConstants.SELECT_ALL);

       return mActionForward;

   }


   public ActionForward clearAll (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	   ActionForward mActionForward = null;
       request.getSession().setAttribute(ApplicationConstants.SELECTED_GRANTS, new SelectedGrants(mapping.getName()) );
       return mActionForward;
   }

   public ActionForward selectAll(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	   ActionForward mActionForward = null;
       return mActionForward;
   }

   public ActionForward changePageSize(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	   ActionForward mActionForward = null;
       RetrieveGrantsForm mRetrieveGrantsForm = (RetrieveGrantsForm) form;
       updateSelected (mapping, form,  request, response);
       Integer pageSize;
       try{
	     pageSize = new Integer(mRetrieveGrantsForm.getSelectedPageSize());
	   } catch(Exception ex) {
	     pageSize = new Integer(ApplicationConstants.DEFAULT_PAGE_SIZE);
	   }

       Integer[] mSelectedIndex = new Integer[pageSize.intValue()];
       for(int indx=0; indx<mSelectedIndex.length; indx++){
		   mSelectedIndex[indx] = new Integer("0");
	   }
	   mRetrieveGrantsForm.setSelectedIndx(mSelectedIndex);
       request.getSession().setAttribute(ApplicationConstants.CURRENT_PAGE_SIZE, pageSize);
       PaginationObject mPaginationObject = (PaginationObject) request.getSession().getAttribute(ApplicationConstants.PAGINATION_OBJECT);
       mPaginationObject.setPageNumber( new Integer(ApplicationConstants.FIRST_PAGE));
       return mActionForward;
   }
   public void processPageSelect (ActionMapping mapping, ActionForm form, HttpServletRequest request, String mAction)
                                      throws GrantSearchException {

       try{
		   SelectedGrants mSelectedGrants = (SelectedGrants) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS);
	       Map queryResults = (Map) request.getSession().getAttribute(ApplicationConstants.QUERY_RESULTS);
           mSelectedGrants.processPageSelect(queryResults, mAction);
           request.getSession().setAttribute(ApplicationConstants.SELECTED_GRANTS, mSelectedGrants);
       } catch(Exception ex) {
	        throw new GrantSearchException("SearchGrantsAction", "processPageSelect", ex.toString(), request.getSession(), ex);
       }

   }

   public ActionForward refresh (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	   ActionForward mActionForward = null;
       updateSelected (mapping, form,  request, response);
       return mActionForward;

   }
   public ActionForward generate (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {


      RetrieveGrantsForm mRetrieveGrantsForm = (RetrieveGrantsForm) form;

	  updateSelected (mapping, form,  request, response);

       boolean mSortOrder = false;
       String mAction = mRetrieveGrantsForm.getRequestAction();
       String mSortColumn = mRetrieveGrantsForm.getSortColumn();
       if(mRetrieveGrantsForm.getSortOrder().equalsIgnoreCase("asc")) {
		   mSortOrder = true;
	   }
       if(mSortColumn==null || mSortColumn.trim().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)) {
		   mSortColumn = DEFAULT_SORT_COLUMN;
		   mSortOrder = true;
	   }
	   SelectedGrants mSelectedGrants = (SelectedGrants) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS);
	   mSelectedGrants.sortSelectedGrants(mSortColumn, mSortOrder);
	   return mapping.findForward(mAction);

   }
   public void updateSelected (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException,  Exception {

	   try{
		   int sortIndex = 0;
		   ActionForward mActionForward = null;
           SelectedGrants mSelectedGrants= (SelectedGrants) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS);
	       Map queryResults = (Map) request.getSession().getAttribute(ApplicationConstants.QUERY_RESULTS);

           RetrieveGrantsForm mRetrieveGrantsForm = (RetrieveGrantsForm) form;
           mSelectedGrants.setSortedSelectedGrants(new ArrayList(queryResults.size()));
           try{
              if(mRetrieveGrantsForm.getSelectedIndx() != null) {
                 Integer[] mSelectedIndx =  mRetrieveGrantsForm.getSelectedIndx();
                 for(int i=0; i<mSelectedIndx.length; i++) {
	                Integer mKey = mSelectedIndx[i];
	                if(mKey != null) {
					 mSelectedGrants.processItemSelect(queryResults, mKey, true, sortIndex++);
					}
			      }
		       }
            mSelectedGrants.getSortedSelectedGrants().trimToSize();
			}catch (Exception ex) {
	             logger.error("An error occurred in updateSelected " + ex.toString());
   	        }
           request.getSession().setAttribute(ApplicationConstants.SELECTED_GRANTS, mSelectedGrants);
       } catch(Exception ex) {
	        throw new GrantSearchException("SearchGrantsAction", "updateSelected", ex.toString(), request.getSession(), ex);
       }

   }
   public ActionForward cancelled (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	   ActionForward mActionForward = null;
       request.getSession().setAttribute(ApplicationConstants.SELECTED_GRANTS, new SelectedGrants(mapping.getName()) );
       return mActionForward;

   }

  public   Map search (ActionForm form, String action, HttpServletRequest request, boolean selectIndicator) {
	  try{
		  request.setAttribute("SelectAllIndicator", new Boolean(selectIndicator));
	      Map queryResults = search(form, action, request);
          return queryResults;
       } catch(Exception ex) {
	        logger.error("Unable to complete search action" + ex.toString());
	        throw new GrantSearchException("SearchGrantsAction", "search", ex.toString(), request.getSession(), ex);
       }
  }

  public  Map search (ActionForm form, String action, HttpServletRequest request) throws GrantSearchException {

	   Map queryResults = null;
	   boolean selectAllIndicator = false;

	   try{
		   if((Boolean) request.getAttribute("SelectAllIndicator") != null) {
			   Boolean temp = (Boolean) request.getAttribute("SelectAllIndicator");
			   selectAllIndicator =temp.booleanValue();
		   }

		   GrantQueryObject mGrantQueryObject = (GrantQueryObject) form;

           RetrieveGrantsForm mRetrieveGrantsForm = (RetrieveGrantsForm) form;
           String  mLastSortColumn =  (String) request.getSession().getAttribute(ApplicationConstants.LAST_SORT_COLUMN);
           if(mLastSortColumn == null) {
		      mLastSortColumn = ApplicationConstants.EMPTY_STRING;
	       }
           boolean mSortAscendingIndicator = mRetrieveGrantsForm.getSortAscendingIndicator();
           //mRetrieveGrantsForm.setSortOrder(ApplicationConstants.SORT_ASC);
           if(mRetrieveGrantsForm.getSortActionSelected()) {
			   if(mSortAscendingIndicator) {
				   mRetrieveGrantsForm.setSortOrder(ApplicationConstants.SORT_ASC);
			   }else{
				   mRetrieveGrantsForm.setSortOrder(ApplicationConstants.SORT_DESC);
			   }

	          mRetrieveGrantsForm.setSortActionSelected(false);
    	   }
  	       PaginationObject mPaginationObject = new PaginationObject();
           if(selectAllIndicator) {
		       mPaginationObject.setPageNumber(new Integer(ApplicationConstants.ALL_PAGES));
	       } else {
	           mPaginationObject =  (PaginationObject) request.getSession().getAttribute(ApplicationConstants.PAGINATION_OBJECT);
	           if (mPaginationObject == null) {
	               mPaginationObject = new PaginationObject();
		       }
	       }
	       GrantSearchService mGrantSearchService = GrantServiceFactory.getGrantSearchService(action, oApplicationContext);
	       queryResults = (Map) mGrantSearchService.search(mGrantQueryObject, mPaginationObject, (UserFilterInfo) request.getSession().getAttribute(ApplicationConstants.USER_FILTER_INFO) );

           if(selectAllIndicator) {
		      return (Map) queryResults;
	       }
		   request.getSession().setAttribute("listGenerated", "Y");
           if(queryResults.size() == 0) {
			  request.getSession().setAttribute("listGenerated", "M");
		      ActionMessages messages = new ActionMessages();
		      logErrors(messages, "search", "errors.search.results.empty");
              this.saveMessages(request, messages);
	       }

	       mRetrieveGrantsForm.setListGenerated((String) request.getSession().getAttribute("listGenerated"));
           request.getSession().setAttribute("queryResults", queryResults);
           request.getSession().setAttribute(ApplicationConstants.PAGINATION_OBJECT, mPaginationObject );
           request.getSession().setAttribute(ApplicationConstants.LAST_SORT_COLUMN, mRetrieveGrantsForm.getSortColumn() );
           request.getSession().setAttribute(ApplicationConstants.LAST_SORT_ORDER, mRetrieveGrantsForm.getSortOrder() );
           request.getSession().setAttribute(ApplicationConstants.OLD_SEARCH_FORM, mRetrieveGrantsForm);
       } catch(Exception ex) {
	        logger.error("Search action failed" + ex.toString());
	        throw new GrantSearchException(this.getClass().getName(), "search", ex.toString(), request.getSession(), ex);
       }

       return (Map) queryResults;

  }
  private boolean setGlobalVariables(ActionForm form, HttpServletRequest request,  HttpServletResponse response, ActionMapping mapping )
                                  throws GrantSearchException {

	oServletContext = request.getSession().getServletContext();
	oApplicationContext =  (ApplicationContext) oServletContext.getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);

	getUserFilterInfo(request);
	createLookUps(request, mapping);

	return true;


}
private NciUser verifyUserInformation(HttpServletRequest request) {

	NciUser oNciUser = null;
	try {

	    if(request.getSession().getAttribute(NciUser.NCI_USER) == null) {
	       oNciUser = getUser(request);
	       request.getSession().setAttribute(NciUser.NCI_USER, oNciUser);
	     } else {
	       oNciUser = (NciUser) request.getSession().getAttribute(NciUser.NCI_USER);
         }
	} catch (Exception ex) {
		oNciUser = null;
        logger.error("Error verifying the user permissions and roles required for this application.");
	}

	return oNciUser;
}
private void getUserFilterInfo(HttpServletRequest request) throws GrantSearchException{

	NciUser oNciUser = verifyUserInformation(request);
    UserFilterInfo mUserFilterInfo = (UserFilterInfo) request.getSession().getAttribute(ApplicationConstants.USER_FILTER_INFO);
    if(mUserFilterInfo==null) {
      try {
	    UserServiceImpl mUserServiceImpl =  new UserServiceImpl(oApplicationContext, oNciUser.getOracleId());
	    mUserFilterInfo = mUserServiceImpl.getUserFilerInfo(oNciUser.getOracleId());
	    request.getSession().setAttribute(ApplicationConstants.USER_FILTER_INFO, mUserFilterInfo);
	  } catch(Exception ex) {
	    throw new GrantSearchException("SearchGrantsAction", "getUserFilterInfo", ex.toString(), request.getSession(), ex);
      }
    }
}

private void createLookUps(HttpServletRequest request, ActionMapping mapping) throws GrantSearchException {

	//build the lookup tables
	NciUser oNciUser = verifyUserInformation(request);
	try{
	   ArrayList mList = new ArrayList();
       mList = LookupHelper.addNewLookUp(LookUpTableConstants.CANCER_ACTIVITIES_T_LOOKUP, oApplicationContext);
	   request.setAttribute(LookUpTableConstants.CANCER_ACTIVITIES_T_LOOKUP[0], mList);

       mList = LookupHelper.addNewLookUp(LookUpTableConstants.APPL_STATUS_MV_LOOKUP, oApplicationContext);
	   request.setAttribute(LookUpTableConstants.APPL_STATUS_MV_LOOKUP[0], mList);

	   mList = LookupHelper.addNewLookUp(LookUpTableConstants.BOARDS_T_LOOKUP, oApplicationContext);
	   request.setAttribute(LookUpTableConstants.BOARDS_T_LOOKUP[0], mList);

	   mList = LookupHelper.addNewLookUp(LookUpTableConstants.PD_ORG_VW3_LOOKUP, oApplicationContext);
	   request.setAttribute(LookUpTableConstants.PD_ORG_VW3_LOOKUP[0], mList);

	   mList = LookupHelper.addNewLookUp(LookUpTableConstants.PD_NAME_VW3_LOOKUP, oApplicationContext);
	   request.setAttribute(LookUpTableConstants.PD_NAME_VW3_LOOKUP[0], mList);

       mList = LookupHelper.addNewLookUp(LookUpTableConstants.PD_NAME_VW4_LOOKUP, oApplicationContext);
       request.setAttribute(LookUpTableConstants.PD_NAME_VW4_LOOKUP[0], mList);

       UserServiceImpl mUserServiceImpl =  new UserServiceImpl(oApplicationContext, oNciUser.getOracleId().toUpperCase());
	   mList  = mUserServiceImpl.buildUserFilterLookup(oNciUser.getOracleId().toUpperCase(), mapping.getName());
	   request.setAttribute(ApplicationConstants.USER_FILTER_INFO, mList);
	   request.setAttribute(ApplicationConstants.PAGE_SIZES, ApplicationConstants.PAGE_SIZE_LIST());
   	}catch(Exception ex) {
	   logger.error("Unable to create LookUp tables" + ex.toString());
	   throw new GrantSearchException("SearchGrantsAction", "createLookUps", ex.toString(), request.getSession(), ex);
    }

}


public ActionForm compareForms(ActionForm form, HttpServletRequest request) {

	ActionForm mFormToUse = form;

   RetrieveGrantsForm mRetrieveOldGrantsForm = (RetrieveGrantsForm) request.getSession().getAttribute(ApplicationConstants.OLD_SEARCH_FORM);
   RetrieveGrantsForm mRetrieveGrantsForm = (RetrieveGrantsForm) form;

   // compare the old form and the new form
   if(!SearchGrantsActionHelper.compareForms(mRetrieveOldGrantsForm, mRetrieveGrantsForm)){
      if(!mRetrieveOldGrantsForm.isNull()){
		  mRetrieveOldGrantsForm.copyForms((RetrieveGrantsForm) mFormToUse);
	  }

   }
   return mFormToUse;
}



}



