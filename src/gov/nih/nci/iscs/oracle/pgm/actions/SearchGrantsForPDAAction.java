package gov.nih.nci.iscs.oracle.pgm.actions;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;


import  gov.nih.nci.iscs.oracle.pgm.actions.NciPgmAction;
import  gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForPDAForm;
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


public class SearchGrantsForPDAAction extends SearchGrantsAction  {

  private static Logger logger = LogManager.getLogger(SearchGrantsAction.class);


  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

     try{
       ActionForward mActionForward = super.executeAction(mapping, form, request, response);
	   RetrieveGrantsForPDAForm mRetrieveGrantsForPDAForm = (RetrieveGrantsForPDAForm) form;
	   String mAction = mRetrieveGrantsForPDAForm.getRequestAction();

	   if(mActionForward != null)
	      return mActionForward;

       if( mAction.equalsIgnoreCase(ApplicationConstants.CONTINUE_ACTION )) {
          mRetrieveGrantsForPDAForm.setQueryResults((List) new ArrayList());
          mRetrieveGrantsForPDAForm.setListGenerated("N");
          request.getSession().setAttribute("listGenerated", "N");
          SearchGrantsActionHelper.resetSessionForSearch(request.getSession(), mapping.getName());
          return mapping.findForward("continue");
	   }

       if(mRetrieveGrantsForPDAForm.getSelectedPageSize().trim().equals(ApplicationConstants.EMPTY_STRING)) {
		  mRetrieveGrantsForPDAForm.setSelectedPageSize(new Integer(ApplicationConstants.DEFAULT_PAGE_SIZE).toString());
	   }
       if( mAction.equalsIgnoreCase(ApplicationConstants.ASSIGN_PD ) ) {
		   super.updateSelected (mapping, form,  request, response);

		   return processPDAssigmnentAction(mapping, form, request, response);
       }
     }catch (Exception ex) {
		   throw new GrantSearchException("SearchGrantsForPDAAction", "executeAction", ex.toString());
	 }

