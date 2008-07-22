package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;

// jdk imports
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.AccessCommandDao;
import gov.nih.nci.iscs.oracle.pgm.service.GrantQueryObject;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

// Springfranework imports

// hibernate imports

import net.sf.hibernate.*;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.MatchMode;
import net.sf.hibernate.expression.*;
import net.sf.hibernate.expression.Order;


public  class RetrieveGrantsCommandDao extends AccessCommandDao {
   /**
     * Abstract class that encapsulates the core methods common to all application
     *  commads for retrieveing Grants from the database. Builds the core search criteria
     *
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.query.AccessCommandDao
     * @see gov.nih.nci.iscs.oracle.pgm.dataaccess.query.dataaccess.RetrieveGrantsCommand
     * @author Michelle Engermann
     * @version 1.0
     */

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    public static final String PERCENT_SYMBOL = "%";
    public static final String DEFAULT_GRANT_NUM = "____________-__%";
    

   /*
    * Class constructor
    */
    public RetrieveGrantsCommandDao() {}


    /*
     * Build the Criteria object and build the sreach Criteria using the QueryObject
     * - Create class instance for NciPdQueryVw
     * - Create the Criteria object
     * - build the GrantsQueryCriteria from the parfent Class
     * throws a CommandDaoException
     * @retrun Criteria - a Criteria object
     */

    /*protected Criteria buildCriteria(Session aSession) throws CommandDaoException {

        Class mNciPdQueryVw = null;
        Criteria mCriteria = null;
        try{
            mNciPdQueryVw = Class.forName("gov.nih.nci.iscs.oracle.pgm.hibernate.NciPdQueryVw");
		    mCriteria = aSession.createCriteria(mNciPdQueryVw);
	    } catch (ClassNotFoundException e) {
			throw new CommandDaoException("Unable to create NciPdQueryVw class " + e.toString());
	    } catch (Exception e) {
			throw new CommandDaoException("Unable to create buildCriteria for Query " + e.toString());
	    }
		return mCriteria;
    }*/

    /*
     * This method builds the search Criteria for the core Grants search criteria
     *   maybe overloaded or extended by child class
     * @param Criteria - a Criteria Object
     * @param GrantsQueryObject - a GrantsQueryObject Object
     * @retrun Criteria - a Criteria object with seach Criteria/ or null
     */

    protected Criteria buildGrantsQueryCriteria(Criteria aCriteria, UserFilterInfo oUserFilterInfo, GrantQueryObject aGrantQueryObject) {


        ArrayList mGrantNumberList = new ArrayList();

        for (int index=0; index<4; index++){
             String mGrantNumber = formatGrantNumber(aGrantQueryObject.getTp()[index], aGrantQueryObject.getMech()[index], aGrantQueryObject.getIcd()[index],
                               aGrantQueryObject.getSrl()[index], aGrantQueryObject.getYear()[index], aGrantQueryObject.getSuffix()[index]);
	         if(!mGrantNumber.equalsIgnoreCase(DEFAULT_GRANT_NUM)){
				 mGrantNumberList.add(mGrantNumber);
			 }
	    }

        if(mGrantNumberList.size() > 0){
			Disjunction grantNumberCrit = Expression.disjunction();
	        Iterator mIterator = mGrantNumberList.iterator();
	        while(mIterator.hasNext()) {
		    	 String mtemp = (String) mIterator.next();
		    	 grantNumberCrit.add(Expression.ilike("fullGrantNum", mtemp));
		    }
		    aCriteria.add(grantNumberCrit);
	    }

		// add the Rfa/Pa Number  search criterion
		if ( !(aGrantQueryObject.getRfaPa() == null || aGrantQueryObject.getRfaPa().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ))
		   aCriteria.add(Expression.ilike("rfaPaNumber", aGrantQueryObject.getRfaPa().toUpperCase().trim() + PERCENT_SYMBOL ));

		// add the Cancer Activity search criterion
		if  ( !(aGrantQueryObject.getCancerActivity() == null || aGrantQueryObject.getCancerActivity().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ))
		   aCriteria.add(Expression.ilike("cayCode", aGrantQueryObject.getCancerActivity().toUpperCase().trim() + PERCENT_SYMBOL ));


		// add the applId  search criterion
		if ( !(aGrantQueryObject.getApplId() == null || aGrantQueryObject.getApplId().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ))
		    aCriteria.add(Expression.eq("applId",  new Long(aGrantQueryObject.getApplId().trim()) ));

		// add the ipf  search criterion
		if ( !(aGrantQueryObject.getIpf() == null || aGrantQueryObject.getIpf().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ))
		   aCriteria.add(Expression.eq("ipf", new Long(aGrantQueryObject.getIpf().trim() )));

   	    // add the Project Title search criterion
		if ( !(aGrantQueryObject.getProjectTitle() == null || aGrantQueryObject.getProjectTitle().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)))
		   aCriteria.add(Expression.ilike("projectTitle", aGrantQueryObject.getProjectTitle().trim(), MatchMode.ANYWHERE));

