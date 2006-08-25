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

public class PdAssignmentDaoImplHelper {
    /**
     * PdAssignmentDaoImplHelper contains helper routines that are common to the
     *   PD Assignment processes
     *
     * @author Michelle Engermann
     * @version 1.0
     */

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    private Connection connection = null;
    private String oAssignmentMessage = null;
    public static final String FAILURE_LITERAL = "FAILURE";

    public PdAssignmentDaoImplHelper(Connection aConnection) {
        /*
     * Assignes the Hibernate Connection instance that will be used
     */
        connection = aConnection;
    }

    public boolean assignPD(Long aApplId, Long aNpeId, String aCancerActivity, 
                            String aPdTransferCode, 
                            java.sql.Timestamp aAssignmentDate) throws CommandDaoException, 
                                                                       SQLException {
        /*
     * Call the assignment stored procedure
     *
     * @return boolean - verification pass/faik
     * @param aApplId - the Appl id
     * @param aNpeId  - the Npe id
     */
        boolean mReturnVal = true;
        CallableStatement mCallableStatement = null;
        PreparedStatement mPreparedStatement = null;
        String mQueryString = 
            "{call PD_PORTFOLIO_MGT_PKG.ASSIGN_CA_PD(?,?,?,?,?,?,?)}";

        java.sql.Timestamp mDate = (java.sql.Timestamp)aAssignmentDate;
        try {
            mCallableStatement = connection.prepareCall(mQueryString);
            mCallableStatement.setLong(1, aApplId.longValue());
            mCallableStatement.setLong(2, aNpeId.longValue());
            mCallableStatement.setString(3, aCancerActivity);
            mCallableStatement.setTimestamp(4, aAssignmentDate);
            mCallableStatement.setString(5, aPdTransferCode);
            mCallableStatement.registerOutParameter(6, Types.VARCHAR);
            mCallableStatement.registerOutParameter(7, Types.VARCHAR);
            mCallableStatement.execute();
            oAssignmentMessage = mCallableStatement.getString(6);
            if (mCallableStatement.getString(6).toUpperCase().equals(FAILURE_LITERAL)) {
                oAssignmentMessage = 
                        oAssignmentMessage + " " + mCallableStatement.getString(7);
                mReturnVal = false;
            }
            //Added August 25, 2006 to close impac ii db link due to sniped sessions
            mPreparedStatement = 
                    connection.prepareStatement("alter session close database link impprd");
            mPreparedStatement.execute();
        } catch (SQLException ex) {
            oAssignmentMessage = 
                    "AN UNEXPECTED EXCEPTION HAS OCCURRED! Processsing of this request has been terminated. Refer to the application Logs for further information";
            throw new CommandDaoException(ex.toString());
        } finally {
            if (mCallableStatement != null) {
                mCallableStatement.close();
            }
            if (mPreparedStatement != null) {
                mPreparedStatement.close();
            }
            if (connection != null) {
                //connection.commit();
            }
           
        }
                 return mReturnVal;
    }


    public String getAssignmentMessage() {
        /*
     *
     * @return String - oAssignmentMessage
     */
        return oAssignmentMessage;
    }
}
