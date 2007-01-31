package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;

// jdk imports
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveLookUpCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.ActionCommandDao;
import gov.nih.nci.iscs.oracle.pgm.exceptions.CommandDaoException;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;


// Springfranework imports
import org.springframework.orm.hibernate.SessionFactoryUtils;
import org.apache.struts.util.LabelValueBean;

// hibernate imports
import net.sf.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RetrieveLookUpCommandDao extends ActionCommandDao implements  RetrieveLookUpCommand {
   /**
     * Abstract class that encapsulates the core methods common to all application
     *  commads for retrieveing Lookup tables from the database. Builds the core search criteria
     *
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.query.AccessCommandDao
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.dataaccess.RetrieveLookUpCommand
     * @author Michelle Engermann
     * @version 1.0
     */

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());


   /*
    * Class constructor
    */
    public RetrieveLookUpCommandDao() {}



    /*
     * The main method that handles the execution of the command.
     * - Get the session from the Session Factory
     * - Build the Query Criteria for the Criteria object
     * - execute the query and return the Query Page
     * @retrun aQueryPage - a QueryPage object that encapsulate the Pagination
     */
    public List execute(String oLookUpTableName, String oLookUpSqlString, String oUserId) {

       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       Connection mConnection = getConnection(mSession, oUserId);
       PreparedStatement mPreparedStatement = null;
       ResultSet mResultSet = null;
       ArrayList oLookUpTableValues = new ArrayList();
       LabelValueBean mLabelValueBean = new LabelValueBean(ApplicationConstants.EMPTY_STRING, ApplicationConstants.EMPTY_STRING);
       oLookUpTableValues.add(mLabelValueBean);
       try {
		    mPreparedStatement = mConnection.prepareStatement(oLookUpSqlString);
            mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {

				Object mKey = mResultSet.getObject(1);
				Object mValue = mResultSet.getObject(2);
                mLabelValueBean = new LabelValueBean(mValue.toString(), mKey.toString());
                oLookUpTableValues.add(mLabelValueBean);
            }
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

       return  oLookUpTableValues;
    }



}