package gov.nih.nci.iscs.oracle.pgm.service;


import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.*;
import java.text.*;

/** @author Hibernate CodeGenerator */
public class PDASearchResultObject extends GrantSearchResultObject {


    /** identifier field */
    private String piLastName;
    private String PdId;
    private String fy;
    private String ncabDate;
    private String assignmentCA;
    private Date pdStartDate;
    private java.sql.Timestamp pdAssignmentStartDate;
    private String pdTransferCode;
    private String rfapa;
    private String key;
    private String adminPhsOrgCode;
    private String activityCode;
    private Integer serialNum;
    private Integer supportYear;
    private String suffixCode;
    public static java.sql.Timestamp mToday;
    public static java.sql.Timestamp mYesterday;

    static{
	}

    public PDASearchResultObject() {
		super();
		pdAssignmentStartDate = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
	}

    public String getPiLastName() {
		return this.piLastName;
	}
    public void setPiLastName(String piName) {
		this.piLastName = piName;
	}

    public String getPdId() {
		return this.PdId;
	}
    public void setPdId(String PdId) {
		this.PdId = PdId;
	}

    public String getFy() {
		return this.fy;
	}
    public void setFy(String fy) {
		this.fy = fy;
	}


    public String getNcabDate() {
		return this.ncabDate;
	}
    public void setNcabDate(String ncabDate) {
		this.ncabDate = ncabDate;
	}

    public String getAssignmentCA() {
		return this.assignmentCA;
	}
    public void setAssignmentCA(String assignmentCA) {
		this.assignmentCA = assignmentCA;
	}


    public Date getPdStartDate() {
		return pdStartDate;
	}
    public void setPdStartDate(String pdStartDate) {
		this.pdStartDate = parseAssignmentDate(pdStartDate);

	}
    public void setPdStartDate(Date pdStartDate) {
		this.pdStartDate = pdStartDate;

    }

    public java.sql.Timestamp getPdAssignmentStartDate() {
		if(pdAssignmentStartDate == null ){
			  pdAssignmentStartDate = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
		}

		return pdAssignmentStartDate;
	}
    public void setPdAssignmentStartDate(String pdAssignmentStartDate) {
		this.pdAssignmentStartDate = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
	}
    public void setPdAssignmentStartDate(java.sql.Timestamp pdAssignmentStartDate) {
		this.pdAssignmentStartDate = pdAssignmentStartDate;
	}

    public String getPdTransferCode() {
		return this.pdTransferCode;
	}
    public void setPdTransferCode(String pdTransferCode) {
		this.pdTransferCode = pdTransferCode;
	}

    public String getRfapa() {
		return this.rfapa;
	}
    public void setRfapa(String rfaPaNumber) {
		this.rfapa = rfaPaNumber;
	}

    public String getKey() {
		return this.key;
	}
    public void setKey(String key) {
		this.key = key;
	}

   public Date parseAssignmentDate(String pdStartDate) {

	   Date mReturnValue = null;
	   try{
	       SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	       mReturnValue=new java.sql.Timestamp(formatter.parse(pdStartDate).getTime());
	       return mReturnValue;

	  }catch(Exception ex) {
		  System.out.println("****unable to parse date **** " + ex.toString());
		  return mReturnValue;
	  }

	  //return mReturnValue;
   }


    public String toString() {
        return new ToStringBuilder(this)
            .append("super ", super.toString())
            .append("piName ", getPiLastName())
            .append("PdId ", getPdId())
            .append("Fy ", getFy())
            .append("NcabDate ", getNcabDate())
            .append("assignmentCA ", getAssignmentCA())
            .append("PdStartDate ", getPdStartDate())
            .append("PdTransferCode ", getPdTransferCode())
            .append("rfaPaNumber ", getRfapa())
            .append("key ", getKey())
            .toString();
    }

    public void setAdminPhsOrgCode(String adminPhsOrgCode) {
        this.adminPhsOrgCode = adminPhsOrgCode;
    }

    public String getAdminPhsOrgCode() {
        return adminPhsOrgCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSupportYear(Integer supportYear) {
        this.supportYear = supportYear;
    }

    public Integer getSupportYear() {
        return supportYear;
    }

    public void setSuffixCode(String suffixCode) {
        this.suffixCode = suffixCode;
    }

    public String getSuffixCode() {
        return suffixCode;
    }
}
