package gov.nih.nci.iscs.oracle.pgm.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.*;
import java.text.DateFormat;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.PdAssignmentActionObject;

import gov.nih.nci.iscs.oracle.pgm.service.PDASearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.GrantSearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.actions.helper.GrantSearchResultComparator;
import org.springframework.context.ApplicationContext;
import gov.nih.nci.iscs.oracle.pgm.service.impl.ProgamDirectorServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralListComparator;



/**
 * SelectedGrants is a wrapper class that encapsulated the methods for accessing
 * ReferralSerachResultObject objects selected for Referral Action. This assumes a compleyely built list of 15
 * ReferralSerachResultObject objects.
 *
 * @author Michelle Engermann
 * @version 1.0
 */
public class SelectedGrants implements Cloneable {


    /** identifier field */
    private TreeMap oSelectedGrants;
    private String  oMappingName;
    private HashMap oCancerActivityMap;
    private List oProgramDirectorsList;
    ArrayList oSortSelectedGrants;
    private boolean oSameCAForAll;
    private String oSelectedCA;
    private String[] keys;
    private static Logger logger = LogManager.getLogger(SelectedGrants.class);


    public TreeMap getSelectedGrants() {
		return oSelectedGrants;
	}

    public ArrayList getSortedSelectedGrants() {
		return  oSortSelectedGrants;
	}

    public void setSortedSelectedGrants(ArrayList aSortSelectedGrants) {
		oSortSelectedGrants = aSortSelectedGrants;
	}

    public void setSelectedGrants(TreeMap aSelectedGrants) {
		oSelectedGrants = aSelectedGrants;
	}

    public void setMappingName(String aMappingName) {
		oMappingName = aMappingName;
	}

	public boolean getSameCAForAll() {
		return oSameCAForAll;
	}

	public Map getCancerActivityMap() {
		return oCancerActivityMap;
	}

	public List getProgramDirectorsList() {
		return oProgramDirectorsList;
	}

	public String getSelectedCA() {
		return oSelectedCA;
	}

	public void initKeys() {
		this.keys = new String[oSelectedGrants.size()];
	}
	public void setKey(int index, String key) {
		this.keys[index] = key;
	}

    /**
     * Constructor.  no arguments  constructor
     */
    public SelectedGrants() {
        oSelectedGrants = new TreeMap();
        oSortSelectedGrants = new ArrayList();
    }

    public SelectedGrants(String aMappingName) {
        oSelectedGrants = new TreeMap();
        oMappingName = aMappingName;
        oSortSelectedGrants = new ArrayList();
    }

   /**
    * Constructor - accepts all persistent attributes.
    * should only be used in development only
    */
    public SelectedGrants(TreeMap aSelectedGrants, String aMappingName) {
        this.oSelectedGrants = aSelectedGrants;
        this.oMappingName = aMappingName;
    }

   /**
    * Constructor - accepts all persistent attributes.
    * should only be used in development only
    */
    public SelectedGrants(Map aSelectedGrants, String aMappingName) {
        this.oSelectedGrants = new  TreeMap(aSelectedGrants);
        this.oMappingName = aMappingName;
    }


   /**
    * Sorts the selectedGrants byy the SortIndex
    */
    public void sortSelectedGrants(String sortColumn, boolean sortOrder)  {

        String mKey = null;
	    int sortIndex;

        this.oSortSelectedGrants = new ArrayList(oSelectedGrants.values());
	    //Collections.sort(oSortSelectedGrants, new ReferralListComparator("sortIndex", true));
	    Collections.sort(this.oSortSelectedGrants, new ReferralListComparator(sortColumn, sortOrder));

	}


   /**
    * Add or removes all entries on the page to the Selected Grants List
    */
    public void processPageSelect(Map queryResults, String mAction)  {

        Integer mKey = null;
        Iterator mIterator = queryResults.entrySet().iterator();
        while( mIterator.hasNext() ) {
            Map.Entry entry = (Map.Entry) mIterator.next();
            mKey = (Integer) entry.getKey();
	        GrantSearchResultObject mGrantSearchResultObject = (GrantSearchResultObject) entry.getValue();
			String mSelectedGrantsKey = mGrantSearchResultObject.getApplId().toString() + mGrantSearchResultObject.getCancerActivity();
            if( mAction.equalsIgnoreCase(ApplicationConstants.SELECT_ALL)) {
                if(oMappingName.equalsIgnoreCase("retrieveGrantsForReferralForm")) {
		           ReferralSearchResultObject mReferralSearchResultObject = (ReferralSearchResultObject) mGrantSearchResultObject;
			       this.add(mSelectedGrantsKey, mReferralSearchResultObject);
			    } else {
		           PDASearchResultObject mPDASearchResultObject = (PDASearchResultObject) mGrantSearchResultObject;
			       this.add(mSelectedGrantsKey, mPDASearchResultObject);
			    }
		    } else {
	          this.remove(mSelectedGrantsKey);
		    }
  	     }

    }


