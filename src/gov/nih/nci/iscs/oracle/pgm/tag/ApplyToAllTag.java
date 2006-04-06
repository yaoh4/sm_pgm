package gov.nih.nci.iscs.oracle.pgm.tag;

import org.apache.struts.util.LabelValueBean;


//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.LookUpObject;
import gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.AcceptReferralForm;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralActionObject;
import gov.nih.nci.iscs.oracle.pgm.service.SelectedGrants;

import java.util.*;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class ApplyToAllTag extends TagSupport {
  private int    indx;
  private String    cancerActivity;
  private String controlName = "pdList9999";


  public int doStartTag() {
    try {
      StringBuffer buf = new StringBuffer();
      HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
      JspWriter out = pageContext.getOut();
	  AcceptReferralForm mAcceptReferralForm = (AcceptReferralForm) request.getAttribute("acceptReferralForm");
      SelectedGrants mSelectedGrants = (SelectedGrants) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS);
      String selectedPd = ApplicationConstants.EMPTY_STRING;
      String filterCA = mAcceptReferralForm.getFilterCA();
      List oProgramDirectorsList = mSelectedGrants.getProgramDirectorsList();
      //if(mSelectedGrants.getSameCAForAll()) {
         buf.append("<SELECT NAME=\"" + controlName + "\" SIZE=\"1\" >");
	     buf.append("<option SELECTED value=");
	     buf.append(ApplicationConstants.EMPTY_STRING);
	     buf.append(">");
	     buf.append(ApplicationConstants.EMPTY_STRING);
         buf.append("</option>\n");
         Iterator mIterator;
	     if( filterCA.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ||
	         filterCA == null) {
            mIterator = oProgramDirectorsList.iterator();
		 }else{
			List mCancerActivityList = (List) mSelectedGrants.getCancerActivityMap().get(filterCA);
            mIterator = mCancerActivityList.iterator();
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
             buf.append("</option>\n");
		 }
		 buf.append("</SELECT>\n");
        //buf.append("</td>\n");

	   //buf.append("<td align=\"left\"><input class=\"button2a\" type=\"button\" value=\"Apply To Selected Grants\" onclick=\"applyForAccept(document.acceptReferralForm." + controlName + ".options[document.acceptReferralForm." + controlName + ".selectedIndex].value);\">\n");
	   buf.append("&nbsp;<input class=\"button2a\" type=\"button\" value=\"Apply To Selected Grants\" onclick=\"applyForAccept(document.acceptReferralForm." + controlName + ".options[document.acceptReferralForm." + controlName + ".selectedIndex].value);\">\n");
       buf.append("</td>\n");
     out.print( buf.toString());
     } catch(Exception e) {
      e.printStackTrace();
     }
   return SKIP_BODY;
  }


}