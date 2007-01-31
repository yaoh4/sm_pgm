package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;

// jdk imports
import java.lang.Class;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveReportsInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.AccessCommandDao;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.exceptions.CommandDaoException;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

// Springfranework imports
import org.springframework.orm.hibernate.SessionFactoryUtils;

// hibernate imports
import net.sf.hibernate.Criteria;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.Session;


public class RetrieveReportsInfoCommandDao extends AccessCommandDao implements  RetrieveReportsInfoCommand {
   /**
     * Concrete class that encapsulates the methods for retrieveing User Data
     *  from the database
     *
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.query.AccessCommandDao
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.dataaccess.RetrieveReportsInfoCommand
     * @author Michelle Engermann
     * @version 1.0
     */

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

   /*
    * Class constructor
    */
    public RetrieveReportsInfoCommandDao() {}


    /*
     * The main method that handles the execution of the command.
     * - Get the session from the Session Factory
     * - Build the Query Criteria for the Criteria object
     * - execute the query and return the Query Page
     * @retrun aQueryPage - a QueryPage object that encapsulate the Pagination
     */
     public QueryPage execute(String  oApplicationName, String oUserid) {

	   QueryPage  mGrantsQueryPage = null;

       // get the session from the sessionFactory
       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       try {
		   // build the query string from query object
           Criteria mCriteria =  buildCriteria(mSession, oApplicationName);
           mGrantsQueryPage = new QueryPage(mCriteria, ApplicationConstants.ALL_PAGES, 1);

	   } catch (CommandDaoException ex) {
		   throw new CommandDaoException(" Query Execution Failed  " + ex.toString() );
       } finally {
		   SessionFactoryUtils.closeSessionIfNecessary(mSession, getSessionFactory());
       }

       return mGrantsQueryPage;
    }

    /*
     * Build the query object and build the UserQueryObject
     * - Create class instance for ReportsVw
     * - Create the Criteria object
     * - build the GrantsQueryCriteria from the parfent Class
     * throws a CommandDaoException
     * @retrun Criteria - a Criteria object
     */
    private Criteria buildCriteria(Session aSession, String  oApplicationName) throws CommandDaoException {

        Class mReportsVw = null;
        Criteria mCriteria = null;
        try{
            mReportsVw = Class.forName("gov.nih.nci.iscs.oracle.pgm.hibernate.ReportsVw");
		    mCriteria = aSession.createCriteria(mReportsVw);
		    mCriteria.add(Expression.eq("applicationName", oApplicationName.trim()) );
	    } catch (ClassNotFoundException e) {
			throw new CommandDaoException("Unable to create mReportsVw class " + e.toString());
	    } catch (Exception e) {
			throw new CommandDaoException("Unable to create buildCriteria for Query " + e.toString());
	    }
		return mCriteria;
	}

    /*
     * Build the query object and build the UserQueryObject
     * - Create class instance for ReportsVw
     * - Create the Criteria object
     * - build the GrantsQueryCriteria from the parfent Class
     * throws a CommandDaoException
     * @retrun Criteria - a Criteria object
     */
    private Criteria buildDetailsCriteria(Session aSession, Long rusId, Long rfrId) throws CommandDaoException {

        Class mReportsVw = null;
        Criteria mCriteria = null;
        try{
            mReportsVw = Class.forName("gov.nih.nci.iscs.oracle.pgm.hibernate.ReportsVw");
		    mCriteria = aSession.createCriteria(mReportsVw);
		    mCriteria.add(Expression.eq("rusId", rusId) );
		    mCriteria.add(Expression.eq("rfrId", rfrId) );
	    } catch (ClassNotFoundException e) {
			throw new CommandDaoException("Unable to create mReportsVw class " + e.toString());
	    } catch (Exception e) {
			throw new CommandDaoException("Unable to create buildCriteria for Query " + e.toString());
	    }
		return mCriteria;
	}

    public QueryPage getReportDetails(Long rusId, Long rfrId) {

	   QueryPage  mGrantsQueryPage = null;

       // get the session from the sessionFactory
       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       try {
		   // build the query string from query object
           Criteria mCriteria =  buildDetailsCriteria(mSession, rusId, rfrId);
           mGrantsQueryPage = new QueryPage(mCriteria, ApplicationConstants.ALL_PAGES, 1);

	   } catch (CommandDaoException ex) {
		   throw new CommandDaoException(" Query Execution Failed  " + ex.toString() );
       } finally {
		   SessionFactoryUtils.closeSessionIfNecessary(mSession, getSessionFactory());
       }

       return mGrantsQueryPage;
    }
}