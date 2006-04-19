package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;

public interface RetrieveApplicationLinkInfoCommand
{
    public QueryPage execute(String applicationName, String oUserId);
}