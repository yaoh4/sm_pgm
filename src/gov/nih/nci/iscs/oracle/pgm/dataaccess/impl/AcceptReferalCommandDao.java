package gov.nih.nci.iscs.oracle.pgm.dataaccess.impl;


import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.orm.hibernate.SessionFactoryUtils;

import net.sf.hibernate.Session;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.AcceptReferalCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper.*;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

import java.sql.Connection;
import java.sql.SQLException;


public class AcceptReferalCommandDao extends ActionCommandDao implements  AcceptReferalCommand {
    /**
     * AcceptReferalCommandDao encapsulates the implementation of accept referra;
     *   activity
     *
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.AcceptReferalCommand
     * @author Michelle Engermann
     * @version 1.0
     */

    private String oReferalMessage = null;
    private List interceptorNames;

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    /*
     * Class constructor
     */
    public AcceptReferalCommandDao() {}

    /*
     * Executes the accept referral.
     * @return String  - pass/fail
     */
     public Object execute(Long oApplId, Long oNpeId, String oUserId) {

       boolean mReferalPassed = false;

       // get the Session object
       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       Connection mConnection = getConnection(mSession, oUserId);
       GrantReferalDaoImplHelper mGrantReferalDaoImplHelper = new GrantReferalDaoImplHelper(mConnection);

       try {
    	     logCaller(oUserId, logger,"Calling PD_PORTFOLIO_MGT_PKG.ACCEPT_REFERRAL, appl id: " + oApplId + " npe id: " + oNpeId);
  			 mReferalPassed = mGrantReferalDaoImplHelper.acceptReferral(oApplId, oNpeId);
	   } catch (CommandDaoException ex) {
		   logError(oUserId, logger,"error occured during PD_PORTFOLIO_MGT_PKG.ACCEPT_REFERRAL : ", ex);
           logger.error("Parameters: p_appl_id - " + oApplId +
           		", p_new_npe_id - " + oNpeId);
		   throw new CommandDaoException("Accept Referral Failed!!!" + ex.toString() );
       } catch (SQLException ex ) {
    	   logError(oUserId, logger,"error occured during PD_PORTFOLIO_MGT_PKG.ACCEPT_REFERRAL : ", ex);
           logger.error("Parameters: p_appl_id - " + oApplId +
           		", p_new_npe_id - " + oNpeId);
		   throw new CommandDaoException("Accept Referral Failed!!!" + ex.toString() );
       } finally {
		   SessionFactoryUtils.closeSessionIfNecessary(mSession, getSessionFactory());
       }

	   return mGrantReferalDaoImplHelper.getReferalMessage();
    }


    private List getInterceptorNames() {
	    return interceptorNames;
    }

    private void setInterceptorNames(List aInterceptorNames) {
	    interceptorNames = aInterceptorNames;
    }



}