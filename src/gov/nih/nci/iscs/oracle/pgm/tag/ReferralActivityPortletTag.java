package gov.nih.nci.iscs.oracle.pgm.tag;
import gov.nih.nci.iscs.oracle.pgm.hibernate.ReferralActivityVw;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 * A tag to 
 * @author hmarwaha
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ReferralActivityPortletTag extends TagSupport 
{
	  private Logger logger = LogManager.getLogger(ReferralActivityPortletTag.class);
    private List referralActivity = null;	
    private static Map referralStatusMap = null;
    static {
    	 referralStatusMap = new HashMap(5);
    	 referralStatusMap.put("REF","Referred");
    	 referralStatusMap.put("ARA","Referred-ARA");
    	 referralStatusMap.put("REF-D","Referred-Dual");
    	 referralStatusMap.put("REREF","Rereferred");
    }
    public void setReferralActivity(List referralActivity)
    {
    	this.referralActivity = referralActivity;
    }
    
    public int doStartTag() throws JspException {
      try {
        JspWriter out = pageContext.getOut();
        StringBuffer buf = new StringBuffer();
        if ((referralActivity != null)&&(referralActivity.size()>0))
        {  
           buf.append("<tr><td class=\"listCell3\">&nbsp;</td><td class=\"listCell3\">&nbsp;</td></tr>\n");
           Iterator iterate = referralActivity.iterator();
           ReferralActivityVw rav = (ReferralActivityVw)iterate.next();
           do { 
           	 String currentCA =  rav.getCayCode();
             String currentCouncil = rav.getCouncilMeetingDate();
           	 boolean sameCA=true;
             int activityCount = rav.getActCount().toBigInteger().intValue();
           	 while ((sameCA)&&(iterate.hasNext()))
           	 {  
           	     
           	    rav = (ReferralActivityVw)iterate.next();
           	    if (rav.getCayCode().equals(currentCA)){
                  activityCount += rav.getActCount().toBigInteger().intValue();
           	    }
           	    else {
           	    	sameCA = false;
           	    }
           	 }
             buf.append(getCARow(currentCA, activityCount, currentCouncil));
             logger.info(buf.toString());
           }while (iterate.hasNext());
        }
        logger.info(buf.toString());
        out.write(buf.toString());
    	return TagSupport.SKIP_BODY;
      }
      catch (Exception e)
	  {
      	logger.error(e);
      	throw new JspException(e.getMessage());
	  }
    }

    private String getCARow(String cancerActivity, int activityCount, String currentCouncil)
    {
    	StringBuffer sb = new StringBuffer(30);
        String ca = cancerActivity;
        String dataLink = "<a href=\"#\" onClick=\"javascript:popUpQueryReferralActivity('"+ca+"','"+currentCouncil+"');\" >";
        sb.append("<tr>\n<td class=\"listCell\">"+ca+"</td>\n<td class=\"listCell2\">"+dataLink+activityCount+"</a></td>\n</tr>\n");
        return sb.toString();    	
    }
    
}