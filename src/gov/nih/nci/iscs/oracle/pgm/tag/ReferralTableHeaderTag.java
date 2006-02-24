package gov.nih.nci.iscs.oracle.pgm.tag;
//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForReferralForm;


import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class ReferralTableHeaderTag extends TagSupport
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
		  lastSortColumn = ApplicationConstants.FULL_GRANT_NUMBER_SORT;
		  lastSortOrder = ApplicationConstants.SORT_ASC;
	  }

	  buf.append("<th id=\"header00\" width=\"3%\" align=middle class=listCellHead>Sel</th>" );

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.FULL_GRANT_NUMBER_SORT)){
		  buf.append("<th id=\"header01\" width=\"16%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.FULL_GRANT_NUMBER_SORT );
		  buf.append("\')\">Grant Number");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("&nbsp;  <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\"> ");
		  }else{
              buf.append("&nbsp;  <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header01\" width=\"16%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.FULL_GRANT_NUMBER_SORT);
		  buf.append("\')\">Grant Number</a></th>");
	  }

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.CANCER_ACTIVITY_SORT)){
		  buf.append("<th id=\"header02\" width=\"6%\" align=middle class=listCellHead><a href=\"javascript:sortGrantList(\'" );
		  buf.append(ApplicationConstants.CANCER_ACTIVITY_SORT);
		  buf.append("\')\">CA");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("&nbsp; <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\">");
		  }else{
              buf.append("&nbsp; <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header02\" width=\"4%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.CANCER_ACTIVITY_SORT);
		  buf.append("\')\">CA</a></th>");
	  }


      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.DUAL_CA_SORT)){
		  buf.append("<th id=\"header03\" width=\"6%\" align=middle class=listCellHead><a href=\"javascript:sortGrantList(\'" );
		  buf.append(ApplicationConstants.DUAL_CA_SORT);
		  buf.append("\')\">Dual CA");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("&nbsp; <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\">");
		  }else{
              buf.append("&nbsp; <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header03\" width=\"6%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.DUAL_CA_SORT);
		  buf.append("\')\">Dual CA</a></th>");
	  }


      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.PI_LAST_NAME_SORT)){
		  buf.append("<th id=\"header04\" width=\"10%\" align=middle class=listCellHead><a href=\"javascript:sortGrantList(\'" );
		  buf.append(ApplicationConstants.PI_LAST_NAME_SORT);
		  buf.append("\')\">PI");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("<img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\">");
		  }else{
              buf.append("<img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header04\" width=\"10%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.PI_LAST_NAME_SORT);
		  buf.append("\')\">PI</a></th>");
	  }

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.ORGANIZATION_SORT)){
		  buf.append("<th id=\"header05\" width=\"15%\" align=middle class=listCellHead><a href=\"javascript:sortGrantList(\'" );
		  buf.append(ApplicationConstants.ORGANIZATION_SORT);
		  buf.append("\')\">Institution");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("&nbsp; <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\">");
		  }else{
              buf.append("&nbsp; <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header05\" width=\"15%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.ORGANIZATION_SORT);
		  buf.append("\')\">Institution</a></th>");
	  }



      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.PROJECT_TITLE_SORT)){
		  buf.append("<th id=\"header06\" width=\"16%\" align=middle class=listCellHead><a href=\"javascript:sortGrantList(\'" );
		  buf.append(ApplicationConstants.PROJECT_TITLE_SORT);
		  buf.append("\')\">Title");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("&nbsp; <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\">");
		  }else{
              buf.append("&nbsp; <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header06\" width=\"16%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.PROJECT_TITLE_SORT);
		  buf.append("\')\">Title</a></th>");
	  }


      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.ARA_SORT)){
		  buf.append("<th id=\"header07\" width=\"6%\" align=middle class=listCellHead><a href=\"javascript:sortGrantList(\'" );
		  buf.append(ApplicationConstants.ARA_SORT);
		  buf.append("\')\">ARA?");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("&nbsp; <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\">");
		  }else{
              buf.append("&nbsp; <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header07\" width=\"6%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.ARA_SORT);
		  buf.append("\')\">ARA?</a></th>");
	  }



      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.NCAB_SORT)){
		  buf.append("<th id=\"header08\" width=\"8%\" align=middle class=listCellHead><a href=\"javascript:sortGrantList(\'" );
		  buf.append(ApplicationConstants.NCAB_SORT);
		  buf.append("\')\">NCAB");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("&nbsp; <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\">");
		  }else{
              buf.append("&nbsp; <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header08\" width=\"8%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.NCAB_SORT);
		  buf.append("\')\">NCAB</a></th>");
	  }

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.CURR_REFERRAL_DATE_SORT)){
		  buf.append("<th id=\"header09\" width=\"10%\" align=middle class=listCellHead><a href=\"javascript:sortGrantList(\'" );
		  buf.append(ApplicationConstants.CURR_REFERRAL_DATE_SORT);
		  buf.append("\')\">Referred Date");
	      if (lastSortOrder.equalsIgnoreCase(ApplicationConstants.SORT_ASC) ){
              buf.append("&nbsp; <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"asc\">");
		  }else{
              buf.append("&nbsp; <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"asc\">");
		  }
		  buf.append("</a></th>");
	  } else {
		  buf.append("<th id=\"header09\" width=\"10%\" align=middle class=listCellHead><a anchor=\"#Grants\" href=\"javascript:sortGrantList(\'");
		  buf.append(ApplicationConstants.CURR_REFERRAL_DATE_SORT);
		  buf.append("\')\">Referred Date</a></th>");
	  }



	  buf.append("<th id=\"header10\" width=\"5%\" align=middle class=listCellHead>eGrants</th>");

      out.print( buf.toString());


  }  catch(Exception e) {
      e.printStackTrace();
  }
  return SKIP_BODY;
}



}