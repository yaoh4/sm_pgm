package gov.nih.nci.iscs.oracle.pgm.forms;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
import java.util.ArrayList;
import java.util.*;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm ;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.servlet.http.HttpServletRequest;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralQueryObject;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject;


public class AcceptReferralForm extends ValidatorForm   {

    private List queryResults;
    private String pdId;
    private String selectedIndex;
    private String requestAction;
    private String[] selectedIndx;
    private String[] cancerActivities;
    private String filterCA;
    private int count;
    private boolean sortAscendingIndicator;
    private String sortColumn;

    public AcceptReferralForm() {
  	    this.queryResults = (List) new ArrayList();
  	    this.pdId = ApplicationConstants.EMPTY_STRING;
  	    this.requestAction = ApplicationConstants.EMPTY_STRING;
  	    this.sortColumn = "grantNumber";
  	    this.sortAscendingIndicator = true;

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
    }

   public void setQueryResults(List queryResults) {
		this.queryResults = queryResults;
		this.count = queryResults.size();
		cancerActivities = new String[count];
		int index = 0;
        for (Iterator mIterator = queryResults.iterator(); mIterator.hasNext();) {
             ReferralSearchResultObject mObj = (ReferralSearchResultObject) mIterator.next();
			 cancerActivities[index] = mObj.getCancerActivity();
			 index++;
		}
	}

	public List getQueryResults() {
		return queryResults;
	}

    public void setPdId(String pdId) {
		this.pdId = pdId;
	}

	public String getPdId() {
		return pdId;
	}


    public void setSelectedIndex(String selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	public String getSelectedIndex() {
		return selectedIndex;
	}

    public void setRequestAction(String requestAction) {
		this.requestAction = requestAction;
	}

	public String getRequestAction() {
		return requestAction;
	}

    public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public String getSortColumn() {
		if(sortColumn == null || sortColumn.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ) {
			return "grantNumber";
		}
		if(sortColumn.equalsIgnoreCase("default") ) {
			return "grantNumber";
		}
		return sortColumn;
	}

    public void setSortAscendingIndicator(boolean sortAscendingIndicator) {
		this.sortAscendingIndicator = sortAscendingIndicator;
	}

	public boolean getSortAscendingIndicator() {
		return sortAscendingIndicator;
	}


    public void setFilterCA(String filterCA) {
		this.filterCA = filterCA;
	}

	public String getFilterCA() {
		if(filterCA == null) {
			return ApplicationConstants.EMPTY_STRING;
		}
		return filterCA;
	}

    public void setSelectedIndx(String[] selectedIndx) {
		this.selectedIndx = selectedIndx;
	}

	public String[] getSelectedIndx() {
		return selectedIndx;
	}

    public void setCancerActivities(String[] cancerActivities) {
		this.cancerActivities = cancerActivities;
	}

	public String[] getCancerActivities() {
		return cancerActivities;
	}

    public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

   public void initializeArray() {

  	    this.selectedIndx = new String[queryResults.size()];
  	    for (int indx=0; indx<selectedIndx.length; indx++) {
			this.selectedIndx[indx] = new String("0");
		}

	}



    public String toString() {
       return new ToStringBuilder(this)
           .append("queryResults ", getQueryResults())
           .append("PdId ", getPdId())
           .append("selectedIndex ", getSelectedIndex())
           .append("requestAction ", getRequestAction())
           .append("count ", getCount())
           .append("selectedIndx ", getSelectedIndx())
           .append("cancerActivities ", getCancerActivities())
           .append("filterCA ", getFilterCA())
           .append("sortColumn ", getSortColumn())
           .append("sortAscendingIndicator ", getSortAscendingIndicator())
           .toString();
	}

}
