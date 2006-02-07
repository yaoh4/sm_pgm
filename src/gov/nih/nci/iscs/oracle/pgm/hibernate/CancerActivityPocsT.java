package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivitiesT;

import java.text.SimpleDateFormat;


/** @author Hibernate CodeGenerator */
public class CancerActivityPocsT implements Serializable {

    /** identifier field */
    private Long npnId;

    /** identifier field */
    private Date startDate;

    /** identifier field */
    private CancerActivitiesT cancerActivitiesT;

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

    /** persistent field */
    private Set applCancerActivityPocsTs;

    /** full constructor */
    public CancerActivityPocsT(Long npnId, Date startDate, CancerActivitiesT cancerActivitiesT, Date endDate, String createUserId, Date createDate, String lastChangeUserId, Date lastChangeDate, Integer updateStamp, Set applCancerActivityPocsTs) {
        this.npnId = npnId;
        System.out.println("**** now in constructr 1 *****");
        SimpleDateFormat mFormatter = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        String mDate = mFormatter.format(startDate);
        Date mNewDate = null;
        try {
          mNewDate = (Date) mFormatter.parse(mDate);
	    } catch (Exception e) {}
        this.startDate = mNewDate;
        this.cancerActivitiesT = cancerActivitiesT;
        this.startDate = startDate;
        this.cancerActivitiesT = cancerActivitiesT;
        this.endDate = endDate;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.lastChangeUserId = lastChangeUserId;
        this.lastChangeDate = lastChangeDate;
        this.updateStamp = updateStamp;
        this.applCancerActivityPocsTs = applCancerActivityPocsTs;
    }

    /** default constructor */
    public CancerActivityPocsT() {
    }

    /** minimal constructor */
    public CancerActivityPocsT(Long npnId, Date startDate, CancerActivitiesT cancerActivitiesT, String createUserId, Date createDate, Set applCancerActivityPocsTs) {
        System.out.println("**** now in constructr 2 *****");

        this.npnId = npnId;
        SimpleDateFormat mFormatter = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        String mDate = mFormatter.format(startDate);
        Date mNewDate = null;
        try {
          mNewDate = (Date) mFormatter.parse(mDate);
	    } catch (Exception e) {}
        this.startDate = mNewDate;
        this.cancerActivitiesT = cancerActivitiesT;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.applCancerActivityPocsTs = applCancerActivityPocsTs;
    }

    public Long getNpnId() {
        return this.npnId;
    }

    public void setNpnId(Long npnId) {
        this.npnId = npnId;
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

    public Set getApplCancerActivityPocsTs() {
        return this.applCancerActivityPocsTs;
    }

    public void setApplCancerActivityPocsTs(Set applCancerActivityPocsTs) {
        this.applCancerActivityPocsTs = applCancerActivityPocsTs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("npnId", getNpnId())
            .append("startDate", getStartDate())
            .append("cancerActivitiesT", getCancerActivitiesT())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CancerActivityPocsT) ) return false;
        CancerActivityPocsT castOther = (CancerActivityPocsT) other;
        return new EqualsBuilder()
            .append(this.getNpnId(), castOther.getNpnId())
            .append(this.getStartDate(), castOther.getStartDate())
            .append(this.getCancerActivitiesT(), castOther.getCancerActivitiesT())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getNpnId())
            .append(getStartDate())
            .append(getCancerActivitiesT())
            .toHashCode();
    }

}
