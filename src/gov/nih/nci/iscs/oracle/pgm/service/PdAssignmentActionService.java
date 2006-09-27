package gov.nih.nci.iscs.oracle.pgm.service;

import java.util.*;

public interface PdAssignmentActionService  {

    public Map getPdAssignmentActionGrants();
    public boolean performPdAssignment(String action);

}
