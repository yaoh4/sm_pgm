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


public class PdAssignmentForm extends ValidatorForm   {

    private List queryResults;
    private String requestAction;
    private int index;
    private  String[] selectedIndx;
    private  String[] pdId;
    private String pdIdForLoad;
    private String pdStartDate;
    private int count;
    private boolean sortAscendingIndicator;
    private String sortColumn;

    public PdAssignmentForm() {
  	    this.queryResults = (List) new ArrayList();
        this.pdId = new String[this.queryResults.size()];
        this.selectedIndx = new String[this.queryResults.size()];
  	    this.requestAction = ApplicationConstants.EMPTY_STRING;
  	    this.pdIdForLoad = ApplicationConstants.EMPTY_STRING;
  	    this.sortColumn = "grantNumber";
  	    this.sortAscendingIndicator = true;

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
    }

   public void setQueryResults(List queryResults) {
        this.pdId = new String[this.queryResults.size()];
		this.count = queryResults.size();
        this.selectedIndx = new String[this.queryResults.size()];
        for(int index=0; index<this.queryResults.size(); index++) {
			selectedIndx[index] = ApplicationConstants.EMPTY_STRING;
			pdId[index] = ApplicationConstants.EMPTY_STRING;
		}

		this.queryResults = queryResults;
	}

	public List getQueryResults() {
		return queryResults;
	}

    public void setSelectedIndx(String[] selectedIndx) {

		this.selectedIndx = selectedIndx;
	}

	public String[] getSelectedIndx() {
		return selectedIndx;
	}

    public void setSelectedIndxIndexed(int index, String selectedIndx) {
		this.selectedIndx[index] = selectedIndx;
	}

	public String getSelectedIndxIndexed(int index) {
	  try {
		if( selectedIndx[index] == null) {
			return ApplicationConstants.EMPTY_STRING;
		} else {
		    return selectedIndx[index];
		}
	  } catch (Exception ex) {
		return ApplicationConstants.EMPTY_STRING;
	  }
	}


    public void setPdId(String[] pdId) {
		this.pdId = pdId;
	}

	public String[] getPdId() {
		return pdId;
	}


    public void setPdIdIndexed(int index, String pdId) {
		this.pdId[index] = pdId;
	}

	public String getPdIdIndexed(int index) {
	  try {
		if( pdId[index] == null) {
			return ApplicationConstants.EMPTY_STRING;
		} else {
		    return pdId[index];
		}
	  } catch (Exception ex) {
		return ApplicationConstants.EMPTY_STRING;
	  }
	}


    public void setRequestAction(String requestAction) {
		this.requestAction = requestAction;
	}

	public String getRequestAction() {
		return requestAction;
	}

    public void setPdIdForLoad(String pdIdForLoad) {
		this.pdIdForLoad = pdIdForLoad;
	}

	public String getPdIdForLoad() {
		if(pdIdForLoad == null) {
		  return ApplicationConstants.EMPTY_STRING;
	    }else {
		  return pdIdForLoad;
	    }
	}

    public String getPdStartDate() {
		return this.pdStartDate;
	}
    public void setPdStartDate(String pdStartDate) {
		this.pdStartDate = pdStartDate;

	}

    public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

    public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
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

    public String toString() {
       return new ToStringBuilder(this)
           .append("queryResults ", getQueryResults())
           .append("PdId ", getPdId())
           .append("selectedIndx ", getSelectedIndx())
           .append("requestAction ", getRequestAction())
           .append("pdIdForLoad ", getPdIdForLoad())
           .append("pdStartDate ", getPdStartDate())
           .append("index ", getIndex())
           .append("count ", getCount())
           .append("sortColumn ", getSortColumn())
           .append("sortAscendingIndicator ", getSortAscendingIndicator())

           .toString();
	}

}
