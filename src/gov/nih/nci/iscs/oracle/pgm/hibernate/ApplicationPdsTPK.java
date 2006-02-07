package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ApplicationPdsTPK implements Serializable {

    /** identifier field */
    private Long npeId;

    /** identifier field */
    private Long applId;

    /** identifier field */
    private Date startDate;

    /** full constructor */
    public ApplicationPdsTPK(Long npeId, Long applId, Date startDate) {
        this.npeId = npeId;
        this.applId = applId;
        this.startDate = startDate;
    }

    /** default constructor */
    public ApplicationPdsTPK() {
    }

    public Long getNpeId() {
        return this.npeId;
    }

    public void setNpeId(Long npeId) {
        this.npeId = npeId;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("npeId", getNpeId())
            .append("applId", getApplId())
            .append("startDate", getStartDate())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ApplicationPdsTPK) ) return false;
        ApplicationPdsTPK castOther = (ApplicationPdsTPK) other;
        return new EqualsBuilder()
            .append(this.getNpeId(), castOther.getNpeId())
            .append(this.getApplId(), castOther.getApplId())
            .append(this.getStartDate(), castOther.getStartDate())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getNpeId())
            .append(getApplId())
            .append(getStartDate())
            .toHashCode();
    }

}
