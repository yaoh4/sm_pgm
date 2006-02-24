package gov.nih.nci.iscs.oracle.pgm.tag;

import org.apache.struts.util.LabelValueBean;


//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.LookUpObject;
import gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.PdAssignmentForm;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralActionObject;
import gov.nih.nci.iscs.oracle.pgm.forms.PaginationObject;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.SelectedGrants;
import gov.nih.nci.iscs.oracle.pgm.service.GrantSearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.PDASearchResultObject;
import org.springframework.context.ApplicationContext;
import gov.nih.nci.iscs.oracle.pgm.service.impl.ProgamDirectorServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralListComparator;
import java.util.*;
import java.text.*;


import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class FormatPDAssignmentListTag extends TagSupport {
  private String key  ;
  private int index;
  private String formName;
  private SelectedGrants mSelectedGrants;
  private String mKey;
  private String action;
  private ApplicationContext mApplicationContext;
  private List mPdAssignmentList;
  private ArrayList mAssignmentActionList;
  private PdAssignmentForm mForm;
  private String formattedDate;
  private Date today;
  public static String className = "";
  public static String borderClassName = "";
  public static String buttonClassName = "";

  public void setKey(String key) {

     this.key = key;
  }

  public void setAction(String action) {

     this.action = action;
  }

  public void setFormName(String formName) {
     this.formName = formName;
  }
  public void setIndex(int index) {

     this.index = index;
  }

  public int doStartTag() {
    try {
      HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
      JspWriter out = pageContext.getOut();
      ServletContext sc = pageContext.getServletContext();
      today = new java.util.Date();
      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
      formattedDate = formatter.format(today);
      mApplicationContext =  (ApplicationContext) sc.getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
      mPdAssignmentList = (List) request.getSession().getAttribute("PdAssignmentList");
	  String nullCancerActivity = null;
	  if(mPdAssignmentList == null) {
		  mPdAssignmentList = getPdAssignmentList(nullCancerActivity);
          request.getSession().setAttribute("PdAssignmentList", mPdAssignmentList);
	  }
      mSelectedGrants = (SelectedGrants) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS);
	  mAssignmentActionList = (ArrayList) request.getSession().getAttribute(ApplicationConstants.PD_ASSIGNMENT_LIST);;
	  mForm = (PdAssignmentForm) request.getAttribute("pdAssignmentForm");
	  StringBuffer buf = new StringBuffer();

      String pdIdForLoad = mForm.getPdIdForLoad();
	  if(action.equalsIgnoreCase(ApplicationConstants.FORMAT_TABLE)) {
		  formatTable(buf, pdIdForLoad);
	  } else {
		  formatSelect(buf, pdIdForLoad);
	  }

      out.print( buf.toString());
     } catch(Exception e) {
      e.printStackTrace();
     }
   return SKIP_BODY;
  }

  private void formatTable(StringBuffer buf, String pdIdForLoad) {

      Iterator iterator = mAssignmentActionList.iterator();
      while  (iterator.hasNext()) {
           PDASearchResultObject sortedObj = (PDASearchResultObject) iterator.next();
           mKey = sortedObj.getApplId().toString() + sortedObj.getCancerActivity();
           PDASearchResultObject obj = (PDASearchResultObject) mSelectedGrants.get(mKey);
	       formatPDAs(obj, buf);
	   }

  }


  private void 	formatSelect(StringBuffer buf, String pdIdForLoad  ){


      String nullCancerActivity = null;
      buf.append("<SELECT NAME=\"pdIdForLoad\" SIZE=\"1\" >");
      addPdSelect(buf, true, nullCancerActivity, pdIdForLoad);
  }


  private void 	formatPDAs(PDASearchResultObject obj, StringBuffer buf  ){

	  buf.append("<tr>");
      setClassForStyles(obj.getMarked());
      if(obj.getSelected()) {
		 buf.append("<td headers=\"header00\" width=\"3%\" class=listCell><input type=\"checkbox\" value=\"" + mKey + "\" NAME=\"selectedIndx\"></td>");
      } else {
		 buf.append("<td headers=\"header00\" width=\"3%\" class=listCell><input type=\"checkbox\" value=\"" + mKey + "\" NAME=\"selectedIndx\"></td>");
	  }
      buf.append("<td headers=\"header01\" width=\"15%\" class=" + className + ">" + obj.getGrantNumber()+ "&nbsp;</td>");
      buf.append("<td headers=\"header02\" width=\"25%\" class=" + className + ">" + obj.getPdFullName() + "&nbsp;</td>");
      buf.append("<td headers=\"header03\" width=\"10%\" class=" + className + ">" + obj.getCancerActivity() + "&nbsp;");
      buf.append("</td>");

      buf.append("<td headers=\"header04\" width=\"27%\" class=" + className + ">" );
      buf.append("<SELECT NAME=\"pdId\" SIZE=\"1\" >");

      boolean showAll  = processFilterLogic(obj.getCancerActivity(), obj.getPdFullName());
      addPdSelect(buf, showAll, obj.getCancerActivity(), obj.getAssignmentCA() + obj.getPdId());
	  buf.append("</td>");
      buf.append("<td headers=\"header05\" width=\"10%\" class=" + borderClassName + "><input type=\"textbox\" name = \"pdStartDate\" value=" + formattedDate + " >" + "&nbsp;");
      buf.append("<a href=\"javascript:void(0)\" onclick=\"gfPop.fPopCalendar(document.pdAssignmentForm.pdStartDate.value);return false;\">");
      buf.append("<img src=\"images/IconCalendar.gif\" width=\"16\" height=\"15\" border=\"0\" alt=\"Date Picker\" />");
	  buf.append("</a></tr>");
	  buf.append("\n");
  }

  private List getPdAssignmentList(String cancerActivity) {

	// get the lookup infomation
    ProgamDirectorServiceImpl mProgamDirectorServiceImpl =  new ProgamDirectorServiceImpl(mApplicationContext);
    List mList = null;
    if(cancerActivity == null || cancerActivity.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)) {
	   mList  = mProgamDirectorServiceImpl.getAllProgramDirectors(cancerActivity, false);
    } else {
	   mList  = mProgamDirectorServiceImpl.getAllProgramDirectors(cancerActivity, true);
    }
    return mList;
  }

  private void addPdSelect(StringBuffer buf, boolean showAll, String cancerActivity, String selectedPd) {
	 buf.append("<option SELECTED value=");
	 buf.append(ApplicationConstants.EMPTY_STRING);
	 buf.append(">");
	 buf.append(ApplicationConstants.EMPTY_STRING);
     buf.append("</option>\n");
     Iterator mIterator = null;
     if(showAll){
		 mIterator = mPdAssignmentList.iterator();
	 } else {
		 List mList = getPdAssignmentList(cancerActivity);
		 mIterator = mList.iterator();
	 }



	 while(mIterator.hasNext() ){
	    LabelValueBean mLookUpValueBean = (LabelValueBean) mIterator.next();
	    String mValue = (String) mLookUpValueBean.getValue();
	    String mLabel = (String) mLookUpValueBean.getLabel();
	    if(mValue.equalsIgnoreCase(selectedPd)) {
	  	   buf.append("<option SELECTED value=");
	    } else {
	       buf.append("<option value=");
	  	}
	    buf.append(mValue);
	  	buf.append(">");
	    buf.append(mLabel);
	    buf.append("</option>");
     }

  }

  private boolean processFilterLogic(String cancerActivity, String pdId) {


     if(cancerActivity == null)
        cancerActivity = ApplicationConstants.EMPTY_STRING;
     if(pdId == null)
        pdId = ApplicationConstants.EMPTY_STRING;

     // Cancer Avtivity & Program Dir Id are both null;
     if(cancerActivity.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) &
		pdId.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ){
		return true;
	 }


     // Cancer activity is not null
     if(!cancerActivity.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ){
		 // and pdId is null
		 if(pdId.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)) {
			 return false;
	 	 }else{
			 // and pdId is not null
			 return true;
		 }
	 }


	 return true;

  }

  private void setClassForStyles(boolean marked) {
	  if(marked){
		  className = "listCellError";
		  borderClassName = "listCell5Error";
		  buttonClassName = "button3b";
	  } else {
		  className = "listCell";
		  borderClassName = "listCell5";
		  buttonClassName = "button3a";
	  }
  }
}