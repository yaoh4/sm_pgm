package gov.nih.nci.iscs.oracle.pgm.service;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.validator.DateValidator;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import java.util.*;
import java.text.*;

/** @author Hibernate CodeGenerator */
public class PDASearchResultObject extends GrantSearchResultObject {


    /** identifier field */
    private String piName;
    private String PdId;
    private String fy;
    private String ncabDate;
    private String assignmentCA;
    private Date pdStartDate;
    private java.sql.Timestamp pdAssignmentStartDate;
    private String pdTransferCode;
    private String rfaPaNumber;
    private String key;
    public static java.sql.Timestamp mToday;
    public static java.sql.Timestamp mYesterday;

    static{
	}

    public PDASearchResultObject() {
		super();
		pdAssignmentStartDate = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
	}

    public String getPiName() {
		return this.piName;
	}
    public void setPiName(String piName) {
		this.piName = piName;
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

    public String getRfaPaNumber() {
		return this.rfaPaNumber;
	}
    public void setRfaPaNumber(String rfaPaNumber) {
		this.rfaPaNumber = rfaPaNumber;
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
            .append("piName ", getPiName())
            .append("PdId ", getPdId())
            .append("Fy ", getFy())
            .append("NcabDate ", getNcabDate())
            .append("assignmentCA ", getAssignmentCA())
            .append("PdStartDate ", getPdStartDate())
            .append("PdTransferCode ", getPdTransferCode())
            .append("rfaPaNumber ", getRfaPaNumber())
            .append("key ", getKey())
            .toString();
    }

}
