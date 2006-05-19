package gov.nih.nci.iscs.oracle.pgm.tag;
//Jdk Imports
import gov.nih.nci.iscs.oracle.common.data.persistence.CommonHandlerFactory;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.hibernate.GrantQueriesT;
import gov.nih.nci.iscs.oracle.pgm.service.impl.UserServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.service.UserFilterInfo;


import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class AdditionalCriteriaTag extends TagSupport
{
  private String   oracleUserId;
  private String   controlName;
  private String   changeScript;

  public void setOracleUserId(String oracleUserId) {
     this.oracleUserId = oracleUserId;
  }
  public void setControlName(String controlName) {
     this.controlName = controlName;
  }
  public void setChangeScript(String changeScript) {
     this.changeScript = changeScript;
  }

  public int doStartTag() {
    try {
      StringBuffer buf = new StringBuffer();
      JspWriter out = pageContext.getOut();

      buf.append("<SELECT NAME=\"");
      buf.append((controlName==null)?"grantsFrom":controlName);
      if (changeScript != null) {
         buf.append("\" SIZE=\"1\" OnChange=\""+changeScript+"\" >\n");
      }
      else {
         buf.append("\" SIZE=\"1\" >\n");
      }
      buf.append("<option value=");
      buf.append(ApplicationConstants.ALL_GRANTS);
      buf.append(">");
      buf.append(ApplicationConstants.ALL_GRANTS);
      buf.append("</option>\n");
      UserFilterInfo mUserFilterInfo = getUserFilerInfo();
      if( mUserFilterInfo.getPortfolioFlag() ) {
		  String mTempValue = parseListItems(ApplicationConstants.MY_PORTFOLIOS,
		                 mUserFilterInfo.getCancerActivityCodes());
	      buf.append("<OPTION");
		       buf.append(ApplicationConstants.MY_PORTFOLIOS_VALUE);
		            buf.append(">");
		            buf.append(mTempValue);
                    buf.append("</OPTION>\n");
      }

      if( mUserFilterInfo.getCancerActivityFlag() ) {
		  String mTempValue = parseListItems(ApplicationConstants.MY_CANCER_ACTIVITIES,
		                 mUserFilterInfo.getCancerActivityCodes());
	      buf.append("<OPTION  VALUE=");
		  buf.append(ApplicationConstants.MY_CANCER_ACTIVITIES_VALUE);
		  buf.append("> ");
		  buf.append(mTempValue);
          buf.append("</OPTION>\n");
      }
      out.print( buf.toString());
  }
  catch(Exception e) {
      e.printStackTrace();
  }
  return SKIP_BODY;
}

public String parseListItems(String aListType, List aList) {

   Iterator mIterator = null;
   StringBuffer mStringBuffer = new StringBuffer(aListType);
   mStringBuffer.append("(");
   boolean mFirstIteration = true;

   mIterator = aList.iterator();
   while (mIterator.hasNext() ) {
	   if(!mFirstIteration) {
          mStringBuffer.append(",");
	  }
      mStringBuffer.append ((String) mIterator.next());
	  mFirstIteration = false;
   }
   mStringBuffer.append(")");
   return mStringBuffer.toString().replaceAll("'", "");
}


 public UserFilterInfo getUserFilerInfo() {

    UserFilterInfo mUserFilterInfo =null;
    try {

        HttpSession session = pageContext.getSession();
        mUserFilterInfo = (UserFilterInfo) session.getAttribute(ApplicationConstants.USER_FILTER_INFO);
        //Check if the session has the user queries list
        if (mUserFilterInfo == null) {
            ServletContext sc = pageContext.getServletContext();
            Object mApplicationContext =   sc.getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
            UserServiceImpl mUserServiceImpl =  new UserServiceImpl(mApplicationContext, oracleUserId);
	        mUserFilterInfo = mUserServiceImpl.getUserFilerInfo(oracleUserId);
	        session.setAttribute(ApplicationConstants.USER_FILTER_INFO, mUserFilterInfo);
        }
    } catch(Exception e) {
        e.printStackTrace();
    }
    System.out.println("**** ended AdditionalCriteriaTag- mUserFilterInfo ***");
    return mUserFilterInfo;
  }
}