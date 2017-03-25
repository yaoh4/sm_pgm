package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 *         table="NCI_PD_QUERY_VW"
 *
*/
public class NciPdQueryVw implements Serializable {

    /** identifier field */
    private java.lang.Long applId;

    /** identifier field */
    private java.lang.String fullGrantNum;

    /** identifier field */
    private java.lang.String rfaPaNumber;

    /** identifier field */
    private java.lang.String councilMeetingDate;

    /** identifier field */
    private java.lang.String firstName;

    /** identifier field */
    private java.lang.String miName;

    /** identifier field */
    private java.lang.String lastName;

    /** identifier field */
    private java.lang.String lastNameUpper;

    /** identifier field */
    private java.lang.String applTypeCode;

    /** identifier field */
    private java.lang.String adminPhsOrgCode;

    /** identifier field */
    private java.lang.String activityCode;

    /** identifier field */
    private java.lang.Integer serialNum;

    /** identifier field */
    private java.lang.Integer supportYear;

    /** identifier field */
    private java.lang.String suffixCode;

    /** identifier field */
    private java.lang.String applStatusCode;

    /** identifier field */
    private java.lang.String applStatusGroupCode;

    /** identifier field */
    private java.util.Date budgetStartDate;

    /** identifier field */
    private java.util.Date budgetEndDate;

    /** identifier field */
    private java.lang.Integer fy;

    /** identifier field */
    private java.lang.Long ipf;

    /** identifier field */
    private java.lang.String orgName;

    /** identifier field */
    private java.lang.String institutionCity;

    /** identifier field */
    private java.lang.String institutionState;

    /** identifier field */
    private java.lang.String projectTitle;

    /** identifier field */
    private java.lang.String legacySourceFile;

    /** identifier field */
    private java.lang.String cayCode;

    /** identifier field */
    private java.lang.String dualCayCode;

    /** identifier field */
    private java.lang.Long pocNpnId;

    /** identifier field */
    private java.lang.String pocLastName;

    /** identifier field */
    private java.lang.String pocFirstName;

    /** identifier field */
    private java.lang.String pocMiName;

    /** identifier field */
    private java.lang.String pocFullName;

    /** identifier field */
    private java.lang.Long dualPocNpnId;

    /** identifier field */
    private java.lang.String dualPocLastName;

    /** identifier field */
    private java.lang.String dualPocFirstName;

    /** identifier field */
    private java.lang.String dualPocMiName;

    /** identifier field */
    private java.lang.String dualPocFullName;

    /** identifier field */
    private java.lang.String araStatusCode;

    /** identifier field */
    private java.lang.Long araId;

    /** identifier field */
    private java.lang.String araMatchFlag;

    /** identifier field */
    private java.lang.String currentFutureBoardFlag;

    /** identifier field */
    private java.lang.String currentReferralActivityCode;

    /** identifier field */
    private java.util.Date currentReferralActivityDate;

    /** identifier field */
    private java.lang.String withdrawnFlag;

    /** identifier field */
    private java.lang.String currentApsComments;
    
    /** identifier field */
    private java.lang.String referralComments;

    /** identifier field */
    private java.lang.String nihGuideAddr;

