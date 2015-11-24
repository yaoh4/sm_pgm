package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;

// jdk imports
import java.lang.Class;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveUserInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.AccessCommandDao;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.exceptions.CommandDaoException;
import gov.nih.nci.iscs.oracle.pgm.hibernate.NciPeopleT;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;


// Springfranework imports
import org.springframework.orm.hibernate.SessionFactoryUtils;

// hibernate imports
import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.Session;


public class RetrieveUserInfoCommandDao extends AccessCommandDao implements  RetrieveUserInfoCommand {
   /**
     * Concrete class that encapsulates the methods for retrieveing User Data
     *  from the database
     *
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.query.AccessCommandDao
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.dataaccess.RetrieveUserInfoCommand
     * @author Michelle Engermann
     * @version 1.0
     */

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

   /*
    * Class constructor
    */
    public RetrieveUserInfoCommandDao() {}


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
       } finally {
	   	   SessionFactoryUtils.closeSessionIfNecessary(mSession, getSessionFactory());
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

    /**
     * This method checks if logged in user is Valid.
     * @param oracleId
     * @return boolean
     * @throws HibernateException 
     */
    public boolean isNciUserValid(String oracleId) throws HibernateException{
    	logger.info("Validating NCIUser with oracleId : "+oracleId);
    	boolean isNciUserValid = true; 
    	Session sess = null;
    	Criteria criteria = null;
    	try{
    		sess = SessionFactoryUtils.getSession(getSessionFactory(), true);
    		criteria = sess.createCriteria(NciPeopleT.class);     
    		criteria.add(Expression.eq("userId", oracleId.toUpperCase()));
    		NciPeopleT nciUser = (NciPeopleT) criteria.uniqueResult();
    		if(nciUser == null || nciUser.getInactiveDate() != null){
        		isNciUserValid = false;
        	}  

    	} catch (CommandDaoException re) {
    		logger.error("Error occurred while validating NCIUser : ", re);
			throw re;
		}
    	finally {
    		if(sess != null){
    			 SessionFactoryUtils.closeSessionIfNecessary(sess, getSessionFactory());
    		}
    	} 
    	  	
    	logger.info("Is NCIUser with oracleId : "+oracleId+" Valid? --> "+ isNciUserValid);
    	return isNciUserValid;
    }
}