package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;

/** @author Hibernate CodeGenerator */
public class GrantQueriesT  {

    /** identifier field */
    private Long id;

    /** identifier field */
    private String queryName;

    /** identifier field */
    private String queryDesc;

    /** identifier field */
    private String queryType;

    /** identifier field */
    private String createUserId;

    /** identifier field */
    private Date createDate;

    /** identifier field */
    private Date lastChangeDate;

    /** identifier field */
    private String lastChangeUserId;

    /** default constructor */
    public GrantQueriesT(Long id, String queryName, String queryDesc, String queryType,
                         String createUserId, Date createDate, Date lastChangeDate, String lastChangeUserId) {

       this.id = id;
       this.queryName = queryName;
       this.queryDesc = queryDesc;
       this.queryType = queryType;
       this.createUserId = createUserId;
       this.createDate = createDate;
       this.lastChangeDate = lastChangeDate;
       this.lastChangeUserId = lastChangeUserId;

    }


    /** default constructor */
    public GrantQueriesT() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQueryName() {
        return this.queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public String getQueryDesc() {
        return this.queryDesc;
    }

    public void setQueryDesc(String queryDesc) {
        this.queryDesc = queryDesc;
    }

    public String getQueryType() {
        return this.queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
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


    public Date getLastChangeDate() {
        return this.lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getLastChangeUserId() {
        return this.lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
    }



    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .append("queryName", getQueryName())
            .append("queryDesc", getQueryDesc())
            .append("queryType", getQueryType())
            .append("createUserId", getCreateUserId())
            .append("createDate", getCreateDate())
            .append("lastChangeDate", getLastChangeDate())
            .append("lastChangeUserId", getLastChangeUserId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof GrantQueriesT) ) return false;
        GrantQueriesT castOther = (GrantQueriesT) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .append(this.getQueryName(), castOther.getQueryName())
            .append(this.getQueryDesc(), castOther.getQueryDesc())
            .append(this.getQueryType(), castOther.getQueryType())
            .append(this.getCreateUserId(), castOther.getCreateUserId())
            .append(this.getCreateDate(), castOther.getCreateDate())
            .append(this.getLastChangeDate(), castOther.getLastChangeDate())
            .append(this.getLastChangeUserId(), castOther.getLastChangeUserId())

            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .append(getQueryName())
            .append(getQueryDesc())
            .append(getQueryType())
            .append(getCreateUserId())
            .append(getCreateDate())
            .append(getLastChangeDate())
            .append(getLastChangeUserId())

            .toHashCode();
    }


}
