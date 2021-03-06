package gov.nih.nci.iscs.oracle.pgm.tag;


//Jdk Imports


import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
//Application imports

public class FormatReferralResultTag extends TagSupport {
  private String    result;

  public void setResult (String result) {

     this.result = result;
  }

  public int doStartTag() {
    try {
	  boolean mActionFailed = true;
      StringBuffer buf = new StringBuffer();
      HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
      JspWriter out = pageContext.getOut();
      if(result.toUpperCase().startsWith("SUCCESS")){
		  mActionFailed = false;
	  }

	  if(mActionFailed) {
		  buf.append("<font color=#ff0000>"  + result + "</font>");
	  } else {
		  buf.append( result );
	  }

      out.print( buf.toString());
     } catch(Exception e) {
      e.printStackTrace();
     }
   return SKIP_BODY;
  }


}