   /**
    * Add or removes an entry selected on the page to the Selected Grants List
    */
    public void processItemSelect(Map queryResults, Integer mKey, boolean grantSelected, int sortIndex)  {

       if(oMappingName.equalsIgnoreCase("retrieveGrantsForReferralForm")) {
          ReferralSearchResultObject obj = (ReferralSearchResultObject) queryResults.get(mKey);
          obj.setMarked(false);
	   }

       String mSelectedGrantsKey;
       if(grantSelected) {
          if(oMappingName.equalsIgnoreCase("retrieveGrantsForReferralForm")) {
			 ReferralSearchResultObject mReferralSearchResultObject = (ReferralSearchResultObject) queryResults.get(mKey);
			 mSelectedGrantsKey = mReferralSearchResultObject.getApplId().toString() + mReferralSearchResultObject.getCancerActivity();
		     this.add(mSelectedGrantsKey, mReferralSearchResultObject);
	      } else {
			 PDASearchResultObject mPDASearchResultObject = (PDASearchResultObject) queryResults.get(mKey);
			 mSelectedGrantsKey = mPDASearchResultObject.getApplId().toString() + mPDASearchResultObject.getCancerActivity();
		     this.add(mSelectedGrantsKey, mPDASearchResultObject);
		  }
	   } else {
		   GrantSearchResultObject mGrantSearchResultObject = (GrantSearchResultObject) queryResults.get(mKey);
		   mSelectedGrantsKey = mGrantSearchResultObject.getApplId().toString() + mGrantSearchResultObject.getCancerActivity();
		   this.remove(mSelectedGrantsKey);
	   }

    }

   /**
    * Reset all marked Grants
    */

    public void resetMarked(){
      for (Iterator iterator = oSelectedGrants.entrySet().iterator(); iterator.hasNext();) {
         Map.Entry entry = (Map.Entry) iterator.next();
         GrantSearchResultObject obj = (GrantSearchResultObject) entry.getValue();
         obj.setMarked(false);
      }
    }

   /**
    * Reset all selected Grants
    */

    public void resetSelected()  {

      for (Iterator iterator = oSelectedGrants.entrySet().iterator(); iterator.hasNext();) {
         Map.Entry entry = (Map.Entry) iterator.next();
         GrantSearchResultObject obj = (GrantSearchResultObject) entry.getValue();
         obj.setSelected(false);
      }
    }

   /**
    * Performs steps required before starting PD assignment; returns an error
    *  message indicating error to be displayed
    */
    public Set processForPdAssignmentAction(TreeMap mAssignmentActionObjects) {

     HashSet mErrorMessages = new HashSet();
     this.resetMarked();
     System.out.println("*** in processForPdAssignmentAction and oSelectedGrants is ** " + oSelectedGrants);
     try {
        Iterator iterator = oSelectedGrants.entrySet().iterator();
        int index = 0;
        int dateIndex = 0;
        while (iterator.hasNext()) {
           Map.Entry entry = (Map.Entry) iterator.next();
           String mKey = (String) entry.getKey();
           PDASearchResultObject obj = (PDASearchResultObject) entry.getValue();
           //if(obj.getSelected()){
		   if(obj.getPdId() == null ||
		      obj.getPdId().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING ) ){
		      // do nothing
		   }else{
			   PdAssignmentActionObject actionObj = new PdAssignmentActionObject();
			   actionObj.setApplId(obj.getApplId());
			   actionObj.setPdId(obj.getPdId());
			   actionObj.setCancerActivity(obj.getCancerActivity());
			   actionObj.setAssignmentCA(obj.getAssignmentCA());
			   actionObj.setPdTransferCode(obj.getPdTransferCode());
			   actionObj.setIndex(index);
			   actionObj.setAssignmentDate(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
			   mAssignmentActionObjects.put(new Integer(index), actionObj);
			   index++;
	       }
		   dateIndex++;
	    }
      } catch (Exception ex) {
		logger.error("**** an exception has been generated in processForPdAssignmentAction ***" + ex.toString());

	  }
	    return (Set) mErrorMessages;

      }

