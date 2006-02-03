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

             mQueryResults = mapPDASearchResults((List) mQueryPage.getPageList());
         } catch (Exception ex) {
			 throw new ServiceImplException("PDAssignmentServiceImpl", "search", "An exception occurred in grants retrieval process!!! " + ex.toString());
 	     }

	     return  mQueryResults;
      }



    private Map mapPDASearchResults(List aNciPdQueryList) {

		HashMap mQueryResults = new HashMap();
		Iterator mIterator = aNciPdQueryList.iterator();
	    int mIndex = 1;
	    String mKey = null;
		while (mIterator.hasNext() ) {
			NciPdQueryVw mNciPdQuery = (NciPdQueryVw) mIterator.next();
		    PDASearchResultObject mPDASearchResultObject = new PDASearchResultObject();
			if(mNciPdQuery.getFullGrantNum() != null) {
				mPDASearchResultObject.setGrantNumber(mNciPdQuery.getFullGrantNum() );
			}else {
				mPDASearchResultObject.setGrantNumber(ApplicationConstants.EMPTY_STRING);
			}

			if(mNciPdQuery.getCayCode() != null) {
				mPDASearchResultObject.setCancerActivity(mNciPdQuery.getCayCode() );
			}else {
				mPDASearchResultObject.setCancerActivity(ApplicationConstants.EMPTY_STRING );
			}


			mPDASearchResultObject.setSelected(false);

			if(mNciPdQuery.getPdFullName() != null) {
				mPDASearchResultObject.setPdFullName(mNciPdQuery.getPdFullName() );
			}else {
				mPDASearchResultObject.setPdFullName(ApplicationConstants.EMPTY_STRING);
			}


			if(mNciPdQuery.getPdOrgName() != null) {
				mPDASearchResultObject.setPdOrg(mNciPdQuery.getPdOrgName() );
			}else {
				mPDASearchResultObject.setPdOrg(ApplicationConstants.EMPTY_STRING);
			}

			if(mNciPdQuery.getFy() != null) {
				mPDASearchResultObject.setFy(mNciPdQuery.getFy().toString() );
			}else {
				mPDASearchResultObject.setFy(ApplicationConstants.EMPTY_STRING);
			}

			if(mNciPdQuery.getCouncilMeetingDate() != null) {
				mPDASearchResultObject.setNcabDate(mNciPdQuery.getCouncilMeetingDate().substring(4,6) + "/" + mNciPdQuery.getCouncilMeetingDate().substring(0,4) );
			}else {
				mPDASearchResultObject.setNcabDate(ApplicationConstants.EMPTY_STRING);
			}


			if(mNciPdQuery.getPdStartDate() != null) {
				mPDASearchResultObject.setPdStartDate(mNciPdQuery.getPdStartDate());
			}

			if(mNciPdQuery.getPdTransferInitialCode() != null) {
				mPDASearchResultObject.setPdTransferCode(mNciPdQuery.getPdTransferInitialCode() );
			}else {
				mPDASearchResultObject.setPdTransferCode(ApplicationConstants.EMPTY_STRING);
			}

		    mPDASearchResultObject.setApplId(mNciPdQuery.getApplId() );
			mPDASearchResultObject.setSelected(false);
			mKey = mPDASearchResultObject.getApplId() + mPDASearchResultObject.getCancerActivity();
			mQueryResults.put(new Integer(mIndex), mPDASearchResultObject);
            mIndex++;
	    }

		return  (Map) mQueryResults;
	}


}