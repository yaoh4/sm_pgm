package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import gov.nih.nci.iscs.oracle.pgm.hibernate.NciApplElementsT;
import gov.nih.nci.iscs.oracle.pgm.hibernate.CancerActivityPocsT;

/** @author Hibernate CodeGenerator */
public class ApplCancerActivityPocsT implements Serializable {

    /** identifier field */
    private Date startDate;

    /** identifier field */
    private NciApplElementsT nciApplElementsT;

    /** identifier field */
    private CancerActivityPocsT cancerActivityPocsT;

    /** nullable persistent field */
    private Date endDate;

    /** persistent field */
    private String createUserId;

    /** persistent field */
    private Date createDate;

    /** nullable persistent field */
    private String lastChangeUserId;

    /** nullable persistent field */
    private Date lastChangeDate;

    /** nullable persistent field */
    private Integer updateStamp;

    /** full constructor */
    public ApplCancerActivityPocsT(Date startDate, NciApplElementsT nciApplElementsT, CancerActivityPocsT cancerActivityPocsT, Date endDate, String createUserId, Date createDate, String lastChangeUserId, Date lastChangeDate, Integer updateStamp) {
        this.startDate = startDate;
        this.nciApplElementsT = nciApplElementsT;
        this.cancerActivityPocsT = cancerActivityPocsT;
        this.endDate = endDate;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.lastChangeUserId = lastChangeUserId;
        this.lastChangeDate = lastChangeDate;
        this.updateStamp = updateStamp;
    }

    /** default constructor */
    public ApplCancerActivityPocsT() {
    }

    /** minimal constructor */
    public ApplCancerActivityPocsT(Date startDate, NciApplElementsT nciApplElementsT, CancerActivityPocsT cancerActivityPocsT, String createUserId, Date createDate) {
        this.startDate = startDate;
        this.nciApplElementsT = nciApplElementsT;
        this.cancerActivityPocsT = cancerActivityPocsT;
        this.createUserId = createUserId;
        this.createDate = createDate;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public NciApplElementsT getNciApplElementsT() {
        return this.nciApplElementsT;
    }

    public void setNciApplElementsT(NciApplElementsT nciApplElementsT) {
        this.nciApplElementsT = nciApplElementsT;
    }

    public CancerActivityPocsT getCancerActivityPocsT() {
        return this.cancerActivityPocsT;
    }

    public void setCancerActivityPocsT(CancerActivityPocsT cancerActivityPocsT) {
        this.cancerActivityPocsT = cancerActivityPocsT;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
		this.endDate = endDate;
    }

    public String getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastChangeUserId() {
        return this.lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
    }

    public Date getLastChangeDate() {
        return this.lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public Integer getUpdateStamp() {
        return this.updateStamp;
    }

    public void setUpdateStamp(Integer updateStamp) {
        this.updateStamp = updateStamp;
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
        if ( !(other instanceof ApplCancerActivityPocsT) ) return false;
        ApplCancerActivityPocsT castOther = (ApplCancerActivityPocsT) other;
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
