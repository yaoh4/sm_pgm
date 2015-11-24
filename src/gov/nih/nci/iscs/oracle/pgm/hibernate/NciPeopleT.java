package gov.nih.nci.iscs.oracle.pgm.hibernate;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * This class maps to NCI_PEOPLE_T table
 * @author tembharend
 *
 */
public class NciPeopleT implements Serializable {
    
    private java.lang.Long id;    
    private java.lang.String lastName;    
    private java.lang.String firstName;
    private java.lang.String genderCode;
    private java.lang.String middelName;
    private java.lang.String namePrefix;
    private java.lang.String nameSuffix;
    private java.lang.String personTypeCode;
    private java.lang.String title;
    private java.lang.String emailAddress;
    private java.lang.String createUserId;
    private java.util.Date createDate;
    private java.lang.String lastChangeUserId;    
    private java.util.Date lastChangeDate;
    private java.lang.Integer updateStamp;
    private java.lang.String userId;
    private java.lang.String specialty;
    private java.lang.Long rrlId;  
    private java.lang.Long nipId; 
    private java.lang.String ardPubVerifiedFlag;
    private java.lang.String ardNotes;
    private java.lang.String ardVerifiedFlag;
    private java.lang.String biography;
    private java.lang.String publicationNotes;
    private java.lang.String researchTitle;
    private java.lang.Long tfsId;
    private java.lang.String researchDescription;
    private java.util.Date inactiveDate;
    private java.lang.String nciLdapCn;
    private java.lang.Long personProfileId;
    private java.util.Date lastLoginDate;

    

   /**
    * Default Constructor
    */
    public NciPeopleT(){    	
    }

