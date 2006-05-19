package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import java.util.ArrayList;
import java.util.List;

public interface RetrieveLookUpCommand extends ActionCommand{

    public List execute(String oLookUpTableName, String oLookUpSqlString,
                          String oUserId);


}