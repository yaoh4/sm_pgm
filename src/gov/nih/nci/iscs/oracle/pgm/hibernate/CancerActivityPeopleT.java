package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CancerActivityPeopleT implements Serializable {

    /** identifier field */
    private long id;

    /** identifier field */
    private long npnId;

    /** identifier field */
    private Date startDate;

    /** identifier field */
    private Date endDate;

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

    /** persistent field */
    private gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivitiesT cancerActivitiesT;

    /** full constructor */
    public CancerActivityPeopleT(long id, long npnId, Date startDate, Date endDate, String createUserId, Date createDate, String lastChangeUserId, Date lastChangeDate, Integer updateStamp, gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivitiesT cancerActivitiesT) {
        this.id = id;
        this.npnId = npnId;
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
    public CancerActivityPeopleT() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNpnId() {
        return this.npnId;
    }

    public void setNpnId(long npnId) {
        this.npnId = npnId;
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
            .append("id", getId())
            .append("npnId", getNpnId())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("createUserId", getCreateUserId())
            .append("createDate", getCreateDate())
            .append("lastChangeUserId", getLastChangeUserId())
            .append("lastChangeDate", getLastChangeDate())
            .append("updateStamp", getUpdateStamp())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CancerActivityPeopleT) ) return false;
        CancerActivityPeopleT castOther = (CancerActivityPeopleT) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .append(this.getNpnId(), castOther.getNpnId())
            .append(this.getStartDate(), castOther.getStartDate())
            .append(this.getEndDate(), castOther.getEndDate())
            .append(this.getCreateUserId(), castOther.getCreateUserId())
            .append(this.getCreateDate(), castOther.getCreateDate())
            .append(this.getLastChangeUserId(), castOther.getLastChangeUserId())
            .append(this.getLastChangeDate(), castOther.getLastChangeDate())
            .append(this.getUpdateStamp(), castOther.getUpdateStamp())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .append(getNpnId())
            .append(getStartDate())
            .append(getEndDate())
            .append(getCreateUserId())
            .append(getCreateDate())
            .append(getLastChangeUserId())
            .append(getLastChangeDate())
            .append(getUpdateStamp())
            .toHashCode();
    }

}
