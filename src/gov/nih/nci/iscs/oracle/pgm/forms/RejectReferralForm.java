package gov.nih.nci.iscs.oracle.pgm.forms;

import java.util.*;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm ;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.servlet.http.HttpServletRequest;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;


public class RejectReferralForm extends ValidatorForm   {

    private List queryResults;
    private String comments;
    private int selectedIndex;
    private String requestAction;
    private Map commentsMap;
    private Map dbCommentsMap;
    private String[] selectedIndx;
    private int count;
    private String commentsToApply;
    private boolean sortAscendingIndicator;
    private String sortColumn;
    private String rejectionSelection;

    public RejectReferralForm() {
  	    this.queryResults = (List) new ArrayList();
  	    this.comments = ApplicationConstants.EMPTY_STRING;
  	    this.requestAction = ApplicationConstants.EMPTY_STRING;
  	    this.commentsMap = new HashMap();
  	    this.dbCommentsMap = new HashMap();
  	    this.commentsToApply = ApplicationConstants.EMPTY_STRING;
  	    this.rejectionSelection = ApplicationConstants.EMPTY_STRING;
  	    this.sortColumn = "grantNumber";
  	    this.sortAscendingIndicator = true;

    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
    }

   public void setQueryResults(List queryResults) {
		this.count = queryResults.size();
		this.queryResults = queryResults;
	}

	public List getQueryResults() {
		return queryResults;
	}

    public void setComments(String comments) {
		this.comments = comments;
	}

	public String getComments() {
		return comments;
	}

    public void setCommentsToApply(String commentsToApply) {
		this.commentsToApply = commentsToApply;
	}

	public String getCommentsToApply() {
		if(this.commentsToApply == null)
			return ApplicationConstants.EMPTY_STRING;
		return commentsToApply;
	}

    public void setRejectionSelection(String rejectionSelection) {
		this.rejectionSelection = rejectionSelection;
	}

	public String getRejectionSelection() {
		if(this.rejectionSelection == null)
			return ApplicationConstants.EMPTY_STRING;
		return rejectionSelection;
	}


    public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	public int getSelectedIndex() {
		return selectedIndex;
	}


    public void setRequestAction(String requestAction) {
		this.requestAction = requestAction;
	}

	public String getRequestAction() {
		return requestAction;
	}

   public Object getCommentMapped(String key) {
	   if(commentsMap.get(key) == null)
		   return ApplicationConstants.EMPTY_STRING;
       return commentsMap.get(key);

    }

    public void setCommentMapped(String key, Object value) {
        commentsMap.put(key, value);
    }

   public Map getCommentsMap() {
        return commentsMap;
    }

    public void setCommentsMap(Map commentsMap) {
        this.commentsMap = (Map) commentsMap;;
    }

   public Object getDbCommentMapped(String key) {
	   if(dbCommentsMap.get(key) == null)
		   return ApplicationConstants.EMPTY_STRING;
       return dbCommentsMap.get(key);

    }

    public void setDbCommentMapped(String key, Object value) {
        dbCommentsMap.put(key, value);
    }

   public Map getDbCommentsMap() {
        return dbCommentsMap;
    }

    public void setDbCommentsMap(Map dbCommentsMap) {
        this.dbCommentsMap = (Map) dbCommentsMap;;
    }
    public void setSelectedIndx(String[] selectedIndx) {
		this.selectedIndx = selectedIndx;
	}

	public String[] getSelectedIndx() {
		return selectedIndx;
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
    public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}


    public String toString() {
       return new ToStringBuilder(this)
           .append("queryResults ", getQueryResults())
           .append("Comments ", getComments())
           .append("CommentsToApply ", getCommentsToApply())
           .append("selectedIndex ", getSelectedIndex())
           .append("requestAction ", getRequestAction())
           .append("count ", getCount())
           .append("sortColumn ", getSortColumn())
           .append("sortAscendingIndicator ", getSortAscendingIndicator())
           .append("selectedIndx ", getSelectedIndx())
           .append("commentsMap ", getCommentsMap())
           .append("dbCommentsMap ", getDbCommentsMap())
           .append("rejectionSelection ", getRejectionSelection())
           .toString();
	}

}
