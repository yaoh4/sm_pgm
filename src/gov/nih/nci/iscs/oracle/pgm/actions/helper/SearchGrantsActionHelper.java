package gov.nih.nci.iscs.oracle.pgm.actions.helper;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.commons.beanutils.PropertyUtils;

import  gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForm;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.SelectedGrants;
import gov.nih.nci.iscs.oracle.pgm.forms.PaginationObject;

import javax.servlet.http.HttpSession;

import java.util.*;


public class SearchGrantsActionHelper {



public static boolean validateFiscalYear(String fiscalYear)  {

    if (fiscalYear.length() == 4) {
	    try {
	        Integer.parseInt(fiscalYear );
	    } catch(NumberFormatException ex) {
		    return false;
	    }
    } else {
        return false;
    }

    return true;

 }

public static boolean validateSession(HttpSession oSession)  {

   if(oSession.isNew()){
	   return false;
   } else {
	   return true;
   }

}

public static boolean validateIntegerFields(String fieldValue)  {

   try {
	     Integer.parseInt(fieldValue );
	     return true;
   } catch(NumberFormatException ex) {
	     return false;
   }

}

public static boolean validateLongFields(String fieldValue)  {

   try {
	     Long.parseLong(fieldValue );
	     return true;
   } catch(NumberFormatException ex) {
	     return false;
   }

}
public static boolean validateFiscalYearRange(String fiscalYearFrom, String fiscalYearTo)  {

	int fyFrom = Integer.parseInt(fiscalYearFrom);
	int fyTo = Integer.parseInt(fiscalYearTo);
	if(fyFrom > fyTo )
		  return false;

    return true;

 }
public static String getDefaultPageSize()  {


    return new Integer(ApplicationConstants.DEFAULT_PAGE_SIZE).toString();

 }
public static boolean validateNcabRange(String ncabFrom, String ncabTo)  {

	int mNcabFrom = Integer.parseInt(ncabFrom);
	int nMcabTo = Integer.parseInt(ncabTo);
	if(mNcabFrom > nMcabTo )
		  return false;

    return true;

 }

public static void copyForms(RetrieveGrantsForm destForm, RetrieveGrantsForm origForm) {

   try {
	     PropertyUtils.copyProperties(destForm, origForm);
	 } catch (Exception ex) {
		 System.out.println("*** error copying froms ****" + ex.toString());
	 }

 }

public static String validateGrantsForAction(Map mSelectedGrantObjects, String mAction) {

  String mErrorMsg = new String(ApplicationConstants.EMPTY_STRING);
  ArrayList mGrantsToRemoveList = new ArrayList();
  Iterator iterator = mSelectedGrantObjects.entrySet().iterator();
  while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry) iterator.next();
      String mKey =  (String)  entry.getKey();
      ReferralSearchResultObject obj = (ReferralSearchResultObject) entry.getValue();

      // check that it is not a dual
      if (obj.getDualPoc() == null  ||
		  obj.getDualPoc().equals("n/a") ||
		  obj.getDualPoc().equals(ApplicationConstants.EMPTY_STRING)) {
          if( mAction.equalsIgnoreCase(ApplicationConstants.RELEASE_DUAL_REFERRAL )) {
			  //add to the remove list
			  mGrantsToRemoveList.add(mKey);
			  obj.setMarked(true);
			  mErrorMsg = "errors.referral.action.non.dual";
		  }
	  } else {
          if( mAction.equalsIgnoreCase(ApplicationConstants.ACCEPT_REFERRAL ) ||
              mAction.equalsIgnoreCase(ApplicationConstants.REJECT_REFERRAL ) ||
              mAction.equalsIgnoreCase(ApplicationConstants.REREFER_REFERRAL) ) {
			  //add to the remove list
			  mGrantsToRemoveList.add(mKey);
			  obj.setMarked(true);
			  mErrorMsg = "errors.referral.action.dual";
		   }
	  }
  }
  return mErrorMsg;

 }

