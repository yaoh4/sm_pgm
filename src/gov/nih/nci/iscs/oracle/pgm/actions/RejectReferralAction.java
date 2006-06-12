package gov.nih.nci.iscs.oracle.pgm.actions;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;


import  gov.nih.nci.iscs.oracle.pgm.actions.NciPgmAction;
import  gov.nih.nci.iscs.oracle.pgm.forms.RejectReferralForm;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants;
import gov.nih.nci.iscs.oracle.pgm.service.impl.UserServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper.LookupHelper;
import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForReferralForm;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralActionObject;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralActionService;
import gov.nih.nci.iscs.oracle.pgm.factory.GrantServiceFactory;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralListComparator;
import gov.nih.nci.iscs.oracle.pgm.actions.helper.SearchGrantsActionHelper;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;



import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.commons.beanutils.PropertyUtils;

import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RejectReferralAction extends NciPgmAction {

  TreeMap  mReferralActionObjects = null;
  ArrayList mReferralActionList =  null;
  RejectReferralForm mRejectReferralForm  = null;
  String mAction = null;
  ActionMessages messages;
  ApplicationContext oApplicationContext;
  String commentsValidationMessage = new String(ApplicationConstants.EMPTY_STRING);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {
       if(!SearchGrantsActionHelper.validateSession(request.getSession() )) {
		   throw new GrantSearchException("AcceptReferralAction", "executeAction", "Your session has expired. You have open a new browser window to continue!", request.getSession());
	   }

	try{
       performInitialization(form, request);

       if( mAction.equalsIgnoreCase(ApplicationConstants.EXECUTE_REJECT )) {
           return executeReferralAction(mapping, form, request, response);
	   }

       if( mAction.equalsIgnoreCase(ApplicationConstants.APPLY_TO_SELECTED ))
           return applyToSelected(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.ACTION_CANCEL ) ||
           mAction.equalsIgnoreCase(ApplicationConstants.ACTION_RETURN ))
           return cancelAction(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.SORT_LIST_ACTION ))
           return sortList(mapping, form, request, response);

	  } catch (Exception ex) {
		  throw new ReferralActionException("RejectReferralAction", "executeAction", ex.toString(), request.getSession(), ex);
	  }
       return mapping.findForward("continue");


   }
   public ActionForward executeReferralAction (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws  ReferralActionException, Exception {

	try{
	   messages = new ActionMessages();
	   RejectReferralForm mForm = (RejectReferralForm) request.getAttribute("rejectReferralForm");

	   boolean mValidationErrors = updateSelected(request);
	   // make sure that at least one comment was entered

       if(!commentsValidationMessage.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING ) ){
		   return mapping.findForward("continue");
	   }else{
		   if(mReferralActionObjects.size() <= 0 ) {
  	          //super.logErrors(messages, "validation", "errors.no.reject.action.selected");
  	          super.logErrors(messages, "validation", "errors.no.rejection.grant.selected");
              this.saveMessages(request, messages);
		      return mapping.findForward("continue");
		   }
	   }

	   NciUser mNciUser = (NciUser) request.getSession().getAttribute(NciUser.NCI_USER);
	   ReferralActionService mReferralActionService = GrantServiceFactory.getReferralActionService(mReferralActionObjects, oApplicationContext, mNciUser.getOracleId() );
	   boolean mResults = mReferralActionService.performReferral("reject");

	   if(!mResults) {
	       super.logErrors(messages, "validation", "errors.reject.failed");
           this.saveMessages(request, messages);
	       return mapping.findForward("continue");
	   }

	  request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_HASH, mReferralActionService.getReferralActionGrants() );
	  } catch (Exception ex) {
		  throw new ReferralActionException("RejectReferralAction", "executeReferralAction", ex.toString(), request.getSession(), ex);
	  }
  	  return mapping.findForward("complete");

   }

   public boolean updateSelected (HttpServletRequest request) throws ReferralActionException, Exception {

	try{
       commentsValidationMessage = ApplicationConstants.EMPTY_STRING;
       boolean mValidationErrors = false;
	   RejectReferralForm mRejectReferralForm = (RejectReferralForm) request.getAttribute("rejectReferralForm");
       mReferralActionObjects = new TreeMap();
       String comments = new String(ApplicationConstants.EMPTY_STRING);
       String dbComments = new String(ApplicationConstants.EMPTY_STRING);
       String mCA = new String(ApplicationConstants.EMPTY_STRING);
       String mApplId = new String(ApplicationConstants.EMPTY_STRING);
       String mKey = new String(ApplicationConstants.EMPTY_STRING);
       Map mCommentsMap = mRejectReferralForm.getCommentsMap();
       Map mDbCommentsMap = mRejectReferralForm.getDbCommentsMap();
	   Map mRejectionComments = (Map) request.getSession().getAttribute("REJ_COMMENTS");
       for (Iterator mIterator = mRejectReferralForm.getCommentsMap().entrySet().iterator(); mIterator.hasNext();) {
            Map.Entry entry = (Map.Entry) mIterator.next();
            mKey = (String)entry.getKey();
            mCA = mKey.substring(0,2);
            mApplId = mKey.substring(3,mKey.length());
            comments = (String) mRejectReferralForm.getCommentMapped(mKey);
            dbComments = (String) mRejectReferralForm.getDbCommentMapped(mKey);
		    String mCommentText = (String) mRejectionComments.get(dbComments);
		    if(mCommentText == null) {
				mCommentText = ApplicationConstants.EMPTY_STRING;
			}
            boolean mPutGrant = validateComment(mCommentText, comments);
            if(mValidationErrors) {
			}else{
				if(!mPutGrant & !commentsValidationMessage.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)){
			       super.logErrors(messages, "validation", commentsValidationMessage);
                   this.saveMessages(request, messages);
    			   mValidationErrors = true;
				}
			}
            for (Iterator mIterator_obj = mReferralActionList.iterator(); mIterator_obj.hasNext();) {
                 ReferralSearchResultObject mReferralSearchResultObject = (ReferralSearchResultObject) mIterator_obj.next();
      	         if(mReferralSearchResultObject.getCancerActivity().equalsIgnoreCase(mCA) &
      	            mApplId.equalsIgnoreCase(mReferralSearchResultObject.getApplId().toString())){
						if(mPutGrant) {
                          ReferralActionObject mReferralActionObject = new ReferralActionObject();
                          if (dbComments.equalsIgnoreCase("Other")){
                          mReferralActionObject.setComments(comments);
                          }
                          else {
                              mReferralActionObject.setComments(dbComments);
                          }
                          mReferralActionObject.setApplId(mReferralSearchResultObject.getApplId());
                          mReferralActionObject.setCancerActivity(mReferralSearchResultObject.getCancerActivity());
                          mReferralActionObjects.put(mCA+"*"+mApplId, mReferralActionObject);
                          break;
					    }else{
							if(!commentsValidationMessage.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ) {
								mReferralSearchResultObject.setMarked(true);
								return true;

							}
						}

				 }
			}

		}
      return mValidationErrors;

	  } catch (Exception ex) {
		  throw new ReferralActionException("RejectReferralAction", "updateSelected", ex.toString(), request.getSession(), ex);
	  }


   }

   private boolean validateComment(String mCommentText, String comments) {

	   boolean mPutGrant = false;
		if(mCommentText.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)){
			if(comments.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)){
				return false;
			}else{
				commentsValidationMessage = "errors.no.dropdown.msg.selected.rejection";
		        return false;
			}
	    }

	   // if dbComments is Other verify that comments entered
       if(mCommentText.equalsIgnoreCase("Other") ) {
		   if(comments.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)) {
			   commentsValidationMessage = "errors.no.dropdown.other.no.msg.rejection";
			   return false;
		   }else{
			   return true;
		   }
	   }


       if(!mCommentText.equalsIgnoreCase("Other") ) {
		   // if comments is empty use commentText
			 if(comments.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)) {
				comments = mCommentText;
				return true;
			 }
			 if(comments.equalsIgnoreCase(mCommentText)){
				 return true;
			 }else{
			     commentsValidationMessage = "errors.no.dropdown.msg.different.rejection";
				 return false;
			 }
		 }

		 return mPutGrant;


   }


   public ActionForward applyToSelected (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

	try{
	   RejectReferralForm mRejectReferralForm = (RejectReferralForm) request.getAttribute("rejectReferralForm");
       ReferralActionObject mReferralActionObject = null;
       boolean errorGenerated = false;
       int indx;
       String[] tokens = new String[3];
       String commentsToApply = mRejectReferralForm.getCommentsToApply();
       String rejectionSelection = mRejectReferralForm.getRejectionSelection();
       if(rejectionSelection.equalsIgnoreCase("Other") ){
		   if(commentsToApply.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ) {
	          messages = new ActionMessages();
	          super.logErrors(messages, "validation", "errors.rejection.text");
              this.saveMessages(request, messages);
		      return mapping.findForward("continue");
		   }
	   }
       if(mRejectReferralForm.getSelectedIndx() != null) {
          String[] mSelectedIndx =  mRejectReferralForm.getSelectedIndx();

          for(int i=0; i<mSelectedIndx.length; i++) {
			  tokens = getKeyTokens(mSelectedIndx[i]);
	          Integer index = new Integer(tokens[0]);
			  String mCA = tokens[1];
			  String mApplId = tokens[2];
			  String mKey = mCA + "*" + mApplId;
			  mRejectReferralForm.setCommentMapped(mKey, commentsToApply);
			  mRejectReferralForm.setDbCommentMapped(mKey, rejectionSelection);
		  }
	   }
	  } catch (Exception ex) {
		  throw new ReferralActionException("RejectReferralAction", "applyToSelected", ex.toString(), request.getSession(), ex);
	  }
       return mapping.findForward("continue");
    }


   public ActionForward cancelAction (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

	try{
	   request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_HASH, new TreeMap());
	   request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_LIST, new ArrayList());
       request.getSession().setAttribute("listGenerated", "Y");
	  } catch (Exception ex) {
		  throw new ReferralActionException("RejectReferralAction", "cancelAction", ex.toString(), request.getSession(), ex);
	  }
       return mapping.findForward(ApplicationConstants.ACTION_CANCEL);

   }

   public ActionForward sortList (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

	try{
	   RejectReferralForm mRejectReferralForm = (RejectReferralForm) request.getAttribute("rejectReferralForm");

       String sortColumn = mRejectReferralForm.getSortColumn();
       boolean sortAscendingIndicator = mRejectReferralForm.getSortAscendingIndicator();
	   Collections.sort(mReferralActionList, new ReferralListComparator(sortColumn, sortAscendingIndicator));
	  } catch (Exception ex) {
		  throw new ReferralActionException("RejectReferralAction", "sortList", ex.toString(), request.getSession(), ex);
	  }
        return mapping.findForward("continue");
    }


   public void performInitialization (ActionForm form, HttpServletRequest request)  throws ReferralActionException, Exception {

	try{
	   RejectReferralForm mRejectReferralForm = (RejectReferralForm) form;
   	   mAction = mRejectReferralForm.getRequestAction();
	   mReferralActionList = (ArrayList) request.getSession().getAttribute(ApplicationConstants.REFERRAL_ACTION_LIST);
	   // this should not happen
	   if( mReferralActionList == null) {
           mReferralActionList  =  new ArrayList();
	   }
       oApplicationContext =  (ApplicationContext)  request.getSession().getServletContext().getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
       if(!mAction.equalsIgnoreCase(ApplicationConstants.REJECT_REFERRAL)) {
		   return;
	   }
	   mRejectReferralForm.setQueryResults( (List) mReferralActionList);
	   mRejectReferralForm.setCount(mReferralActionList.size());
       performInitializeHashMap(form, request);
	  } catch (Exception ex) {
		  throw new ReferralActionException("RejectReferralAction", "performInitialization", ex.toString(), request.getSession(), ex);
	  }
   }

   public void performInitializeHashMap (ActionForm form, HttpServletRequest request)  {

	   RejectReferralForm mRejectReferralForm = (RejectReferralForm) form;
	   HashMap mCommentsMap = new HashMap();
	   for(int index=0; index<mReferralActionList.size(); index++){
		   Integer mTempVal = new Integer(index);
		   mCommentsMap.put(mTempVal.toString(), ApplicationConstants.EMPTY_STRING);
	   }

	   mRejectReferralForm.setCommentsMap( (Map) mCommentsMap);
	   mRejectReferralForm.setDbCommentsMap( (Map) mCommentsMap);

   }


   private String[] getKeyTokens(String mKey) {

      String[] tokens = new String[3];
	  int indx = 0;
	  if(mKey != null) {
	     StringTokenizer st = new StringTokenizer(mKey, "*");
	     while(st.hasMoreTokens()) {
		    String temp = (String) st.nextToken();
		    tokens[indx] = temp;
		    indx++;
	     }
      }

      return tokens;
   }

}
