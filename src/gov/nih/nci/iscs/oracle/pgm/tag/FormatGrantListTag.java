package gov.nih.nci.iscs.oracle.pgm.tag;


//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.hibernate.GwbLinksT;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.SelectedGrants;
import gov.nih.nci.iscs.oracle.pgm.service.GrantSearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.PDASearchResultObject;
import gov.nih.nci.iscs.oracle.common.helper.ApplicationInfo;
import java.util.*;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class FormatGrantListTag extends TagSupport {
  private String key  ;
  private int index;
  private String formName;
  private SelectedGrants mSelectedGrants;
  private boolean grantSelected;
  private String mSelectedGrantsKey;
  private Integer mKey;
  private String grantsUrl="";
  private String nihGuideAddrUrl="";

  public static String className = "";
  public static String borderClassName = "";
  public static String buttonClassName = "";
  public static String underlineButtonClassName = "";

  public void setKey(String key) {

     this.key = key;
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
      HttpSession session = request.getSession();
      ServletContext sc = session.getServletContext();
      ApplicationInfo ai = (ApplicationInfo) sc.getAttribute("applicationInfo");
	  grantsUrl = ai.getApplicationKey("GRANTS_DETAILS_URL");
	  session.setAttribute("GRANTS_DETAILS_URL", grantsUrl);
	  StringBuffer buf = new StringBuffer();
      mSelectedGrants = (SelectedGrants) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS);
      Map referralQueryResults = (Map) request.getSession().getAttribute(ApplicationConstants.QUERY_RESULTS);
      // get URL to eGrants
      String eGrantsURL = "";
      HashMap map = (HashMap) sc.getAttribute(ApplicationConstants.APP_LINK_LIST);
      if (map != null) {
          GwbLinksT eGrantLink = (GwbLinksT) map.get("eGrants");
          if (eGrantLink != null) {
              eGrantsURL = eGrantLink.getProtocol() + "://" + eGrantLink.getLinkServer() + eGrantLink.getLinkPath();
          }
      }

      int selIndex = 0;
      Iterator iterator = referralQueryResults.entrySet().iterator();
      while  (iterator.hasNext()) {
           Map.Entry entry = (Map.Entry) iterator.next();
           mKey = (Integer) entry.getKey();
           GrantSearchResultObject obj = (GrantSearchResultObject) entry.getValue();
           mSelectedGrantsKey = obj.getApplId().toString() + obj.getCancerActivity();
           if(mSelectedGrants.getSelectedGrants() != null ) {
             if(mSelectedGrants.getSelectedGrants().containsKey(mSelectedGrantsKey)) {
		        grantSelected = true;
	         }
	      }
	      if(formName.equalsIgnoreCase("retrieveGrantsForReferralForm")){
			  formatReferrals(selIndex, obj, buf, eGrantsURL);
		  } else {
			  formatPDAs(selIndex, obj, buf);
		  }
	     selIndex++;
	     grantSelected = false;
	  }

      out.print( buf.toString());
     } catch(Exception e) {
      e.printStackTrace();
     }
   return SKIP_BODY;
  }

  private void 	formatReferrals(int selIndex, GrantSearchResultObject grantObj, StringBuffer buf, String eGrantsURL){

	  ReferralSearchResultObject obj = (ReferralSearchResultObject) grantObj;
	  setClassForStyles(obj.getMarked());

	  buf.append("<tr>");
      String controlName = "selected" + selIndex;
      String sectionName = "section" + selIndex;
      String hrefName = "#" + sectionName;
      String pocInfo = obj.getDualPoc();
      if(grantSelected) {
		 buf.append("<td headers=\"header00\" width=\"3%\" class=listCell><input type=\"checkbox\" value=\"" + mKey + "\" NAME=\"selectedIndx\" checked ></td>");
      } else {
		 buf.append("<td headers=\"header00\" width=\"3%\" class=listCell><input type=\"checkbox\" value=\"" + mKey + "\" NAME=\"selectedIndx\"></td>");
	  }
      buf.append("<td headers=\"header01\" width=\"16%\" style=\"white-space: nowrap;\" class=" + className + ">");

      buf.append("<a href=\"javascript:openYourGrantsWindow(\'" + obj.getApplId() + "\', \'" + grantsUrl + "\');\">" + obj.getGrantNumber() + "&nbsp;</a>");
	  if(obj.getWithdrawn() ){
		 buf.append("<br> Withdrawn in IMPAC II");
	  }
      if(obj.getReReferred() ){
         buf.append("<BR> <a href=\"javascript:openCAHistWindow(\'" + obj.getApplId() + "\',\'" + obj.getGrantNumber() + "\');\"> Referred from Other CA </a>");
      }
      if(obj.getApsComments().length() > 0 && ( obj.getCurrentReferralActivityCode().equalsIgnoreCase("REF") || obj.getCurrentReferralActivityCode().equalsIgnoreCase("REF-D")) ){
         buf.append("<BR> <a href=\"javascript:openReferralOfficeCommentsWindow(\'" + obj.getApplId() + "\',\'" + obj.getGrantNumber() + "\');\"> Referral Office Comments </a>");
      }
	  buf.append("</td>");
      buf.append("<td headers=\"header02\" width=\"6%\" class=" + className + ">" +  obj.getCancerActivity() + "&nbsp;</td>");
	  buf.append("<td headers=\"header03\" width=\"6%\" class=" + className + ">" + " <INPUT  type=\"button\" class=" + underlineButtonClassName + " id=\"" + controlName + "\" value=\"" + obj.getDualCA() + "\" onmouseover=\"javascript:moveOver(" + "\'" + pocInfo + "\', \'" + selIndex + "\');\" onmouseout=\"javascript:moveOut();\"></a>&nbsp;</td>");
      buf.append("<td headers=\"header04\" width=\"10%\" class=" + className + ">" + obj.getPiLastName() + "&nbsp;</td>");
      buf.append("<td headers=\"header05\" width=\"15%\" class=" + className + ">" + obj.getInstName()+ "&nbsp;</td>");
      buf.append("<td headers=\"header06\" width=\"16%\" class=" + className + ">" + obj.getProjectTitle() + "&nbsp;</td>");
      buf.append("<td headers=\"header06\" style=\"white-space: nowrap;\" width=\"10%\" class=" + className + ">");
      String rfapa = obj.getRfapa().trim();
      if (rfapa.length() < 1){
    	  buf.append("&nbsp;"); 
      }else{
    	  buf.append("<a href=\"javascript:openRfaPaWindow(\'" + obj.getNihGuideAddrUrl() + "\');\">" + obj.getRfapa().trim() + "</a>");
      }
      buf.append("<td headers=\"header07\" width=\"6%\" class=" + className + ">" );
      buf.append("<a href=\"javascript:araView(" + obj.getAraId() + ")\" >" +obj.getAraStatus()+ "</a>");
      buf.append("&nbsp;</td>");
      buf.append("<td headers=\"header08\" width=\"8%\" class=" + className + ">" + obj.getNcabDate()+ "&nbsp;</td>");
      buf.append("<td headers=\"header09\" width=\"10%\" class=" + className + ">" + obj.getCurrentReferralActivityDate()+ "&nbsp;</td>");
      buf.append("<td headers=\"header10\" width=\"5%\" class=" + borderClassName + ">" + "<a href=\"javascript:openEGrantsWindow(\'" + eGrantsURL + "\', \'"+ obj.getEGrantsNumber() + "\');\"><img src=\"images/egrants.gif\" alt=\"eGrants\"  border=\"0\"> </a></td>");


	  buf.append("</tr>");
	  buf.append("\n");
	  mSelectedGrants.remove(mSelectedGrantsKey);


  }

  private void 	formatPDAs(int selIndex, GrantSearchResultObject grantObj, StringBuffer buf  ){

	  PDASearchResultObject obj = (PDASearchResultObject) grantObj;
	  buf.append("<tr>");
      String controlName = "selected" + selIndex;
      setClassForStyles(obj.getMarked());

      if(grantSelected) {
		 buf.append("<td headers=\"header00\" width=\"3%\" class=listCell><input type=\"checkbox\" value=\"" + mKey + "\" NAME=\"selectedIndx\" checked ></td>");
      } else {
		 buf.append("<td headers=\"header00\" width=\"3%\" class=listCell><input type=\"checkbox\" value=\"" + mKey + "\" NAME=\"selectedIndx\"></td>");
	  }
	     buf.append("<td headers=\"header01\" width=\"16%\" class=" + className + ">");
         buf.append("<a href=\"javascript:openYourGrantsWindow(\'" + obj.getApplId() + "\', \'" + grantsUrl + "\');\">" + obj.getGrantNumber() + "&nbsp;</a>");
	     if(obj.getWithdrawn() ){
		    buf.append("<br> Withdrawn in IMPAC II");
		 }
		 buf.append("</td>");

         buf.append("<td headers=\"header02\" width=\"14%\" class=" + className + ">" + obj.getPiName()+ "&nbsp;</td>");
         buf.append("<td headers=\"header03\" width=\"6%\" class=" + className + ">" + obj.getFy() + "&nbsp;</td>");
         buf.append("<td headers=\"header04\" width=\"10%\" class=" + className + ">" + obj.getNcabDate() + "&nbsp;</td>");
 
         buf.append("<td headers=\"header05\" width=\"10%\" class=" + className + ">" + obj.getRfaPaNumber() + "&nbsp;</td>");
         
         buf.append("<td headers=\"header06\" width=\"6%\" class=" + className + ">" + obj.getCancerActivity() + "&nbsp;</td>");

         buf.append("<td headers=\"header07\" width=\"14%\" class=" + className + ">" + obj.getPdFullName()+ "&nbsp;</td>");

         if(obj.getPdStartDate() != null) {
			 String temp = obj.getPdStartDate().toString();
			 temp = temp.substring(5,7) + "/" + temp.substring(8,10) + "/" + temp.substring(0,4);
			 buf.append("<td headers=\"header08\" width=\"15%\" class=" + borderClassName + ">" + temp + "&nbsp;</td>");
		 }else {
			 buf.append("<td headers=\"header08\" width=\"15%\" class=" + borderClassName + ">" + ApplicationConstants.EMPTY_STRING + "&nbsp;</td>");
		 }


	  buf.append("</tr>");
	  buf.append("\n");
	  mSelectedGrants.remove(mSelectedGrantsKey);
  }


  private void setClassForStyles(boolean marked) {
	  if(marked){
		  className = "listCellError";
		  borderClassName = "listCell5Error";
		  buttonClassName = "button3b";
		  underlineButtonClassName = "button5b";
	  } else {
		  className = "listCell";
		  borderClassName = "listCell5";
		  buttonClassName = "button3a";
		  underlineButtonClassName = "button5a";
	  }
  }

}
