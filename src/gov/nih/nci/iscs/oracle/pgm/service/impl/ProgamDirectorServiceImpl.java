package gov.nih.nci.iscs.oracle.pgm.service.impl;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

import gov.nih.nci.iscs.oracle.pgm.service.impl.BaseServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveProgamDirectorInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveProgamDirectorsInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrievePDOrgInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrievePDCancerActivityInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrievePDInfoForAssignmentCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveActivePDInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.context.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;
import gov.nih.nci.iscs.oracle.pgm.hibernate.PdCaAsgnmtVw;
import gov.nih.nci.iscs.oracle.pgm.hibernate.PdOrgVw4;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;


/**
 * A jdbc implementation of the UserHandler interface.
 * @author Oracle
 */
public class ProgamDirectorServiceImpl extends BaseServiceImpl
{
    static Logger logger = LogManager.getLogger(ProgamDirectorServiceImpl.class);


    public ProgamDirectorServiceImpl(Object oContextFactory ) {
		super(oContextFactory);
	}


    public List getProgamDirectorForCA(String cancerActivity) {
		  ArrayList mList  = new ArrayList();
		  ArrayList mLabelValueBeanList = new ArrayList();
		  try{
             RetrieveProgamDirectorInfoCommand oRetrieveProgamDirectorInfoCommand = (RetrieveProgamDirectorInfoCommand) getBean("retrieveProgamDirectorInfoCommandDao");

             QueryPage  aPDQueryPage = oRetrieveProgamDirectorInfoCommand.execute(cancerActivity, super.getUserId());
              // get the list from the page
             mList =  (ArrayList) aPDQueryPage.getList();
             Iterator mIterator = mList.iterator();
             while(mIterator.hasNext() ) {
				  PdCaAsgnmtVw mPdCaAsgnmtVw = (PdCaAsgnmtVw) mIterator.next();
				  LabelValueBean mLabelValueBean;
				  if(cancerActivity == null) {
					  mLabelValueBean = new LabelValueBean(mPdCaAsgnmtVw.getPdName() + "/" + mPdCaAsgnmtVw.getOrgDesc() + "/" + mPdCaAsgnmtVw.getCayCode(), mPdCaAsgnmtVw.getCayCode() + mPdCaAsgnmtVw.getNpeId().toString() );
				  }else {
					  mLabelValueBean = new LabelValueBean(mPdCaAsgnmtVw.getPdName() + "/" + mPdCaAsgnmtVw.getOrgDesc(), mPdCaAsgnmtVw.getNpeId().toString());
				  }
			     mLabelValueBeanList.add(mLabelValueBean);
			  }


		  } catch (Exception ex) {
			 throw new ServiceImplException("ProgamDirectorServiceImpl", "getProgamDirectorForCA", "Unable to obtain Program Director from the database!!! " + ex.toString());
	      }
	       return mLabelValueBeanList;
    }


    public List getProgamDirectorForAllCAs(TreeSet cancerActivities) {
		  ArrayList mList  = new ArrayList();
		  ArrayList mLabelValueBeanList = new ArrayList();
		  try{
             RetrieveProgamDirectorsInfoCommand oRetrieveProgamDirectorsInfoCommand = (RetrieveProgamDirectorsInfoCommand) getBean("retrieveProgamDirectorsInfoCommandDao");

             QueryPage  aPDQueryPage = oRetrieveProgamDirectorsInfoCommand.execute(cancerActivities, super.getUserId());
              // get the list from the page
             mList =  (ArrayList) aPDQueryPage.getList();
             Iterator mIterator = mList.iterator();
             while(mIterator.hasNext() ) {
				  PdCaAsgnmtVw mPdCaAsgnmtVw = (PdCaAsgnmtVw) mIterator.next();
				  LabelValueBean mLabelValueBean;
				  mLabelValueBean = new LabelValueBean(mPdCaAsgnmtVw.getPdName() + "/" + mPdCaAsgnmtVw.getOrgDesc(), mPdCaAsgnmtVw.getNpeId().toString());
			     mLabelValueBeanList.add(mLabelValueBean);
			  }


		  } catch (Exception ex) {
			 throw new ServiceImplException("ProgamDirectorServiceImpl", "getProgamDirectorForAllCAs", "Unable to obtain Program Director from the database!!! " + ex.toString());
	      }
	       return mLabelValueBeanList;
    }