     return mapping.findForward("continue");

   }

   public ActionForward processPDAssigmnentAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException {



	  RetrieveGrantsForPDAForm mRetrieveGrantsForPDAForm = (RetrieveGrantsForPDAForm) form;
	  String mAction = mRetrieveGrantsForPDAForm.getRequestAction();
	  try{
		  // verify that grants have been selected.
          ActionMessages messages = new ActionMessages();
	      SelectedGrants mSelectedGrants = (SelectedGrants) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS  );

          if(mSelectedGrants.isEmpty()){
	         super.logErrors(messages, "pdAssignmentaction", "errors.pdassign.action.select");
	   	     this.saveMessages(request, messages);
		     return mapping.findForward("continue");
	      }
          ArrayList newQueryResults = new ArrayList(mSelectedGrants.getSelectedGrants().values());

	      request.getSession().setAttribute(ApplicationConstants.SELECTED_GRANTS  , mSelectedGrants);
          request.getSession().setAttribute(ApplicationConstants.PD_ASSIGNMENT_LIST , newQueryResults);
	      request.getSession().setAttribute("previousForm", mRetrieveGrantsForPDAForm);
	  } catch (Exception ex) {
		  logger.error ("An exception has occurred processing PD Assignment Action " + ex.toString() );
		  throw new GrantSearchException("SearchGrantsForPDAAction", "processPDAssigmnentAction", ex.toString());
	  }

      return mapping.findForward(mAction);

   }

   public  ActionForward search (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	   ActionForward mActionForward = super.search(mapping, form, request, response);
	   RetrieveGrantsForPDAForm mRetrieveGrantsForPDAForm = (RetrieveGrantsForPDAForm) form;
	   if(mActionForward != null)
	      return mActionForward;

	   ActionForm mFormToUse = form;

       if(mRetrieveGrantsForPDAForm.getSearchButtonInitiated()) {
		   mRetrieveGrantsForPDAForm.setSortColumn(ApplicationConstants.FULL_GRANT_NUMBER_SORT);
           if(!validateForm(mapping, mFormToUse,  request)) {
			   SearchGrantsActionHelper.resetSession(request.getSession(), (RetrieveGrantsForm) mRetrieveGrantsForPDAForm, mapping.getName(), true);
	           mRetrieveGrantsForPDAForm.setListGenerated("M");
		       return  mapping.findForward("continue");
	       }
		   SearchGrantsActionHelper.resetSessionForSearch(request.getSession(), mapping.getName());
	       mRetrieveGrantsForPDAForm.setSearchButtonInitiated(false);
	   }

       super.search(mFormToUse, ApplicationConstants.PD_ASSIGNMENT, request);
       return mapping.findForward("continue");
   }

   public ActionForward next (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	   ActionForward mActionForward = super.next(mapping, form, request, response);
	   if(mActionForward != null)
	      return mActionForward;

	   ActionForm mFormToUse = form;

       mFormToUse = super.compareForms(form, request);

       super.search(mFormToUse, ApplicationConstants.PD_ASSIGNMENT, request);
       RetrieveGrantsForPDAForm mRetrieveGrantsForPDAForm = (RetrieveGrantsForPDAForm) mFormToUse;

       return mapping.findForward("continue");
   }

   public ActionForward previous (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {

 	   ActionForward mActionForward = super.previous(mapping, form, request, response);
 	   if(mActionForward != null)
 	      return mActionForward;

       ActionForm mFormToUse = super.compareForms(form, request);

       super.search(mFormToUse, ApplicationConstants.PD_ASSIGNMENT, request);
       RetrieveGrantsForPDAForm mRetrieveGrantsForPDAForm = (RetrieveGrantsForPDAForm) mFormToUse;
       return mapping.findForward("continue");
   }

   public ActionForward gotoPage (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {


 	   ActionForward mActionForward = super.gotoPage(mapping, form, request, response);
 	   if(mActionForward != null)
 	      return mActionForward;

       ActionForm mFormToUse = super.compareForms(form, request);

       super.search(mFormToUse, ApplicationConstants.PD_ASSIGNMENT, request);
       RetrieveGrantsForPDAForm mRetrieveGrantsForPDAForm = (RetrieveGrantsForPDAForm) mFormToUse;
       return mapping.findForward("continue");
   }

    public ActionForward refresh (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {


        return mapping.findForward("continue");
   }

   public ActionForward cancelled (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

 	   ActionForward mActionForward = super.cancelled(mapping, form, request, response);

	   ActionForm mFormToUse = form;

       RetrieveGrantsForPDAForm mRetrieveGrantsForPDAForm  = (RetrieveGrantsForPDAForm) request.getSession().getAttribute("previousForm");
	   String mAction = mRetrieveGrantsForPDAForm.getRequestAction();
       if( mAction.equalsIgnoreCase(ApplicationConstants.ASSIGN_PD ) ) {
          super.search(mRetrieveGrantsForPDAForm, ApplicationConstants.PD_ASSIGNMENT, request);
       }
       request.setAttribute("retrieveGrantsForPDAForm", (ActionForm) mRetrieveGrantsForPDAForm);
       return mapping.findForward("continue");

   }

   public ActionForward clearAllOnPage (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {

 	   ActionForward mActionForward = super.clearAllOnPage(mapping, form, request, response);
       return mapping.findForward("continue");

   }
   public ActionForward selectAllOnPage (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {

 	   ActionForward mActionForward = super.selectAllOnPage(mapping, form, request, response);
       return mapping.findForward("continue");

   }
   public ActionForward clearAll (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {

 	   ActionForward mActionForward = super.clearAll(mapping, form, request, response);
       return mapping.findForward("continue");

   }
   public ActionForward selectAll (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {

 	   ActionForward mActionForward = super.selectAll(mapping, form, request, response);
       Map map = (Map) super.search(form, ApplicationConstants.PD_ASSIGNMENT, request, true);
       SelectedGrants mSelectedGrants = new SelectedGrants(mapping.getName());
       mSelectedGrants.processPageSelect(map, ApplicationConstants.SELECT_ALL);
       request.getSession().setAttribute(ApplicationConstants.SELECTED_GRANTS, mSelectedGrants);

       return mapping.findForward("continue");

   }
   public ActionForward changePageSize (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws GrantSearchException, Exception {

 	   ActionForward mActionForward = super.changePageSize(mapping, form, request, response);
       request.setAttribute("ChangePageSize", new Boolean(true));
       return search(mapping, form, request, response);

   }
   public ActionForward reset (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws GrantSearchException, Exception {

	   ActionForward mActionForward = super.reset(mapping, form, request, response);

	   if (mActionForward == null) {
		   RetrieveGrantsForPDAForm mRetrieveGrantsForPDAForm = (RetrieveGrantsForPDAForm) form;
		   mRetrieveGrantsForPDAForm.reset(mapping, request);
           return mapping.findForward("continue");
	   } else {
		   return mActionForward;
	   }

   }

   public boolean validateForm(ActionMapping mapping, ActionForm form, HttpServletRequest request)
                                throws GrantSearchException {



	   boolean results = true;
       try{
	      RetrieveGrantsForPDAForm mRetrieveGrantsForPDAForm = (RetrieveGrantsForPDAForm) form;
          /*boolean mFormIsNull  = mRetrieveGrantsForPDAForm.isNull();
          if(mFormIsNull){
		     ActionMessages messages = new ActionMessages();
		     logErrors(messages, "search", "errors.search.criteria.null");
             super.saveMessages(request, messages);
	         return false;
	      }*/

          ArrayList validationMessages = (ArrayList) mRetrieveGrantsForPDAForm.validate();
          if(validationMessages.size() > 0 ) {
		      super.saveMessages(validationMessages, request);
		      mRetrieveGrantsForPDAForm.setListGenerated("M");
		      results = false;
	      }
	   } catch (Exception ex) {
		  logger.error ("An exception has occurred processing PD Assignment Action " + ex.toString() );
		  throw new GrantSearchException("SearchGrantsForPDAAction", "validateForm", ex.toString());
	   }

	   return results;

   }



}
