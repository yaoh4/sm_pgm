package gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper;

import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import gov.nih.nci.iscs.oracle.pgm.service.impl.LookUpServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.service.impl.LookUpServiceHolder;

import org.springframework.context.ApplicationContext;



public class LookupHelper  {
    /**
     * LookupHelper contains helper routines that are common to the LookUp process
     *
     * @author Michelle Engermann
     * @version 1.0
     */

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());


public static HashMap getLookUpTableHash() {
    /*
     * Returns the Lookup HashMap from the singleton LookUpServiceHolder class
     *
     * @return HashMap - lookUp Hash
     */

       LookUpServiceHolder mLookUpHolder = LookUpServiceHolder.getLookUpHolderInstance();

       return mLookUpHolder.getLookUpHash();
   }

public static void  saveLookUpTableHash(HashMap mLookUpHash) {
    /*
     * sets the Lookup HashMap from the singleton LookUpServiceHolder class
     *
     * @return HashMap - lookUp Hash
     */

       LookUpServiceHolder mLookUpHolder = LookUpServiceHolder.getLookUpHolderInstance();

       mLookUpHolder.setLookUpHash(mLookUpHash);
   }

public static ArrayList  addNewLookUp(String[] mLookUpValues, ApplicationContext mApplicationContext) {
    /*
     * sets the Lookup HashMap from the singleton LookUpServiceHolder class
     *
     * @return HashMap - lookUp Hash
     */

     HashMap mLookUpTableHash = getLookUpTableHash();
     if( !mLookUpTableHash.containsKey(mLookUpValues[0])) {
	    LookUpServiceImpl mLookUpServiceImpl = new LookUpServiceImpl( (Object) mApplicationContext );
	    List mLookUpTableValues = mLookUpServiceImpl.getLookUpTable(mLookUpValues);
	    mLookUpTableHash.put(mLookUpValues[0],  mLookUpTableValues);

	    LookupHelper.saveLookUpTableHash(mLookUpTableHash);
	    return (ArrayList) mLookUpTableValues;
	 } else {
		 return (ArrayList) mLookUpTableHash.get(mLookUpValues[0]);
	 }

}

public static ArrayList getLookUp(String[] mLookUpValues, ApplicationContext mApplicationContext) {
    /*
     * retrieves the Lookup HashMap from the singleton LookUpServiceHolder class
     *
     * @return HashMap - lookUp Hash
     */

     HashMap mLookUpTableHash = getLookUpTableHash();
     if( !mLookUpTableHash.containsKey(mLookUpValues[0])) {
		 addNewLookUp(mLookUpValues, mApplicationContext);
	 }

	 return (ArrayList) mLookUpTableHash.get((String) mLookUpValues[0]);
 }


}