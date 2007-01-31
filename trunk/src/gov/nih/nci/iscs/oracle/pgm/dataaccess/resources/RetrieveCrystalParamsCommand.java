package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;

public interface RetrieveCrystalParamsCommand  {

    public QueryPage execute(Long  oReportId, String oUserId);

}