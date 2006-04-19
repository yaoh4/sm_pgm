package gov.nih.nci.iscs.oracle.pgm.actions;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;


import  gov.nih.nci.iscs.oracle.pgm.actions.NciPgmAction;
import  gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForReferralForm;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants;
import gov.nih.nci.iscs.oracle.pgm.service.impl.UserServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper.LookupHelper;
import gov.nih.nci.iscs.oracle.pgm.actions.helper.SearchGrantsActionHelper;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.SelectedGrants;
import  gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForm;

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
import javax.servlet.http.HttpSession;


public class SearchGrantsForReferralAction extends SearchGrantsAction  {

  private static Logger logger = LogManager.getLogger(SearchGrantsAction.class);

  private String timestamp = null;
  private boolean backButtonActive = false;
  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

     try{
       //throw new Exception("This is a test");
       ActionForward mActionForward = super.executeAction(mapping, form, request, response);
	   if(mActionForward != null)
	      return mActionForward;

	   RetrieveGrantsForReferralForm mRetrieveGrantsForReferralForm = (RetrieveGrantsForReferralForm) form;
	   String mAction = mRetrieveGrantsForReferralForm.getRequestAction();
	   if(mRetrieveGrantsForReferralForm.getSelectedPageSize().trim().equals(ApplicationConstants.EMPTY_STRING)) {
	 	  mRetrieveGrantsForReferralForm.setSelectedPageSize(new Integer(ApplicationConstants.DEFAULT_PAGE_SIZE).toString());
	   }

       if( mAction.equalsIgnoreCase(ApplicationConstants.ACCEPT_REFERRAL ) ||
           mAction.equalsIgnoreCase(ApplicationConstants.REJECT_REFERRAL ) ||
           mAction.equalsIgnoreCase(ApplicationConstants.REREFER_REFERRAL) ||
           mAction.equalsIgnoreCase(ApplicationConstants.RELEASE_DUAL_REFERRAL ) ) {
		   super.updateSelected (mapping, form,  request, response);

		   return processReferralAction(mapping, form, request, response);
       }

       String mLastAction = (String) request.getSession().getAttribute("lastAction");
       if(mLastAction != null) {
          if( mLastAction.equalsIgnoreCase(ApplicationConstants.ACCEPT_REFERRAL ) ||
             mLastAction.equalsIgnoreCase(ApplicationConstants.REJECT_REFERRAL ) ||
             mLastAction.equalsIgnoreCase(ApplicationConstants.REREFER_REFERRAL) ||
             mLastAction.equalsIgnoreCase(ApplicationConstants.RELEASE_DUAL_REFERRAL ) ) {
             mRetrieveGrantsForReferralForm.setRequestAction(mLastAction);
		     return cancelled (mapping, form,  request, response);
          }
	   }
       if( mAction.equalsIgnoreCase(ApplicationConstants.EXT_SEARCH_ACTION) ){
		   mRetrieveGrantsForReferralForm.setSearchButtonInitiated(true);
		   return search(mapping, form, request, response);
	   }
     }catch (Exception ex) {
		   throw new GrantSearchException("SearchGrantsForReferralAction", "executeAction", ex.toString(), request.getSession(), ex);
	 }

