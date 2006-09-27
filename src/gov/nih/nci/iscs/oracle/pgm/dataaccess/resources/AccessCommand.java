package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;


import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;

public interface AccessCommand {

    public QueryPage execute(String aUserId);

}