package gov.nih.nci.iscs.oracle.pgm.service.impl;


import java.util.*;

import gov.nih.nci.iscs.oracle.pgm.service.impl.BaseServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveReportsInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveCrystalParamsCommand;
import gov.nih.nci.iscs.oracle.pgm.context.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;
import gov.nih.nci.iscs.oracle.pgm.hibernate.ReportsVw;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.UpdateReportDataCommand;
import gov.nih.nci.iscs.oracle.pgm.service.GrantSearchResultObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;


/**
 * A jdbc implementation of the UserHandler interface.
 * @author Oracle
 */
public class ReportSelectorServiceImpl extends BaseServiceImpl
{
    static Logger logger = LogManager.getLogger(ReportSelectorServiceImpl.class);



    public ReportSelectorServiceImpl(Object oContextFactory ) {
		super(oContextFactory);
	}


    public List getReportsForApplication(String applicationName) {
		  ArrayList mList  = new ArrayList();
		  try{
             RetrieveReportsInfoCommand oRetrieveReportsInfoCommand = (RetrieveReportsInfoCommand) getBean("retrieveReportsInfoCommandDao");

             QueryPage  aReportsInfoQueryPage = oRetrieveReportsInfoCommand.execute(applicationName, super.getUserId());
              // get the list from the page
             mList =  (ArrayList) aReportsInfoQueryPage.getAllAsList();
		  } catch (Exception ex) {
			 throw new ServiceImplException("ReportSelectorServiceImpl", "getReportsForApplication", "Unable to obtain Reports Info from the database!!! " + ex.toString());
	      }
	       return mList;
    }

    public List getCrystalReportParams(Long reportId) {
		  ArrayList mList  = new ArrayList();
		  try{
             RetrieveCrystalParamsCommand oRetrieveCrystalParamsCommand = (RetrieveCrystalParamsCommand) getBean("retrieveCrystalParamsCommandDao");

             QueryPage  aCrystalParamsQueryPage = oRetrieveCrystalParamsCommand.execute(reportId, super.getUserId());
              // get the list from the page
             mList =  (ArrayList) aCrystalParamsQueryPage.getAllAsList();
		  } catch (Exception ex) {
			 throw new ServiceImplException("ReportSelectorServiceImpl", "getReportsForApplication", "Unable to obtain Reports Info from the database!!! " + ex.toString());
	      }
	       return mList;
    }

    public ReportsVw getReportDetails(Long rusId, Long rfrId) {
		  ArrayList mList  = new ArrayList();
		  try{
             RetrieveReportsInfoCommand oRetrieveReportsInfoCommand = (RetrieveReportsInfoCommand) getBean("retrieveReportsInfoCommandDao");
             QueryPage  aReportsInfoQueryPage = oRetrieveReportsInfoCommand.getReportDetails(rusId, rfrId);
              // get the list from the page
             mList =  (ArrayList) aReportsInfoQueryPage.getAllAsList();
		  } catch (Exception ex) {
			 throw new ServiceImplException("ReportSelectorServiceImpl", "getReportsForApplication", "Unable to obtain Reports Info from the database!!! " + ex.toString());
	      }
	      if(mList.size() > 0) {
			 return (ReportsVw) mList.get(0);
		  } else {
			 return new ReportsVw();
		  }
    }


    public void insertDataForReport(List mSortedSelectedGrants, String reportType,String mSessionId, Long mReportId) {
		   String actionResult = new String();
		   try{
	            UpdateReportDataCommand oUpdateReportDataCommand = (UpdateReportDataCommand) getBean("updateReportDataCommandDao");
                Iterator mIterator = mSortedSelectedGrants.iterator();
                while  (mIterator.hasNext()) {
                   GrantSearchResultObject mGrantSearchResultObject = (GrantSearchResultObject) mIterator.next();
				   Long mApplId = mGrantSearchResultObject.getApplId();
   			       actionResult = (String) oUpdateReportDataCommand.execute(mSessionId, mReportId, mApplId, "insert", super.getUserId(), reportType);
				}
			} catch (Exception ex) {
				 throw new ServiceImplException("ReportSelectorServiceImpl", "insertDataForReport", "Unable to insert grant data in report table!!! " + ex.toString());
		    }
    }


    public void deleteDataForReport(String mSessionId, String reportType, Long mReportId) {
		   String actionResult = new String();
		   Long mApplId = new Long ("0");
		   try{
	            UpdateReportDataCommand oUpdateReportDataCommand = (UpdateReportDataCommand) getBean("updateReportDataCommandDao");
   			    actionResult = (String) oUpdateReportDataCommand.execute(mSessionId, mReportId, mApplId, "delete", super.getUserId(), reportType);

			} catch (Exception ex) {
				 throw new ServiceImplException("ReportSelectorServiceImpl", "insertDataForReport", "Unable to insert grant data in report table!!! " + ex.toString());
		    }
    }


}