package gov.nih.nci.iscs.oracle.pgm.service;

import java.util.*;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;
import gov.nih.nci.iscs.oracle.pgm.forms.PaginationObject;

public interface GrantSearchService  {

    public Map search(GrantQueryObject  aGrantQueryObject, PaginationObject aPaginationObject, UserFilterInfo aUserFilterInfo);

}
