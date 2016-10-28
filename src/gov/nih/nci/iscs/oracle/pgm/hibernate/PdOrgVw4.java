package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import gov.nih.nci.iscs.oracle.pgm.util.TimeInsensitiveDateComparator;


/**
 *        @hibernate.class
 *         table="PD_ORG_VW4"
 *
*/
public class PdOrgVw4 implements Serializable {

    /** identifier field */
    private Long npeId;

    /** identifier field */
    private String pdCode;

    /** identifier field */
    private String pdName;

    /** identifier field */
    private Long personId;

    /** identifier field */
    private long orgId;

    /** identifier field */
    private String orgDesc;

    /** identifier field */
    private String orgAbbrv;

    /** identifier field */
    private Date pdStartDate;

    /** identifier field */
    private Date pdEndDate;

    /** identifier field */
    private String cayCode;

    /** identifier field */
    private Date cayStartDate;

    /** identifier field */
    private Date cayEndDate;
    
    /** full constructor */
    public PdOrgVw4(Long npeId, String pdCode, String pdName, Long personId, long orgId, String orgDesc, String orgAbbrv, Date pdStartDate, Date pdEndDate, String cayCode, Date cayStartDate, Date cayEndDate) {
        this.npeId = npeId;
        this.pdCode = pdCode;
        this.pdName = pdName;
        this.personId = personId;
        this.orgId = orgId;
        this.orgDesc = orgDesc;
        this.orgAbbrv = orgAbbrv;
        this.pdStartDate = pdStartDate;
        this.pdEndDate = pdEndDate;
        this.cayCode = cayCode;
        this.cayStartDate = cayStartDate;
        this.cayEndDate = cayEndDate;
    }

    /** default constructor */
    public PdOrgVw4() {
    }

    /**
     *                @hibernate.property
     *                 column="NPE_ID"
     *
     */
    public Long getNpeId() {
        return this.npeId;
    }

    public void setNpeId(Long npeId) {
        this.npeId = npeId;
    }

    /**
     *                @hibernate.property
     *                 column="PD_CODE"
     *
     */
    public String getPdCode() {
        return this.pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    /**
     *                @hibernate.property
     *                 column="PD_NAME"
     *
     */
    public String getPdName() {
        return this.pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    /**
     *                @hibernate.property
     *                 column="PERSON_ID"
     *
     */
    public Long getPersonId() {
        return this.personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /**
     *                @hibernate.property
     *                 column="ORG_ID"
     *
     */
    public long getOrgId() {
        return this.orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    /**
     *                @hibernate.property
     *                 column="ORG_DESC"
     *
     */
    public String getOrgDesc() {
        return this.orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }

    /**
     *                @hibernate.property
     *                 column="ORG_ABBRV"
     *
     */
    public String getOrgAbbrv() {
        return this.orgAbbrv;
    }

    public void setOrgAbbrv(String orgAbbrv) {
        this.orgAbbrv = orgAbbrv;
    }

    /**
     *                @hibernate.property
     *                 column="PD_START_DATE"
     *
     */
    public Date getPdStartDate() {
        return this.pdStartDate;
    }

    public void setPdStartDate(Date pdStartDate) {
        this.pdStartDate = pdStartDate;
    }

    /**
     *                @hibernate.property
     *                 column="PD_END_DATE"
     *
     */
    public Date getPdEndDate() {
        return this.pdEndDate;
    }

    public void setPdEndDate(Date pdEndDate) {
        this.pdEndDate = pdEndDate;
    }

    /**
     *                @hibernate.property
     *                 column="CAY_CODE"
     *
     */
    public String getCayCode() {
        return this.cayCode;
    }

    public void setCayCode(String cayCode) {
        this.cayCode = cayCode;
    }

    /**
     *                @hibernate.property
     *                 column="CAY_START_DATE"
     *
     */
    public Date getCayStartDate() {
        return this.cayStartDate;
    }

    public void setCayStartDate(Date cayStartDate) {
        this.cayStartDate = cayStartDate;
    }

    /**
     *                @hibernate.property
     *                 column="CAY_END_DATE"
     *
     */
    public Date getCayEndDate() {
        return this.cayEndDate;
    }

    public void setCayEndDate(Date cayEndDate) {
        this.cayEndDate = cayEndDate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("npeId", getNpeId())
            .append("pdCode", getPdCode())
            .append("pdName", getPdName())
            .append("personId", getPersonId())
            .append("orgId", getOrgId())
            .append("orgDesc", getOrgDesc())
            .append("orgAbbrv", getOrgAbbrv())
            .append("pdStartDate", getPdStartDate())
            .append("pdEndDate", getPdEndDate())
            .append("cayCode", getCayCode())
            .append("cayStartDate", getCayStartDate())
            .append("cayEndDate", getCayEndDate())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof PdOrgVw4) ) return false;
        PdOrgVw4 castOther = (PdOrgVw4) other;
        return new EqualsBuilder()
            .append(this.getNpeId(), castOther.getNpeId())
            .append(this.getPdCode(), castOther.getPdCode())
            .append(this.getPdName(), castOther.getPdName())
            .append(this.getPersonId(), castOther.getPersonId())
            .append(this.getOrgId(), castOther.getOrgId())
            .append(this.getOrgDesc(), castOther.getOrgDesc())
            .append(this.getOrgAbbrv(), castOther.getOrgAbbrv())
            .append(this.getPdStartDate(), castOther.getPdStartDate())
            .append(this.getPdEndDate(), castOther.getPdEndDate())
            .append(this.getCayCode(), castOther.getCayCode())
            .append(this.getCayStartDate(), castOther.getCayStartDate())
            .append(this.getCayEndDate(), castOther.getCayEndDate())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getNpeId())
            .append(getPdCode())
            .append(getPdName())
            .append(getPersonId())
            .append(getOrgId())
            .append(getOrgDesc())
            .append(getOrgAbbrv())
            .append(getPdStartDate())
            .append(getPdEndDate())
            .append(getCayCode())
            .append(getCayStartDate())
            .append(getCayEndDate())
            .toHashCode();
    }

    
	private static class ComparatorHolder {
		static TimeInsensitiveDateComparator instance = new TimeInsensitiveDateComparator();
	}

	public Boolean isActive() {
		final TimeInsensitiveDateComparator tComp = ComparatorHolder.instance;

		if (((pdEndDate == null) || (tComp.compare(pdEndDate, new Date()) >= 0))
				&& ((pdStartDate == null) || (tComp.compare(pdStartDate, new Date()) <= 0))
				&& ((cayEndDate == null) || (tComp.compare(cayEndDate, new Date()) >= 0))
				&& ((cayStartDate == null) || (tComp.compare(cayStartDate, new Date()) <= 0))) {
			return true;
		}

		return false;
	}
}
