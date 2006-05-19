package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;

import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.RetrieveGrantsCommandDao;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveGrantsForPDACommand;
import gov.nih.nci.iscs.oracle.pgm.service.PDAQueryObject;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.exceptions.CommandDaoException;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import gov.nih.nci.iscs.oracle.pgm.service.GrantQueryObject;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import gov.nih.nci.iscs.oracle.pgm.service.GrantQueryObject;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import gov.nih.nci.iscs.oracle.pgm.service.GrantQueryObject;


// Springfranework imports
import org.springframework.orm.hibernate.HibernateInterceptor;
import org.springframework.orm.hibernate.SessionFactoryUtils;


// hibernate imports
import net.sf.hibernate.*;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.*;
import net.sf.hibernate.expression.Order;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;


public class RetrieveGrantsForPDACommandDao extends RetrieveGrantsCommandDao implements  RetrieveGrantsForPDACommand {
   /**
     * RetrieveGrantsForPDACommandDao encapsulates the implementation logic for retrieveing
     * Grants from the database for Program Director assignment actiosn based on search criteria entered.
     *
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.query.RetrieveGrantsCommandDao
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.dataaccess.RetrieveGrantsForReferalCommand
     * @author Michelle Engermann
     * @version 1.0
     */

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    private List interceptorNames;
    public static final String PERCENT_SYMBOL = "%";

