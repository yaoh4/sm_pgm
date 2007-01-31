package gov.nih.nci.iscs.oracle.pgm.service;


import org.apache.commons.lang.builder.ToStringBuilder;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

/** @author Hibernate CodeGenerator */
public class ReferralActionObject {


    /** identifier field */
    private  int   index;
    private Long   applId;
    private String pdId;
    private String cancerActivity;
    private String comments;
    private String rereferCA;
    private String rereferPOC;
    private String dualCA;
    private String results;
    private String programDirector;


    public void ReferralActionObject() {
		this.index = 0;
		this.comments = ApplicationConstants.EMPTY_STRING;
		this.rereferCA = ApplicationConstants.EMPTY_STRING;
		this.rereferPOC = ApplicationConstants.EMPTY_STRING;
		this.pdId = ApplicationConstants.EMPTY_STRING;
		this.results = ApplicationConstants.EMPTY_STRING;
		this.cancerActivity = ApplicationConstants.EMPTY_STRING;
		this.dualCA = ApplicationConstants.EMPTY_STRING;
		this.programDirector = ApplicationConstants.EMPTY_STRING;
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


   public void setComments(String comments) {
	   this.comments = comments;
   }
   public String getComments() {
	   if(comments == null)
			return ApplicationConstants.EMPTY_STRING;
	   return this.comments;
   }


   public void setRereferCA(String rereferCA) {
	   this.rereferCA = rereferCA;
   }
   public String getRereferCA() {
	   if(rereferCA == null)
			return ApplicationConstants.EMPTY_STRING;
	   return this.rereferCA;
   }

    public String getDualCA() {
		if (dualCA == null)
		    return ApplicationConstants.EMPTY_STRING;
		return this.dualCA;
	}
    public void setDualCA(String dualCA) {
		this.dualCA = dualCA;
	}



   public void setRereferPOC(String rereferPOC) {
	   this.rereferPOC = rereferPOC;
   }
   public String getRereferPOC() {
	   if(rereferPOC == null)
			return ApplicationConstants.EMPTY_STRING;
	   return this.rereferPOC;
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



  public String toString() {
        return new ToStringBuilder(this)
            .append("CanacerActivity ", getCancerActivity())
            .append("index ", getIndex())
            .append("ApplId ", getApplId())
            .append("pdId ", getPdId())
            .append("comments ", getComments())
            .append("rereferCA ", getRereferCA())
            .append("rereferPOC ", getRereferPOC())
            .append("dualCA ", getDualCA())
            .append("programDirector ", getProgramDirector())
            .append("results ", getResults())
            .toString();
    }
}
