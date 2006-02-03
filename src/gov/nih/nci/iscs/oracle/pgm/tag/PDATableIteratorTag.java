package gov.nih.nci.iscs.oracle.pgm.tag;
//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.PDASearchResultObject;


import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
import java.util.*;
//Application imports

public class PDATableIteratorTag extends TagSupport
{

  public int doStartTag() {
    try {
      int minPage = 0;
      int maxPage = 0;
      StringBuffer buf = new StringBuffer();
      JspWriter out = pageContext.getOut();
      ServletContext sc = pageContext.getServletContext();
      HttpSession session = pageContext.getSession();
      HttpServletRequest request = (HttpServletRequest)  pageContext.getRequest();
      ArrayList queryResults = (ArrayList) request.getAttribute("queryResults");

      Iterator mIterator = queryResults.iterator();
      while (mIterator.hasNext() ) {
		  PDASearchResultObject queryResultObject = (PDASearchResultObject) mIterator.next();

		  buf.append("<td headers=\"header00\" width=\"3%\" class=listCell>");;
		  buf.append("<input type=checkbox name=\"selected\">");
		  buf.append("</td>");

		  buf.append("<td headers=\"header01\" width=\"17%\" class=listCell>");
		  buf.append(queryResultObject.getPdFullName());
		  buf.append("</td>");


		  buf.append("<td headers=\"header02\" width=\"30%\" class=listCell>");
		  buf.append(queryResultObject.getPdOrg());
		  buf.append("</td>");

		  buf.append("<td headers=\"header03\" width=\"10%\" class=listCell>");
		  buf.append(queryResultObject.getFy());
		  buf.append("</td>");

		  buf.append("<td headers=\"header04\" width=\"17%\" class=listCell>");
		  buf.append(queryResultObject.getGrantNumber());
		  buf.append("</td>");

		  buf.append("<td headers=\"header05\" width=\"3%\" class=listCell>");
		  buf.append(queryResultObject.getCancerActivity());
		  buf.append("</td>");

		  buf.append("<td headers=\"header06\" width=\"10%\" class=listCell>");
		  buf.append(queryResultObject.getNcabDate());
		  buf.append("</td>");

		  buf.append("<td headers=\"header07\" width=\"10%\" class=listCell5>");
		  if(queryResultObject.getPdStartDate() != null) {
			  String temp = queryResultObject.getPdStartDate().toString();
			  System.out.println("*** now in tag and temp is ***** " + temp);
		     buf.append(temp.substring(0, 10));
		  }else {
		     buf.append(ApplicationConstants.EMPTY_STRING);
		  }

		  buf.append("</td>");

      }


      out.print( buf.toString());


  }  catch(Exception e) {
      e.printStackTrace();
  }
  return SKIP_BODY;
}



}