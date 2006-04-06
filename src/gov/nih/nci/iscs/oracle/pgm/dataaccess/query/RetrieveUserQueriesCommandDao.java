package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;

// jdk imports
import java.lang.Class;
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveUserQueriesCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.AccessCommandDao;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.exceptions.CommandDaoException;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

// Springfranework imports
import org.springframework.orm.hibernate.HibernateInterceptor;
import org.springframework.orm.hibernate.SessionFactoryUtils;

// hibernate imports
import net.sf.hibernate.Criteria;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.Order;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;


public class RetrieveUserQueriesCommandDao extends AccessCommandDao implements  RetrieveUserQueriesCommand {
   /**
     * Concrete class that encapsulates the methods for retrieveing User Data
     *  from the database
     *
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.query.AccessCommandDao
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.dataaccess.RetrieveUserQueriesCommand
     * @author Michelle Engermann
     * @version 1.0
     */

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

   /*
    * Class constructor
    */
    public RetrieveUserQueriesCommandDao() {}

    /*
     * The main method that handles the execution of the command.
     * - Get the session from the Session Factory
     * - Build the Query Criteria for the Criteria object
     * - execute the query and return the Query Page
     * @retrun aQueryPage - a QueryPage object that encapsulate the Pagination
     */
    public QueryPage execute(String oUserQueryId) {

	   QueryPage  mUserQueryPage = null;

       // get the session from the sessionFactory
       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       try {
		   // build the query string from query object
           Criteria mCriteria =  buildCriteria(mSession, oUserQueryId);
           mUserQueryPage = new QueryPage(mCriteria, ApplicationConstants.ALL_PAGES, ApplicationConstants.ALL_PAGES);
       } catch (CommandDaoException ex) {
		   throw new CommandDaoException("Query Execution Failed " + ex.toString() );
       }

       return mUserQueryPage;
    }


    /*
     * Build the query object and build the UserQueryObject
     * - Create class instance for DbaRolePrivs
     * - Create the Criteria object
     * - build the GrantsQueryCriteria from the parfent Class
     * throws a CommandDaoException
     * @retrun Criteria - a Criteria object
     */

    private Criteria buildCriteria(Session aSession, String oUserQueryId) throws CommandDaoException {

        Class mDbaRolePrivs = null;
        Criteria mCriteria = null;
        try{
            mDbaRolePrivs = Class.forName("gov.nih.nci.iscs.oracle.pgm.hibernate.DbaRolePrivs");
		    mCriteria = aSession.createCriteria(mDbaRolePrivs);
		    if (oUserQueryId != null ) {
				mCriteria.add(Expression.eq("grantee", oUserQueryId ));
		    } else {
				throw new CommandDaoException("No search criteria for Query");
		    }
	    } catch (ClassNotFoundException e) {
			throw new CommandDaoException("Unable to create DbaRolePrivs class " + e.toString());
	    } catch (Exception e) {
			throw new CommandDaoException(e.toString());
	    }
		return mCriteria;
    }




}