package gov.nih.nci.iscs.oracle.pgm.service.impl;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

import gov.nih.nci.iscs.oracle.pgm.service.impl.BaseServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralActionService;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralActionObject;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.AcceptReferalCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RejectReferalCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.ReleaseReferalCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.ReReferReferalCommand;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveGrantInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.hibernate.NciPdReferralVw;
import gov.nih.nci.iscs.oracle.pgm.hibernate.NciPdTransferVw;
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
public class ReferralActionServiceImpl extends BaseServiceImpl implements ReferralActionService {

   /** Logger for this class and subclasses */
    static Logger logger = LogManager.getLogger(ReferalServiceImpl.class);
    public static final String SUCCESS_LITERAL = "SUCCESS";
    private Map referralActionGrants;
    private ReferralActionObject referralActionObject;
    private ReReferReferalCommand reReferReferalCommand;
    private AcceptReferalCommand acceptReferalCommand;
    private RejectReferalCommand rejectReferalCommand;
    private ReleaseReferalCommand releaseReferalCommand;
    private String oAction;



    /*
     * Class constructor
     * @param Map - grants selected for Referral Action
     * @param Object - oContextFactory
     * @throws SQLException
     */
    public ReferralActionServiceImpl(Map referralActionGrants, Object oContextFactory, String aUserId ) {
		super(oContextFactory, aUserId);
		this.referralActionGrants = referralActionGrants;
		this.referralActionObject = new ReferralActionObject();
	}

    public Map getReferralActionGrants() {
		return referralActionGrants;
	}

    /*
     * Executes the request to the CommandDao to perform accpet action
     * @return boolean  - pass/fail
     */
     private boolean accept() {

 		 boolean mResults = false;
 		 try{
			 String actionResult = new String();
   			 actionResult = (String) acceptReferalCommand.execute(referralActionObject.getApplId(), new Long(referralActionObject.getPdId()), super.getUserId() );
             referralActionObject.setResults(actionResult);
			 if(actionResult.trim().equalsIgnoreCase(SUCCESS_LITERAL)){
                mResults = true;
			 }
         } catch (NumberFormatException ex) {
			 logger.error(" Unable to process accept for " + referralActionObject.getApplId() + " " + ex.toString());
		 } catch (Exception ex) {
			 throw new ServiceImplException("ReferralActionServiceImpl", "accept", "An exception occurred in Accept Referral process!!! " + ex.toString());
 	     }

	     return mResults;
      }
    /*
     * Executes the request to the CommandDao to perform reject action
     * @return boolean  - pass/fail
     */
     private boolean reject() {

 		 boolean mResults = false;
 		 try{
   		     String actionResult = new String();
			 actionResult = (String) rejectReferalCommand.execute(referralActionObject.getApplId(), referralActionObject.getComments(), super.getUserId());
             referralActionObject.setResults(actionResult);
			 if(actionResult.trim().equalsIgnoreCase(SUCCESS_LITERAL)){
                mResults = true;
			 }
         } catch (Exception ex) {
			 throw new ServiceImplException("ReferralActionServiceImpl", "reject", "An exception occurred in Reject Referral process!!! " + ex.toString());
 	     }

	     return mResults;
      }
    /*
     * Executes the request to the CommandDao to perform release action
     * @return boolean  - pass/fail
     */
     private boolean release() {

 		 boolean mResults = false;
 		 try{

			 String actionResult = new String();
			 actionResult = (String) releaseReferalCommand.execute(referralActionObject.getApplId(), referralActionObject.getCancerActivity(), super.getUserId());
             referralActionObject.setResults(actionResult);
			 if(actionResult.trim().equalsIgnoreCase(SUCCESS_LITERAL)){
                mResults = true;
			 }
         } catch (Exception ex) {
			 throw new ServiceImplException("ReferralActionServiceImpl", "release", "An exception occurred in Reject Release process!!! " + ex.toString());
 	     }

	     return mResults;
      }

