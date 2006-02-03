package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;

/** @author Hibernate CodeGenerator */
public class ReportsVw implements Serializable {

    /** identifier field */
    private Long repId;

    /** identifier field */
    private String reportName;

    /** identifier field */
    private Long crystalId;

    /** identifier field */
    private Long rusId;

    /** identifier field */
    private String applicationName;

    /** identifier field */
    private String moduleName;

    /** identifier field */
    private Long sequenceNum;

    /** identifier field */
    private Long rfrId;

    /** identifier field */
    private String formatType;

    /** identifier field */
    private String displayName;

    /** default constructor */
    public ReportsVw(Long repId, String reportName, Long crystalId, Long rusId,
                         String applicationName, String moduleName, Long sequenceNum,
                         Long rfrId, String formatType, String displayName ) {

       this.repId = repId;
       this.reportName = reportName;
       this.crystalId = crystalId;
       this.rusId = rusId;
       this.applicationName = applicationName;
       this.moduleName = moduleName;
       this.sequenceNum = sequenceNum;
       this.rfrId = rfrId;
       this.formatType = formatType;
       this.displayName = displayName;

    }


    /** default constructor */
    public ReportsVw() {
    }

    public Long getRepId() {
        return this.repId;
    }

    public void setRepId(Long repId) {
        this.repId = repId;
    }

    public String getReportName() {
        return this.reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Long getCrystalId() {
        return this.crystalId;
    }

    public void setCrystalId(Long crystalId) {
        this.crystalId = crystalId;
    }

    public Long getRusId() {
        return this.rusId;
    }

    public void setRusId(Long rusId) {
        this.rusId = rusId;
    }

    public String getApplicationName() {
        return this.applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }


    public String getModuleName() {
        return this.moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }


    public Long getSequenceNum() {
        return this.sequenceNum;
    }

    public void setSequenceNum(Long sequenceNum) {
        this.sequenceNum = sequenceNum;
    }

    public Long getRfrId() {
        return this.rfrId;
    }

    public void setRfrId(Long rfrId) {
        this.rfrId = rfrId;
    }


    public String getFormatType() {
        return this.formatType;
    }

    public void setFormatType(String formatType) {
        this.formatType = formatType;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("repId", getRepId())
            .append("reportName", getReportName())
            .append("crystalId", getCrystalId())
            .append("rusId", getRusId())
            .append("applicationName", getApplicationName())
            .append("moduleName", getModuleName())
            .append("sequenceNum", getSequenceNum())
            .append("rfrId", getRfrId())
            .append("formatType", getFormatType())
            .append("displayName", getDisplayName())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ReportsVw) ) return false;
        ReportsVw castOther = (ReportsVw) other;
        return new EqualsBuilder()
            .append(this.getRepId(), castOther.getRepId())
            .append(this.getReportName(), castOther.getReportName())
            .append(this.getCrystalId(), castOther.getCrystalId())
            .append(this.getRusId(), castOther.getRusId())
            .append(this.getApplicationName(), castOther.getApplicationName())
            .append(this.getModuleName(), castOther.getModuleName())
            .append(this.getSequenceNum(), castOther.getSequenceNum())
            .append(this.getRfrId(), castOther.getRfrId())
            .append(this.getFormatType(), castOther.getFormatType())
            .append(this.getDisplayName(), castOther.getDisplayName())

            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRepId())
            .append(getReportName())
            .append(getCrystalId())
            .append(getRusId())
            .append(getApplicationName())
            .append(getModuleName())
            .append(getSequenceNum())
            .append(getRfrId())
            .append(getFormatType())
            .append(getDisplayName())

            .toHashCode();
    }


}
