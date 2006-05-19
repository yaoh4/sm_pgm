package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ProcessStatusesTPK implements Serializable {

    /** identifier field */
    private Long nonId;

    /** identifier field */
    private String code;

    /** full constructor */
    public ProcessStatusesTPK(Long nonId, String code) {
        this.nonId = nonId;
        this.code = code;
    }

    /** default constructor */
    public ProcessStatusesTPK() {
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("nonId", getNonId())
            .append("code", getCode())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ProcessStatusesTPK) ) return false;
        ProcessStatusesTPK castOther = (ProcessStatusesTPK) other;
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
