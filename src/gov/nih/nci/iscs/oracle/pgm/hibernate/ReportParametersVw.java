package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;

/** @author Hibernate CodeGenerator */
public class ReportParametersVw implements Serializable {

    /** identifier field */
    private Long repId;

    /** identifier field */
    private String reportName;

    /** identifier field */
    private Long crystalId;

    /** identifier field */
    private String name;

    /** identifier field */
    private String tableMapping;

    /** identifier field */
    private String columnMapping;

    /** identifier field */
    private String defaultValue;


    /** default constructor */
    public ReportParametersVw(Long repId, String reportName, Long crystalId, String name,
                         String tableMapping, String columnMapping, String defaultValue) {

       this.repId = repId;
       this.reportName = reportName;
       this.crystalId = crystalId;
       this.name = name;
       this.tableMapping = tableMapping;
       this.columnMapping = columnMapping;
       this.defaultValue = defaultValue;

    }


    /** default constructor */
    public ReportParametersVw() {
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTableMapping() {
        return this.tableMapping;
    }

    public void setTableMapping(String tableMapping) {
        this.tableMapping = tableMapping;
    }


    public String getColumnMapping() {
        return this.columnMapping;
    }

    public void setColumnMapping(String columnMapping) {
        this.columnMapping = columnMapping;
    }


    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String sequenceNum) {
        this.defaultValue = defaultValue;
    }




    public String toString() {
        return new ToStringBuilder(this)
            .append("repId", getRepId())
            .append("reportName", getReportName())
            .append("crystalId", getCrystalId())
            .append("name", getName())
            .append("tableMapping", getTableMapping())
            .append("columnMapping", getColumnMapping())
            .append("defaultValue", getDefaultValue())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ReportParametersVw) ) return false;
        ReportParametersVw castOther = (ReportParametersVw) other;
        return new EqualsBuilder()
            .append(this.getRepId(), castOther.getRepId())
            .append(this.getReportName(), castOther.getReportName())
            .append(this.getCrystalId(), castOther.getCrystalId())
            .append(this.getName(), castOther.getName())
            .append(this.getTableMapping(), castOther.getTableMapping())
            .append(this.getColumnMapping(), castOther.getColumnMapping())
            .append(this.getDefaultValue(), castOther.getDefaultValue())

            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRepId())
            .append(getReportName())
            .append(getCrystalId())
            .append(getName())
            .append(getTableMapping())
            .append(getColumnMapping())
            .append(getDefaultValue())

            .toHashCode();
    }


}
