package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.ActionCommandDao;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.WbRetrieveBoardsCommand;
import gov.nih.nci.iscs.oracle.pgm.exceptions.CommandDaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.sf.hibernate.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate.SessionFactoryUtils;

public class WbRetrieveBoardsCommandDao extends ActionCommandDao implements WbRetrieveBoardsCommand
{
   /**
     * Abstract class that encapsulates the core methods common to all application
     *  commads for retrieveing Lookup tables from the database. Builds the core search criteria
     *
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.query.ActionCommandDao
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.dataaccess.RetrieveLookUpCommand
     * @author Michelle Engermann
     * @version 1.0
     */

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    private List boards;
    private static String CURRENT_COUNCIL_QUERY = "select min(bds.meeting_year||bds.meeting_month) current_board "+
                                                  "from   boards_t bds "+
                                                  "where bds.meeting_month != '00' "+
                                                  "and bds.meeting_year||bds.meeting_month > to_char(sysdate,'YYYYMM') ";

    private static String NEXT_COUNCIL_QUERY = "select min(bds.meeting_year||bds.meeting_month) next_board "+
                                               "from boards_t bds "+
                                               "where bds.meeting_year||bds.meeting_month > ? "+
                                               "and bds.meeting_month != '00'";

    private static String NEXT_NEXT_COUNCIL_QUERY = "select min(bds.meeting_year||bds.meeting_month) nextnext_board "+
                                               "from boards_t bds "+
                                               "where bds.meeting_year||bds.meeting_month > ? "+
                                               "and bds.meeting_month != '00'";


   /*
    * Class constructor
    */
    public WbRetrieveBoardsCommandDao() {}

    /*
     * The main method that handles the execution of the command.
     * - Get the session from the Session Factory
     * - Build the Query Criteria for the Criteria object
     * - execute the query and return the Query Page
     * @retrun aQueryPage - a QueryPage object that encapsulate the Pagination
     */
    /*
     * The main method that handles the execution of the command.
     * - Get the session from the Session Factory
     * - Build the Query Criteria for the Criteria object
     * - execute the query and return the Query Page
     * @retrun aQueryPage - a QueryPage object that encapsulate the Pagination
     */
    public String execute(String oUserId) {
       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       Connection mConnection = getConnection(mSession, oUserId);
       PreparedStatement mPreparedStatement = null;
       String mResults = "failed";
       boards = new ArrayList(3);
       String currentBoard = null;
       String nextBoard = null;
       String nextNextBoard = null;
       ResultSet mResultSet = null;
       try {
		    mPreparedStatement = mConnection.prepareStatement(CURRENT_COUNCIL_QUERY);
        mResultSet = mPreparedStatement.executeQuery();
         while (mResultSet.next()) {
            currentBoard = mResultSet.getString("current_board");
         }
        mResultSet.close();
        mPreparedStatement.close();
        mPreparedStatement = mConnection.prepareStatement(NEXT_COUNCIL_QUERY);
        mPreparedStatement.setString(1,currentBoard);
        mResultSet = mPreparedStatement.executeQuery();
        while (mResultSet.next())
        {
            nextBoard = mResultSet.getString("next_board");
        }
        mResultSet.close();
        mPreparedStatement.close();
        mPreparedStatement = mConnection.prepareStatement(NEXT_NEXT_COUNCIL_QUERY);
        mPreparedStatement.setString(1, nextBoard);
        mResultSet = mPreparedStatement.executeQuery();
        while (mResultSet.next())
        {
           nextNextBoard = mResultSet.getString("nextnext_board");
        }
        boards.add(0, currentBoard);
        boards.add(1, nextBoard);
        boards.add(2, nextNextBoard);
        mResults = "passed";
	   } catch (SQLException ex) {
	       throw new CommandDaoException("execution failed for LookUp" +  ex.toString() );
	   } finally {
		   try {
			   mPreparedStatement.close();
			   mResultSet.close();
		   } catch (SQLException ex) {
			   SessionFactoryUtils.closeSessionIfNecessary(mSession, getSessionFactory());
		   }
			   SessionFactoryUtils.closeSessionIfNecessary(mSession, getSessionFactory());
       }

       return mResults;
    }



  public List getBoards()
  {
    return boards;
  }

}