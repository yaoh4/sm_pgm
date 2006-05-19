package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveGrantsCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import java.util.*;
public interface RetrieveProgamDirectorsInfoCommand  {

    public QueryPage execute(TreeSet oCancerActivities, String oUserId);

}