package gov.nih.nci.iscs.oracle.pgm.service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import java.util.*;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

/** @author Hibernate CodeGenerator */
public class PdAssignmentActionObject {


    /** identifier field */
    private  int   index;
    private Long   applId;
    private String pdId;
    private String cancerActivity;
    private Date assignmentDate;
    private String assignmentCA;
    private String results;
    private String programDirector;
    private String grantNumber;
    private String pdTransferCode;
    protected SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");


    public void PdAssignmentActionObject() {
		this.index = 0;
		this.pdId = ApplicationConstants.EMPTY_STRING;
		this.results = ApplicationConstants.EMPTY_STRING;
		this.cancerActivity = ApplicationConstants.EMPTY_STRING;
		//this.assignmentDate = ApplicationConstants.EMPTY_STRING;
		this.assignmentCA = ApplicationConstants.EMPTY_STRING;
		this.programDirector = ApplicationConstants.EMPTY_STRING;
		this.grantNumber = ApplicationConstants.EMPTY_STRING;
		this.pdTransferCode = ApplicationConstants.EMPTY_STRING;

    }

    public void setIndex(int index) {
		this.index = index;
	}
    public int getIndex() {
		return this.index;
	}

    public void setApplId(Long applId) {
		this.applId = applId;
	}
    public Long getApplId() {
		return this.applId;
	}

    public String getPdId() {
	    if(pdId == null)
			return ApplicationConstants.EMPTY_STRING;

		return this.pdId;
	}
    public void setPdId(String pdId) {
		this.pdId = pdId;
	}

    public void setCancerActivity(String cancerActivity) {
		this.cancerActivity = cancerActivity;
	}
    public String getCancerActivity() {
	    if(cancerActivity == null)
			return ApplicationConstants.EMPTY_STRING;
		return this.cancerActivity;
	}

   public Date getAssignmentDate() {
		if (assignmentDate == null)
		    return new Date();
		return this.assignmentDate;
   }
   public void setAssignmentDate(Date assignmentDate) {
		this.assignmentDate = assignmentDate;
   }

   public String getAssignmentCA() {
		if (assignmentCA == null)
		    return ApplicationConstants.EMPTY_STRING;
		return this.assignmentCA;
   }
   public void setAssignmentCA(String assignmentCA) {
		this.assignmentCA = assignmentCA;
   }


   public void setResults(String results) {
	   this.results = results;
   }
   public String getResults() {
	   return this.results;
   }

   public void setProgramDirector(String programDirector) {
	   this.programDirector = programDirector;
   }
   public String getProgramDirector() {
	   return this.programDirector;
   }


   public void setGrantNumber(String grantNumber) {
	   this.grantNumber = grantNumber;
   }
   public String getGrantNumber() {
	   return this.grantNumber;
   }

    public String getPdTransferCode() {
		return this.pdTransferCode;
	}
    public void setPdTransferCode(String pdTransferCode) {
		this.pdTransferCode = pdTransferCode;
	}

   public java.sql.Date parseAssignmentDate() {

	   try{
           Date sqlToday = new Date();
	      //sqlToday=new java.sql.Date(formatter.parse(assignmentDate).getTime());
	      return (java.sql.Date) sqlToday;

	  }catch(Exception ex) {
		  System.out.println("****unable to parse date **** " + ex.toString());
		  return null;
	  }
   }


  public String toString() {
        return new ToStringBuilder(this)
            .append("CanacerActivity ", getCancerActivity())
            .append("index ", getIndex())
            .append("ApplId ", getApplId())
            .append("pdId ", getPdId())
            .append("assignmentDate ", getAssignmentDate())
            .append("assignmentCA ", getAssignmentCA())
            .append("programDirector ", getProgramDirector())
            .append("grantNumber ", getGrantNumber())
            .append("PdTransferCode ", getPdTransferCode())
            .append("results ", getResults())
            .toString();
    }
}
