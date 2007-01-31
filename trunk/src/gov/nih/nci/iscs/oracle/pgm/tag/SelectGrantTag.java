package gov.nih.nci.iscs.oracle.pgm.tag;


//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForm;
import gov.nih.nci.iscs.oracle.pgm.forms.PaginationObject;

import java.util.*;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
//Application imports

public class SelectGrantTag extends TagSupport {
  private String    key;
  private int index;
  private String formName;


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
      StringBuffer buf = new StringBuffer();
      HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
      JspWriter out = pageContext.getOut();
      PaginationObject mPaginationObject = (PaginationObject) request.getSession().getAttribute(ApplicationConstants.PAGINATION_OBJECT);
      RetrieveGrantsForm mForm = (RetrieveGrantsForm) request.getAttribute(formName);
      TreeMap mSelectedGrants = (TreeMap) request.getSession().getAttribute(ApplicationConstants.SELECTED_GRANTS);
      boolean grantSelected = false;
      if(mSelectedGrants != null ) {
         if(mSelectedGrants.containsKey(key)) {
		    grantSelected = true;
	     }
	  }

      String controlName = "selected" + index;
      if(grantSelected) {
		  buf.append("<input type=\"checkbox\" NAME=\"" + controlName + "\" checked onClick=\"setGrantSelected(\'" + key + "\', document." + formName + "." + controlName + ".checked);\" >");
      } else {
		  buf.append("<input type=\"checkbox\" NAME=\"" + controlName + "\" onClick=\"setGrantSelected(\'" + key + "\', document." + formName + "." + controlName + ".checked);\" >");
	  }
	  buf.append("\n");

      out.print( buf.toString());
     } catch(Exception e) {
      e.printStackTrace();
     }
   return SKIP_BODY;
  }


}