package gov.nih.nci.iscs.oracle.pgm.dataaccess.impl;


import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.orm.hibernate.SessionFactoryUtils;

import net.sf.hibernate.Session;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RejectReferalCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper.*;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

import java.sql.Connection;
import java.sql.SQLException;


 /**
  * RejectReferalCommandDao encapsulates the implementation of reject referra;
  *   activity
  *
  * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RejectReferalCommand
  * @author Michelle Engermann
  * @version 1.0
  */
public class RejectReferalCommandDao extends ActionCommandDao implements  RejectReferalCommand {

    private String oReferalMessage = null;
    private List interceptorNames;

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());


    /*
     * Class constructor
     */
    public RejectReferalCommandDao() {}

    /*
     * Executes the reject referral.
     * @return String  - pass/fail
     */
    public Object execute(Long oApplId, String oComments, String oUserId) {

       boolean mReferalPassed = false;
       String params = null;

       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       Connection mConnection = getConnection(mSession, oUserId);
       GrantReferalDaoImplHelper mGrantReferalDaoImplHelper = new GrantReferalDaoImplHelper(mConnection);

       try {
    	    params = "Parameters: p_appl_id - " + oApplId + 
              		", p_comments - " + oComments;
       	    logCaller(oUserId, logger,"Calling PD_PORTFOLIO_MGT_PKG.REJECT_REFERRAL: " + params);
  			mReferalPassed =  mGrantReferalDaoImplHelper.rejectReferral(oApplId, oComments);

	   } catch (CommandDaoException ex) {
		   logError(oUserId, logger,"error occured during PD_PORTFOLIO_MGT_PKG.REJECT_REFERRAL : ", ex);
           logger.error(params);
		   throw new CommandDaoException("Reject Referral Failed!!!" + ex.toString() );
       } catch (SQLException ex ) {
    	   logError(oUserId, logger,"error occured during PD_PORTFOLIO_MGT_PKG.REJECT_REFERRAL : ", ex);
           logger.error(params);
		   throw new CommandDaoException("Reject Referral Failed!!!" + ex.toString() );
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