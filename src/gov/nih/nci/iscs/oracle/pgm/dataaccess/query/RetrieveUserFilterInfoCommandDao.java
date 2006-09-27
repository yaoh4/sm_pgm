package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;

// jdk imports
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

// application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveUserFilterInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.ActionCommandDao;
import gov.nih.nci.iscs.oracle.pgm.exceptions.CommandDaoException;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;

// Springfranework imports
import org.springframework.orm.hibernate.SessionFactoryUtils;

// hibernate imports
import net.sf.hibernate.Session;


public class RetrieveUserFilterInfoCommandDao extends ActionCommandDao implements  RetrieveUserFilterInfoCommand {
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
    public RetrieveUserFilterInfoCommandDao() {}


    /*
     * The main method that handles the execution of the command.
     * - Get the session from the Session Factory
     * - Build the Query Criteria for the Criteria object
     * - execute the query and return the Query Page
     * @retrun aQueryPage - a QueryPage object that encapsulate the Pagination
     */
    public UserFilterInfo execute(String oUserId) {

       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       Connection mConnection = getConnection(mSession, oUserId);
       UserFilterInfo oUserFilterInfo;
       try {
          oUserFilterInfo = executeQuery(mConnection, oUserId);


	   } catch (CommandDaoException ex) {
		   throw new CommandDaoException("Execution failed for UserFilterInfo" + ex.toString() );
       } finally {
		   SessionFactoryUtils.closeSessionIfNecessary(mSession, getSessionFactory());
       }

	   return oUserFilterInfo;
    }

    /*
     * Build the query object and build the UserQueryObject
     * - Create the Criteria object
     * - build the GrantsQueryCriteria from the parfent Class
     * throws a CommandDaoException
     * @retrun Criteria - a Criteria object
     */

    private UserFilterInfo executeQuery(Connection connection, String oUserId) throws CommandDaoException {

       UserFilterInfo oUserFilterInfo = new UserFilterInfo();
       boolean mReturnVal = true;
       String  mPGM = new String ("PGM");
       String mYes = "Y";
       ResultSet mResultSet = null;
       ArrayList mTempList = null;
       StringTokenizer mTokens = null;
       CallableStatement mCallableStatement = null;
       String mQueryString = "{call USER_INFO_PKG.retrieve_person_information(?,?,?,?,?,?,?,?,?)}";

       try {

		      mCallableStatement = connection.prepareCall(mQueryString);
              mCallableStatement.setString(1, oUserId);
              mCallableStatement.setString(2, mPGM);
              mCallableStatement.registerOutParameter(3, Types.NUMERIC);
              mCallableStatement.registerOutParameter(4, Types.VARCHAR);
              mCallableStatement.registerOutParameter(5, Types.VARCHAR);
              mCallableStatement.registerOutParameter(6, Types.VARCHAR);
              mCallableStatement.registerOutParameter(7, Types.VARCHAR);
              mCallableStatement.registerOutParameter(8, Types.VARCHAR);
              mCallableStatement.registerOutParameter(9, Types.VARCHAR);
              mCallableStatement.execute();
    		  oUserFilterInfo.setOracleId(oUserId);
			  oUserFilterInfo.setUserType(mPGM);

			  if (new Long (mCallableStatement.getLong(3)) != null) {
		          oUserFilterInfo.setPeopleId(new Long(mCallableStatement.getLong(3)) );
		      }

    		  if (mCallableStatement.getString(4) != null) {
			      oUserFilterInfo.setDivisionAbbrev(mCallableStatement.getString(4) );
   		      }

			  if (mCallableStatement.getString(5) != null) {
			      oUserFilterInfo.setPortfolioFlag(true);
			  }

			  if ( (mCallableStatement.getString(5) != null) |
			       (mCallableStatement.getString(6) != null) ){
			        oUserFilterInfo.setCancerActivityFlag(true);
	          }

			  if (mCallableStatement.getString(7) != null) {
				  mTempList = new ArrayList();
  				  mTokens = new StringTokenizer(mCallableStatement.getString(7), ",");
				  while (mTokens.hasMoreTokens()) {
   				      mTempList.add(mTokens.nextToken());
			      }
                 oUserFilterInfo.setProgramDirectorIds((List) mTempList);
			  }

			  if (mCallableStatement.getString(8) != null) {
                  mTempList = new ArrayList();
				  mTokens = new StringTokenizer(mCallableStatement.getString(8), ",");
				  while (mTokens.hasMoreTokens()) {
					 mTempList.add(mTokens.nextToken().replaceAll("'", ""));
			     }
                 oUserFilterInfo.setRuCodes((List) mTempList);
			  }

			  if (mCallableStatement.getString(9) != null) {
                  mTempList = new ArrayList();
				  mTokens = new StringTokenizer(mCallableStatement.getString(9), ",");
				  while (mTokens.hasMoreTokens()) {
					 mTempList.add(mTokens.nextToken());
			     }
                 oUserFilterInfo.setCancerActivityCodes((List) mTempList);
			  }

	          if (mCallableStatement != null) {
	               mCallableStatement.close();
    	      }

       } catch (SQLException ex) {
		    oUserFilterInfo = null;
            throw new CommandDaoException( ex.toString() );
       } catch (Exception ex) {
            throw new CommandDaoException( ex.toString() );
       }
       return oUserFilterInfo;
    }
}