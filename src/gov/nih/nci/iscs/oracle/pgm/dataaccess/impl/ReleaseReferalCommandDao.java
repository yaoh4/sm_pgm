package gov.nih.nci.iscs.oracle.pgm.dataaccess.impl;


import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.orm.hibernate.SessionFactoryUtils;

import net.sf.hibernate.Session;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.ReleaseReferalCommand;
import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper.*;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

import java.sql.Connection;
import java.sql.SQLException;


 /**
  * ReleaseReferalCommandDao encapsulates the implementation of reject referra;
  *   activity
  *
  * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.ReleaseReferalCommand
  * @author Michelle Engermann
  * @version 1.0
  */
public class ReleaseReferalCommandDao extends ActionCommandDao implements  ReleaseReferalCommand {

    private String oReferalMessage = null;
    private List interceptorNames;
    private NciUser nciUser;

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    /*
     * Class constructor
     */
    public ReleaseReferalCommandDao() {}




    /*
     * Executes the Release referral.
     * @return String  - pass/fail
     */
    public Object execute(Long oApplId, String oCancerActicityCode, String oUserId,String readOnly) {

    	if(("true").equalsIgnoreCase(readOnly)) {
    		throw new ServiceDeniedException();
    	}
       boolean mReferalPassed = false;
       String params = null;

       // get the Session object
       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       Connection mConnection = getConnection(mSession, oUserId);
       GrantReferalDaoImplHelper mGrantReferalDaoImplHelper = new GrantReferalDaoImplHelper(mConnection);
       try {
    	     params = "Parameters: p_appl_id - " + oApplId + 
             		", p_released_cay_code - " + oCancerActicityCode;
      	     logCaller(oUserId, logger,"PD_PORTFOLIO_MGT_PKG.RELEASE_REFERRAL: " + params);
  			 mReferalPassed = mGrantReferalDaoImplHelper.releaseReferral(oApplId, oCancerActicityCode);
	   } catch (CommandDaoException ex) {
		   logError(oUserId, logger,"error occured during PD_PORTFOLIO_MGT_PKG.RELEASE_REFERRAL : ", ex);
           logger.error(params);
		   throw new CommandDaoException("Release Referral Failed!!!" + ex.toString() );
       } catch (SQLException ex ) {
    	   logError(oUserId, logger,"error occured during PD_PORTFOLIO_MGT_PKG.RELEASE_REFERRAL : ", ex);
           logger.error(params);
		   throw new CommandDaoException("Release Referral Failed!!!" + ex.toString() );
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