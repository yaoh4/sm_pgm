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

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.ReReferReferalCommand;
import gov.nih.nci.iscs.oracle.pgm.context.ApplicationContextFactory;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper.*;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

import java.sql.Connection;
import java.sql.SQLException;


 /**
  * ReReferReferalCommandDao encapsulates the implementation of reject referra;
  *   activity
  *
  * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.ReReferReferalCommand
  * @author Michelle Engermann
  * @version 1.0
  */
public class ReReferReferalCommandDao extends ActionCommandDao implements  ReReferReferalCommand {

    private String oReferalMessage = null;
    private List interceptorNames;

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    /*
     * Class constructor
     */
    public ReReferReferalCommandDao() {}
    /*
     * Executes the Re-refer activity.
     * @return String  - pass/fail
     */
    public Object execute(Long oApplId, String oCancerActicityCode, String oComments, String oUserId) {

       boolean mReferalPassed = false;

       // get the Session object
       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       Connection mConnection = getConnection(mSession, oUserId);
       GrantReferalDaoImplHelper mGrantReferalDaoImplHelper = new GrantReferalDaoImplHelper(mConnection);

       try {
  			 mReferalPassed = mGrantReferalDaoImplHelper.reReferReferral(oApplId, oCancerActicityCode, oComments);

	   } catch (CommandDaoException ex) {
		   throw new CommandDaoException("Re-refer Referral Failed!!!" + ex.toString() );
       } catch (SQLException ex ) {
		   throw new CommandDaoException("Re-refer Referral Failed!!!" + ex.toString() );
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