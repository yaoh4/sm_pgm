package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

//application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;

//hibernate imports
import net.sf.hibernate.Criteria;

public interface RetrieveUserInfoCommand {

    public QueryPage execute(String oUserQueryId);

}