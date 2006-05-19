package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveGrantsCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;

public interface RetrievePDOrgInfoCommand  {

    public QueryPage execute(String  oPersonId, String  oCancerActivity, String oUserId );

}