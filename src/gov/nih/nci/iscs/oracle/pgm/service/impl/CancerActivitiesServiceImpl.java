package gov.nih.nci.iscs.oracle.pgm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gov.nih.nci.iscs.oracle.pgm.service.impl.BaseServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveCAInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivitiesT;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;


/**
 * A jdbc implementation of the UserHandler interface.
 * @author Oracle
 */
public class CancerActivitiesServiceImpl extends BaseServiceImpl
{
    static Logger logger = LogManager.getLogger(CancerActivitiesServiceImpl.class);



    public CancerActivitiesServiceImpl(Object oContextFactory) {
		super(oContextFactory);
	}


    public List getActiveCancerActivities() {
		LabelValueBean mLabelValueBean;
		ArrayList mReturnList = new ArrayList();
		  try{
             RetrieveCAInfoCommand oRetrieveCAInfoCommand = (RetrieveCAInfoCommand) getBean("retrieveCAInfoCommandDao");
             QueryPage  aActiveCAQueryPage = oRetrieveCAInfoCommand.execute();
            // get the list from the page
             ArrayList mList =  (ArrayList) aActiveCAQueryPage.getList();
		     Iterator mIterator = mList.iterator();
		     while(mIterator.hasNext()){
				 CancerActivitiesT mCancerActivitiesT = (CancerActivitiesT) mIterator.next();
		         mLabelValueBean = new LabelValueBean( mCancerActivitiesT.getCode(), mCancerActivitiesT.getCode());
		         mReturnList.add(mLabelValueBean);
			 }
		  } catch (Exception ex) {
			 throw new ServiceImplException("CancerActivitiesServiceImpl", "getActiveCancerActivities", "Unable to obtain Active Cancer Activities from the database!!! " + ex.toString());
	      }
	       return mReturnList;
    }





}