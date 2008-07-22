package gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper;


import java.sql.*;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


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
     * @return boolean - verification pass/fail
     * @param aApplId - the Appl id
     * @param aNpeId  - the Npe id
     */
        boolean mReturnVal = true;
        CallableStatement mCallableStatement = null;
        CallableStatement closeDBLinkCallableStatement = null;                          
        String mQueryString = 
            "{call PD_PORTFOLIO_MGT_PKG.ASSIGN_CA_PD(?,?,?,?,?,?,?)}";
        String closeDBLinkString = "{call nci_util.p_close_db_link(?)}";      
        
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
            closeDBLinkCallableStatement = connection.prepareCall(closeDBLinkString);
            closeDBLinkCallableStatement.setString(1, "impprd");
            closeDBLinkCallableStatement.execute();
        } catch (SQLException ex) {
            oAssignmentMessage = 
                    "AN UNEXPECTED EXCEPTION HAS OCCURRED! Processsing of this request has been terminated. Refer to the application Logs for further information";
            throw new CommandDaoException(ex.toString());
        } finally {
            if (mCallableStatement != null) {
                mCallableStatement.close();
            }
            if (closeDBLinkCallableStatement != null) {
                closeDBLinkCallableStatement.close();
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
