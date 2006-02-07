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

public class AcceptReferralCATag extends TagSupport {
  private String controlName = "filterCA";

  public int doStartTag() {
    try {
      StringBuffer buf = new StringBuffer();
      HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
      JspWriter out = pageContext.getOut();
      AcceptReferralForm mForm = (AcceptReferralForm) request.getAttribute("acceptReferralForm");
      String filterCA = mForm.getFilterCA();
      SelectedGrants mSelectedGrants = (SelectedGrants) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS);

      if(!mSelectedGrants.getSameCAForAll()) {
		 buf.append("<td  align=\"left\" ><B> Filter by Cancer Activity: </B>");
         buf.append("&nbsp; ");

         buf.append("<SELECT NAME=\"" + controlName + "\" SIZE=\"1\" onChange=\"selectByCA();\" >");
	     buf.append("<option SELECTED value=");
	     buf.append(ApplicationConstants.EMPTY_STRING);
	     buf.append(">");
	     buf.append(ApplicationConstants.EMPTY_STRING);
         buf.append("</option>\n");
         TreeMap mCancerActivityMap = new TreeMap((Map) mSelectedGrants.getCancerActivityMap());
         for (Iterator mIterator = mCancerActivityMap.entrySet().iterator(); mIterator.hasNext();) {
            Map.Entry entry = (Map.Entry) mIterator.next();
            String mKey = (String)entry.getKey();
            if(mKey.equalsIgnoreCase(filterCA) ){
			    buf.append("<option SELECTED value=");
		    }else{
			    buf.append("<option value=");
		    }
		    buf.append(mKey);
		    buf.append(">");
		    buf.append(mKey);
            buf.append("</option>");
	    }
        buf.append("</td>\n");

	 }
     out.print( buf.toString());
   } catch(Exception e) {
      e.printStackTrace();
   }
   return SKIP_BODY;
  }



}