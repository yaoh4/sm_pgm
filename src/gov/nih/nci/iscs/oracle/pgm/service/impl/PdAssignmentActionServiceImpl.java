package gov.nih.nci.iscs.oracle.pgm.service.impl;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

import gov.nih.nci.iscs.oracle.pgm.service.impl.BaseServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.service.PdAssignmentActionService;
import gov.nih.nci.iscs.oracle.pgm.service.PdAssignmentActionObject;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.AssignPDCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveGrantInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.hibernate.NciPdQueryVw;
import gov.nih.nci.iscs.oracle.pgm.hibernate.*;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

    /**
     * ReferralActionServiceImpl provides implementation of referral activities
     *
     * @see gov.nih.nci.iscs.oracle.pgm.service.ReferralActionService
     * @author Michelle Engermann
     * @version 1.0
     */
public class PdAssignmentActionServiceImpl extends BaseServiceImpl implements PdAssignmentActionService {

   /** Logger for this class and subclasses */
    static Logger logger = LogManager.getLogger(PdAssignmentActionServiceImpl.class);
    public static final String SUCCESS_LITERAL = "SUCCESS";
    private Map pdAssignmentActionGrants;
    private PdAssignmentActionObject pdAssignmentActionObject;
    private AssignPDCommand assignPDCommand;



    /*
     * Class constructor
     * @param Map - grants selected for Referral Action
     * @param Object - oContextFactory
     * @throws SQLException
     */
    public PdAssignmentActionServiceImpl(Map pdAssignmentActionGrants, Object oContextFactory, String aUserId ) {
		super(oContextFactory, aUserId);
		this.pdAssignmentActionGrants = pdAssignmentActionGrants;
		this.pdAssignmentActionObject = new PdAssignmentActionObject();
	}

    public Map getPdAssignmentActionGrants() {
		return pdAssignmentActionGrants;
	}

    /*
     * Executes the request to the CommandDao to perform rerefer action
     * @return boolean  - pass/fail
     */
    public boolean performPdAssignment(String action) {

 		 boolean mResults = false;
 		 try{

			 if( action.equalsIgnoreCase("assign") ) {
		         assignPDCommand = (AssignPDCommand) getBean("assignPDCommandDao");
			 }
			 ArrayList grantList = new ArrayList(pdAssignmentActionGrants.values());
			 Iterator  mIterator = grantList.iterator();
			 while (mIterator.hasNext() ){
				 boolean mAssignmentResults = false;
				 pdAssignmentActionObject = (PdAssignmentActionObject) mIterator.next();
                 if(action.equalsIgnoreCase("assign")){
                    mAssignmentResults = assign();
			        mResults = performRequery(mAssignmentResults);
				 }

			 }
         } catch (Exception ex) {
			 throw new ServiceImplException("PdAssignmentActionServiceImpl", "performPdAssignment", "An exception occurred in PD Assignment process!!! " + ex.toString());
 	     }

	     return true;
	 }


    /*
     * Perform the Program Director Assignment
     * @return boolean  - pass/fail
     */
     private boolean assign() {

 		 boolean mResults = false;
 		 try{
			 String actionResult = new String();
   			 actionResult = (String) assignPDCommand.execute(pdAssignmentActionObject.getApplId(),
   			                         new Long(pdAssignmentActionObject.getPdId()),
   			                         new String(pdAssignmentActionObject.getAssignmentCA()),
   			                         pdAssignmentActionObject.getAssignmentDate(),
   			                         pdAssignmentActionObject.getPdTransferCode(),
   			                         super.getUserId());
             pdAssignmentActionObject.setResults(actionResult);
			 if(actionResult.trim().equalsIgnoreCase(SUCCESS_LITERAL)){
                mResults = true;
			 }
         } catch (Exception ex) {
			 throw new ServiceImplException("PdAssignmentActionServiceImpl", "assign", "An exception occurred in Assign PD process!!! " + ex.toString());
 	     }

	     return mResults;
      }

    /*
     * Requeries the database for the grant detail
     * @return boolean  - pass/fail
     */
     private boolean performRequery(boolean actionPassed) {

		 boolean mResults = false;
		 String cancerActivity = new String(ApplicationConstants.EMPTY_STRING);
	     NciPdQueryVw mNciPdQueryVw = null;
         if(actionPassed) {
			cancerActivity = pdAssignmentActionObject.getAssignmentCA();
		 } else {
			cancerActivity = pdAssignmentActionObject.getCancerActivity();
		 }

		 mNciPdQueryVw = requeryGrant(pdAssignmentActionObject.getApplId(), cancerActivity);
         if(mNciPdQueryVw != null) {
			pdAssignmentActionObject.setCancerActivity(ApplicationConstants.EMPTY_STRING);
			if(mNciPdQueryVw.getCayCode() != null )
			    pdAssignmentActionObject.setCancerActivity(mNciPdQueryVw.getCayCode());
			pdAssignmentActionObject.setProgramDirector(ApplicationConstants.EMPTY_STRING);
			if(mNciPdQueryVw.getPdFullName() != null )
			    pdAssignmentActionObject.setProgramDirector(mNciPdQueryVw.getPdFullName());
			pdAssignmentActionObject.setGrantNumber(ApplicationConstants.EMPTY_STRING);
			if(mNciPdQueryVw.getFullGrantNum() != null )
			   pdAssignmentActionObject.setGrantNumber(mNciPdQueryVw.getFullGrantNum());
		    mResults = true;
		 }

		 return mResults;

	 }
    /*
     * Get the POC for the Cancer Activity
     * @return String  - POC
     */
     public NciPdQueryVw requeryGrant(Long aApplId, String cancerActivity) {
         NciPdQueryVw mNciPdQueryVw;
 		 String mPoc = new String(ApplicationConstants.EMPTY_STRING);
 		 if(cancerActivity.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ) {
			 cancerActivity = null;
		 }
	     try{
	         RetrieveGrantInfoCommand mRetrieveGrantInfoCommand = (RetrieveGrantInfoCommand) getBean("retrieveGrantInfoCommandDao");
		     QueryPage mQueryPage = mRetrieveGrantInfoCommand.execute(aApplId, cancerActivity, super.getUserId());
		     List mList = mQueryPage.getPageList();
		     mNciPdQueryVw = (NciPdQueryVw) mList.get(0);
         } catch (Exception ex) {
			 throw new ServiceImplException("PdAssignmentActionServiceImpl", "requeryGrant", "An exception occurred in the reQuery process!!! " + ex.toString());
 	     }

 	     return  mNciPdQueryVw;

	 }


}