   /**
    * Performs steps required before starting referral; returns an error
    *  message indicating error to be displayed
    */
    public String processForReferralAction(String mAction, ApplicationContext mApplicationContext, UserFilterInfo mUserFilterInfo) {

        String mErrorMsg = new String(ApplicationConstants.EMPTY_STRING);
		this.resetMarked();
        Iterator iterator = oSelectedGrants.entrySet().iterator();
        while (iterator.hasNext()) {
           Map.Entry entry = (Map.Entry) iterator.next();
           ReferralSearchResultObject obj = (ReferralSearchResultObject) entry.getValue();

           // check that it is not a dual
           if (obj.getDualPoc() == null  ||
		       obj.getDualPoc().equals("n/a") ||
		       obj.getDualPoc().equals(ApplicationConstants.EMPTY_STRING)) {
               if( mAction.equalsIgnoreCase(ApplicationConstants.RELEASE_DUAL_REFERRAL )) {
			      obj.setMarked(true);
			      mErrorMsg = "errors.referral.action.dual";
		       }
	      } else {
              if( mAction.equalsIgnoreCase(ApplicationConstants.ACCEPT_REFERRAL ) ||
                  mAction.equalsIgnoreCase(ApplicationConstants.REJECT_REFERRAL ) ||
                  mAction.equalsIgnoreCase(ApplicationConstants.REREFER_REFERRAL) ) {
			      obj.setMarked(true);
			      mErrorMsg = "errors.referral.action.non.dual";
		      }
	      }

	      // make sure that CA selected in in MyCancerActivities

	      boolean caMatched = false;
			List myCancerActivities = (List) mUserFilterInfo.getCancerActivityCodes();
	        if(myCancerActivities != null) {
	           Iterator mIterator = myCancerActivities.iterator();
	           while(mIterator.hasNext()){
			      String myCancerActivity = (String) mIterator.next();
	              myCancerActivity = new String(myCancerActivity.replaceAll("'", "") );
			      if(myCancerActivity.trim().equalsIgnoreCase(obj.getCancerActivity() )){
			         caMatched = true;
			         break;
			      }
			   }
			}
			if(!caMatched){
			   obj.setMarked(true);
			   mErrorMsg = "errors.referral.ca.notin.mycanceractivity";
		    }

      }

      if( mAction.equalsIgnoreCase(ApplicationConstants.ACCEPT_REFERRAL )){
		  if(mErrorMsg.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ){
 			this.checkIfSameCA(mApplicationContext);
            if(oSelectedGrants.size() == 1){
				oSameCAForAll = false;
			}
		  }
	  }
      return mErrorMsg;

	}

   /*
    *Check if all the grants are for the same Cancer Activity
    */

    public void checkIfSameCA(ApplicationContext mApplicationContext) {

        // sort using the suppiled comparator by Year
        TreeSet mCancerActivitySet = new TreeSet();
		// Iterate through the sorted list
        Iterator iterator = oSelectedGrants.entrySet().iterator();

		while (iterator.hasNext() ) {
           Map.Entry entry = (Map.Entry) iterator.next();
           GrantSearchResultObject obj = (GrantSearchResultObject) entry.getValue();
			mCancerActivitySet.add((Object) obj.getCancerActivity());
		}

		if(mCancerActivitySet.size() > 1){
		   oSameCAForAll = false;
		   oSelectedCA = ApplicationConstants.EMPTY_STRING;
	    } else {
		   oSameCAForAll = true;
		   oSelectedCA = (String) mCancerActivitySet.first();
	    }

        oCancerActivityMap = new HashMap();
        iterator = mCancerActivitySet.iterator();

        ProgamDirectorServiceImpl mProgamDirectorServiceImpl =  new ProgamDirectorServiceImpl(mApplicationContext);
		while (iterator.hasNext() ) {
			// get the lookup infomation
		   String cancerActivity = (String) iterator.next();
	       List mList  = mProgamDirectorServiceImpl.getProgamDirectorForCA(cancerActivity.toUpperCase());
           oCancerActivityMap.put(cancerActivity.toUpperCase(), mList);
	    }
	    oProgramDirectorsList  = mProgamDirectorServiceImpl.getProgamDirectorForAllCAs(mCancerActivitySet);


	}

