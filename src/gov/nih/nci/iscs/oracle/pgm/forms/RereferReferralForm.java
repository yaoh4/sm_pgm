package gov.nih.nci.iscs.oracle.pgm.forms;

import gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser;
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


public class RereferReferralForm extends ValidatorForm   {

    private List queryResults;
    private String rereferCA;
    private int selectedIndex;
    private String comments;
    private String requestAction;
    private Map commentsMap;
    private Map cancerActivitiesMap;
    private String[] selectedIndx;
    private int count;
    private String commentsToApply;
    private String caToApply;
    private boolean sortAscendingIndicator;
    private String sortColumn;

    public RereferReferralForm() {
  	    this.queryResults = (List) new ArrayList();
  	    this.rereferCA = ApplicationConstants.EMPTY_STRING;
  	    this.comments = ApplicationConstants.EMPTY_STRING;
  	    this.requestAction = ApplicationConstants.EMPTY_STRING;
  	    this.commentsMap = new HashMap();
  	    this.cancerActivitiesMap = new HashMap();
  	    this.commentsToApply = ApplicationConstants.EMPTY_STRING;
  	    this.caToApply = ApplicationConstants.EMPTY_STRING;
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

    public void setRereferCA(String rereferCA) {
		this.rereferCA = rereferCA;
	}

	public String getRereferCA() {
		return rereferCA;
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
		return commentsToApply;
	}

    public void setCaToApply(String caToApply) {
		this.caToApply = caToApply;
	}

	public String getCaToApply() {
		if(caToApply == null)
		   return ApplicationConstants.EMPTY_STRING;
		return caToApply;
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

   public Object getCommentMapped(String key) {
	   if(commentsMap.get(key) == null)
		   return ApplicationConstants.EMPTY_STRING;
        return  commentsMap.get(key);
    }

    public void setCommentMapped(String key, Object value) {
        commentsMap.put(key,  value);
    }

   public Map getCommentsMap() {
        return commentsMap;
    }

    public void setCommentsMap(Map commentsMap) {
        this.commentsMap = (Map) commentsMap;;
    }

   public Object getCancerActivityMapped(String key) {
	   if(cancerActivitiesMap.get(key) == null)
		   return ApplicationConstants.EMPTY_STRING;
        return cancerActivitiesMap.get(key);
    }

    public void setCancerActivityMapped(String key, Object value) {
        cancerActivitiesMap.put(key,  value);
    }

   public Map getCancerActivitiesMap() {
        return cancerActivitiesMap;
    }

    public void setCancerActivitiesMap(Map cancerActivitiesMap) {
        this.cancerActivitiesMap = (Map) cancerActivitiesMap;;
    }

    public void setSelectedIndx(String[] selectedIndx) {
		this.selectedIndx = selectedIndx;
	}

	public String[] getSelectedIndx() {
		return selectedIndx;
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
           .append("rereferCA ", getRereferCA())
           .append("comments ", getComments())
           .append("selectedIndex ", getSelectedIndex())
           .append("requestAction ", getRequestAction())
           .append("count ", getCount())
           .append("commentsToApply ", getCommentsToApply())
           .append("caToApply ", getCaToApply())
           .append("CommentsMap ", getCommentsMap())
           .append("CancerActivitiesMap ", getCancerActivitiesMap())
           .append("sortColumn ", getSortColumn())
           .append("sortAscendingIndicator ", getSortAscendingIndicator())
           .append("selectedIndx ", getSelectedIndx())

           .toString();
	}

}
