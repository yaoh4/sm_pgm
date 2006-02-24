package gov.nih.nci.iscs.oracle.pgm.service;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import java.util.*;

/** @author Hibernate CodeGenerator */
public class PDASearchResultObject extends GrantSearchResultObject {


    /** identifier field */
    private String piName;
    private String PdId;
    private String fy;
    private String ncabDate;
    private String assignmentCA;
    private Date pdStartDate;
    private String pdTransferCode;
    private String rfaPaNumber;






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

   public java.util.Date parseAssignmentDate(String pdStartDate) {

	   try{
           //java.util.Date sqlToday = new Date();
	       java.util.Date sqlAssignmentDate=new java.util.Date(formatter.parse(pdStartDate).getTime());
	      return (java.util.Date) sqlAssignmentDate;

	  }catch(Exception ex) {
		  System.out.println("****unable to parse date **** " + ex.toString());
		  return null;
	  }
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
            .toString();
    }

}
