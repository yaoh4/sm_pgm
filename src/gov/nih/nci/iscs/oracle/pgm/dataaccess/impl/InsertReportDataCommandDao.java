package gov.nih.nci.iscs.oracle.pgm.dataaccess.impl;


import java.util.*;
import java.text.SimpleDateFormat;
import net.sf.hibernate.type.Type;

import net.sf.hibernate.HibernateException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.orm.hibernate.SessionFactoryUtils;
import org.springframework.orm.hibernate.support.HibernateDaoSupport;
import org.springframework.orm.hibernate.HibernateInterceptor;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.InsertReportDataCommand;
import gov.nih.nci.iscs.oracle.pgm.context.ApplicationContextFactory;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper.*;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;


public class InsertReportDataCommandDao extends ActionCommandDao implements  InsertReportDataCommand {
    /**
     * AcceptReferalCommandDao encapsulates the implementation of accept referra;
     *   activity
     *
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.InsertReportDataCommand
     * @author Michelle Engermann
     * @version 1.0
     */

    private String oReferalMessage = null;
    private List interceptorNames;
    private static String DELETE_ACTION = "delete";

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    /*
     * Class constructor
     */
    public InsertReportDataCommandDao() {}

    /*
     * Executes the accept referral.
     * @return String  - pass/fail
     */
     public Object execute(String mSessionId, Long mReportId, Long mApplId, String mAction, String oUserId) {

       boolean mUpdatePassed = false;

       // get the Session object
       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       Connection mConnection = getConnection(mSession, oUserId);

       try {
		     if(mAction.equalsIgnoreCase(DELETE_ACTION)) {
  			     mUpdatePassed = deleteData(mSessionId, mReportId, mConnection);
			 }else {
				 mUpdatePassed = insertData(mSessionId, mReportId, mApplId, mConnection);
			 }
	   } catch (CommandDaoException ex) {
		   throw new CommandDaoException("Accept Referral Failed!!!" + ex.toString() );
       } catch (SQLException ex ) {
		   throw new CommandDaoException("Accept Referral Failed!!!" + ex.toString() );
       } finally {
		   SessionFactoryUtils.closeSessionIfNecessary(mSession, getSessionFactory());
       }

	   return "passed";
    }


    private List getInterceptorNames() {
	    return interceptorNames;
    }

    private void setInterceptorNames(List aInterceptorNames) {
	    interceptorNames = aInterceptorNames;
    }

    public boolean insertData(String mSessionId, Long mReportId, Long mApplId, Connection mConnection ) throws CommandDaoException, SQLException  {
    /*
     * Call the stored procedure to insert temp data for report
     *
     * @return boolean - verification pass/faik
     * @param mSessionId - the mSessionId
     * @param mReportId  - the mReport id
     */
       boolean mReturnVal = true;
       CallableStatement mCallableStatement = null;
	   String mColumnName = "APPL_ID";
	   String mSourceTableName = "NCI_PD_QUERY_VW";
	   String mWhereClause = "APPL_ID = "+mApplId;
       String mQueryString = "{call REPORTS_UTL_PKG.STORE_TEMP_IDS(?,?,?,?,?)}";
       try {

		      mCallableStatement = mConnection.prepareCall(mQueryString);
              mCallableStatement.setString(1, mSessionId);
              mCallableStatement.setString(2, mColumnName);
              mCallableStatement.setString(3, mSourceTableName);
              mCallableStatement.setLong(4, mReportId.longValue());
              mCallableStatement.setString(5, mWhereClause);
              mCallableStatement.execute();

       } catch (SQLException ex) {
		       oReferalMessage = "AN UNEXPECTED EXCEPTION HAS OCCURRED! Processsing of this request has been terminated. Refer to the application Logs for further information";
               throw new CommandDaoException( ex.toString() );
       } finally {
	           if (mCallableStatement != null) {
	               mCallableStatement.close();
	           }

	           if (mConnection != null) {
	               mConnection.commit();
	           }
	   			return mReturnVal;
	    }

    }

    public boolean deleteData(String mSessionId, Long mReportId,  Connection mConnection ) throws CommandDaoException, SQLException  {
    /*
     * Call the stored procedure to insert temp data for report
     *
     * @return boolean - verification pass/faik
     * @param mSessionId - the mSessionId
     * @param mReportId  - the mReport id
     */
       boolean mReturnVal = true;
       PreparedStatement  mPreparedStatement = null;
       String mQueryString = "delete from REPORT_TEMP_GRANTS_T where SESSION_ID = ? and REPORT_ID = ?";
       try {

		      mPreparedStatement = mConnection.prepareStatement(mQueryString);
              mPreparedStatement.setString(1, mSessionId);
              mPreparedStatement.setLong(1, mReportId.longValue());

              mPreparedStatement.execute();

       } catch (SQLException ex) {
		       oReferalMessage = "AN UNEXPECTED EXCEPTION HAS OCCURRED! Processsing of this request has been terminated. Refer to the application Logs for further information";
               throw new CommandDaoException( ex.toString() );
       } finally {
	           if (mPreparedStatement != null) {
	               mPreparedStatement.close();
	           }

	           if (mConnection != null) {
	               mConnection.commit();
	           }
	   			return mReturnVal;
	    }

    }

}