package gov.nih.nci.iscs.oracle.pgm.dataaccess.impl;


import java.sql.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.ActionCommand;
import net.sf.hibernate.Session;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.SessionFactory;

import java.sql.Connection;


/**
  * Base abstract class inherited by all CommandDao that perform action
  * calls to the database
  *
  * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.ActionCommand
  * @author Michelle Engermann
  * @version 1.0
  */
public abstract class ActionCommandDao implements  ActionCommand {

    private SessionFactory sessionFactory;
    private String oUserId;
   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    /*
     * Class constructor
     */
    public ActionCommandDao() {}

    /**
     * mutator / accessor methods for sessionFactory attribute
     */
    public SessionFactory getSessionFactory () {
		return this.sessionFactory;
    }
    public void setSessionFactory (SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
    }

    /*
     * Obtains a Hibernate connection object from the Session
     * @param Session  - hibernate Session
     * @return Connection  - hibernate Connection
     */
    public Connection getConnection(Session aSession, String oUserId) {
		if (aSession == null )
		    return null;
		try {
		    Connection aConnection =  aSession.connection();
		    setAuditInfo(aConnection, oUserId);
		    return aConnection;
	    } catch (HibernateException ex ) {
		   logger.error("Unable to obtain Hibernate Connection" + ex.toString() );
		   return null;
	    }
	}

    private void setAuditInfo(Connection conn, String oUserId) throws HibernateException
    {
        try
        {
            String callStr = "call dbms_application_info.set_client_info(?)";
            CallableStatement mCallableStatement = conn.prepareCall(callStr);
            if(oUserId != null)
                mCallableStatement.setString(1, oUserId);
            else
                mCallableStatement.setNull(1, 12);
            mCallableStatement.execute();
        }
        catch(Exception e)
        {
            logger.error(e);
            throw new HibernateException(" Error setting audit columns. " + e.getMessage());
        }
    }

	/**
 	 * Log Caller information before DB operation
 	 * 
 	 * @param user
 	 * @param logger
 	 * @param message
 	 */
 	protected static void logCaller(String user, Log logger, String message){ 
 		logger.info("User " + user + ": " + message);
 	}
 	
 	/**
 	 * Log Error information after DB operation
 	 * 
 	 * @param user
 	 * @param logger
 	 * @param message
 	 */
 	protected static void logError(String user, Log logger, String message, Exception ex){ 
 		logger.error("User " + user + ": " + message, ex);
 	}
 	
    

}