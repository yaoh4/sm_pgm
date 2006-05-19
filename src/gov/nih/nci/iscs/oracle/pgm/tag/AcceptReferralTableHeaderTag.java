package gov.nih.nci.iscs.oracle.pgm.tag;
//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.AcceptReferralForm;


import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class AcceptReferralTableHeaderTag extends TagSupport
{

  public int doStartTag() {
    try {
      StringBuffer buf = new StringBuffer();
      JspWriter out = pageContext.getOut();
      ServletContext sc = pageContext.getServletContext();
      HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
      AcceptReferralForm mForm = (AcceptReferralForm) request.getAttribute("acceptReferralForm");
      String lastSortColumn = mForm.getSortColumn();
      boolean lastSortOrderAsc = mForm.getSortAscendingIndicator();


      boolean mTrue = true;
      boolean mFalse = false;

	  buf.append("<th id=\"header00\" width=\"3%\" align=middle class=listCellHead>Sel</th>" );

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.GRANT_NUMBER_SORT)){
		  buf.append("<th id=\"header01\" width=\"20%\" align=middle class=listCellHead><a anchor=\"#\" href=\"javascript:sortReferralList(\'");
		  buf.append(ApplicationConstants.GRANT_NUMBER_SORT );
		  buf.append("\'");
	      if (lastSortOrderAsc){
			  buf.append(", \'" + mFalse + "\')\">Grant Number");
              buf.append("&nbsp;  <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\"> ");
		  }else{
			  buf.append(", \'" + mTrue + "\')\">Grant Number");
             buf.append("&nbsp;  <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header01\" width=\"20%\" align=middle class=listCellHead><a anchor=\"#\" href=\"javascript:sortReferralList(\'");
		  buf.append(ApplicationConstants.GRANT_NUMBER_SORT);
		  buf.append("\'");
		  buf.append(", \'" + mTrue + "\')\">Grant Number");
	  }

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.CA_SORT)){
		  buf.append("<th id=\"header02\" width=\"6%\" align=middle class=listCellHead><a anchor=\"#\" href=\"javascript:sortReferralList(\'");
		  buf.append(ApplicationConstants.CA_SORT );
		  buf.append("\'");
	      if (lastSortOrderAsc){
			  buf.append(", \'" + mFalse + "\')\">CA");
              buf.append("&nbsp;  <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\"> ");
		  }else{
			  buf.append(", \'" + mTrue + "\')\">CA");
             buf.append("&nbsp;  <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header02\" width=\"6%\" align=middle class=listCellHead><a anchor=\"#\" href=\"javascript:sortReferralList(\'");
		  buf.append(ApplicationConstants.CA_SORT);
		  buf.append("\'");
		  buf.append(", \'" + mTrue + "\')\">CA");
	  }

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.PI_LAST_NAME_SORT)){
		  buf.append("<th id=\"header03\" width=\"23%\" align=middle class=listCellHead><a anchor=\"#\" href=\"javascript:sortReferralList(\'");
		  buf.append(ApplicationConstants.PI_LAST_NAME_SORT );
		  buf.append("\'");
	      if (lastSortOrderAsc){
			  buf.append(", \'" + mFalse + "\')\">PI Name");
              buf.append("&nbsp;  <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\"> ");
		  }else{
			  buf.append(", \'" + mTrue + "\')\">PI Name");
             buf.append("&nbsp;  <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header03\" width=\"23%\" align=middle class=listCellHead><a anchor=\"#\" href=\"javascript:sortReferralList(\'");
		  buf.append(ApplicationConstants.PI_LAST_NAME_SORT);
		  buf.append("\'");
		  buf.append(", \'" + mTrue + "\')\">PI Name");
	  }

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.INST_NAME_SORT)){
		  buf.append("<th id=\"header03\" width=\"23%\" align=middle class=listCellHead><a anchor=\"#\" href=\"javascript:sortReferralList(\'");
		  buf.append(ApplicationConstants.INST_NAME_SORT );
		  buf.append("\'");
	      if (lastSortOrderAsc){
			  buf.append(", \'" + mFalse + "\')\">Institution");
              buf.append("&nbsp;  <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\"> ");
		  }else{
			  buf.append(", \'" + mTrue + "\')\">Institution");
             buf.append("&nbsp;  <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header03\" width=\"23%\" align=middle class=listCellHead><a anchor=\"#\" href=\"javascript:sortReferralList(\'");
		  buf.append(ApplicationConstants.INST_NAME_SORT);
		  buf.append("\'");
		  buf.append(", \'" + mTrue + "\')\">Institution");
	  }



      out.print( buf.toString());


  }  catch(Exception e) {
      e.printStackTrace();
  }
  return SKIP_BODY;
}



}