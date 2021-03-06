package gov.nih.nci.iscs.oracle.pgm.service;

import gov.nih.nci.iscs.oracle.pgm.actions.SearchGrantsAction;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.builder.ToStringBuilder;
import java.util.*;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/** @author Hibernate CodeGenerator */
public class PdAssignmentActionObject {


    /** identifier field */
    private  int   index;
    private Long   applId;
    private String pdId;
    private String cancerActivity;
    private java.sql.Timestamp assignmentDate;
    private String assignmentCA;
    private String results;
    private String programDirector;
    private String grantNumber;
    private String pdTransferCode;
    protected SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private static Logger logger = LogManager.getLogger(PdAssignmentActionObject.class);


    public void PdAssignmentActionObject() {
		this.index = 0;
		this.pdId = ApplicationConstants.EMPTY_STRING;
		this.results = ApplicationConstants.EMPTY_STRING;
		this.cancerActivity = ApplicationConstants.EMPTY_STRING;
		this.assignmentDate = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
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

   public java.sql.Timestamp getAssignmentDate() {
		if (assignmentDate == null)
		    return null;
		return this.assignmentDate;
   }
   public void setAssignmentDate(java.sql.Timestamp assignmentDate) {
		this.assignmentDate = assignmentDate;
   }
   public String getFormattedAssignmentDate() {


		String mFormattedDate = formatter.format(assignmentDate);
		return mFormattedDate;
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

   public java.sql.Timestamp parseAssignmentDate() {

	   try{
           Date sqlToday = new Date();
	      //sqlToday=new java.sql.Timestamp(formatter.parse(assignmentDate).getTime());
	      return (java.sql.Timestamp) sqlToday;

	  }catch(Exception ex) {
		  logger.error("****unable to parse date **** " + ex.toString());
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