   /**
    * Performs steps required before starting referral; returns an error
    *  message indicating error to be displayed
    */
    //public void processKeyForPDAssignmentAction(String mKey, String pdAssignmentStartDate, boolean mSelected) {
    public void processKeyForPDAssignmentAction(String mKey, boolean mSelected) {


		PDASearchResultObject mPDASearchResultObject = (PDASearchResultObject) oSelectedGrants.get(mKey);
        mPDASearchResultObject.setSelected(mSelected);

        //mPDASearchResultObject.setPdAssignmentStartDate(pdAssignmentStartDate);
    }
   /**
    * Performs steps required before starting referral; returns an error
    *  message indicating error to be displayed
    */
    //public void processKeyForPDAssignmentAction(String mKey, String pdAssignmentStartDate, boolean mSelected) {
    public void processKeyForPortfolioAssignmentAction(String mPdId, String mAssignmentCA) {


      for (Iterator iterator = oSelectedGrants.entrySet().iterator(); iterator.hasNext();) {
         Map.Entry entry = (Map.Entry) iterator.next();
         PDASearchResultObject mPDASearchResultObject = (PDASearchResultObject) entry.getValue();
         mPDASearchResultObject.setSelected(true);
		 mPDASearchResultObject.setPdId(mPdId);
         mPDASearchResultObject.setAssignmentCA(mAssignmentCA);
      }
    }


   /**
    * Performs steps required before starting referral; returns an error
    *  message indicating error to be displayed
    */
    public void processPdForPDAssignmentAction(String mPdId, String mAssignmentCA, String mKey, boolean mSelected, String pdIdForLoad) {

		try{
           PDASearchResultObject mPDASearchResultObject= (PDASearchResultObject) oSelectedGrants.get(mKey);;
           //if(!mSelected) {
		   if(mPDASearchResultObject.getSelected()){
		      if(pdIdForLoad==null || pdIdForLoad.trim().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ) {
                 mPDASearchResultObject.setPdId(mPdId);
                 mPDASearchResultObject.setAssignmentCA(mAssignmentCA);
		      }
	      }else {
		     mPDASearchResultObject.setPdId(mPdId);
             mPDASearchResultObject.setAssignmentCA(mAssignmentCA);
	      }
      } catch (Exception ex) {
		logger.error("**** an exception has been generated in processPdForPDAssignmentAction ***" + ex.toString());
	  }


    }

   /**
    * Performs steps required before starting referral; returns an error
    *  message indicating error to be displayed
    */
    public String processLoadForPDAssignmentAction(String mPdId, String mAssignmentCA) {

        String mErrorMsg = ApplicationConstants.EMPTY_STRING;
        resetMarked();
        Iterator iterator = oSelectedGrants.entrySet().iterator();
        while  (iterator.hasNext()) {
           Map.Entry entry = (Map.Entry) iterator.next();
           String mKey = (String) entry.getKey();
           PDASearchResultObject mPDASearchResultObject = (PDASearchResultObject) entry.getValue();
		   if(mPDASearchResultObject.getSelected() ){
			  mPDASearchResultObject.setPdId(mPdId);
              mPDASearchResultObject.setAssignmentCA(mAssignmentCA);
		   }

	    }

	    return mErrorMsg;
    }


   /*
    *Check if the Map is empty
    */

    public boolean isEmpty(){
	    if (oSelectedGrants.size() > 0) {
			return false;
		} else {
			return true;
		}
	}



   /**
    * Add new entries to the List of SelectedGrants
    */

    public void add(Object key, Object value){
		oSelectedGrants.put(key, value);
	}

   /**
    * remove an entry from the List of SelectedGrants
    */

    public void remove(Object key){
		oSelectedGrants.remove(key);
	}

   /**
    * retruns an item in the map
    */

    public Object get(Object key){
       if(oMappingName.equalsIgnoreCase("retrieveGrantsForReferralForm")) {
          return (ReferralSearchResultObject) oSelectedGrants.get(key);
       } else {
          return (PDASearchResultObject) oSelectedGrants.get(key);
	   }
	}

}
