package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;

public interface RetrievePDCancerActivityInfoCommand  {

    public QueryPage execute(String  oPersonId, String oUserId);

}