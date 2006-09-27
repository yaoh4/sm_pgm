package gov.nih.nci.iscs.oracle.pgm.forms;


import java.util.List;


import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;


public class ExternalReferralForm extends RetrieveGrantsForReferralForm {

    public ExternalReferralForm() {
        super();
        setSortColumn(ApplicationConstants.FULL_GRANT_NUMBER_SORT);

    }

    public List validate() {
       return super.validate();
    }

}
