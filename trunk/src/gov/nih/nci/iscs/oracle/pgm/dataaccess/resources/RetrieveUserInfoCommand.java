package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

//application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;

//hibernate imports

public interface RetrieveUserInfoCommand {

    public QueryPage execute(String oUserQueryId);

}