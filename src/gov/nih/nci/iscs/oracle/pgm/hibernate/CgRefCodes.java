package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *        @hibernate.class
 *         table="CG_REF_CODES"
 *
*/
public class CgRefCodes implements Serializable {

    /** identifier field */
    private String rvDomain;

    /** identifier field */
    private String rvLowValue;

    /** identifier field */
    private String rvHighValue;

    /** identifier field */
    private String rvAbbreviation;

    /** identifier field */
    private String rvMeaning;

    /** full constructor */
    public CgRefCodes(String rvDomain, String rvLowValue, String rvHighValue, String rvAbbreviation, String rvMeaning) {
        this.rvDomain = rvDomain;
        this.rvLowValue = rvLowValue;
        this.rvHighValue = rvHighValue;
        this.rvAbbreviation = rvAbbreviation;
        this.rvMeaning = rvMeaning;
    }

    /** default constructor */
    public CgRefCodes() {
    }

    /**
     *                @hibernate.property
     *                 column="RV_DOMAIN"
     *
     */
    public String getRvDomain() {
        return this.rvDomain;
    }

    public void setRvDomain(String rvDomain) {
        this.rvDomain = rvDomain;
    }

    /**
     *                @hibernate.property
     *                 column="RV_LOW_VALUE"
     *
     */
    public String getRvLowValue() {
        return this.rvLowValue;
    }

    public void setRvLowValue(String rvLowValue) {
        this.rvLowValue = rvLowValue;
    }

    /**
     *                @hibernate.property
     *                 column="RV_HIGH_VALUE"
     *
     */
    public String getRvHighValue() {
        return this.rvHighValue;
    }

    public void setRvHighValue(String rvHighValue) {
        this.rvHighValue = rvHighValue;
    }

    /**
     *                @hibernate.property
     *                 column="RV_ABBREVIATION"
     *
     */
    public String getRvAbbreviation() {
        return this.rvAbbreviation;
    }

    public void setRvAbbreviation(String rvAbbreviation) {
        this.rvAbbreviation = rvAbbreviation;
    }

    /**
     *                @hibernate.property
     *                 column="RV_MEANING"
     *
     */
    public String getRvMeaning() {
        return this.rvMeaning;
    }

    public void setRvMeaning(String rvMeaning) {
        this.rvMeaning = rvMeaning;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rvDomain", getRvDomain())
            .append("rvLowValue", getRvLowValue())
            .append("rvHighValue", getRvHighValue())
            .append("rvAbbreviation", getRvAbbreviation())
            .append("rvMeaning", getRvMeaning())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CgRefCodes) ) return false;
        CgRefCodes castOther = (CgRefCodes) other;
        return new EqualsBuilder()
            .append(this.getRvDomain(), castOther.getRvDomain())
            .append(this.getRvLowValue(), castOther.getRvLowValue())
            .append(this.getRvHighValue(), castOther.getRvHighValue())
            .append(this.getRvAbbreviation(), castOther.getRvAbbreviation())
            .append(this.getRvMeaning(), castOther.getRvMeaning())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRvDomain())
            .append(getRvLowValue())
            .append(getRvHighValue())
            .append(getRvAbbreviation())
            .append(getRvMeaning())
            .toHashCode();
    }

}
