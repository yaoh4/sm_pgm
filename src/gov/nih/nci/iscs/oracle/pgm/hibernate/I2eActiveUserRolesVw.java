package gov.nih.nci.iscs.oracle.pgm.hibernate;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class I2eActiveUserRolesVw implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private java.lang.String oracleId;
	private java.lang.String nciLdapCn;
	private java.lang.Long npnId;
	private java.lang.Long npeId;
	private java.lang.String roleCode;
	private java.lang.String roleName;
	private java.util.Date roleCreatedDate;
	private java.lang.String roleCreatedByFullName;
	private java.lang.Long orgId;
	private java.lang.String orgAbbrev;
	private java.lang.String docAbbrev;
	private java.lang.String fullOrgPathAbbrev;
	private java.lang.String fullOrgPathDescription;
	private java.lang.String ldapRoleName;
	private java.lang.Long ogaBranchId;

	
	/**
	    * Default Constructor
     */
	public I2eActiveUserRolesVw(){   
	    	
	} 
	
	/**
 * @param oracleId
 * @param nciLdapCn
 * @param npnId
 * @param npeId
 * @param roleCode
 * @param roleName
 * @param roleCreatedDate
 * @param roleCreatedByFullName
 * @param orgId
 * @param orgAbbrev
 * @param docAbbrev
 * @param fullOrgPathAbbrev
 * @param fullOrgPathDescription
 * @param ldapRoleName
 * @param ogaBranchId
 */
    public I2eActiveUserRolesVw(String oracleId, String nciLdapCn, Long npnId, Long npeId, String roleCode,
		String roleName, Date roleCreatedDate, String roleCreatedByFullName, Long orgId, String orgAbbrev, 
		String docAbbrev, String fullOrgPathAbbrev, String fullOrgPathDescription, String ldapRoleName, Long ogaBranchId) {
	this.oracleId = oracleId;
	this.nciLdapCn = nciLdapCn;
	this.npnId = npnId;
	this.npeId = npeId;
	this.roleCode = roleCode;
	this.roleName = roleName;
	this.roleCreatedDate = roleCreatedDate;
	this.roleCreatedByFullName = roleCreatedByFullName;
	this.orgId =orgId;
	this.orgAbbrev =orgAbbrev;
	this.docAbbrev = docAbbrev;
	this.fullOrgPathAbbrev = fullOrgPathAbbrev;
	this.fullOrgPathDescription = fullOrgPathDescription;
	this.ldapRoleName = ldapRoleName;
	this.ogaBranchId = ogaBranchId;
    }

	
	public java.lang.String getOracleId() {
		return oracleId;
	}
	public void setOracleId(java.lang.String oracleId) {
		this.oracleId = oracleId;
	}
	public java.lang.String getNciLdapCn() {
		return nciLdapCn;
	}
	public void setNciLdapCn(java.lang.String nciLdapCn) {
		this.nciLdapCn = nciLdapCn;
	}
	public java.lang.Long getNpnId() {
		return npnId;
	}
	public void setNpnId(java.lang.Long npnId) {
		this.npnId = npnId;
	}
	public java.lang.Long getNpeId() {
		return npeId;
	}
	public void setNpeId(java.lang.Long npeId) {
		this.npeId = npeId;
	}
	public java.lang.String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(java.lang.String roleCode) {
		this.roleCode = roleCode;
	}
	public java.lang.String getRoleName() {
		return roleName;
	}
	public void setRoleName(java.lang.String roleName) {
		this.roleName = roleName;
	}
	public java.util.Date getRoleCreatedDate() {
		return roleCreatedDate;
	}
	public void setRoleCreatedDate(java.util.Date roleCreatedDate) {
		this.roleCreatedDate = roleCreatedDate;
	}
	public java.lang.String getRoleCreatedByFullName() {
		return roleCreatedByFullName;
	}
	public void setRoleCreatedByFullName(java.lang.String roleCreatedByFullName) {
		this.roleCreatedByFullName = roleCreatedByFullName;
	}
	public java.lang.Long getOrgId() {
		return orgId;
	}
	public void setOrgId(java.lang.Long orgId) {
		this.orgId = orgId;
	}
	public java.lang.String getOrgAbbrev() {
		return orgAbbrev;
	}
	public void setOrgAbbrev(java.lang.String orgAbbrev) {
		this.orgAbbrev = orgAbbrev;
	}
	public java.lang.String getDocAbbrev() {
		return docAbbrev;
	}
	public void setDocAbbrev(java.lang.String docAbbrev) {
		this.docAbbrev = docAbbrev;
	}
	public java.lang.String getFullOrgPathAbbrev() {
		return fullOrgPathAbbrev;
	}
	public void setFullOrgPathAbbrev(java.lang.String fullOrgPathAbbrev) {
		this.fullOrgPathAbbrev = fullOrgPathAbbrev;
	}
	public java.lang.String getFullOrgPathDescription() {
		return fullOrgPathDescription;
	}
	public void setFullOrgPathDescription(java.lang.String fullOrgPathDescription) {
		this.fullOrgPathDescription = fullOrgPathDescription;
	}
	public java.lang.String getLdapRoleName() {
		return ldapRoleName;
	}
	public void setLdapRoleName(java.lang.String ldapRoleName) {
		this.ldapRoleName = ldapRoleName;
	}
	public java.lang.Long getOgaBranchId() {
		return ogaBranchId;
	}
	public void setOgaBranchId(java.lang.Long ogaBranchId) {
		this.ogaBranchId = ogaBranchId;
	}
	
	public String toString() {
        return new ToStringBuilder(this)
            .append("oracleId", getOracleId())
            .toString();
    }

  
    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOracleId())
            .toHashCode();
    }
}