package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *        @hibernate.class
 *         table="NCI_PD_QUERY_VW"
 *
*/
public class NciPdQueryVw implements Serializable {

    /** identifier field */
    private Long applId;

    /** identifier field */
    private String fullGrantNum;

    /** identifier field */
    private String rfaPaNumber;

    /** identifier field */
    private String councilMeetingDate;

    /** identifier field */
    private String firstName;

    /** identifier field */
    private String miName;

    /** identifier field */
    private String lastName;

    /** identifier field */
    private java.math.BigDecimal irgPercentileNum;

    /** identifier field */
    private java.lang.Integer priorityScoreNum;

    /** identifier field */
    private String irgCode;

    /** identifier field */
    private String irgFlexCode;

    /** identifier field */
    private String groupCode;

    /** identifier field */
    private String groupExtCode;

    /** identifier field */
    private String sraDesignatorCode;

    /** identifier field */
    private String sraFlexCode;

    /** identifier field */
    private String specialConsiderCode;

    /** identifier field */
    private String applTypeCode;

    /** identifier field */
    private String adminPhsOrgCode;

    /** identifier field */
    private String activityCode;

    /** identifier field */
    private java.lang.Integer serialNum;

    /** identifier field */
    private java.lang.Integer supportYear;

    /** identifier field */
    private String suffixCode;

    /** identifier field */
    private String applStatusCode;

    /** identifier field */
    private String applStatusGroupCode;

    /** identifier field */
    private String formerNum;

    /** identifier field */
    private java.util.Date projectPeriodStartDate;

    /** identifier field */
    private java.util.Date projectPeriodEndDate;

    /** identifier field */
    private java.util.Date budgetStartDate;

    /** identifier field */
    private java.util.Date budgetEndDate;

    /** identifier field */
    private java.lang.Integer fy;

    /** identifier field */
    private java.lang.Long ipf;

    /** identifier field */
    private String orgName;

    /** identifier field */
    private String institutionCity;

    /** identifier field */
    private String institutionState;

    /** identifier field */
    private String line1Addr;

    /** identifier field */
    private String line2Addr;

    /** identifier field */
    private String line3Addr;

    /** identifier field */
    private String line4Addr;

    /** identifier field */
    private String line5Addr;

    /** identifier field */
    private String projectTitle;

    /** identifier field */
    private String legacySourceFile;

    /** identifier field */
    private String cayCode;

    /** identifier field */
    private String dualCayCode;

    /** identifier field */
    private java.lang.Long pocNpnId;

    /** identifier field */
    private String pocLastName;

    /** identifier field */
    private String pocFirstName;

    /** identifier field */
    private String pocMiName;

    /** identifier field */
    private String pocFullName;

    /** identifier field */
    private java.lang.Long dualPocNpnId;

    /** identifier field */
    private String dualPocLastName;

    /** identifier field */
    private String dualPocFirstName;

    /** identifier field */
    private String dualPocMiName;

    /** identifier field */
    private String dualPocFullName;

    /** identifier field */
    private String roleUsageCode;

    /** identifier field */
    private java.lang.Long pdNpeId;

    /** identifier field */
    private java.lang.Long pdNpnId;

    /** identifier field */
    private String pdLastName;

    /** identifier field */
    private String pdFirstName;

    /** identifier field */
    private String pdMiName;

    /** identifier field */
    private String pdFullName;

    /** identifier field */
    private java.util.Date pdStartDate;

    /** identifier field */
    private java.lang.Long pdNonId;

    /** identifier field */
    private String pdOrgName;

    /** identifier field */
    private String hncCode;

    /** identifier field */
    private String araStatusCode;

    /** identifier field */
    private String araMatchFlag;

    /** identifier field */
    private String pdTransferInitialCode;

    /** identifier field */
    private String currentFutureBoardFlag;

    /** identifier field */
    private String currentReferralActivityCode;

    /** identifier field */
    private java.util.Date currentReferralActivityDate;

    /** identifier field */
    private String withdrawnFlag;

