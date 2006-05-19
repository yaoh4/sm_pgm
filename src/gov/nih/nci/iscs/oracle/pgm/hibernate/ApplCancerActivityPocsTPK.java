package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ApplCancerActivityPocsTPK implements Serializable {

    /** identifier field */
    private Date startDate;

    /** identifier field */
    private gov.nih.nci.iscs.oracle.pgm.hibernate.NciApplElementsT nciApplElementsT;

    /** identifier field */
    private gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivityPocsT cancerActivityPocsT;

    /** full constructor */
    public ApplCancerActivityPocsTPK(Date startDate, gov.nih.nci.iscs.oracle.pgm.hibernate.NciApplElementsT nciApplElementsT, gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivityPocsT cancerActivityPocsT) {
        this.startDate = startDate;
        this.nciApplElementsT = nciApplElementsT;
        this.cancerActivityPocsT = cancerActivityPocsT;
    }

    /** default constructor */
    public ApplCancerActivityPocsTPK() {
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public gov.nih.nci.iscs.oracle.pgm.hibernate.NciApplElementsT getNciApplElementsT() {
        return this.nciApplElementsT;
    }

    public void setNciApplElementsT(gov.nih.nci.iscs.oracle.pgm.hibernate.NciApplElementsT nciApplElementsT) {
        this.nciApplElementsT = nciApplElementsT;
    }

    public gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivityPocsT getCancerActivityPocsT() {
        return this.cancerActivityPocsT;
    }

    public void setCancerActivityPocsT(gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivityPocsT cancerActivityPocsT) {
        this.cancerActivityPocsT = cancerActivityPocsT;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("startDate", getStartDate())
            .append("nciApplElementsT", getNciApplElementsT())
            .append("cancerActivityPocsT", getCancerActivityPocsT())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ApplCancerActivityPocsTPK) ) return false;
        ApplCancerActivityPocsTPK castOther = (ApplCancerActivityPocsTPK) other;
        return new EqualsBuilder()
            .append(this.getStartDate(), castOther.getStartDate())
            .append(this.getNciApplElementsT(), castOther.getNciApplElementsT())
            .append(this.getCancerActivityPocsT(), castOther.getCancerActivityPocsT())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getStartDate())
            .append(getNciApplElementsT())
            .append(getCancerActivityPocsT())
            .toHashCode();
    }

}
