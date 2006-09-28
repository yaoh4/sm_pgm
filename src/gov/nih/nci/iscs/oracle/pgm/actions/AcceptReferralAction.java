package gov.nih.nci.iscs.oracle.pgm.actions;


import org.springframework.context.ApplicationContext;


import  gov.nih.nci.iscs.oracle.pgm.actions.NciPgmAction;
import  gov.nih.nci.iscs.oracle.pgm.forms.AcceptReferralForm;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper.LookupHelper;
import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralActionObject;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralActionService;
import gov.nih.nci.iscs.oracle.pgm.factory.GrantServiceFactory;
import gov.nih.nci.iscs.oracle.pgm.actions.helper.SearchGrantsActionHelper;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralListComparator;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;


import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AcceptReferralAction extends NciPgmAction {

  TreeMap  mReferralActionObjects = null;
  ArrayList mReferralActionList =  null;
  AcceptReferralForm mAcceptReferralForm  = null;
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

       if( mAction.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING ))
           return initializeSelection(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.EXECUTE_ACCEPT ))
           return executeReferralAction(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.UPDATE_SELECTED ))
           return updateSelected(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.ACTION_CANCEL ) ||
           mAction.equalsIgnoreCase(ApplicationConstants.ACTION_RETURN ))
           return cancelAction(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.APPLY_TO_SELECTED ))
           return applyToSelected(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.FILTER_CA_ACTION ))
           return filterCA(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.SORT_LIST_ACTION ))
           return sortList(mapping, form, request, response);
	  } catch (Exception ex) {
		  throw new ReferralActionException("AcceptReferralAction", "executeAction", ex.toString(), request.getSession(), ex);
	  }

       return mapping.findForward("continue");

   }
   public ActionForward executeReferralAction (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

	try{
       messages = new ActionMessages();	   
	   // make sure that at least one PD was selected
       if( mReferralActionObjects.size() == 0){
	       super.logErrors(messages, "validation", "errors.no.pd.selected");
           this.saveMessages(request, messages);
		   return mapping.findForward("continue");
	   }

	   NciUser mNciUser = (NciUser) request.getSession().getAttribute(NciUser.NCI_USER);
	   ReferralActionService mReferralActionService = GrantServiceFactory.getReferralActionService(mReferralActionObjects, oApplicationContext, mNciUser.getOracleId() );
	   boolean mResults = mReferralActionService.performReferral("accept");

	   if(!mResults) {
	       super.logErrors(messages, "validation", "errors.accept.failed");
           this.saveMessages(request, messages);
	       return mapping.findForward("continue");
	   }

	  request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_HASH, mReferralActionService.getReferralActionGrants());
	  } catch (Exception ex) {
		  throw new ReferralActionException("AcceptReferralAction", "executeReferralAction", ex.toString(), request.getSession(), ex);
	  }
  	  return mapping.findForward("complete");

   }

   public ActionForward updateSelected (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

	try{
	   AcceptReferralForm mAcceptReferralForm = (AcceptReferralForm) request.getAttribute("acceptReferralForm");
       String mKey = mAcceptReferralForm.getSelectedIndex();
       String[] tokens = getKeyTokens(mKey);
       Integer index = new Integer(tokens[0]);
       String selectedPd = mAcceptReferralForm.getPdId();
       ReferralSearchResultObject mReferralSearchResultObject = (ReferralSearchResultObject) mReferralActionList.get(index.intValue());
       ReferralActionObject mReferralActionObject = new ReferralActionObject();
       if(selectedPd.equalsIgnoreCase("removed")) {
           mReferralActionObjects.remove(tokens[1] + "*" + tokens[2]);
	   }else{
           mReferralActionObject.setPdId(selectedPd);
           mReferralActionObject.setApplId(mReferralSearchResultObject.getApplId());
           mReferralActionObject.setCancerActivity(mReferralSearchResultObject.getCancerActivity());
           mReferralActionObjects.put(tokens[1] + "*" + tokens[2], mReferralActionObject);
	   }
	  } catch (Exception ex) {
		  throw new ReferralActionException("AcceptReferralAction", "updateSelected", ex.toString(), request.getSession(), ex);
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
		  throw new ReferralActionException("AcceptReferralAction", "cancelAction", ex.toString(), request.getSession(), ex);
	  }
       return mapping.findForward(ApplicationConstants.ACTION_CANCEL);

   }

   public ActionForward initializeSelection (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

	try{
	   AcceptReferralForm mAcceptReferralForm = (AcceptReferralForm) request.getAttribute("acceptReferralForm");
       mAcceptReferralForm.initializeArray();
	  } catch (Exception ex) {
		  throw new ReferralActionException("AcceptReferralAction", "initializeSelection", ex.toString(), request.getSession(), ex);
	  }
       return mapping.findForward("continue");

   }

   public ActionForward applyToSelected (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

	try{
	   AcceptReferralForm mAcceptReferralForm = (AcceptReferralForm) request.getAttribute("acceptReferralForm");
       ReferralActionObject mReferralActionObject = null;       
       String[] tokens = new String[3];
       String selectedPd = mAcceptReferralForm.getPdId();
       if(mAcceptReferralForm.getSelectedIndx() != null) {
          String[] mSelectedIndx =  mAcceptReferralForm.getSelectedIndx();

          for(int i=0; i<mSelectedIndx.length; i++) {
			  tokens = getKeyTokens(mSelectedIndx[i]);
	       	  Integer index = new Integer(tokens[0]);
			  String mCA = tokens[1];
			  String mApplId = tokens[2];
			  if(selectedPd.equalsIgnoreCase("") || selectedPd == null){
                    mReferralActionObjects.remove(index);
			  }else{
					 Iterator mIterator = mReferralActionList.iterator();
				     while(mIterator.hasNext()){
					     ReferralSearchResultObject mReferralSearchResultObject = (ReferralSearchResultObject) mIterator.next();
					     if(mCA.equalsIgnoreCase(mReferralSearchResultObject.getCancerActivity()) &
					        mApplId.equalsIgnoreCase(mReferralSearchResultObject.getApplId().toString())){
							    mReferralActionObject = new ReferralActionObject();
                                mReferralActionObject.setPdId(selectedPd);
                                mReferralActionObject.setApplId(mReferralSearchResultObject.getApplId());
                                mReferralActionObject.setCancerActivity(mReferralSearchResultObject.getCancerActivity());
                                mReferralActionObjects.put(mCA + "*" +  mApplId, mReferralActionObject);
				         }
				     }
			  }

		  }

		}
	  } catch (Exception ex) {
		  throw new ReferralActionException("AcceptReferralAction", "applyToSelected", ex.toString(), request.getSession(), ex);
	  }
        return mapping.findForward("continue");

   }


   public ActionForward filterCA (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

	try{
	   AcceptReferralForm mAcceptReferralForm = (AcceptReferralForm) request.getAttribute("acceptReferralForm");              
       String filterCA = mAcceptReferralForm.getFilterCA();
   	   Iterator mIterator = mReferralActionList.iterator();
   	   while(mIterator.hasNext()){
		   ReferralSearchResultObject mReferralSearchResultObject = (ReferralSearchResultObject) mIterator.next();
		   if(filterCA.equalsIgnoreCase(mReferralSearchResultObject.getCancerActivity() )) {
			   mReferralSearchResultObject.setSelected(true);
		   }
		}
	  } catch (Exception ex) {
		  throw new ReferralActionException("AcceptReferralAction", "filterCA", ex.toString(), request.getSession(), ex);
	  }
        return mapping.findForward("continue");
    }

   public ActionForward sortList (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

	try{
	   AcceptReferralForm mAcceptReferralForm = (AcceptReferralForm) request.getAttribute("acceptReferralForm");      
       String sortColumn = mAcceptReferralForm.getSortColumn();
       boolean sortAscendingIndicator = mAcceptReferralForm.getSortAscendingIndicator();   	   
	   Collections.sort(mReferralActionList, new ReferralListComparator(sortColumn, sortAscendingIndicator));
	  } catch (Exception ex) {
		  throw new ReferralActionException("AcceptReferralAction", "sortList", ex.toString(), request.getSession(), ex);
	  }
        return mapping.findForward("continue");
    }


   public void performInitialization (ActionForm form, HttpServletRequest request) throws ReferralActionException, Exception  {
	   
	try{
	   AcceptReferralForm mAcceptReferralForm = (AcceptReferralForm) form;
	   mReferralActionList = (ArrayList) request.getSession().getAttribute(ApplicationConstants.REFERRAL_ACTION_LIST);;
	   // this should not happen
	   if( mReferralActionList == null) {
           mReferralActionList  =  new ArrayList();
		   request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_LIST, mReferralActionList);
	   }
	   //Collections.sort(mReferralActionList, new ReferralListComparator(mSortColumn, mSortAsc));
	   mReferralActionObjects = (TreeMap) request.getSession().getAttribute(ApplicationConstants.REFERRAL_ACTION_HASH);
	   if( mReferralActionObjects == null) {
		   mReferralActionObjects = new TreeMap();
		   request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_HASH, mReferralActionObjects);
	   }

   	   mAction = mAcceptReferralForm.getRequestAction();
	   mAcceptReferralForm.setQueryResults( (List) mReferralActionList);
  	   // set the Program Director LookUp
       oApplicationContext =  (ApplicationContext)  request.getSession().getServletContext().getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
       ArrayList mList = LookupHelper.addNewLookUp(LookUpTableConstants.PD_NAME_VW3_LOOKUP, oApplicationContext);
       request.setAttribute(LookUpTableConstants.PD_NAME_VW3_LOOKUP[0], mList);
	  } catch (Exception ex) {
		  throw new ReferralActionException("AcceptReferralAction", "performInitialization", ex.toString(), request.getSession(), ex);
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