    /** full constructor */
    public NciPdQueryVw(Long applId, String fullGrantNum, String rfaPaNumber, String councilMeetingDate, String firstName, String miName, String lastName, java.math.BigDecimal irgPercentileNum, java.lang.Integer priorityScoreNum, String irgCode, String irgFlexCode, String groupCode, String groupExtCode, String sraDesignatorCode, String sraFlexCode, String specialConsiderCode, String applTypeCode, String adminPhsOrgCode, String activityCode, java.lang.Integer serialNum, java.lang.Integer supportYear, String suffixCode, String applStatusCode, String applStatusGroupCode, String formerNum, java.util.Date projectPeriodStartDate, java.util.Date projectPeriodEndDate, java.util.Date budgetStartDate, java.util.Date budgetEndDate, java.lang.Integer fy, java.lang.Long ipf, String orgName, String institutionCity, String institutionState, String line1Addr, String line2Addr, String line3Addr, String line4Addr, String line5Addr, String projectTitle, String legacySourceFile, String cayCode, String dualCayCode, java.lang.Long pocNpnId, String pocLastName, String pocFirstName, String pocMiName, String pocFullName, java.lang.Long dualPocNpnId, String dualPocLastName, String dualPocFirstName, String dualPocMiName, String dualPocFullName, String roleUsageCode, java.lang.Long pdNpeId, java.lang.Long pdNpnId, String pdLastName, String pdFirstName, String pdMiName, String pdFullName, java.util.Date pdStartDate, java.lang.Long pdNonId, String pdOrgName, String hncCode, String araStatusCode, String araMatchFlag, String pdTransferInitialCode, String currentFutureBoardFlag, String currentReferralActivityCode, java.util.Date currentReferralActivityDate, String withdrawnFlag) {
        this.applId = applId;
        this.fullGrantNum = fullGrantNum;
        this.rfaPaNumber = rfaPaNumber;
        this.councilMeetingDate = councilMeetingDate;
        this.firstName = firstName;
        this.miName = miName;
        this.lastName = lastName;
        this.irgPercentileNum = irgPercentileNum;
        this.priorityScoreNum = priorityScoreNum;
        this.irgCode = irgCode;
        this.irgFlexCode = irgFlexCode;
        this.groupCode = groupCode;
        this.groupExtCode = groupExtCode;
        this.sraDesignatorCode = sraDesignatorCode;
        this.sraFlexCode = sraFlexCode;
        this.specialConsiderCode = specialConsiderCode;
        this.applTypeCode = applTypeCode;
        this.adminPhsOrgCode = adminPhsOrgCode;
        this.activityCode = activityCode;
        this.serialNum = serialNum;
        this.supportYear = supportYear;
        this.suffixCode = suffixCode;
        this.applStatusCode = applStatusCode;
        this.applStatusGroupCode = applStatusGroupCode;
        this.formerNum = formerNum;
        this.projectPeriodStartDate = projectPeriodStartDate;
        this.projectPeriodEndDate = projectPeriodEndDate;
        this.budgetStartDate = budgetStartDate;
        this.budgetEndDate = budgetEndDate;
        this.fy = fy;
        this.ipf = ipf;
        this.orgName = orgName;
        this.institutionCity = institutionCity;
        this.institutionState = institutionState;
        this.line1Addr = line1Addr;
        this.line2Addr = line2Addr;
        this.line3Addr = line3Addr;
        this.line4Addr = line4Addr;
        this.line5Addr = line5Addr;
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
        this.roleUsageCode = roleUsageCode;
        this.pdNpeId = pdNpeId;
        this.pdNpnId = pdNpnId;
        this.pdLastName = pdLastName;
        this.pdFirstName = pdFirstName;
        this.pdMiName = pdMiName;
        this.pdFullName = pdFullName;
        this.pdStartDate = pdStartDate;
        this.pdNonId = pdNonId;
        this.pdOrgName = pdOrgName;
        this.hncCode = hncCode;
        this.araStatusCode = araStatusCode;
        this.araMatchFlag = araMatchFlag;
        this.pdTransferInitialCode = pdTransferInitialCode;
        this.currentFutureBoardFlag = currentFutureBoardFlag;
        this.currentReferralActivityCode = currentReferralActivityCode;
        this.currentReferralActivityDate = currentReferralActivityDate;
        this.withdrawnFlag = withdrawnFlag;
    }

