package gov.nih.nci.iscs.oracle.pgm.service.impl;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUserImpl;

import gov.nih.nci.iscs.oracle.pgm.service.impl.BaseServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveUserFilterInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveUserInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveUserQueriesCommand;
import gov.nih.nci.iscs.oracle.pgm.hibernate.DbaRolePrivs;
import gov.nih.nci.iscs.oracle.pgm.hibernate.GrantQueriesT;
import gov.nih.nci.iscs.oracle.pgm.hibernate.NciPeopleVw;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

import net.sf.hibernate.HibernateException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;


/**
 * A jdbc implementation of the UserHandler interface.
 * @author Oracle
 */
public class UserServiceImpl extends BaseServiceImpl
{
    static Logger logger = LogManager.getLogger(UserServiceImpl.class);



    public UserServiceImpl(Object oContextFactory, String aUserId) {
		super(oContextFactory, aUserId);
	}

	public UserServiceImpl(Object oContextFactory) {
		super(oContextFactory);
	}

	public HashSet getUserDbRoles(String nciOracleId) {
		  HashSet mRoleSet = new HashSet();
		  try{
             RetrieveUserInfoCommand oRetrieveUserInfoCommand = (RetrieveUserInfoCommand) getBean("retrieveUserInfoCommandDao");
             QueryPage  aUserQueryPage = oRetrieveUserInfoCommand.execute(nciOracleId);
            // get the list from the page
             ArrayList mList =  (ArrayList) aUserQueryPage.getList();
             Iterator mIterator = mList.iterator();
             while (mIterator.hasNext() ) {
			     DbaRolePrivs mDbaRolePrivs = new DbaRolePrivs();
			     mDbaRolePrivs = (DbaRolePrivs) mIterator.next();
			     mRoleSet.add(mDbaRolePrivs.getGrantedRole());
	         }
		  } catch (Exception ex) {
			 throw new ServiceImplException("UserServiceImpl", "getUserDbRoles", "Unable to obtain User Priviledges from the database!!! " + ex.toString());
	      }
	       return mRoleSet;
    }
    
    public List getUserAppRoles(String userId) throws Exception {
     RetrieveUserInfoCommand oRetrieveUserInfoCommand = (RetrieveUserInfoCommand) getBean("retrieveUserInfoCommandDao");
   	 return oRetrieveUserInfoCommand.getUserAppRoles(userId);
    }
    
    public List<NciPeopleVw> searchUser(String firstName, String lastName) throws Exception{
    	RetrieveUserInfoCommand oRetrieveUserInfoCommand = (RetrieveUserInfoCommand) getBean("retrieveUserInfoCommandDao");
		return oRetrieveUserInfoCommand.searchUser(firstName, lastName);
	}
    
    /**
     * This method checks if logged in user is RestrictedUser.
     * @param  oracleId
     * @return boolean
     * @throws Exception 
     */   
    public boolean isRestrictedUser(String oracleId) throws Exception{
    	RetrieveUserInfoCommand oRetrieveUserInfoCommand = (RetrieveUserInfoCommand) getBean("retrieveUserInfoCommandDao");
    	return oRetrieveUserInfoCommand.isRestrictedUser(oracleId);
    }

    public UserFilterInfo getUserFilerInfo(String nciOracleId) throws Exception
    {
		try {
		    RetrieveUserFilterInfoCommand oRetrieveUserFilterInfoCommand = (RetrieveUserFilterInfoCommand) getBean("retrieveUserFilterInfoCommandDao");
		    RetrieveUserFilterInfoCommand bRetrieveUserFilterInfoCommand = (RetrieveUserFilterInfoCommand) getBean("retrieveUserFilterInfoCommandDao");

            UserFilterInfo mUserFilterInfo = oRetrieveUserFilterInfoCommand.execute(super.getUserId());

            return mUserFilterInfo;
		} catch (Exception ex) {
			throw new ServiceImplException("UserServiceImpl", "getUserFilerInfo", "Unable to obtain User Filer Information from the database!!! " + ex.toString());
	    }

    }

