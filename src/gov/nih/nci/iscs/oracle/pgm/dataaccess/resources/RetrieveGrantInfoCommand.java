package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveGrantsCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;

public interface RetrieveGrantInfoCommand  {

    public QueryPage execute(Long  oApplId, String oCancerActivity, String oUserId, String oAction);

}