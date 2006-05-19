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


public class RetrieveGrantsForReferralForm extends RetrieveGrantsForm implements ReferralQueryObject  {

    private Boolean allowAraNotNull;
    private Boolean allowDualsNotNull;

    public RetrieveGrantsForReferralForm() {
        super();
        setSortColumn(ApplicationConstants.FULL_GRANT_NUMBER_SORT);

    }

    public Boolean getAllowAraNotNull() {
		return this.allowAraNotNull;
	}
    public boolean getAllowAraNotNull_boolean() {
		return this.allowAraNotNull.booleanValue();
	}
	public void setAllowAraNotNull(Boolean allowAraNotNull) {
		this.allowAraNotNull = allowAraNotNull;
	}


    public Boolean getAllowDualsNotNull() {
		return this.allowDualsNotNull;
	}
    public boolean getAllowDualsNotNull_boolean() {
		return this.allowDualsNotNull.booleanValue();
	}
	public void setAllowDualsNotNull(Boolean allowDualsNotNull) {
		this.allowDualsNotNull = allowDualsNotNull;
	}

    public void reset(ActionMapping mapping, HttpServletRequest request) {
		allowAraNotNull = null;
		allowDualsNotNull = null;
        super.reset(mapping, request);
    }

    public boolean isNull() {
		return false;
		/*
		if (allowAraNotNull != null)
		    return false;
		if (allowDualsNotNull != null)
		    return false;
        */
    }


    public String toString() {
       return new ToStringBuilder(this)
           .append("allowAraNotNull ", getAllowAraNotNull())
           .append("allowDualsNotNull ", getAllowDualsNotNull())
           .append (super.toString() )
           .toString();
	}

    public void copyForms(RetrieveGrantsForReferralForm destForm) {
		super.copyForms(destForm);
        destForm.allowAraNotNull  = this.allowAraNotNull;;
        destForm.allowDualsNotNull  = this.allowDualsNotNull;;

	}
    public List validate() {

	   ArrayList validationMessages = new ArrayList();

       if( super.getNcabFromDate().length() == 0 || super.getNcabToDate().length() == 0) {
		  validationMessages.add("errors.ncab.equired.criteria.null");
          return validationMessages;
	   }


	   if(this.isNull() ){
		  validationMessages.add("errors.search.criteria.null");
          return validationMessages;
	   }

       return super.validate(validationMessages);

   }

}
