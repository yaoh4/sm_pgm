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
import gov.nih.nci.iscs.oracle.pgm.context.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;
import gov.nih.nci.iscs.oracle.pgm.hibernate.PdCaAsgnmtVw;

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
		  try{
             RetrievePDInfoForAssignmentCommand oRetrievePDInfoForAssignmentCommand = (RetrievePDInfoForAssignmentCommand) getBean("retrievePDInfoForAssignmentCommandDao");
             QueryPage  aPDQueryPage = oRetrievePDInfoForAssignmentCommand.execute(cancerActivity, super.getUserId());
              // get the list from the page
             mList =  (ArrayList) aPDQueryPage.getList();

             Iterator mIterator = mList.iterator();
             String mPreviousPd = ApplicationConstants.EMPTY_STRING;
             while(mIterator.hasNext() ) {
				  PdCaAsgnmtVw mPdCaAsgnmtVw = (PdCaAsgnmtVw) mIterator.next();
				  LabelValueBean mLabelValueBean = null;
				  if(cancerActivity == null || formatPds) {
					  mLabelValueBean = new LabelValueBean(mPdCaAsgnmtVw.getPdName() + "/" + mPdCaAsgnmtVw.getOrgDesc() + "/" + mPdCaAsgnmtVw.getCayCode(), mPdCaAsgnmtVw.getCayCode() + mPdCaAsgnmtVw.getNpeId().toString() );
			          mLabelValueBeanList.add(mLabelValueBean);
				  }else {
					  if(!mPdCaAsgnmtVw.getPdName().equalsIgnoreCase(mPreviousPd)) {
				  	     mLabelValueBean = new LabelValueBean(mPdCaAsgnmtVw.getPdName(), mPdCaAsgnmtVw.getPersonId().toString());
				         mPreviousPd = mPdCaAsgnmtVw.getPdName();
			             mLabelValueBeanList.add(mLabelValueBean);
					  }
				  }
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
		  try{
             RetrievePDCancerActivityInfoCommand oRetrievePDCancerActivityInfoCommand = (RetrievePDCancerActivityInfoCommand) getBean("retrievePDCancerActivityInfoCommandDao");
             QueryPage  aPDQueryPage = oRetrievePDCancerActivityInfoCommand.execute(key, super.getUserId());
              // get the list from the page
             mList =  (ArrayList) aPDQueryPage.getList();

             Iterator mIterator = mList.iterator();
             while(mIterator.hasNext() ) {
				  PdCaAsgnmtVw mPdCaAsgnmtVw = (PdCaAsgnmtVw) mIterator.next();
				  LabelValueBean mLabelValueBean;
				  mLabelValueBean = new LabelValueBean(mPdCaAsgnmtVw.getCayCode(), mPdCaAsgnmtVw.getCayCode());
 			      mLabelValueBeanList.add(mLabelValueBean);
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
				  PdCaAsgnmtVw mPdCaAsgnmtVw = (PdCaAsgnmtVw) mIterator.next();
				  LabelValueBean mLabelValueBean;
				  mLabelValueBean = new LabelValueBean(mPdCaAsgnmtVw.getOrgDesc(), mPdCaAsgnmtVw.getOrgId().toString());
 			      mLabelValueBeanList.add(mLabelValueBean);
			  }


		  } catch (Exception ex) {
			 throw new ServiceImplException("ProgamDirectorServiceImpl", "getCancerActivityForPD", "Unable to obtain Program Director from the database!!! " + ex.toString());
	      }
	       return mLabelValueBeanList;
    }

}