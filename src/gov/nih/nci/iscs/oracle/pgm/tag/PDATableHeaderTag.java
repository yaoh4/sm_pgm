package gov.nih.nci.iscs.oracle.pgm.tag;
//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForReferralForm;


import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class PDATableHeaderTag extends TagSupport
{

  public int doStartTag() {
    try {
      int minPage = 0;
      int maxPage = 0;
      StringBuffer buf = new StringBuffer();
      JspWriter out = pageContext.getOut();
      ServletContext sc = pageContext.getServletContext();
      HttpSession session = pageContext.getSession();
      String lastSortOrder = (String) session.getAttribute(ApplicationConstants.LAST_SORT_ORDER);
      String lastSortColumn = (String) session.getAttribute(ApplicationConstants.LAST_SORT_COLUMN);

      if (lastSortColumn == null) {
		  lastSortColumn = ApplicationConstants.PD_LAST_NAME_SORT;
		  lastSortOrder = ApplicationConstants.SORT_ASC;
	  }

	  buf.append("<th id=\"header00\" width=\"3%\" align=middle class=listCellHead>Sel</th>" );

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.PD_LAST_NAME_SORT)){
		  buf.append("<th id=\"header01\" width=\"14%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.PD_LAST_NAME_SORT );
		  buf.append("\')\">Program Director</a>");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("&nbsp; &nbsp <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\"> </th>");
		  }else{
              buf.append("&nbsp; &nbsp <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\"> </th>");
		  }
	  } else {
		  buf.append("<th id=\"header01\" width=\"14%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.PD_LAST_NAME_SORT);
		  buf.append("\')\">PD Name</a></th>");
	  }

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.PD_ORGANIZATION_SORT)){
		  buf.append("<th id=\"header02\" width=\"20%\" align=middle class=listCellHead><a href=\"javascript:sortGrantList(\'" );
		  buf.append(ApplicationConstants.PD_ORGANIZATION_SORT);
		  buf.append("\')\">PD Org</a>");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("&nbsp; &nbsp <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\"> </th>");
		  }else{
              buf.append("&nbsp; &nbsp <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\"> </th>");
		  }
	  } else {
		  buf.append("<th id=\"header02\" width=\"20%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.PD_ORGANIZATION_SORT);
		  buf.append("\')\">PD Org</a></th>");
	  }

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.FISCAL_YEAR_SORT)){
		  buf.append("<th id=\"header03\" width=\"6%\" align=middle class=listCellHead><a href=\"javascript:sortGrantList(\'" );
		  buf.append(ApplicationConstants.FISCAL_YEAR_SORT);
		  buf.append("\')\">FY</a>");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("&nbsp; &nbsp <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\"> </th>");
		  }else{
              buf.append("&nbsp; &nbsp <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\"> </th>");
		  }
	  } else {
		  buf.append("<th id=\"header03\" width=\"6%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.FISCAL_YEAR_SORT);
		  buf.append("\')\">fy</a></th>");
	  }


      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.FULL_GRANT_NUMBER_SORT)){
		  buf.append("<th id=\"header04\" width=\"16%\" align=middle class=listCellHead><a href=\"javascript:sortGrantList(\'" );
		  buf.append(ApplicationConstants.FULL_GRANT_NUMBER_SORT);
		  buf.append("\')\">Grant Number</a>");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("&nbsp; &nbsp <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\"> </th>");
		  }else{
              buf.append("&nbsp; &nbsp <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\"> </th>");
		  }
	  } else {
		  buf.append("<th id=\"header04\" width=\"16%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.FULL_GRANT_NUMBER_SORT);
		  buf.append("\')\">Grant Number</a></th>");
	  }


      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.CANCER_ACTIVITY_SORT)){
		  buf.append("<th id=\"header05\" width=\"6%\" align=middle class=listCellHead><a href=\"javascript:sortGrantList(\'" );
		  buf.append(ApplicationConstants.CANCER_ACTIVITY_SORT);
		  buf.append("\')\">CA</a>");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("&nbsp; &nbsp <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\"> </th>");
		  }else{
              buf.append("&nbsp; &nbsp <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\"> </th>");
		  }
	  } else {
		  buf.append("<th id=\"header05\" width=\"6%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.CANCER_ACTIVITY_SORT);
		  buf.append("\')\">CA</a></th>");
	  }


      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.NCAB_SORT)){
		  buf.append("<th id=\"header06\" width=\"10%\" align=middle class=listCellHead><a href=\"javascript:sortGrantList(\'" );
		  buf.append(ApplicationConstants.NCAB_SORT);
		  buf.append("\')\">NCAB</a>");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("&nbsp; &nbsp <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\"> </th>");
		  }else{
              buf.append("&nbsp; &nbsp <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\"> </th>");
		  }
	  } else {
		  buf.append("<th id=\"header06\" width=\"10%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.NCAB_SORT);
		  buf.append("\')\">NCAB</a></th>");
	  }


      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.PD_START_DATE_SORT)){
		  buf.append("<th id=\"header07\" width=\"15%\" align=middle class=listCellHead><a href=\"javascript:sortGrantList(\'" );
		  buf.append(ApplicationConstants.PD_START_DATE_SORT);
		  buf.append("\')\">PD Start Date</a>");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("&nbsp; &nbsp <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\"> </th>");
		  }else{
              buf.append("&nbsp; &nbsp <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\"> </th>");
		  }
	  } else {
		  buf.append("<th id=\"header07\" width=\"15%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.PD_START_DATE_SORT);
		  buf.append("\')\">PD Start Date</a></th>");
	  }


      out.print( buf.toString());


  }  catch(Exception e) {
      e.printStackTrace();
  }
  return SKIP_BODY;
}



}