package gov.nih.nci.iscs.oracle.pgm.tag;

import org.apache.struts.util.LabelValueBean;


//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.LookUpObject;
import gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForPDAForm;
import gov.nih.nci.iscs.oracle.pgm.service.impl.ProgamDirectorServiceImpl;
import org.springframework.context.ApplicationContext;
import java.util.*;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class FormatCancerActivitySelectTag extends TagSupport {

  private String key;
  private String cancerActivity;
  private ApplicationContext mApplicationContext;
  boolean disableSelect = false;

  public void setKey(String key) {

     this.key = key;
  }

  public int doStartTag() {
    try {
      HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
      JspWriter out = pageContext.getOut();
      ServletContext sc = pageContext.getServletContext();
      mApplicationContext =  (ApplicationContext) sc.getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
	  RetrieveGrantsForPDAForm mRetrieveGrantsForPDAForm = (RetrieveGrantsForPDAForm) request.getAttribute("retrieveGrantsForPDAForm");
      this.key = mRetrieveGrantsForPDAForm.getPdId();
      this.cancerActivity = mRetrieveGrantsForPDAForm.getCancerActivity();

	  StringBuffer buf = new StringBuffer();

      if(!key.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)) {
	     List mList = getCancerActivityForPDList(key);
	     if(mList.size() > 0) {
            formatSelectForPd(key, buf, mList);
		 } else {
			disableSelect = true;
		 }
	  }

      if(key.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) || disableSelect) {
	     List mList = (List) request.getAttribute(LookUpTableConstants.CANCER_ACTIVITIES_T_LOOKUP[0]);
		 formatEmptySelect(buf, mList);
	  }

      out.print( buf.toString());
     } catch(Exception e) {
      e.printStackTrace();
     }
   return SKIP_BODY;
  }

  private StringBuffer formatEmptySelect(StringBuffer buf, List mList) {

         if(disableSelect) {
             buf.append("<SELECT NAME=\"cancerActivity\" SIZE=\"1\" DISABLED=true>");
		     disableSelect	= false;
		 } else {
             buf.append("<SELECT NAME=\"cancerActivity\" SIZE=\"1\" onchange=\"setPDAction('continue')\">");
		 }
	     buf.append("<option SELECTED value=");
	     buf.append(ApplicationConstants.EMPTY_STRING);
	     buf.append(">");
	     buf.append(ApplicationConstants.EMPTY_STRING);
         buf.append("</option>\n");
	     Iterator mIterator = mList.iterator();

	     while(mIterator.hasNext() ){
	        LabelValueBean mLookUpValueBean = (LabelValueBean) mIterator.next();
	        String mValue = (String) mLookUpValueBean.getValue();
	        String mLabel = (String) mLookUpValueBean.getLabel();
	        if(mValue.equalsIgnoreCase(cancerActivity)) {
	  	       buf.append("<option SELECTED value=");
	        } else {
	           buf.append("<option value=");
		    }
	        buf.append(mValue);
	  	    buf.append(">");
	        buf.append(mValue);
	        buf.append("</option>");
		}

		return buf;
  }

  private StringBuffer formatSelectForPd(String key, StringBuffer buf, List mList) {

         buf.append("<SELECT NAME=\"cancerActivity\" SIZE=\"1\" onchange=\"setPDAction('continue')\">");
	     buf.append("<option SELECTED value=");
	     buf.append(ApplicationConstants.EMPTY_STRING);
	     buf.append(">");
	     buf.append(ApplicationConstants.EMPTY_STRING);
         buf.append("</option>\n");

	     Iterator mIterator = mList.iterator();

	     while(mIterator.hasNext() ){
	        LabelValueBean mLookUpValueBean = (LabelValueBean) mIterator.next();
	        String mValue = (String) mLookUpValueBean.getValue();
	        String mLabel = (String) mLookUpValueBean.getLabel();
	        if(mValue.equalsIgnoreCase(cancerActivity)) {
	  	       buf.append("<option SELECTED value=");
	        } else {
	           buf.append("<option value=");
		    }
	        buf.append(mValue);
	  	    buf.append(">");
	        buf.append(mLabel);
	        buf.append("</option>");
		}

		return buf;
  }
   private List getCancerActivityForPDList(String key) {

 	// get the lookup infomation
 	String cancerActivity = null;
     ProgamDirectorServiceImpl mProgamDirectorServiceImpl =  new ProgamDirectorServiceImpl(mApplicationContext);
 	 List mList  = mProgamDirectorServiceImpl.getCancerActivityForPD(key);
     return mList;
   }


 }