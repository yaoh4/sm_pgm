package gov.nih.nci.iscs.oracle.pgm.dataaccess.impl;


//jdk imports

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.AccessCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;

// hibernate imports
import net.sf.hibernate.SessionFactory;

// springframework imports


/**
  * Base abstract class inherited by all CommandDao that perform access
  * / retrieve call to the database
  *
  * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.AccessCommand
  * @author Michelle Engermann
  * @version 1.0
  */
public  class AccessCommandDao  implements  AccessCommand {


    private SessionFactory sessionFactory;
   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());


    /*
     * Class constructor
     */
    public AccessCommandDao() {}

    /**
     * mutator / accessor methods for sessionFactory attribute
     */
    public SessionFactory getSessionFactory () {
		return this.sessionFactory;
    }
    public void setSessionFactory (SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
    }


    public QueryPage execute(String aUserId) {
		return (QueryPage) new Object();
	}


}