package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *        @hibernate.class
 *         table="GWB_LINKS_T"
 *     
*/
public class GwbLinksT implements Serializable {

    /** identifier field */
    private long id;

    /** identifier field */
    private String linkType;

    /** identifier field */
    private String linkServer;

    /** identifier field */
    private String linkPath;

    /** identifier field */
    private String name;

    /** identifier field */
    private String displayName;

    /** identifier field */
    private String activeFlag;

    /** identifier field */
    private String protocol;

    /** identifier field */
    private String createUserId;

    /** identifier field */
    private Date createDate;

    /** identifier field */
    private String lastChangeUserId;

    /** identifier field */
    private Date lastChangeDate;

    /** identifier field */
    private Integer updateStamp;

    /** full constructor */
    public GwbLinksT(long id, String linkType, String linkServer, String linkPath, String name, String displayName, String activeFlag, String protocol, String createUserId, Date createDate, String lastChangeUserId, Date lastChangeDate, Integer updateStamp) {
        this.id = id;
        this.linkType = linkType;
        this.linkServer = linkServer;
        this.linkPath = linkPath;
        this.name = name;
        this.displayName = displayName;
        this.activeFlag = activeFlag;
        this.protocol = protocol;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.lastChangeUserId = lastChangeUserId;
        this.lastChangeDate = lastChangeDate;
        this.updateStamp = updateStamp;
    }

    /** default constructor */
    public GwbLinksT() {
    }

    /** 
     *                @hibernate.property
     *                 column="ID"
     *             
     */
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /** 
     *                @hibernate.property
     *                 column="LINK_TYPE"
     *             
     */
    public String getLinkType() {
        return this.linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    /** 
     *                @hibernate.property
     *                 column="LINK_SERVER"
     *             
     */
    public String getLinkServer() {
        return this.linkServer;
    }

    public void setLinkServer(String linkServer) {
        this.linkServer = linkServer;
    }

    /** 
     *                @hibernate.property
     *                 column="LINK_PATH"
     *             
     */
    public String getLinkPath() {
        return this.linkPath;
    }

    public void setLinkPath(String linkPath) {
        this.linkPath = linkPath;
    }

    /** 
     *                @hibernate.property
     *                 column="NAME"
     *             
     */
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** 
     *                @hibernate.property
     *                 column="DISPLAY_NAME"
     *             
     */
    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /** 
     *                @hibernate.property
     *                 column="ACTIVE_FLAG"
     *             
     */
    public String getActiveFlag() {
        return this.activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

    /** 
     *                @hibernate.property
     *                 column="PROTOCOL"
     *             
     */
    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /** 
     *                @hibernate.property
     *                 column="CREATE_USER_ID"
     *             
     */
    public String getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    /** 
     *                @hibernate.property
     *                 column="CREATE_DATE"
     *             
     */
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /** 
     *                @hibernate.property
     *                 column="LAST_CHANGE_USER_ID"
     *             
     */
    public String getLastChangeUserId() {
        return this.lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
    }

    /** 
     *                @hibernate.property
     *                 column="LAST_CHANGE_DATE"
     *             
     */
    public Date getLastChangeDate() {
        return this.lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    /** 
     *                @hibernate.property
     *                 column="UPDATE_STAMP"
     *             
     */
    public Integer getUpdateStamp() {
        return this.updateStamp;
    }

    public void setUpdateStamp(Integer updateStamp) {
        this.updateStamp = updateStamp;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .append("linkType", getLinkType())
            .append("linkServer", getLinkServer())
            .append("linkPath", getLinkPath())
            .append("name", getName())
            .append("displayName", getDisplayName())
            .append("activeFlag", getActiveFlag())
            .append("protocol", getProtocol())
            .append("createUserId", getCreateUserId())
            .append("createDate", getCreateDate())
            .append("lastChangeUserId", getLastChangeUserId())
            .append("lastChangeDate", getLastChangeDate())
            .append("updateStamp", getUpdateStamp())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof GwbLinksT) ) return false;
        GwbLinksT castOther = (GwbLinksT) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .append(this.getLinkType(), castOther.getLinkType())
            .append(this.getLinkServer(), castOther.getLinkServer())
            .append(this.getLinkPath(), castOther.getLinkPath())
            .append(this.getName(), castOther.getName())
            .append(this.getDisplayName(), castOther.getDisplayName())
            .append(this.getActiveFlag(), castOther.getActiveFlag())
            .append(this.getProtocol(), castOther.getProtocol())
            .append(this.getCreateUserId(), castOther.getCreateUserId())
            .append(this.getCreateDate(), castOther.getCreateDate())
            .append(this.getLastChangeUserId(), castOther.getLastChangeUserId())
            .append(this.getLastChangeDate(), castOther.getLastChangeDate())
            .append(this.getUpdateStamp(), castOther.getUpdateStamp())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .append(getLinkType())
            .append(getLinkServer())
            .append(getLinkPath())
            .append(getName())
            .append(getDisplayName())
            .append(getActiveFlag())
            .append(getProtocol())
            .append(getCreateUserId())
            .append(getCreateDate())
            .append(getLastChangeUserId())
            .append(getLastChangeDate())
            .append(getUpdateStamp())
            .toHashCode();
    }

}
