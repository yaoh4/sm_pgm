package gov.nih.nci.iscs.oracle.pgm.tag;

import org.apache.struts.util.LabelValueBean;


//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.helper.LookupHelper;

import java.util.*;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
//Application imports

public class ProgramDirCATag extends TagSupport {
  private int    indx;

  public void setIndx(String indx) {
	  Integer newIndex = new Integer(indx);
     this.indx = newIndex.intValue();
  }

  public void setIndx(int indx) {
     this.indx = indx;
  }

  public int doStartTag() {
    try {
      StringBuffer buf = new StringBuffer();
      String className = "ta";
      HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
      JspWriter out = pageContext.getOut();

      buf.append("<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"400\" align=\"center\">");
	  buf.append("<tr>");
	  buf.append("<td headers=\"header01\" width=\"70%\" class=listCellHead> PROGRAM DIRECTOR </td>");
	  buf.append("<td headers=\"header01\" width=\"30%\" class=listCellHead> CANCER ACTIVITY </td>");
	  buf.append("</tr>");

      HashMap mLookUpHash = LookupHelper.getLookUpTableHash();
      ArrayList caList = (ArrayList) mLookUpHash.get(LookUpTableConstants.PD_CA_ASGNMT_VW_LOOKUP[0]);
      //ArrayList caList = (ArrayList) request.getAttribute(LookUpTableConstants.PD_CA_ASGNMT_VW_LOOKUP[0]);
      Iterator mIterator = caList.iterator();
      while(mIterator.hasNext() ){
		  LabelValueBean mLookUpValueBean = (LabelValueBean) mIterator.next();
          String mValue = mLookUpValueBean.getValue();
          String mLabel = mLookUpValueBean.getLabel();
	      buf.append("<tr>");
	      buf.append("<td headers=\"header01\" width=\"70%\" class=listCell>" + mValue + "</td>");
	      buf.append("<td headers=\"header01\" width=\"30%\" class=listCell5>" + mLabel + "</td>");
	      buf.append("</tr>");

      }
	  buf.append("<INPUT TYPE=\"BUTTON\" VALUE=\"Close Window\" onClick=\"window.close()\">");

      out.print( buf.toString());

     } catch(Exception e) {
      e.printStackTrace();
     }
   return SKIP_BODY;
  }


}