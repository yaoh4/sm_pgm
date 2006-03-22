package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;

// jdk imports
import java.lang.Class;
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;

// application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveGrantInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.AccessCommandDao;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.exceptions.CommandDaoException;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;

// Springfranework imports
import org.springframework.orm.hibernate.HibernateInterceptor;
import org.springframework.orm.hibernate.SessionFactoryUtils;

// hibernate imports
import net.sf.hibernate.Criteria;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.Order;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;


public class RetrieveGrantInfoCommandDao extends AccessCommandDao implements  RetrieveGrantInfoCommand {
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
    public RetrieveGrantInfoCommandDao() {}


    /*
     * The main method that handles the execution of the command.
     * - Get the session from the Session Factory
     * - Build the Query Criteria for the Criteria object
     * - execute the query and return the Query Page
     * @retrun aQueryPage - a QueryPage object that encapsulate the Pagination
     */
    public QueryPage execute(Long  oApplId, String oCancerActivity, String oUserId, String oAction) {

	   QueryPage  mGrantsQueryPage = null;
	   Criteria mCriteria = null;

       // get the session from the sessionFactory
       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       try {
		   // build the query string from query object
         if(oAction.equalsIgnoreCase(ApplicationConstants.REFERRAL) ){
			mCriteria =  buildReferralCriteria(mSession, oApplId,  oCancerActivity);
		 }else{
			if(oAction.equalsIgnoreCase(ApplicationConstants.PD_ASSIGNMENT)) {
			   mCriteria =  buildTransferCriteria(mSession, oApplId,  oCancerActivity);
			}
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
     * - Create class instance for NciPdReferralVw
     * - Create the Criteria object
     * - build the GrantsQueryCriteria from the parfent Class
     * throws a CommandDaoException
     * @retrun Criteria - a Criteria object
     */
    private Criteria buildReferralCriteria(Session aSession, Long  oApplId, String oCancerActivity) throws CommandDaoException {

        Class mNciPdReferralVw = null;
        Criteria mCriteria = null;
        try{
            mNciPdReferralVw = Class.forName("gov.nih.nci.iscs.oracle.pgm.hibernate.NciPdReferralVw");
		    mCriteria = aSession.createCriteria(mNciPdReferralVw);
		    mCriteria.add(Expression.eq("applId",  oApplId ));
		    if(oCancerActivity != null)
		        mCriteria.add(Expression.eq("cayCode",  oCancerActivity ));
	    } catch (ClassNotFoundException e) {
			throw new CommandDaoException("Unable to create NciPdReferralVw class " + e.toString());
	    } catch (Exception e) {
			throw new CommandDaoException("Unable to create buildCriteria for Query " + e.toString());
	    }
		return mCriteria;
	}

    /*
     * Build the query object and build the UserQueryObject
     * - Create class instance for NciPdTransferVw
     * - Create the Criteria object
     * - build the GrantsQueryCriteria from the parfent Class
     * throws a CommandDaoException
     * @retrun Criteria - a Criteria object
     */
    private Criteria buildTransferCriteria(Session aSession, Long  oApplId, String oCancerActivity) throws CommandDaoException {

        Class mNciPdTransferVw = null;
        Criteria mCriteria = null;
        try{
            mNciPdTransferVw = Class.forName("gov.nih.nci.iscs.oracle.pgm.hibernate.NciPdTransferVw");
		    mCriteria = aSession.createCriteria(mNciPdTransferVw);
		    mCriteria.add(Expression.eq("applId",  oApplId ));
		    if(oCancerActivity != null)
		        mCriteria.add(Expression.eq("cayCode",  oCancerActivity ));
	    } catch (ClassNotFoundException e) {
			throw new CommandDaoException("Unable to create NciPdTransferVw class " + e.toString());
	    } catch (Exception e) {
			throw new CommandDaoException("Unable to create buildCriteria for Query " + e.toString());
	    }
		return mCriteria;
	}



}