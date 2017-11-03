package gov.nih.nci.iscs.oracle.pgm.service.impl;

import gov.nih.nci.iscs.oracle.pgm.service.impl.UserServiceImpl;

import org.springframework.context.ApplicationContext;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.forms.PaginationObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * A jdbc implementation of the UserHandler interface.
 * @author Oracle
 */
public class BaseServiceImpl
{
    static Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private String oUserId;
    private String readOnly;

    public String getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	ApplicationContext oContextFactory = null;

    public BaseServiceImpl(Object oContextFactory) {
		this .oContextFactory = (ApplicationContext) oContextFactory;
	}

    public BaseServiceImpl(Object oContextFactory, String oUserId) {

		this .oContextFactory = (ApplicationContext) oContextFactory;
		this.oUserId = oUserId;
	}

    public BaseServiceImpl(Object oContextFactory, String oUserId, String readOnly) {

  		this .oContextFactory = (ApplicationContext) oContextFactory;
  		this.oUserId = oUserId;
  		this.readOnly = readOnly;
  	}
    
    public ApplicationContext getContextFactory() {
		return oContextFactory;
	}

    public Object getBean(String beanName) throws Exception
    {
		  Object hibernateBean = oContextFactory.getBean(beanName);
		  return hibernateBean;

    }

    /**
     * mutator / accessor methods for userId attribute
     */
    public String getUserId () {
		return this.oUserId;
    }
    public void setUserId (String aUserId) {
		this.oUserId = aUserId;
    }

    public void mapPaginationObject(QueryPage aQueryPage, PaginationObject mPaginationObject) {

		mPaginationObject.setTotalResultsCount(new Long(aQueryPage.getTotalResults() ));
		mPaginationObject.setIsFirstPage(aQueryPage.isFirstPage() );
		mPaginationObject.setIsLastPage(aQueryPage.isLastPage() );
		mPaginationObject.setLastPageNumber(new Integer(aQueryPage.getLastPageNumber() ));
		mPaginationObject.setNextPageNumber(new Integer(aQueryPage.getNextPageNumber() ));
		mPaginationObject.setPreviousPageNumber(new Integer(aQueryPage.getPreviousPageNumber() ));
		mPaginationObject.setHasNextPage(aQueryPage.hasNextPage() );
		mPaginationObject.setHasPreviousPage(aQueryPage.hasPreviousPage() );

	}

	protected String formatDate(String dateToParse) {
      String returnDate = dateToParse.substring(0, 10);
      returnDate = returnDate.substring(5,7) + "/" + returnDate.substring(8,10) + "/"  + returnDate.substring(0,4);
	  return returnDate;
   }

}