    /** full constructor */
    public NciPdQueryVw(java.lang.Long applId, java.lang.String fullGrantNum, java.lang.String rfaPaNumber, java.lang.String councilMeetingDate, java.lang.String firstName, java.lang.String miName, java.lang.String lastName, java.lang.String applTypeCode, java.lang.String adminPhsOrgCode, java.lang.String activityCode, java.lang.Integer serialNum, java.lang.Integer supportYear, java.lang.String suffixCode, java.lang.String applStatusCode, java.lang.String applStatusGroupCode, java.util.Date budgetStartDate, java.util.Date budgetEndDate, java.lang.Integer fy, java.lang.Long ipf, java.lang.String orgName, java.lang.String institutionCity, java.lang.String institutionState, java.lang.String projectTitle, java.lang.String legacySourceFile, java.lang.String cayCode, java.lang.String dualCayCode, java.lang.Long pocNpnId, java.lang.String pocLastName, java.lang.String pocFirstName, java.lang.String pocMiName, java.lang.String pocFullName, java.lang.Long dualPocNpnId, java.lang.String dualPocLastName, java.lang.String dualPocFirstName, java.lang.String dualPocMiName, java.lang.String dualPocFullName, java.lang.String araStatusCode, java.lang.Long araId, java.lang.String araMatchFlag, java.lang.String currentFutureBoardFlag, java.lang.String currentReferralActivityCode, java.util.Date currentReferralActivityDate, java.lang.String withdrawnFlag, java.lang.String currentApsComments, java.lang.String referralComments) {
        this.applId = applId;
        this.fullGrantNum = fullGrantNum;
        this.rfaPaNumber = rfaPaNumber;
        this.councilMeetingDate = councilMeetingDate;
        this.firstName = firstName;
        this.miName = miName;
        this.lastName = lastName;
        this.lastNameUpper = lastNameUpper;
        this.applTypeCode = applTypeCode;
        this.adminPhsOrgCode = adminPhsOrgCode;
        this.activityCode = activityCode;
        this.serialNum = serialNum;
        this.supportYear = supportYear;
        this.suffixCode = suffixCode;
        this.applStatusCode = applStatusCode;
        this.applStatusGroupCode = applStatusGroupCode;
        this.budgetStartDate = budgetStartDate;
        this.budgetEndDate = budgetEndDate;
        this.fy = fy;
        this.ipf = ipf;
        this.orgName = orgName;
        this.institutionCity = institutionCity;
        this.institutionState = institutionState;
        this.projectTitle = projectTitle;
        this.legacySourceFile = legacySourceFile;
        this.cayCode = cayCode;
        this.dualCayCode = dualCayCode;
        this.pocNpnId = pocNpnId;
        this.pocLastName = pocLastName;
        this.pocFirstName = pocFirstName;
        this.pocMiName = pocMiName;
        this.pocFullName = pocFullName;
        this.dualPocNpnId = dualPocNpnId;
        this.dualPocLastName = dualPocLastName;
        this.dualPocFirstName = dualPocFirstName;
        this.dualPocMiName = dualPocMiName;
        this.dualPocFullName = dualPocFullName;
        this.araStatusCode = araStatusCode;
        this.araId = araId;
        this.araMatchFlag = araMatchFlag;
        this.currentFutureBoardFlag = currentFutureBoardFlag;
        this.currentReferralActivityCode = currentReferralActivityCode;
        this.currentReferralActivityDate = currentReferralActivityDate;
        this.withdrawnFlag = withdrawnFlag;
        this.currentApsComments = currentApsComments;
        this.referralComments = referralComments;
        this.nihGuideAddr = nihGuideAddr;
    }

    /** default constructor */
    public NciPdQueryVw() {
    }

    /**
     *                @hibernate.property
     *                 column="APPL_ID"
     *
     */
    public java.lang.Long getApplId() {
        return this.applId;
    }

    public void setApplId(java.lang.Long applId) {
        this.applId = applId;
    }

    /**
     *                @hibernate.property
     *                 column="FULL_GRANT_NUM"
     *
     */
    public java.lang.String getFullGrantNum() {
        return this.fullGrantNum;
    }

    public void setFullGrantNum(java.lang.String fullGrantNum) {
        this.fullGrantNum = fullGrantNum;
    }

    /**
     *                @hibernate.property
     *                 column="RFA_PA_NUMBER"
     *
     */
    public java.lang.String getRfaPaNumber() {
        return this.rfaPaNumber;
    }

    public void setRfaPaNumber(java.lang.String rfaPaNumber) {
        this.rfaPaNumber = rfaPaNumber;
    }

    /**
     *                @hibernate.property
     *                 column="COUNCIL_MEETING_DATE"
     *
     */
    public java.lang.String getCouncilMeetingDate() {
        return this.councilMeetingDate;
    }

    public void setCouncilMeetingDate(java.lang.String councilMeetingDate) {
        this.councilMeetingDate = councilMeetingDate;
    }

