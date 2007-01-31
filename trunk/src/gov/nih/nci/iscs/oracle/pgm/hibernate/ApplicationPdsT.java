package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ApplicationPdsT implements Serializable {

    /** identifier field */
    private Long npeId;

    /** identifier field */
    private Long applId;

    /** identifier field */
    private Date startDate;

    /** nullable persistent field */
    private Date endDate;

    /** persistent field */
    private Date createDate;

    /** persistent field */
    private String createUserId;

    /** nullable persistent field */
    private String lastChangeUserId;

    /** nullable persistent field */
    private Date lastChangeDate;

    /** nullable persistent field */
    private Integer updateStamp;

    /** full constructor */
    public ApplicationPdsT(Long npeId, Long applId, Date startDate, Date endDate, Date createDate, String createUserId, String lastChangeUserId, Date lastChangeDate, Integer updateStamp) {
        this.npeId = npeId;
        this.applId = applId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.lastChangeUserId = lastChangeUserId;
        this.lastChangeDate = lastChangeDate;
        this.updateStamp = updateStamp;
    }

    /** default constructor */
    public ApplicationPdsT() {
    }

    /** minimal constructor */
    public ApplicationPdsT(Long npeId, Long applId, Date startDate, Date createDate, String createUserId) {
        this.npeId = npeId;
        this.applId = applId;
        this.startDate = startDate;
        this.createDate = createDate;
        this.createUserId = createUserId;
    }

    public Long getNpeId() {
        return this.npeId;
    }

    public void setNpeId(Long npeId) {
        this.npeId = npeId;
    }

    public Long getApplId() {
        return this.applId;
    }

    public void setApplId(Long applId) {
        this.applId = applId;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("npeId", getNpeId())
            .append("applId", getApplId())
            .append("startDate", getStartDate())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ApplicationPdsT) ) return false;
        ApplicationPdsT castOther = (ApplicationPdsT) other;
        return new EqualsBuilder()
            .append(this.getNpeId(), castOther.getNpeId())
            .append(this.getApplId(), castOther.getApplId())
            .append(this.getStartDate(), castOther.getStartDate())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getNpeId())
            .append(getApplId())
            .append(getStartDate())
            .toHashCode();
    }

}
