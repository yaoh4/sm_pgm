package gov.nih.nci.iscs.oracle.pgm.tag;

import org.apache.struts.util.LabelValueBean;


//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.LookUpObject;
import gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.RereferReferralForm;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralActionObject;
import gov.nih.nci.iscs.oracle.pgm.service.SelectedGrants;
import gov.nih.nci.iscs.oracle.pgm.service.impl.CancerActivitiesServiceImpl;
import org.springframework.context.ApplicationContext;

import java.util.*;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class RereferReferralTag extends TagSupport {
  private int    indx;
  private String action;
  private String    cancerActivity;
  private Long applId;
  private boolean selected;

  private static String ACTIVE_CANCER_ACTIVITIES = "activeCancerActivities";
  private ApplicationContext mApplicationContext;
  private ArrayList caList;

  public void setIndx(String indx) {
	  Integer newIndex = new Integer(indx);
     this.indx = newIndex.intValue();
  }

  public void setIndx(int indx) {
     this.indx = indx;
  }
  public void setAction(String action) {
     this.action = action;
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
      String className = "ta";
      HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
      JspWriter out = pageContext.getOut();
      ServletContext sc = pageContext.getServletContext();
      mApplicationContext =  (ApplicationContext) sc.getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
      caList = (ArrayList) getActiveCancerActivities(request);
      if(action.equalsIgnoreCase("selection")) {
		  buf = formatSelection(buf, request);
	  }
      if(action.equalsIgnoreCase("comments")) {
		  buf = formatComments(buf, request);
	  }
      if(action.equalsIgnoreCase("caForApply")) {
		  buf = formatCAForApply(buf, request);
	  }
      out.print( buf.toString());
     } catch(Exception e) {
      e.printStackTrace();
     }
   return SKIP_BODY;
  }

  private  StringBuffer formatComments(StringBuffer buf, HttpServletRequest request) {
      String selectedCA = ApplicationConstants.EMPTY_STRING;
      String comments = ApplicationConstants.EMPTY_STRING;
      RereferReferralForm mRereferReferralForm = (RereferReferralForm) request.getAttribute("rereferReferralForm");
      String mHashKey = cancerActivity + "*" + applId.toString();

      buf.append("<td headers=\"header06\" width=\"4%\" class=listCell>");

      String caControlName = "CancerActivityMapped(" + mHashKey + ")";
      String commentsControlName = "CommentMapped(" + mHashKey + ")";
      String  cancerActivity = (String) mRereferReferralForm.getCancerActivityMapped(mHashKey);

      //buf.append("<SELECT NAME=\"" + caControlName + "\" SIZE=\"1\" onchange=\"setCA(" + indx + ", document.rereferReferralForm." + caControlName + ".options[document.rereferReferralForm." + caControlName + ".selectedIndex].value, document.rereferReferralForm." + commentsControlName + ".value);\" >");
      buf.append("<SELECT NAME=\"" + caControlName + "\" SIZE=\"1\" >");
	  buf.append("<option SELECTED value=");
	  buf.append(ApplicationConstants.EMPTY_STRING);
	  buf.append(">");
	  buf.append(ApplicationConstants.EMPTY_STRING);
      buf.append("</option>\n");


      Iterator mIterator = caList.iterator();
      while(mIterator.hasNext() ){
		  LabelValueBean mLookUpValueBean = (LabelValueBean) mIterator.next();
          String mValue = (String) mLookUpValueBean.getValue();
          String mLabel = (String) mLookUpValueBean.getLabel();
          if(cancerActivity.equalsIgnoreCase(mValue) ) {
		    buf.append("<option SELECTED value=");
		  } else {
			  buf.append("<option value=");
		  }
		  buf.append(mValue);
		  buf.append(">");
		  buf.append(mValue);
          buf.append("</option>\n");
      }
      buf.append("</td>");
      buf.append("<td headers=\"header07\" width=\"20%\" class=listCell5>");

      comments = (String) mRereferReferralForm.getCommentMapped(mHashKey);
      //buf.append("<TEXTAREA NAME=\"" + commentsControlName + "\" rows=\"2\" cols=\"30\" maxsize=\"90\" wrap=\"virtual\" style=\"overflow:auto\" onchange=\"setRereferComments(" + indx + ", document.rereferReferralForm." + commentsControlName + ".value, document.rereferReferralForm." + caControlName + ".options[document.rereferReferralForm." + caControlName + ".selectedIndex].value);\">");
      buf.append("<TEXTAREA NAME=\"" + commentsControlName + "\" rows=\"2\" cols=\"30\" maxsize=\"90\" wrap=\"virtual\" style=\"overflow:auto\">");
	  buf.append( comments );
	  buf.append("</TEXTAREA>");
	  buf.append("\n");
      buf.append("</td>");

      return buf;
  }

  private  StringBuffer formatSelection(StringBuffer buf, HttpServletRequest request) {
      String mKey = new Integer(indx).toString() + "*" + cancerActivity + "*" + applId.toString();
      buf.append("<td headers=\"header00\" width=\"3%\" class=listCell><input type=\"checkbox\" value=\"" + mKey + "\" NAME=\"selectedIndx\"></td>");

      return buf;
  }

   private List getActiveCancerActivities(HttpServletRequest request) {

 	// get the lookup infomation
 	 String cancerActivity = null;
 	 List mList = (List) request.getAttribute(ACTIVE_CANCER_ACTIVITIES);
 	 if(mList == null) {
        CancerActivitiesServiceImpl mCancerActivitiesServiceImpl =  new CancerActivitiesServiceImpl(mApplicationContext);
 	    mList  = mCancerActivitiesServiceImpl.getActiveCancerActivities();
	    request.setAttribute(ACTIVE_CANCER_ACTIVITIES, mList);
	 }
     return mList;
   }

  private  StringBuffer formatCAForApply(StringBuffer buf, HttpServletRequest request) {
      RereferReferralForm mRereferReferralForm = (RereferReferralForm) request.getAttribute("rereferReferralForm");

      String caForApply = (String) mRereferReferralForm.getCaToApply();
      buf.append("<SELECT NAME=caToApply SIZE=\"1\" >");
	  buf.append("<option SELECTED value=");
	  buf.append(ApplicationConstants.EMPTY_STRING);
	  buf.append(">");
	  buf.append(ApplicationConstants.EMPTY_STRING);
      buf.append("</option>\n");


      Iterator mIterator = caList.iterator();
      while(mIterator.hasNext() ){
		  LabelValueBean mLookUpValueBean = (LabelValueBean) mIterator.next();
          String mValue = (String) mLookUpValueBean.getValue();
          String mLabel = (String) mLookUpValueBean.getLabel();
          if(caForApply.equalsIgnoreCase(mValue) ) {
		    buf.append("<option SELECTED value=");
		  } else {
			  buf.append("<option value=");
		  }
		  buf.append(mValue);
		  buf.append(">");
		  buf.append(mValue);
          buf.append("</option>\n");
      }
      return buf;

  }

}