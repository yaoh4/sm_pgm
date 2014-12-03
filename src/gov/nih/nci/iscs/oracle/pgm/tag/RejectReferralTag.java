package gov.nih.nci.iscs.oracle.pgm.tag;


//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.RejectReferralForm;
import gov.nih.nci.iscs.oracle.pgm.service.impl.RejectionCommentsServiceImpl;

import java.util.*;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class RejectReferralTag extends TagSupport {
  private int    indx;
  private String action;
  private String    cancerActivity;
  private Long applId;
  private boolean selected;
  private Map rejectionCommentsMap;
  public String formName = "rejectReferralForm";
  private String mHashKey;
  private String mKey;
  private String mCaApplId;

  public static String className = "";

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
	  RejectReferralForm mRejectReferralForm = (RejectReferralForm) request.getAttribute("rejectReferralForm");
      rejectionCommentsMap = (Map) request.getSession().getAttribute("REJ_COMMENTS");
      if(rejectionCommentsMap == null) {
		 getRejectComments();
		 request.getSession().setAttribute("REJ_COMMENTS", rejectionCommentsMap);
	  }
      if(action.equalsIgnoreCase("selection")) {
		  buf = formatSelection(buf, request);
	  }else{
		 if(action.equalsIgnoreCase("comments")) {
		    buf = formatComments(buf, request);
		 }else{
            String mCommentsToApply = mRejectReferralForm.getCommentsToApply();
		    String mRejectionSelection = mRejectReferralForm.getRejectionSelection();
		    buf = appendComments(buf, "rejectionSelection", "commentsToApply", mCommentsToApply, mRejectionSelection);
		    request.setAttribute("DisbaleComments", new Boolean(true));
		    if(mRejectionSelection.equalsIgnoreCase("Other")) {
				request.setAttribute("DisbaleComments", new Boolean(false));
			}
		 }

	  }

      out.print( buf.toString());
     } catch(Exception e) {
      e.printStackTrace();
     }
   return SKIP_BODY;
  }

  private  StringBuffer formatComments(StringBuffer buf, HttpServletRequest request) {

	  RejectReferralForm mRejectReferralForm = (RejectReferralForm) request.getAttribute("rejectReferralForm");

      mKey = new Integer(indx).toString() + "*" + cancerActivity + "*" + applId.toString();
      mHashKey = cancerActivity + "*" + applId.toString();
      mCaApplId = cancerActivity + applId.toString();;
      String comments = (String)  mRejectReferralForm.getCommentMapped(mHashKey);
      String commentsToApply = (String)  mRejectReferralForm.getDbCommentMapped(mHashKey);
      String controlName = "CommentMapped(" + mHashKey  + ")";
      String commentsControlName = "DbCommentMapped(" + mHashKey  + ")";;

      appendComments(buf, commentsControlName, controlName, comments, commentsToApply);
      buf.append("<TEXTAREA NAME= \"" +  controlName + "\" rows=\"2\" cols=\"30\" maxsize=\"90\" wrap=\"virtual\" style=\"overflow:auto\");\">");
	  buf.append( comments);
	  buf.append("</TEXTAREA>");
	  buf.append("\n");
      return buf;
  }

  private  StringBuffer formatSelection(StringBuffer buf, HttpServletRequest request) {
	  RejectReferralForm mRejectReferralForm = (RejectReferralForm) request.getAttribute("rejectReferralForm");
      //String mKey = new Integer(indx).toString();
      String mKey = new Integer(indx).toString() + "*" + cancerActivity + "*" + applId.toString();
      if(this.selected) {
		  buf.append("<td headers=\"header00\" width=\"3%\" class=listCell><input type=\"checkbox\" value=\"" + mKey + "\" NAME=\"selectedIndx\" checked></td>");
	  } else {
		  buf.append("<td headers=\"header00\" width=\"3%\" class=listCell><input type=\"checkbox\" value=\"" + mKey + "\" NAME=\"selectedIndx\"></td>");
	  }

      return buf;
  }

public void getRejectComments() {

    try {

         ServletContext sc = pageContext.getServletContext();
         Object mApplicationContext =   sc.getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
         RejectionCommentsServiceImpl mRejectionCommentsServiceImpl =  new RejectionCommentsServiceImpl(mApplicationContext);
         this.rejectionCommentsMap  = mRejectionCommentsServiceImpl.getRejectionComments();
    } catch(Exception e) {
        e.printStackTrace();
    }


}

private StringBuffer appendComments(StringBuffer buf, String commentsControlName, String controlName, String commentsToApply, String rejectionSelection) {


	  String mDefaultkey = new String(" ");
	  if(commentsControlName.equalsIgnoreCase("rejectionSelection")) {
		  buf.append("<SELECT style=\"width: 245px\" NAME=\""+ commentsControlName + "\" SIZE=\"1\" onchange=\"refreshComments(document." + formName + "." + commentsControlName + ".options[document." + formName + "." + commentsControlName + ".selectedIndex].text, document." + formName + "." + controlName + ");\")\">");
	  }else{
		  buf.append("<SELECT style=\"width: 245px\" NAME=\""+ commentsControlName + "\" SIZE=\"1\" onchange=\"refreshSelComments(document." + formName + "." + commentsControlName + ".options[document." + formName + "." + commentsControlName + ".selectedIndex].text, document." + formName + ",\'" +  indx + "\', \'" + mCaApplId + "\');\")\">");
	  }

      buf.append("<OPTION SELECTED value=" + mDefaultkey + ">");
      buf.append("Select Comments.....");
      buf.append("</OPTION>\n");

	 for (Iterator iterator = this.rejectionCommentsMap.entrySet().iterator(); iterator.hasNext();) {
	          Map.Entry entry = (Map.Entry) iterator.next();
	          String key = (String)entry.getKey();
	        //  key = key.replaceAll(" ", "");
	          String value = (String)entry.getValue();
	          if(rejectionSelection.equalsIgnoreCase(key.trim())) {
				  buf.append("<OPTION SELECTED value='");
			  }else{
				  buf.append("<OPTION value='");
			  }
			  buf.append( key);
			  buf.append("'>");
			  buf.append(value);
	          buf.append("</OPTION>\n");
	  }
	  buf.append("</SELECT><BR>");
      return  buf;
  }

  private void setClassForStyles(boolean marked) {
	  if(marked){
		  className = "listCellError";
	  } else {
		  className = "listCell";
	  }
  }

}