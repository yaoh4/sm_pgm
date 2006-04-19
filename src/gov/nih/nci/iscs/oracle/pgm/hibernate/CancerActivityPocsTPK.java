package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CancerActivityPocsTPK implements Serializable {

    /** identifier field */
    private Long npnId;

    /** identifier field */
    private Date startDate;

    /** identifier field */
    private gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivitiesT cancerActivitiesT;

    /** full constructor */
    public CancerActivityPocsTPK(Long npnId, Date startDate, gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivitiesT cancerActivitiesT) {
        this.npnId = npnId;
        this.startDate = startDate;
        this.cancerActivitiesT = cancerActivitiesT;
    }

    /** default constructor */
    public CancerActivityPocsTPK() {
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

    public gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivitiesT getCancerActivitiesT() {
        return this.cancerActivitiesT;
    }

    public void setCancerActivitiesT(gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivitiesT cancerActivitiesT) {
        this.cancerActivitiesT = cancerActivitiesT;
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
        if ( !(other instanceof CancerActivityPocsTPK) ) return false;
        CancerActivityPocsTPK castOther = (CancerActivityPocsTPK) other;
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