    public List getAllProgramDirectors(String cancerActivity, boolean formatPds) {
		  ArrayList mList  = new ArrayList();
		  ArrayList mLabelValueBeanList = new ArrayList();
		  String mViewName = "pdCaAsgnmtVw";
		  try{
             RetrievePDInfoForAssignmentCommand oRetrievePDInfoForAssignmentCommand = (RetrievePDInfoForAssignmentCommand) getBean("retrievePDInfoForAssignmentCommandDao");
             QueryPage  aPDQueryPage = oRetrievePDInfoForAssignmentCommand.execute(cancerActivity, mViewName, super.getUserId());
              // get the list from the page
             mList =  (ArrayList) aPDQueryPage.getList();

             Iterator mIterator = mList.iterator();
             while(mIterator.hasNext() ) {
				  PdCaAsgnmtVw mPdCaAsgnmtVw = (PdCaAsgnmtVw) mIterator.next();
				  LabelValueBean mLabelValueBean = null;
				  if(cancerActivity == null || formatPds) {
					  mLabelValueBean = new LabelValueBean(mPdCaAsgnmtVw.getPdName() + "/" + mPdCaAsgnmtVw.getOrgDesc() + "/" + mPdCaAsgnmtVw.getCayCode(), mPdCaAsgnmtVw.getCayCode() + mPdCaAsgnmtVw.getNpeId().toString() );
			          mLabelValueBeanList.add(mLabelValueBean);
				  }
		     }
		  } catch (Exception ex) {
			 throw new ServiceImplException("ProgamDirectorServiceImpl", "getAllProgramDirectors", "Unable to obtain Program Director from the database!!! " + ex.toString());
	      }
	       return mLabelValueBeanList;
    }

    public List getPDForTransfer(String cancerActivity) {
		  ArrayList mLabelValueBeanList = new ArrayList();
		  ArrayList mList  = new ArrayList();
		  TreeMap mTempMap;
		  String mViewName = "pdOrgVw4";
		  try{
             RetrievePDInfoForAssignmentCommand oRetrievePDInfoForAssignmentCommand = (RetrievePDInfoForAssignmentCommand) getBean("retrievePDInfoForAssignmentCommandDao");
             QueryPage  aPDQueryPage = oRetrievePDInfoForAssignmentCommand.execute(cancerActivity, mViewName, super.getUserId());
              // get the list from the page
             mList =  (ArrayList) aPDQueryPage.getList();
             mTempMap = new TreeMap();

             String pdName = ApplicationConstants.EMPTY_STRING;
             String pdCode = ApplicationConstants.EMPTY_STRING;
             String personId = ApplicationConstants.EMPTY_STRING;
             Iterator mIterator = mList.iterator();
             while(mIterator.hasNext() ) {
				  HashSet mTempSet = new HashSet();
				  PdOrgVw4 mPdOrgVw4 = (PdOrgVw4) mIterator.next();
				  pdName =  mPdOrgVw4.getPdName();
				  pdCode =  mPdOrgVw4.getPdCode();
				  personId = mPdOrgVw4.getPersonId().toString();
				  if(mTempMap.containsKey(pdName+"*"+personId)){
					  mTempSet = (HashSet) mTempMap.get(pdName+"*"+personId);
					  mTempSet.add(pdCode);
				  }else{
					  mTempSet.add(pdCode);
				  }
				  mTempMap.put(pdName+"*"+personId, mTempSet);
			  }

              LabelValueBean mLabelValueBean = null;
              for (mIterator = mTempMap.entrySet().iterator(); mIterator.hasNext();) {
                   Map.Entry entry = (Map.Entry) mIterator.next();
                   String key = (String)entry.getKey();
                   Set value = (Set)entry.getValue();
                   int index = key.indexOf("*");
                   pdName = key.substring(0, index);
                   personId = key.substring(index+1, key.length());
                   pdCode  = " (";
                   boolean firstTime = true;
                   for (Iterator mIter = value.iterator(); mIter.hasNext();) {
					   if(firstTime){
						   pdCode  = pdCode + (String) mIter.next();
						   firstTime = false;
					   }else{
						   pdCode  = pdCode + ", " + (String) mIter.next();
					   }

				   }
				   mLabelValueBean = new LabelValueBean(pdName + pdCode + ")", personId);
                   mLabelValueBeanList.add(mLabelValueBean);
              }
		  } catch (Exception ex) {
			 throw new ServiceImplException("ProgamDirectorServiceImpl", "getAllProgramDirectors", "Unable to obtain Program Director from the database!!! " + ex.toString());
	      }
	       return mLabelValueBeanList;
    }
    /*public List getAllProgramDirectors(String cancerActivity, boolean mFormatPDs) {

		  this.formatPds = true;
		  List mList =  getAllProgramDirectors(cancerActivity);
		  this.formatPds = false;
		  return mList;
	}*/

