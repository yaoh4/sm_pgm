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

public class FormatPDorgSelectTag extends TagSupport {

  private String cancerActivity  ;
  private String personId  ;
  private String pdOrg  ;
  private ApplicationContext mApplicationContext;
  boolean disableSelect = true;


  public void setCancerActivity(String cancerActivity) {

     this.cancerActivity = cancerActivity;
  }
  public void setPersonId(String personId) {

     this.personId = personId;
  }

  public int doStartTag() {
    try {
      HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
      JspWriter out = pageContext.getOut();
      ServletContext sc = pageContext.getServletContext();
      mApplicationContext =  (ApplicationContext) sc.getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
	  RetrieveGrantsForPDAForm mRetrieveGrantsForPDAForm = (RetrieveGrantsForPDAForm) request.getAttribute("retrieveGrantsForPDAForm");
      this.cancerActivity = ApplicationConstants.EMPTY_STRING;
      this.personId = ApplicationConstants.EMPTY_STRING;
      this.pdOrg = ApplicationConstants.EMPTY_STRING;
      disableSelect  = true;

      if(mRetrieveGrantsForPDAForm.getCancerActivity() != null)
         this.cancerActivity = mRetrieveGrantsForPDAForm.getCancerActivity();
      if(mRetrieveGrantsForPDAForm.getPdId() != null)
         this.personId = mRetrieveGrantsForPDAForm.getPdId();
      if(mRetrieveGrantsForPDAForm.getPdOrg() != null)
         this.pdOrg = mRetrieveGrantsForPDAForm.getPdOrg();

	  StringBuffer buf = new StringBuffer();

      if(!cancerActivity.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING ) &
         !personId.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING ) )  {
	       System.out.println("**** about to process getPDOrgForCAList for boolean ***" + disableSelect);
	       List mList = getPDOrgForCAList(cancerActivity, personId );
	       if(mList.size() > 0) {
		     formatSelectForCA(this.cancerActivity, this.personId, buf, mList);
		     disableSelect = false;
		   }
	  }

      if(cancerActivity.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ||
         personId.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)  ||
         disableSelect) {
	       System.out.println("**** about to process formatEmptySelect for boolean ***" + disableSelect);
	        List mList = (List)  request.getAttribute(LookUpTableConstants.PD_ORG_VW3_LOOKUP[0]);
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
             buf.append("<SELECT NAME=\"pdOrg\" SIZE=\"1\" DISABLED=true>");
		     disableSelect	= false;
		 } else {
             buf.append("<SELECT NAME=\"pdOrg\" SIZE=\"1\" onchange=\"setPDAction('continue')\">");
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
            buf.append("<option value=");
	        buf.append(mValue);
	  	    buf.append(">");
	        buf.append(mLabel);
	        buf.append("</option>");
		}

		return buf;
  }


  private StringBuffer formatSelectForCA(String cancerActivity, String personId, StringBuffer buf, List mList) {

         buf.append("<SELECT NAME=\"pdOrg\" SIZE=\"1\">");
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
	        if(mValue.equalsIgnoreCase(pdOrg)) {
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

   private List getPDOrgForCAList(String cancerActivity, String personId) {

 	// get the lookup infomation
     ProgamDirectorServiceImpl mProgamDirectorServiceImpl =  new ProgamDirectorServiceImpl(mApplicationContext);
 	 List mList  = mProgamDirectorServiceImpl.getPDOrgForCA(cancerActivity, personId);
     return mList;
   }


 }