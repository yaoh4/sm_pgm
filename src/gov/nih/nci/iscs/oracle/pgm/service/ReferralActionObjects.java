package gov.nih.nci.iscs.oracle.pgm.service;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import java.util.List;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

/** @author Hibernate CodeGenerator */
public class ReferralActionObjects {


    /** identifier field */
    private  int   index;
    private Long   applId;
    private String pdId;
    private String cancerActivity;
    private String comments;
    private String dualCA;
    private String results;


    public void ReferralActionObjects() {
		this.index = 0;
		this.comments = ApplicationConstants.EMPTY_STRING;
		this.pdId = ApplicationConstants.EMPTY_STRING;
		this.results = ApplicationConstants.EMPTY_STRING;
		this.cancerActivity = ApplicationConstants.EMPTY_STRING;
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

    public String getDualCA() {
		if (dualCA == null)
		    return ApplicationConstants.EMPTY_STRING;
		return this.dualCA;
	}
    public void setDualCA(String dualCA) {
		this.dualCA = dualCA;
	}


   public void setComments(String comments) {
	   this.comments = comments;
   }
   public String getComments() {
	   return this.comments;
   }

   public void setResults(String results) {
	   this.results = results;
   }
   public String getResults() {
	   return this.results;
   }


  public String toString() {
        return new ToStringBuilder(this)
            .append("CanacerActivity ", getCancerActivity())
            .append("index ", getIndex())
            .append("ApplId ", getApplId())
            .append("pdId ", getPdId())
            .append("comments ", getComments())
            .append("dualCA ", getDualCA())
            .append("results ", getResults())
            .toString();
    }
}