    /*
     * Executes the request to the CommandDao to perform rerefer action
     * @return boolean  - pass/fail
    */
    public boolean performReferral(String action) {

 		 boolean mResults = false;
 		 try{

			 if( action.equalsIgnoreCase("accept") ) {
		         acceptReferalCommand = (AcceptReferalCommand) getBean("acceptReferalCommandDao");
			 }
			 if( action.equalsIgnoreCase("reject") ) {
		         rejectReferalCommand = (RejectReferalCommand) getBean("rejectReferalCommandDao");
			 }
			 if( action.equalsIgnoreCase("rerefer") ) {
		         reReferReferalCommand = (ReReferReferalCommand) getBean("reReferReferalCommandDao");
			 }
			 if( action.equalsIgnoreCase("release") ) {
		         releaseReferalCommand = (ReleaseReferalCommand) getBean("releaseReferalCommandDao");
			 }

			 ArrayList grantList = new ArrayList(referralActionGrants.values());
			 Iterator  mIterator = grantList.iterator();
			 while (mIterator.hasNext() ){
				 boolean mReferralResults = false;
				 referralActionObject = (ReferralActionObject) mIterator.next();
                 if(action.equalsIgnoreCase("accept"))
                    mReferralResults = accept();

                 if(action.equalsIgnoreCase("reject"))
                    mReferralResults = reject();

                 if(action.equalsIgnoreCase("rerefer"))
                    mReferralResults = rerefer();

                 if(action.equalsIgnoreCase("release"))
                    mReferralResults = release();

			 	 if(mReferralResults) {
				    if(!action.equalsIgnoreCase("reject")) {
				       mResults = performRequery(action);

				    }

				 }
			 }
         } catch (Exception ex) {
			 throw new ServiceImplException("ReferralActionServiceImpl", "performRerefer", "An exception occurred in Rereferal Release process!!! " + ex.toString());
 	     }

	     return true;
	 }
    /*
     * Executes the request to the CommandDao to perform rerefer action
     * @return boolean  - pass/fail
     */
     private boolean rerefer() {

 		 boolean mResults = false;
 		 try{

			 String actionResult = new String();
			 actionResult = (String) reReferReferalCommand.execute(referralActionObject.getApplId(), referralActionObject.getRereferCA(), referralActionObject.getComments(), super.getUserId());
             referralActionObject.setResults(actionResult);
			 if(actionResult.trim().equalsIgnoreCase(SUCCESS_LITERAL)){
                mResults = true;
			 }
         } catch (Exception ex) {
			 throw new ServiceImplException("ReferralActionServiceImpl", "rerefer", "An exception occurred in Rereferal Release process!!! " + ex.toString());
 	     }

	     return mResults;
      }

    /*
     * Get the POC for the Cancer Activity
     * @return String  - POC
     */
     private boolean performRequery(String action) {

         NciPdReferralVw mNciPdReferralVw = null;
         NciPdTransferVw mNciPdTransferVw = null;
         oAction =  ApplicationConstants.REFERRAL;
		 boolean mResults = false;
		 String cancerActivity = new String(ApplicationConstants.EMPTY_STRING);
	     NciPdQueryVw mNciPdQueryVw = null;
         if(action.equalsIgnoreCase("accept")) {
			cancerActivity = referralActionObject.getCancerActivity();
			oAction =  ApplicationConstants.PD_ASSIGNMENT;
		 }

		 if(action.equalsIgnoreCase("release") )
			cancerActivity = referralActionObject.getDualCA();

         if(action.equalsIgnoreCase("rerefer") ) {
			cancerActivity = referralActionObject.getRereferCA();
		 }


		 List mList = requeryGrant(referralActionObject.getApplId(), cancerActivity);
         if(oAction.equalsIgnoreCase(ApplicationConstants.REFERRAL) ){
			 mNciPdReferralVw = (NciPdReferralVw) mList.get(0);
             if(mNciPdReferralVw != null)
			    referralActionObject.setCancerActivity(mNciPdReferralVw.getCayCode());
			 //if(mNciPdReferralVw.getLastName() != null)
			 //   referralActionObject.setProgramDirector(mNciPdReferralVw.getFirstName() + " " + mNciPdQueryVw.getLastName());
			 if(mNciPdReferralVw.getPocFullName() != null)
			    referralActionObject.setRereferPOC(mNciPdReferralVw.getPocFullName());
			 mResults = true;
		 }else{
             if(oAction.equalsIgnoreCase(ApplicationConstants.PD_ASSIGNMENT) ){
			    mNciPdTransferVw = (NciPdTransferVw) mList.get(0);
                if(mNciPdTransferVw != null)
			       referralActionObject.setCancerActivity(mNciPdTransferVw.getCayCode());
			    if(mNciPdTransferVw.getPdFullName() != null)
			       referralActionObject.setProgramDirector(mNciPdTransferVw.getPdFullName() );
			    //if(mNciPdTransferVw.getPocFullName() != null)
			    //   referralActionObject.setRereferPOC(mNciPdTransferVw.getPocFullName());
			    mResults = true;
			}
		 }

		 return mResults;

	 }
    /*
     * Get the POC for the Cancer Activity
     * @return String  - POC
     */
     public List requeryGrant(Long aApplId, String cancerActivity) {
         List mList = null;
 		 String mPoc = new String(ApplicationConstants.EMPTY_STRING);
	     try{
	         RetrieveGrantInfoCommand mRetrieveGrantInfoCommand = (RetrieveGrantInfoCommand) getBean("retrieveGrantInfoCommandDao");
		     QueryPage mQueryPage = mRetrieveGrantInfoCommand.execute(aApplId, cancerActivity, super.getUserId(), oAction);
		     mList = mQueryPage.getPageList();
         } catch (Exception ex) {
			 throw new ServiceImplException("ReferralActionServiceImpl", "requeryGrant", "An exception occurred in the reQuery process!!! " + ex.toString());
 	     }

 	     return  mList;

	 }


}