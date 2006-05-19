package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class NciApplElementsT implements Serializable {

    /** identifier field */
    private Long applApplId;

    /** persistent field */
    private String aidsFlag;

    /** persistent field */
    private String porFlag;

    /** persistent field */
    private String araFlag;

    /** persistent field */
    private String bmmCcrCode;

    /** persistent field */
    private String bmmScnCode;

    /** persistent field */
    private String bmmCode;

    /** persistent field */
    private BigDecimal estimatedIdcRate;

    /** nullable persistent field */
    private Long ifaId;

    /** nullable persistent field */
    private String ncpCode;

    /** nullable persistent field */
    private BigDecimal basicPercentage;

    /** nullable persistent field */
    private BigDecimal appliedPercentage;

    /** nullable persistent field */
    private BigDecimal developmentalPercentage;

    /** nullable persistent field */
    private String foreignInvolvementFlag;

    /** nullable persistent field */
    private Date applLevel1SignDate;

    /** nullable persistent field */
    private Date applLevel2SignDate;

    /** nullable persistent field */
    private String justInTimeFlag;

    /** nullable persistent field */
    private String lastChangeUserId;

    /** nullable persistent field */
    private Date lastChangeDate;

    /** persistent field */
    private String createUserId;

    /** persistent field */
    private Date createDate;

    /** nullable persistent field */
    private Integer updateStamp;

    /** nullable persistent field */
    private String overrideBmmFlag;

    /** nullable persistent field */
    private Date gabReceiptDate;

    /** nullable persistent field */
    private Long tcsAmt;

    /** nullable persistent field */
    private Long tcs1stFutYrAmt;

    /** nullable persistent field */
    private Long tcs2ndFutYrAmt;

    /** nullable persistent field */
    private Long tcs3rdFutYrAmt;

    /** nullable persistent field */
    private Long tcs4thFutYrAmt;

    /** nullable persistent field */
    private BigDecimal oerCnt;

    /** nullable persistent field */
    private String oerCntOverrideFlag;

    /** nullable persistent field */
    private String prevCouncilMeetingDate;

    /** nullable persistent field */
    private String impacIiDeletedFlag;

    /** nullable persistent field */
    private String prevFullGrantNum;

    /** persistent field */
    private String minSuppFlag;

    /** nullable persistent field */
    private String traineeSuppTypeCode;

    /** persistent field */
    private gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT nciPersonOrgRolesTByApplLevel2Id;

    /** persistent field */
    private gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT nciPersonOrgRolesTByApplLevel1Id;

    /** persistent field */
    private Set applProcessStatusesTs;

    /** persistent field */
    private Set applCancerActivityPocsTs;

    /** full constructor */
    public NciApplElementsT(Long applApplId, String aidsFlag, String porFlag, String araFlag, String bmmCcrCode, String bmmScnCode, String bmmCode, BigDecimal estimatedIdcRate, Long ifaId, String ncpCode, BigDecimal basicPercentage, BigDecimal appliedPercentage, BigDecimal developmentalPercentage, String foreignInvolvementFlag, Date applLevel1SignDate, Date applLevel2SignDate, String justInTimeFlag, String lastChangeUserId, Date lastChangeDate, String createUserId, Date createDate, Integer updateStamp, String overrideBmmFlag, Date gabReceiptDate, Long tcsAmt, Long tcs1stFutYrAmt, Long tcs2ndFutYrAmt, Long tcs3rdFutYrAmt, Long tcs4thFutYrAmt, BigDecimal oerCnt, String oerCntOverrideFlag, String prevCouncilMeetingDate, String impacIiDeletedFlag, String prevFullGrantNum, String minSuppFlag, String traineeSuppTypeCode, gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT nciPersonOrgRolesTByApplLevel2Id, gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT nciPersonOrgRolesTByApplLevel1Id, Set applProcessStatusesTs, Set applCancerActivityPocsTs) {
        this.applApplId = applApplId;
        this.aidsFlag = aidsFlag;
        this.porFlag = porFlag;
        this.araFlag = araFlag;
        this.bmmCcrCode = bmmCcrCode;
        this.bmmScnCode = bmmScnCode;
        this.bmmCode = bmmCode;
        this.estimatedIdcRate = estimatedIdcRate;
        this.ifaId = ifaId;
        this.ncpCode = ncpCode;
        this.basicPercentage = basicPercentage;
        this.appliedPercentage = appliedPercentage;
        this.developmentalPercentage = developmentalPercentage;
        this.foreignInvolvementFlag = foreignInvolvementFlag;
        this.applLevel1SignDate = applLevel1SignDate;
        this.applLevel2SignDate = applLevel2SignDate;
        this.justInTimeFlag = justInTimeFlag;
        this.lastChangeUserId = lastChangeUserId;
        this.lastChangeDate = lastChangeDate;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.updateStamp = updateStamp;
        this.overrideBmmFlag = overrideBmmFlag;
        this.gabReceiptDate = gabReceiptDate;
        this.tcsAmt = tcsAmt;
        this.tcs1stFutYrAmt = tcs1stFutYrAmt;
        this.tcs2ndFutYrAmt = tcs2ndFutYrAmt;
        this.tcs3rdFutYrAmt = tcs3rdFutYrAmt;
        this.tcs4thFutYrAmt = tcs4thFutYrAmt;
        this.oerCnt = oerCnt;
        this.oerCntOverrideFlag = oerCntOverrideFlag;
        this.prevCouncilMeetingDate = prevCouncilMeetingDate;
        this.impacIiDeletedFlag = impacIiDeletedFlag;
        this.prevFullGrantNum = prevFullGrantNum;
        this.minSuppFlag = minSuppFlag;
        this.traineeSuppTypeCode = traineeSuppTypeCode;
        this.nciPersonOrgRolesTByApplLevel2Id = nciPersonOrgRolesTByApplLevel2Id;
        this.nciPersonOrgRolesTByApplLevel1Id = nciPersonOrgRolesTByApplLevel1Id;
        this.applProcessStatusesTs = applProcessStatusesTs;
        this.applCancerActivityPocsTs = applCancerActivityPocsTs;
    }

    /** default constructor */
    public NciApplElementsT() {
    }

    /** minimal constructor */
    public NciApplElementsT(Long applApplId, String aidsFlag, String porFlag, String araFlag, String bmmCcrCode, String bmmScnCode, String bmmCode, BigDecimal estimatedIdcRate, String createUserId, Date createDate, String minSuppFlag, gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT nciPersonOrgRolesTByApplLevel2Id, gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT nciPersonOrgRolesTByApplLevel1Id, Set applProcessStatusesTs, Set applCancerActivityPocsTs) {
        this.applApplId = applApplId;
        this.aidsFlag = aidsFlag;
        this.porFlag = porFlag;
        this.araFlag = araFlag;
        this.bmmCcrCode = bmmCcrCode;
        this.bmmScnCode = bmmScnCode;
        this.bmmCode = bmmCode;
        this.estimatedIdcRate = estimatedIdcRate;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.minSuppFlag = minSuppFlag;
        this.nciPersonOrgRolesTByApplLevel2Id = nciPersonOrgRolesTByApplLevel2Id;
        this.nciPersonOrgRolesTByApplLevel1Id = nciPersonOrgRolesTByApplLevel1Id;
        this.applProcessStatusesTs = applProcessStatusesTs;
        this.applCancerActivityPocsTs = applCancerActivityPocsTs;
    }

    public Long getApplApplId() {
        return this.applApplId;
    }

    public void setApplApplId(Long applApplId) {
        this.applApplId = applApplId;
    }

    public String getAidsFlag() {
        return this.aidsFlag;
    }

    public void setAidsFlag(String aidsFlag) {
        this.aidsFlag = aidsFlag;
    }

    public String getPorFlag() {
        return this.porFlag;
    }

    public void setPorFlag(String porFlag) {
        this.porFlag = porFlag;
    }

    public String getAraFlag() {
        return this.araFlag;
    }

    public void setAraFlag(String araFlag) {
        this.araFlag = araFlag;
    }

    public String getBmmCcrCode() {
        return this.bmmCcrCode;
    }

    public void setBmmCcrCode(String bmmCcrCode) {
        this.bmmCcrCode = bmmCcrCode;
    }

    public String getBmmScnCode() {
        return this.bmmScnCode;
    }

    public void setBmmScnCode(String bmmScnCode) {
        this.bmmScnCode = bmmScnCode;
    }

    public String getBmmCode() {
        return this.bmmCode;
    }

    public void setBmmCode(String bmmCode) {
        this.bmmCode = bmmCode;
    }

    public BigDecimal getEstimatedIdcRate() {
        return this.estimatedIdcRate;
    }

    public void setEstimatedIdcRate(BigDecimal estimatedIdcRate) {
        this.estimatedIdcRate = estimatedIdcRate;
    }

    public Long getIfaId() {
        return this.ifaId;
    }

    public void setIfaId(Long ifaId) {
        this.ifaId = ifaId;
    }

    public String getNcpCode() {
        return this.ncpCode;
    }

    public void setNcpCode(String ncpCode) {
        this.ncpCode = ncpCode;
    }

    public BigDecimal getBasicPercentage() {
        return this.basicPercentage;
    }

    public void setBasicPercentage(BigDecimal basicPercentage) {
        this.basicPercentage = basicPercentage;
    }

    public BigDecimal getAppliedPercentage() {
        return this.appliedPercentage;
    }

    public void setAppliedPercentage(BigDecimal appliedPercentage) {
        this.appliedPercentage = appliedPercentage;
    }

    public BigDecimal getDevelopmentalPercentage() {
        return this.developmentalPercentage;
    }

    public void setDevelopmentalPercentage(BigDecimal developmentalPercentage) {
        this.developmentalPercentage = developmentalPercentage;
    }

    public String getForeignInvolvementFlag() {
        return this.foreignInvolvementFlag;
    }

    public void setForeignInvolvementFlag(String foreignInvolvementFlag) {
        this.foreignInvolvementFlag = foreignInvolvementFlag;
    }

    public Date getApplLevel1SignDate() {
        return this.applLevel1SignDate;
    }

    public void setApplLevel1SignDate(Date applLevel1SignDate) {
        this.applLevel1SignDate = applLevel1SignDate;
    }

    public Date getApplLevel2SignDate() {
        return this.applLevel2SignDate;
    }

    public void setApplLevel2SignDate(Date applLevel2SignDate) {
        this.applLevel2SignDate = applLevel2SignDate;
    }

    public String getJustInTimeFlag() {
        return this.justInTimeFlag;
    }

    public void setJustInTimeFlag(String justInTimeFlag) {
        this.justInTimeFlag = justInTimeFlag;
    }

    public String getLastChangeUserId() {
        return this.lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
    }

    public Date getLastChangeDate() {
        return this.lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdateStamp() {
        return this.updateStamp;
    }

    public void setUpdateStamp(Integer updateStamp) {
        this.updateStamp = updateStamp;
    }

    public String getOverrideBmmFlag() {
        return this.overrideBmmFlag;
    }

    public void setOverrideBmmFlag(String overrideBmmFlag) {
        this.overrideBmmFlag = overrideBmmFlag;
    }

    public Date getGabReceiptDate() {
        return this.gabReceiptDate;
    }

    public void setGabReceiptDate(Date gabReceiptDate) {
        this.gabReceiptDate = gabReceiptDate;
    }

    public Long getTcsAmt() {
        return this.tcsAmt;
    }

    public void setTcsAmt(Long tcsAmt) {
        this.tcsAmt = tcsAmt;
    }

    public Long getTcs1stFutYrAmt() {
        return this.tcs1stFutYrAmt;
    }

    public void setTcs1stFutYrAmt(Long tcs1stFutYrAmt) {
        this.tcs1stFutYrAmt = tcs1stFutYrAmt;
    }

    public Long getTcs2ndFutYrAmt() {
        return this.tcs2ndFutYrAmt;
    }

    public void setTcs2ndFutYrAmt(Long tcs2ndFutYrAmt) {
        this.tcs2ndFutYrAmt = tcs2ndFutYrAmt;
    }

    public Long getTcs3rdFutYrAmt() {
        return this.tcs3rdFutYrAmt;
    }

    public void setTcs3rdFutYrAmt(Long tcs3rdFutYrAmt) {
        this.tcs3rdFutYrAmt = tcs3rdFutYrAmt;
    }

    public Long getTcs4thFutYrAmt() {
        return this.tcs4thFutYrAmt;
    }

    public void setTcs4thFutYrAmt(Long tcs4thFutYrAmt) {
        this.tcs4thFutYrAmt = tcs4thFutYrAmt;
    }

    public BigDecimal getOerCnt() {
        return this.oerCnt;
    }

    public void setOerCnt(BigDecimal oerCnt) {
        this.oerCnt = oerCnt;
    }

    public String getOerCntOverrideFlag() {
        return this.oerCntOverrideFlag;
    }

    public void setOerCntOverrideFlag(String oerCntOverrideFlag) {
        this.oerCntOverrideFlag = oerCntOverrideFlag;
    }

    public String getPrevCouncilMeetingDate() {
        return this.prevCouncilMeetingDate;
    }

    public void setPrevCouncilMeetingDate(String prevCouncilMeetingDate) {
        this.prevCouncilMeetingDate = prevCouncilMeetingDate;
    }

    public String getImpacIiDeletedFlag() {
        return this.impacIiDeletedFlag;
    }

    public void setImpacIiDeletedFlag(String impacIiDeletedFlag) {
        this.impacIiDeletedFlag = impacIiDeletedFlag;
    }

    public String getPrevFullGrantNum() {
        return this.prevFullGrantNum;
    }

    public void setPrevFullGrantNum(String prevFullGrantNum) {
        this.prevFullGrantNum = prevFullGrantNum;
    }

    public String getMinSuppFlag() {
        return this.minSuppFlag;
    }

    public void setMinSuppFlag(String minSuppFlag) {
        this.minSuppFlag = minSuppFlag;
    }

    public String getTraineeSuppTypeCode() {
        return this.traineeSuppTypeCode;
    }

    public void setTraineeSuppTypeCode(String traineeSuppTypeCode) {
        this.traineeSuppTypeCode = traineeSuppTypeCode;
    }

    public gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT getNciPersonOrgRolesTByApplLevel2Id() {
        return this.nciPersonOrgRolesTByApplLevel2Id;
    }

    public void setNciPersonOrgRolesTByApplLevel2Id(gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT nciPersonOrgRolesTByApplLevel2Id) {
        this.nciPersonOrgRolesTByApplLevel2Id = nciPersonOrgRolesTByApplLevel2Id;
    }

    public gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT getNciPersonOrgRolesTByApplLevel1Id() {
        return this.nciPersonOrgRolesTByApplLevel1Id;
    }

    public void setNciPersonOrgRolesTByApplLevel1Id(gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT nciPersonOrgRolesTByApplLevel1Id) {
        this.nciPersonOrgRolesTByApplLevel1Id = nciPersonOrgRolesTByApplLevel1Id;
    }

    public Set getApplProcessStatusesTs() {
        return this.applProcessStatusesTs;
    }

    public void setApplProcessStatusesTs(Set applProcessStatusesTs) {
        this.applProcessStatusesTs = applProcessStatusesTs;
    }

    public Set getApplCancerActivityPocsTs() {
        return this.applCancerActivityPocsTs;
    }

    public void setApplCancerActivityPocsTs(Set applCancerActivityPocsTs) {
        this.applCancerActivityPocsTs = applCancerActivityPocsTs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("applApplId", getApplApplId())
            .toString();
    }

}
