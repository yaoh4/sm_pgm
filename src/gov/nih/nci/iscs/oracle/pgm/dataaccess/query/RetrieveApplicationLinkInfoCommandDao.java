package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.AccessCommandDao;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveApplicationLinkInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.exceptions.CommandDaoException;
import net.sf.hibernate.Criteria;
import net.sf.hibernate.Session;
import net.sf.hibernate.expression.Expression;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate.SessionFactoryUtils;

public class RetrieveApplicationLinkInfoCommandDao extends AccessCommandDao implements RetrieveApplicationLinkInfoCommand
{
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
    public RetrieveApplicationLinkInfoCommandDao() {}

    /*
     * The main method that handles the execution of the command.
     * - Get the session from the Session Factory
     * - Build the Query Criteria for the Criteria object
     * - execute the query and return the Query Page
     * @retrun aQueryPage - a QueryPage object that encapsulate the Pagination
     */
    public QueryPage execute(String  oApplicationName, String oUserId) {

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
     * - Create class instance for NciPdQueryVw
     * - Create the Criteria object
     * - build the GrantsQueryCriteria from the parfent Class
     * throws a CommandDaoException
     * @retrun Criteria - a Criteria object
     */
    private Criteria buildCriteria(Session aSession, String  oApplicationName) throws CommandDaoException {

        Class mGwbLinksT = null;
        Criteria mCriteria = null;
        try{
            mGwbLinksT = Class.forName("gov.nih.nci.iscs.oracle.pgm.hibernate.GwbLinksT");
    		    mCriteria = aSession.createCriteria(mGwbLinksT);
            mCriteria.add(Expression.eq("name", oApplicationName));
	    } catch (ClassNotFoundException e) {
			throw new CommandDaoException("Unable to create mReferralActivityVw class " + e.toString());
	    } catch (Exception e) {
			throw new CommandDaoException("Unable to create buildCriteria for Query " + e.toString());
	    }
		return mCriteria;
	}
}