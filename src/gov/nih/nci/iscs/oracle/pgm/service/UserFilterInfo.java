package gov.nih.nci.iscs.oracle.pgm.service;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import java.util.List;

/** @author Hibernate CodeGenerator */
public class UserFilterInfo implements Serializable {

    /** identifier field */
    private String oracleId;

    /** identifier field */
    private String userType;

    /** identifier field */
    private Long peopleId;

    /** identifier field */
    private String divisionAbbrev;

    /** identifier field */
    private boolean portfolioFlag;

    /** identifier field */
    private boolean cancerActivityFlag;

    /** identifier field */
    private List programDirectorIds;

    /** identifier field */
    private List ruCodes;

    /** identifier field */
    private List cancerActivityCodes;

    /** identifier field */
    private boolean includeUnassignedGrants;

    /** identifier field */
    private boolean includeInactiveGrants;

    /** identifier field */
    private boolean portfolioFlagSelected;

    /** identifier field */
    private boolean cancerActivityFlagSelected;

    /** default constructor */
    public UserFilterInfo() {
    }

    public String getOracleId() {
        return this.oracleId;
    }

    public void setOracleId(String oracleId) {
        this.oracleId = oracleId;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Long getPeopleId() {
        return this.peopleId;
    }

    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }

    public String getDivisionAbbrev() {
        return this.divisionAbbrev;
    }

    public void setDivisionAbbrev(String divisionAbbrev) {
        this.divisionAbbrev = divisionAbbrev;
    }

    public boolean getPortfolioFlag() {
        return this.portfolioFlag;
    }

    public void setPortfolioFlag(boolean portfolioFlag) {
        this.portfolioFlag = portfolioFlag;
    }


    public boolean getCancerActivityFlag() {
        return this.cancerActivityFlag;
    }

    public void setCancerActivityFlag(boolean cancerActivityFlag) {
        this.cancerActivityFlag = cancerActivityFlag;
    }


    public List getProgramDirectorIds() {
        return this.programDirectorIds;
    }

    public void setProgramDirectorIds(List programDirectorIds) {
        this.programDirectorIds = programDirectorIds;
    }

    public List getRuCodes() {
        return this.ruCodes;
    }

    public void setRuCodes(List ruCodes) {
        this.ruCodes = ruCodes;
    }

    public List getCancerActivityCodes() {
        return this.cancerActivityCodes;
    }

    public void setCancerActivityCodes(List cancerActivityCodes) {
        this.cancerActivityCodes = cancerActivityCodes;
    }

    public boolean getIncludeUnassignedGrants() {
        return this.includeUnassignedGrants;
    }

    public void setIncludeUnassignedGrants(boolean includeUnassignedGrants) {
        this.includeUnassignedGrants = includeUnassignedGrants;
    }

    public boolean getIncludeInactiveGrants() {
        return this.includeInactiveGrants;
    }

    public void setIncludeInactiveGrants(boolean includeInactiveGrants) {
        this.includeInactiveGrants = includeInactiveGrants;
    }

    public boolean getPortfolioFlagSelected() {
        return this.portfolioFlagSelected;
    }

    public void setPortfolioFlagSelected(boolean portfolioFlagSelected) {
        this.portfolioFlagSelected = portfolioFlagSelected;
    }

    public boolean getCancerActivityFlagSelected() {
        return this.cancerActivityFlagSelected;
    }

    public void setCancerActivityFlagSelected(boolean cancerActivityFlagSelected) {
        this.cancerActivityFlagSelected = cancerActivityFlagSelected;
    }


    public String toString() {
        return new ToStringBuilder(this)
            .append("OracleId ", getOracleId())
            .append("UserType ", getUserType())
            .append("PeopleId ", getPeopleId())
            .append("DivisionAbbrev ", getDivisionAbbrev())
            .append("PortfolioFlag ", getPortfolioFlag())
            .append("CancerActivityFlag ", getCancerActivityFlag())
            .append("ProgramDirectorIds ", getProgramDirectorIds())
            .append("RuCodes ", getRuCodes())
            .append("CancerActivityCodes ", getCancerActivityCodes())
            .append("IncludeUnassignedGrants ", getIncludeUnassignedGrants())
            .append("IncludeInactiveGrants ", getIncludeInactiveGrants())
            .append("PortfolioFlagSelected ", getPortfolioFlagSelected())
            .append("CancerActivityFlagSelected ", getCancerActivityFlagSelected())
            .toString();
    }



}
