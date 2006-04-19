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
		/*mToday = new java.sql.Timestamp(Calendar.getInstance().getTime());
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DATE, -1);
        mYesterday = new java.sql.Timestamp(calendar.getTime());*/
		mToday = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());

		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DATE, -1);
        mYesterday = new java.sql.Timestamp(calendar.getTimeInMillis());
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
		java.sql.Timestamp parsedDate = parseAssignmentDate(pdAssignmentStartDate);
	    if(!parsedDate.after(mToday)) {
		   setPdAssignmentStartDate(mToday);
	   }else{
		   setPdAssignmentStartDate(parsedDate);
	   }
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

   public java.sql.Timestamp parseAssignmentDate(String pdStartDate) {

	   java.sql.Timestamp mReturnValue = null;
	   try{
	       SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	       java.sql.Timestamp sqlAssignmentDate=new java.sql.Timestamp(formatter.parse(pdStartDate).getTime());
	       mReturnValue =  (java.sql.Timestamp) sqlAssignmentDate;
	       return mReturnValue;

	  }catch(Exception ex) {
		  System.out.println("****unable to parse date **** " + ex.toString());
		  return mReturnValue;
	  }

	  //return mReturnValue;
   }

   public String validatePdAssignmentStartDate(String pdStartDate){

	   String mReturnValue = ApplicationConstants.EMPTY_STRING;

       DateValidator mDateValidator = DateValidator.getInstance();
       boolean validDate = mDateValidator.isValid(pdStartDate, "MM/dd/yyyy", true);

	   if(!validDate){
		   return "errors.invalid.assignment.date.format";
	   }
	   java.sql.Timestamp parsedDate = parseAssignmentDate(pdStartDate);

	   if(!parsedDate.after(mYesterday)){
		   return "errors.invalid.assignment.date";
	   }

	   if(!parsedDate.after(mToday)) {
		   pdAssignmentStartDate = mToday;
		   return mReturnValue;
	   }else{
		   pdAssignmentStartDate = parsedDate;
	   }
	   return mReturnValue;
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
            .append("PdAssignmentStartDate ", getPdAssignmentStartDate())
            .append("PdTransferCode ", getPdTransferCode())
            .append("rfaPaNumber ", getRfaPaNumber())
            .append("key ", getKey())
            .toString();
    }

}
