package gov.nih.nci.iscs.oracle.pgm.actions;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;


import  gov.nih.nci.iscs.oracle.pgm.actions.NciPgmAction;
import  gov.nih.nci.iscs.oracle.pgm.forms.PdAssignmentForm;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper.LookupHelper;
import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.oracle.pgm.service.PdAssignmentActionService;
import gov.nih.nci.iscs.oracle.pgm.factory.GrantServiceFactory;
import gov.nih.nci.iscs.oracle.pgm.actions.helper.SearchGrantsActionHelper;
import gov.nih.nci.iscs.oracle.pgm.service.SelectedGrants;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralListComparator;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;


import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AssignPDAction extends NciPgmAction {

  TreeMap  mAssignmentActionObjects = null;
  ArrayList mAssignmentActionList =  null;
  PdAssignmentForm mPdAssignmentForm  = null;
  SelectedGrants mSelectedGrants = null;
  String mAction = null;
  ActionMessages messages;
  ApplicationContext oApplicationContext;
  private boolean portfolioExecution = false;
  private static Logger logger = LogManager.getLogger(AssignPDAction.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {

       if(!SearchGrantsActionHelper.validateSession(request.getSession() )) {
		   throw new GrantSearchException("NciPgmAction", "execute", "Your session has expired. You have open a new browser window to continue!", request.getSession());
	   }
	try{

	   performInitialization(form, request);

       if( mAction.equalsIgnoreCase(ApplicationConstants.ASSIGN_PD ) ||
           mAction.equalsIgnoreCase(ApplicationConstants.ASSIGN_PORTFOLIO) ){
            return initializeSelection(mapping, form, request, response);
	   }
       if( mAction.equalsIgnoreCase(ApplicationConstants.EXECUTE_ASSIGN ))
           return executeAssignmentAction(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.EXECUTE_PORTFOLIO_ASSIGNMENT ))
           return executePortfolioAssignmentAction(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.LOAD_ASSIGNMENTS ))
           return loadAssignmentAction(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.ACTION_CANCEL ) ||
           mAction.equalsIgnoreCase(ApplicationConstants.ACTION_RETURN ))
           return cancelAction(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.APPLY_TO_SELECTED ))
           return applyToSelected(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.SORT_LIST_ACTION ))
           return sortList(mapping, form, request, response);

	  } catch (Exception ex) {
		  throw new PDAssignmentException("AssignPDAction", "executeAction", ex.toString(), request.getSession(), ex);
	  }

      return mapping.findForward("continue");

   }


   public ActionForward executeAssignmentAction (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
	   
       String mErrorMsg = ApplicationConstants.EMPTY_STRING;
	   PdAssignmentForm mPdAssignmentForm = (PdAssignmentForm) form;
       messages = new ActionMessages();
       mSelectedGrants = (SelectedGrants) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS);
	   // mark all seleceted grants
	   if(!portfolioExecution ) {
		   mErrorMsg=markSelectedGrants(mPdAssignmentForm);
		   if(!mErrorMsg.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)){
              super.logErrors(messages, "validation", mErrorMsg);
              this.saveMessages(request, messages);
              return mapping.findForward("continue");
		   }
  	       // process PdIds
	       processPdIds();
	   }
       mAssignmentActionObjects = new TreeMap();
       Set errorMessages = mSelectedGrants.processForPdAssignmentAction(mAssignmentActionObjects);
       if(errorMessages.size() > 0){
		   Iterator iter = errorMessages.iterator();
		  while(iter.hasNext()){
		      mErrorMsg = (String) iter.next();
	          super.logErrors(messages, "validation", mErrorMsg);
              this.saveMessages(request, messages);
		  }
		  return mapping.findForward("continue");
	   }

	   // make sure that at least one PD was selected

       if( mAssignmentActionObjects.size() == 0){
	       super.logErrors(messages, "validation", "errors.no.pd.assignment.selected");
           this.saveMessages(request, messages);
		   return mapping.findForward("continue");
	   }

	   NciUser mNciUser = (NciUser) request.getSession().getAttribute(NciUser.NCI_USER);
	   PdAssignmentActionService mPdAssignmentActionService = GrantServiceFactory.getPdAssignmentActionService(mAssignmentActionObjects, oApplicationContext, mNciUser.getOracleId() );
	   boolean mResults = mPdAssignmentActionService.performPdAssignment("assign");

	   if(!mResults) {
	       super.logErrors(messages, "executeAssignmentAction", "errors.assign.failed");
           this.saveMessages(request, messages);
	       return mapping.findForward("continue");
	   }

	  request.getSession().setAttribute(ApplicationConstants.ASSIGNMENT_ACTION_HASH, mPdAssignmentActionService.getPdAssignmentActionGrants());
  	  return mapping.findForward("complete");

   }

   public ActionForward executePortfolioAssignmentAction (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {

       messages = new ActionMessages();
	   PdAssignmentForm mPdAssignmentForm = (PdAssignmentForm) request.getAttribute("pdAssignmentForm");
       String pdIdForLoad = mPdAssignmentForm.getPdIdForLoad();
       if(pdIdForLoad == null || pdIdForLoad.trim().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)) {
          super.logErrors(messages, "validation", "errors.no.asignment.pd.selected");
	   	  this.saveMessages(request, messages);
	   	  mPdAssignmentForm.setRequestAction(ApplicationConstants.ASSIGN_PORTFOLIO);
	   	  return mapping.findForward("continue");
	   }else{
		   mSelectedGrants = (SelectedGrants) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS);
	       mSelectedGrants.processKeyForPortfolioAssignmentAction(pdIdForLoad.substring(2), pdIdForLoad.substring(0,2));
	       portfolioExecution = true;
	   }
	   return executeAssignmentAction(mapping, form, request, response);

   }

   public ActionForward initializeSelection (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

	try{
	   PdAssignmentForm mPdAssignmentForm = (PdAssignmentForm) request.getAttribute("pdAssignmentForm");
       mPdAssignmentForm.initializeArray();
	  } catch (Exception ex) {
		  throw new ReferralActionException("executeAssignmentAction", "initializeSelection", ex.toString(), request.getSession(), ex);
	  }
       return mapping.findForward("continue");

   }

   public ActionForward sortList (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {

	   PdAssignmentForm mPdAssignmentForm = (PdAssignmentForm) form;
       String sortColumn = mPdAssignmentForm.getSortColumn();
       boolean sortAscendingIndicator = mPdAssignmentForm.getSortAscendingIndicator();
	   Collections.sort(mAssignmentActionList, new ReferralListComparator(sortColumn, sortAscendingIndicator));

       mSelectedGrants = (SelectedGrants) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS);
       mSelectedGrants.resetMarked();
  	   // process PdIds
	   if( mAction.equalsIgnoreCase(ApplicationConstants.ASSIGN_PD ) ){
          processPdIds();
	   }
	   String mLastAction = (String) request.getSession().getAttribute("lastAction");
	   if(StringUtils.isNotEmpty(mLastAction)){
		   if(ApplicationConstants.ASSIGN_PORTFOLIO.equalsIgnoreCase(mLastAction)){
			   mPdAssignmentForm.setRequestAction(ApplicationConstants.ASSIGN_PORTFOLIO);
		   }
		   else if(ApplicationConstants.ASSIGN_PD.equalsIgnoreCase(mLastAction)){
			   mPdAssignmentForm.setRequestAction(ApplicationConstants.ASSIGN_PD);
		   }
	   }
       return mapping.findForward("continue");
    }

   public ActionForward loadAssignmentAction (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {

	   // mark all seleceted grants	   
       messages = new ActionMessages();
       String mErrorMsg = ApplicationConstants.EMPTY_STRING;
	   PdAssignmentForm mPdAssignmentForm = (PdAssignmentForm) form;
       mSelectedGrants = (SelectedGrants) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS);
	   mErrorMsg = markSelectedGrants(mPdAssignmentForm);
	   if(!mErrorMsg.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)){
          super.logErrors(messages, "validation", mErrorMsg);
          this.saveMessages(request, messages);
          return mapping.findForward("continue");
	   }
       String pdIdForLoad = mPdAssignmentForm.getPdIdForLoad();
        if(pdIdForLoad != null) {
           try {
	          mErrorMsg = mSelectedGrants.processLoadForPDAssignmentAction(pdIdForLoad.substring(2), pdIdForLoad.substring(0,2));
		   } catch(Exception ex) {
               super.logErrors(messages, "validation", "errors.no.asignment.pd.selected");
	   	       this.saveMessages(request, messages);
               //mErrorMsg= mSelectedGrants.processLoadForPDAssignmentAction(ApplicationConstants.EMPTY_STRING, ApplicationConstants.EMPTY_STRING);
	       }
	    }
       if(!mErrorMsg.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)){
             super.logErrors(messages, "validation", mErrorMsg);
	   	     this.saveMessages(request, messages);
		}
  	   // process PdIds
       processPdIds();
       return mapping.findForward("continue");


   }

   public ActionForward cancelAction (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {

	   request.getSession().setAttribute(ApplicationConstants.ASSIGNMENT_ACTION_HASH, new TreeMap());
	   request.getSession().setAttribute(ApplicationConstants.PD_ASSIGNMENT_LIST, new ArrayList());
       request.getSession().setAttribute("listGenerated", "Y");
       return mapping.findForward(ApplicationConstants.ACTION_RETURN);

   }

   public ActionForward applyToSelected (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {


        return mapping.findForward("continue");
    }


   public void performInitialization (ActionForm form, HttpServletRequest request) {

	   mPdAssignmentForm = (PdAssignmentForm) form;
	   mAssignmentActionList = (ArrayList) request.getSession().getAttribute(ApplicationConstants.PD_ASSIGNMENT_LIST);;
	   portfolioExecution = false;
	   // this should not happen
	   if( mAssignmentActionList == null) {
           mAssignmentActionList  =  new ArrayList();
		   request.getSession().setAttribute(ApplicationConstants.PD_ASSIGNMENT_LIST, mAssignmentActionList);
	   }

   	   mAction = mPdAssignmentForm.getRequestAction();
	   mPdAssignmentForm.setQueryResults( (List) mAssignmentActionList);
  	   // set the Program Director LookUp
       oApplicationContext =  (ApplicationContext)  request.getSession().getServletContext().getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
       ArrayList mList = LookupHelper.addNewLookUp(LookUpTableConstants.PD_NAME_VW4_LOOKUP, oApplicationContext);
       request.setAttribute(LookUpTableConstants.PD_NAME_VW4_LOOKUP[0], mList);
   }



   private String markSelectedGrants(PdAssignmentForm mPdAssignmentForm) {

       mSelectedGrants.resetSelected();
       try{
           if(mPdAssignmentForm.getSelectedIndx() != null) {
              String[] mSelectedIndx =  mPdAssignmentForm.getSelectedIndx();
              for(int i=0; i<mSelectedIndx.length; i++) {
	              String mKey = mSelectedIndx[i];
	              if(mKey != null) {
			    	 mSelectedGrants.processKeyForPDAssignmentAction(mKey,  true);
				  }
			   }
			   return ApplicationConstants.EMPTY_STRING;
		    }else{
				return "errors.no.pd.assignment.selected";
			}
	    }catch (Exception ex) {
	        logger.error("An error occurred in markSelectedGrants " + ex.toString());
   	    }
	    return ApplicationConstants.EMPTY_STRING;

	}

   private void processPdIds() {

        try{
           String pdIdForLoad = mPdAssignmentForm.getPdIdForLoad();
		   Iterator iter = mPdAssignmentForm.getPrgIdsMap().entrySet().iterator();
		   while(iter.hasNext()){
			   Map.Entry entry = (Map.Entry)iter.next();
			   String mKey = (String) entry.getKey();
			   String mPdId = (String) entry.getValue();
	           try {
				  if(mPdId == null ||  mPdId.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ) {
                     mSelectedGrants.processPdForPDAssignmentAction(ApplicationConstants.EMPTY_STRING, ApplicationConstants.EMPTY_STRING, mKey, false, pdIdForLoad);
				  }else {
	                 mSelectedGrants.processPdForPDAssignmentAction(mPdId.substring(2), mPdId.substring(0,2), mKey, false, pdIdForLoad);
				  }
			   } catch (Exception ex) {
				  logger.error("**** an exception has been generated in processPdIds ***" + ex.toString());
			   }
		    }
	    }catch (Exception ex) {
	        logger.error("An error occurred in processPdIds " + ex.toString());
   	    }


	}


}
