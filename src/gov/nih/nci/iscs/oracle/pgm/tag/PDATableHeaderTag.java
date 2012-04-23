package gov.nih.nci.iscs.oracle.pgm.tag;
//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForm;


import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class PDATableHeaderTag extends TagSupport
{
  private boolean lastSortOrderAsc;
  private String lastSortColumn;

  public int doStartTag() {
    try {

      StringBuffer buf = new StringBuffer();
      JspWriter out = pageContext.getOut();
      ServletContext sc = pageContext.getServletContext();
      HttpSession session = pageContext.getSession();
      HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
      RetrieveGrantsForm mForm = (RetrieveGrantsForm) request.getAttribute("retrieveGrantsForPDAForm");


      lastSortColumn = (String) session.getAttribute(ApplicationConstants.LAST_SORT_COLUMN);
      lastSortOrderAsc = mForm.getSortAscendingIndicator();
      String returnText = "";

      if (lastSortColumn == null) {
		  lastSortColumn = ApplicationConstants.FULL_GRANT_NUMBER_SORT;
		  lastSortOrderAsc = true;
	  }

	  buf.append("<th id=\"header00\" width=\"3%\" align=middle class=listCellHead>Sel</th>" );

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.FULL_GRANT_NUMBER_SORT) ||
         lastSortColumn.equalsIgnoreCase(ApplicationConstants.GRANT_NUMBER_SORT) ){
		  returnText = formatColumnText(true, "Grant Number", "16%", "listCellHead", ApplicationConstants.GRANT_NUMBER_SORT, "header01");
	  } else {
		  returnText = formatColumnText(false, "Grant Number", "16%", "listCellHead", ApplicationConstants.GRANT_NUMBER_SORT, "header01");
	  }
      buf.append(returnText);
      //bug fix for PROGRAMMANAGEMENT-190
      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.PI_LAST_NAME_PDA__SORT)){
		  returnText = formatColumnText(true, "PI Name", "20%", "listCellHead", ApplicationConstants.PI_LAST_NAME_PDA__SORT, "header02");
	  } else {
		  returnText = formatColumnText(false, "PI Name", "20%", "listCellHead", ApplicationConstants.PI_LAST_NAME_PDA__SORT, "header02");
	  }
      buf.append(returnText);


      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.FISCAL_YEAR_SORT)){
		  returnText = formatColumnText(true, "FY", "6%", "listCellHead", ApplicationConstants.FISCAL_YEAR_SORT, "header03");
	  } else {
		  returnText = formatColumnText(false, "FY", "6%", "listCellHead", ApplicationConstants.FISCAL_YEAR_SORT, "header03");
	  }
      buf.append(returnText);

      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.NCAB_SORT)){
		  returnText = formatColumnText(true, "NCAB", "10%", "listCellHead", ApplicationConstants.NCAB_SORT, "header04");
	  } else {
		  returnText = formatColumnText(false, "NCAB", "10%", "listCellHead", ApplicationConstants.NCAB_SORT, "header04");
	  }
      buf.append(returnText);


      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.RFA_PA_NUMBER_SORT)){
		  returnText = formatColumnText(true, "RFA/PA", "6%", "listCellHead", ApplicationConstants.RFA_PA_NUMBER_SORT, "header05");
	  } else {
		  returnText = formatColumnText(false, "RFA/PA", "6%", "listCellHead", ApplicationConstants.RFA_PA_NUMBER_SORT, "header05");
	  }
      buf.append(returnText);


      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.CANCER_ACTIVITY_SORT)){
		  returnText = formatColumnText(true, "CA", "6%", "listCellHead", ApplicationConstants.CANCER_ACTIVITY_SORT, "header06");
	  } else {
		  returnText = formatColumnText(false, "CA", "6%", "listCellHead", ApplicationConstants.CANCER_ACTIVITY_SORT, "header06");
	  }
      buf.append(returnText);


      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.PD_FULL_NAME_SORT)){
		  returnText = formatColumnText(true, "PD", "14%", "listCellHead", ApplicationConstants.PD_FULL_NAME_SORT, "header07");
	  } else {
		  returnText = formatColumnText(false, "PD", "14%", "listCellHead", ApplicationConstants.PD_FULL_NAME_SORT, "header07");
	  }
      buf.append(returnText);


      if(lastSortColumn.equalsIgnoreCase(ApplicationConstants.PD_START_DATE_SORT)){
		  returnText = formatColumnText(true, "PD Start Date", "15%", "listCellHead", ApplicationConstants.PD_START_DATE_SORT, "header08");
	  } else {
		  returnText = formatColumnText(false, "PD Start Date", "15%", "listCellHead", ApplicationConstants.PD_START_DATE_SORT, "header08");
	  }
      buf.append(returnText);


      out.print( buf.toString());


  }  catch(Exception e) {
      e.printStackTrace();
  }
  return SKIP_BODY;
}

private String formatSortImages(String sortColumn) {
	String mReturn = ApplicationConstants.EMPTY_STRING;

	boolean mFalse = false;
	boolean mTrue = true;
	String mFalseString = ", \'" + mFalse + "\')\">" + sortColumn;
	String mTrueString = ", \'" + mTrue + "\')\">" + sortColumn;
	String mUpArrowText = "&nbsp; <img src=\"/pgm/images/uparrow.gif\" border=\"0\"   alt=\"Normal Sort\">";
	String mDownArrowText = "&nbsp; <img src=\"/pgm/images/downarrow.gif\"  border=\"0\"   alt=\"Reverse Sort\">";

	if(lastSortOrderAsc){
		mReturn = mFalseString + mUpArrowText;
	}else{
		mReturn = mTrueString + mDownArrowText;
	}
	return mReturn;

}

private String formatColumnText(boolean lastSort, String sortColumn, String mWidth, String mClass, String ColumnText, String mHeader){

	String mReturn = ApplicationConstants.EMPTY_STRING;
	boolean mTrue = true;

    String mText_1 = "<th id=\"" + mHeader + "\" width=\"" + mWidth + "\" align=middle class=" + mClass + "><a href=\"javascript:sortGrantList(\'";
	String mText_2 = ColumnText + "\'";
	String mText_3 = ", \'" + mTrue + "\')\">" + sortColumn;

	if(lastSort){
		mReturn = mText_1 + mText_2;
		mReturn = mReturn + " " + formatSortImages(sortColumn);
	}else{
		mReturn = mText_1 + mText_2 + mText_3;
	}

	return mReturn;
}



}
