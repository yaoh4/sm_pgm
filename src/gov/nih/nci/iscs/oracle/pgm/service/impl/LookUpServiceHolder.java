package gov.nih.nci.iscs.oracle.pgm.service.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;


/**
 * @author Michelle Engermann
 */
public class LookUpServiceHolder {
	private static Log logger = LogFactory.getLog(LookUpServiceHolder.class);

	private static LookUpServiceHolder cLookUpServiceHolderInstance = null;
	private HashMap oLookUpHash = null;



    public static LookUpServiceHolder getLookUpHolderInstance() {

		 if (cLookUpServiceHolderInstance == null) {
			 createcLookUpServiceHolderInstance();
			 return cLookUpServiceHolderInstance;
	     } else {
			 return cLookUpServiceHolderInstance;
	     }
	 }
    private static LookUpServiceHolder createcLookUpServiceHolderInstance() {

		 cLookUpServiceHolderInstance = new LookUpServiceHolder();
		 cLookUpServiceHolderInstance.initializeInstance();
		 return cLookUpServiceHolderInstance;
	 }

    public HashMap getLookUpHash() {
		return oLookUpHash;
	}

    public void setLookUpHash(HashMap aLookUpHash) {
		this.oLookUpHash = aLookUpHash;
	}
	private void initializeInstance() {
		oLookUpHash = new HashMap();
	}

}
