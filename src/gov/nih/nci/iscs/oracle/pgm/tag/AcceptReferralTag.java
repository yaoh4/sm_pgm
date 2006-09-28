package gov.nih.nci.iscs.oracle.pgm.tag;

import org.apache.struts.util.LabelValueBean;


//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.AcceptReferralForm;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralActionObject;
import gov.nih.nci.iscs.oracle.pgm.service.SelectedGrants;

import java.util.*;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
//Application imports

public class AcceptReferralTag extends TagSupport {
  private String action;
  private int    indx;
  private String    cancerActivity;
  private Long applId;
  private boolean selected;

  public void setAction(String action) {
     this.action = action;
  }

  public void setIndx(String indx) {
	  Integer newIndex = new Integer(indx);
     this.indx = newIndex.intValue();
  }

  public void setIndx(int indx) {
     this.indx = indx;
  }

  public void setCancerActivity(String cancerActivity) {
     this.cancerActivity = cancerActivity;
  }

  public void setApplId(Long applId) {
     this.applId = applId;
  }

  public void setSelected(boolean selected) {
     this.selected = selected;
  }

  public int doStartTag() {
    try {
      StringBuffer buf = new StringBuffer();
      HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
      JspWriter out = pageContext.getOut();
      AcceptReferralForm mForm = (AcceptReferralForm) request.getAttribute("acceptReferralForm");

      if(action.equalsIgnoreCase("selection")) {
		  buf = formatSelection(request, buf);
	  }else{
		  buf = formatDropdown(request, buf);
	  }

      out.print( buf.toString());
     } catch(Exception e) {
      e.printStackTrace();
     }
   return SKIP_BODY;
  }

  private StringBuffer formatDropdown(HttpServletRequest request, StringBuffer buf){

      TreeMap mReferralActionObjects = (TreeMap) request.getSession().getAttribute(ApplicationConstants.REFERRAL_ACTION_HASH);
      SelectedGrants mSelectedGrants = (SelectedGrants) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS);
      String selectedPd = ApplicationConstants.EMPTY_STRING;
      String mKey = cancerActivity + "*" + applId.toString();
      String mSelectedIndex = new Integer(indx).toString() + "*" + cancerActivity + "*" + applId.toString();
      if(mReferralActionObjects.containsKey(mKey)) {
		  ReferralActionObject mReferralActionObject = (ReferralActionObject) mReferralActionObjects.get(mKey);
		  selectedPd = mReferralActionObject.getPdId();
	  }
      HashMap mCancerActivityMap = (HashMap) mSelectedGrants.getCancerActivityMap();

      ArrayList pdLookUp = (ArrayList) mCancerActivityMap.get(cancerActivity.toUpperCase());
      String controlName = "pdList" + indx;
      buf.append("<SELECT NAME=\"" + controlName + "\" SIZE=\"1\" onchange=\"javascript:setPdId(\'" + mSelectedIndex + "\', document.acceptReferralForm." + controlName + ".selectedIndex, document.acceptReferralForm." + controlName + ".options[document.acceptReferralForm." + controlName + ".selectedIndex].value);\" >");
	  buf.append("<option SELECTED value=");
	  buf.append(ApplicationConstants.EMPTY_STRING);
	  buf.append(">");
	  buf.append(ApplicationConstants.EMPTY_STRING);
      buf.append("</option>\n");

      Iterator mIterator = pdLookUp.iterator();

      while(mIterator.hasNext() ){
		  LabelValueBean mLookUpValueBean = (LabelValueBean) mIterator.next();
          String mValue = mLookUpValueBean.getValue();
          String mLabel = mLookUpValueBean.getLabel();
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

      return buf;
  }
  private StringBuffer formatSelection(HttpServletRequest request, StringBuffer buf){

      String mKey = new Integer(indx).toString() + "*" + cancerActivity + "*" + applId.toString();
      if(this.selected) {
		  buf.append("<td headers=\"header00\" width=\"3%\" class=listCell><input type=\"checkbox\" value=\"" + mKey + "\" NAME=\"selectedIndx\" checked></td>");
	  } else {
		  buf.append("<td headers=\"header00\" width=\"3%\" class=listCell><input type=\"checkbox\" value=\"" + mKey + "\" NAME=\"selectedIndx\"></td>");
	  }


      return buf;
  }




}