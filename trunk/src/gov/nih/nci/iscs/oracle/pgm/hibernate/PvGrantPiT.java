package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class PvGrantPiT implements Serializable {

    /** identifier field */
    private long applId;

    /** identifier field */
    private String fullGrantNum;

    /** identifier field */
    private String applTypeCode;

    /** identifier field */
    private String activityCode;

    /** identifier field */
    private String adminPhsOrgCode;

    /** identifier field */
    private Integer serialNum;

    /** identifier field */
    private Integer supportYear;

    /** identifier field */
    private String suffixCode;

    /** identifier field */
    private String projectTitle;

    /** identifier field */
    private String formerNum;

    /** identifier field */
    private String rfaPaNumber;

    /** identifier field */
    private String councilMeetingDate;

    /** identifier field */
    private Long externalOrgId;

    /** identifier field */
    private String orgName;

    /** identifier field */
    private Date projectPeriodStartDate;

    /** identifier field */
    private Date projectPeriodEndDate;

    /** identifier field */
    private Date budgetStartDate;

    /** identifier field */
    private Date budgetEndDate;

    /** identifier field */
    private Long personId;

    /** identifier field */
    private String namePrefix;

    /** identifier field */
    private String lastName;

    /** identifier field */
    private String firstName;

    /** identifier field */
    private String miName;

    /** identifier field */
    private String nameSuffix;

    /** identifier field */
    private String emailAddr;

    /** identifier field */
    private String progClassCode;

    /** identifier field */
    private String irgCode;

    /** identifier field */
    private String irgFlexCode;

    /** identifier field */
    private String groupCode;

    /** identifier field */
    private String irgRecommendationCode;

    /** identifier field */
    private Integer priorityScoreNum;

    /** identifier field */
    private BigDecimal irgPercentileNum;

    /** identifier field */
    private String irgPercentileRefCode;

    /** identifier field */
    private String humanSubjectCode;

    /** identifier field */
    private String animalSubjectsCode;

    /** identifier field */
    private String aidsRelatedCode;

    /** identifier field */
    private String genderClinicalStudyCode;

    /** identifier field */
    private String minorityClinicalStudyCode;

    /** identifier field */
    private String applStatusGroupCode;

    /** identifier field */
    private String applStatusGroupDescrip;

    /** identifier field */
    private Integer fy;

    /** identifier field */
    private String childClinicalStudyCode;

    /** identifier field */
    private String animalSubjectAssuranceNum;

    /** identifier field */
    private Date animalSubjectIacucDate;

    /** identifier field */
    private Date applReceivedDate;

    /** identifier field */
    private String applStatusCode;

    /** identifier field */
    private Date awdNoticeIssuedDate;

    /** identifier field */
    private String councilRecomCode;

    /** identifier field */
    private Date createdDate;

    /** identifier field */
    private String creatorId;

    /** identifier field */
    private Date currAwdNoticeIssueDatetime;

    /** identifier field */
    private BigDecimal directCostRequestedAmt;

    /** identifier field */
    private String ein;

    /** identifier field */
    private String expandedAuthoritiesCode;

    /** identifier field */
    private String expeditedReviewCode;

    /** identifier field */
    private String fedDemoProjectCode;

    /** identifier field */
    private String humanSubjectAssuranceNum;

    /** identifier field */
    private Date humanSubjectIrbDate;

    /** identifier field */
    private BigDecimal indirectCostRequestedAmt;

    /** identifier field */
    private Date initEncumbranceDate;

    /** identifier field */
    private Date lastAwdNoticeIssueDatetime;

    /** identifier field */
    private Date lastUpdDate;

    /** identifier field */
    private String lastUpdId;

    /** identifier field */
    private Date latestEncumbranceDate;

    /** identifier field */
    private Integer outYearsNum;

    /** identifier field */
    private String specialDispCode;

    /** identifier field */
    private String suppTypeCode;

    /** identifier field */
    private Integer totalCostRequestedAmt;

    /** identifier field */
    private Long totalCostRequestedYear1Amt;

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
    private Date activationDate;

    /** identifier field */
    private String cofundingIndicatorCode;

    /** identifier field */
    private String foreignApplCode;

    /** identifier field */
    private String fundingRecommendedCode;

    /** identifier field */
    private String groupExtCode;

    /** identifier field */
    private String icdDispCode;

    /** identifier field */
    private String icdSpecialCode;

    /** identifier field */
    private String icdSpecialCodeCmnt;

    /** identifier field */
    private String intentToPayCode;

    /** identifier field */
    private String otherCountryCode;

    /** identifier field */
    private String snapIndicatorCode;

    /** identifier field */
    private String specialConsiderCode;

    /** identifier field */
    private String sraDesignatorCode;

    /** identifier field */
    private String sraFlexCode;

    /** identifier field */
    private String transferStatusCode;

    /** identifier field */
    private String wipStatusCode;

    /** identifier field */
    private String cityName;

    /** identifier field */
    private String faxNum;

    /** identifier field */
    private String phoneExtensionNum;

    /** identifier field */
    private String phoneNum;

    /** identifier field */
    private String stateCode;

    /** identifier field */
    private String zipCode;

    /** identifier field */
    private String aaInstnTypeCode;

    /** identifier field */
    private String caIcdRspnsbltyCode;

    /** identifier field */
    private String specialSuppCode;

    /** identifier field */
    private String trackingExceptionCode;

    /** identifier field */
    private String institutionState;

    /** identifier field */
    private String institutionCity;

    /** identifier field */
    private String grantId;

    /** identifier field */
    private String piName;

    /** identifier field */
    private String piNameF;

    /** identifier field */
    private String legacySourceFile;

    /** identifier field */
    private Date createDate;

    /** identifier field */
    private Date lastChangeDate;

    /** full constructor */
    public PvGrantPiT(long applId, String fullGrantNum, String applTypeCode, String activityCode, String adminPhsOrgCode, Integer serialNum, Integer supportYear, String suffixCode, String projectTitle, String formerNum, String rfaPaNumber, String councilMeetingDate, Long externalOrgId, String orgName, Date projectPeriodStartDate, Date projectPeriodEndDate, Date budgetStartDate, Date budgetEndDate, Long personId, String namePrefix, String lastName, String firstName, String miName, String nameSuffix, String emailAddr, String progClassCode, String irgCode, String irgFlexCode, String groupCode, String irgRecommendationCode, Integer priorityScoreNum, BigDecimal irgPercentileNum, String irgPercentileRefCode, String humanSubjectCode, String animalSubjectsCode, String aidsRelatedCode, String genderClinicalStudyCode, String minorityClinicalStudyCode, String applStatusGroupCode, String applStatusGroupDescrip, Integer fy, String childClinicalStudyCode, String animalSubjectAssuranceNum, Date animalSubjectIacucDate, Date applReceivedDate, String applStatusCode, Date awdNoticeIssuedDate, String councilRecomCode, Date createdDate, String creatorId, Date currAwdNoticeIssueDatetime, BigDecimal directCostRequestedAmt, String ein, String expandedAuthoritiesCode, String expeditedReviewCode, String fedDemoProjectCode, String humanSubjectAssuranceNum, Date humanSubjectIrbDate, BigDecimal indirectCostRequestedAmt, Date initEncumbranceDate, Date lastAwdNoticeIssueDatetime, Date lastUpdDate, String lastUpdId, Date latestEncumbranceDate, Integer outYearsNum, String specialDispCode, String suppTypeCode, Integer totalCostRequestedAmt, Long totalCostRequestedYear1Amt, String line1Addr, String line2Addr, String line3Addr, String line4Addr, String line5Addr, Date activationDate, String cofundingIndicatorCode, String foreignApplCode, String fundingRecommendedCode, String groupExtCode, String icdDispCode, String icdSpecialCode, String icdSpecialCodeCmnt, String intentToPayCode, String otherCountryCode, String snapIndicatorCode, String specialConsiderCode, String sraDesignatorCode, String sraFlexCode, String transferStatusCode, String wipStatusCode, String cityName, String faxNum, String phoneExtensionNum, String phoneNum, String stateCode, String zipCode, String aaInstnTypeCode, String caIcdRspnsbltyCode, String specialSuppCode, String trackingExceptionCode, String institutionState, String institutionCity, String grantId, String piName, String piNameF, String legacySourceFile, Date createDate, Date lastChangeDate) {
        this.applId = applId;
        this.fullGrantNum = fullGrantNum;
        this.applTypeCode = applTypeCode;
        this.activityCode = activityCode;
        this.adminPhsOrgCode = adminPhsOrgCode;
        this.serialNum = serialNum;
        this.supportYear = supportYear;
        this.suffixCode = suffixCode;
        this.projectTitle = projectTitle;
        this.formerNum = formerNum;
        this.rfaPaNumber = rfaPaNumber;
        this.councilMeetingDate = councilMeetingDate;
        this.externalOrgId = externalOrgId;
        this.orgName = orgName;
        this.projectPeriodStartDate = projectPeriodStartDate;
        this.projectPeriodEndDate = projectPeriodEndDate;
        this.budgetStartDate = budgetStartDate;
        this.budgetEndDate = budgetEndDate;
        this.personId = personId;
        this.namePrefix = namePrefix;
        this.lastName = lastName;
        this.firstName = firstName;
        this.miName = miName;
        this.nameSuffix = nameSuffix;
        this.emailAddr = emailAddr;
        this.progClassCode = progClassCode;
        this.irgCode = irgCode;
        this.irgFlexCode = irgFlexCode;
        this.groupCode = groupCode;
        this.irgRecommendationCode = irgRecommendationCode;
        this.priorityScoreNum = priorityScoreNum;
        this.irgPercentileNum = irgPercentileNum;
        this.irgPercentileRefCode = irgPercentileRefCode;
        this.humanSubjectCode = humanSubjectCode;
        this.animalSubjectsCode = animalSubjectsCode;
        this.aidsRelatedCode = aidsRelatedCode;
        this.genderClinicalStudyCode = genderClinicalStudyCode;
        this.minorityClinicalStudyCode = minorityClinicalStudyCode;
        this.applStatusGroupCode = applStatusGroupCode;
        this.applStatusGroupDescrip = applStatusGroupDescrip;
        this.fy = fy;
        this.childClinicalStudyCode = childClinicalStudyCode;
        this.animalSubjectAssuranceNum = animalSubjectAssuranceNum;
        this.animalSubjectIacucDate = animalSubjectIacucDate;
        this.applReceivedDate = applReceivedDate;
        this.applStatusCode = applStatusCode;
        this.awdNoticeIssuedDate = awdNoticeIssuedDate;
        this.councilRecomCode = councilRecomCode;
        this.createdDate = createdDate;
        this.creatorId = creatorId;
        this.currAwdNoticeIssueDatetime = currAwdNoticeIssueDatetime;
        this.directCostRequestedAmt = directCostRequestedAmt;
        this.ein = ein;
        this.expandedAuthoritiesCode = expandedAuthoritiesCode;
        this.expeditedReviewCode = expeditedReviewCode;
        this.fedDemoProjectCode = fedDemoProjectCode;
        this.humanSubjectAssuranceNum = humanSubjectAssuranceNum;
        this.humanSubjectIrbDate = humanSubjectIrbDate;
        this.indirectCostRequestedAmt = indirectCostRequestedAmt;
        this.initEncumbranceDate = initEncumbranceDate;
        this.lastAwdNoticeIssueDatetime = lastAwdNoticeIssueDatetime;
        this.lastUpdDate = lastUpdDate;
        this.lastUpdId = lastUpdId;
        this.latestEncumbranceDate = latestEncumbranceDate;
        this.outYearsNum = outYearsNum;
        this.specialDispCode = specialDispCode;
        this.suppTypeCode = suppTypeCode;
        this.totalCostRequestedAmt = totalCostRequestedAmt;
        this.totalCostRequestedYear1Amt = totalCostRequestedYear1Amt;
        this.line1Addr = line1Addr;
        this.line2Addr = line2Addr;
        this.line3Addr = line3Addr;
        this.line4Addr = line4Addr;
        this.line5Addr = line5Addr;
        this.activationDate = activationDate;
        this.cofundingIndicatorCode = cofundingIndicatorCode;
        this.foreignApplCode = foreignApplCode;
        this.fundingRecommendedCode = fundingRecommendedCode;
        this.groupExtCode = groupExtCode;
        this.icdDispCode = icdDispCode;
        this.icdSpecialCode = icdSpecialCode;
        this.icdSpecialCodeCmnt = icdSpecialCodeCmnt;
        this.intentToPayCode = intentToPayCode;
        this.otherCountryCode = otherCountryCode;
        this.snapIndicatorCode = snapIndicatorCode;
        this.specialConsiderCode = specialConsiderCode;
        this.sraDesignatorCode = sraDesignatorCode;
        this.sraFlexCode = sraFlexCode;
        this.transferStatusCode = transferStatusCode;
        this.wipStatusCode = wipStatusCode;
        this.cityName = cityName;
        this.faxNum = faxNum;
        this.phoneExtensionNum = phoneExtensionNum;
        this.phoneNum = phoneNum;
        this.stateCode = stateCode;
        this.zipCode = zipCode;
        this.aaInstnTypeCode = aaInstnTypeCode;
        this.caIcdRspnsbltyCode = caIcdRspnsbltyCode;
        this.specialSuppCode = specialSuppCode;
        this.trackingExceptionCode = trackingExceptionCode;
        this.institutionState = institutionState;
        this.institutionCity = institutionCity;
        this.grantId = grantId;
        this.piName = piName;
        this.piNameF = piNameF;
        this.legacySourceFile = legacySourceFile;
        this.createDate = createDate;
        this.lastChangeDate = lastChangeDate;
    }

    /** default constructor */
    public PvGrantPiT() {
    }

    public long getApplId() {
        return this.applId;
    }

    public void setApplId(long applId) {
        this.applId = applId;
    }

    public String getFullGrantNum() {
        return this.fullGrantNum;
    }

    public void setFullGrantNum(String fullGrantNum) {
        this.fullGrantNum = fullGrantNum;
    }

    public String getApplTypeCode() {
        return this.applTypeCode;
    }

    public void setApplTypeCode(String applTypeCode) {
        this.applTypeCode = applTypeCode;
    }

    public String getActivityCode() {
        return this.activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getAdminPhsOrgCode() {
        return this.adminPhsOrgCode;
    }

    public void setAdminPhsOrgCode(String adminPhsOrgCode) {
        this.adminPhsOrgCode = adminPhsOrgCode;
    }

    public Integer getSerialNum() {
        return this.serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public Integer getSupportYear() {
        return this.supportYear;
    }

    public void setSupportYear(Integer supportYear) {
        this.supportYear = supportYear;
    }

    public String getSuffixCode() {
        return this.suffixCode;
    }

    public void setSuffixCode(String suffixCode) {
        this.suffixCode = suffixCode;
    }

    public String getProjectTitle() {
        return this.projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getFormerNum() {
        return this.formerNum;
    }

    public void setFormerNum(String formerNum) {
        this.formerNum = formerNum;
    }

    public String getRfaPaNumber() {
        return this.rfaPaNumber;
    }

    public void setRfaPaNumber(String rfaPaNumber) {
        this.rfaPaNumber = rfaPaNumber;
    }

    public String getCouncilMeetingDate() {
        return this.councilMeetingDate;
    }

    public void setCouncilMeetingDate(String councilMeetingDate) {
        this.councilMeetingDate = councilMeetingDate;
    }

    public Long getExternalOrgId() {
        return this.externalOrgId;
    }

    public void setExternalOrgId(Long externalOrgId) {
        this.externalOrgId = externalOrgId;
    }

    public String getOrgName() {
        return this.orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Date getProjectPeriodStartDate() {
        return this.projectPeriodStartDate;
    }

    public void setProjectPeriodStartDate(Date projectPeriodStartDate) {
        this.projectPeriodStartDate = projectPeriodStartDate;
    }

    public Date getProjectPeriodEndDate() {
        return this.projectPeriodEndDate;
    }

    public void setProjectPeriodEndDate(Date projectPeriodEndDate) {
        this.projectPeriodEndDate = projectPeriodEndDate;
    }

    public Date getBudgetStartDate() {
        return this.budgetStartDate;
    }

    public void setBudgetStartDate(Date budgetStartDate) {
        this.budgetStartDate = budgetStartDate;
    }

    public Date getBudgetEndDate() {
        return this.budgetEndDate;
    }

    public void setBudgetEndDate(Date budgetEndDate) {
        this.budgetEndDate = budgetEndDate;
    }

    public Long getPersonId() {
        return this.personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getNamePrefix() {
        return this.namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiName() {
        return this.miName;
    }

    public void setMiName(String miName) {
        this.miName = miName;
    }

    public String getNameSuffix() {
        return this.nameSuffix;
    }

    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    public String getEmailAddr() {
        return this.emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public String getProgClassCode() {
        return this.progClassCode;
    }

    public void setProgClassCode(String progClassCode) {
        this.progClassCode = progClassCode;
    }

    public String getIrgCode() {
        return this.irgCode;
    }

    public void setIrgCode(String irgCode) {
        this.irgCode = irgCode;
    }

    public String getIrgFlexCode() {
        return this.irgFlexCode;
    }

    public void setIrgFlexCode(String irgFlexCode) {
        this.irgFlexCode = irgFlexCode;
    }

    public String getGroupCode() {
        return this.groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getIrgRecommendationCode() {
        return this.irgRecommendationCode;
    }

    public void setIrgRecommendationCode(String irgRecommendationCode) {
        this.irgRecommendationCode = irgRecommendationCode;
    }

    public Integer getPriorityScoreNum() {
        return this.priorityScoreNum;
    }

    public void setPriorityScoreNum(Integer priorityScoreNum) {
        this.priorityScoreNum = priorityScoreNum;
    }

    public BigDecimal getIrgPercentileNum() {
        return this.irgPercentileNum;
    }

    public void setIrgPercentileNum(BigDecimal irgPercentileNum) {
        this.irgPercentileNum = irgPercentileNum;
    }

    public String getIrgPercentileRefCode() {
        return this.irgPercentileRefCode;
    }

    public void setIrgPercentileRefCode(String irgPercentileRefCode) {
        this.irgPercentileRefCode = irgPercentileRefCode;
    }

    public String getHumanSubjectCode() {
        return this.humanSubjectCode;
    }

    public void setHumanSubjectCode(String humanSubjectCode) {
        this.humanSubjectCode = humanSubjectCode;
    }

    public String getAnimalSubjectsCode() {
        return this.animalSubjectsCode;
    }

    public void setAnimalSubjectsCode(String animalSubjectsCode) {
        this.animalSubjectsCode = animalSubjectsCode;
    }

    public String getAidsRelatedCode() {
        return this.aidsRelatedCode;
    }

    public void setAidsRelatedCode(String aidsRelatedCode) {
        this.aidsRelatedCode = aidsRelatedCode;
    }

    public String getGenderClinicalStudyCode() {
        return this.genderClinicalStudyCode;
    }

    public void setGenderClinicalStudyCode(String genderClinicalStudyCode) {
        this.genderClinicalStudyCode = genderClinicalStudyCode;
    }

    public String getMinorityClinicalStudyCode() {
        return this.minorityClinicalStudyCode;
    }

    public void setMinorityClinicalStudyCode(String minorityClinicalStudyCode) {
        this.minorityClinicalStudyCode = minorityClinicalStudyCode;
    }

    public String getApplStatusGroupCode() {
        return this.applStatusGroupCode;
    }

    public void setApplStatusGroupCode(String applStatusGroupCode) {
        this.applStatusGroupCode = applStatusGroupCode;
    }

    public String getApplStatusGroupDescrip() {
        return this.applStatusGroupDescrip;
    }

    public void setApplStatusGroupDescrip(String applStatusGroupDescrip) {
        this.applStatusGroupDescrip = applStatusGroupDescrip;
    }

    public Integer getFy() {
        return this.fy;
    }

    public void setFy(Integer fy) {
        this.fy = fy;
    }

    public String getChildClinicalStudyCode() {
        return this.childClinicalStudyCode;
    }

    public void setChildClinicalStudyCode(String childClinicalStudyCode) {
        this.childClinicalStudyCode = childClinicalStudyCode;
    }

    public String getAnimalSubjectAssuranceNum() {
        return this.animalSubjectAssuranceNum;
    }

    public void setAnimalSubjectAssuranceNum(String animalSubjectAssuranceNum) {
        this.animalSubjectAssuranceNum = animalSubjectAssuranceNum;
    }

    public Date getAnimalSubjectIacucDate() {
        return this.animalSubjectIacucDate;
    }

    public void setAnimalSubjectIacucDate(Date animalSubjectIacucDate) {
        this.animalSubjectIacucDate = animalSubjectIacucDate;
    }

    public Date getApplReceivedDate() {
        return this.applReceivedDate;
    }

    public void setApplReceivedDate(Date applReceivedDate) {
        this.applReceivedDate = applReceivedDate;
    }

    public String getApplStatusCode() {
        return this.applStatusCode;
    }

    public void setApplStatusCode(String applStatusCode) {
        this.applStatusCode = applStatusCode;
    }

    public Date getAwdNoticeIssuedDate() {
        return this.awdNoticeIssuedDate;
    }

    public void setAwdNoticeIssuedDate(Date awdNoticeIssuedDate) {
        this.awdNoticeIssuedDate = awdNoticeIssuedDate;
    }

    public String getCouncilRecomCode() {
        return this.councilRecomCode;
    }

    public void setCouncilRecomCode(String councilRecomCode) {
        this.councilRecomCode = councilRecomCode;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatorId() {
        return this.creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCurrAwdNoticeIssueDatetime() {
        return this.currAwdNoticeIssueDatetime;
    }

    public void setCurrAwdNoticeIssueDatetime(Date currAwdNoticeIssueDatetime) {
        this.currAwdNoticeIssueDatetime = currAwdNoticeIssueDatetime;
    }

    public BigDecimal getDirectCostRequestedAmt() {
        return this.directCostRequestedAmt;
    }

    public void setDirectCostRequestedAmt(BigDecimal directCostRequestedAmt) {
        this.directCostRequestedAmt = directCostRequestedAmt;
    }

    public String getEin() {
        return this.ein;
    }

    public void setEin(String ein) {
        this.ein = ein;
    }

    public String getExpandedAuthoritiesCode() {
        return this.expandedAuthoritiesCode;
    }

    public void setExpandedAuthoritiesCode(String expandedAuthoritiesCode) {
        this.expandedAuthoritiesCode = expandedAuthoritiesCode;
    }

    public String getExpeditedReviewCode() {
        return this.expeditedReviewCode;
    }

    public void setExpeditedReviewCode(String expeditedReviewCode) {
        this.expeditedReviewCode = expeditedReviewCode;
    }

    public String getFedDemoProjectCode() {
        return this.fedDemoProjectCode;
    }

    public void setFedDemoProjectCode(String fedDemoProjectCode) {
        this.fedDemoProjectCode = fedDemoProjectCode;
    }

    public String getHumanSubjectAssuranceNum() {
        return this.humanSubjectAssuranceNum;
    }

    public void setHumanSubjectAssuranceNum(String humanSubjectAssuranceNum) {
        this.humanSubjectAssuranceNum = humanSubjectAssuranceNum;
    }

    public Date getHumanSubjectIrbDate() {
        return this.humanSubjectIrbDate;
    }

    public void setHumanSubjectIrbDate(Date humanSubjectIrbDate) {
        this.humanSubjectIrbDate = humanSubjectIrbDate;
    }

    public BigDecimal getIndirectCostRequestedAmt() {
        return this.indirectCostRequestedAmt;
    }

    public void setIndirectCostRequestedAmt(BigDecimal indirectCostRequestedAmt) {
        this.indirectCostRequestedAmt = indirectCostRequestedAmt;
    }

    public Date getInitEncumbranceDate() {
        return this.initEncumbranceDate;
    }

    public void setInitEncumbranceDate(Date initEncumbranceDate) {
        this.initEncumbranceDate = initEncumbranceDate;
    }

    public Date getLastAwdNoticeIssueDatetime() {
        return this.lastAwdNoticeIssueDatetime;
    }

    public void setLastAwdNoticeIssueDatetime(Date lastAwdNoticeIssueDatetime) {
        this.lastAwdNoticeIssueDatetime = lastAwdNoticeIssueDatetime;
    }

    public Date getLastUpdDate() {
        return this.lastUpdDate;
    }

    public void setLastUpdDate(Date lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }

    public String getLastUpdId() {
        return this.lastUpdId;
    }

    public void setLastUpdId(String lastUpdId) {
        this.lastUpdId = lastUpdId;
    }

    public Date getLatestEncumbranceDate() {
        return this.latestEncumbranceDate;
    }

    public void setLatestEncumbranceDate(Date latestEncumbranceDate) {
        this.latestEncumbranceDate = latestEncumbranceDate;
    }

    public Integer getOutYearsNum() {
        return this.outYearsNum;
    }

    public void setOutYearsNum(Integer outYearsNum) {
        this.outYearsNum = outYearsNum;
    }

    public String getSpecialDispCode() {
        return this.specialDispCode;
    }

    public void setSpecialDispCode(String specialDispCode) {
        this.specialDispCode = specialDispCode;
    }

    public String getSuppTypeCode() {
        return this.suppTypeCode;
    }

    public void setSuppTypeCode(String suppTypeCode) {
        this.suppTypeCode = suppTypeCode;
    }

    public Integer getTotalCostRequestedAmt() {
        return this.totalCostRequestedAmt;
    }

    public void setTotalCostRequestedAmt(Integer totalCostRequestedAmt) {
        this.totalCostRequestedAmt = totalCostRequestedAmt;
    }

    public Long getTotalCostRequestedYear1Amt() {
        return this.totalCostRequestedYear1Amt;
    }

    public void setTotalCostRequestedYear1Amt(Long totalCostRequestedYear1Amt) {
        this.totalCostRequestedYear1Amt = totalCostRequestedYear1Amt;
    }

    public String getLine1Addr() {
        return this.line1Addr;
    }

    public void setLine1Addr(String line1Addr) {
        this.line1Addr = line1Addr;
    }

    public String getLine2Addr() {
        return this.line2Addr;
    }

    public void setLine2Addr(String line2Addr) {
        this.line2Addr = line2Addr;
    }

    public String getLine3Addr() {
        return this.line3Addr;
    }

    public void setLine3Addr(String line3Addr) {
        this.line3Addr = line3Addr;
    }

    public String getLine4Addr() {
        return this.line4Addr;
    }

    public void setLine4Addr(String line4Addr) {
        this.line4Addr = line4Addr;
    }

    public String getLine5Addr() {
        return this.line5Addr;
    }

    public void setLine5Addr(String line5Addr) {
        this.line5Addr = line5Addr;
    }

    public Date getActivationDate() {
        return this.activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public String getCofundingIndicatorCode() {
        return this.cofundingIndicatorCode;
    }

    public void setCofundingIndicatorCode(String cofundingIndicatorCode) {
        this.cofundingIndicatorCode = cofundingIndicatorCode;
    }

    public String getForeignApplCode() {
        return this.foreignApplCode;
    }

    public void setForeignApplCode(String foreignApplCode) {
        this.foreignApplCode = foreignApplCode;
    }

    public String getFundingRecommendedCode() {
        return this.fundingRecommendedCode;
    }

    public void setFundingRecommendedCode(String fundingRecommendedCode) {
        this.fundingRecommendedCode = fundingRecommendedCode;
    }

    public String getGroupExtCode() {
        return this.groupExtCode;
    }

    public void setGroupExtCode(String groupExtCode) {
        this.groupExtCode = groupExtCode;
    }

    public String getIcdDispCode() {
        return this.icdDispCode;
    }

    public void setIcdDispCode(String icdDispCode) {
        this.icdDispCode = icdDispCode;
    }

    public String getIcdSpecialCode() {
        return this.icdSpecialCode;
    }

    public void setIcdSpecialCode(String icdSpecialCode) {
        this.icdSpecialCode = icdSpecialCode;
    }

    public String getIcdSpecialCodeCmnt() {
        return this.icdSpecialCodeCmnt;
    }

    public void setIcdSpecialCodeCmnt(String icdSpecialCodeCmnt) {
        this.icdSpecialCodeCmnt = icdSpecialCodeCmnt;
    }

    public String getIntentToPayCode() {
        return this.intentToPayCode;
    }

    public void setIntentToPayCode(String intentToPayCode) {
        this.intentToPayCode = intentToPayCode;
    }

    public String getOtherCountryCode() {
        return this.otherCountryCode;
    }

    public void setOtherCountryCode(String otherCountryCode) {
        this.otherCountryCode = otherCountryCode;
    }

    public String getSnapIndicatorCode() {
        return this.snapIndicatorCode;
    }

    public void setSnapIndicatorCode(String snapIndicatorCode) {
        this.snapIndicatorCode = snapIndicatorCode;
    }

    public String getSpecialConsiderCode() {
        return this.specialConsiderCode;
    }

    public void setSpecialConsiderCode(String specialConsiderCode) {
        this.specialConsiderCode = specialConsiderCode;
    }

    public String getSraDesignatorCode() {
        return this.sraDesignatorCode;
    }

    public void setSraDesignatorCode(String sraDesignatorCode) {
        this.sraDesignatorCode = sraDesignatorCode;
    }

    public String getSraFlexCode() {
        return this.sraFlexCode;
    }

    public void setSraFlexCode(String sraFlexCode) {
        this.sraFlexCode = sraFlexCode;
    }

    public String getTransferStatusCode() {
        return this.transferStatusCode;
    }

    public void setTransferStatusCode(String transferStatusCode) {
        this.transferStatusCode = transferStatusCode;
    }

    public String getWipStatusCode() {
        return this.wipStatusCode;
    }

    public void setWipStatusCode(String wipStatusCode) {
        this.wipStatusCode = wipStatusCode;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getFaxNum() {
        return this.faxNum;
    }

    public void setFaxNum(String faxNum) {
        this.faxNum = faxNum;
    }

    public String getPhoneExtensionNum() {
        return this.phoneExtensionNum;
    }

    public void setPhoneExtensionNum(String phoneExtensionNum) {
        this.phoneExtensionNum = phoneExtensionNum;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getStateCode() {
        return this.stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAaInstnTypeCode() {
        return this.aaInstnTypeCode;
    }

    public void setAaInstnTypeCode(String aaInstnTypeCode) {
        this.aaInstnTypeCode = aaInstnTypeCode;
    }

    public String getCaIcdRspnsbltyCode() {
        return this.caIcdRspnsbltyCode;
    }

    public void setCaIcdRspnsbltyCode(String caIcdRspnsbltyCode) {
        this.caIcdRspnsbltyCode = caIcdRspnsbltyCode;
    }

    public String getSpecialSuppCode() {
        return this.specialSuppCode;
    }

    public void setSpecialSuppCode(String specialSuppCode) {
        this.specialSuppCode = specialSuppCode;
    }

    public String getTrackingExceptionCode() {
        return this.trackingExceptionCode;
    }

    public void setTrackingExceptionCode(String trackingExceptionCode) {
        this.trackingExceptionCode = trackingExceptionCode;
    }

    public String getInstitutionState() {
        return this.institutionState;
    }

    public void setInstitutionState(String institutionState) {
        this.institutionState = institutionState;
    }

    public String getInstitutionCity() {
        return this.institutionCity;
    }

    public void setInstitutionCity(String institutionCity) {
        this.institutionCity = institutionCity;
    }

    public String getGrantId() {
        return this.grantId;
    }

    public void setGrantId(String grantId) {
        this.grantId = grantId;
    }

    public String getPiName() {
        return this.piName;
    }

    public void setPiName(String piName) {
        this.piName = piName;
    }

    public String getPiNameF() {
        return this.piNameF;
    }

    public void setPiNameF(String piNameF) {
        this.piNameF = piNameF;
    }

    public String getLegacySourceFile() {
        return this.legacySourceFile;
    }

    public void setLegacySourceFile(String legacySourceFile) {
        this.legacySourceFile = legacySourceFile;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastChangeDate() {
        return this.lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("applId", getApplId())
            .append("fullGrantNum", getFullGrantNum())
            .append("applTypeCode", getApplTypeCode())
            .append("activityCode", getActivityCode())
            .append("adminPhsOrgCode", getAdminPhsOrgCode())
            .append("serialNum", getSerialNum())
            .append("supportYear", getSupportYear())
            .append("suffixCode", getSuffixCode())
            .append("projectTitle", getProjectTitle())
            .append("formerNum", getFormerNum())
            .append("rfaPaNumber", getRfaPaNumber())
            .append("councilMeetingDate", getCouncilMeetingDate())
            .append("externalOrgId", getExternalOrgId())
            .append("orgName", getOrgName())
            .append("projectPeriodStartDate", getProjectPeriodStartDate())
            .append("projectPeriodEndDate", getProjectPeriodEndDate())
            .append("budgetStartDate", getBudgetStartDate())
            .append("budgetEndDate", getBudgetEndDate())
            .append("personId", getPersonId())
            .append("namePrefix", getNamePrefix())
            .append("lastName", getLastName())
            .append("firstName", getFirstName())
            .append("miName", getMiName())
            .append("nameSuffix", getNameSuffix())
            .append("emailAddr", getEmailAddr())
            .append("progClassCode", getProgClassCode())
            .append("irgCode", getIrgCode())
            .append("irgFlexCode", getIrgFlexCode())
            .append("groupCode", getGroupCode())
            .append("irgRecommendationCode", getIrgRecommendationCode())
            .append("priorityScoreNum", getPriorityScoreNum())
            .append("irgPercentileNum", getIrgPercentileNum())
            .append("irgPercentileRefCode", getIrgPercentileRefCode())
            .append("humanSubjectCode", getHumanSubjectCode())
            .append("animalSubjectsCode", getAnimalSubjectsCode())
            .append("aidsRelatedCode", getAidsRelatedCode())
            .append("genderClinicalStudyCode", getGenderClinicalStudyCode())
            .append("minorityClinicalStudyCode", getMinorityClinicalStudyCode())
            .append("applStatusGroupCode", getApplStatusGroupCode())
            .append("applStatusGroupDescrip", getApplStatusGroupDescrip())
            .append("fy", getFy())
            .append("childClinicalStudyCode", getChildClinicalStudyCode())
            .append("animalSubjectAssuranceNum", getAnimalSubjectAssuranceNum())
            .append("animalSubjectIacucDate", getAnimalSubjectIacucDate())
            .append("applReceivedDate", getApplReceivedDate())
            .append("applStatusCode", getApplStatusCode())
            .append("awdNoticeIssuedDate", getAwdNoticeIssuedDate())
            .append("councilRecomCode", getCouncilRecomCode())
            .append("createdDate", getCreatedDate())
            .append("creatorId", getCreatorId())
            .append("currAwdNoticeIssueDatetime", getCurrAwdNoticeIssueDatetime())
            .append("directCostRequestedAmt", getDirectCostRequestedAmt())
            .append("ein", getEin())
            .append("expandedAuthoritiesCode", getExpandedAuthoritiesCode())
            .append("expeditedReviewCode", getExpeditedReviewCode())
            .append("fedDemoProjectCode", getFedDemoProjectCode())
            .append("humanSubjectAssuranceNum", getHumanSubjectAssuranceNum())
            .append("humanSubjectIrbDate", getHumanSubjectIrbDate())
            .append("indirectCostRequestedAmt", getIndirectCostRequestedAmt())
            .append("initEncumbranceDate", getInitEncumbranceDate())
            .append("lastAwdNoticeIssueDatetime", getLastAwdNoticeIssueDatetime())
            .append("lastUpdDate", getLastUpdDate())
            .append("lastUpdId", getLastUpdId())
            .append("latestEncumbranceDate", getLatestEncumbranceDate())
            .append("outYearsNum", getOutYearsNum())
            .append("specialDispCode", getSpecialDispCode())
            .append("suppTypeCode", getSuppTypeCode())
            .append("totalCostRequestedAmt", getTotalCostRequestedAmt())
            .append("totalCostRequestedYear1Amt", getTotalCostRequestedYear1Amt())
            .append("line1Addr", getLine1Addr())
            .append("line2Addr", getLine2Addr())
            .append("line3Addr", getLine3Addr())
            .append("line4Addr", getLine4Addr())
            .append("line5Addr", getLine5Addr())
            .append("activationDate", getActivationDate())
            .append("cofundingIndicatorCode", getCofundingIndicatorCode())
            .append("foreignApplCode", getForeignApplCode())
            .append("fundingRecommendedCode", getFundingRecommendedCode())
            .append("groupExtCode", getGroupExtCode())
            .append("icdDispCode", getIcdDispCode())
            .append("icdSpecialCode", getIcdSpecialCode())
            .append("icdSpecialCodeCmnt", getIcdSpecialCodeCmnt())
            .append("intentToPayCode", getIntentToPayCode())
            .append("otherCountryCode", getOtherCountryCode())
            .append("snapIndicatorCode", getSnapIndicatorCode())
            .append("specialConsiderCode", getSpecialConsiderCode())
            .append("sraDesignatorCode", getSraDesignatorCode())
            .append("sraFlexCode", getSraFlexCode())
            .append("transferStatusCode", getTransferStatusCode())
            .append("wipStatusCode", getWipStatusCode())
            .append("cityName", getCityName())
            .append("faxNum", getFaxNum())
            .append("phoneExtensionNum", getPhoneExtensionNum())
            .append("phoneNum", getPhoneNum())
            .append("stateCode", getStateCode())
            .append("zipCode", getZipCode())
            .append("aaInstnTypeCode", getAaInstnTypeCode())
            .append("caIcdRspnsbltyCode", getCaIcdRspnsbltyCode())
            .append("specialSuppCode", getSpecialSuppCode())
            .append("trackingExceptionCode", getTrackingExceptionCode())
            .append("institutionState", getInstitutionState())
            .append("institutionCity", getInstitutionCity())
            .append("grantId", getGrantId())
            .append("piName", getPiName())
            .append("piNameF", getPiNameF())
            .append("legacySourceFile", getLegacySourceFile())
            .append("createDate", getCreateDate())
            .append("lastChangeDate", getLastChangeDate())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof PvGrantPiT) ) return false;
        PvGrantPiT castOther = (PvGrantPiT) other;
        return new EqualsBuilder()
            .append(this.getApplId(), castOther.getApplId())
            .append(this.getFullGrantNum(), castOther.getFullGrantNum())
            .append(this.getApplTypeCode(), castOther.getApplTypeCode())
            .append(this.getActivityCode(), castOther.getActivityCode())
            .append(this.getAdminPhsOrgCode(), castOther.getAdminPhsOrgCode())
            .append(this.getSerialNum(), castOther.getSerialNum())
            .append(this.getSupportYear(), castOther.getSupportYear())
            .append(this.getSuffixCode(), castOther.getSuffixCode())
            .append(this.getProjectTitle(), castOther.getProjectTitle())
            .append(this.getFormerNum(), castOther.getFormerNum())
            .append(this.getRfaPaNumber(), castOther.getRfaPaNumber())
            .append(this.getCouncilMeetingDate(), castOther.getCouncilMeetingDate())
            .append(this.getExternalOrgId(), castOther.getExternalOrgId())
            .append(this.getOrgName(), castOther.getOrgName())
            .append(this.getProjectPeriodStartDate(), castOther.getProjectPeriodStartDate())
            .append(this.getProjectPeriodEndDate(), castOther.getProjectPeriodEndDate())
            .append(this.getBudgetStartDate(), castOther.getBudgetStartDate())
            .append(this.getBudgetEndDate(), castOther.getBudgetEndDate())
            .append(this.getPersonId(), castOther.getPersonId())
            .append(this.getNamePrefix(), castOther.getNamePrefix())
            .append(this.getLastName(), castOther.getLastName())
            .append(this.getFirstName(), castOther.getFirstName())
            .append(this.getMiName(), castOther.getMiName())
            .append(this.getNameSuffix(), castOther.getNameSuffix())
            .append(this.getEmailAddr(), castOther.getEmailAddr())
            .append(this.getProgClassCode(), castOther.getProgClassCode())
            .append(this.getIrgCode(), castOther.getIrgCode())
            .append(this.getIrgFlexCode(), castOther.getIrgFlexCode())
            .append(this.getGroupCode(), castOther.getGroupCode())
            .append(this.getIrgRecommendationCode(), castOther.getIrgRecommendationCode())
            .append(this.getPriorityScoreNum(), castOther.getPriorityScoreNum())
            .append(this.getIrgPercentileNum(), castOther.getIrgPercentileNum())
            .append(this.getIrgPercentileRefCode(), castOther.getIrgPercentileRefCode())
            .append(this.getHumanSubjectCode(), castOther.getHumanSubjectCode())
            .append(this.getAnimalSubjectsCode(), castOther.getAnimalSubjectsCode())
            .append(this.getAidsRelatedCode(), castOther.getAidsRelatedCode())
            .append(this.getGenderClinicalStudyCode(), castOther.getGenderClinicalStudyCode())
            .append(this.getMinorityClinicalStudyCode(), castOther.getMinorityClinicalStudyCode())
            .append(this.getApplStatusGroupCode(), castOther.getApplStatusGroupCode())
            .append(this.getApplStatusGroupDescrip(), castOther.getApplStatusGroupDescrip())
            .append(this.getFy(), castOther.getFy())
            .append(this.getChildClinicalStudyCode(), castOther.getChildClinicalStudyCode())
            .append(this.getAnimalSubjectAssuranceNum(), castOther.getAnimalSubjectAssuranceNum())
            .append(this.getAnimalSubjectIacucDate(), castOther.getAnimalSubjectIacucDate())
            .append(this.getApplReceivedDate(), castOther.getApplReceivedDate())
            .append(this.getApplStatusCode(), castOther.getApplStatusCode())
            .append(this.getAwdNoticeIssuedDate(), castOther.getAwdNoticeIssuedDate())
            .append(this.getCouncilRecomCode(), castOther.getCouncilRecomCode())
            .append(this.getCreatedDate(), castOther.getCreatedDate())
            .append(this.getCreatorId(), castOther.getCreatorId())
            .append(this.getCurrAwdNoticeIssueDatetime(), castOther.getCurrAwdNoticeIssueDatetime())
            .append(this.getDirectCostRequestedAmt(), castOther.getDirectCostRequestedAmt())
            .append(this.getEin(), castOther.getEin())
            .append(this.getExpandedAuthoritiesCode(), castOther.getExpandedAuthoritiesCode())
            .append(this.getExpeditedReviewCode(), castOther.getExpeditedReviewCode())
            .append(this.getFedDemoProjectCode(), castOther.getFedDemoProjectCode())
            .append(this.getHumanSubjectAssuranceNum(), castOther.getHumanSubjectAssuranceNum())
            .append(this.getHumanSubjectIrbDate(), castOther.getHumanSubjectIrbDate())
            .append(this.getIndirectCostRequestedAmt(), castOther.getIndirectCostRequestedAmt())
            .append(this.getInitEncumbranceDate(), castOther.getInitEncumbranceDate())
            .append(this.getLastAwdNoticeIssueDatetime(), castOther.getLastAwdNoticeIssueDatetime())
            .append(this.getLastUpdDate(), castOther.getLastUpdDate())
            .append(this.getLastUpdId(), castOther.getLastUpdId())
            .append(this.getLatestEncumbranceDate(), castOther.getLatestEncumbranceDate())
            .append(this.getOutYearsNum(), castOther.getOutYearsNum())
            .append(this.getSpecialDispCode(), castOther.getSpecialDispCode())
            .append(this.getSuppTypeCode(), castOther.getSuppTypeCode())
            .append(this.getTotalCostRequestedAmt(), castOther.getTotalCostRequestedAmt())
            .append(this.getTotalCostRequestedYear1Amt(), castOther.getTotalCostRequestedYear1Amt())
            .append(this.getLine1Addr(), castOther.getLine1Addr())
            .append(this.getLine2Addr(), castOther.getLine2Addr())
            .append(this.getLine3Addr(), castOther.getLine3Addr())
            .append(this.getLine4Addr(), castOther.getLine4Addr())
            .append(this.getLine5Addr(), castOther.getLine5Addr())
            .append(this.getActivationDate(), castOther.getActivationDate())
            .append(this.getCofundingIndicatorCode(), castOther.getCofundingIndicatorCode())
            .append(this.getForeignApplCode(), castOther.getForeignApplCode())
            .append(this.getFundingRecommendedCode(), castOther.getFundingRecommendedCode())
            .append(this.getGroupExtCode(), castOther.getGroupExtCode())
            .append(this.getIcdDispCode(), castOther.getIcdDispCode())
            .append(this.getIcdSpecialCode(), castOther.getIcdSpecialCode())
            .append(this.getIcdSpecialCodeCmnt(), castOther.getIcdSpecialCodeCmnt())
            .append(this.getIntentToPayCode(), castOther.getIntentToPayCode())
            .append(this.getOtherCountryCode(), castOther.getOtherCountryCode())
            .append(this.getSnapIndicatorCode(), castOther.getSnapIndicatorCode())
            .append(this.getSpecialConsiderCode(), castOther.getSpecialConsiderCode())
            .append(this.getSraDesignatorCode(), castOther.getSraDesignatorCode())
            .append(this.getSraFlexCode(), castOther.getSraFlexCode())
            .append(this.getTransferStatusCode(), castOther.getTransferStatusCode())
            .append(this.getWipStatusCode(), castOther.getWipStatusCode())
            .append(this.getCityName(), castOther.getCityName())
            .append(this.getFaxNum(), castOther.getFaxNum())
            .append(this.getPhoneExtensionNum(), castOther.getPhoneExtensionNum())
            .append(this.getPhoneNum(), castOther.getPhoneNum())
            .append(this.getStateCode(), castOther.getStateCode())
            .append(this.getZipCode(), castOther.getZipCode())
            .append(this.getAaInstnTypeCode(), castOther.getAaInstnTypeCode())
            .append(this.getCaIcdRspnsbltyCode(), castOther.getCaIcdRspnsbltyCode())
            .append(this.getSpecialSuppCode(), castOther.getSpecialSuppCode())
            .append(this.getTrackingExceptionCode(), castOther.getTrackingExceptionCode())
            .append(this.getInstitutionState(), castOther.getInstitutionState())
            .append(this.getInstitutionCity(), castOther.getInstitutionCity())
            .append(this.getGrantId(), castOther.getGrantId())
            .append(this.getPiName(), castOther.getPiName())
            .append(this.getPiNameF(), castOther.getPiNameF())
            .append(this.getLegacySourceFile(), castOther.getLegacySourceFile())
            .append(this.getCreateDate(), castOther.getCreateDate())
            .append(this.getLastChangeDate(), castOther.getLastChangeDate())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getApplId())
            .append(getFullGrantNum())
            .append(getApplTypeCode())
            .append(getActivityCode())
            .append(getAdminPhsOrgCode())
            .append(getSerialNum())
            .append(getSupportYear())
            .append(getSuffixCode())
            .append(getProjectTitle())
            .append(getFormerNum())
            .append(getRfaPaNumber())
            .append(getCouncilMeetingDate())
            .append(getExternalOrgId())
            .append(getOrgName())
            .append(getProjectPeriodStartDate())
            .append(getProjectPeriodEndDate())
            .append(getBudgetStartDate())
            .append(getBudgetEndDate())
            .append(getPersonId())
            .append(getNamePrefix())
            .append(getLastName())
            .append(getFirstName())
            .append(getMiName())
            .append(getNameSuffix())
            .append(getEmailAddr())
            .append(getProgClassCode())
            .append(getIrgCode())
            .append(getIrgFlexCode())
            .append(getGroupCode())
            .append(getIrgRecommendationCode())
            .append(getPriorityScoreNum())
            .append(getIrgPercentileNum())
            .append(getIrgPercentileRefCode())
            .append(getHumanSubjectCode())
            .append(getAnimalSubjectsCode())
            .append(getAidsRelatedCode())
            .append(getGenderClinicalStudyCode())
            .append(getMinorityClinicalStudyCode())
            .append(getApplStatusGroupCode())
            .append(getApplStatusGroupDescrip())
            .append(getFy())
            .append(getChildClinicalStudyCode())
            .append(getAnimalSubjectAssuranceNum())
            .append(getAnimalSubjectIacucDate())
            .append(getApplReceivedDate())
            .append(getApplStatusCode())
            .append(getAwdNoticeIssuedDate())
            .append(getCouncilRecomCode())
            .append(getCreatedDate())
            .append(getCreatorId())
            .append(getCurrAwdNoticeIssueDatetime())
            .append(getDirectCostRequestedAmt())
            .append(getEin())
            .append(getExpandedAuthoritiesCode())
            .append(getExpeditedReviewCode())
            .append(getFedDemoProjectCode())
            .append(getHumanSubjectAssuranceNum())
            .append(getHumanSubjectIrbDate())
            .append(getIndirectCostRequestedAmt())
            .append(getInitEncumbranceDate())
            .append(getLastAwdNoticeIssueDatetime())
            .append(getLastUpdDate())
            .append(getLastUpdId())
            .append(getLatestEncumbranceDate())
            .append(getOutYearsNum())
            .append(getSpecialDispCode())
            .append(getSuppTypeCode())
            .append(getTotalCostRequestedAmt())
            .append(getTotalCostRequestedYear1Amt())
            .append(getLine1Addr())
            .append(getLine2Addr())
            .append(getLine3Addr())
            .append(getLine4Addr())
            .append(getLine5Addr())
            .append(getActivationDate())
            .append(getCofundingIndicatorCode())
            .append(getForeignApplCode())
            .append(getFundingRecommendedCode())
            .append(getGroupExtCode())
            .append(getIcdDispCode())
            .append(getIcdSpecialCode())
            .append(getIcdSpecialCodeCmnt())
            .append(getIntentToPayCode())
            .append(getOtherCountryCode())
            .append(getSnapIndicatorCode())
            .append(getSpecialConsiderCode())
            .append(getSraDesignatorCode())
            .append(getSraFlexCode())
            .append(getTransferStatusCode())
            .append(getWipStatusCode())
            .append(getCityName())
            .append(getFaxNum())
            .append(getPhoneExtensionNum())
            .append(getPhoneNum())
            .append(getStateCode())
            .append(getZipCode())
            .append(getAaInstnTypeCode())
            .append(getCaIcdRspnsbltyCode())
            .append(getSpecialSuppCode())
            .append(getTrackingExceptionCode())
            .append(getInstitutionState())
            .append(getInstitutionCity())
            .append(getGrantId())
            .append(getPiName())
            .append(getPiNameF())
            .append(getLegacySourceFile())
            .append(getCreateDate())
            .append(getLastChangeDate())
            .toHashCode();
    }

}