    public List getStoredUserQueriess(String nciOracleId) throws Exception
    {
		  List mQueryList = new ArrayList();
		  try {
             RetrieveUserQueriesCommand oRetrieveUserQueriesCommand = (RetrieveUserQueriesCommand) getBean("retrieveUserQueriesCommandDao");
             QueryPage  aUserQueryPage = oRetrieveUserQueriesCommand.execute(nciOracleId);
             // get the list from the page
             ArrayList mList =  (ArrayList) aUserQueryPage.getList();
             Iterator mIterator = mList.iterator();
             while (mIterator.hasNext() ) {
			     GrantQueriesT mGrantQueriesT = new GrantQueriesT();
			     mGrantQueriesT = (GrantQueriesT) mIterator.next();
			     mQueryList.add(mGrantQueriesT);
	         }
          } catch (Exception ex) {
			 throw new ServiceImplException("UserServiceImpl", "getStoredUserQueriess", "Fatal error occurred getting user Store Queries from the database!!! " + ex.toString());
          }
   	      return mQueryList;
    }

    public ArrayList buildUserFilterLookup(String nciOracleId, String mappingName) {
		ArrayList mList = new ArrayList();

        // get the UserFilterInfo

        try {
			LabelValueBean mLabelValueBean;
			UserFilterInfo mUserFilterInfo = getUserFilerInfo(nciOracleId);
	        if(!mappingName.equalsIgnoreCase(ApplicationConstants.REFERRAL_ACTION_MAPPING)){
			    if( mUserFilterInfo.getPortfolioFlag() ) {
	                String mTempValue = parseListItems(ApplicationConstants.MY_PORTFOLIOS,
		                                           mUserFilterInfo.getRuCodes());
		            mLabelValueBean = new LabelValueBean( mTempValue, ApplicationConstants.MY_PORTFOLIOS_VALUE);
		            mList.add(mLabelValueBean);
				}
			}
            if( mUserFilterInfo.getCancerActivityFlag() ) {
				String mTempValue = parseListItems(ApplicationConstants.MY_CANCER_ACTIVITIES,
		                                           mUserFilterInfo.getCancerActivityCodes());
		        mLabelValueBean = new LabelValueBean( mTempValue, ApplicationConstants.MY_CANCER_ACTIVITIES_VALUE  );
		        mList.add(mLabelValueBean);
		    }
		    mLabelValueBean = new LabelValueBean(ApplicationConstants.ALL_GRANTS, ApplicationConstants.ALL_GRANTS);

	        mList.add(mLabelValueBean);
        } catch (Exception ex) {
			throw new ServiceImplException("UserServiceImpl", "buildUserFilterLookup", "Fatal error occurred writing Filter infomation!!! " + ex.toString());
        }
	  return mList;
    }


    private String parseListItems(String aListType, List aList) throws Exception {
		Iterator mIterator = null;
        StringBuffer mStringBuffer = new StringBuffer(aListType);
        mStringBuffer.append("(");
        boolean mFirstIteration = true;

        mIterator = aList.iterator();
        while (mIterator.hasNext() ) {
	        if(!mFirstIteration) {
                mStringBuffer.append(",");
	        }
            mStringBuffer.append ((String) mIterator.next());
	        mFirstIteration = false;
        }
        mStringBuffer.append(")");
        return mStringBuffer.toString().replaceAll("'", "");
    }
     
    /**
     * This method retrieves information of logged in user from NciPeopleVw and populates NCIUser.
     * @param userId    
     * @return nciUser
     */
    public NciUserImpl getNCIUser(String userId) throws Exception {
    	NciPeopleVw nciPeopleVw = null;
    	RetrieveUserInfoCommand oRetrieveUserInfoCommand = (RetrieveUserInfoCommand) getBean("retrieveUserInfoCommandDao");
    	nciPeopleVw = oRetrieveUserInfoCommand.getNCIUserInformation(userId);

    	if(nciPeopleVw == null){
    		logger.info("I2E Account doesn't exist for User with userId: "+userId);
    		return null;
    	}

    	NciUserImpl nciUser = new NciUserImpl();
    	nciUser.setUserId(nciPeopleVw.getNihNetworkId());
    	nciUser.setAttribute("nciOracleId", nciPeopleVw.getOracleId());
    	nciUser.setAttribute("givenName", nciPeopleVw.getFirstName());
    	nciUser.setAttribute("lastName", nciPeopleVw.getLastName());

    	String givenName = (String)nciUser.getAttribute("givenName");
    	String lastName = (String)nciUser.getAttribute("lastName");
    	if (givenName ==  null) givenName = "";
    	if (lastName == null) lastName = "";
    	nciUser.setAttribute("fullName",givenName+" "+lastName);

    	nciUser.setAttribute("mail", nciPeopleVw.getEmailAddress());
    	nciUser.setAttribute("activeFlag", nciPeopleVw.getActiveFlag());

    	return nciUser;
    }

}