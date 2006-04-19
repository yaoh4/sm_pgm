package gov.nih.nci.iscs.oracle.pgm.service.impl;

import java.util.*;


import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.impl.BaseServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.service.GrantSearchService;
import gov.nih.nci.iscs.oracle.pgm.service.GrantSearchObject;
import gov.nih.nci.iscs.oracle.pgm.service.PDAQueryObject;
import gov.nih.nci.iscs.oracle.pgm.service.GrantQueryObject;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.forms.PaginationObject;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveGrantsForPDACommand;
import gov.nih.nci.iscs.oracle.pgm.service.PDASearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralListComparator;
import gov.nih.nci.iscs.oracle.pgm.hibernate.*;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * A jdbc implementation of the UserHandler interface.
 * @author Oracle
 */
public class PDAssignmentServiceImpl extends BaseServiceImpl implements GrantSearchService  {

    static Logger logger = LogManager.getLogger(PDAssignmentServiceImpl.class);
    public static HashMap columnMethodMap;
       // Here's a static initializer that fills in the hashtable
       static {
       columnMethodMap = new HashMap();
       columnMethodMap.put("grantNumber", "getFullGrantNum");
       columnMethodMap.put("default", "getFullGrantNum");
       columnMethodMap.put("cayCode", "getCayCode");
       columnMethodMap.put("pdFullName", "getPdFullName");
       columnMethodMap.put("lastName", "getLastName");
       columnMethodMap.put("fy", "getFy");
       columnMethodMap.put("projectTitle", "getProjectTitle");
       columnMethodMap.put("pdStartDate", "getPdStartDate");
       columnMethodMap.put("councilMeetingDate", "getCouncilMeetingDate");
       columnMethodMap.put("rfaPaNumber", "getRfaPaNumber");
      }



    public PDAssignmentServiceImpl(Object oContextFactory ) {
		super(oContextFactory);
	}

     public Map search(GrantQueryObject aGrantQueryObject, PaginationObject aPaginationObject, UserFilterInfo aUserFilterInfo) {

 		 Map mQueryResults = null;
 		 try{
			 PDAQueryObject aPDAQueryObject = (PDAQueryObject) aGrantQueryObject;
		     RetrieveGrantsForPDACommand oRetrieveGrantsForPDACommand = (RetrieveGrantsForPDACommand) getBean("retrieveGrantsForPDACommandDao");
             QueryPage mQueryPage = oRetrieveGrantsForPDACommand.execute(aUserFilterInfo,
                                             aPDAQueryObject,
                                             aPaginationObject.getPageNumber().intValue(),
                                             aPaginationObject.getPageSize().intValue(),
                                             super.getUserId());

             mapPaginationObject(mQueryPage, aPaginationObject);

             String sortColumn = aGrantQueryObject.getSortColumn();
             String methodName = (String) columnMethodMap.get(sortColumn);
             if(sortColumn == null || methodName == null ) {
				 sortColumn = "default";
				 methodName = "getFullGrantNum";
			 }
             boolean sortAscendingIndicator = false;
             if(aGrantQueryObject.getSortOrder().equalsIgnoreCase(ApplicationConstants.SORT_ASC)){
				 sortAscendingIndicator = true;
			 }

	  		 if(sortColumn.equalsIgnoreCase("default") ||
	  		    sortColumn.equalsIgnoreCase("fullGrantNum") ||
	  		    sortColumn.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ||
	  		    sortColumn.equalsIgnoreCase("grantNumber")){
	  		 }else{
	  	        Collections.sort((List) mQueryPage.getPageList(), new ReferralListComparator(null, sortAscendingIndicator, methodName));
	  		 }

             mQueryResults = mapPDASearchResults((List) mQueryPage.getPageList());
         } catch (Exception ex) {
			 throw new ServiceImplException("PDAssignmentServiceImpl", "search", "An exception occurred in grants retrieval process!!! " + ex.toString());
 	     }

	     return  mQueryResults;
      }



    private Map mapPDASearchResults(List aNciPdTransferList) {

		TreeMap mQueryResults = new TreeMap();
		Iterator mIterator = aNciPdTransferList.iterator();

	    int mIndex = 1;
	    String mKey = null;
		while (mIterator.hasNext() ) {
			NciPdTransferVw mNciPdTransfer = (NciPdTransferVw) mIterator.next();
		    PDASearchResultObject mPDASearchResultObject = new PDASearchResultObject();
			if(mNciPdTransfer.getFullGrantNum() != null) {
				mPDASearchResultObject.setGrantNumber(mNciPdTransfer.getFullGrantNum() );
			}else {
				mPDASearchResultObject.setGrantNumber(ApplicationConstants.EMPTY_STRING);
			}

			if(mNciPdTransfer.getCayCode() != null) {
				mPDASearchResultObject.setCancerActivity(mNciPdTransfer.getCayCode() );
			}else {
				mPDASearchResultObject.setCancerActivity(ApplicationConstants.EMPTY_STRING );
			}


			mPDASearchResultObject.setSelected(false);

			if(mNciPdTransfer.getPdFullName() != null) {
				mPDASearchResultObject.setPdFullName(mNciPdTransfer.getPdFullName() );
			}else {
				mPDASearchResultObject.setPdFullName(ApplicationConstants.EMPTY_STRING);
			}


			if(mNciPdTransfer.getLastName() != null) {
				mPDASearchResultObject.setPiName(mNciPdTransfer.getLastName() + " " + mNciPdTransfer.getFirstName());
			}else {
				mPDASearchResultObject.setPiName(ApplicationConstants.EMPTY_STRING);
			}

			if(mNciPdTransfer.getFy() != null) {
				mPDASearchResultObject.setFy(mNciPdTransfer.getFy().toString() );
			}else {
				mPDASearchResultObject.setFy(ApplicationConstants.EMPTY_STRING);
			}

			if(mNciPdTransfer.getCouncilMeetingDate() != null ){
			   try{
				  mPDASearchResultObject.setNcabDate(mNciPdTransfer.getCouncilMeetingDate().substring(4,6) + "/" + mNciPdTransfer.getCouncilMeetingDate().substring(0,4) );
			   }catch(StringIndexOutOfBoundsException ex){
				   mPDASearchResultObject.setNcabDate(ApplicationConstants.EMPTY_STRING);
			   }
			}else {
				mPDASearchResultObject.setNcabDate(ApplicationConstants.EMPTY_STRING);
			}

			if(mNciPdTransfer.getRfaPaNumber() != null) {
				mPDASearchResultObject.setRfaPaNumber(mNciPdTransfer.getRfaPaNumber() );
			}else {
				mPDASearchResultObject.setRfaPaNumber(ApplicationConstants.EMPTY_STRING);
			}


			if(mNciPdTransfer.getPdStartDate() != null) {
				mPDASearchResultObject.setPdStartDate(mNciPdTransfer.getPdStartDate());
			}

			if(mNciPdTransfer.getPdTransferInitialCode() != null) {
				mPDASearchResultObject.setPdTransferCode(mNciPdTransfer.getPdTransferInitialCode() );
			}else {
				mPDASearchResultObject.setPdTransferCode(ApplicationConstants.EMPTY_STRING);
			}

		    mPDASearchResultObject.setApplId(new Long(mNciPdTransfer.getApplId() ));
			mPDASearchResultObject.setSelected(false);
			mKey = mPDASearchResultObject.getApplId() + mPDASearchResultObject.getCancerActivity();
			mPDASearchResultObject.setKey(mKey);
			mQueryResults.put(new Integer(mIndex), mPDASearchResultObject);
            mIndex++;
	    }

		return  (Map) mQueryResults;
	}


}