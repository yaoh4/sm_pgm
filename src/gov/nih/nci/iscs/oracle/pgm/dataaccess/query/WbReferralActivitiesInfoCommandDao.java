package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;

// jdk imports
import java.lang.Class;
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.WbReferralActivitiesInfoCommand;
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
import net.sf.hibernate.expression.Order;


public class WbReferralActivitiesInfoCommandDao extends AccessCommandDao implements  WbReferralActivitiesInfoCommand {
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
    public WbReferralActivitiesInfoCommandDao() {}

    /*
     * The main method that handles the execution of the command.
     * - Get the session from the Session Factory
     * - Build the Query Criteria for the Criteria object
     * - execute the query and return the Query Page
     * @retrun aQueryPage - a QueryPage object that encapsulate the Pagination
     */
    public QueryPage execute(String  oCouncilMeetingDate, List cancerActivities, String oUserId) {

	   QueryPage  mGrantsQueryPage = null;

       // get the session from the sessionFactory
       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       try {
		   // build the query string from query object
           Criteria mCriteria =  buildCriteria(mSession, oCouncilMeetingDate, cancerActivities);
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
     * - Create class instance for ReferralActivityVw
     * - Create the Criteria object
     * - build the GrantsQueryCriteria from the parfent Class
     * throws a CommandDaoException
     * @retrun Criteria - a Criteria object
     */
    private Criteria buildCriteria(Session aSession, String  oCouncilMeetingDate, List cancerActivities) throws CommandDaoException {

        Class mReferralActivityVw = null;
        Criteria mCriteria = null;
        try{
            mReferralActivityVw = Class.forName("gov.nih.nci.iscs.oracle.pgm.hibernate.ReferralActivityVw");
    		    mCriteria = aSession.createCriteria(mReferralActivityVw);
	          mCriteria.addOrder(Order.asc("cayCode"));
	          mCriteria.add(Expression.eq("councilMeetingDate", oCouncilMeetingDate) );
            if (cancerActivities == null)
            {
               cancerActivities = new ArrayList(1);
               cancerActivities.add("P-");
            }
            Iterator cancerActivitiesIterator = cancerActivities.iterator();
            Object[] cancerActivitiesArray = new Object[cancerActivities.size()];
            int i=0;
            while (cancerActivitiesIterator.hasNext()) 
            {
               String cancerActivity = (String)cancerActivitiesIterator.next();
               cancerActivitiesArray[i++] = new String(cancerActivity.replaceAll("'", "") );
            }
             mCriteria.add(Expression.in("cayCode",cancerActivitiesArray));
	    } catch (ClassNotFoundException e) {
			throw new CommandDaoException("Unable to create mReferralActivityVw class " + e.toString());
	    } catch (Exception e) {
			throw new CommandDaoException("Unable to create buildCriteria for Query " + e.toString());
	    }
		return mCriteria;
	}
}