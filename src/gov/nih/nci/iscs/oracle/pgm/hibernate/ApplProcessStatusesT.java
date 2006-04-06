package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import gov.nih.nci.iscs.oracle.pgm.hibernate.NciApplElementsT;
import gov.nih.nci.iscs.oracle.pgm.hibernate.ProcessStatusesT;


/** @author Hibernate CodeGenerator */
public class ApplProcessStatusesT implements Serializable {

    /** identifier field */
    private Long id;

    /** nullable persistent field */
    private Long nonId;

    /** nullable persistent field */
    private Date endDate;

    /** persistent field */
    private Date beginDate;

    /** persistent field */
    private String createUserId;

    /** persistent field */
    private Date createDate;

    /** nullable persistent field */
    private Date lastChangeDate;

    /** nullable persistent field */
    private String lastChangeUserId;

    /** nullable persistent field */
    private Integer updateStamp;

    /** nullable persistent field */
    private String comments;

    /** persistent field */
    private gov.nih.nci.iscs.oracle.pgm.hibernate.NciApplElementsT nciApplElementsT;

    /** persistent field */
    private gov.nih.nci.iscs.oracle.pgm.hibernate.ProcessStatusesT processStatusesT;

    /** persistent field */
    private gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT nciPersonOrgRolesT;

    /** full constructor */
    public ApplProcessStatusesT(Long id, Long nonId, Date endDate, Date beginDate, String createUserId, Date createDate, Date lastChangeDate, String lastChangeUserId, Integer updateStamp, String comments, NciApplElementsT nciApplElementsT, ProcessStatusesT processStatusesT, gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT nciPersonOrgRolesT) {
        this.id = id;
        this.nonId = nonId;
        this.endDate = endDate;
        this.beginDate = beginDate;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.lastChangeDate = lastChangeDate;
        this.lastChangeUserId = lastChangeUserId;
        this.updateStamp = updateStamp;
        this.comments = comments;
        this.nciApplElementsT = nciApplElementsT;
        this.processStatusesT = processStatusesT;
        this.nciPersonOrgRolesT = nciPersonOrgRolesT;
    }

    /** default constructor */
    public ApplProcessStatusesT() {
    }

    /** minimal constructor */
    public ApplProcessStatusesT(Long id, Date beginDate, String createUserId, Date createDate, NciApplElementsT nciApplElementsT, ProcessStatusesT processStatusesT, gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT nciPersonOrgRolesT) {
        this.id = id;
        this.beginDate = beginDate;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.nciApplElementsT = nciApplElementsT;
        this.processStatusesT = processStatusesT;
        this.nciPersonOrgRolesT = nciPersonOrgRolesT;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNonId() {
        return this.nonId;
    }

    public void setNonId(Long nonId) {
        this.nonId = nonId;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getBeginDate() {
        return this.beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
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

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public gov.nih.nci.iscs.oracle.pgm.hibernate.NciApplElementsT getNciApplElementsT() {
        return this.nciApplElementsT;
    }

    public void setNciApplElementsT(gov.nih.nci.iscs.oracle.pgm.hibernate.NciApplElementsT nciApplElementsT) {
        this.nciApplElementsT = nciApplElementsT;
    }

    public gov.nih.nci.iscs.oracle.pgm.hibernate.ProcessStatusesT getProcessStatusesT() {
        return this.processStatusesT;
    }

    public void setProcessStatusesT(gov.nih.nci.iscs.oracle.pgm.hibernate.ProcessStatusesT processStatusesT) {
        this.processStatusesT = processStatusesT;
    }

    public gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT getNciPersonOrgRolesT() {
        return this.nciPersonOrgRolesT;
    }

    public void setNciPersonOrgRolesT(gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT nciPersonOrgRolesT) {
        this.nciPersonOrgRolesT = nciPersonOrgRolesT;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
