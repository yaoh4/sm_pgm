package gov.nih.nci.iscs.oracle.pgm.tag;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class applAPSCommentsTag extends TagSupport{

      private String   applId;
      private Integer mKey;


      public void setApplId(String applId) {
         this.applId = applId;
      }

      public int doStartTag() {

        try {
          JspWriter out = pageContext.getOut();            
          String results = formatPage(applId);
          out.print(results);
        } catch(Exception e) {
          e.printStackTrace();
        }
        return SKIP_BODY;
      }

      private String formatPage(String applId) {

          StringBuffer buf = new StringBuffer();
          buf.append("<table><tr>");
          buf.append("<td width=\"40%\" align=\"right\" class=\"DefaultTextBold\">Comments:</td>");
          buf.append("<td width=\"60%\" align=\"left\" class=\"DefaultText\">" + getAPSComments(applId) + "</td>");                
          buf.append("</tr></table>\n");
          return  buf.toString();

    }


    public String getAPSComments(String applId) {

        HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
        String comments = null;
        try {                
            Map referralQueryResults = (Map) request.getSession().getAttribute(ApplicationConstants.QUERY_RESULTS);            
            Iterator iterator = referralQueryResults.entrySet().iterator();
            while  (iterator.hasNext()) {
                 Map.Entry entry = (Map.Entry) iterator.next();
                 mKey = (Integer) entry.getKey();
                 ReferralSearchResultObject obj = (ReferralSearchResultObject) entry.getValue();
                 if (applId.equalsIgnoreCase(obj.getApplId().toString())){
                 comments = obj.getApsComments();                
                 break;
                 }
                }            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return comments;

    }
}
