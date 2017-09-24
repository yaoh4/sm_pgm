package gov.nih.nci.iscs.oracle.pgm.actions;


import org.springframework.context.ApplicationContext;


import  gov.nih.nci.iscs.oracle.pgm.actions.NciPgmAction;
import  gov.nih.nci.iscs.oracle.pgm.forms.ReleaseReferralForm;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralActionObject;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralActionService;
import gov.nih.nci.iscs.oracle.pgm.factory.GrantServiceFactory;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralListComparator;
import gov.nih.nci.iscs.oracle.pgm.actions.helper.SearchGrantsActionHelper;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;


import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReleaseReferralAction extends NciPgmAction {

  TreeMap  mReferralActionObjects = null;
  ArrayList mReferralActionList =  null;
  ReleaseReferralForm mReleaseReferralForm  = null;
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

       if( mAction.equalsIgnoreCase(ApplicationConstants.EXECUTE_RELEASE ))
           return executeReferralAction(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.ACTION_CANCEL ) ||
           mAction.equalsIgnoreCase(ApplicationConstants.ACTION_RETURN ))
           return cancelAction(mapping, form, request, response);
       if( mAction.equalsIgnoreCase(ApplicationConstants.SORT_LIST_ACTION ))
           return sortList(mapping, form, request, response);
	  } catch (Exception ex) {
		  throw new ReferralActionException("ReleaseReferralAction", "executeAction", ex.toString(), request.getSession(), ex);
	  }

       return mapping.findForward("continue");


   }
   public ActionForward executeReferralAction (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws  ReferralActionException, Exception {

	try{
	   messages = new ActionMessages();	   
	   NciUser mNciUser = (NciUser) request.getSession().getAttribute(NciUser.NCI_USER);
	   ReferralActionService mReferralActionService = GrantServiceFactory.getReferralActionService(mReferralActionObjects, oApplicationContext, mNciUser.getOracleId(),(String)mNciUser.getAttribute("readOnly") );
	   boolean mResults = mReferralActionService.performReferral("release");

	   if(!mResults) {
	       super.logErrors(messages, "validation", "errors.release.failed");
           this.saveMessages(request, messages);
	       return mapping.findForward("continue");
	   }

	  request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_HASH, mReferralActionService.getReferralActionGrants() );
	  } catch (Exception ex) {
		  throw new ReferralActionException("ReleaseReferralAction", "executeReferralAction", ex.toString(), request.getSession(), ex);
	  }
  	  return mapping.findForward("complete");

   }

   public ActionForward cancelAction (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

	try{
	   request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_HASH, new TreeMap());
	   request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_LIST, new ArrayList());
       request.getSession().setAttribute("listGenerated", "Y");
	  } catch (Exception ex) {
		  throw new ReferralActionException("ReleaseReferralAction", "cancelAction", ex.toString(), request.getSession(), ex);
	  }
       return mapping.findForward(ApplicationConstants.ACTION_CANCEL);

   }

   public ActionForward sortList (ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws ReferralActionException, Exception {

	try{
	   ReleaseReferralForm mReleaseReferralForm = (ReleaseReferralForm) request.getAttribute("releaseReferralForm");       
       String sortColumn = mReleaseReferralForm.getSortColumn();
       boolean sortAscendingIndicator = mReleaseReferralForm.getSortAscendingIndicator();
   	   Iterator mIterator = mReferralActionList.iterator();
   	   while(mIterator.hasNext()){
		   ReferralSearchResultObject mReferralSearchResultObject = (ReferralSearchResultObject) mIterator.next();
		   mReferralSearchResultObject.setSelected(false);
	   }
	   Collections.sort(mReferralActionList, new ReferralListComparator(sortColumn, sortAscendingIndicator));
	  } catch (Exception ex) {
		  throw new ReferralActionException("ReleaseReferralAction", "sortList", ex.toString(), request.getSession(), ex);
	  }
        return mapping.findForward("continue");
    }


   public void performInitialization (ActionForm form, HttpServletRequest request)  throws ReferralActionException, Exception {

	try{
	   mReleaseReferralForm = (ReleaseReferralForm) form;
	   mReferralActionList = (ArrayList) request.getSession().getAttribute(ApplicationConstants.REFERRAL_ACTION_LIST);;
	   // this should not happen
	   if( mReferralActionList == null) {
           mReferralActionList  =  new ArrayList();
		   request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_LIST, mReferralActionList);
	   }
	   mReferralActionObjects = (TreeMap) request.getSession().getAttribute(ApplicationConstants.REFERRAL_ACTION_HASH);
	   if( mReferralActionObjects == null) {
		   mReferralActionObjects = new TreeMap();
		   request.getSession().setAttribute(ApplicationConstants.REFERRAL_ACTION_HASH, mReferralActionObjects);
	   }
       int indx = 0;
       Iterator mIterator = mReferralActionList.iterator();
       while (mIterator.hasNext() ){
		      ReferralSearchResultObject mReferralSearchResultObject = (ReferralSearchResultObject) mIterator.next();
	          ReferralActionObject mReferralActionObject = new ReferralActionObject();
	          mReferralActionObject.setApplId(mReferralSearchResultObject.getApplId());
	          mReferralActionObject.setCancerActivity(mReferralSearchResultObject.getCancerActivity());
	          mReferralActionObject.setDualCA(mReferralSearchResultObject.getDualCA());
	          mReferralActionObjects.put(new Integer(indx), mReferralActionObject);
              indx++;
	   }

   	   mAction = mReleaseReferralForm.getRequestAction();
	   mReleaseReferralForm.setQueryResults( (List) mReferralActionList);
       oApplicationContext =  (ApplicationContext)  request.getSession().getServletContext().getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
	  } catch (Exception ex) {
		  throw new ReferralActionException("ReleaseReferralAction", "performInitialization", ex.toString(), request.getSession(), ex);
	  }
   }



}
