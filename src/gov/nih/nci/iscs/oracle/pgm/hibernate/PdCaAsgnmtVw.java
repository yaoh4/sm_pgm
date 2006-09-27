package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;

import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class PdCaAsgnmtVw implements Serializable {

    /** identifier field */
    private Long npeId;

    /** identifier field */
    private String pdCode;

    /** identifier field */
    private String pdName;

    /** identifier field */
    private Long personId;

    /** identifier field */
    private Long orgId;

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
    public PdCaAsgnmtVw(Long npeId, String pdCode, String pdName,
             Long personId, Long orgId, String orgDesc, String orgAbbrv,
             Date pdStartDate, Date pdEndDate, String cayCode, Date cayStartDate, Date cayEndDate){
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
    public PdCaAsgnmtVw() {
    }

    public Long getNpeId() {
        return this.npeId;
    }

    public void setNpeId(Long npeId) {
        this.npeId = npeId;
    }

    public String getPdCode() {
        return this.pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdName() {
        return this.pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }


    public Long getPersonId() {
        return this.personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }


    public Long getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgDesc() {
        return this.orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }

    public String getOrgAbbrv() {
        return this.orgAbbrv;
    }

    public void setOrgAbbrv(String orgAbbrv) {
        this.orgAbbrv = orgAbbrv;
    }


    public Date getPdStartDate() {
        return this.pdStartDate;
    }

    public void setPdStartDate(Date pdStartDate) {
        this.pdStartDate = pdStartDate;
    }

    public Date getPdEndDate() {
        return this.pdEndDate;
    }

    public void setPdEndDate(Date pdEndDate) {
        this.pdEndDate = pdEndDate;
    }

    public String getCayCode() {
        return this.cayCode;
    }

    public void setCayCode(String cayCode) {
        this.cayCode = cayCode;
    }

    public Date getCayStartDate() {
        return this.cayStartDate;
    }

    public void setCayStartDate(Date pdStartDate) {
        this.cayStartDate = cayStartDate;
    }

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
            .append("getPdName", getPdName())
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
        if ( !(other instanceof PdCaAsgnmtVw) ) return false;
        PdCaAsgnmtVw castOther = (PdCaAsgnmtVw) other;
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
            .append(getOrgId())
            .append(getOrgDesc())
            .append(getPdStartDate())
            .append(getPdEndDate())
            .append(getCayCode())
            .append(getCayStartDate())
            .append(getCayEndDate())

            .toHashCode();
    }

}
