package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;

// jdk imports
import java.util.List;
import java.lang.Integer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// application imports
import gov.nih.nci.iscs.oracle.pgm.exceptions.CommandDaoException;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

// hiernate imports
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Criteria;

/**
* This class provides pagination for displaying results from a large result set
* over a number of pages (i.e. with a given number of results per page).
*
* @author Michelle Engermann
     * @version 1.0
*/
public class QueryPage {

    private List oPageResults;
    private int  oPageSize;
    private int  oPageNumber;
    private long oTotalResultsCount = 0;



    protected final Log logger = LogFactory.getLog(getClass());
    /**
     * Construct a new Page. Page numbers are zero-based, so the first page is page 0.
     *
     * @param Criteria   - the Hibernate Criteria
     * @param aPageNumber  - the page number (zero-based)
     * @param aPageSize  - the number of results to display on the page
     */
   public  QueryPage(Criteria aCriteria, int aPageNumber, int aPageSize) throws CommandDaoException {
    this.oPageNumber = aPageNumber;
    this.oPageSize = aPageSize;
    try
    {
		if ( oPageNumber < ApplicationConstants.ALL_PAGES ) {
			oPageResults = aCriteria.setFirstResult( (oPageNumber - 1) * oPageSize).setMaxResults(oPageSize).list();
	    } else {
			oPageResults = aCriteria.list();
	    }
        oTotalResultsCount = aCriteria.count();
    } catch (HibernateException e) {
        throw new CommandDaoException("Failed to get paginated results: " + e.getMessage());
    }

  }
  // returns true if the current Page number is zero
  public boolean isFirstPage() {
    return oPageNumber == 1;
  }

  // retruns true if the current page number is greater then or equal to the last page number
  public boolean isLastPage() {
    return oPageNumber >= getLastPageNumber();
  }

  // return true if this is not the last page of the query results
  public boolean hasNextPage() {
    //return oPageResults.size() > oPageSize;
    return oPageNumber < getLastPageNumber();
  }

  // return true if this is not the first page of the query results
  public boolean hasPreviousPage() {
    return oPageNumber > 1;
  }

  public int getLastPageNumber() {
   /*
    * We use the Math.floor() method because page numbers are zero-based
    * (i.e. the first page is page 0).
    */
    double totalResults = new Long(getTotalResults()).doubleValue();
    int baseValue = new Double(Math.floor(totalResults / oPageSize)).intValue();
    long aPageSize = new Long(getPageSize()).longValue();
    long  modValue = getTotalResults() % aPageSize;

    if( modValue > 0 )
		return baseValue + 1;

	 return baseValue;
  }

  public List getList() {
   /*
    * Since we retrieved one more than the specified pageSize when the
    * class was constructed, we now trim it down to the pageSize if a next
    * page exists.
    */
     return hasNextPage() ? oPageResults.subList(0, oPageSize) : oPageResults;
  }

  public List getAllAsList() {
   /*
    * returns the entire list
    */
     return oPageResults;

  }
  public List getPageList() {
   /*
    * returns the page list
    */
     return oPageResults;

  }

  // return the total row count for this query
  public long getTotalResults() {
	  return oTotalResultsCount;
  }

  // return the index to the first entry in the returned page
  public int getFirstResultNumber() {
   return (oPageNumber - 1) * oPageSize + 1;
  }

  // return the index to the last entry in the returned page
  public long getLastResultNumber() {
   long fullPage = getFirstResultNumber() + oPageSize - 1;
   return getTotalResults() < fullPage ? getTotalResults() : fullPage;
  }

  // get the next page number - this is zero-based
  public int getNextPageNumber() {
   return hasNextPage() ?  oPageNumber + 1 : oPageNumber;
  }

  // get the previous page number - this is zero-based
  public int getPreviousPageNumber() {
   return hasPreviousPage()  ? oPageNumber - 1 : oPageNumber;
  }

 //  get the page Number
  public int getPageNumber() {
	  return oPageNumber;
  }

 //  get the page Size
  public int getPageSize() {
	  return oPageSize;
  }

}



