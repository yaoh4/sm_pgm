package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CancerActivitiesT implements Serializable {

    /** identifier field */
    private String code;

    /** persistent field */
    private String description;

    /** persistent field */
    private Date createDate;

    /** persistent field */
    private String createUserId;

    /** nullable persistent field */
    private Date lastChangeDate;

    /** nullable persistent field */
    private String lastChangeUserId;

    /** nullable persistent field */
    private Integer updateStamp;

    /** persistent field */
    private Date startDate;

    /** nullable persistent field */
    private Date endDate;

    /** persistent field */
    private Set cancerActivityPocsTs;

    /** persistent field */
    private Set applCancerActivitiesTs;

    /** persistent field */
    private Set cancerActivityPeopleTs;

    /** persistent field */
    private Set cancerActivityPdsTs;

    /** full constructor */
    public CancerActivitiesT(String code, String description, Date createDate, String createUserId, Date lastChangeDate, String lastChangeUserId, Integer updateStamp, Date startDate, Date endDate, Set cancerActivityPocsTs, Set applCancerActivitiesTs, Set cancerActivityPeopleTs, Set cancerActivityPdsTs) {
        this.code = code;
        this.description = description;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.lastChangeDate = lastChangeDate;
        this.lastChangeUserId = lastChangeUserId;
        this.updateStamp = updateStamp;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cancerActivityPocsTs = cancerActivityPocsTs;
        this.applCancerActivitiesTs = applCancerActivitiesTs;
        this.cancerActivityPeopleTs = cancerActivityPeopleTs;
        this.cancerActivityPdsTs = cancerActivityPdsTs;
    }

    /** default constructor */
    public CancerActivitiesT() {
    }

    /** minimal constructor */
    public CancerActivitiesT(String code, String description, Date createDate, String createUserId, Date startDate, Set cancerActivityPocsTs, Set applCancerActivitiesTs, Set cancerActivityPeopleTs, Set cancerActivityPdsTs) {
        this.code = code;
        this.description = description;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.startDate = startDate;
        this.cancerActivityPocsTs = cancerActivityPocsTs;
        this.applCancerActivitiesTs = applCancerActivitiesTs;
        this.cancerActivityPeopleTs = cancerActivityPeopleTs;
        this.cancerActivityPdsTs = cancerActivityPdsTs;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getLastChangeDate() {
        return this.lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getLastChangeUserId() {
        return this.lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
    }

    public Integer getUpdateStamp() {
        return this.updateStamp;
    }

    public void setUpdateStamp(Integer updateStamp) {
        this.updateStamp = updateStamp;
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

    public Set getCancerActivityPocsTs() {
        return this.cancerActivityPocsTs;
    }

    public void setCancerActivityPocsTs(Set cancerActivityPocsTs) {
        this.cancerActivityPocsTs = cancerActivityPocsTs;
    }

    public Set getApplCancerActivitiesTs() {
        return this.applCancerActivitiesTs;
    }

    public void setApplCancerActivitiesTs(Set applCancerActivitiesTs) {
        this.applCancerActivitiesTs = applCancerActivitiesTs;
    }

    public Set getCancerActivityPeopleTs() {
        return this.cancerActivityPeopleTs;
    }

    public void setCancerActivityPeopleTs(Set cancerActivityPeopleTs) {
        this.cancerActivityPeopleTs = cancerActivityPeopleTs;
    }

    public Set getCancerActivityPdsTs() {
        return this.cancerActivityPdsTs;
    }

    public void setCancerActivityPdsTs(Set cancerActivityPdsTs) {
        this.cancerActivityPdsTs = cancerActivityPdsTs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("code", getCode())
            .toString();
    }

}
