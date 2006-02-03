package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;

import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.RetrieveGrantsCommandDao;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveGrantsForReferalCommand;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralQueryObject;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.exceptions.CommandDaoException;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import gov.nih.nci.iscs.oracle.pgm.service.GrantQueryObject;


// Springfranework imports
import org.springframework.orm.hibernate.HibernateInterceptor;
import org.springframework.orm.hibernate.SessionFactoryUtils;


// hibernate imports
import net.sf.hibernate.Criteria;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.Order;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;


public class RetrieveGrantsForReferalCommandDao extends RetrieveGrantsCommandDao implements  RetrieveGrantsForReferalCommand {
   /**
     * RetrieveGrantsForReferalCommandDao encapsulates the implementation logic for retrieveing
     * Grants from the database for referal actiosn based on search criteria entered.
     *
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.query.RetrieveGrantsCommandDao
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.dataaccess.RetrieveGrantsForReferalCommand
     * @author Michelle Engermann
     * @version 1.0
     */

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    private List interceptorNames;

   /*
    * Class constructor
    */
    public RetrieveGrantsForReferalCommandDao() {
		super();
	}

    /*
     * The main method that handles the execution of the command.
     * - Get the session from the Session Factory
     * - Build the Query Criteria for the Criteria object
     * - execute the query and return the Query Page
     * @retrun aQueryPage - a QueryPage object that encapsulate the Pagination
     */

    public QueryPage execute(UserFilterInfo oUserFilterInfo,
                             GrantQueryObject oGrantQueryObject,
                             int pageNumber, int pageSize, String oUserId) {

	   QueryPage  mGrantsQueryPage = null;

       // get the session from the sessionFactory

       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       try {
		   // build the query string from query object
           Criteria mCriteria =  buildCriteria(mSession, oUserFilterInfo, oGrantQueryObject);
           mGrantsQueryPage = new QueryPage(mCriteria, pageNumber, pageSize);

	   } catch (CommandDaoException ex) {
		   throw new CommandDaoException(" Query Execution Failed  " + ex.toString() );
       } finally {
		   SessionFactoryUtils.closeSessionIfNecessary(mSession, getSessionFactory());
       }

       return mGrantsQueryPage;
    }

    /*
     * Build the Criteria object and build the sreach Criteria using the QueryObject
     * - Create class instance for NciPdQueryVw
     * - Create the Criteria object
     * - build the GrantsQueryCriteria from the parfent Class
     * throws a CommandDaoException
     * @retrun Criteria - a Criteria object
     */

    protected Criteria buildCriteria(Session aSession, UserFilterInfo oUserFilterInfo, GrantQueryObject oGrantQueryObject) throws CommandDaoException {
		Criteria aCriteria = null;
		try {
		    aCriteria = super.buildCriteria(aSession);
		    //if (!(super.getQueryObject().isNull()) ) {
			    aCriteria = buildGrantsQueryCriteria(aCriteria, oUserFilterInfo, oGrantQueryObject);
		    //} else {
			//    throw new CommandDaoException("No search criteria for Query");
		    //}
        } catch (Exception e) {
			throw new CommandDaoException(e.toString());
	    }
	    return aCriteria;

	}

    /*
     * This method builds the search Criteria for the Program Director assignment
     * Grants search criteria
     * @param Criteria - a Criteria Object
     * @param GrantQueryObject - a GrantQueryObject Object
     * @retrun Criteria - a Criteria object with seach Criteria/ or null
     */

    protected Criteria buildGrantsQueryCriteria(Criteria aCriteria, UserFilterInfo oUserFilterInfo, GrantQueryObject oGrantQueryObject) {


        String mYesLiteral = "Y";
        ReferralQueryObject aGrantQueryObject = (ReferralQueryObject) oGrantQueryObject;

		// add the araStatusCode search criterion
		if(aGrantQueryObject.getAllowAraNotNull() != null) {
		   if(aGrantQueryObject.getAllowAraNotNull_boolean())
		      aCriteria.add(Expression.eq("araMatchFlag", mYesLiteral));
		}

		// add the getAllowDualsNotNulll search criterion
		if(aGrantQueryObject.getAllowDualsNotNull() != null) {
	       if(aGrantQueryObject.getAllowDualsNotNull_boolean())
		      aCriteria.add(Expression.isNotNull("dualCayCode" ));
		}

        aCriteria = super.buildGrantsQueryCriteria(aCriteria, oUserFilterInfo, aGrantQueryObject);
		// add getCurrentReferralActivityCode must be not be null
		//aCriteria.add(Expression.eq("activeReferralFlag", mYesLiteral));
		aCriteria.add(Expression.isNotNull("currentReferralActivityCode"));

	    return aCriteria;

    }
}
