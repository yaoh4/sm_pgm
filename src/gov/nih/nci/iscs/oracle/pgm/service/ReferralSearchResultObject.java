package gov.nih.nci.iscs.oracle.pgm.service;


import org.apache.commons.lang.builder.ToStringBuilder;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

/** @author Hibernate CodeGenerator */
public class ReferralSearchResultObject extends GrantSearchResultObject {


    /** identifier field */
    private String grantNumber;
    private String instName;
    private String piLastName;
    private String projectTitle;
    private String araStatus;
    private String dualCA;
    private String dualPoc;
    private String currentPoc;
    private String ncabDate;
    private String currentReferralActivityDate;
    private String currentReferralActivityCode;
    private String eGrantsNumber;
    private String rfapa;
    private String apsComments;
    private String referralComments;
    private String nihGuideAddrUrl;
    private boolean reReferred = false;


    public String getInstName() {
		return this.instName;
	}

    public void setInstName(String instName) {
		this.instName = instName;
	}


    public String getPiLastName() {
		return this.piLastName;
	}
    public void setPiLastName(String piLastName) {
		this.piLastName = piLastName;
	}


    public String getProjectTitle() {
		return this.projectTitle;
	}
    public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}


    public String getAraStatus() {
		if (araStatus == null)
		    return ApplicationConstants.EMPTY_STRING;
		return this.araStatus;
	}
    public void setAraStatus(String araStatus) {
		this.araStatus = araStatus;
	}

    public String getDualCA() {
		if (dualCA == null)
		    return ApplicationConstants.EMPTY_STRING;
		return this.dualCA;
	}
    public void setDualCA(String dualCA) {
		this.dualCA = dualCA;
	}

    public String getDualPoc() {
		if (dualPoc == null)
		    return ApplicationConstants.EMPTY_STRING;
		return this.dualPoc;
	}
    public void setDualPoc(String dualPoc) {
		this.dualPoc = dualPoc;
	}

    public String getCurrentPoc() {
		if (currentPoc == null)
		    return ApplicationConstants.EMPTY_STRING;
		return this.currentPoc;
	}
    public void setCurrentPoc(String currentPoc) {
		this.currentPoc = currentPoc;
	}


    public String getEGrantsNumber() {
		if (eGrantsNumber == null)
		    return ApplicationConstants.EMPTY_STRING;
		return this.eGrantsNumber;
	}
    public void setEGrantsNumber(String eGrantsNumber) {
		this.eGrantsNumber = eGrantsNumber;
	}

    public String getNcabDate() {
		if (ncabDate == null)
		    return ApplicationConstants.EMPTY_STRING;
		return this.ncabDate;
	}
    public void setNcabDate(String ncabDate) {
		this.ncabDate = ncabDate;
	}

    public String getCurrentReferralActivityDate() {
		if (currentReferralActivityDate == null)
		    return ApplicationConstants.EMPTY_STRING;
		return this.currentReferralActivityDate;
	}
    public void setCurrentReferralActivityDate(String currentReferralActivityDate) {
		this.currentReferralActivityDate = currentReferralActivityDate;
	}

    public boolean getReReferred() {
		return this.reReferred;
	}
    public void setReReferred(boolean reReferred) {
		this.reReferred = reReferred;
	}


    public String toString() {
        return new ToStringBuilder(this)
            .append("super ", super.toString())
            .append("InstName ", getInstName())
            .append("PiLastName ", getPiLastName())
            .append("projectTitle ", getProjectTitle())
            .append("araStatus ", getAraStatus())
            .append("dualCA ", getDualCA())
            .append("dualPoc ", getDualPoc())
            .append("currentPoc ", getCurrentPoc())
            .append("ncabDate ", getNcabDate())
            .append("currentReferralActivityDate ", getCurrentReferralActivityDate())
            .append("eGrantsNumber ", getEGrantsNumber())
            .append("reReferred ", getReReferred())
            .toString();
    }

    public void setRfapa(String rfapa) {
        this.rfapa = rfapa;
    }

    public String getRfapa() {
        return rfapa;
    }

    public void setApsComments(String apsComments) {
        this.apsComments = apsComments;
    }

    public String getApsComments() {
        return apsComments;
    }

    /**
	 * @return the referralComments
	 */
	public String getReferralComments() {
		return referralComments;
	}

	/**
	 * @param referralComments the referralComments to set
	 */
	public void setReferralComments(String referralComments) {
		this.referralComments = referralComments;
	}

	public void setCurrentReferralActivityCode(String currentReferralActivityCode) {
        this.currentReferralActivityCode = currentReferralActivityCode;
    }

    public String getCurrentReferralActivityCode() {
        return currentReferralActivityCode;
    }
    
    public void setNihGuideAddrUrl(String nihGuideAddrUrl){
        this.nihGuideAddrUrl = nihGuideAddrUrl;
    }
    
    public String getNihGuideAddrUrl(){
        return nihGuideAddrUrl;
    }
}
