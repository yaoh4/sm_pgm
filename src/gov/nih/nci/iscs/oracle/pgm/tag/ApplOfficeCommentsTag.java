package gov.nih.nci.iscs.oracle.pgm.tag;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.hibernate.ApplCaAsgnmtHistoryVw;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject;
import gov.nih.nci.iscs.oracle.pgm.service.impl.CancerActivityHistoryServiceImpl;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ApplOfficeCommentsTag extends TagSupport
{
  private String   applId;


  public void setApplId(String applId) {
     this.applId = applId;
  }

  public int doStartTag() {

    try {
      JspWriter out = pageContext.getOut();      
      ApplCaAsgnmtHistoryVw mApplCaAsgnmtHistoryVw = getApplCaAsgnmtHistoryVw(applId);
      String results = formatPage(mApplCaAsgnmtHistoryVw);
      out.print(results);
    } catch(Exception e) {
      e.printStackTrace();
    }
    return SKIP_BODY;
  }

  private String formatPage(ApplCaAsgnmtHistoryVw mApplCaAsgnmtHistoryVw) {

      StringBuffer buf = new StringBuffer();
      buf.append("<table><tr>");     
      buf.append("<td width=\"40%\" align=\"right\" valign=\"top\" class=\"DefaultTextBold\">Comments:</td>");
      buf.append("<td width=\"60%\" align=\"left\" class=\"DefaultText\">" + getAPSComments(applId) + "</td>");      
      buf.append("</tr></table>\n");
      return  buf.toString();

}


public ApplCaAsgnmtHistoryVw getApplCaAsgnmtHistoryVw(String applId) {

    ApplCaAsgnmtHistoryVw mApplCaAsgnmtHistoryVw = new ApplCaAsgnmtHistoryVw();
    try {

         ServletContext sc = pageContext.getServletContext();
         Object mApplicationContext =   sc.getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
         CancerActivityHistoryServiceImpl mCancerActivityHistoryServiceImpl =  new CancerActivityHistoryServiceImpl(mApplicationContext);
	     mApplCaAsgnmtHistoryVw = mCancerActivityHistoryServiceImpl.getCAHistoryForAppl(applId);
    } catch(Exception e) {
        e.printStackTrace();
    }
    return mApplCaAsgnmtHistoryVw;

}
    private String getAPSComments(String applId) {

        HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
        String comments = null;
        Integer mKey;
        try {                
            Map referralQueryResults = (Map) request.getSession().getAttribute(ApplicationConstants.QUERY_RESULTS);            
            Iterator iterator = referralQueryResults.entrySet().iterator();
            while  (iterator.hasNext()) {
                 Map.Entry entry = (Map.Entry) iterator.next();
                 mKey = (Integer) entry.getKey();
                 ReferralSearchResultObject obj = (ReferralSearchResultObject) entry.getValue();
                 if (applId.equalsIgnoreCase(obj.getApplId().toString())){
                 comments = obj.getReferralComments();                
                 break;
                 }
                }            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return comments;

    }
}
