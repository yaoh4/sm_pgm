package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;


/**
 *        @hibernate.class
 *         table="NCI_PD_TRANSFER_VW"
 *
*/
public class NciPdTransferVw implements Serializable {

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
    private BigDecimal irgPercentileNum;

    /** identifier field */
    private Integer priorityScoreNum;

    /** identifier field */
    private String irgCode;

    /** identifier field */
    private String irgFlexCode;

    /** identifier field */
    private String groupCode;

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
    private String roleUsageCode;

    /** identifier field */
    private Long pdNpeId;

    /** identifier field */
    private Long pdNpnId;

    /** identifier field */
    private String pdLastName;

    /** identifier field */
    private String pdFirstName;

    /** identifier field */
    private String pdMiName;

    /** identifier field */
    private String pdFullName;

    /** identifier field */
    private Date pdStartDate;

    /** identifier field */
    private Long pdNonId;

    /** identifier field */
    private String pdOrgName;

    /** identifier field */
    private String pdTransferInitialCode;

    /** identifier field */
    private String currentFutureBoardFlag;

    /** identifier field */
    private String withdrawnFlag;

    /** full constructor */
    public NciPdTransferVw(long applId, String fullGrantNum, String rfaPaNumber, String councilMeetingDate, String firstName, String miName, String lastName, BigDecimal irgPercentileNum, Integer priorityScoreNum, String irgCode, String irgFlexCode, String groupCode, String applTypeCode, String adminPhsOrgCode, String activityCode, Integer serialNum, Integer supportYear, String suffixCode, String applStatusCode, String applStatusGroupCode, Integer fy, Long ipf, String orgName, String institutionCity, String institutionState, String projectTitle, String legacySourceFile, String cayCode, String roleUsageCode, Long pdNpeId, Long pdNpnId, String pdLastName, String pdFirstName, String pdMiName, String pdFullName, Date pdStartDate, Long pdNonId, String pdOrgName, String pdTransferInitialCode, String currentFutureBoardFlag, String withdrawnFlag) {
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
        this.applTypeCode = applTypeCode;
        this.adminPhsOrgCode = adminPhsOrgCode;
        this.activityCode = activityCode;
        this.serialNum = serialNum;
        this.supportYear = supportYear;
        this.suffixCode = suffixCode;
        this.applStatusCode = applStatusCode;
        this.applStatusGroupCode = applStatusGroupCode;
        this.fy = fy;
        this.ipf = ipf;
        this.orgName = orgName;
        this.institutionCity = institutionCity;
        this.institutionState = institutionState;
        this.projectTitle = projectTitle;
        this.legacySourceFile = legacySourceFile;
        this.cayCode = cayCode;
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
        this.pdTransferInitialCode = pdTransferInitialCode;
        this.currentFutureBoardFlag = currentFutureBoardFlag;
        this.withdrawnFlag = withdrawnFlag;
    }