 	    // add the PI Last Name search criterion
 	         if ( !(aGrantQueryObject.getPiLastName() == null || aGrantQueryObject.getPiLastName().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)))
 	            aCriteria.add(Expression.ilike("lastName", aGrantQueryObject.getPiLastName().trim() + PERCENT_SYMBOL ));
	 
            // add the PI First Name search criterion
		if ( !(aGrantQueryObject.getPiFirstName() == null || aGrantQueryObject.getPiFirstName().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ))
		   aCriteria.add(Expression.ilike("firstName", aGrantQueryObject.getPiFirstName().trim() + PERCENT_SYMBOL ));

		// add the Institution Name search criterion
		if ( !(aGrantQueryObject.getInstName() == null || aGrantQueryObject.getInstName().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ))
		   aCriteria.add(Expression.ilike("orgName", aGrantQueryObject.getInstName().trim() + PERCENT_SYMBOL, MatchMode.ANYWHERE ));

		// add the Institution City search criterion
		if ( !(aGrantQueryObject.getInstCity() == null || aGrantQueryObject.getInstCity().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ))
		   aCriteria.add(Expression.ilike("institutionCity", aGrantQueryObject.getInstCity().toUpperCase().trim() + PERCENT_SYMBOL ));

		// add the Institution State search criterion
		if ( !(aGrantQueryObject.getInstState() == null || aGrantQueryObject.getInstState().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ))
		   aCriteria.add(Expression.ilike("institutionState", aGrantQueryObject.getInstState().toUpperCase().trim() + PERCENT_SYMBOL ));

		// add the NCAB from and to date search criterion
		if ( !(aGrantQueryObject.getNcabFromDate() == null || aGrantQueryObject.getNcabFromDate().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ) ){
			if(aGrantQueryObject.getNcabToDate() == null || aGrantQueryObject.getNcabToDate().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ) {
				aGrantQueryObject.setNcabToDate(aGrantQueryObject.getNcabFromDate());
		    }
		   aCriteria.add(Expression.between("councilMeetingDate", aGrantQueryObject.getNcabFromDate(), aGrantQueryObject.getNcabToDate() ));
	    }

		// add the Fiscal year from and to search criterion
		if ( !(aGrantQueryObject.getFyFrom() == null || aGrantQueryObject.getFyFrom().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ) ){
			if(aGrantQueryObject.getFyTo() == null || aGrantQueryObject.getFyTo().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ) {
				aGrantQueryObject.setFyTo(aGrantQueryObject.getFyFrom());
		    }
		   aCriteria.add(Expression.between("fy", new Integer(aGrantQueryObject.getFyFrom()), new Integer(aGrantQueryObject.getFyTo())));
	    }

		// add the Fiscal year from and to search criterion
		if ( (aGrantQueryObject.getFyFrom() == null || aGrantQueryObject.getFyFrom().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ) ){
			if(!(aGrantQueryObject.getFyTo() == null || aGrantQueryObject.getFyTo().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)) ) {
		        aCriteria.add(Expression.ge("fy", new Integer(aGrantQueryObject.getFyTo()) ));
		    }
	    }

		// add the NCAB from and to date search criterion
		if ( (aGrantQueryObject.getNcabFromDate() == null || aGrantQueryObject.getNcabFromDate().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ) ){
			if(!(aGrantQueryObject.getNcabToDate() == null || aGrantQueryObject.getNcabToDate().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)) ) {
		        aCriteria.add(Expression.ge("councilMeetingDate", aGrantQueryObject.getNcabToDate() ));
		    }
	    }

	    // add cancerActivityFlagSelected criteria
	    if (aGrantQueryObject.getGrantsFromCriteria().equalsIgnoreCase(ApplicationConstants.MY_CANCER_ACTIVITIES_VALUE) ) {
	        Object[] valuesArray = new Object[oUserFilterInfo.getCancerActivityCodes().size()];
	        Iterator mIterator = oUserFilterInfo.getCancerActivityCodes().iterator();
	        int i=0;
	        while(mIterator.hasNext()) {
			    String mtemp = (String) mIterator.next();
	            String tempValue = new String(mtemp.replaceAll("'", "") );
			    valuesArray[i] = tempValue;
			    i++;
		    }
		    aCriteria.add(Expression.in("cayCode",valuesArray));
		}

		// add the sort order search criterion
		if (aGrantQueryObject.getSortOrder().equalsIgnoreCase(ApplicationConstants.SORT_ASC)) {
			if(aGrantQueryObject.getSortColumn().equalsIgnoreCase("default") ||
			   aGrantQueryObject.getSortColumn().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ||
			   aGrantQueryObject.getSortColumn().equalsIgnoreCase("fullGrantNum") ||
			   aGrantQueryObject.getSortColumn().equalsIgnoreCase("grantNumber")){
				aCriteria.addOrder( Order.asc(ApplicationConstants.PHS_ORG_CODE_SORT));
				aCriteria.addOrder( Order.asc(ApplicationConstants.ACTIVITY_CODE_SORT));
				aCriteria.addOrder( Order.asc(ApplicationConstants.SERIAL_NUM_SORT));
				aCriteria.addOrder( Order.asc(ApplicationConstants.SUPPORT_YEAR_SORT));
				aCriteria.addOrder( Order.asc(ApplicationConstants.SUFFIX_CODE_SORT));
			} else {
                            if(aGrantQueryObject.getSortColumn().equalsIgnoreCase("lastName")){
                                aCriteria.addOrder( Order.asc("lastNameUpper"));
                            }else{
			    aCriteria.addOrder( Order.asc(aGrantQueryObject.getSortColumn()));
			    }	
                                aCriteria.addOrder( Order.asc(ApplicationConstants.PHS_ORG_CODE_SORT));
				aCriteria.addOrder( Order.asc(ApplicationConstants.ACTIVITY_CODE_SORT));
				aCriteria.addOrder( Order.asc(ApplicationConstants.SERIAL_NUM_SORT));
				aCriteria.addOrder( Order.asc(ApplicationConstants.SUPPORT_YEAR_SORT));
				aCriteria.addOrder( Order.asc(ApplicationConstants.SUFFIX_CODE_SORT));
			}
		} else {
			if(aGrantQueryObject.getSortColumn().equalsIgnoreCase("default") ||
			   aGrantQueryObject.getSortColumn().equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ||
			   aGrantQueryObject.getSortColumn().equalsIgnoreCase("fullGrantNum") ||
			   aGrantQueryObject.getSortColumn().equalsIgnoreCase("grantNumber")){
				aCriteria.addOrder( Order.desc(ApplicationConstants.PHS_ORG_CODE_SORT));
				aCriteria.addOrder( Order.desc(ApplicationConstants.ACTIVITY_CODE_SORT));
				aCriteria.addOrder( Order.desc(ApplicationConstants.SERIAL_NUM_SORT));
				aCriteria.addOrder( Order.desc(ApplicationConstants.SUPPORT_YEAR_SORT));
				aCriteria.addOrder( Order.desc(ApplicationConstants.SUFFIX_CODE_SORT));
			} else {
			    if(aGrantQueryObject.getSortColumn().equalsIgnoreCase("lastName")){
			        aCriteria.addOrder( Order.desc("lastNameUpper"));
			    }else{
			    aCriteria.addOrder( Order.desc(aGrantQueryObject.getSortColumn()));
			    }   
				aCriteria.addOrder( Order.desc(ApplicationConstants.PHS_ORG_CODE_SORT));
				aCriteria.addOrder( Order.desc(ApplicationConstants.ACTIVITY_CODE_SORT));
				aCriteria.addOrder( Order.desc(ApplicationConstants.SERIAL_NUM_SORT));
				aCriteria.addOrder( Order.desc(ApplicationConstants.SUPPORT_YEAR_SORT));
				aCriteria.addOrder( Order.desc(ApplicationConstants.SUFFIX_CODE_SORT));
			}
		}

		return aCriteria;

    }



    private String  formatGrantNumber(String tp, String mech, String icd, String srl, String year, String suffix) {

		int SRL_LENGTH = 6;
		int YR_LENGTH = 2;
		String mGrantNumber = "";
		srl = padValue(srl, SRL_LENGTH);
		year = padValue(year, YR_LENGTH);


		if (tp == null || tp.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ){
			mGrantNumber = mGrantNumber + "_";
		} else{
			mGrantNumber = mGrantNumber + tp.toUpperCase().trim() + PERCENT_SYMBOL;
		}

		if (mech == null || mech.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ){
			mGrantNumber = mGrantNumber + "___";
		} else{
			mGrantNumber = mGrantNumber + mech.toUpperCase().trim() + PERCENT_SYMBOL;
		}

		if (icd == null || icd.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ){
			mGrantNumber = mGrantNumber + "__";
		} else{
			mGrantNumber = mGrantNumber + icd.toUpperCase().trim() + PERCENT_SYMBOL;
		}

		if (srl == null || srl.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ){
			mGrantNumber = mGrantNumber + "______";
		} else{
			mGrantNumber = mGrantNumber + srl.toUpperCase().trim() + PERCENT_SYMBOL;
		}

		mGrantNumber = mGrantNumber + "-";

		if (year == null || year.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ){
			mGrantNumber = mGrantNumber + "__";
		} else{
			mGrantNumber = mGrantNumber + year.toUpperCase().trim() + PERCENT_SYMBOL;
		}

		if (suffix == null || suffix.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ){
			mGrantNumber = mGrantNumber + PERCENT_SYMBOL;
		} else{
			mGrantNumber = mGrantNumber + suffix.toUpperCase().trim() + PERCENT_SYMBOL;
		}


        return mGrantNumber;
	}

	private String padValue (String value, int maxLength){

		if(value == null )
			return ApplicationConstants.EMPTY_STRING;
	    if(value.trim().length()==0)
	        return ApplicationConstants.EMPTY_STRING;

		int valLength = value.length();
		String temp = "";
		if(valLength<maxLength){
			int upperLimit = maxLength - valLength;
			for(int i=0; i<upperLimit; i++){
				temp = temp += "0";
			}
		}

		value = temp + value;
		return value;
	}


}