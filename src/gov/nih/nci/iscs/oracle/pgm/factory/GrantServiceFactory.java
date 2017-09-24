package gov.nih.nci.iscs.oracle.pgm.factory;

import org.springframework.context.ApplicationContext;


import gov.nih.nci.iscs.oracle.pgm.service.GrantSearchService;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralActionService;
import gov.nih.nci.iscs.oracle.pgm.service.impl.PDAssignmentServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.service.impl.ReferralActionServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.service.impl.ReferalServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.service.impl.PdAssignmentActionServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.service.PdAssignmentActionService;

import java.util.*;

public abstract class GrantServiceFactory {
    /**
     * DAOFactory encapsulates the implementation of the persistence mechanism
     *
     * @author Michelle Engermann
     * @version 1.0
     */



    /*
     * Returns the right GrantServiceFactory Implementation based on the
     * action parameter provided
     * @retrun GrantSearchService - Concrete Implenetation of GrantSearchService
     * @param action - parameter indicating action
     */
     public static GrantSearchService getGrantSearchService(String action, ApplicationContext aApplicationContext) {

         if (action.equalsIgnoreCase( ApplicationConstants.REFERRAL) )
             return new ReferalServiceImpl((Object) aApplicationContext);

         if (action.equalsIgnoreCase( ApplicationConstants.PD_ASSIGNMENT))
             return new PDAssignmentServiceImpl((Object) aApplicationContext);

         return null;


     }
    /*
     * Returns the right GrantServiceFactory Implementation based on the
     * action parameter provided
     * @retrun ReferalActionService - Concrete Implenetation of ReferalActionService
     * @param ArrayList - List of grants for Refrral Action
     */
     public static ReferralActionService getReferralActionService(Map referralActionGrants, ApplicationContext aApplicationContext, String aUserId,String readOnly) {

             return new ReferralActionServiceImpl(referralActionGrants, (Object) aApplicationContext, aUserId,readOnly);



     }


    /*
     * Returns the right GrantServiceFactory Implementation based on the
     * action parameter provided
     * @retrun PdAssignmentActionService - Concrete Implenetation of PdAssignmentActionService
     * @param ArrayList - List of grants for AdAssignments Action
     */
     public static PdAssignmentActionService getPdAssignmentActionService(Map PdAssignmentActionGrants, ApplicationContext aApplicationContext, String aUserId,String readOnly) {

             return new PdAssignmentActionServiceImpl(PdAssignmentActionGrants, (Object) aApplicationContext, aUserId,readOnly);



     }
  }
