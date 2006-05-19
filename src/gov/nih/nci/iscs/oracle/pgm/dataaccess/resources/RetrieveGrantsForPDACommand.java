package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveGrantsCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import gov.nih.nci.iscs.oracle.pgm.service.GrantQueryObject;

public interface RetrieveGrantsForPDACommand  extends RetrieveGrantsCommand{

    public QueryPage execute(UserFilterInfo oUserFilterInfo,
                             GrantQueryObject oGrantQueryObject,
                             int pageNumber, int pageSize, String oUserId);

}