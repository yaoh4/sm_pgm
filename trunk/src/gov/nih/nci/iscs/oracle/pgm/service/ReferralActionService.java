package gov.nih.nci.iscs.oracle.pgm.service;

import java.util.*;

public interface ReferralActionService  {

    public Map getReferralActionGrants();
    public boolean performReferral(String action);

}
