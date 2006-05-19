package gov.nih.nci.iscs.oracle.pgm.forms;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.servlet.http.HttpServletRequest;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralQueryObject;


public class ExternalReferralForm extends RetrieveGrantsForReferralForm {

    public ExternalReferralForm() {
        super();
        setSortColumn(ApplicationConstants.FULL_GRANT_NUMBER_SORT);

    }

    public List validate() {
       return super.validate();
    }

}