    /** default constructor */
    public NciPdQueryVw() {
    }

    /**
     *                @hibernate.property
     *                 column="APPL_ID"
     *
     */
    public Long getApplId() {
        return this.applId;
    }

    public void setApplId(Long applId) {
        this.applId = applId;
    }

    /**
     *                @hibernate.property
     *                 column="FULL_GRANT_NUM"
     *
     */
    public String getFullGrantNum() {
        return this.fullGrantNum;
    }

    public void setFullGrantNum(String fullGrantNum) {
        this.fullGrantNum = fullGrantNum;
    }

    /**
     *                @hibernate.property
     *                 column="RFA_PA_NUMBER"
     *
     */
    public String getRfaPaNumber() {
        return this.rfaPaNumber;
    }

    public void setRfaPaNumber(String rfaPaNumber) {
        this.rfaPaNumber = rfaPaNumber;
    }

    /**
     *                @hibernate.property
     *                 column="COUNCIL_MEETING_DATE"
     *
     */
    public String getCouncilMeetingDate() {
        return this.councilMeetingDate;
    }

    public void setCouncilMeetingDate(String councilMeetingDate) {
        this.councilMeetingDate = councilMeetingDate;
    }

    /**
     *                @hibernate.property
     *                 column="FIRST_NAME"
     *
     */
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *                @hibernate.property
     *                 column="MI_NAME"
     *
     */
    public String getMiName() {
        return this.miName;
    }

    public void setMiName(String miName) {
        this.miName = miName;
    }

    /**
     *                @hibernate.property
     *                 column="LAST_NAME"
     *
     */
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *                @hibernate.property
     *                 column="IRG_PERCENTILE_NUM"
     *
     */
    public java.math.BigDecimal getIrgPercentileNum() {
        return this.irgPercentileNum;
    }

    public void setIrgPercentileNum(java.math.BigDecimal irgPercentileNum) {
        this.irgPercentileNum = irgPercentileNum;
    }

    /**
     *                @hibernate.property
     *                 column="PRIORITY_SCORE_NUM"
     *
     */
    public java.lang.Integer getPriorityScoreNum() {
        return this.priorityScoreNum;
    }

    public void setPriorityScoreNum(java.lang.Integer priorityScoreNum) {
        this.priorityScoreNum = priorityScoreNum;
    }

    /**
     *                @hibernate.property
     *                 column="IRG_CODE"
     *
     */
    public String getIrgCode() {
        return this.irgCode;
    }

    public void setIrgCode(String irgCode) {
        this.irgCode = irgCode;
    }

    /**
     *                @hibernate.property
     *                 column="IRG_FLEX_CODE"
     *
     */
    public String getIrgFlexCode() {
        return this.irgFlexCode;
    }

    public void setIrgFlexCode(String irgFlexCode) {
        this.irgFlexCode = irgFlexCode;
    }

