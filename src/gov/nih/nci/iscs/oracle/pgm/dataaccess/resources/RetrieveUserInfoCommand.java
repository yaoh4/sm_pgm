package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import java.util.List;

//application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.hibernate.NciPeopleVw;

//hibernate imports

public interface RetrieveUserInfoCommand {

    public QueryPage execute(String oUserQueryId);
    
    public NciPeopleVw getNCIUserInformation(String userId) throws Exception;

    public List getUserAppRoles(String userId);
    public List<NciPeopleVw> searchUser(String firstName, String lastName) throws Exception;
    public boolean isRestrictedUser(String oracleId); 
}