       return mapping.findForward("continue");

   }

   public ActionForward processReferralAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException {


	   RetrieveGrantsForReferralForm mRetrieveGrantsForReferralForm = (RetrieveGrantsForReferralForm) form;
	   String mAction = mRetrieveGrantsForReferralForm.getRequestAction();
       String errorMsg = "";
       ActionMessages messages = new ActionMessages();
	  try{
		  // verify that grants have been selected.
	      SelectedGrants mSelectedGrants = (SelectedGrants) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS  );
          if(mSelectedGrants.isEmpty()){
	         super.logErrors(messages, "referralaction", "errors.referral.action.select");
	   	     this.saveMessages(request, messages);
		     return mapping.findForward("continue");
	      }

          errorMsg = mSelectedGrants.processForReferralAction(mAction, super.getApplicationContext(), (UserFilterInfo) request.getSession().getAttribute(ApplicationConstants.USER_FILTER_INFO) );
          if(!errorMsg.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)){
             super.logErrors(messages, "referralaction", errorMsg);
	   	     this.saveMessages(request, messages);
		     return mapping.findForward("continue");
	      }

          ArrayList newQueryResults = new ArrayList(mSelectedGrants.getSelectedGrants().values());

	      request.getSession().setAttribute(ApplicationConstants.SELECTED_GRANTS  , mSelectedGrants);
          request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_LIST , newQueryResults);
		  request.getSession().setAttribute("previousForm", mRetrieveGrantsForReferralForm);
          request.getSession().setAttribute("lastAction", mAction);
	  }  catch (Exception ex) {
		  throw new GrantSearchException("SearchGrantsForReferralAction", "processReferralAction", ex.toString(), request.getSession(), ex);
	  }

      return mapping.findForward(mAction);

   }

   public   ActionForward search (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	  try{
	     ActionForward mActionForward = super.search(mapping, form, request, response);
	     if(mActionForward != null)
	        return mActionForward;

	     ActionForm mFormToUse = form;

         RetrieveGrantsForReferralForm mRetrieveGrantsForReferralForm = (RetrieveGrantsForReferralForm) mFormToUse;

         if(mRetrieveGrantsForReferralForm.getSearchButtonInitiated()) {
		    mRetrieveGrantsForReferralForm.setSortColumn(ApplicationConstants.FULL_GRANT_NUMBER_SORT);
            if(!validateForm(mapping, mFormToUse,  request)) {
			   SearchGrantsActionHelper.resetSession(request.getSession(), (RetrieveGrantsForm) mRetrieveGrantsForReferralForm, mapping.getName(), true);
	           mRetrieveGrantsForReferralForm.setListGenerated("M");
		       return  mapping.findForward("continue");
	        }
		    SearchGrantsActionHelper.resetSessionForSearch(request.getSession(), mapping.getName());
	        mRetrieveGrantsForReferralForm.setSearchButtonInitiated(false);
	     }
		 super.search(mFormToUse, ApplicationConstants.REFERRAL, request);

        //mRetrieveGrantsForReferralForm = (RetrieveGrantsForReferralForm)  mFormToUse;
        //mRetrieveGrantsForReferralForm.copyForms((RetrieveGrantsForReferralForm) form);
	  } catch (Exception ex) {
		  throw new GrantSearchException("SearchGrantsForReferralAction", "processReferralAction", ex.toString(), request.getSession(), ex);
	  }


      return mapping.findForward("continue");
   }

   public ActionForward next (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	  try{
	     ActionForward mActionForward = super.next(mapping, form, request, response);
	     if(mActionForward != null)
	        return mActionForward;

	     ActionForm mFormToUse = form;

         mFormToUse = super.compareForms(form, request);

         super.search(mFormToUse, ApplicationConstants.REFERRAL, request);
         RetrieveGrantsForReferralForm mRetrieveGrantsForReferralForm = (RetrieveGrantsForReferralForm) mFormToUse;
         //mRetrieveGrantsForReferralForm.copyForms((RetrieveGrantsForReferralForm) form);
	  } catch (Exception ex) {
		  throw new GrantSearchException("SearchGrantsForReferralAction", "next", ex.toString(), request.getSession(), ex);
	  }

      return mapping.findForward("continue");
   }

    public ActionForward previous (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {

	  try{
 	     ActionForward mActionForward = super.previous(mapping, form, request, response);
 	     if(mActionForward != null)
 	        return mActionForward;
	     ActionForm mFormToUse = form;

         mFormToUse = super.compareForms(form, request);
         super.search(mFormToUse, ApplicationConstants.REFERRAL, request);
         RetrieveGrantsForReferralForm mRetrieveGrantsForReferralForm = (RetrieveGrantsForReferralForm) mFormToUse;
         //mRetrieveGrantsForReferralForm.copyForms((RetrieveGrantsForReferralForm) form);
	  } catch (Exception ex) {
		  throw new GrantSearchException("SearchGrantsForReferralAction", "previous", ex.toString(), request.getSession(), ex);
	  }

        return mapping.findForward("continue");
   }

    public ActionForward gotoPage (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {

	  try{

 	     ActionForward mActionForward = super.gotoPage(mapping, form, request, response);
 	     if(mActionForward != null)
 	        return mActionForward;

	     ActionForm mFormToUse = form;

         super.search(mFormToUse, ApplicationConstants.REFERRAL, request);
         RetrieveGrantsForReferralForm mRetrieveGrantsForReferralForm = (RetrieveGrantsForReferralForm) mFormToUse;
	  } catch (Exception ex) {
		  throw new GrantSearchException("SearchGrantsForReferralAction", "gotoPage", ex.toString(), request.getSession(), ex);
	  }

         return mapping.findForward("continue");
   }

    public ActionForward refresh (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {

 	   ActionForward mActionForward = super.refresh(mapping, form, request, response);
        return mapping.findForward("continue");
   }

   public ActionForward cancelled (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {
	  try{

 	      ActionForward mActionForward = super.cancelled(mapping, form, request, response);

	      ActionForm mFormToUse = form;

	      request.getSession().setAttribute(ApplicationConstants.SELECTED_GRANTS, new SelectedGrants(mapping.getName()));
          RetrieveGrantsForReferralForm mRetrieveGrantsForReferralForm  = (RetrieveGrantsForReferralForm) request.getSession().getAttribute("previousForm");
	      String mAction = mRetrieveGrantsForReferralForm.getRequestAction();
          if( mAction.equalsIgnoreCase(ApplicationConstants.ACCEPT_REFERRAL ) ||
              mAction.equalsIgnoreCase(ApplicationConstants.REJECT_REFERRAL ) ||
              mAction.equalsIgnoreCase(ApplicationConstants.REREFER_REFERRAL) ||
              mAction.equalsIgnoreCase(ApplicationConstants.RELEASE_DUAL_REFERRAL ) ) {
              super.search(mRetrieveGrantsForReferralForm, ApplicationConstants.REFERRAL, request);
          }
          request.setAttribute("retrieveGrantsForReferralForm", (ActionForm) mRetrieveGrantsForReferralForm);
	      request.getSession().setAttribute("lastAction", ApplicationConstants.EMPTY_STRING);
          request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_HASH, new TreeMap());
          request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_LIST, new ArrayList());
	  } catch (Exception ex) {
		  throw new GrantSearchException("SearchGrantsForReferralAction", "cancelled", ex.toString(), request.getSession(), ex);
	  }


       return mapping.findForward("continue");

   }


   public ActionForward clearAllOnPage (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {

	  try{
 	     ActionForward mActionForward = super.clearAllOnPage(mapping, form, request, response);
	  } catch (Exception ex) {
		  throw new GrantSearchException("SearchGrantsForReferralAction", "clearAllOnPage", ex.toString(), request.getSession(), ex);
	  }
       return mapping.findForward("continue");

   }

   public ActionForward selectAllOnPage (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {

	  try{
 	     ActionForward mActionForward = super.selectAllOnPage(mapping, form, request, response);
	  } catch (Exception ex) {
		  throw new GrantSearchException("SearchGrantsForReferralAction", "selectAllOnPage", ex.toString(), request.getSession(), ex);
	  }
      return mapping.findForward("continue");

   }
   public ActionForward clearAll (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {
	  try{

 	    ActionForward mActionForward = super.clearAll(mapping, form, request, response);
	  } catch (Exception ex) {
		  throw new GrantSearchException("SearchGrantsForReferralAction", "clearAll", ex.toString(), request.getSession(), ex);
	  }

        return mapping.findForward("continue");

   }
   public ActionForward selectAll (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {

	  try{
 	     ActionForward mActionForward = super.selectAll(mapping, form, request, response);
         Map map = (Map) super.search(form, ApplicationConstants.REFERRAL, request, true);
         SelectedGrants mSelectedGrants = new SelectedGrants(mapping.getName());
         mSelectedGrants.processPageSelect(map, ApplicationConstants.SELECT_ALL);
         request.getSession().setAttribute(ApplicationConstants.SELECTED_GRANTS, mSelectedGrants);
	  } catch (Exception ex) {
		  throw new GrantSearchException("SearchGrantsForReferralAction", "selectAll", ex.toString(), request.getSession(), ex);
	  }

      return mapping.findForward("continue");

   }
   public ActionForward changePageSize (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {

	  try{
 	     ActionForward mActionForward = super.changePageSize(mapping, form, request, response);
         request.setAttribute("ChangePageSize", new Boolean(true));
	  } catch (Exception ex) {
		  throw new GrantSearchException("SearchGrantsForReferralAction", "changePageSize", ex.toString(), request.getSession(), ex);
	  }

      return search(mapping, form, request, response);

   }
   public ActionForward reset (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	  try{
	     ActionForward mActionForward = super.reset(mapping, form, request, response);

	     if (mActionForward == null) {
		     RetrieveGrantsForReferralForm mRetrieveGrantsForReferralForm = (RetrieveGrantsForReferralForm) form;
		     mRetrieveGrantsForReferralForm.reset(mapping, request);
             return mapping.findForward("continue");
	     } else {
		     return mActionForward;
	     }
	  } catch (Exception ex) {
		  throw new GrantSearchException("SearchGrantsForReferralAction", "reset", ex.toString(), request.getSession(), ex);
	  }


   }

   public boolean validateForm(ActionMapping mapping, ActionForm form, HttpServletRequest request)
                                throws GrantSearchException {



	   boolean results = true;
	   try{
	      RetrieveGrantsForReferralForm mRetrieveGrantsForReferralForm = (RetrieveGrantsForReferralForm) form;
          /*boolean mFormIsNull  = mRetrieveGrantsForReferralForm.isNull();
          if(mFormIsNull){
		     ActionMessages messages = new ActionMessages();
		     logErrors(messages, "search", "errors.search.criteria.null");
             super.saveMessages(request, messages);
	         return false;
	      }*/

          ArrayList validationMessages = (ArrayList) mRetrieveGrantsForReferralForm.validate();
          if(validationMessages.size() > 0 ) {
		     super.saveMessages(validationMessages, request);
		     mRetrieveGrantsForReferralForm.setListGenerated("M");
		     results = false;
	      }
	  } catch (Exception ex) {
		  throw new GrantSearchException("SearchGrantsForReferralAction", "validateForm", ex.toString(), request.getSession(), ex);
	  }

	   return results;

   }



}
