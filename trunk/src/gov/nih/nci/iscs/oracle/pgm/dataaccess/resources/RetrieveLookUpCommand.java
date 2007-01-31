package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;


import java.util.List;

public interface RetrieveLookUpCommand extends ActionCommand{

    public List execute(String oLookUpTableName, String oLookUpSqlString,
                          String oUserId);


}