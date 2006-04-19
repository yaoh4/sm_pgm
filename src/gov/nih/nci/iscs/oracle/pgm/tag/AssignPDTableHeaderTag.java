package gov.nih.nci.iscs.oracle.pgm.tag;
//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.PdAssignmentForm;


import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class AssignPDTableHeaderTag extends TagSupport
{

  public int doStartTag() {
    try {
      StringBuffer buf = new StringBuffer();
      JspWriter out = pageContext.getOut();
      ServletContext sc = pageContext.getServletContext();
      HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
      PdAssignmentForm mForm = (PdAssignmentForm) request.getAttribute("pdAssignmentForm");
      String lastSortColumn = mForm.getSortColumn();
      boolean lastSortOrderAsc = mForm.getSortAscendingIndicator();


      boolean mTrue = true;
      boolean mFalse = false;

	  buf.append("<th id=\"header00\" width=\"3%\" align=middle class=listCellHead>Sel</th>" );

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.GRANT_NUMBER_SORT)){
		  buf.append("<th id=\"header01\" width=\"15%\" align=middle class=listCellHead><a anchor=\"#\" href=\"javascript:sortReferralList(\'");
		  buf.append(ApplicationConstants.GRANT_NUMBER_SORT );
		  buf.append("\'");
	      if (lastSortOrderAsc){
			  buf.append(", \'" + mFalse + "\')\">Grant Number");
              buf.append("&nbsp;  <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\"> ");
		  }else{
			  buf.append(", \'" + mTrue + "\')\">Grant Number");
             buf.append("&nbsp;  <img src=\"/pgm/images/downarrow.gif\"  border=\"0\" alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header01\" width=\"15%\" align=middle class=listCellHead><a anchor=\"#\" href=\"javascript:sortReferralList(\'");
		  buf.append(ApplicationConstants.GRANT_NUMBER_SORT);
		  buf.append("\'");
		  buf.append(", \'" + mTrue + "\')\">Grant Number");
		  buf.append("</a></th>");
	  }

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.PD_FULL_NAME_SORT)){
		  buf.append("<th id=\"header02\" width=\"25%\" align=middle class=listCellHead><a anchor=\"#\" href=\"javascript:sortReferralList(\'");
		  buf.append(ApplicationConstants.PD_FULL_NAME_SORT );
		  buf.append("\'");
	      if (lastSortOrderAsc){
			  buf.append(", \'" + mFalse + "\')\">Current PD");
              buf.append("&nbsp;  <img src=\"/pgm/images/uparrow.gif\" border=\"0\"  alt=\"asc\"> ");
		  }else{
			  buf.append(", \'" + mTrue + "\')\">Current PD");
             buf.append("&nbsp;  <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"  alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header02\" width=\"25%\" align=middle class=listCellHead><a anchor=\"#\" href=\"javascript:sortReferralList(\'");
		  buf.append(ApplicationConstants.PD_FULL_NAME_SORT);
		  buf.append("\'");
		  buf.append(", \'" + mTrue + "\')\">Current PD");
		  buf.append("</a></th>");
	  }

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.CA_SORT)){
		  buf.append("<th id=\"header03\" width=\"6%\" align=middle class=listCellHead><a anchor=\"#\" href=\"javascript:sortReferralList(\'");
		  buf.append(ApplicationConstants.CA_SORT );
		  buf.append("\'");
	      if (lastSortOrderAsc){
			  buf.append(", \'" + mFalse + "\')\">Current CA");
              buf.append("&nbsp;  <img src=\"/pgm/images/uparrow.gif\" border=\"0\"  alt=\"asc\"> ");
		  }else{
			  buf.append(", \'" + mTrue + "\')\">Current CA");
             buf.append("&nbsp;  <img src=\"/pgm/images/downarrow.gif\"  border=\"0\" alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header03\" width=\"6%\" align=middle class=listCellHead><a anchor=\"#\" href=\"javascript:sortReferralList(\'");
		  buf.append(ApplicationConstants.CA_SORT);
		  buf.append("\'");
		  buf.append(", \'" + mTrue + "\')\">Current CA");
		  buf.append("</a></th>");
	  }


      buf.append("<th id= headers=\"header04\" width=\"27%\" align=middle class=listCellHead>Assign To</th>");
      buf.append("<th id= headers=\"header05\" width=\"10%\" class=listCellHead>Start Date</th>");


      out.print( buf.toString());


  }  catch(Exception e) {
      e.printStackTrace();
  }
  return SKIP_BODY;
}



}