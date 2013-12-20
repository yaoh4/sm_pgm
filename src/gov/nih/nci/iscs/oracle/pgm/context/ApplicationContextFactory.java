/*
 *  This file was created by Rick Hightower of ArcMinds Inc.
 *
 */
package gov.nih.nci.iscs.oracle.pgm.context;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

/**
 * @author Michelle Engermann
 */
public class ApplicationContextFactory {
	private static Log logger = LogFactory.getLog(ApplicationContextFactory.class);

	private static String contextResourceLocation = "gov/nih/nci/iscs/oracle/pgm/context/applicationContext.xml";
//	 private static String contextResourceLocation = "gov/nih/nci/iscs/oracle/pgm/context/development/applicationContext.xml";
	private static ApplicationContextFactory cApplicationContextFactoryInstance = null;
       private static ApplicationContext oApplicationContext = null;



    public static ApplicationContext getApplicationContext() {

		 if (cApplicationContextFactoryInstance == null) {
			 createFactoryInstance();
			 return oApplicationContext;
	     } else {
			 return oApplicationContext;
	     }
	 }
    public static ApplicationContext getApplicationContext(String contextPath) {

		 if (cApplicationContextFactoryInstance == null) {
			 createFactoryInstance(contextPath);
			 return oApplicationContext;
	     } else {
			 return oApplicationContext;
	     }
	 }


     private static void createFactoryInstance(String contextPath) {
		 cApplicationContextFactoryInstance = new ApplicationContextFactory();
		 cApplicationContextFactoryInstance.initializeContext(contextPath);
     }

     private static void createFactoryInstance() {
		 cApplicationContextFactoryInstance = new ApplicationContextFactory();
		 cApplicationContextFactoryInstance.initializeContext();
     }
	private static void initializeContext(){


        // get the application path from the properties or XML file
        try{
           logger.info(" contextPath is " + contextResourceLocation);
    	   oApplicationContext =  new ClassPathXmlApplicationContext(contextResourceLocation);
	    } catch (Exception ex) {
            logger.error(ex);
            throw new InfrastructureException(ex.toString());
	    }

     }
	private static void initializeContext(String contextPath){


        // get the application path from the properties or XML file
        try{
           logger.info(" contextPath is " + contextPath);
    	   oApplicationContext =  new ClassPathXmlApplicationContext(contextPath);

	    } catch (Exception ex) {
            logger.error(ex);
            throw new InfrastructureException(ex.toString());
	    }

     }

}
