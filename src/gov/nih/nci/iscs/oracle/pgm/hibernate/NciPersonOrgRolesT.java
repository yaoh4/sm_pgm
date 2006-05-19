package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class NciPersonOrgRolesT implements Serializable {

    /** identifier field */
    private Long id;

    /** persistent field */
    private String ereCode;

    /** persistent field */
    private Date startDate;

    /** nullable persistent field */
    private Date endDate;

    /** persistent field */
    private String assignType;

    /** persistent field */
    private long epnId;

    /** persistent field */
    private long orgId;

    /** nullable persistent field */
    private String roleUsageCode;

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
    private Set nciApplElementsTsByApplLevel2Id;

    /** persistent field */
    private Set nciApplElementsTsByApplLevel1Id;

    /** persistent field */
    private Set applProcessStatusesTs;

    /** persistent field */
    private Set cancerActivityPdsTs;

    /** full constructor */
    public NciPersonOrgRolesT(Long id, String ereCode, Date startDate, Date endDate, String assignType, long epnId, long orgId, String roleUsageCode, String createUserId, Date createDate, String lastChangeUserId, Date lastChangeDate, Integer updateStamp, Set nciApplElementsTsByApplLevel2Id, Set nciApplElementsTsByApplLevel1Id, Set applProcessStatusesTs, Set cancerActivityPdsTs) {
        this.id = id;
        this.ereCode = ereCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.assignType = assignType;
        this.epnId = epnId;
        this.orgId = orgId;
        this.roleUsageCode = roleUsageCode;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.lastChangeUserId = lastChangeUserId;
        this.lastChangeDate = lastChangeDate;
        this.updateStamp = updateStamp;
        this.nciApplElementsTsByApplLevel2Id = nciApplElementsTsByApplLevel2Id;
        this.nciApplElementsTsByApplLevel1Id = nciApplElementsTsByApplLevel1Id;
        this.applProcessStatusesTs = applProcessStatusesTs;
        this.cancerActivityPdsTs = cancerActivityPdsTs;
    }

    /** default constructor */
    public NciPersonOrgRolesT() {
    }

    /** minimal constructor */
    public NciPersonOrgRolesT(Long id, String ereCode, Date startDate, String assignType, long epnId, long orgId, String createUserId, Date createDate, Set nciApplElementsTsByApplLevel2Id, Set nciApplElementsTsByApplLevel1Id, Set applProcessStatusesTs, Set cancerActivityPdsTs) {
        this.id = id;
        this.ereCode = ereCode;
        this.startDate = startDate;
        this.assignType = assignType;
        this.epnId = epnId;
        this.orgId = orgId;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.nciApplElementsTsByApplLevel2Id = nciApplElementsTsByApplLevel2Id;
        this.nciApplElementsTsByApplLevel1Id = nciApplElementsTsByApplLevel1Id;
        this.applProcessStatusesTs = applProcessStatusesTs;
        this.cancerActivityPdsTs = cancerActivityPdsTs;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEreCode() {
        return this.ereCode;
    }

    public void setEreCode(String ereCode) {
        this.ereCode = ereCode;
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

    public String getAssignType() {
        return this.assignType;
    }

    public void setAssignType(String assignType) {
        this.assignType = assignType;
    }

    public long getEpnId() {
        return this.epnId;
    }

    public void setEpnId(long epnId) {
        this.epnId = epnId;
    }

    public long getOrgId() {
        return this.orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getRoleUsageCode() {
        return this.roleUsageCode;
    }

    public void setRoleUsageCode(String roleUsageCode) {
        this.roleUsageCode = roleUsageCode;
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

    public Set getNciApplElementsTsByApplLevel2Id() {
        return this.nciApplElementsTsByApplLevel2Id;
    }

    public void setNciApplElementsTsByApplLevel2Id(Set nciApplElementsTsByApplLevel2Id) {
        this.nciApplElementsTsByApplLevel2Id = nciApplElementsTsByApplLevel2Id;
    }

    public Set getNciApplElementsTsByApplLevel1Id() {
        return this.nciApplElementsTsByApplLevel1Id;
    }

    public void setNciApplElementsTsByApplLevel1Id(Set nciApplElementsTsByApplLevel1Id) {
        this.nciApplElementsTsByApplLevel1Id = nciApplElementsTsByApplLevel1Id;
    }

    public Set getApplProcessStatusesTs() {
        return this.applProcessStatusesTs;
    }

    public void setApplProcessStatusesTs(Set applProcessStatusesTs) {
        this.applProcessStatusesTs = applProcessStatusesTs;
    }

    public Set getCancerActivityPdsTs() {
        return this.cancerActivityPdsTs;
    }

    public void setCancerActivityPdsTs(Set cancerActivityPdsTs) {
        this.cancerActivityPdsTs = cancerActivityPdsTs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
