package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ApplCaAsgnmtHistoryVw implements Serializable {

    /** identifier field */
    private Long applId;

    /** identifier field */
    private String cayCode;

    /** identifier field */
    private String pocName;

    /** identifier field */
    private Date caStartDate;

    /** identifier field */
    private Date caEndDate;


    /** full constructor */
    public ApplCaAsgnmtHistoryVw(Long applId, String cayCode, String pocName,
             Date caStartDate, Date caEndDate){
		this.applId = applId;
        this.cayCode = cayCode;
        this.pocName = pocName;
        this.caStartDate = caStartDate;
        this.caEndDate = caEndDate;

    }

    /** default constructor */
    public ApplCaAsgnmtHistoryVw() {
    }

    public Long getApplId() {
        return this.applId;
    }

    public void setApplId(Long applId) {
        this.applId = applId;
    }

    public String getCayCode() {
        return this.cayCode;
    }

    public void setCayCode(String cayCode) {
        this.cayCode = cayCode;
    }

    public String getPocName() {
        return this.pocName;
    }

    public void setPocName(String pocName) {
        this.pocName = pocName;
    }

    public Date getCaStartDate() {
        return this.caStartDate;
    }

    public void setCaStartDate(Date caStartDate) {
        this.caStartDate = caStartDate;
    }

    public Date getCaEndDate() {
        return this.caEndDate;
    }

    public void setCaEndDate(Date caEndDate) {
        this.caEndDate = caEndDate;
    }


    public String toString() {
        return new ToStringBuilder(this)
            .append("applId", getApplId())
            .append("cayCode", getCayCode())
            .append("pocName", getPocName())
            .append("caStartDate", getCaStartDate())
            .append("caEndDate", getCaEndDate())
             .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ApplCaAsgnmtHistoryVw) ) return false;
        ApplCaAsgnmtHistoryVw castOther = (ApplCaAsgnmtHistoryVw) other;
        return new EqualsBuilder()
            .append(this.getApplId(), castOther.getApplId())
            .append(this.getCayCode(), castOther.getCayCode())
            .append(this.getPocName(), castOther.getPocName())
            .append(this.getCaStartDate(), castOther.getCaStartDate())
            .append(this.getCaEndDate(), castOther.getCaEndDate())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getApplId())
            .append(getCayCode())
            .append(getPocName())
            .append(getCaStartDate())
            .append(getCaEndDate())
            .toHashCode();
    }

}
