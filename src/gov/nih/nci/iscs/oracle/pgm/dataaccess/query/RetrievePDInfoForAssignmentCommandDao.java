package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;

// jdk imports
import java.lang.Class;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrievePDInfoForAssignmentCommand;
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


public class RetrievePDInfoForAssignmentCommandDao extends AccessCommandDao implements  RetrievePDInfoForAssignmentCommand {
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
    public RetrievePDInfoForAssignmentCommandDao() {}


    /*
     * The main method that handles the execution of the command.
     * - Get the session from the Session Factory
     * - Build the Query Criteria for the Criteria object
     * - execute the query and return the Query Page
     * @retrun aQueryPage - a QueryPage object that encapsulate the Pagination
     */
    public QueryPage execute(String  oCancerActivity, String oViewName, String oUserId) {

	   QueryPage  mGrantsQueryPage = null;
	   Criteria mCriteria = null;

       // get the session from the sessionFactory
       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       try {
		   // build the query string from query object
		   if(oViewName.equalsIgnoreCase("pdOrgVw4")){
			  mCriteria =  buildPdOrgVw4Criteria(mSession, oCancerActivity);
		   }
		   if(oViewName.equalsIgnoreCase("pdCaAsgnmtVw")){
			  mCriteria =  buildPdCaAsgnmtVwCriteria(mSession, oCancerActivity);
		   }
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
     * - Create class instance for PdOrgVw4
     * - Create the Criteria object
     * - build the GrantsQueryCriteria from the parfent Class
     * throws a CommandDaoException
     * @retrun Criteria - a Criteria object
     */
    private Criteria buildPdOrgVw4Criteria(Session aSession, String  oCancerActivity) throws CommandDaoException {

        Class mPdOrgVw4 = null;
        Criteria mCriteria = null;
        try{
            mPdOrgVw4 = Class.forName("gov.nih.nci.iscs.oracle.pgm.hibernate.PdOrgVw4");
		    mCriteria = aSession.createCriteria(mPdOrgVw4);
		    if(oCancerActivity != null &
		       !oCancerActivity.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ) {
				mCriteria.add(Expression.eq("cayCode", oCancerActivity.toUpperCase().trim()) );
			}
		    mCriteria.addOrder( Order.asc("pdName"));
	    } catch (ClassNotFoundException e) {
			throw new CommandDaoException("Unable to create mPdOrgVw4 class " + e.toString());
	    } catch (Exception e) {
			throw new CommandDaoException("Unable to create buildCriteria for Query " + e.toString());
	    }
		return mCriteria;
	}
    /*
     * Build the query object and build the UserQueryObject
     * - Create class instance for PdCaAsgnmtVw
     * - Create the Criteria object
     * - build the GrantsQueryCriteria from the parfent Class
     * throws a CommandDaoException
     * @retrun Criteria - a Criteria object
     */
    private Criteria buildPdCaAsgnmtVwCriteria(Session aSession, String  oCancerActivity) throws CommandDaoException {

        Class mPdCaAsgnmtVw = null;
        Criteria mCriteria = null;
        try{
            mPdCaAsgnmtVw = Class.forName("gov.nih.nci.iscs.oracle.pgm.hibernate.PdCaAsgnmtVw");
		    mCriteria = aSession.createCriteria(mPdCaAsgnmtVw);
		    mCriteria.addOrder( Order.asc("pdName"));
	    } catch (ClassNotFoundException e) {
			throw new CommandDaoException("Unable to create PdCaAsgnmtVw class " + e.toString());
	    } catch (Exception e) {
			throw new CommandDaoException("Unable to create buildCriteria for Query " + e.toString());
	    }
		return mCriteria;
	}

}