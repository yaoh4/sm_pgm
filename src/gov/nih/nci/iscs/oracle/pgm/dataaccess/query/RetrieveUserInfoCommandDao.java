package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;

// jdk imports
import java.lang.Class;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveUserInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.AccessCommandDao;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.exceptions.CommandDaoException;
import gov.nih.nci.iscs.oracle.pgm.hibernate.NciPeopleVw;
import gov.nih.nci.iscs.oracle.pgm.hibernate.DbaRolePrivs;
import gov.nih.nci.iscs.oracle.pgm.hibernate.I2eActiveUserRolesVw;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;


// Springfranework imports
import org.springframework.orm.hibernate.SessionFactoryUtils;

// hibernate imports
import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.Order;
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
     * This method retrieves information of logged in user from NciPeopleVw.
     * @param userId    
     * @return nciPeopleVw    
     */
    public NciPeopleVw getNCIUserInformation(String userId) throws Exception{ 
    	NciPeopleVw nciPeopleVw = null;
    	Criteria criteria = null;
    	Session session = null;
    	try{
    		session = SessionFactoryUtils.getSession(getSessionFactory(), true);
    		criteria = session.createCriteria(NciPeopleVw.class);      		
    		criteria.add(Expression.eq("nihNetworkId", userId.toUpperCase()));    		
    		nciPeopleVw = (NciPeopleVw) criteria.uniqueResult();
        	
    	} catch (Throwable ex) {
    		throw new CommandDaoException("Error occurred while retrieving I2E Account of NCI User with nihNetworkId: "+userId);			
		}
    	finally{
    		if(session != null){
    			SessionFactoryUtils.closeSessionIfNecessary(session, getSessionFactory());
    		}
    	}    	
    	return nciPeopleVw;
    } 
      
       /**
        * This method checks if logged in user is RestrictedUser.
        * @param  oracleId
        * @return boolean
        */
       @SuppressWarnings("unchecked")
       public boolean isRestrictedUser(String oracleId){ 
       	boolean isRestrictedUser = false;
       	Session session = null;
       	try{
       		session = SessionFactoryUtils.getSession(getSessionFactory(), true);
       		Criteria rolesCriteria = session.createCriteria(DbaRolePrivs.class);
           	rolesCriteria.add(Expression.eq("grantee", oracleId));
           	List<DbaRolePrivs> roles = (List<DbaRolePrivs>) rolesCriteria.list();
       		for(DbaRolePrivs role : roles){
       			if(ApplicationConstants.I2E_RESTRICTED_USER.equalsIgnoreCase(role.getGrantedRole())){
       				isRestrictedUser = true;
       				logger.info("I2E Account with oracleId : "+oracleId + " is Restricted.");
       				break;
       			}
       		}

       	} catch (Throwable ex) {  	
       		throw new CommandDaoException("Error occurred while retrieving NCI User Roles with oracleId: "+oracleId);
       	}
       	finally{
       		if(session != null){
       			SessionFactoryUtils.closeSessionIfNecessary(session, getSessionFactory());
       		}
       	}    	
       	return isRestrictedUser;
       }


	@Override
	public List getUserAppRoles(String userId) {
		// get available ldap roles/npe id based on user's npn id
    	Session session = null;
        List<I2eActiveUserRolesVw> result = null;
        try {
        	session = SessionFactoryUtils.getSession(getSessionFactory(), true);
            Criteria criteria = session.createCriteria(I2eActiveUserRolesVw.class);
            criteria.add(Expression.eq("nciLdapCn", userId));
            criteria.addOrder(Order.desc("npeId"));
            result = criteria.list();         
            return result;
        } catch (Exception e) {
        	logger.error("Error occured while retrieving role info for user " + userId, e);
        	throw new CommandDaoException("Error occured while retrieving role info for user "+userId);
        } finally {
        	if(session != null){
        		SessionFactoryUtils.closeSessionIfNecessary(session, getSessionFactory());
    		}
        } // end finally
	}

	public List<NciPeopleVw> searchUser(String firstName, String lastName) throws Exception {
	 	Session session = null;
       	Criteria criteria = null;
       	List<NciPeopleVw> result = null; 
       	try {
       		session = SessionFactoryUtils.getSession(getSessionFactory(), true);
       		criteria = session.createCriteria(NciPeopleVw.class);
       		 if (StringUtils.isNotEmpty(firstName)) {
       			 criteria.add(Expression.like("firstName", firstName + "%").ignoreCase());
       		 }
       		 if (StringUtils.isNotEmpty(lastName)) {
       			 criteria.add(Expression.like("lastName", lastName + "%").ignoreCase());
       		 }
       		result = criteria.list();
       	}
       	catch (Exception e) {
           	logger.error("Error occured while results " + firstName +lastName, e);
           	throw new CommandDaoException("Error occured while results " + firstName +lastName);
           } finally {
           	if(session != null){
           		SessionFactoryUtils.closeSessionIfNecessary(session, getSessionFactory());
       		}
           }
       	
       	return result;
	}
}