package gov.nih.nci.iscs.oracle.pgm.forms;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.servlet.http.HttpServletRequest;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.PDAQueryObject;

public class RetrieveGrantsForPDAForm extends RetrieveGrantsForm implements PDAQueryObject {



    private String irgCode;
    private String irgFlexCode;
    private boolean barFlag;
    private boolean unAssignedGrantsCriteria;
    private boolean inactiveGrantsCriteria;
    private boolean includeHistoricalGrants;
    private String i2Status;
    private String groupCode;
    private String pdOrg;
    private String pdId;
    private String percentileFrom;
    private String percentileTo;
    private String priorityScoreFrom;
    private String priorityScoreTo;


    public RetrieveGrantsForPDAForm() {
        super();
        pdId = ApplicationConstants.EMPTY_STRING;
        pdOrg = ApplicationConstants.EMPTY_STRING;
        percentileFrom = ApplicationConstants.EMPTY_STRING;
        percentileTo = ApplicationConstants.EMPTY_STRING;
  	    super.setListGenerated("N");
        setSortColumn(ApplicationConstants.PD_LAST_NAME_SORT);
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        pdId = ApplicationConstants.EMPTY_STRING;
        pdOrg = ApplicationConstants.EMPTY_STRING;
        percentileFrom = ApplicationConstants.EMPTY_STRING;
        percentileTo = ApplicationConstants.EMPTY_STRING;

        super.reset(mapping, request);
    }



    public String getIrgCode() {
      return irgCode;
    }

    public void setIrgCode(String irgCode) {
	  if (irgCode==null)
		  irgCode = ApplicationConstants.EMPTY_STRING;
      this.irgCode = irgCode;
    }

    public String getIrgFlexCode() {
	  if (irgFlexCode==null)
		  return ApplicationConstants.EMPTY_STRING;
      return irgFlexCode;
    }

    public void setIrgFlexCode(String irgCode) {
	  if (irgFlexCode==null)
		  irgFlexCode = ApplicationConstants.EMPTY_STRING;
      this.irgFlexCode = irgFlexCode;
    }

    public boolean getBarFlag() {
      return barFlag;
    }

    public void setBarFlag(boolean barFlag) {
      this.barFlag = barFlag;
    }
    public boolean getUnAssignedGrantsCriteria() {
      return unAssignedGrantsCriteria;
    }

    public void setUnAssignedGrantsCriteria(boolean unAssignedGrantsCriteria) {
      this.unAssignedGrantsCriteria = unAssignedGrantsCriteria;
    }

    public boolean getInactiveGrantsCriteria() {
      return inactiveGrantsCriteria;
    }

    public void setInactiveGrantsCriteria(boolean inactiveGrantsCriteria) {
      this.inactiveGrantsCriteria = inactiveGrantsCriteria;
    }

    public boolean getIncludeHistoricalGrants() {
      return includeHistoricalGrants;
    }

    public void setIncludeHistoricalGrants(boolean includeHistoricalGrants) {
      this.includeHistoricalGrants = includeHistoricalGrants;
    }


    public String getI2Status() {
		if (i2Status==null)
    	    return ApplicationConstants.EMPTY_STRING;
        return i2Status;
    }

    public void setI2Status(String i2Status) {
       if (i2Status==null)
   		  i2Status = ApplicationConstants.EMPTY_STRING;
       this.i2Status = i2Status;
    }

    public String getPercentileFrom() {
		if (percentileFrom==null)
		    return ApplicationConstants.EMPTY_STRING;
        return percentileFrom;
    }

    public void setPercentileFrom(String percentileFrom) {
    	 if (percentileFrom==null)
    		 percentileFrom = ApplicationConstants.EMPTY_STRING;
         this.percentileFrom = percentileFrom;
    }

    public String getPercentileTo() {
    	if (percentileTo==null)
    	   return ApplicationConstants.EMPTY_STRING;
         return percentileTo;
    }

    public void setPercentileTo(String percentileTo) {
    	if (percentileTo==null)
    		  percentileTo = ApplicationConstants.EMPTY_STRING;
        this.percentileTo = percentileTo;
    }


   public String getPriorityScoreFrom() {
    	if (priorityScoreFrom==null)
    	   return ApplicationConstants.EMPTY_STRING;
        return priorityScoreFrom;
   }

   public void setPriorityScoreFrom(String priorityScoreFrom) {
       if (priorityScoreFrom==null)
      	   priorityScoreFrom = ApplicationConstants.EMPTY_STRING;
       this.priorityScoreFrom = priorityScoreFrom;
   }

