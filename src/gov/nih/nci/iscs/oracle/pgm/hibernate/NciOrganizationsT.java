package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class NciOrganizationsT implements Serializable {

    /** identifier field */
    private long id;

    /** identifier field */
    private String abbreviation;

    /** identifier field */
    private String description;

    /** identifier field */
    private String nihAdminCode;

    /** identifier field */
    private String noeOrgType;

    /** identifier field */
    private Long parentOrgId;

    /** identifier field */
    private String commonEmailAddr;

    /** identifier field */
    private String createUserId;

    /** identifier field */
    private Date createDate;

    /** identifier field */
    private String lastChangeUserId;

    /** identifier field */
    private Date lastChangeDate;

    /** identifier field */
    private Integer updateStamp;

    /** identifier field */
    private String verifiedFlag;

    /** identifier field */
    private Date verifiedDate;

    /** identifier field */
    private Object ardEntry;

    /** identifier field */
    private Date inactiveDate;

    /** full constructor */
    public NciOrganizationsT(long id, String abbreviation, String description, String nihAdminCode, String noeOrgType, Long parentOrgId, String commonEmailAddr, String createUserId, Date createDate, String lastChangeUserId, Date lastChangeDate, Integer updateStamp, String verifiedFlag, Date verifiedDate, Object ardEntry, Date inactiveDate) {
        this.id = id;
        this.abbreviation = abbreviation;
        this.description = description;
        this.nihAdminCode = nihAdminCode;
        this.noeOrgType = noeOrgType;
        this.parentOrgId = parentOrgId;
        this.commonEmailAddr = commonEmailAddr;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.lastChangeUserId = lastChangeUserId;
        this.lastChangeDate = lastChangeDate;
        this.updateStamp = updateStamp;
        this.verifiedFlag = verifiedFlag;
        this.verifiedDate = verifiedDate;
        this.ardEntry = ardEntry;
        this.inactiveDate = inactiveDate;
    }

    /** default constructor */
    public NciOrganizationsT() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNihAdminCode() {
        return this.nihAdminCode;
    }

    public void setNihAdminCode(String nihAdminCode) {
        this.nihAdminCode = nihAdminCode;
    }

    public String getNoeOrgType() {
        return this.noeOrgType;
    }

    public void setNoeOrgType(String noeOrgType) {
        this.noeOrgType = noeOrgType;
    }

    public Long getParentOrgId() {
        return this.parentOrgId;
    }

    public void setParentOrgId(Long parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public String getCommonEmailAddr() {
        return this.commonEmailAddr;
    }

    public void setCommonEmailAddr(String commonEmailAddr) {
        this.commonEmailAddr = commonEmailAddr;
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

    public Integer getUpdateStamp() {
        return this.updateStamp;
    }

    public void setUpdateStamp(Integer updateStamp) {
        this.updateStamp = updateStamp;
    }

    public String getVerifiedFlag() {
        return this.verifiedFlag;
    }

    public void setVerifiedFlag(String verifiedFlag) {
        this.verifiedFlag = verifiedFlag;
    }

    public Date getVerifiedDate() {
        return this.verifiedDate;
    }

    public void setVerifiedDate(Date verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    public Object getArdEntry() {
        return this.ardEntry;
    }

    public void setArdEntry(Object ardEntry) {
        this.ardEntry = ardEntry;
    }

    public Date getInactiveDate() {
        return this.inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .append("abbreviation", getAbbreviation())
            .append("description", getDescription())
            .append("nihAdminCode", getNihAdminCode())
            .append("noeOrgType", getNoeOrgType())
            .append("parentOrgId", getParentOrgId())
            .append("commonEmailAddr", getCommonEmailAddr())
            .append("createUserId", getCreateUserId())
            .append("createDate", getCreateDate())
            .append("lastChangeUserId", getLastChangeUserId())
            .append("lastChangeDate", getLastChangeDate())
            .append("updateStamp", getUpdateStamp())
            .append("verifiedFlag", getVerifiedFlag())
            .append("verifiedDate", getVerifiedDate())
            .append("ardEntry", getArdEntry())
            .append("inactiveDate", getInactiveDate())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof NciOrganizationsT) ) return false;
        NciOrganizationsT castOther = (NciOrganizationsT) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .append(this.getAbbreviation(), castOther.getAbbreviation())
            .append(this.getDescription(), castOther.getDescription())
            .append(this.getNihAdminCode(), castOther.getNihAdminCode())
            .append(this.getNoeOrgType(), castOther.getNoeOrgType())
            .append(this.getParentOrgId(), castOther.getParentOrgId())
            .append(this.getCommonEmailAddr(), castOther.getCommonEmailAddr())
            .append(this.getCreateUserId(), castOther.getCreateUserId())
            .append(this.getCreateDate(), castOther.getCreateDate())
            .append(this.getLastChangeUserId(), castOther.getLastChangeUserId())
            .append(this.getLastChangeDate(), castOther.getLastChangeDate())
            .append(this.getUpdateStamp(), castOther.getUpdateStamp())
            .append(this.getVerifiedFlag(), castOther.getVerifiedFlag())
            .append(this.getVerifiedDate(), castOther.getVerifiedDate())
            .append(this.getArdEntry(), castOther.getArdEntry())
            .append(this.getInactiveDate(), castOther.getInactiveDate())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .append(getAbbreviation())
            .append(getDescription())
            .append(getNihAdminCode())
            .append(getNoeOrgType())
            .append(getParentOrgId())
            .append(getCommonEmailAddr())
            .append(getCreateUserId())
            .append(getCreateDate())
            .append(getLastChangeUserId())
            .append(getLastChangeDate())
            .append(getUpdateStamp())
            .append(getVerifiedFlag())
            .append(getVerifiedDate())
            .append(getArdEntry())
            .append(getInactiveDate())
            .toHashCode();
    }

}
