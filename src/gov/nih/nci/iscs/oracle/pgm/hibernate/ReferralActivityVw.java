package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ReferralActivityVw implements Serializable {

    /** identifier field */
    private String councilMeetingDate;

    /** identifier field */
    private String cayCode;

    /** identifier field */
    private String referralStatus;

    /** identifier field */
    private BigDecimal actCount;

    /** full constructor */
    public ReferralActivityVw(String councilMeetingDate, String cayCode, String referralStatus, BigDecimal actCount) {
        this.councilMeetingDate = councilMeetingDate;
        this.cayCode = cayCode;
        this.referralStatus = referralStatus;
        this.actCount = actCount;
    }

    /** default constructor */
    public ReferralActivityVw() {
    }

    public String getCouncilMeetingDate() {
        return this.councilMeetingDate;
    }

    public void setCouncilMeetingDate(String councilMeetingDate) {
        this.councilMeetingDate = councilMeetingDate;
    }

    public String getCayCode() {
        return this.cayCode;
    }

    public void setCayCode(String cayCode) {
        this.cayCode = cayCode;
    }

    public String getReferralStatus() {
        return this.referralStatus;
    }

    public void setReferralStatus(String referralStatus) {
        this.referralStatus = referralStatus;
    }

    public BigDecimal getActCount() {
        return this.actCount;
    }

    public void setActCount(BigDecimal actCount) {
        this.actCount = actCount;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("councilMeetingDate", getCouncilMeetingDate())
            .append("cayCode", getCayCode())
            .append("referralStatus", getReferralStatus())
            .append("actCount", getActCount())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ReferralActivityVw) ) return false;
        ReferralActivityVw castOther = (ReferralActivityVw) other;
        return new EqualsBuilder()
            .append(this.getCouncilMeetingDate(), castOther.getCouncilMeetingDate())
            .append(this.getCayCode(), castOther.getCayCode())
            .append(this.getReferralStatus(), castOther.getReferralStatus())
            .append(this.getActCount(), castOther.getActCount())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCouncilMeetingDate())
            .append(getCayCode())
            .append(getReferralStatus())
            .append(getActCount())
            .toHashCode();
    }

}