   public String getPriorityScoreTo() {
   	  if (priorityScoreTo==null)
  		  return ApplicationConstants.EMPTY_STRING;
      return priorityScoreTo;
   }

   public void setPriorityScoreTo(String priorityScoreTo) {
   	  if (priorityScoreTo==null)
   		  priorityScoreTo = ApplicationConstants.EMPTY_STRING;
     this.priorityScoreTo = priorityScoreTo;
   }


   public String getGroupCode() {
   	  if (groupCode==null)
    	  return ApplicationConstants.EMPTY_STRING;
      return groupCode;
   }

   public void setGroupCode(String groupCode) {
   	  if (groupCode==null)
    	  groupCode = ApplicationConstants.EMPTY_STRING;
      this.groupCode = groupCode;
   }

   public String getPdOrg() {
      if (pdOrg==null)
     	  return ApplicationConstants.EMPTY_STRING;
      return pdOrg;
   }

   public void setPdOrg(String pdOrg) {
   	  if (pdOrg==null)
   		  pdOrg = ApplicationConstants.EMPTY_STRING;
      this.pdOrg = pdOrg;
   }

   public String getPdId() {
      if (pdId==null)
    	  return ApplicationConstants.EMPTY_STRING;
      return pdId;
   }

   public void setPdId(String pdId) {
      if (pdId==null)
          pdId = ApplicationConstants.EMPTY_STRING;
      this.pdId = pdId;
   }

   public String toString() {
       return new ToStringBuilder(this)
           .append (super.toString() )
           .append("i2Status ", getI2Status())
           .append("pdOrg ", getPdOrg())
           .append("pdId ", getPdId())
           .append("barFlag ", getBarFlag())
           .append("percentileFrom ", getPercentileFrom())
           .append("percentileTo ", getPercentileTo())
           .append("includeHistoricalGrants ", getIncludeHistoricalGrants())
           .append("priorityScoreFrom ", getPriorityScoreFrom())
           .append("priorityScoreTo ", getPriorityScoreTo())
           .toString();
	}


    public void copyForms (RetrieveGrantsForPDAForm destForm) {
		System.out.println("**** now in forms coptForm before **** " + destForm);
		super.copyForms(destForm);
		destForm.irgCode  = this.irgCode;
		destForm.irgFlexCode  = this.irgFlexCode;
		destForm.barFlag  = this.barFlag;
		destForm.unAssignedGrantsCriteria  = this.unAssignedGrantsCriteria;
		destForm.inactiveGrantsCriteria  = this.inactiveGrantsCriteria;
		destForm.includeHistoricalGrants  = this.includeHistoricalGrants;
		destForm.i2Status  = this.i2Status;
		destForm.groupCode  = this.groupCode;
		destForm.pdOrg  = this.pdOrg;
		destForm.pdId  = this.pdId;
		destForm.percentileFrom  = this.percentileFrom;
		destForm.percentileTo  = this.percentileTo;
		destForm.priorityScoreFrom  = this.priorityScoreFrom;
        destForm.priorityScoreTo  = this.priorityScoreTo;
		System.out.println("**** now in forms coptForm after **** " + destForm);

	}



    /*
     * Checks all the search columns, and returns null if they are all null
     * @return boolean - false if any of the search column is not null;
     */

    public boolean isNull() {

        boolean results = true;
        if (!super.isNull() )
            return false;

	    if (i2Status != null & i2Status.trim().length() > 0)
		    return false;

	    if (pdOrg != null & pdOrg.trim().length() > 0)
		    return false;

	    if (pdId != null & pdId.trim().length() > 0)
		    return false;

        Boolean mBarFlag = new Boolean(barFlag);
	    if (mBarFlag != null )
		    return false;

	    if (percentileFrom != null & percentileFrom.trim().length() > 0)
		    return false;

	    if (percentileTo != null & percentileTo.trim().length() > 0)
		    return false;

	    if (priorityScoreFrom != null & priorityScoreFrom.trim().length() > 0)
		    return false;

	    if (priorityScoreTo != null & priorityScoreTo.trim().length() > 0)
		    return false;

        return results;
	}


  public List validate() {


  	   ArrayList validationMessages = new ArrayList();

  	   /*if(this.isNull() ){
  		  validationMessages.add("errors.search.criteria.null");
            return validationMessages;
  	   }*/

       if(pdId.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) &
          !validGrantNumber()) {
   		     validationMessages.add("errors.pd.equired.criteria.null");
			 return validationMessages;
	   }
       return super.validate();

     }

}
