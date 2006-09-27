package gov.nih.nci.iscs.oracle.pgm.tag;
//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper.LookupHelper;
import gov.nih.nci.iscs.oracle.pgm.service.LookUpObject;

import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class LookupSelectTag extends TagSupport
{
  private String   selectedValue;
  private String[]   lookUpValues;
  private String   changeScript;

  public void setSelectedValue(String selectedValue) {
     this.selectedValue = selectedValue;
  }
  public void setLookUpValues(String[] lookUpValues) {
     this.lookUpValues = lookUpValues;
  }
  public void setChangeScript(String changeScript) {
     this.changeScript = changeScript;
  }

  public int doStartTag() {
    try {

      StringBuffer buf = new StringBuffer();
      JspWriter out = pageContext.getOut();
      ServletContext sc = pageContext.getServletContext();

      buf.append("<SELECT NAME=\"");
      if (changeScript != null) {
         buf.append("\" SIZE=\"1\" OnChange=\""+changeScript+"\" >\n");
      }
      else {
         buf.append("\" SIZE=\"1\" >\n");
      }
      // get the hashTable with lookup Tables
	  ApplicationContext mApplicationContext =  (ApplicationContext) sc.getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
      ArrayList mLookupMap = LookupHelper.getLookUp(lookUpValues, mApplicationContext);

      if (mLookupMap != null) {
		  Iterator mIterator = mLookupMap.iterator();
		  while (mIterator.hasNext() ) {
			  LookUpObject mLookUpObject = (LookUpObject)  mIterator.next();
			  buf.append("<option value=");
              buf.append(mLookUpObject.getKey());
              buf.append(">");
              buf.append(mLookUpObject.getValue());
              buf.append("</option>\n");
		  }
	  }

      out.print( buf.toString());
  }
  catch(Exception e) {
      e.printStackTrace();
  }
  return SKIP_BODY;
}



}