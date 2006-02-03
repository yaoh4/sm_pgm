package gov.nih.nci.iscs.oracle.pgm.factory;

import gov.nih.nci.iscs.oracle.pgm.exceptions.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.GrantReferalDao;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.orm.hibernate.SessionHolder;

import gov.nih.nci.iscs.oracle.pgm.context.ApplicationContextFactory;

public  class HibernateDAOFactory extends DAOFactory {

	private SessionFactory oSessionFactory = null;


    static Logger logger = LogManager.getLogger(HibernateDAOFactory.class);
    /**
     * HibernateDAOFactory encapsulates the implementation of the persistence mechanism
     *
     * @author Michelle Engermann
     * @version 1.0
     */


    /*
     * Constructor for the HibernateDAOfactory Class
     * Creates a singleton instance of the ApplicationContextFactory Class
     */
     public void HibernateDAOFactory() {}

     public void initContext() {

        // get the application path from the properties or XML file
        try{
    	    oSessionFactory = (SessionFactory) ApplicationContextFactory.getApplicationContext().getBean("sessionFactory");
	    } catch (Exception ex) {
            logger.error(ex);
            throw new InfrastructureException(ex.toString());
	    }
     }


    /*
     * This method return the actual concrete implementation DAO Class for Hibernate
     * @retrun GrantReferalDao - Concrete Implenetation of DAO
     */
     public GrantReferalDao getGrantReferalDao(){
		 try {
		    GrantReferalDao mSpringBeanDao = (GrantReferalDao) ApplicationContextFactory.getApplicationContext().getBean("grantReferalDaoImpl");
	         return mSpringBeanDao;
	     } catch (Exception ex) {
            logger.error(ex);
            throw new InfrastructureException(ex.toString());

	     }
     }



}
