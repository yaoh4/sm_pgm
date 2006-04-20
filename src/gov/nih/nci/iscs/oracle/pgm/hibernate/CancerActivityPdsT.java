package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import gov.nih.nci.iscs.oracle.pgm.hibernate.NciPersonOrgRolesT;

import gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivitiesT;

/** @author Hibernate CodeGenerator */
public class CancerActivityPdsT implements Serializable {

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

    /** identifier field */
    private NciPersonOrgRolesT nciPersonOrgRolesT;

    /** full constructor */
    public CancerActivityPdsT(Date startDate, CancerActivitiesT cancerActivitiesT, NciPersonOrgRolesT nciPersonOrgRolesT, Date endDate, String createUserId, Date createDate, String lastChangeUserId, Date lastChangeDate, Integer updateStamp) {
        this.startDate = startDate;
        this.cancerActivitiesT = cancerActivitiesT;
        this.nciPersonOrgRolesT = nciPersonOrgRolesT;
        this.endDate = endDate;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.lastChangeUserId = lastChangeUserId;
        this.lastChangeDate = lastChangeDate;
        this.updateStamp = updateStamp;
    }

    /** default constructor */
    public CancerActivityPdsT() {
    }

    /** minimal constructor */
    public CancerActivityPdsT(Date startDate, CancerActivitiesT cancerActivitiesT, NciPersonOrgRolesT nciPersonOrgRolesT, String createUserId, Date createDate) {
        this.startDate = startDate;
        this.cancerActivitiesT = cancerActivitiesT;
        this.nciPersonOrgRolesT = nciPersonOrgRolesT;
        this.createUserId = createUserId;
        this.createDate = createDate;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public CancerActivitiesT getCancerActivitiesT() {
        return this.cancerActivitiesT;
    }

    public void setCancerActivitiesT(CancerActivitiesT cancerActivitiesT) {
        this.cancerActivitiesT = cancerActivitiesT;
    }

    public NciPersonOrgRolesT getNciPersonOrgRolesT() {
        return this.nciPersonOrgRolesT;
    }

    public void setNciPersonOrgRolesT(NciPersonOrgRolesT nciPersonOrgRolesT) {
        this.nciPersonOrgRolesT = nciPersonOrgRolesT;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("startDate", getStartDate())
            .append("cancerActivitiesT", getCancerActivitiesT())
            .append("nciPersonOrgRolesT", getNciPersonOrgRolesT())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CancerActivityPdsT) ) return false;
        CancerActivityPdsT castOther = (CancerActivityPdsT) other;
        return new EqualsBuilder()
            .append(this.getStartDate(), castOther.getStartDate())
            .append(this.getCancerActivitiesT(), castOther.getCancerActivitiesT())
            .append(this.getNciPersonOrgRolesT(), castOther.getNciPersonOrgRolesT())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getStartDate())
            .append(getCancerActivitiesT())
            .append(getNciPersonOrgRolesT())
            .toHashCode();
    }

}
