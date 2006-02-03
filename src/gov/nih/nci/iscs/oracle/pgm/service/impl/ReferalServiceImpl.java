package gov.nih.nci.iscs.oracle.pgm.service.impl;

import java.util.*;

import gov.nih.nci.iscs.oracle.pgm.service.impl.BaseServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.service.GrantSearchService;
import gov.nih.nci.iscs.oracle.pgm.service.GrantSearchObject;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralQueryObject;
import gov.nih.nci.iscs.oracle.pgm.service.GrantQueryObject;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.forms.PaginationObject;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveGrantsForReferalCommand;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.hibernate.*;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralListComparator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ReferalServiceImpl extends BaseServiceImpl implements GrantSearchService {
    /**
     * ReferalServiceImpl. This class provides the implementation of core
     *  methods for the Grant Referral process
     *
     * @see gov.nih.nci.iscs.oracle.pgm.service.GrantSearchService
     * @author Michelle Engermann
     * @version 1.0
     */

    static Logger logger = LogManager.getLogger(ReferalServiceImpl.class);
    public static HashMap columnMethodMap;
       // Here's a static initializer that fills in the hashtable
       static {
       columnMethodMap = new HashMap();
       columnMethodMap.put("grantNumber", "getFullGrantNum");
       columnMethodMap.put("default", "getFullGrantNum");
       columnMethodMap.put("cayCode", "getCayCode");
       columnMethodMap.put("dualCayCode", "getDualCayCode");
       columnMethodMap.put("lastName", "getLastName");
       columnMethodMap.put("orgName", "getOrgName");
       columnMethodMap.put("projectTitle", "getProjectTitle");
       columnMethodMap.put("araStatusCode", "getAraStatusCode");
       columnMethodMap.put("councilMeetingDate", "getCouncilMeetingDate");
       columnMethodMap.put("currentReferralActivityDate", "getCurrentReferralActivityDate");
      }


    /*
     * Class constructor
     * @param oContextFactory - The Context Factory
     */
    public ReferalServiceImpl(Object oContextFactory ) {
		super(oContextFactory);
	}


    /*
     * Gets the RetrieveGrantsForReferalCommand object from the factory and executes
     *  the search
     * @retrun Map of search results keyed by ApplId
     * @param aGrantQueryObject - the GrantQueryObject containg the search criteris
     * @param aPaginationObject - the PaginationObject for paging
     * @param aUserFilterInfo - the UserFilterInfo
     */
    public Map search(GrantQueryObject aGrantQueryObject, PaginationObject aPaginationObject, UserFilterInfo aUserFilterInfo) {

 		 Map mQueryResults = null;
 		 try{
	         ReferralQueryObject aReferralQueryObject = (ReferralQueryObject) aGrantQueryObject;
		     RetrieveGrantsForReferalCommand oRetrieveGrantsForReferalCommand = (RetrieveGrantsForReferalCommand) getBean("retrieveGrantsForReferalCommandDao");

             QueryPage mQueryPage = oRetrieveGrantsForReferalCommand.execute(aUserFilterInfo,
                                             aReferralQueryObject,
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
	         Collections.sort((List) mQueryPage.getPageList(), new ReferralListComparator(null, sortAscendingIndicator, methodName));

             mQueryResults = mapReferralSearchResults((List) mQueryPage.getPageList(), aPaginationObject);
         } catch (Exception ex) {
			 logger.error("An exception occurred in grants retrieval process!!! " + ex.toString());
 	         throw new GrantSearchException("ReferalServiceImpl", "search", "An exception occurred in grants retrieval process!!! ");
 	     }

	     return  mQueryResults;
    }


    /*
     * Map the query results to the ReferralSearchResultObject
     * Add enties to a hashMap by applId
     * @retrun Map of search results keyed by ApplId
     * @param aGrantList - aNciPdQueryList the search result
     */
    private Map mapReferralSearchResults(List aNciPdQueryList, PaginationObject aPaginationObject) throws Exception{

		TreeMap mQueryResults = new TreeMap();
		Iterator mIterator = aNciPdQueryList.iterator();
		String mKey = null;
		int mIndex = 1;
		int pageNumber = aPaginationObject.getPageNumber().intValue();
		while (mIterator.hasNext() ) {
			NciPdQueryVw mNciPdQuery = (NciPdQueryVw) mIterator.next();
		    ReferralSearchResultObject mReferralSearchResultObject = new ReferralSearchResultObject();
			if(mNciPdQuery.getFullGrantNum() != null ) {
				mReferralSearchResultObject.setGrantNumber(mNciPdQuery.getFullGrantNum() );
			} else {
				mReferralSearchResultObject.setGrantNumber(ApplicationConstants.EMPTY_STRING );
			}

			if(mNciPdQuery.getOrgName() != null ) {
				mReferralSearchResultObject.setInstName(mNciPdQuery.getOrgName() );
			} else {
				mReferralSearchResultObject.setInstName(ApplicationConstants.EMPTY_STRING );
			}

			if(mNciPdQuery.getLastName() != null ) {
				mReferralSearchResultObject.setPiLastName(mNciPdQuery.getLastName() );
			} else {
				mReferralSearchResultObject.setPiLastName(ApplicationConstants.EMPTY_STRING );
			}

			if(mNciPdQuery.getProjectTitle() != null ) {
				mReferralSearchResultObject.setProjectTitle(mNciPdQuery.getProjectTitle() );
			} else {
				mReferralSearchResultObject.setProjectTitle(ApplicationConstants.EMPTY_STRING );
			}

			if(mNciPdQuery.getCayCode() != null ) {
				mReferralSearchResultObject.setCancerActivity(mNciPdQuery.getCayCode() );
			} else {
				mReferralSearchResultObject.setCancerActivity(ApplicationConstants.EMPTY_STRING );
			}

			if(mNciPdQuery.getAraMatchFlag() != null ) {
				mReferralSearchResultObject.setAraStatus(mNciPdQuery.getAraMatchFlag());
			} else {
				mReferralSearchResultObject.setAraStatus(ApplicationConstants.EMPTY_STRING);
			}

			if(mNciPdQuery.getDualCayCode() != null ) {
				mReferralSearchResultObject.setDualCA(mNciPdQuery.getDualCayCode() );
			} else {
				mReferralSearchResultObject.setDualCA(ApplicationConstants.EMPTY_STRING);
			}

			if((mNciPdQuery.getDualPocLastName() != null ) &&
			   (mNciPdQuery.getDualPocFirstName() != null ) ) {
				mReferralSearchResultObject.setDualPoc(mNciPdQuery.getDualPocLastName() + ", " + mNciPdQuery.getDualPocFirstName());
			} else {
				mReferralSearchResultObject.setDualPoc(ApplicationConstants.EMPTY_STRING );
			}


			if(mNciPdQuery.getPocFullName() != null )  {
				mReferralSearchResultObject.setCurrentPoc(mNciPdQuery.getPocFullName());
			} else {
				mReferralSearchResultObject.setCurrentPoc(ApplicationConstants.EMPTY_STRING );
			}

			if(mNciPdQuery.getPdFullName() != null ) {
				mReferralSearchResultObject.setPdFullName(mNciPdQuery.getPdFullName() );
			} else {
				mReferralSearchResultObject.setPdFullName(ApplicationConstants.EMPTY_STRING);
			}

			if(mNciPdQuery.getCouncilMeetingDate() != null ) {
				mReferralSearchResultObject.setNcabDate(mNciPdQuery.getCouncilMeetingDate().substring(4,6) + "/"  + mNciPdQuery.getCouncilMeetingDate().substring(0,4) );
			} else {
				mReferralSearchResultObject.setNcabDate(ApplicationConstants.EMPTY_STRING);
			}

			if(mNciPdQuery.getCurrentReferralActivityDate() != null ) {
				String temp = mNciPdQuery.getCurrentReferralActivityDate().toString();
				mReferralSearchResultObject.setCurrentReferralActivityDate(temp.substring(5,7) + "/" + temp.substring(8,10) + "/" + temp.substring(0,4) );
			} else {
				mReferralSearchResultObject.setCurrentReferralActivityDate(ApplicationConstants.EMPTY_STRING);
			}

			mReferralSearchResultObject.setWithdrawn(false);
			if(mNciPdQuery.getWithdrawnFlag() != null ) {
				if(mNciPdQuery.getWithdrawnFlag().trim().equalsIgnoreCase("Y")) {
				   mReferralSearchResultObject.setWithdrawn(true);
			    }
			}

			mReferralSearchResultObject.setReReferred(false);
			if(mNciPdQuery.getCurrentReferralActivityCode() != null ) {
				if(mNciPdQuery.getCurrentReferralActivityCode().trim().equalsIgnoreCase("REREF")) {
				   mReferralSearchResultObject.setReReferred(true);
			    }
			}

			String mEgrantsNumber = null;
			if(mNciPdQuery.getAdminPhsOrgCode() == null ||
			   mNciPdQuery.getSerialNum() == null ||
			   mNciPdQuery.getSupportYear() == null) {
   		       mEgrantsNumber = ApplicationConstants.EMPTY_STRING;
			} else {
				 String supportYear = mNciPdQuery.getSupportYear().toString();
				 int supportYearLen = supportYear.length();
				 while (supportYearLen < 2) {
					 supportYear = "0" + supportYear;
					 supportYearLen = supportYear.length();
				 }

				 String serialNum = mNciPdQuery.getSerialNum().toString();
				 int  serialNumLen = serialNum.length();
				 while (serialNumLen < 6) {
					 serialNum = "0" + serialNum;
					 serialNumLen = serialNum.length();
				 }
				 mEgrantsNumber = mNciPdQuery.getAdminPhsOrgCode() +  serialNum + "-" + supportYear;
			}
			mReferralSearchResultObject.setEGrantsNumber(mEgrantsNumber);


		    mReferralSearchResultObject.setApplId(mNciPdQuery.getApplId() );

			mReferralSearchResultObject.setSelected(false);
			mReferralSearchResultObject.setSortIndex(mIndex * pageNumber);
			mKey = mReferralSearchResultObject.getApplId() + mReferralSearchResultObject.getCancerActivity();
			mQueryResults.put(new Integer(mIndex), mReferralSearchResultObject);
            mIndex++;
	    }

		return  (Map) mQueryResults;
	}


}