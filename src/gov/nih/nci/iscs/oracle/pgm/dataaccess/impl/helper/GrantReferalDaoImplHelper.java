package gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper;

import java.util.List;
import java.util.*;

import java.sql.*;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;
import gov.nih.nci.iscs.oracle.pgm.hibernate.*;

import net.sf.hibernate.type.Type;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.orm.hibernate.HibernateTemplate;
import org.springframework.orm.hibernate.SessionFactoryUtils;
import org.springframework.orm.hibernate.support.HibernateDaoSupport;
import org.springframework.orm.hibernate.HibernateInterceptor;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.GrantReferalDao;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

public class GrantReferalDaoImplHelper  {
    /**
     * GrantReferalDaoImplHelper contains helper routines that are common to the
     *   Grant Referal processes
     *
     * @author Michelle Engermann
     * @version 1.0
     */

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    private Connection connection = null;
    private String oReferalMessage = null;
    public static final String FAILURE_LITERAL = "FAILURE";

    public GrantReferalDaoImplHelper(Connection aConnection) {
    /*
     * Assignes the Hibernate Connection instance that will be used
     */
       connection         = aConnection;
	}

    public boolean acceptReferral(Long aApplId, Long aNpeId) throws CommandDaoException, SQLException  {
    /*
     * Call the accepr_referral stored procedure
     *
     * @return boolean - verification pass/faik
     * @param aApplId - the Appl id
     * @param aNpeId  - the Npe id
     */
       boolean mReturnVal = true;
       CallableStatement mCallableStatement = null;
       PreparedStatement mPreparedStatement = null;
       String mQueryString = "{call PD_PORTFOLIO_MGT_PKG.ACCEPT_REFERRAL(?,?,?,?)}";
       try {

		      mCallableStatement = connection.prepareCall(mQueryString);
              mCallableStatement.setLong(1, aApplId.longValue());
              mCallableStatement.setLong(2, aNpeId.longValue());
              mCallableStatement.registerOutParameter(3, Types.VARCHAR);
              mCallableStatement.registerOutParameter(4, Types.VARCHAR);
              mCallableStatement.execute();
              oReferalMessage = mCallableStatement.getString(3);
              if (mCallableStatement.getString(3).toUpperCase().equals(FAILURE_LITERAL)) {
                  oReferalMessage = oReferalMessage + " " + mCallableStatement.getString(4);
                  mReturnVal = false;
              }
              //Added August 25, 2006 to close impac ii db link due to sniped sessions
              mPreparedStatement = connection.prepareStatement("alter session close database link impprd");
              mPreparedStatement.execute();

       } catch (SQLException ex) {
		       oReferalMessage = "AN UNEXPECTED EXCEPTION HAS OCCURRED! Processsing of this request has been terminated. Refer to the application Logs for further information";
               throw new CommandDaoException( ex.toString() );
       } finally {
	           if (mCallableStatement != null) {
	               mCallableStatement.close();
	           }
	           if (mPreparedStatement != null) {
	               mPreparedStatement.close();
	           } 
	           if (connection != null) {
	               connection.commit();
	           }
	   			
	    }
        return mReturnVal;
    }

    public boolean rejectReferral(Long aApplId, String aComments) throws SQLException   {
    /*
     * Call the reject_referral stored procedure
     *
     * @return boolean - verification pass/faik
     * @param aApplId - the Appl id
     * @param aComments  - the Comments
     */
       boolean mReturnVal = true;
       CallableStatement mCallableStatement = null;
       String mQueryString = "{call PD_PORTFOLIO_MGT_PKG.REJECT_REFERRAL(?,?,?,?)}";
        try {
		      mCallableStatement = connection.prepareCall(mQueryString);
              mCallableStatement.setLong(1, aApplId.longValue());
              mCallableStatement.setString(2, aComments);
              mCallableStatement.registerOutParameter(3, Types.VARCHAR);
              mCallableStatement.registerOutParameter(4, Types.VARCHAR);
              mCallableStatement.execute();
              oReferalMessage = mCallableStatement.getString(3);
              if (mCallableStatement.getString(3).toUpperCase().equals(FAILURE_LITERAL)) {
                  oReferalMessage = oReferalMessage + " " + mCallableStatement.getString(4);
                  mReturnVal = false;
              }
       } catch (SQLException ex) {
		    oReferalMessage = "AN UNEXPECTED EXCEPTION HAS OCCURRED! Processsing of this request has been terminated. Refer to the application Logs for further information";
            throw new CommandDaoException( ex.toString() );
       } finally {
	           if (mCallableStatement != null) {
	               mCallableStatement.close();
	           }

	           if (connection != null) {
	               connection.commit();
	           }
	   			
	    }
        return mReturnVal;
    }

