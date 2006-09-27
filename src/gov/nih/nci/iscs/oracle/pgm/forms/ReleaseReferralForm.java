package gov.nih.nci.iscs.oracle.pgm.forms;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm ;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.servlet.http.HttpServletRequest;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;


public class ReleaseReferralForm extends ValidatorForm   {

    private List queryResults;
    private int selectedIndex;
    private String requestAction;
    private boolean sortAscendingIndicator;
    private String sortColumn;
    private String[] selectedIndx;

    public ReleaseReferralForm() {
  	    this.queryResults = (List) new ArrayList();
  	    this.requestAction = ApplicationConstants.EMPTY_STRING;
  	    this.sortColumn = "grantNumber";
  	    this.sortAscendingIndicator = true;

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
    }

   public void setQueryResults(List queryResults) {
		this.queryResults = queryResults;
	}

	public List getQueryResults() {
		return queryResults;
	}

    public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	public int getSelectedIndex() {
		return selectedIndex;
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
    public void setRequestAction(String requestAction) {
		this.requestAction = requestAction;
	}

	public String getRequestAction() {
		return requestAction;
	}

    public void setSelectedIndx(String[] selectedIndx) {
		this.selectedIndx = selectedIndx;
	}

	public String[] getSelectedIndx() {
		return selectedIndx;
	}

    public String toString() {
       return new ToStringBuilder(this)
           .append("queryResults ", getQueryResults())
           .append("selectedIndex ", getSelectedIndex())
           .append("sortColumn ", getSortColumn())
           .append("sortAscendingIndicator ", getSortAscendingIndicator())
           .append("requestAction ", getRequestAction())
           .append("selectedIndx ", getSelectedIndx())
           .toString();
	}

}
