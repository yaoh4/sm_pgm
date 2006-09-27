package gov.nih.nci.iscs.oracle.pgm.service.impl;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveApplicationLinkInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveUserFilterInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.WbRetrieveBoardsCommand;
import gov.nih.nci.iscs.oracle.pgm.hibernate.GwbLinksT;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import gov.nih.nci.iscs.oracle.pgm.service.impl.BaseServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.WbReferralActivitiesInfoCommand;

import java.util.Map;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/**
 * A jdbc implementation of the UserHandler interface.
 * @author Oracle
 */
public class WbReferralActivitiesImpl extends BaseServiceImpl
{
    static Logger logger = LogManager.getLogger(WbReferralActivitiesImpl.class);



    public WbReferralActivitiesImpl(Object oContextFactory ) {
		super(oContextFactory);
	}

  /**
   * Returns a map of list of Referral Activities to councilMeetingDates
   * @return
   * @param councilMeetingDate
   */
    public Map getReferralActivitiesMap( UserFilterInfo userFilterInfo) {
		  Map mReferralMap  = new HashMap(3);
		  try{
        List boards = getBoards(); //Get the previous, current, and next boards
        String prevCouncil = (String)boards.get(0);
        String currentCouncil = (String)boards.get(1);
        String nextCouncil = (String)boards.get(2);
        List prevActivities = getReferralActivities(prevCouncil, userFilterInfo.getCancerActivityCodes());
        List currentActivities = getReferralActivities(currentCouncil, userFilterInfo.getCancerActivityCodes());
        List nextActivities = getReferralActivities(nextCouncil, userFilterInfo.getCancerActivityCodes());
        mReferralMap.put(prevCouncil, prevActivities);
        mReferralMap.put(currentCouncil, currentActivities);
        mReferralMap.put(nextCouncil, nextActivities);
		  } catch (Exception ex) {
			 throw new ServiceImplException("WbReferralActivitiesImpl", "getReferralActivitiesMap", "Unable to obtain referral activities, board map from the database!!! " + ex.toString());
	      }
	      return  mReferralMap;
    }

    /*
     * Get referral activities for a particular council.
     *
     */
    public List getReferralActivities(String councilMeetingDate, List cancerActivities) {
		  ArrayList mList  = new ArrayList();
		  try{
         WbReferralActivitiesInfoCommand oWbReferralActivitiesInfoCommand = (WbReferralActivitiesInfoCommand) getBean("wbReferralActivitiesInfoCommandDao");
         QueryPage  aQueryPage = oWbReferralActivitiesInfoCommand.execute(councilMeetingDate, cancerActivities, super.getUserId());
         // get the list from the page
         mList = (ArrayList) aQueryPage.getList();
		  } catch (Exception ex) {
			 throw new ServiceImplException("WbReferralActivitiesImpl", "getReferralActivities", "Unable to obtain referral activities from the database!!! " + ex.toString());
	      }
	      return (List) mList;
    }
  /**
   * Get the board council meeting dates for previous, current, and next boards.
   * @return
   */
  public List getBoards()
  {
      List boards = null;
		  try{
         WbRetrieveBoardsCommand oWbRetrieveBoardsCommand = (WbRetrieveBoardsCommand) getBean("wbRetrieveBoardsCommandDao");
		 String result = oWbRetrieveBoardsCommand.execute(super.getUserId());
         if (result.equals("failed"))
         {
            throw new Exception("Error getting boards.");
         }
         boards = oWbRetrieveBoardsCommand.getBoards();
		  } catch (Exception ex) {
			 throw new ServiceImplException("WbReferralActivitiesImpl", "getBoards", "Unable to obtain current, next and previous boards from the database!!! " + ex.toString());
	      }
	      return boards;

  }
  /**
   * Gets the url for an application.
   * @return
   * @param applicationName
   */
    public String getApplicationUrl(String applicationName)
    {
      String url= "";
      try {
       RetrieveApplicationLinkInfoCommand oRetrieveApplicationLinkInfoCommand = (RetrieveApplicationLinkInfoCommand) getBean("retrieveApplicationLinkInfoCommandDao");
       QueryPage aQueryPage = oRetrieveApplicationLinkInfoCommand.execute(applicationName, super.getUserId());
       List mList = (ArrayList) aQueryPage.getList();
       if (mList.size()>0)
       {
          GwbLinksT oGwbLinksT = (GwbLinksT)mList.get(0);
          StringBuffer buf = new StringBuffer(30);
          buf.append(oGwbLinksT.getProtocol()==null?"http://":oGwbLinksT.getProtocol()+"://");
          buf.append(oGwbLinksT.getLinkServer());
          buf.append(oGwbLinksT.getLinkPath());
          url = buf.toString();
       }
      }
      catch (Exception ex) {
			 throw new ServiceImplException("WbReferralActivitiesImpl", "getSearchCriteria", "Unable to obtain Workbench Search Criteria from the database!!! " + ex.toString());
	      }
       return url;
    }

  /**
   * Gets the default user filter information.
   * @throws java.lang.Exception
   * @return
   * @param nciOracleId
   */
   public UserFilterInfo getUserFilterInfo(String nciOracleId) throws Exception
    {
		try {
		    RetrieveUserFilterInfoCommand oRetrieveUserFilterInfoCommand = (RetrieveUserFilterInfoCommand) getBean("retrieveUserFilterInfoCommandDao");
            UserFilterInfo oUserFilterInfo  = oRetrieveUserFilterInfoCommand.execute(nciOracleId.toUpperCase());
            return oUserFilterInfo;
		} catch (Exception ex) {
			throw new ServiceImplException("UserServiceImpl", "getUserFilerInfo", "Unable to obtain User Filer Information from the database!!! " + ex.toString());
	    }

    }
}