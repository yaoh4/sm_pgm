package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;

// jdk imports
import java.lang.Class;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveCAHistoryCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.AccessCommandDao;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.exceptions.CommandDaoException;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

// Springfranework imports
import org.springframework.orm.hibernate.SessionFactoryUtils;

// hibernate imports
import net.sf.hibernate.Criteria;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.Order;
import net.sf.hibernate.Session;


public class RetrieveCAHistoryCommandDao extends AccessCommandDao implements  RetrieveCAHistoryCommand {
   /**
     * Concrete class that encapsulates the methods for retrieveing User Data
     *  from the database
     *
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.query.AccessCommandDao
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.dataaccess.RetrieveUserFilerInfoCommand
     * @author Michelle Engermann
     * @version 1.0
     */

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

   /*
    * Class constructor
    */
    public RetrieveCAHistoryCommandDao() {}


    /*
     * The main method that handles the execution of the command.
     * - Get the session from the Session Factory
     * - Build the Query Criteria for the Criteria object
     * - execute the query and return the Query Page
     * @retrun aQueryPage - a QueryPage object that encapsulate the Pagination
     */
    public QueryPage execute(Long oApplId, String oUserId) {

	   QueryPage  mGrantsQueryPage = null;

       // get the session from the sessionFactory
       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       try {
		   // build the query string from query object
           Criteria mCriteria =  buildCriteria(mSession, oApplId);
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
     * - Create class instance for ApplCaAsgnmtHistoryVw
     * - Create the Criteria object
     * - build the GrantsQueryCriteria from the parfent Class
     * throws a CommandDaoException
     * @retrun Criteria - a Criteria object
     */
    private Criteria buildCriteria(Session aSession, Long oApplId) throws CommandDaoException {

        Class mApplCaAsgnmtHistoryVw = null;
        Criteria mCriteria = null;
        try{
            mApplCaAsgnmtHistoryVw = Class.forName("gov.nih.nci.iscs.oracle.pgm.hibernate.ApplCaAsgnmtHistoryVw");
		    mCriteria = aSession.createCriteria(mApplCaAsgnmtHistoryVw);
		    mCriteria.add(Expression.eq("applId", oApplId ));
		    mCriteria.add(Expression.isNotNull("caEndDate" ));
			mCriteria.addOrder( Order.desc("caEndDate"));
	    } catch (ClassNotFoundException e) {
			throw new CommandDaoException("Unable to create ApplCaAsgnmtHistoryVw class " + e.toString());
	    } catch (Exception e) {
			throw new CommandDaoException("Unable to create buildCriteria for Query " + e.toString());
	    }
		return mCriteria;
	}

}