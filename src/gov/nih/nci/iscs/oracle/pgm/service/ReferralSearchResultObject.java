package gov.nih.nci.iscs.oracle.pgm.service;


import org.apache.commons.lang.builder.ToStringBuilder;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

import java.util.Date;

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
    private Date currentReferralActivityDate;
    private String currentReferralActivityCode;
    private String eGrantsNumber;
    private String rfapa;
    private String apsComments;
    private String adminPhsOrgCode;
    private String activityCode;
    private String serialNum;
    private String supportYear;
    private String suffixCode;
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

    public Date getCurrentReferralActivityDate() {                            
		return this.currentReferralActivityDate;
	}
    public void setCurrentReferralActivityDate(Date currentReferralActivityDate) {
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

    public void setCurrentReferralActivityCode(String currentReferralActivityCode) {
        this.currentReferralActivityCode = currentReferralActivityCode;
    }

    public String getCurrentReferralActivityCode() {
        return currentReferralActivityCode;
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

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSupportYear(String supportYear) {
        this.supportYear = supportYear;
    }

    public String getSupportYear() {
        return supportYear;
    }

    public void setSuffixCode(String suffixCode) {
        this.suffixCode = suffixCode;
    }

    public String getSuffixCode() {
        return suffixCode;
    }
}
