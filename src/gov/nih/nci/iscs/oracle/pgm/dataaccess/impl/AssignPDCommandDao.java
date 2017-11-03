package gov.nih.nci.iscs.oracle.pgm.dataaccess.impl;


import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.orm.hibernate.SessionFactoryUtils;

import net.sf.hibernate.Session;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.AssignPDCommand;
import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper.*;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

import java.sql.Connection;
import java.sql.SQLException;


public class AssignPDCommandDao extends ActionCommandDao implements  AssignPDCommand {
    /**
     * AcceptReferalCommandDao encapsulates the implementation of accept referra;
     *   activity
     *
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.AcceptReferalCommand
     * @author Michelle Engermann
     * @version 1.0
     */

    private List interceptorNames;
    private NciUser nci;
   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    /*
     * Class constructor
     */
    public AssignPDCommandDao() {}


    /*
     * Executes the accept referral.
     * @return String  - pass/fail
     */
     public Object execute(Long oApplId, Long oNpeId, String oCancerActivity,
                           java.sql.Timestamp oAssignmentDate, String oPdTransferCode, String oUserId,String readOnly) {
    	 
    	if(("true").equalsIgnoreCase(readOnly)) {
    		throw new ServiceDeniedException();
    	}

       boolean mAssignmentPassed = false;
       String params = null;

       // get the Session object
       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       Connection mConnection = getConnection(mSession, oUserId);
       PdAssignmentDaoImplHelper mPdAssignmentDaoImplHelper = new PdAssignmentDaoImplHelper(mConnection);

       try {
    	     params = "Parameters: p_appl_id - " + oApplId + 
           		", p_new_npe_id - " + oNpeId + 
           		", p_new_cay_code - " + oCancerActivity +
           		", p_pd_transfer_initial_code - " + oPdTransferCode + 
           		", p_new_date" + oAssignmentDate;
    	     logCaller(oUserId, logger,"Calling PD_PORTFOLIO_MGT_PKG.ASSIGN_CA_PD: " + params);
  			 mAssignmentPassed = mPdAssignmentDaoImplHelper.assignPD(oApplId, oNpeId, oCancerActivity, oPdTransferCode, oAssignmentDate);
	   } catch (CommandDaoException ex) {
		   logError(oUserId, logger,"error occured during PD_PORTFOLIO_MGT_PKG.ASSIGN_CA_PD : ", ex);
           logger.error(params);
		   throw new CommandDaoException("PD Assignment Failed!!!" + ex.toString() );
       } catch (SQLException ex ) {
    	   logError(oUserId, logger,"error occured during PD_PORTFOLIO_MGT_PKG.ASSIGN_CA_PD : ", ex);
           logger.error(params);
		   throw new CommandDaoException("PD Assignment Failed!!!" + ex.toString() );
       } finally {
		   SessionFactoryUtils.closeSessionIfNecessary(mSession, getSessionFactory());
       }

	   return mPdAssignmentDaoImplHelper.getAssignmentMessage();
    }


    private List getInterceptorNames() {
	    return interceptorNames;
    }

    private void setInterceptorNames(List aInterceptorNames) {
	    interceptorNames = aInterceptorNames;
    }



}