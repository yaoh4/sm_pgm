package gov.nih.nci.iscs.oracle.pgm.service.impl;

import java.util.*;

import gov.nih.nci.iscs.oracle.pgm.service.impl.BaseServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveRejCommentsCommand;
import gov.nih.nci.iscs.oracle.pgm.context.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;
import gov.nih.nci.iscs.oracle.pgm.hibernate.CgRefCodes;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;


/**
 * A jdbc implementation of the UserHandler interface.
 * @author Oracle
 */
public class RejectionCommentsServiceImpl extends BaseServiceImpl
{
    static Logger logger = LogManager.getLogger(RejectionCommentsServiceImpl.class);




    public RejectionCommentsServiceImpl(Object oContextFactory) {
		super(oContextFactory);
	}


    public Map getRejectionComments() {
		HashMap mRejectionComments = new HashMap();
		ArrayList mReturnList = new ArrayList();
		  try{
             RetrieveRejCommentsCommand oRetrieveRejCommentsCommand = (RetrieveRejCommentsCommand) getBean("retrieveRejCommentsCommandDao");
             QueryPage  aRejectionCommentsQueryPage = oRetrieveRejCommentsCommand.execute();
            // get the list from the page
             ArrayList mList =  (ArrayList) aRejectionCommentsQueryPage.getList();
		     Iterator mIterator = mList.iterator();
		     while(mIterator.hasNext()){
				 CgRefCodes mCgRefCodes = (CgRefCodes) mIterator.next();
	           //  mRejectionComments.put(mCgRefCodes.getRvLowValue().replaceAll(" ", ""), mCgRefCodes.getRvLowValue());
                     mRejectionComments.put(mCgRefCodes.getRvLowValue(), mCgRefCodes.getRvLowValue());
			 }
	         mRejectionComments.put("Other", "Other");
		  } catch (Exception ex) {
			 throw new ServiceImplException("RejectionCommentsServiceImpl", "getRejectionComments", "Unable to obtain Reject Comments from the database!!! " + ex.toString());
	      }
	       return (Map) mRejectionComments;
    }





}