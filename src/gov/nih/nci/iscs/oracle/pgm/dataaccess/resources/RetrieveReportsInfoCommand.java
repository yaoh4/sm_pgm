package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveGrantsCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;

public interface RetrieveReportsInfoCommand  {

    public QueryPage execute(String  oApplicationName, String oUserid);
    public QueryPage getReportDetails(Long rusId, Long rfrId);

}