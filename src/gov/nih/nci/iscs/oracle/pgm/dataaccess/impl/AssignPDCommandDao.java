package gov.nih.nci.iscs.oracle.pgm.dataaccess.impl;


import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.orm.hibernate.SessionFactoryUtils;

import net.sf.hibernate.Session;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.AssignPDCommand;
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
                           java.sql.Timestamp oAssignmentDate, String oPdTransferCode, String oUserId) {

       boolean mAssignmentPassed = false;

       // get the Session object
       Session mSession = SessionFactoryUtils.getSession(getSessionFactory(), true);
       Connection mConnection = getConnection(mSession, oUserId);
       PdAssignmentDaoImplHelper mPdAssignmentDaoImplHelper = new PdAssignmentDaoImplHelper(mConnection);

       try {
  			 mAssignmentPassed = mPdAssignmentDaoImplHelper.assignPD(oApplId, oNpeId, oCancerActivity, oPdTransferCode, oAssignmentDate);
	   } catch (CommandDaoException ex) {
		   throw new CommandDaoException("PD Assignment Failed!!!" + ex.toString() );
       } catch (SQLException ex ) {
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