   /*
    * Class constructor
    */
    public RetrieveGrantsForPDACommandDao() {}

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
		   throw new CommandDaoException("Query Execution Failed  " + ex.toString());
       } finally {
		   SessionFactoryUtils.closeSessionIfNecessary(mSession, getSessionFactory());
       }

       return mGrantsQueryPage;
    }


    /*
     * Build the Criteria object and build the sreach Criteria using the QueryObject
     * - Create class instance for NciPdTransferVw
     * - Create the Criteria object
     * - build the GrantsQueryCriteria from the parfent Class
     * throws a CommandDaoException
     * @retrun Criteria - a Criteria object
     */

    protected Criteria buildCriteria(Session aSession, UserFilterInfo oUserFilterInfo, GrantQueryObject oGrantQueryObject) throws CommandDaoException {

		Criteria aCriteria = null;
        Class mNciPdTransferVw = null;
        try{
            mNciPdTransferVw = Class.forName("gov.nih.nci.iscs.oracle.pgm.hibernate.NciPdTransferVw");
		    aCriteria = aSession.createCriteria(mNciPdTransferVw);
		    aCriteria = this.buildGrantsQueryCriteria(aCriteria, oUserFilterInfo, oGrantQueryObject);
	    } catch (ClassNotFoundException e) {
			throw new CommandDaoException("Unable to create mNciPdTransferVw class " + e.toString());
	    } catch (Exception e) {
			throw new CommandDaoException("Unable to create buildCriteria for Query " + e.toString());
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


        PDAQueryObject aGrantQueryObject = (PDAQueryObject) oGrantQueryObject;

		if(!(aGrantQueryObject.getIrgFlexCode() == null|| aGrantQueryObject.getIrgFlexCode().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ))
		   aCriteria.add(Expression.like("irgFlexCode", aGrantQueryObject.getIrgFlexCode().toUpperCase().trim() + PERCENT_SYMBOL ));

		// add the PdOrgName search criterion

		// add the BarFlag search criterion
		String mBarFlag = "NO";
		//if(aGrantQueryObject.getBarFlag())
		//   mBarFlag = "YES";
		//   aCriteria.add(Expression.like("barFlag", mBarFlag));
		// add the ApplStatusCode search criterion



		// add the Ipf search criterion
		if(!(aGrantQueryObject.getIpf() == null || aGrantQueryObject.getIpf().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ))
		   aCriteria.add(Expression.eq("ipf", new Long(aGrantQueryObject.getIpf()) ));

	    // add the IrgCode  search criterion
		if(!(aGrantQueryObject.getIrgCode() == null || aGrantQueryObject.getIrgCode().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ))
		   aCriteria.add(Expression.ilike("irgCode", aGrantQueryObject.getIrgCode().toUpperCase().trim() + PERCENT_SYMBOL ));

		// add the GroupCode search criterion
		if(!(aGrantQueryObject.getGroupCode() == null || aGrantQueryObject.getGroupCode().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ))
		   aCriteria.add(Expression.ilike("groupCode", aGrantQueryObject.getGroupCode().toUpperCase().trim() + PERCENT_SYMBOL ));

		// add the IrgFlexCode search criterion
		if(!(aGrantQueryObject.getPdOrg() == null || aGrantQueryObject.getPdOrg().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)) )
		   aCriteria.add(Expression.eq("pdNonId", new Long(aGrantQueryObject.getPdOrg()) ));
		// add the PdFullName search criterion

		if(!(aGrantQueryObject.getPdId() == null || aGrantQueryObject.getPdId().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)))
		   aCriteria.add(Expression.eq("pdNpnId", new Long(aGrantQueryObject.getPdId())  ));

		if(!(aGrantQueryObject.getI2Status() == null || aGrantQueryObject.getI2Status().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)) )
		   aCriteria.add(Expression.ilike("applStatusGroupCode", aGrantQueryObject.getI2Status().toUpperCase().trim() + PERCENT_SYMBOL ));

		// add the PriorityScoreNum from and to date search criterion
		if(!(aGrantQueryObject.getPriorityScoreFrom() == null || aGrantQueryObject.getPriorityScoreFrom().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)) ) {
			if(aGrantQueryObject.getPriorityScoreTo() == null) {
				aGrantQueryObject.setPriorityScoreTo(aGrantQueryObject.getPriorityScoreFrom());
		    }
		   aCriteria.add(Expression.between("priorityScoreNum", aGrantQueryObject.getPriorityScoreFromInt(), aGrantQueryObject.getPriorityScoreToInt() ));
		}

		// add the IrgPercentileNum from and to search criterion
		if(!(aGrantQueryObject.getPercentileFrom() == null || aGrantQueryObject.getPercentileFrom().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING))) {
			if(aGrantQueryObject.getPercentileTo() == null ){
				aGrantQueryObject.setPercentileTo(aGrantQueryObject.getPercentileFrom());
		    }
		   aCriteria.add(Expression.between("irgPercentileNum", aGrantQueryObject.getPercentileFromBD(), aGrantQueryObject.getPercentileToBD()));
	    }


        aCriteria = super.buildGrantsQueryCriteria(aCriteria, oUserFilterInfo, aGrantQueryObject);

	    /*Disjunction councilDateCrit = Expression.disjunction();
	    Disjunction intialTransferCrit = Expression.disjunction();
	    Disjunction pdTransferCrit = Expression.disjunction();

		councilDateCrit.add(Expression.ilike("councilMeetingDate", "%00"));

		councilDateCrit.add(Expression.ilike("pdTransferInitialCode", "%T"));

		councilDateCrit.add(Expression.and( Expression.eq("pdTransferInitialCode", "%I"),
		                                    Expression.eq("currentFutureBoardFlag", "N")));

		aCriteria.add(councilDateCrit);
		*/

	    // add programDirectorFlag criteria
	    if (aGrantQueryObject.getGrantsFromCriteria().equalsIgnoreCase(ApplicationConstants.MY_PORTFOLIOS_VALUE) ) {
	        Object[] valuesArray = new Object[oUserFilterInfo.getProgramDirectorIds().size()];
	        Iterator mIterator = oUserFilterInfo.getProgramDirectorIds().iterator();
	        int i=0;
	        while(mIterator.hasNext()) {
		        String mtemp = (String) mIterator.next();
	            Long tempValue = new Long(new String(mtemp.replaceAll("'", "")) );
			    valuesArray[i] = tempValue;
			    i++;
		    }
		    aCriteria.add(Expression.in("pdNpeId",valuesArray));
		}


	    return aCriteria;

    }

}