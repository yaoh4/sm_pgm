package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;


public interface RetrieveUserQueriesCommand {

    public QueryPage execute(String oUserQueryId);


}