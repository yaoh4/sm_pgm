package gov.nih.nci.iscs.oracle.pgm.factory;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.GrantReferalDao;

public abstract class DAOFactory {
    /**
     * DAOFactory encapsulates the implementation of the persistence mechanism
     *
     * @author Michelle Engermann
     * @version 1.0
     */

     // List of persistence mechnisms supported by the factory
	 public static final int HIBERNATE = 1;
     public static final int JDBC = 2;

    /*
     * List the accessor method for each DAO that can be created.
     * The concrete factories will have to implement these methods.
     */

     public abstract GrantReferalDao   getGrantReferalDao();


    /*
     * Returns the right DAOFactory Implementation based on the application parameter provided
     * @retrun DAOFactory - Concrete Implenetation of database persistence
     * @param applicationFactory - parameter indicating persistence mechanism
     */
     public static DAOFactory getDAOFactory(int applicationFactory) {

         switch (applicationFactory) {
             case HIBERNATE:
                  return new HibernateDAOFactory();
             default           :
                  return null;
         }
     }
}