    /**
	 * @param id
	 * @param lastName
	 * @param firstName
	 * @param genderCode
	 * @param middelName
	 * @param namePrefix
	 * @param nameSuffix
	 * @param personTypeCode
	 * @param title
	 * @param emailAddress
	 * @param createUserId
	 * @param createDate
	 * @param lastChangeUserId
	 * @param lastChangeDate
	 * @param updateStamp
	 * @param userId
	 * @param specialty
	 * @param rrlId
	 * @param nipId
	 * @param ardPubVerifiedFlag
	 * @param ardNotes
	 * @param ardVerifiedFlag
	 * @param biography
	 * @param publicationNotes
	 * @param researchTitle
	 * @param tfsId
	 * @param researchDescription
	 * @param inactiveDate
	 * @param nciLdapCn
	 * @param personProfileId
	 * @param lastLoginDate
	 */
	public NciPeopleT(Long id, String lastName, String firstName, String genderCode, String middelName,
			String namePrefix, String nameSuffix, String personTypeCode, String title, String emailAddress,
			String createUserId, Date createDate, String lastChangeUserId, Date lastChangeDate, Integer updateStamp,
			String userId, String specialty, Long rrlId, Long nipId, String ardPubVerifiedFlag, String ardNotes,
			String ardVerifiedFlag, String biography, String publicationNotes, String researchTitle, Long tfsId,
			String researchDescription, Date inactiveDate, String nciLdapCn, Long personProfileId, Date lastLoginDate) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.genderCode = genderCode;
		this.middelName = middelName;
		this.namePrefix = namePrefix;
		this.nameSuffix = nameSuffix;
		this.personTypeCode = personTypeCode;
		this.title = title;
		this.emailAddress = emailAddress;
		this.createUserId = createUserId;
		this.createDate = createDate;
		this.lastChangeUserId = lastChangeUserId;
		this.lastChangeDate = lastChangeDate;
		this.updateStamp = updateStamp;
		this.userId = userId;
		this.specialty = specialty;
		this.rrlId = rrlId;
		this.nipId = nipId;
		this.ardPubVerifiedFlag = ardPubVerifiedFlag;
		this.ardNotes = ardNotes;
		this.ardVerifiedFlag = ardVerifiedFlag;
		this.biography = biography;
		this.publicationNotes = publicationNotes;
		this.researchTitle = researchTitle;
		this.tfsId = tfsId;
		this.researchDescription = researchDescription;
		this.inactiveDate = inactiveDate;
		this.nciLdapCn = nciLdapCn;
		this.personProfileId = personProfileId;
		this.lastLoginDate = lastLoginDate;
	}

	/**
	 * @return the id
	 */
	public java.lang.Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	/**
	 * @return the lastName
	 */
	public java.lang.String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(java.lang.String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public java.lang.String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(java.lang.String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the genderCode
	 */
	public java.lang.String getGenderCode() {
		return genderCode;
	}

	/**
	 * @param genderCode the genderCode to set
	 */
	public void setGenderCode(java.lang.String genderCode) {
		this.genderCode = genderCode;
	}

	/**
	 * @return the middelName
	 */
	public java.lang.String getMiddelName() {
		return middelName;
	}

	/**
	 * @param middelName the middelName to set
	 */
	public void setMiddelName(java.lang.String middelName) {
		this.middelName = middelName;
	}

	/**
	 * @return the namePrefix
	 */
	public java.lang.String getNamePrefix() {
		return namePrefix;
	}

	/**
	 * @param namePrefix the namePrefix to set
	 */
	public void setNamePrefix(java.lang.String namePrefix) {
		this.namePrefix = namePrefix;
	}

	/**
	 * @return the nameSuffix
	 */
	public java.lang.String getNameSuffix() {
		return nameSuffix;
	}

	/**
	 * @param nameSuffix the nameSuffix to set
	 */
	public void setNameSuffix(java.lang.String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	/**
	 * @return the personTypeCode
	 */
	public java.lang.String getPersonTypeCode() {
		return personTypeCode;
	}

	/**
	 * @param personTypeCode the personTypeCode to set
	 */
	public void setPersonTypeCode(java.lang.String personTypeCode) {
		this.personTypeCode = personTypeCode;
	}

	/**
	 * @return the title
	 */
	public java.lang.String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	/**
	 * @return the emailAddress
	 */
	public java.lang.String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(java.lang.String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the createUserId
	 */
	public java.lang.String getCreateUserId() {
		return createUserId;
	}

	/**
	 * @param createUserId the createUserId to set
	 */
	public void setCreateUserId(java.lang.String createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * @return the createDate
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the lastChangeUserId
	 */
	public java.lang.String getLastChangeUserId() {
		return lastChangeUserId;
	}

	/**
	 * @param lastChangeUserId the lastChangeUserId to set
	 */
	public void setLastChangeUserId(java.lang.String lastChangeUserId) {
		this.lastChangeUserId = lastChangeUserId;
	}

	/**
	 * @return the lastChangeDate
	 */
	public java.util.Date getLastChangeDate() {
		return lastChangeDate;
	}

	/**
	 * @param lastChangeDate the lastChangeDate to set
	 */
	public void setLastChangeDate(java.util.Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}

	/**
	 * @return the updateStamp
	 */
	public java.lang.Integer getUpdateStamp() {
		return updateStamp;
	}

	/**
	 * @param updateStamp the updateStamp to set
	 */
	public void setUpdateStamp(java.lang.Integer updateStamp) {
		this.updateStamp = updateStamp;
	}

	/**
	 * @return the userId
	 */
	public java.lang.String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}

	/**
	 * @return the specialty
	 */
	public java.lang.String getSpecialty() {
		return specialty;
	}

	/**
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(java.lang.String specialty) {
		this.specialty = specialty;
	}

	/**
	 * @return the rrlId
	 */
	public java.lang.Long getRrlId() {
		return rrlId;
	}

	/**
	 * @param rrlId the rrlId to set
	 */
	public void setRrlId(java.lang.Long rrlId) {
		this.rrlId = rrlId;
	}

	/**
	 * @return the nipId
	 */
	public java.lang.Long getNipId() {
		return nipId;
	}

	/**
	 * @param nipId the nipId to set
	 */
	public void setNipId(java.lang.Long nipId) {
		this.nipId = nipId;
	}

	/**
	 * @return the ardPubVerifiedFlag
	 */
	public java.lang.String getArdPubVerifiedFlag() {
		return ardPubVerifiedFlag;
	}

	/**
	 * @param ardPubVerifiedFlag the ardPubVerifiedFlag to set
	 */
	public void setArdPubVerifiedFlag(java.lang.String ardPubVerifiedFlag) {
		this.ardPubVerifiedFlag = ardPubVerifiedFlag;
	}

	/**
	 * @return the ardNotes
	 */
	public java.lang.String getArdNotes() {
		return ardNotes;
	}

	/**
	 * @param ardNotes the ardNotes to set
	 */
	public void setArdNotes(java.lang.String ardNotes) {
		this.ardNotes = ardNotes;
	}

	/**
	 * @return the ardVerifiedFlag
	 */
	public java.lang.String getArdVerifiedFlag() {
		return ardVerifiedFlag;
	}

	/**
	 * @param ardVerifiedFlag the ardVerifiedFlag to set
	 */
	public void setArdVerifiedFlag(java.lang.String ardVerifiedFlag) {
		this.ardVerifiedFlag = ardVerifiedFlag;
	}

	/**
	 * @return the biography
	 */
	public java.lang.String getBiography() {
		return biography;
	}

	/**
	 * @param biography the biography to set
	 */
	public void setBiography(java.lang.String biography) {
		this.biography = biography;
	}

	/**
	 * @return the publicationNotes
	 */
	public java.lang.String getPublicationNotes() {
		return publicationNotes;
	}

	/**
	 * @param publicationNotes the publicationNotes to set
	 */
	public void setPublicationNotes(java.lang.String publicationNotes) {
		this.publicationNotes = publicationNotes;
	}

	/**
	 * @return the researchTitle
	 */
	public java.lang.String getResearchTitle() {
		return researchTitle;
	}

	/**
	 * @param researchTitle the researchTitle to set
	 */
	public void setResearchTitle(java.lang.String researchTitle) {
		this.researchTitle = researchTitle;
	}

	/**
	 * @return the tfsId
	 */
	public java.lang.Long getTfsId() {
		return tfsId;
	}

	/**
	 * @param tfsId the tfsId to set
	 */
	public void setTfsId(java.lang.Long tfsId) {
		this.tfsId = tfsId;
	}

	/**
	 * @return the researchDescription
	 */
	public java.lang.String getResearchDescription() {
		return researchDescription;
	}

	/**
	 * @param researchDescription the researchDescription to set
	 */
	public void setResearchDescription(java.lang.String researchDescription) {
		this.researchDescription = researchDescription;
	}

	/**
	 * @return the inactiveDate
	 */
	public java.util.Date getInactiveDate() {
		return inactiveDate;
	}

	/**
	 * @param inactiveDate the inactiveDate to set
	 */
	public void setInactiveDate(java.util.Date inactiveDate) {
		this.inactiveDate = inactiveDate;
	}

	/**
	 * @return the nciLdapCn
	 */
	public java.lang.String getNciLdapCn() {
		return nciLdapCn;
	}

	/**
	 * @param nciLdapCn the nciLdapCn to set
	 */
	public void setNciLdapCn(java.lang.String nciLdapCn) {
		this.nciLdapCn = nciLdapCn;
	}

	/**
	 * @return the personProfileId
	 */
	public java.lang.Long getPersonProfileId() {
		return personProfileId;
	}

	/**
	 * @param personProfileId the personProfileId to set
	 */
	public void setPersonProfileId(java.lang.Long personProfileId) {
		this.personProfileId = personProfileId;
	}

	/**
	 * @return the lastLoginDate
	 */
	public java.util.Date getLastLoginDate() {
		return lastLoginDate;
	}

	/**
	 * @param lastLoginDate the lastLoginDate to set
	 */
	public void setLastLoginDate(java.util.Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof NciPeopleT) ) return false;
        NciPeopleT castOther = (NciPeopleT) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

}
