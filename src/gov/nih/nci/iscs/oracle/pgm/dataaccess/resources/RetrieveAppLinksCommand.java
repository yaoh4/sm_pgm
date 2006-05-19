package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveAppLinksCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;

public interface RetrieveAppLinksCommand  {

    public QueryPage execute();

}