    /**
     *                @hibernate.property
     *                 column="GROUP_CODE"
     *
     */
    public String getGroupCode() {
        return this.groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    /**
     *                @hibernate.property
     *                 column="GROUP_EXT_CODE"
     *
     */
    public String getGroupExtCode() {
        return this.groupExtCode;
    }

    public void setGroupExtCode(String groupExtCode) {
        this.groupExtCode = groupExtCode;
    }

    /**
     *                @hibernate.property
     *                 column="SRA_DESIGNATOR_CODE"
     *
     */
    public String getSraDesignatorCode() {
        return this.sraDesignatorCode;
    }

    public void setSraDesignatorCode(String sraDesignatorCode) {
        this.sraDesignatorCode = sraDesignatorCode;
    }

    /**
     *                @hibernate.property
     *                 column="SRA_FLEX_CODE"
     *
     */
    public String getSraFlexCode() {
        return this.sraFlexCode;
    }

    public void setSraFlexCode(String sraFlexCode) {
        this.sraFlexCode = sraFlexCode;
    }

    /**
     *                @hibernate.property
     *                 column="SPECIAL_CONSIDER_CODE"
     *
     */
    public String getSpecialConsiderCode() {
        return this.specialConsiderCode;
    }

    public void setSpecialConsiderCode(String specialConsiderCode) {
        this.specialConsiderCode = specialConsiderCode;
    }

    /**
     *                @hibernate.property
     *                 column="APPL_TYPE_CODE"
     *
     */
    public String getApplTypeCode() {
        return this.applTypeCode;
    }

    public void setApplTypeCode(String applTypeCode) {
        this.applTypeCode = applTypeCode;
    }

    /**
     *                @hibernate.property
     *                 column="ADMIN_PHS_ORG_CODE"
     *
     */
    public String getAdminPhsOrgCode() {
        return this.adminPhsOrgCode;
    }

    public void setAdminPhsOrgCode(String adminPhsOrgCode) {
        this.adminPhsOrgCode = adminPhsOrgCode;
    }

    /**
     *                @hibernate.property
     *                 column="ACTIVITY_CODE"
     *
     */
    public String getActivityCode() {
        return this.activityCode;
    }

    public void setActivityCode(String activityCode) {
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
    public String getSuffixCode() {
        return this.suffixCode;
    }

    public void setSuffixCode(String suffixCode) {
        this.suffixCode = suffixCode;
    }

    /**
     *                @hibernate.property
     *                 column="APPL_STATUS_CODE"
     *
     */
    public String getApplStatusCode() {
        return this.applStatusCode;
    }

    public void setApplStatusCode(String applStatusCode) {
        this.applStatusCode = applStatusCode;
    }

    /**
     *                @hibernate.property
     *                 column="APPL_STATUS_GROUP_CODE"
     *
     */
    public String getApplStatusGroupCode() {
        return this.applStatusGroupCode;
    }

    public void setApplStatusGroupCode(String applStatusGroupCode) {
        this.applStatusGroupCode = applStatusGroupCode;
    }

    /**
     *                @hibernate.property
     *                 column="FORMER_NUM"
     *
     */
    public String getFormerNum() {
        return this.formerNum;
    }

    public void setFormerNum(String formerNum) {
        this.formerNum = formerNum;
    }

    /**
     *                @hibernate.property
     *                 column="PROJECT_PERIOD_START_DATE"
     *
     */
    public java.util.Date getProjectPeriodStartDate() {
        return this.projectPeriodStartDate;
    }

    public void setProjectPeriodStartDate(java.util.Date projectPeriodStartDate) {
        this.projectPeriodStartDate = projectPeriodStartDate;
    }

    /**
     *                @hibernate.property
     *                 column="PROJECT_PERIOD_END_DATE"
     *
     */
    public java.util.Date getProjectPeriodEndDate() {
        return this.projectPeriodEndDate;
    }

    public void setProjectPeriodEndDate(java.util.Date projectPeriodEndDate) {
        this.projectPeriodEndDate = projectPeriodEndDate;
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
    public String getOrgName() {
        return this.orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     *                @hibernate.property
     *                 column="INSTITUTION_CITY"
     *
     */
    public String getInstitutionCity() {
        return this.institutionCity;
    }

    public void setInstitutionCity(String institutionCity) {
        this.institutionCity = institutionCity;
    }

    /**
     *                @hibernate.property
     *                 column="INSTITUTION_STATE"
     *
     */
    public String getInstitutionState() {
        return this.institutionState;
    }

    public void setInstitutionState(String institutionState) {
        this.institutionState = institutionState;
    }

    /**
     *                @hibernate.property
     *                 column="LINE_1_ADDR"
     *
     */
    public String getLine1Addr() {
        return this.line1Addr;
    }

    public void setLine1Addr(String line1Addr) {
        this.line1Addr = line1Addr;
    }

    /**
     *                @hibernate.property
     *                 column="LINE_2_ADDR"
     *
     */
    public String getLine2Addr() {
        return this.line2Addr;
    }

    public void setLine2Addr(String line2Addr) {
        this.line2Addr = line2Addr;
    }

    /**
     *                @hibernate.property
     *                 column="LINE_3_ADDR"
     *
     */
    public String getLine3Addr() {
        return this.line3Addr;
    }

    public void setLine3Addr(String line3Addr) {
        this.line3Addr = line3Addr;
    }

    /**
     *                @hibernate.property
     *                 column="LINE_4_ADDR"
     *
     */
    public String getLine4Addr() {
        return this.line4Addr;
    }

    public void setLine4Addr(String line4Addr) {
        this.line4Addr = line4Addr;
    }

    /**
     *                @hibernate.property
     *                 column="LINE_5_ADDR"
     *
     */
    public String getLine5Addr() {
        return this.line5Addr;
    }

    public void setLine5Addr(String line5Addr) {
        this.line5Addr = line5Addr;
    }

    /**
     *                @hibernate.property
     *                 column="PROJECT_TITLE"
     *
     */
    public String getProjectTitle() {
        return this.projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    /**
     *                @hibernate.property
     *                 column="LEGACY_SOURCE_FILE"
     *
     */
    public String getLegacySourceFile() {
        return this.legacySourceFile;
    }

    public void setLegacySourceFile(String legacySourceFile) {
        this.legacySourceFile = legacySourceFile;
    }

    /**
     *                @hibernate.property
     *                 column="CAY_CODE"
     *
     */
    public String getCayCode() {
        return this.cayCode;
    }

    public void setCayCode(String cayCode) {
        this.cayCode = cayCode;
    }

    /**
     *                @hibernate.property
     *                 column="DUAL_CAY_CODE"
     *
     */
    public String getDualCayCode() {
        return this.dualCayCode;
    }

    public void setDualCayCode(String dualCayCode) {
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
    public String getPocLastName() {
        return this.pocLastName;
    }

    public void setPocLastName(String pocLastName) {
        this.pocLastName = pocLastName;
    }

    /**
     *                @hibernate.property
     *                 column="POC_FIRST_NAME"
     *
     */
    public String getPocFirstName() {
        return this.pocFirstName;
    }

    public void setPocFirstName(String pocFirstName) {
        this.pocFirstName = pocFirstName;
    }

    /**
     *                @hibernate.property
     *                 column="POC_MI_NAME"
     *
     */
    public String getPocMiName() {
        return this.pocMiName;
    }

    public void setPocMiName(String pocMiName) {
        this.pocMiName = pocMiName;
    }

    /**
     *                @hibernate.property
     *                 column="POC_FULL_NAME"
     *
     */
    public String getPocFullName() {
        return this.pocFullName;
    }

    public void setPocFullName(String pocFullName) {
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
    public String getDualPocLastName() {
        return this.dualPocLastName;
    }

    public void setDualPocLastName(String dualPocLastName) {
        this.dualPocLastName = dualPocLastName;
    }

    /**
     *                @hibernate.property
     *                 column="DUAL_POC_FIRST_NAME"
     *
     */
    public String getDualPocFirstName() {
        return this.dualPocFirstName;
    }

    public void setDualPocFirstName(String dualPocFirstName) {
        this.dualPocFirstName = dualPocFirstName;
    }

    /**
     *                @hibernate.property
     *                 column="DUAL_POC_MI_NAME"
     *
     */
    public String getDualPocMiName() {
        return this.dualPocMiName;
    }

    public void setDualPocMiName(String dualPocMiName) {
        this.dualPocMiName = dualPocMiName;
    }

    /**
     *                @hibernate.property
     *                 column="DUAL_POC_FULL_NAME"
     *
     */
    public String getDualPocFullName() {
        return this.dualPocFullName;
    }

    public void setDualPocFullName(String dualPocFullName) {
        this.dualPocFullName = dualPocFullName;
    }

    /**
     *                @hibernate.property
     *                 column="ROLE_USAGE_CODE"
     *
     */
    public String getRoleUsageCode() {
        return this.roleUsageCode;
    }

    public void setRoleUsageCode(String roleUsageCode) {
        this.roleUsageCode = roleUsageCode;
    }

    /**
     *                @hibernate.property
     *                 column="PD_NPE_ID"
     *
     */
    public java.lang.Long getPdNpeId() {
        return this.pdNpeId;
    }

    public void setPdNpeId(java.lang.Long pdNpeId) {
        this.pdNpeId = pdNpeId;
    }

    /**
     *                @hibernate.property
     *                 column="PD_NPN_ID"
     *
     */
    public java.lang.Long getPdNpnId() {
        return this.pdNpnId;
    }

    public void setPdNpnId(java.lang.Long pdNpnId) {
        this.pdNpnId = pdNpnId;
    }

    /**
     *                @hibernate.property
     *                 column="PD_LAST_NAME"
     *
     */
    public String getPdLastName() {
        return this.pdLastName;
    }

    public void setPdLastName(String pdLastName) {
        this.pdLastName = pdLastName;
    }

    /**
     *                @hibernate.property
     *                 column="PD_FIRST_NAME"
     *
     */
    public String getPdFirstName() {
        return this.pdFirstName;
    }

    public void setPdFirstName(String pdFirstName) {
        this.pdFirstName = pdFirstName;
    }

    /**
     *                @hibernate.property
     *                 column="PD_MI_NAME"
     *
     */
    public String getPdMiName() {
        return this.pdMiName;
    }

    public void setPdMiName(String pdMiName) {
        this.pdMiName = pdMiName;
    }

    /**
     *                @hibernate.property
     *                 column="PD_FULL_NAME"
     *
     */
    public String getPdFullName() {
        return this.pdFullName;
    }

    public void setPdFullName(String pdFullName) {
        this.pdFullName = pdFullName;
    }

    /**
     *                @hibernate.property
     *                 column="PD_START_DATE"
     *
     */
    public java.util.Date getPdStartDate() {
        return this.pdStartDate;
    }

    public void setPdStartDate(java.util.Date pdStartDate) {
        this.pdStartDate = pdStartDate;
    }

    /**
     *                @hibernate.property
     *                 column="PD_NON_ID"
     *
     */
    public java.lang.Long getPdNonId() {
        return this.pdNonId;
    }

    public void setPdNonId(java.lang.Long pdNonId) {
        this.pdNonId = pdNonId;
    }

    /**
     *                @hibernate.property
     *                 column="PD_ORG_NAME"
     *
     */
    public String getPdOrgName() {
        return this.pdOrgName;
    }

    public void setPdOrgName(String pdOrgName) {
        this.pdOrgName = pdOrgName;
    }

    /**
     *                @hibernate.property
     *                 column="HNC_CODE"
     *
     */
    public String getHncCode() {
        return this.hncCode;
    }

    public void setHncCode(String hncCode) {
        this.hncCode = hncCode;
    }

    /**
     *                @hibernate.property
     *                 column="ARA_STATUS_CODE"
     *
     */
    public String getAraStatusCode() {
        return this.araStatusCode;
    }

    public void setAraStatusCode(String araStatusCode) {
        this.araStatusCode = araStatusCode;
    }

    /**
     *                @hibernate.property
     *                 column="ARA_MATCH_FLAG"
     *
     */
    public String getAraMatchFlag() {
        return this.araMatchFlag;
    }

    public void setAraMatchFlag(String araMatchFlag) {
        this.araMatchFlag = araMatchFlag;
    }

    /**
     *                @hibernate.property
     *                 column="PD_TRANSFER_INITIAL_CODE"
     *
     */
    public String getPdTransferInitialCode() {
        return this.pdTransferInitialCode;
    }

    public void setPdTransferInitialCode(String pdTransferInitialCode) {
        this.pdTransferInitialCode = pdTransferInitialCode;
    }

    /**
     *                @hibernate.property
     *                 column="CURRENT_FUTURE_BOARD_FLAG"
     *
     */
    public String getCurrentFutureBoardFlag() {
        return this.currentFutureBoardFlag;
    }

    public void setCurrentFutureBoardFlag(String currentFutureBoardFlag) {
        this.currentFutureBoardFlag = currentFutureBoardFlag;
    }

    /**
     *                @hibernate.property
     *                 column="CURRENT_REFERRAL_ACTIVITY_CODE"
     *
     */
    public String getCurrentReferralActivityCode() {
        return this.currentReferralActivityCode;
    }

    public void setCurrentReferralActivityCode(String currentReferralActivityCode) {
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
    public String getWithdrawnFlag() {
        return this.withdrawnFlag;
    }

    public void setWithdrawnFlag(String withdrawnFlag) {
        this.withdrawnFlag = withdrawnFlag;
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
            .append("irgPercentileNum", getIrgPercentileNum())
            .append("priorityScoreNum", getPriorityScoreNum())
            .append("irgCode", getIrgCode())
            .append("irgFlexCode", getIrgFlexCode())
            .append("groupCode", getGroupCode())
            .append("groupExtCode", getGroupExtCode())
            .append("sraDesignatorCode", getSraDesignatorCode())
            .append("sraFlexCode", getSraFlexCode())
            .append("specialConsiderCode", getSpecialConsiderCode())
            .append("applTypeCode", getApplTypeCode())
            .append("adminPhsOrgCode", getAdminPhsOrgCode())
            .append("activityCode", getActivityCode())
            .append("serialNum", getSerialNum())
            .append("supportYear", getSupportYear())
            .append("suffixCode", getSuffixCode())
            .append("applStatusCode", getApplStatusCode())
            .append("applStatusGroupCode", getApplStatusGroupCode())
            .append("formerNum", getFormerNum())
            .append("projectPeriodStartDate", getProjectPeriodStartDate())
            .append("projectPeriodEndDate", getProjectPeriodEndDate())
            .append("budgetStartDate", getBudgetStartDate())
            .append("budgetEndDate", getBudgetEndDate())
            .append("fy", getFy())
            .append("ipf", getIpf())
            .append("orgName", getOrgName())
            .append("institutionCity", getInstitutionCity())
            .append("institutionState", getInstitutionState())
            .append("line1Addr", getLine1Addr())
            .append("line2Addr", getLine2Addr())
            .append("line3Addr", getLine3Addr())
            .append("line4Addr", getLine4Addr())
            .append("line5Addr", getLine5Addr())
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
            .append("roleUsageCode", getRoleUsageCode())
            .append("pdNpeId", getPdNpeId())
            .append("pdNpnId", getPdNpnId())
            .append("pdLastName", getPdLastName())
            .append("pdFirstName", getPdFirstName())
            .append("pdMiName", getPdMiName())
            .append("pdFullName", getPdFullName())
            .append("pdStartDate", getPdStartDate())
            .append("pdNonId", getPdNonId())
            .append("pdOrgName", getPdOrgName())
            .append("hncCode", getHncCode())
            .append("araStatusCode", getAraStatusCode())
            .append("araMatchFlag", getAraMatchFlag())
            .append("pdTransferInitialCode", getPdTransferInitialCode())
            .append("currentFutureBoardFlag", getCurrentFutureBoardFlag())
            .append("currentReferralActivityCode", getCurrentReferralActivityCode())
            .append("currentReferralActivityDate", getCurrentReferralActivityDate())
            .append("withdrawnFlag", getWithdrawnFlag())
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
            .append(this.getIrgPercentileNum(), castOther.getIrgPercentileNum())
            .append(this.getPriorityScoreNum(), castOther.getPriorityScoreNum())
            .append(this.getIrgCode(), castOther.getIrgCode())
            .append(this.getIrgFlexCode(), castOther.getIrgFlexCode())
            .append(this.getGroupCode(), castOther.getGroupCode())
            .append(this.getGroupExtCode(), castOther.getGroupExtCode())
            .append(this.getSraDesignatorCode(), castOther.getSraDesignatorCode())
            .append(this.getSraFlexCode(), castOther.getSraFlexCode())
            .append(this.getSpecialConsiderCode(), castOther.getSpecialConsiderCode())
            .append(this.getApplTypeCode(), castOther.getApplTypeCode())
            .append(this.getAdminPhsOrgCode(), castOther.getAdminPhsOrgCode())
            .append(this.getActivityCode(), castOther.getActivityCode())
            .append(this.getSerialNum(), castOther.getSerialNum())
            .append(this.getSupportYear(), castOther.getSupportYear())
            .append(this.getSuffixCode(), castOther.getSuffixCode())
            .append(this.getApplStatusCode(), castOther.getApplStatusCode())
            .append(this.getApplStatusGroupCode(), castOther.getApplStatusGroupCode())
            .append(this.getFormerNum(), castOther.getFormerNum())
            .append(this.getProjectPeriodStartDate(), castOther.getProjectPeriodStartDate())
            .append(this.getProjectPeriodEndDate(), castOther.getProjectPeriodEndDate())
            .append(this.getBudgetStartDate(), castOther.getBudgetStartDate())
            .append(this.getBudgetEndDate(), castOther.getBudgetEndDate())
            .append(this.getFy(), castOther.getFy())
            .append(this.getIpf(), castOther.getIpf())
            .append(this.getOrgName(), castOther.getOrgName())
            .append(this.getInstitutionCity(), castOther.getInstitutionCity())
            .append(this.getInstitutionState(), castOther.getInstitutionState())
            .append(this.getLine1Addr(), castOther.getLine1Addr())
            .append(this.getLine2Addr(), castOther.getLine2Addr())
            .append(this.getLine3Addr(), castOther.getLine3Addr())
            .append(this.getLine4Addr(), castOther.getLine4Addr())
            .append(this.getLine5Addr(), castOther.getLine5Addr())
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
            .append(this.getRoleUsageCode(), castOther.getRoleUsageCode())
            .append(this.getPdNpeId(), castOther.getPdNpeId())
            .append(this.getPdNpnId(), castOther.getPdNpnId())
            .append(this.getPdLastName(), castOther.getPdLastName())
            .append(this.getPdFirstName(), castOther.getPdFirstName())
            .append(this.getPdMiName(), castOther.getPdMiName())
            .append(this.getPdFullName(), castOther.getPdFullName())
            .append(this.getPdStartDate(), castOther.getPdStartDate())
            .append(this.getPdNonId(), castOther.getPdNonId())
            .append(this.getPdOrgName(), castOther.getPdOrgName())
            .append(this.getHncCode(), castOther.getHncCode())
            .append(this.getAraStatusCode(), castOther.getAraStatusCode())
            .append(this.getAraMatchFlag(), castOther.getAraMatchFlag())
            .append(this.getPdTransferInitialCode(), castOther.getPdTransferInitialCode())
            .append(this.getCurrentFutureBoardFlag(), castOther.getCurrentFutureBoardFlag())
            .append(this.getCurrentReferralActivityCode(), castOther.getCurrentReferralActivityCode())
            .append(this.getCurrentReferralActivityDate(), castOther.getCurrentReferralActivityDate())
            .append(this.getWithdrawnFlag(), castOther.getWithdrawnFlag())
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
            .append(getIrgPercentileNum())
            .append(getPriorityScoreNum())
            .append(getIrgCode())
            .append(getIrgFlexCode())
            .append(getGroupCode())
            .append(getGroupExtCode())
            .append(getSraDesignatorCode())
            .append(getSraFlexCode())
            .append(getSpecialConsiderCode())
            .append(getApplTypeCode())
            .append(getAdminPhsOrgCode())
            .append(getActivityCode())
            .append(getSerialNum())
            .append(getSupportYear())
            .append(getSuffixCode())
            .append(getApplStatusCode())
            .append(getApplStatusGroupCode())
            .append(getFormerNum())
            .append(getProjectPeriodStartDate())
            .append(getProjectPeriodEndDate())
            .append(getBudgetStartDate())
            .append(getBudgetEndDate())
            .append(getFy())
            .append(getIpf())
            .append(getOrgName())
            .append(getInstitutionCity())
            .append(getInstitutionState())
            .append(getLine1Addr())
            .append(getLine2Addr())
            .append(getLine3Addr())
            .append(getLine4Addr())
            .append(getLine5Addr())
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
            .append(getRoleUsageCode())
            .append(getPdNpeId())
            .append(getPdNpnId())
            .append(getPdLastName())
            .append(getPdFirstName())
            .append(getPdMiName())
            .append(getPdFullName())
            .append(getPdStartDate())
            .append(getPdNonId())
            .append(getPdOrgName())
            .append(getHncCode())
            .append(getAraStatusCode())
            .append(getAraMatchFlag())
            .append(getPdTransferInitialCode())
            .append(getCurrentFutureBoardFlag())
            .append(getCurrentReferralActivityCode())
            .append(getCurrentReferralActivityDate())
            .append(getWithdrawnFlag())
            .toHashCode();
    }

}
