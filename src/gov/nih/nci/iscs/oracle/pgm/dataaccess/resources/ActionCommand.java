package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import net.sf.hibernate.Session;
import java.sql.Connection;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;

public interface ActionCommand {

    public Connection getConnection(Session aSession, String oUserId);

}