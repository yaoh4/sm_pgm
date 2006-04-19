package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivitiesT;


/** @author Hibernate CodeGenerator */
public class ApplCancerActivitiesT implements Serializable {

    /** identifier field */
    private Long applId;

    /** identifier field */
    private Date startDate;

    /** nullable persistent field */
    private Date endDate;

    /** persistent field */
    private String createUserId;

    /** persistent field */
    private Date createDate;

    /** nullable persistent field */
    private String lastChangeUserId;

    /** nullable persistent field */
    private Date lastChangeDate;

    /** nullable persistent field */
    private Integer updateStamp;

    /** identifier field */
    private CancerActivitiesT cancerActivitiesT;

    /** full constructor */
    public ApplCancerActivitiesT(Long applId, Date startDate, Date endDate, String createUserId, Date createDate, String lastChangeUserId, Date lastChangeDate, Integer updateStamp, gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivitiesT cancerActivitiesT) {
        this.applId = applId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.lastChangeUserId = lastChangeUserId;
        this.lastChangeDate = lastChangeDate;
        this.updateStamp = updateStamp;
        this.cancerActivitiesT = cancerActivitiesT;

    }

    /** default constructor */
    public ApplCancerActivitiesT() {
    }

    /** minimal constructor */
    public ApplCancerActivitiesT(Long applId, Date startDate, String createUserId, Date createDate) {
        this.applId = applId;
        this.startDate = startDate;
        this.createUserId = createUserId;
        this.createDate = createDate;
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

    public gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivitiesT getCancerActivitiesT() {
        return this.cancerActivitiesT;
    }

    public void setCancerActivitiesT(gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivitiesT cancerActivitiesT) {
        this.cancerActivitiesT = cancerActivitiesT;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("applId", getApplId())
            .append("startDate", getStartDate())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ApplCancerActivitiesT) ) return false;
        ApplCancerActivitiesT castOther = (ApplCancerActivitiesT) other;
        return new EqualsBuilder()
            .append(this.getApplId(), castOther.getApplId())
            .append(this.getStartDate(), castOther.getStartDate())
            .append(this.getCancerActivitiesT(), castOther.getCancerActivitiesT())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getApplId())
            .append(getStartDate())
            .append(getCancerActivitiesT())
            .toHashCode();
    }

}