    /**
     *                @hibernate.property
     *                 column="FIRST_NAME"
     *
     */
    public java.lang.String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    /**
     *                @hibernate.property
     *                 column="MI_NAME"
     *
     */
    public java.lang.String getMiName() {
        return this.miName;
    }

    public void setMiName(java.lang.String miName) {
        this.miName = miName;
    }

    /**
     *                @hibernate.property
     *                 column="LAST_NAME"
     *
     */
    public java.lang.String getLastName() {
        return this.lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    /**
     *                @hibernate.property
     *                 column="LAST_NAME_UPPER"
     *
     */
    public java.lang.String getLastNameUpper() {
        return this.lastNameUpper;
    }

    public void setLastNameUpper(java.lang.String lastNameUpper) {
        this.lastNameUpper = lastNameUpper;
    }

    /**
     *                @hibernate.property
     *                 column="APPL_TYPE_CODE"
     *
     */
    public java.lang.String getApplTypeCode() {
        return this.applTypeCode;
    }

    public void setApplTypeCode(java.lang.String applTypeCode) {
        this.applTypeCode = applTypeCode;
    }

    /**
     *                @hibernate.property
     *                 column="ADMIN_PHS_ORG_CODE"
     *
     */
    public java.lang.String getAdminPhsOrgCode() {
        return this.adminPhsOrgCode;
    }

    public void setAdminPhsOrgCode(java.lang.String adminPhsOrgCode) {
        this.adminPhsOrgCode = adminPhsOrgCode;
    }

    /**
     *                @hibernate.property
     *                 column="ACTIVITY_CODE"
     *
     */
    public java.lang.String getActivityCode() {
        return this.activityCode;
    }

    public void setActivityCode(java.lang.String activityCode) {
        this.activityCode = activityCode;
    }

    /**
     *                @hibernate.property
     *                 column="SERIAL_NUM"
     *
     */
    public java.lang.Integer getSerialNum() {
        return this.serialNum;
    }

    public void setSerialNum(java.lang.Integer serialNum) {
        this.serialNum = serialNum;
    }

    /**
     *                @hibernate.property
     *                 column="SUPPORT_YEAR"
     *
     */
    public java.lang.Integer getSupportYear() {
        return this.supportYear;
    }

    public void setSupportYear(java.lang.Integer supportYear) {
        this.supportYear = supportYear;
    }

    /**
     *                @hibernate.property
     *                 column="SUFFIX_CODE"
     *
     */
    public java.lang.String getSuffixCode() {
        return this.suffixCode;
    }

    public void setSuffixCode(java.lang.String suffixCode) {
        this.suffixCode = suffixCode;
    }

    /**
     *                @hibernate.property
     *                 column="APPL_STATUS_CODE"
     *
     */
    public java.lang.String getApplStatusCode() {
        return this.applStatusCode;
    }

    public void setApplStatusCode(java.lang.String applStatusCode) {
        this.applStatusCode = applStatusCode;
    }

    /**
     *                @hibernate.property
     *                 column="APPL_STATUS_GROUP_CODE"
     *
     */
    public java.lang.String getApplStatusGroupCode() {
        return this.applStatusGroupCode;
    }

    public void setApplStatusGroupCode(java.lang.String applStatusGroupCode) {
        this.applStatusGroupCode = applStatusGroupCode;
    }

    /**
     *                @hibernate.property
     *                 column="BUDGET_START_DATE"
     *
     */
    public java.util.Date getBudgetStartDate() {
        return this.budgetStartDate;
    }

    public void setBudgetStartDate(java.util.Date budgetStartDate) {
        this.budgetStartDate = budgetStartDate;
    }

    /**
     *                @hibernate.property
     *                 column="BUDGET_END_DATE"
     *
     */
    public java.util.Date getBudgetEndDate() {
        return this.budgetEndDate;
    }

    public void setBudgetEndDate(java.util.Date budgetEndDate) {
        this.budgetEndDate = budgetEndDate;
    }

    /**
     *                @hibernate.property
     *                 column="FY"
     *
     */
    public java.lang.Integer getFy() {
        return this.fy;
    }

    public void setFy(java.lang.Integer fy) {
        this.fy = fy;
    }

    /**
     *                @hibernate.property
     *                 column="IPF"
     *
     */
    public java.lang.Long getIpf() {
        return this.ipf;
    }

    public void setIpf(java.lang.Long ipf) {
        this.ipf = ipf;
    }

    /**
     *                @hibernate.property
     *                 column="ORG_NAME"
     *
     */
    public java.lang.String getOrgName() {
        return this.orgName;
    }

    public void setOrgName(java.lang.String orgName) {
        this.orgName = orgName;
    }

    /**
     *                @hibernate.property
     *                 column="INSTITUTION_CITY"
     *
     */
    public java.lang.String getInstitutionCity() {
        return this.institutionCity;
    }

    public void setInstitutionCity(java.lang.String institutionCity) {
        this.institutionCity = institutionCity;
    }

    /**
     *                @hibernate.property
     *                 column="INSTITUTION_STATE"
     *
     */
    public java.lang.String getInstitutionState() {
        return this.institutionState;
    }

    public void setInstitutionState(java.lang.String institutionState) {
        this.institutionState = institutionState;
    }

    /**
     *                @hibernate.property
     *                 column="PROJECT_TITLE"
     *
     */
    public java.lang.String getProjectTitle() {
        return this.projectTitle;
    }

    public void setProjectTitle(java.lang.String projectTitle) {
        this.projectTitle = projectTitle;
    }

    /**
     *                @hibernate.property
     *                 column="LEGACY_SOURCE_FILE"
     *
     */
    public java.lang.String getLegacySourceFile() {
        return this.legacySourceFile;
    }

    public void setLegacySourceFile(java.lang.String legacySourceFile) {
        this.legacySourceFile = legacySourceFile;
    }

    /**
     *                @hibernate.property
     *                 column="CAY_CODE"
     *
     */
    public java.lang.String getCayCode() {
        return this.cayCode;
    }

    public void setCayCode(java.lang.String cayCode) {
        this.cayCode = cayCode;
    }

    /**
     *                @hibernate.property
     *                 column="DUAL_CAY_CODE"
     *
     */
    public java.lang.String getDualCayCode() {
        return this.dualCayCode;
    }

    public void setDualCayCode(java.lang.String dualCayCode) {
        this.dualCayCode = dualCayCode;
    }

    /**
     *                @hibernate.property
     *                 column="POC_NPN_ID"
     *
     */
    public java.lang.Long getPocNpnId() {
        return this.pocNpnId;
    }

    public void setPocNpnId(java.lang.Long pocNpnId) {
        this.pocNpnId = pocNpnId;
    }

    /**
     *                @hibernate.property
     *                 column="POC_LAST_NAME"
     *
     */
    public java.lang.String getPocLastName() {
        return this.pocLastName;
    }

    public void setPocLastName(java.lang.String pocLastName) {
        this.pocLastName = pocLastName;
    }

    /**
     *                @hibernate.property
     *                 column="POC_FIRST_NAME"
     *
     */
    public java.lang.String getPocFirstName() {
        return this.pocFirstName;
    }

    public void setPocFirstName(java.lang.String pocFirstName) {
        this.pocFirstName = pocFirstName;
    }

    /**
     *                @hibernate.property
     *                 column="POC_MI_NAME"
     *
     */
    public java.lang.String getPocMiName() {
        return this.pocMiName;
    }

    public void setPocMiName(java.lang.String pocMiName) {
        this.pocMiName = pocMiName;
    }

    /**
     *                @hibernate.property
     *                 column="POC_FULL_NAME"
     *
     */
    public java.lang.String getPocFullName() {
        return this.pocFullName;
    }

    public void setPocFullName(java.lang.String pocFullName) {
        this.pocFullName = pocFullName;
    }

    /**
     *                @hibernate.property
     *                 column="DUAL_POC_NPN_ID"
     *
     */
    public java.lang.Long getDualPocNpnId() {
        return this.dualPocNpnId;
    }

    public void setDualPocNpnId(java.lang.Long dualPocNpnId) {
        this.dualPocNpnId = dualPocNpnId;
    }

    /**
     *                @hibernate.property
     *                 column="DUAL_POC_LAST_NAME"
     *
     */
    public java.lang.String getDualPocLastName() {
        return this.dualPocLastName;
    }

    public void setDualPocLastName(java.lang.String dualPocLastName) {
        this.dualPocLastName = dualPocLastName;
    }

    /**
     *                @hibernate.property
     *                 column="DUAL_POC_FIRST_NAME"
     *
     */
    public java.lang.String getDualPocFirstName() {
        return this.dualPocFirstName;
    }

    public void setDualPocFirstName(java.lang.String dualPocFirstName) {
        this.dualPocFirstName = dualPocFirstName;
    }

    /**
     *                @hibernate.property
     *                 column="DUAL_POC_MI_NAME"
     *
     */
    public java.lang.String getDualPocMiName() {
        return this.dualPocMiName;
    }

    public void setDualPocMiName(java.lang.String dualPocMiName) {
        this.dualPocMiName = dualPocMiName;
    }

    /**
     *                @hibernate.property
     *                 column="DUAL_POC_FULL_NAME"
     *
     */
    public java.lang.String getDualPocFullName() {
        return this.dualPocFullName;
    }

    public void setDualPocFullName(java.lang.String dualPocFullName) {
        this.dualPocFullName = dualPocFullName;
    }

    /**
     *                @hibernate.property
     *                 column="ARA_STATUS_CODE"
     *
     */
    public java.lang.String getAraStatusCode() {
        return this.araStatusCode;
    }

    public void setAraStatusCode(java.lang.String araStatusCode) {
        this.araStatusCode = araStatusCode;
    }

    /**
     *                @hibernate.property
     *                 column="ARA_ID"
     *
     */
    public java.lang.Long getAraId() {
        return this.araId;
    }

    public void setAraId(java.lang.Long araId) {
        this.araId = araId;
    }

    /**
     *                @hibernate.property
     *                 column="ARA_MATCH_FLAG"
     *
     */
    public java.lang.String getAraMatchFlag() {
        return this.araMatchFlag;
    }

    public void setAraMatchFlag(java.lang.String araMatchFlag) {
        this.araMatchFlag = araMatchFlag;
    }

    /**
     *                @hibernate.property
     *                 column="CURRENT_FUTURE_BOARD_FLAG"
     *
     */
    public java.lang.String getCurrentFutureBoardFlag() {
        return this.currentFutureBoardFlag;
    }

    public void setCurrentFutureBoardFlag(java.lang.String currentFutureBoardFlag) {
        this.currentFutureBoardFlag = currentFutureBoardFlag;
    }

    /**
     *                @hibernate.property
     *                 column="CURRENT_REFERRAL_ACTIVITY_CODE"
     *
     */
    public java.lang.String getCurrentReferralActivityCode() {
        return this.currentReferralActivityCode;
    }

    public void setCurrentReferralActivityCode(java.lang.String currentReferralActivityCode) {
        this.currentReferralActivityCode = currentReferralActivityCode;
    }

    /**
     *                @hibernate.property
     *                 column="CURRENT_REFERRAL_ACTIVITY_DATE"
     *
     */
    public java.util.Date getCurrentReferralActivityDate() {
        return this.currentReferralActivityDate;
    }

    public void setCurrentReferralActivityDate(java.util.Date currentReferralActivityDate) {
        this.currentReferralActivityDate = currentReferralActivityDate;
    }

    /**
     *                @hibernate.property
     *                 column="WITHDRAWN_FLAG"
     *
     */
    public java.lang.String getWithdrawnFlag() {
        return this.withdrawnFlag;
    }

    public void setWithdrawnFlag(java.lang.String withdrawnFlag) {
        this.withdrawnFlag = withdrawnFlag;
    }

    /**
     *                @hibernate.property
     *                 column="CURRENT_APS_COMMENTS"
     *
     */
    public java.lang.String getCurrentApsComments() {
        return this.currentApsComments;
    }

    public void setCurrentApsComments(java.lang.String currentApsComments) {
        this.currentApsComments = currentApsComments;
    }

    /**
	 * @return the referralComments
	 */
	public java.lang.String getReferralComments() {
		return referralComments;
	}

	/**
	 * @param referralComments the referralComments to set
	 */
	public void setReferralComments(java.lang.String referralComments) {
		this.referralComments = referralComments;
	}

	/**
	 *                @hibernate.property
	 *                 column="NIH_GUIDE_ADDR"
	 *
	 */
	public java.lang.String getNihGuideAddr() {
		return this.nihGuideAddr;
	}

	public void setNihGuideAddr(java.lang.String nihGuideAddr) {
		this.nihGuideAddr = nihGuideAddr;
	}


    public String toString() {
        return new ToStringBuilder(this)
            .append("applId", getApplId())
            .append("fullGrantNum", getFullGrantNum())
            .append("rfaPaNumber", getRfaPaNumber())
            .append("councilMeetingDate", getCouncilMeetingDate())
            .append("firstName", getFirstName())
            .append("miName", getMiName())
            .append("lastName", getLastName())
            .append("lastNameUpper", getLastNameUpper())
            .append("applTypeCode", getApplTypeCode())
            .append("adminPhsOrgCode", getAdminPhsOrgCode())
            .append("activityCode", getActivityCode())
            .append("serialNum", getSerialNum())
            .append("supportYear", getSupportYear())
            .append("suffixCode", getSuffixCode())
            .append("applStatusCode", getApplStatusCode())
            .append("applStatusGroupCode", getApplStatusGroupCode())
            .append("budgetStartDate", getBudgetStartDate())
            .append("budgetEndDate", getBudgetEndDate())
            .append("fy", getFy())
            .append("ipf", getIpf())
            .append("orgName", getOrgName())
            .append("institutionCity", getInstitutionCity())
            .append("institutionState", getInstitutionState())
            .append("projectTitle", getProjectTitle())
            .append("legacySourceFile", getLegacySourceFile())
            .append("cayCode", getCayCode())
            .append("dualCayCode", getDualCayCode())
            .append("pocNpnId", getPocNpnId())
            .append("pocLastName", getPocLastName())
            .append("pocFirstName", getPocFirstName())
            .append("pocMiName", getPocMiName())
            .append("pocFullName", getPocFullName())
            .append("dualPocNpnId", getDualPocNpnId())
            .append("dualPocLastName", getDualPocLastName())
            .append("dualPocFirstName", getDualPocFirstName())
            .append("dualPocMiName", getDualPocMiName())
            .append("dualPocFullName", getDualPocFullName())
            .append("araStatusCode", getAraStatusCode())
            .append("araId", getAraId())
            .append("araMatchFlag", getAraMatchFlag())
            .append("currentFutureBoardFlag", getCurrentFutureBoardFlag())
            .append("currentReferralActivityCode", getCurrentReferralActivityCode())
            .append("currentReferralActivityDate", getCurrentReferralActivityDate())
            .append("withdrawnFlag", getWithdrawnFlag())
            .append("currentApsComments", getCurrentApsComments())
            .append("nihGuideAddr", getNihGuideAddr())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof NciPdQueryVw) ) return false;
        NciPdQueryVw castOther = (NciPdQueryVw) other;
        return new EqualsBuilder()
            .append(this.getApplId(), castOther.getApplId())
            .append(this.getFullGrantNum(), castOther.getFullGrantNum())
            .append(this.getRfaPaNumber(), castOther.getRfaPaNumber())
            .append(this.getCouncilMeetingDate(), castOther.getCouncilMeetingDate())
            .append(this.getFirstName(), castOther.getFirstName())
            .append(this.getMiName(), castOther.getMiName())
            .append(this.getLastName(), castOther.getLastName())
            .append(this.getLastNameUpper(), castOther.getLastNameUpper())
            .append(this.getApplTypeCode(), castOther.getApplTypeCode())
            .append(this.getAdminPhsOrgCode(), castOther.getAdminPhsOrgCode())
            .append(this.getActivityCode(), castOther.getActivityCode())
            .append(this.getSerialNum(), castOther.getSerialNum())
            .append(this.getSupportYear(), castOther.getSupportYear())
            .append(this.getSuffixCode(), castOther.getSuffixCode())
            .append(this.getApplStatusCode(), castOther.getApplStatusCode())
            .append(this.getApplStatusGroupCode(), castOther.getApplStatusGroupCode())
            .append(this.getBudgetStartDate(), castOther.getBudgetStartDate())
            .append(this.getBudgetEndDate(), castOther.getBudgetEndDate())
            .append(this.getFy(), castOther.getFy())
            .append(this.getIpf(), castOther.getIpf())
            .append(this.getOrgName(), castOther.getOrgName())
            .append(this.getInstitutionCity(), castOther.getInstitutionCity())
            .append(this.getInstitutionState(), castOther.getInstitutionState())
            .append(this.getProjectTitle(), castOther.getProjectTitle())
            .append(this.getLegacySourceFile(), castOther.getLegacySourceFile())
            .append(this.getCayCode(), castOther.getCayCode())
            .append(this.getDualCayCode(), castOther.getDualCayCode())
            .append(this.getPocNpnId(), castOther.getPocNpnId())
            .append(this.getPocLastName(), castOther.getPocLastName())
            .append(this.getPocFirstName(), castOther.getPocFirstName())
            .append(this.getPocMiName(), castOther.getPocMiName())
            .append(this.getPocFullName(), castOther.getPocFullName())
            .append(this.getDualPocNpnId(), castOther.getDualPocNpnId())
            .append(this.getDualPocLastName(), castOther.getDualPocLastName())
            .append(this.getDualPocFirstName(), castOther.getDualPocFirstName())
            .append(this.getDualPocMiName(), castOther.getDualPocMiName())
            .append(this.getDualPocFullName(), castOther.getDualPocFullName())
            .append(this.getAraStatusCode(), castOther.getAraStatusCode())
            .append(this.getAraId(), castOther.getAraId())
            .append(this.getAraMatchFlag(), castOther.getAraMatchFlag())
            .append(this.getCurrentFutureBoardFlag(), castOther.getCurrentFutureBoardFlag())
            .append(this.getCurrentReferralActivityCode(), castOther.getCurrentReferralActivityCode())
            .append(this.getCurrentReferralActivityDate(), castOther.getCurrentReferralActivityDate())
            .append(this.getWithdrawnFlag(), castOther.getWithdrawnFlag())
            .append(this.getCurrentApsComments(), castOther.getCurrentApsComments())
            .append(this.getReferralComments(), castOther.getReferralComments())
            .append(this.getNihGuideAddr(), castOther.getNihGuideAddr())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getApplId())
            .append(getFullGrantNum())
            .append(getRfaPaNumber())
            .append(getCouncilMeetingDate())
            .append(getFirstName())
            .append(getMiName())
            .append(getLastName())
            .append(getLastNameUpper())
            .append(getApplTypeCode())
            .append(getAdminPhsOrgCode())
            .append(getActivityCode())
            .append(getSerialNum())
            .append(getSupportYear())
            .append(getSuffixCode())
            .append(getApplStatusCode())
            .append(getApplStatusGroupCode())
            .append(getBudgetStartDate())
            .append(getBudgetEndDate())
            .append(getFy())
            .append(getIpf())
            .append(getOrgName())
            .append(getInstitutionCity())
            .append(getInstitutionState())
            .append(getProjectTitle())
            .append(getLegacySourceFile())
            .append(getCayCode())
            .append(getDualCayCode())
            .append(getPocNpnId())
            .append(getPocLastName())
            .append(getPocFirstName())
            .append(getPocMiName())
            .append(getPocFullName())
            .append(getDualPocNpnId())
            .append(getDualPocLastName())
            .append(getDualPocFirstName())
            .append(getDualPocMiName())
            .append(getDualPocFullName())
            .append(getAraStatusCode())
            .append(getAraId())
            .append(getAraMatchFlag())
            .append(getCurrentFutureBoardFlag())
            .append(getCurrentReferralActivityCode())
            .append(getCurrentReferralActivityDate())
            .append(getWithdrawnFlag())
            .append(getCurrentApsComments())
            .append(getNihGuideAddr())
            .toHashCode();
    }

}