    public List getCancerActivityForPD(String key) {
		  ArrayList mList  = new ArrayList();
		  ArrayList mLabelValueBeanList = new ArrayList();
		  String mLastCayCode = ApplicationConstants.EMPTY_STRING;
		  try{
             RetrievePDCancerActivityInfoCommand oRetrievePDCancerActivityInfoCommand = (RetrievePDCancerActivityInfoCommand) getBean("retrievePDCancerActivityInfoCommandDao");
             QueryPage  aPDQueryPage = oRetrievePDCancerActivityInfoCommand.execute(key, super.getUserId());
              // get the list from the page
             mList =  (ArrayList) aPDQueryPage.getList();
             if(mList.size() > 1){
				 HashMap mTempMap = new HashMap(mList.size());
				 Iterator mIterator = mList.iterator();
				 while(mIterator.hasNext() ) {
				    PdOrgVw4 mPdOrgVw4 = (PdOrgVw4) mIterator.next();
				    mTempMap.put(mPdOrgVw4.getCayCode(), mPdOrgVw4);
				 }
				 mList = new ArrayList(mTempMap.values());
			 }
		    Iterator mIterator = mList.iterator();
            while(mIterator.hasNext() ) {
				  PdOrgVw4 mPdOrgVw4 = (PdOrgVw4) mIterator.next();
				  if(mPdOrgVw4.getCayCode().equalsIgnoreCase(mLastCayCode)){
				  }else{
				    LabelValueBean mLabelValueBean;
				    mLabelValueBean = new LabelValueBean(mPdOrgVw4.getCayCode(), mPdOrgVw4.getCayCode());
 			        mLabelValueBeanList.add(mLabelValueBean);
				  }
 			      mLastCayCode = mPdOrgVw4.getCayCode();
			  }


		  } catch (Exception ex) {
			 throw new ServiceImplException("ProgamDirectorServiceImpl", "getCancerActivityForPD", "Unable to obtain Program Director from the database!!! " + ex.toString());
	      }
	       return mLabelValueBeanList;
    }


    public List getPDOrgForCA(String cancerActivity, String personId) {
		  ArrayList mList  = new ArrayList();
		  ArrayList mLabelValueBeanList = new ArrayList();
		  try{
             RetrievePDOrgInfoCommand oRetrievePDOrgInfoCommand = (RetrievePDOrgInfoCommand) getBean("retrievePDOrgInfoCommandDao");
             QueryPage  aPDQueryPage = oRetrievePDOrgInfoCommand.execute(personId, cancerActivity, super.getUserId());
              // get the list from the page
             mList =  (ArrayList) aPDQueryPage.getList();

             Iterator mIterator = mList.iterator();
             while(mIterator.hasNext() ) {
				  PdOrgVw4 mPdOrgVw4 = (PdOrgVw4) mIterator.next();
				  LabelValueBean mLabelValueBean;
				  mLabelValueBean = new LabelValueBean(mPdOrgVw4.getOrgDesc(), new Long(mPdOrgVw4.getOrgId()).toString());
 			      mLabelValueBeanList.add(mLabelValueBean);
			  }


		  } catch (Exception ex) {
			 throw new ServiceImplException("ProgamDirectorServiceImpl", "getCancerActivityForPD", "Unable to obtain Program Director from the database!!! " + ex.toString());
	      }
	       return mLabelValueBeanList;
    }

    public List getAllActiveProgramDirectors(String cancerActivity, boolean formatPds) {
		  ArrayList mList  = new ArrayList();
		  ArrayList mLabelValueBeanList = new ArrayList();
		  try{
             RetrieveActivePDInfoCommand oRetrieveActivePDInfoCommand = (RetrieveActivePDInfoCommand) getBean("retrieveActivePDInfoCommandDao");
             QueryPage  aPDQueryPage = oRetrieveActivePDInfoCommand.execute(cancerActivity, super.getUserId());
              // get the list from the page
             mList =  (ArrayList) aPDQueryPage.getList();

             Iterator mIterator = mList.iterator();
             String mPreviousPd = ApplicationConstants.EMPTY_STRING;
             while(mIterator.hasNext() ) {
				  PdOrgVw4 mPdOrgVw4 = (PdOrgVw4) mIterator.next();
				  LabelValueBean mLabelValueBean = null;
				  if(cancerActivity == null || formatPds) {
					  mLabelValueBean = new LabelValueBean(mPdOrgVw4.getPdName() + "/" + mPdOrgVw4.getOrgDesc() + "/" + mPdOrgVw4.getCayCode(), mPdOrgVw4.getCayCode() + mPdOrgVw4.getNpeId().toString() );
			          mLabelValueBeanList.add(mLabelValueBean);
				  }else {
					  if(!mPdOrgVw4.getPdName().equalsIgnoreCase(mPreviousPd)) {
				  	     mLabelValueBean = new LabelValueBean(mPdOrgVw4.getPdName(), mPdOrgVw4.getPersonId().toString());
				         mPreviousPd = mPdOrgVw4.getPdName();
			             mLabelValueBeanList.add(mLabelValueBean);
					  }
				  }
			  }


		  } catch (Exception ex) {
			 throw new ServiceImplException("ProgamDirectorServiceImpl", "getAllActiveProgramDirectors", "Unable to obtain active Program Director from the database!!! " + ex.toString());
	      }
	       return mLabelValueBeanList;
    }

}