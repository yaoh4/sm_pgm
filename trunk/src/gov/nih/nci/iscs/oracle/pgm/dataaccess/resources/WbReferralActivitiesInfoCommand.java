package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import java.util.List;

public interface WbReferralActivitiesInfoCommand  {

    public QueryPage execute(String  oCouncilMeetingDate, List cancerActivities, String oUserId);
}