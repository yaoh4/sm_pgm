package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
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
    private long applId;

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
    private String applTypeCode;

    /** identifier field */
    private String adminPhsOrgCode;

    /** identifier field */
    private String activityCode;

    /** identifier field */
    private Integer serialNum;

    /** identifier field */
    private Integer supportYear;

    /** identifier field */
    private String suffixCode;

    /** identifier field */
    private String applStatusCode;

    /** identifier field */
    private String applStatusGroupCode;

    /** identifier field */
    private Date budgetStartDate;

    /** identifier field */
    private Date budgetEndDate;

    /** identifier field */
    private Integer fy;

    /** identifier field */
    private Long ipf;

    /** identifier field */
    private String orgName;

    /** identifier field */
    private String institutionCity;

    /** identifier field */
    private String institutionState;

    /** identifier field */
    private String projectTitle;

    /** identifier field */
    private String legacySourceFile;

    /** identifier field */
    private String cayCode;

    /** identifier field */
    private String dualCayCode;

    /** identifier field */
    private long pocNpnId;

    /** identifier field */
    private String pocLastName;

    /** identifier field */
    private String pocFirstName;

    /** identifier field */
    private String pocMiName;

    /** identifier field */
    private String pocFullName;

    /** identifier field */
    private Long dualPocNpnId;

    /** identifier field */
    private String dualPocLastName;

    /** identifier field */
    private String dualPocFirstName;

    /** identifier field */
    private String dualPocMiName;

    /** identifier field */
    private String dualPocFullName;

    /** identifier field */
    private String araStatusCode;

    /** identifier field */
    private String araMatchFlag;

    /** identifier field */
    private String currentFutureBoardFlag;

    /** identifier field */
    private String currentReferralActivityCode;

    /** identifier field */
    private Date currentReferralActivityDate;

    /** identifier field */
    private String withdrawnFlag;

    /** full constructor */
    public NciPdQueryVw(long applId, String fullGrantNum, String rfaPaNumber, String councilMeetingDate, String firstName, String miName, String lastName, String applTypeCode, String adminPhsOrgCode, String activityCode, Integer serialNum, Integer supportYear, String suffixCode, String applStatusCode, String applStatusGroupCode, Date budgetStartDate, Date budgetEndDate, Integer fy, Long ipf, String orgName, String institutionCity, String institutionState, String projectTitle, String legacySourceFile, String cayCode, String dualCayCode, long pocNpnId, String pocLastName, String pocFirstName, String pocMiName, String pocFullName, Long dualPocNpnId, String dualPocLastName, String dualPocFirstName, String dualPocMiName, String dualPocFullName, String araStatusCode, String araMatchFlag, String currentFutureBoardFlag, String currentReferralActivityCode, Date currentReferralActivityDate, String withdrawnFlag) {
        this.applId = applId;
        this.fullGrantNum = fullGrantNum;
        this.rfaPaNumber = rfaPaNumber;
        this.councilMeetingDate = councilMeetingDate;
        this.firstName = firstName;
        this.miName = miName;
        this.lastName = lastName;
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
        this.araMatchFlag = araMatchFlag;
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
    public long getApplId() {
        return this.applId;
    }

    public void setApplId(long applId) {
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
    public Integer getSerialNum() {
        return this.serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    /** 
     *                @hibernate.property
     *                 column="SUPPORT_YEAR"
     *             
     */
    public Integer getSupportYear() {
        return this.supportYear;
    }

    public void setSupportYear(Integer supportYear) {
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
     *                 column="BUDGET_START_DATE"
     *             
     */
    public Date getBudgetStartDate() {
        return this.budgetStartDate;
    }

    public void setBudgetStartDate(Date budgetStartDate) {
        this.budgetStartDate = budgetStartDate;
    }

    /** 
     *                @hibernate.property
     *                 column="BUDGET_END_DATE"
     *             
     */
    public Date getBudgetEndDate() {
        return this.budgetEndDate;
    }

    public void setBudgetEndDate(Date budgetEndDate) {
        this.budgetEndDate = budgetEndDate;
    }

    /** 
     *                @hibernate.property
     *                 column="FY"
     *             
     */
    public Integer getFy() {
        return this.fy;
    }

    public void setFy(Integer fy) {
        this.fy = fy;
    }

    /** 
     *                @hibernate.property
     *                 column="IPF"
     *             
     */
    public Long getIpf() {
        return this.ipf;
    }

    public void setIpf(Long ipf) {
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
    public long getPocNpnId() {
        return this.pocNpnId;
    }

    public void setPocNpnId(long pocNpnId) {
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
    public Long getDualPocNpnId() {
        return this.dualPocNpnId;
    }

    public void setDualPocNpnId(Long dualPocNpnId) {
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
    public Date getCurrentReferralActivityDate() {
        return this.currentReferralActivityDate;
    }

    public void setCurrentReferralActivityDate(Date currentReferralActivityDate) {
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
            .append("araMatchFlag", getAraMatchFlag())
            .append("currentFutureBoardFlag", getCurrentFutureBoardFlag())
            .append("currentReferralActivityCode", getCurrentReferralActivityCode())
            .append("currentReferralActivityDate", getCurrentReferralActivityDate())
            .append("withdrawnFlag", getWithdrawnFlag())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
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
            .append(this.getAraMatchFlag(), castOther.getAraMatchFlag())
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
            .append(getAraMatchFlag())
            .append(getCurrentFutureBoardFlag())
            .append(getCurrentReferralActivityCode())
            .append(getCurrentReferralActivityDate())
            .append(getWithdrawnFlag())
            .toHashCode();
    }

}
