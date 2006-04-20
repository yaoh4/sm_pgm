package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ProcessStatusesT implements Serializable {

    /** identifier field */
    private Long nonId;

    /** identifier field */
    private String code;

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

    /** persistent field */
    private Set applProcessStatusesTs;

    /** full constructor */
    public ProcessStatusesT(Long nonId, String code, String createUserId, Date createDate, String lastChangeUserId, Date lastChangeDate, Integer updateStamp, Set applProcessStatusesTs) {

        this.nonId = nonId;
        this.code = code;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.lastChangeUserId = lastChangeUserId;
        this.lastChangeDate = lastChangeDate;
        this.updateStamp = updateStamp;
        this.applProcessStatusesTs = applProcessStatusesTs;
    }

    /** default constructor */
    public ProcessStatusesT() {
    }

    /** minimal constructor */
    public ProcessStatusesT(Long nonId, String code, String createUserId, Date createDate, Set applProcessStatusesTs) {
        this.nonId = nonId;
        this.code = code;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.applProcessStatusesTs = applProcessStatusesTs;
    }

    public Long getNonId() {
        return this.nonId;
    }

    public void setNonId(Long nonId) {
        this.nonId = nonId;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Set getApplProcessStatusesTs() {
        return this.applProcessStatusesTs;
    }

    public void setApplProcessStatusesTs(Set applProcessStatusesTs) {
        this.applProcessStatusesTs = applProcessStatusesTs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("nonId", getNonId())
            .append("code", getCode())
            .append("createUserId", getCreateUserId())
            .append("createDate", getCreateDate())
            .append("lastChangeUserId", getLastChangeUserId())
            //.append("updateStamp", getUpdateStamp())
            //.append("applProcessStatusesTs", getApplProcessStatusesTs())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ProcessStatusesT) ) return false;
        ProcessStatusesT castOther = (ProcessStatusesT) other;
        return new EqualsBuilder()
            .append(this.getNonId(), castOther.getNonId())
            .append(this.getCode(), castOther.getCode())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getNonId())
            .append(getCode())
            .toHashCode();
    }

}