    /** default constructor */
    public NciPdTransferVw() {
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
	 try{
       if(councilMeetingDate.substring(4,6).equalsIgnoreCase("00")){
			councilMeetingDate = ApplicationConstants.EMPTY_STRING;
		}
        this.councilMeetingDate = councilMeetingDate;
	 }catch(Exception ex) {
		 councilMeetingDate = ApplicationConstants.EMPTY_STRING;
	 }
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
    public BigDecimal getIrgPercentileNum() {
        return this.irgPercentileNum;
    }

    public void setIrgPercentileNum(BigDecimal irgPercentileNum) {
        this.irgPercentileNum = irgPercentileNum;
    }

    /**
     *                @hibernate.property
     *                 column="PRIORITY_SCORE_NUM"
     *
     */
    public Integer getPriorityScoreNum() {
        return this.priorityScoreNum;
    }

    public void setPriorityScoreNum(Integer priorityScoreNum) {
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
    public Long getPdNpeId() {
        return this.pdNpeId;
    }

    public void setPdNpeId(Long pdNpeId) {
        this.pdNpeId = pdNpeId;
    }

    /**
     *                @hibernate.property
     *                 column="PD_NPN_ID"
     *
     */
    public Long getPdNpnId() {
        return this.pdNpnId;
    }

    public void setPdNpnId(Long pdNpnId) {
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
    public Date getPdStartDate() {
        return this.pdStartDate;
    }

    public void setPdStartDate(Date pdStartDate) {
        this.pdStartDate = pdStartDate;
    }

    /**
     *                @hibernate.property
     *                 column="PD_NON_ID"
     *
     */
    public Long getPdNonId() {
        return this.pdNonId;
    }

    public void setPdNonId(Long pdNonId) {
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
            .append("applTypeCode", getApplTypeCode())
            .append("adminPhsOrgCode", getAdminPhsOrgCode())
            .append("activityCode", getActivityCode())
            .append("serialNum", getSerialNum())
            .append("supportYear", getSupportYear())
            .append("suffixCode", getSuffixCode())
            .append("applStatusCode", getApplStatusCode())
            .append("applStatusGroupCode", getApplStatusGroupCode())
            .append("fy", getFy())
            .append("ipf", getIpf())
            .append("orgName", getOrgName())
            .append("institutionCity", getInstitutionCity())
            .append("institutionState", getInstitutionState())
            .append("projectTitle", getProjectTitle())
            .append("legacySourceFile", getLegacySourceFile())
            .append("cayCode", getCayCode())
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
            .append("pdTransferInitialCode", getPdTransferInitialCode())
            .append("currentFutureBoardFlag", getCurrentFutureBoardFlag())
            .append("withdrawnFlag", getWithdrawnFlag())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof NciPdTransferVw) ) return false;
        NciPdTransferVw castOther = (NciPdTransferVw) other;
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
            .append(this.getApplTypeCode(), castOther.getApplTypeCode())
            .append(this.getAdminPhsOrgCode(), castOther.getAdminPhsOrgCode())
            .append(this.getActivityCode(), castOther.getActivityCode())
            .append(this.getSerialNum(), castOther.getSerialNum())
            .append(this.getSupportYear(), castOther.getSupportYear())
            .append(this.getSuffixCode(), castOther.getSuffixCode())
            .append(this.getApplStatusCode(), castOther.getApplStatusCode())
            .append(this.getApplStatusGroupCode(), castOther.getApplStatusGroupCode())
            .append(this.getFy(), castOther.getFy())
            .append(this.getIpf(), castOther.getIpf())
            .append(this.getOrgName(), castOther.getOrgName())
            .append(this.getInstitutionCity(), castOther.getInstitutionCity())
            .append(this.getInstitutionState(), castOther.getInstitutionState())
            .append(this.getProjectTitle(), castOther.getProjectTitle())
            .append(this.getLegacySourceFile(), castOther.getLegacySourceFile())
            .append(this.getCayCode(), castOther.getCayCode())
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
            .append(this.getPdTransferInitialCode(), castOther.getPdTransferInitialCode())
            .append(this.getCurrentFutureBoardFlag(), castOther.getCurrentFutureBoardFlag())
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
            .append(getApplTypeCode())
            .append(getAdminPhsOrgCode())
            .append(getActivityCode())
            .append(getSerialNum())
            .append(getSupportYear())
            .append(getSuffixCode())
            .append(getApplStatusCode())
            .append(getApplStatusGroupCode())
            .append(getFy())
            .append(getIpf())
            .append(getOrgName())
            .append(getInstitutionCity())
            .append(getInstitutionState())
            .append(getProjectTitle())
            .append(getLegacySourceFile())
            .append(getCayCode())
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
            .append(getPdTransferInitialCode())
            .append(getCurrentFutureBoardFlag())
            .append(getWithdrawnFlag())
            .toHashCode();
    }

}
