package gov.nih.nci.iscs.oracle.pgm.actions;


import org.springframework.context.ApplicationContext;


import  gov.nih.nci.iscs.oracle.pgm.actions.NciPgmAction;
import  gov.nih.nci.iscs.oracle.pgm.forms.RereferReferralForm;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper.LookupHelper;
import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralActionObject;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralActionService;
import gov.nih.nci.iscs.oracle.pgm.factory.GrantServiceFactory;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralListComparator;
import gov.nih.nci.iscs.oracle.pgm.actions.helper.SearchGrantsActionHelper;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;


import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RereferReferralAction extends NciPgmAction {

  TreeMap  mReferralActionObjects = null;
  ArrayList mReferralActionList =  null;
  RereferReferralForm mRereferReferralForm  = null;
  String mAction = null;
  ActionMessages messages;
  ApplicationContext oApplicationContext;

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

       if(!SearchGrantsActionHelper.validateSession(request.getSession() )) {
		   throw new GrantSearchException("AcceptReferralAction", "executeAction", "Your session has expired. You have open a new browser window to continue!", request.getSession());
	   }

	try{
	   performInitialization(form, request);

       if( mAction.equalsIgnoreCase(ApplicationConstants.APPLY_TO_SELECTED ))
           return applyToSelected(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.EXECUTE_REREFER ))
           return executeReferralAction(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.ACTION_CANCEL ) ||
           mAction.equalsIgnoreCase(ApplicationConstants.ACTION_RETURN ))
           return cancelAction(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.SORT_LIST_ACTION ))
           return sortList(mapping, form, request, response);
	  } catch (Exception ex) {
		  throw new ReferralActionException("RereferReferralAction", "executeAction", ex.toString(), request.getSession(), ex);
	  }

       return mapping.findForward("continue");


   }
   public ActionForward executeReferralAction (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

	try{
	   messages = new ActionMessages();	   
	   boolean mValidationErrors = updateSelected(request);	  

	   // make sure that at comments and CA entered for all selecetd
       if( mValidationErrors){
	       super.logErrors(messages, "validation", "errors.referral.comments.maxlength");
           this.saveMessages(request, messages);
		   return mapping.findForward("continue");
	   }
	   // make sure that at least one entry werrors.no.rereferas selected
       if( mReferralActionObjects.size() == 0){
	       super.logErrors(messages, "validation", "errors.no.rerefer.action.selected");
           this.saveMessages(request, messages);
		   return mapping.findForward("continue");
	   }

	   NciUser mNciUser = (NciUser) request.getSession().getAttribute(NciUser.NCI_USER);
	   ReferralActionService mReferralActionService = GrantServiceFactory.getReferralActionService(mReferralActionObjects, oApplicationContext, mNciUser.getOracleId() );
	   boolean mResults = mReferralActionService.performReferral("rerefer");

	   if(!mResults) {
	       super.logErrors(messages, "validation", "errors.reject.failed");
           this.saveMessages(request, messages);
	       return mapping.findForward("continue");
	   }

	  request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_HASH, mReferralActionService.getReferralActionGrants() );
	  } catch (Exception ex) {
		  throw new ReferralActionException("RereferReferralAction", "executeReferralAction", ex.toString(), request.getSession(), ex);
	  }
  	  return mapping.findForward("complete");

   }

   public boolean updateSelected (HttpServletRequest request) throws ReferralActionException, Exception {

	try{       
       boolean mValidationErrors = false;
       mReferralActionObjects = new TreeMap();
       String comments = new String(ApplicationConstants.EMPTY_STRING);
       String cancerActivity = new String(ApplicationConstants.EMPTY_STRING);
       String mCA = new String(ApplicationConstants.EMPTY_STRING);
       String mApplId = new String(ApplicationConstants.EMPTY_STRING);
       String mKey = new String(ApplicationConstants.EMPTY_STRING);
 	   RereferReferralForm mRereferReferralForm = (RereferReferralForm) request.getAttribute("rereferReferralForm");       
       for (Iterator mIterator = mRereferReferralForm.getCommentsMap().entrySet().iterator(); mIterator.hasNext();) {
            Map.Entry entry = (Map.Entry) mIterator.next();
            mKey = (String)entry.getKey();
            mCA = mKey.substring(0,2);
            mApplId = mKey.substring(3,mKey.length());
            comments = (String) mRereferReferralForm.getCommentMapped(mKey);
            
            if(!StringUtils.isEmpty(comments) && comments.length() > 1000){
            	mValidationErrors = true;
    		}
            cancerActivity = (String) mRereferReferralForm.getCancerActivityMapped(mKey);

            for (Iterator mIterator_obj = mReferralActionList.iterator(); mIterator_obj.hasNext();) {
                 ReferralSearchResultObject mReferralSearchResultObject = (ReferralSearchResultObject) mIterator_obj.next();
 	             if(mReferralSearchResultObject.getCancerActivity().equalsIgnoreCase(mCA) &
      	            mApplId.equalsIgnoreCase(mReferralSearchResultObject.getApplId().toString())){
			          if(cancerActivity.length() > 0) {
		 		           ReferralActionObject mReferralActionObject = new ReferralActionObject();
                           mReferralActionObject.setRereferCA(cancerActivity);
                           mReferralActionObject.setComments(comments);
                           mReferralActionObject.setApplId(mReferralSearchResultObject.getApplId());
                           mReferralActionObject.setCancerActivity(mReferralSearchResultObject.getCancerActivity());
                           mReferralActionObject.setRereferPOC(mReferralSearchResultObject.getCurrentPoc());
                           mReferralActionObjects.put(mCA+"*"+mApplId, mReferralActionObject);
		                   mReferralSearchResultObject.setMarked(false);
				      }
		              break;
				 }
			}

	   }
       return mValidationErrors;
	  } catch (Exception ex) {
		  throw new ReferralActionException("RereferReferralAction", "updateSelected", ex.toString(), request.getSession(), ex);
	  }


   }


   public ActionForward applyToSelected (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

	try{
	   RereferReferralForm mRereferReferralForm = (RereferReferralForm) request.getAttribute("rereferReferralForm");
       
       String[] tokens = new String[3];
       String commentsToApply = mRereferReferralForm.getCommentsToApply();
       String caToApply = mRereferReferralForm.getCaToApply();

       if(mRereferReferralForm.getSelectedIndx() != null) {
          String[] mSelectedIndx =  mRereferReferralForm.getSelectedIndx();

          for(int i=0; i<mSelectedIndx.length; i++) {
			  tokens = getKeyTokens(mSelectedIndx[i]);	       	  
			  String mCA = tokens[1];
			  String mApplId = tokens[2];
			  String mKey = mCA + "*" + mApplId;
	          if(commentsToApply == null || commentsToApply.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ){
			  }else{
			     mRereferReferralForm.setCommentMapped(mKey, commentsToApply);
			  }
	          if(caToApply == null || caToApply.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)){
			  }else{
			     mRereferReferralForm.setCancerActivityMapped(mKey, caToApply);
			  }

		  }
	   }
	  } catch (Exception ex) {
		  throw new ReferralActionException("RereferReferralAction", "applyToSelected", ex.toString(), request.getSession(), ex);
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
		  throw new ReferralActionException("RereferReferralAction", "cancelAction", ex.toString(), request.getSession(), ex);
	  }
       return mapping.findForward(ApplicationConstants.ACTION_CANCEL);

   }

   public ActionForward sortList (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

	try{
	   RereferReferralForm mRereferReferralForm = (RereferReferralForm) request.getAttribute("rereferReferralForm");       
       String sortColumn = mRereferReferralForm.getSortColumn();
       boolean sortAscendingIndicator = mRereferReferralForm.getSortAscendingIndicator();
   	   Iterator mIterator = mReferralActionList.iterator();
   	   while(mIterator.hasNext()){
		   ReferralSearchResultObject mReferralSearchResultObject = (ReferralSearchResultObject) mIterator.next();
		   mReferralSearchResultObject.setSelected(false);
	   }
	   Collections.sort(mReferralActionList, new ReferralListComparator(sortColumn, sortAscendingIndicator));
	  } catch (Exception ex) {
		  throw new ReferralActionException("RereferReferralAction", "sortList", ex.toString(), request.getSession(), ex);
	  }
        return mapping.findForward("continue");
    }


   public void performInitialization (ActionForm form, HttpServletRequest request) throws ReferralActionException, Exception {

	try{
	   mRereferReferralForm = (RereferReferralForm) form;
   	   mAction = mRereferReferralForm.getRequestAction();
	   mReferralActionList = (ArrayList) request.getSession().getAttribute(ApplicationConstants.REFERRAL_ACTION_LIST);;
	   // this should not happen
	   if( mReferralActionList == null) {
           mReferralActionList  =  new ArrayList();
		   request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_LIST, mReferralActionList);
	   }
       oApplicationContext =  (ApplicationContext)  request.getSession().getServletContext().getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
	   ArrayList mList = new ArrayList();
       mList = LookupHelper.addNewLookUp(LookUpTableConstants.PD_CA_ASGNMT_VW_LOOKUP, oApplicationContext);
	   request.setAttribute(LookUpTableConstants.PD_CA_ASGNMT_VW_LOOKUP[0], mList);
	   mList = new ArrayList();
       mList = LookupHelper.addNewLookUp(LookUpTableConstants.CANCER_ACTIVITIES_T_LOOKUP, oApplicationContext);
	   request.setAttribute(LookUpTableConstants.CANCER_ACTIVITIES_T_LOOKUP[0], mList);
	   mRereferReferralForm.setQueryResults( (List) mReferralActionList);
       if(!mAction.equalsIgnoreCase(ApplicationConstants.REREFER_REFERRAL)) {
		   return;
	   }

	   HashMap mCommentsMap = new HashMap();
	   HashMap mCancerActivitiesMap = new HashMap();
	   for(int index=0; index<mReferralActionList.size(); index++){
		   Integer mTempVal = new Integer(index);
		   mCommentsMap.put(mTempVal.toString(), ApplicationConstants.EMPTY_STRING);
		   mCancerActivitiesMap.put(mTempVal.toString(), ApplicationConstants.EMPTY_STRING);
	   }

	   mRereferReferralForm.setCommentsMap( (Map) mCommentsMap);
	   mRereferReferralForm.setCancerActivitiesMap( (Map) mCancerActivitiesMap);

	  } catch (Exception ex) {
		  throw new ReferralActionException("RereferReferralAction", "performInitialization", ex.toString(), request.getSession(), ex);
	  }

   }

   private String[] getKeyTokens(String mKey) {

      String[] tokens = new String[3];
	  int indx = 0;
	  if(mKey != null) {
	     StringTokenizer st = new StringTokenizer(mKey, "*");
	     while(st.hasMoreTokens()) {
		    String temp =  st.nextToken();
		    tokens[indx] = temp;
		    indx++;
	     }
      }

      return tokens;
   }


}
