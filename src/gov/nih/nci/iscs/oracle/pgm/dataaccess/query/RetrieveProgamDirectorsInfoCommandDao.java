package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;

// jdk imports
import java.lang.Class;
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveProgamDirectorsInfoCommand;
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


public class RetrieveProgamDirectorsInfoCommandDao extends AccessCommandDao implements  RetrieveProgamDirectorsInfoCommand {
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
    private String  oCancerActivity;

   /*
    * Class constructor
    */
    public RetrieveProgamDirectorsInfoCommandDao() {}

     public void setCancerActivity(String aCancerActivity){
		 this.oCancerActivity = aCancerActivity;
     }

    /*
     * The main method that handles the execution of the command.
     * - Get the session from the Session Factory
     * - Build the Query Criteria for the Criteria object
     * - execute the query and return the Query Page
     * @retrun aQueryPage - a QueryPage object that encapsulate the Pagination
     */
    public QueryPage execute(TreeSet  oCancerActivities, String oUserId) {

	   QueryPage  mGrantsQueryPage = null;

       // get the session from the sessionFactory
       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       try {
		   // build the query string from query object
           Criteria mCriteria =  buildCriteria(mSession, oCancerActivities);
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
     * - Create class instance for PdCaAsgnmtVw
     * - Create the Criteria object
     * - build the GrantsQueryCriteria from the parfent Class
     * throws a CommandDaoException
     * @retrun Criteria - a Criteria object
     */
    private Criteria buildCriteria(Session aSession, TreeSet  oCancerActivities) throws CommandDaoException {

        Class mPdCaAsgnmtVw = null;
        Criteria mCriteria = null;
        try{
            mPdCaAsgnmtVw = Class.forName("gov.nih.nci.iscs.oracle.pgm.hibernate.PdCaAsgnmtVw");
		    mCriteria = aSession.createCriteria(mPdCaAsgnmtVw);
	        String[] valuesArray = new String[oCancerActivities.size()];
	        Iterator mIterator = oCancerActivities.iterator();
	        int i=0;
	        while(mIterator.hasNext()) {
			    String mtemp = (String) mIterator.next();
	            String tempValue = new String(mtemp.replaceAll("'", "") );
			    valuesArray[i] = tempValue;
			    i++;
		    }
		    mCriteria.add(Expression.in("cayCode",valuesArray));
		    mCriteria.addOrder( Order.asc("pdName"));

	    } catch (ClassNotFoundException e) {
			throw new CommandDaoException("Unable to create PdCaAsgnmtVw class " + e.toString());
	    } catch (Exception e) {
			throw new CommandDaoException("Unable to create buildCriteria for Query " + e.toString());
	    }
		return mCriteria;
	}

}