public static void resetSortParameters(HttpSession session, RetrieveGrantsForm newForm) {

   session.setAttribute(ApplicationConstants.LAST_SORT_COLUMN, newForm.getSortColumn() );
   session.setAttribute(ApplicationConstants.LAST_SORT_ORDER, newForm.getSortOrder() );
 }

public static void resetSession(HttpSession session, RetrieveGrantsForm newForm, String mappingAction, boolean resetSort) {

   session.setAttribute(ApplicationConstants.OLD_SEARCH_FORM, newForm );
   resetSessionForSearch(session, mappingAction);
   if(resetSort){
	   resetSortParameters(session, newForm);
   }
 }

public static void resetSessionForSearch(HttpSession session, String mappingAction) {

   PaginationObject mPaginationObject = new PaginationObject();
   mPaginationObject.setPageNumber(new Integer(ApplicationConstants.FIRST_PAGE));
   session.setAttribute(ApplicationConstants.CURRENT_PAGE_SIZE, new Integer(ApplicationConstants.DEFAULT_PAGE_SIZE));

   session.setAttribute(ApplicationConstants.PAGINATION_OBJECT, mPaginationObject);
   session.setAttribute(ApplicationConstants.QUERY_RESULTS, new HashMap());
   session.setAttribute(ApplicationConstants.SELECTED_GRANTS, new SelectedGrants(mappingAction));
	session.setAttribute("listGenerated", "");

 }

public static void resetMarked(Map mSelectedGrantObjects) {

  for (Iterator iterator = mSelectedGrantObjects.entrySet().iterator(); iterator.hasNext();) {
      Map.Entry entry = (Map.Entry) iterator.next();
      ReferralSearchResultObject obj = (ReferralSearchResultObject) entry.getValue();
      obj.setMarked(false);
  }
}

public static boolean compareForms(RetrieveGrantsForm oldForm, RetrieveGrantsForm newForm) {

	if ( (oldForm == null) || (newForm==null) ){
		return false;
	}

	if(!oldForm.getTp().equals(newForm.getTp()) ){
		return false;
	}

	if(!oldForm.getMech().equals(newForm.getMech()) ){
		return false;
	}

	if(!oldForm.getIcd().equals(newForm.getIcd()) ){
		return false;
	}

	if(!oldForm.getYear().equals(newForm.getYear()) ){
		return false;
	}

	if(!oldForm.getSuffix().equals(newForm.getSuffix()) ){
		return false;
	}

	if(!oldForm.getApplId().equals(newForm.getApplId()) ){
		return false;
	}

	if(!oldForm.getIpf().equals(newForm.getIpf()) ){
		return false;
	}

	if(!oldForm.getProjectTitle().equals(newForm.getProjectTitle()) ){
		return false;
	}

	if(!oldForm.getPiLastName().equalsIgnoreCase(newForm.getPiLastName() ) ){
		return false;
	}

 	if(!oldForm.getPiFirstName().equals(newForm.getPiFirstName()) ){
 		return false;
 	}

 	if(!oldForm.getInstName().equals(newForm.getInstName()) ){
 		return false;
 	}

 	if(!oldForm.getInstCity().equals(newForm.getInstCity()) ){
 		return false;
 	}

 	if(!oldForm.getInstState().equals(newForm.getInstState()) ){
 		return false;
 	}

 	if(!oldForm.getRfaPa().equals(newForm.getRfaPa()) ){
 		return false;
 	}

 	if(!oldForm.getNcabFromDate().equals(newForm.getNcabFromDate()) ){
 		return false;
 	}

 	if(!oldForm.getNcabToDate().equals(newForm.getNcabToDate()) ){
 		return false;
 	}

 	if(!oldForm.getFyFrom().equals(newForm.getFyFrom()) ){
 		return false;
 	}

 	if(!oldForm.getFyTo().equals(newForm.getFyTo()) ){
 		return false;
 	}

 	if(!oldForm.getCancerActivity().equals(newForm.getCancerActivity()) ){
 		return false;
 	}

 	if(!oldForm.getGrantsFromCriteria().equals(newForm.getGrantsFromCriteria()) ){
 		return false;
 	}



    return true;

}

}
