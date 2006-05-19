package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveGrantsCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;

public interface RetrieveCAHistoryCommand  {

    public QueryPage execute(Long aApplId, String oUserId);

}