    public boolean reReferReferral(Long aApplId, String aCancerActivityCode, String aComments) throws SQLException   {
    /*
     * Call the reRefer_referral stored procedure
     *
     * @return boolean - verification pass/faik
     * @param aApplId - the Appl id
     * @param aCancerActivityCode  - the new Cancer Activity Code
     * @param aComments  - the comments
     */
       boolean mReturnVal = true;
       CallableStatement mCallableStatement = null;
       String mQueryString = "{call PD_PORTFOLIO_MGT_PKG.REREFER_REFERRAL(?,?,?,?,?)}";
        try {
		      mCallableStatement = connection.prepareCall(mQueryString);
              mCallableStatement.setLong(1, aApplId.longValue());
              mCallableStatement.setString(2, aCancerActivityCode);
              mCallableStatement.setString(3, aComments);
              mCallableStatement.registerOutParameter(4, Types.VARCHAR);
              mCallableStatement.registerOutParameter(5, Types.VARCHAR);
              mCallableStatement.execute();

              oReferalMessage = mCallableStatement.getString(4);

              if (mCallableStatement.getString(4).toUpperCase().equals(FAILURE_LITERAL)) {
                  oReferalMessage = oReferalMessage + " " + mCallableStatement.getString(5);
                  mReturnVal = false;
              }
       } catch (SQLException ex) {
		    oReferalMessage = "AN UNEXPECTED EXCEPTION HAS OCCURRED! Processsing of this request has been terminated. Refer to the application Logs for further information";
            throw new CommandDaoException( ex.toString() );
       } finally {
	           if (mCallableStatement != null) {
	               mCallableStatement.close();
	           }

	           if (connection != null) {
	               connection.commit();
	           }
	   			
	    }
        return mReturnVal;
    }


    public boolean releaseReferral(Long aApplId, String aCancerActivityCode) throws SQLException   {
    /*
     * Call the reRefer_referral stored procedure
     *
     * @return boolean - verification pass/faik
     * @param aApplId - the Appl id
     * @param aCancerActivityCode  - the released Cancer Activity Code
     */
       boolean mReturnVal = true;
       CallableStatement mCallableStatement = null;
       String mQueryString = "{call PD_PORTFOLIO_MGT_PKG.RELEASE_REFERRAL(?,?,?,?)}";
        try {
		      mCallableStatement = connection.prepareCall(mQueryString);
              mCallableStatement.setLong(1, aApplId.longValue());
              mCallableStatement.setString(2, aCancerActivityCode);
              mCallableStatement.registerOutParameter(3, Types.VARCHAR);
              mCallableStatement.registerOutParameter(4, Types.VARCHAR);
              mCallableStatement.execute();
              oReferalMessage = mCallableStatement.getString(3);

              if (mCallableStatement.getString(3).toUpperCase().equals(FAILURE_LITERAL)) {
                  oReferalMessage = oReferalMessage + " " + mCallableStatement.getString(4);
                  mReturnVal = false;
              }
       } catch (SQLException ex) {
		    oReferalMessage = "AN UNEXPECTED EXCEPTION HAS OCCURRED! Processsing of this request has been terminated. Refer to the application Logs for further information";
            throw new CommandDaoException( ex.toString() );
       } finally {
	           if (mCallableStatement != null) {
	               mCallableStatement.close();
	           }

	           if (connection != null) {
	               connection.commit();
	           }
	   			
	    }
        return mReturnVal;
    }
 public String getReferalMessage() {
    /*
     *
     * @return String - oReferalMessage
     */
       return oReferalMessage;
     }
}