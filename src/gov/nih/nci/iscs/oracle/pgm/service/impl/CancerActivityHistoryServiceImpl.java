package gov.nih.nci.iscs.oracle.pgm.service.impl;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gov.nih.nci.iscs.oracle.pgm.service.impl.BaseServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveCAHistoryCommand;
import gov.nih.nci.iscs.oracle.pgm.context.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;
import gov.nih.nci.iscs.oracle.pgm.hibernate.ApplCaAsgnmtHistoryVw;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;


/**
 * A jdbc implementation of the UserHandler interface.
 * @author Oracle
 */
public class CancerActivityHistoryServiceImpl extends BaseServiceImpl
{
    static Logger logger = LogManager.getLogger(CancerActivityHistoryServiceImpl.class);



    public CancerActivityHistoryServiceImpl(Object oContextFactory ) {
		super(oContextFactory);
	}


    public ApplCaAsgnmtHistoryVw getCAHistoryForAppl(String applId) {
		  ArrayList mList  = new ArrayList();
		  ApplCaAsgnmtHistoryVw mApplCaAsgnmtHistoryVw = new ApplCaAsgnmtHistoryVw();
		  try{
             RetrieveCAHistoryCommand oRetrieveCAHistoryCommand = (RetrieveCAHistoryCommand) getBean("retrieveCAHistoryCommandDao");
             QueryPage  aCAHistQueryPage = oRetrieveCAHistoryCommand.execute(new Long(applId), super.getUserId());
              // get the list from the page
             mList =  (ArrayList) aCAHistQueryPage.getList();
             if(mList.size() > 0) {
				 mApplCaAsgnmtHistoryVw = (ApplCaAsgnmtHistoryVw) mList.get(0);
			 }

		  } catch (Exception ex) {
			 throw new ServiceImplException("CancerActivityHistoryServiceImpl", "getProgamDirectorForCA", "Unable to obtain Program Director from the database!!! " + ex.toString());
	      }

	      return mApplCaAsgnmtHistoryVw;
    }



}