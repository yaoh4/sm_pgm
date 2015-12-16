package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import net.sf.hibernate.HibernateException;
//application imports
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;

//hibernate imports

public interface RetrieveUserInfoCommand {

    public QueryPage execute(String oUserQueryId);
    
    public boolean isNciUserValid(String oracleId) throws HibernateException;

}