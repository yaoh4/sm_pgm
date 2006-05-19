package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;

public interface RetrieveActivePDInfoCommand  {

    public QueryPage execute(String aCancerActivity, String oUserId);

}