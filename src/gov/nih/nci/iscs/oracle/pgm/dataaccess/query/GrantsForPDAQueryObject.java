package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;


//jdk imports
import java.math.BigDecimal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang.builder.ToStringBuilder;


import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryObject;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.PDAQueryObject;


public class GrantsForPDAQueryObject extends QueryObject implements PDAQueryObject{

   /**
     * GrantsForPDAQueryObject encapsulates the processing additional search columns
     * for Program Director Assignmenth
     *
     * @author Michelle Engermann
     * @version 1.0
     */
   /** Logger for this class and subclasses */

    protected final Log logger = LogFactory.getLog(getClass());


    private String ipf;
    private String i2Status;
    private String irgCode;
    private String irgFlexCode;
    private String groupCode;
    private String pdOrg;
    private String pdId;
    private String percentileFrom;
    private String percentileTo;
    private String priorityScoreFrom;
    private String priorityScoreTo;
    private boolean barFlag;
    private boolean unAssignedGrantsCriteria;
    private boolean inactiveGrantsCriteria;

    public GrantsForPDAQueryObject() {
        super();
    }


    public String getIpf() {
	  if (ipf==null)
		  return ApplicationConstants.EMPTY_STRING;
      return ipf;
    }

    public void setIpf(String ipf) {
      this.ipf = ipf;
    }

    public String getI2Status() {
	  if (i2Status==null)
		  return ApplicationConstants.EMPTY_STRING;
      return i2Status;
    }

    public void setI2Status(String i2Status) {
      this.i2Status = i2Status;
    }

    public String getPercentileFrom() {
	  if (percentileFrom==null)
		  return ApplicationConstants.EMPTY_STRING;
      return percentileFrom;
    }
    public BigDecimal getPercentileFromBD() {
		if (percentileFrom==null)
		    return new BigDecimal("0");
        return new BigDecimal(percentileFrom);
    }

    public void setPercentileFrom(String percentileFrom) {
      this.percentileFrom = percentileFrom;
    }

    public String getPercentileTo() {
	  if (percentileTo==null)
		  return ApplicationConstants.EMPTY_STRING;
      return percentileTo;
    }
    public BigDecimal getPercentileToBD() {
    	if (percentileTo==null)
		    return new BigDecimal("0");
         return new BigDecimal(percentileTo);
    }

    public void setPercentileTo(String percentileTo) {
      this.percentileTo = percentileTo;
    }


    public String getPriorityScoreFrom() {
	  if (priorityScoreFrom==null)
		  return ApplicationConstants.EMPTY_STRING;
      return priorityScoreFrom;
    }
    public Integer getPriorityScoreFromInt() {
	  if (priorityScoreFrom==null)
		    return new Integer("0");
      return new Integer(priorityScoreFrom);
    }

    public void setPriorityScoreFrom(String priorityScoreFrom) {
      this.priorityScoreFrom = priorityScoreFrom;
    }

    public String getPriorityScoreTo() {
	  if (priorityScoreTo==null)
		  return ApplicationConstants.EMPTY_STRING;
      return priorityScoreTo;
    }
    public Integer getPriorityScoreToInt() {
	  if (priorityScoreTo==null)
		    return new Integer("0");
      return new Integer(priorityScoreTo);
    }

    public void setPriorityScoreTo(String priorityScoreTo) {
      this.priorityScoreTo = priorityScoreTo;
    }

    public String getIrgCode() {
	  if (irgCode==null)
		  return ApplicationConstants.EMPTY_STRING;
      return irgCode;
    }

    public void setIrgCode(String irgCode) {
      this.irgCode = irgCode;
    }

    public String getIrgFlexCode() {
	  if (irgFlexCode==null)
		  return ApplicationConstants.EMPTY_STRING;
      return irgFlexCode;
    }

    public void setIrgFlexCode(String irgFlexCode) {
      this.irgFlexCode = irgFlexCode;
    }


    public String getGroupCode() {
	  if (groupCode==null)
		  return ApplicationConstants.EMPTY_STRING;
      return groupCode;
    }

    public void setGroupCode(String groupCode) {
      this.groupCode = groupCode;
    }

    public String getPdOrg() {
	  if (pdOrg==null)
		  return ApplicationConstants.EMPTY_STRING;
      return pdOrg;
    }

    public void setPdOrg(String pdOrg) {
      this.pdOrg = pdOrg;
    }

     public String getPdId() {
	  if (pdId==null)
		  return ApplicationConstants.EMPTY_STRING;
      return pdId;
    }

    public void setPdId(String pdId) {
      this.pdId = pdId;
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


    public String toString() {
       return new ToStringBuilder(this)
           .append (super.toString() )
           .append("ipf ", getIpf())
           .append("i2Status ", getI2Status())
           .append("pdOrg ", getPdOrg())
           .append("pdId ", getPdId())
           .append("barFlag ", getBarFlag())
           .append("percentileFrom ", getPercentileFrom())
           .append("percentileTo ", getPercentileTo())
           .append("priorityScoreFrom ", getPriorityScoreFrom())
           .append("priorityScoreTo ", getPriorityScoreTo())
           .toString();
	}


    /*
     * Checks all the search columns, and returns null if they are all null
     * @return boolean - false if any of the search column is not null;
     */
    public boolean isNull() {
        if (!super.isNull() )
            return false;

		if (ipf != null )
		    return false;

		if (i2Status != null )
		    return false;

		if (pdOrg != null )
		    return false;

		if (pdId != null )
		    return false;

        Boolean mBarFlag = new Boolean(barFlag);
	    if (mBarFlag != null )
		    return false;

		if (percentileFrom != null )
		    return false;

		if (percentileTo != null )
		    return false;

	    if (priorityScoreFrom != null )
		    return false;

		if (priorityScoreTo != null )
		    return false;

	    return true;

	}

}
