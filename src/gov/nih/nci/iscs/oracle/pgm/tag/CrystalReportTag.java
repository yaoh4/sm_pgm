package gov.nih.nci.iscs.oracle.pgm.tag;



import gov.nih.nci.iscs.oracle.pgm.hibernate.ReportsVw;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;

import javax.servlet.ServletContext;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.http.*;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import gov.nih.nci.iscs.oracle.common.helper.ApplicationInfo;

/**
 * A tag to generate the crystal report based on the db report id, crystal report id
 * and format selected by the user.
 * @author Oracle
 */
public class CrystalReportTag extends TagSupport {
  private static Logger logger = LogManager.getLogger(CrystalReportTag.class);

  public int doStartTag() throws JspException{

    try {
      JspWriter out = pageContext.getOut();
      HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
      HttpSession session = request.getSession();
      String browserType = request.getHeader("User-Agent");

      String mReportAction = (String)session.getAttribute("reportAction");
      ReportsVw mReportDetails = (ReportsVw)session.getAttribute("reportDetails");

      if(mReportDetails == null) {
		  mReportDetails = new ReportsVw();
	  }
	  if(mReportAction==null) {
		  mReportAction = new String(ApplicationConstants.EMPTY_STRING);
	  }

      String mReportFormat = mReportDetails.getFormatType();
      Long   mTempReportId = mReportDetails.getRepId();
      //Long   mTempReportId = new Long("1960");
      boolean ie = false;
      if (browserType.lastIndexOf("MSIE") >= 0 ) {
         ie = true;
      }

      StringBuffer buf = new StringBuffer(" ");
      ApplicationInfo applInfo = ApplicationInfo.getInstance(ApplicationConstants.APPLICATION_KEY);
      // Generate the report only if the report type selected is not null

      if ((mReportAction != null)&&(mReportAction.equalsIgnoreCase("run"))&&(mReportDetails != null)&&(mTempReportId != null)) {
         String vCrystalUrl = applInfo.getApplicationKey("CRYSTAL.SERVER.URL");
         String vApsName = applInfo.getApplicationKey("CRYSTAL.SERVER.APSNAME");
         String vApsUser = applInfo.getApplicationKey("CRYSTAL.SERVER.APSUSER");
         String vApsAuthType = applInfo.getApplicationKey("CRYSTAL.SERVER.APSAUTHTYPE");
         String vAuthUrl = "&apsname="+vApsName+"&user="+vApsUser+"&apsauthtype="+vApsAuthType;
         String vExportFormat = "";

         if (mReportFormat.equals("PDF")) {
            vExportFormat = ApplicationConstants.PDF_EXPORT_FORMAT;
         }
         if (mReportFormat.equals("Excel")) {
             vExportFormat = ApplicationConstants.EXCEL_EXPORT_FORMAT;
         }
         if (mReportFormat.equals("Report")) {
            vExportFormat = "";
         }
         Object sessionId = session.getId();
         System.out.println("Report db rec id "+mReportDetails.getCrystalId());

         Long crystalReportId = null;
         if (mReportDetails != null)
         {
            crystalReportId = mReportDetails.getCrystalId();
         }
         if (crystalReportId != null)
         {
            buf.append("<SCRIPT language=JavaScript>\n");
            buf.append("window.open('"+vCrystalUrl+"?id="+crystalReportId+((mReportFormat.equals("Report"))?((ie)?ApplicationConstants.ACTIVEX_VIEWER:ApplicationConstants.JAVA_VIEWER):"")+vAuthUrl+
                       "&promptex0="+sessionId+"&promptex1="+crystalReportId+vExportFormat+"&connect=1"+
                       "','"+"ReportWindow"+crystalReportId+"', 'width=700, height=500, resizable=yes');\n");
            buf.append("</SCRIPT>\n");
         }
      }
      logger.debug(buf);
      session.setAttribute("reportAction", null);
      out.print( buf.toString());
    }
    catch(Exception e) {
      logger.error(e);
      throw new JspException("Error calling report."+ e.getMessage());
    }
    return SKIP_BODY;
  }



}
