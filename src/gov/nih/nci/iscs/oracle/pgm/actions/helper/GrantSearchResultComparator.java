package gov.nih.nci.iscs.oracle.pgm.actions.helper;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.commons.beanutils.PropertyUtils;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.GrantSearchResultObject;

import javax.servlet.http.HttpSession;

import java.util.*;
import java.util.Comparator;


/**
 * CancerActivityComparator encapsulates the implementation of CRUD calls to
 * the database for the AddressVO object.
 *
 * @see gov.nih.nci.iscs.i2e.supp.oracle.data.persistence.jdbc.handler.PersonAddressHandler
 * @author Michelle Engermann
 * @version 1.0
 */
public class GrantSearchResultComparator implements Comparator {
    public static Comparator CancerActivityComparator = new Comparator() {
            public int compare(Object aGrantSearchResultObject, Object anotherGrantSearchResultObject) {
                int returnValue = 0;
                GrantSearchResultObject mFirstGrantSearchResultObject = (GrantSearchResultObject) aGrantSearchResultObject;
                GrantSearchResultObject mNextGrantSearchResultObject = (GrantSearchResultObject) anotherGrantSearchResultObject;
                String mFirstCACode = mFirstGrantSearchResultObject.getCancerActivity()
                                                        .toUpperCase();
                String mNextCACode = mNextGrantSearchResultObject.getCancerActivity()
                                                      .toUpperCase();
                if (!(mFirstCACode.equals(mNextCACode))) {
                    returnValue = mFirstCACode.compareTo(mNextCACode);
                }
                return returnValue;
            }

            private String parseString(String aCode) {
                String mEmptyString = "";

                try {
                    if (aCode == null) {
                        aCode = mEmptyString;
                    }

                    aCode = aCode.trim();

                    if (aCode.length() > 0) {
                        aCode = aCode.toUpperCase();
                    }
                } catch (Exception e) {
                    aCode = mEmptyString;
                }

                return aCode;
            }

       };

    public GrantSearchResultComparator() {}

    public int compare(Object aGrantSearchResultObject, Object anotherGrantSearchResultObject) {
        return 0;

        // use static inner class methods
    }
}
