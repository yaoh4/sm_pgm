package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import java.util.Date;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;

public interface RetrieveUserFilterInfoCommand extends ActionCommand {

     public UserFilterInfo execute(String oUserId);


}