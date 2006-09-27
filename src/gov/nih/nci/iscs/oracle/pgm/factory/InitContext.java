package gov.nih.nci.iscs.oracle.pgm.factory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import gov.nih.nci.iscs.oracle.pgm.context.ApplicationContextFactory;

public  class InitContext  {


    static Logger logger = LogManager.getLogger(InitContext.class);
    /**
     * InitContext encapsulates the implementation of the persistence mechanism
     *
     * @author Michelle Engermann
     * @version 1.0
     */


    /*
     * Constructor for the InitContext Class
     * Creates a singleton instance of the ApplicationContextFactory Class
     */

     public static Object getBean(String aBean) {
		 // get the bean
		 Object mBean = null;
		 mBean = (Object) ApplicationContextFactory.getApplicationContext().getBean(aBean);

	     return mBean;
	 }




}
