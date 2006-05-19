package gov.nih.nci.iscs.oracle.pgm.tag;
//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.PaginationObject;


import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class PaginationTag extends TagSupport
{

  public static int FIRST_PAGE = 1;


  public int doStartTag() {
     try {
        String mLastPage = null;;
        StringBuffer buf = new StringBuffer();
        JspWriter out = pageContext.getOut();
        ServletContext sc = pageContext.getServletContext();
        HttpSession session = pageContext.getSession();
        PaginationObject mPaginationObject = (PaginationObject) session.getAttribute(ApplicationConstants.PAGINATION_OBJECT);
        mLastPage = mPaginationObject.getLastPageNumber().toString();

        if(mPaginationObject.getLastPageNumber().intValue() == 0) {
			buf.append("first < prev next > last ");
		} else {
          if(mPaginationObject.getIsFirstPage()) {
	    	   buf.append("&nbsp;first &nbsp;");
	      } else {
	    	   buf.append("&nbsp;<a href=\"javascript:gotoPage(\'" + FIRST_PAGE  + "\')\">first </a> &nbsp;&nbsp;");
          }

          if(mPaginationObject.getLastPageNumber().intValue() > FIRST_PAGE) {
	    	  buf.append("<");
	          if(mPaginationObject.getHasPreviousPage() ){
	    	     buf.append("&nbsp;<a href=\"javascript:setPagination(\'prev\')\">prev </a>");
	    	  } else {
	    	     buf.append("&nbsp; prev");
	    	  }

	          if(mPaginationObject.getHasNextPage() ){
	    	     buf.append("&nbsp;<a href=\"javascript:setPagination(\'next\')\">next</a>");
	    	  } else {
	    	     buf.append("&nbsp; next");
	    	  }

	    	  buf.append("> ");
              if(mPaginationObject.getIsLastPage()) {
	    	      buf.append("&nbsp;last &nbsp;");
	          } else {
	    	      buf.append("&nbsp;<a href=\"javascript:gotoPage(\'" + mLastPage + "\')\">last</a>");
	          }
	      }
	  }

      out.print( buf.toString());
   }  catch(Exception e) {
       e.toString();
   }
   return SKIP_BODY;
 }



}