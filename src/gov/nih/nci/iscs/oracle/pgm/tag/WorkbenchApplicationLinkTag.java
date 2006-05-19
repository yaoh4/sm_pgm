package gov.nih.nci.iscs.oracle.pgm.tag;

//Jdk Imports
import gov.nih.nci.iscs.oracle.common.data.persistence.CommonHandlerFactory;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.impl.ApplicationLinksServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.hibernate.GwbLinksT;
import gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForm;

import java.util.*;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//Application imports

/*
** A tag to display application links in header/footer for applications
** Notifications, Workbench and YourGrants.
*/
public class WorkbenchApplicationLinkTag extends BodyTagSupport {
  private String m_Application;
  private String m_AdditionalParams = "false";
  private String m_AdditionalUrlText;
  private String m_javascript;
  private String m_windowparams;
  private String m_ApplicationKey;
  private GwbLinksT currentApplicationLink;
  protected final Log logger = LogFactory.getLog(getClass());


  private static String DEFAULT_JAVASCRIPT = "popUpSolo";
  private static String DEFAULT_WINDOW_PARAMS = "'scrollbars=yes,status=yes,toolbar=yes,location=yes,menubar=yes,resizable=yes,width=750,height=550'";
  private static String APPLICATION_MAP = "applicationmap";

  public void setApplication(String application) {
    m_Application = application;
  }

  public void setAdditionalUrlText(String pAdditionalUrlText) {
    m_AdditionalUrlText = pAdditionalUrlText;
  }

  public void setAdditionalParams(String pAdditionalParams) {
    m_AdditionalParams = pAdditionalParams;
  }

  public void setPopScript(String pScript){
     m_javascript = pScript;
  }

  public void setWindowParams(String pWindowParams){
     m_windowparams = pWindowParams;
  }

  public void setApplicationKey(String pApplicationKey){
     m_ApplicationKey = pApplicationKey;
  }

 public int doStartTag() throws JspTagException {
     StringBuffer buf = new StringBuffer();

     try {
       JspWriter out = pageContext.getOut();
       HttpSession session = pageContext.getSession();
       Map m_ApplicationMap = (Map)session.getAttribute(APPLICATION_MAP);
       //Get the application map from the database if it is not available in the session
       if (m_ApplicationMap == null) {
		   m_ApplicationMap = getApplicationMap();

           session.setAttribute(APPLICATION_MAP, m_ApplicationMap);
       }
       currentApplicationLink = (GwbLinksT)m_ApplicationMap.get(m_Application);
       if (currentApplicationLink != null) {
		  String thisUrl = currentApplicationLink.getProtocol() + "://" + currentApplicationLink.getLinkServer() + currentApplicationLink.getLinkPath();
		  buf.append("<a  class=OtherAppButton href=\'"  + thisUrl + "\'" +
                     "   target=_blank" + ">" );
       }
       out.print( buf.toString());
     }
     catch(Exception e) {
         logger.error(e);
     }
     return EVAL_BODY_TAG;
  }
  public int doAfterBody() throws JspTagException {
    try {
       JspWriter out = pageContext.getOut();
       if (currentApplicationLink != null) {
          out.print("</a>\n");
       }
    }
    catch (Exception e) {
        logger.error(e);
        throw new JspTagException("Error :"+e.getMessage());
    }
    return SKIP_BODY;
  }
  public int doEndTag() throws JspTagException
  {
    try
    {
      if(bodyContent != null) // Check if we even entered the body
        bodyContent.writeOut(bodyContent.getEnclosingWriter());
    }
    catch(java.io.IOException e)
    {
      logger.error(e);
      throw new JspTagException("IO Error: " + e.getMessage());
    }
    return EVAL_PAGE;
  }
public Map getApplicationMap() {

    Map mApplicationMap = null;
    try {

         ServletContext sc = pageContext.getServletContext();
         Object mApplicationContext =   sc.getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
         ApplicationLinksServiceImpl mApplicationLinksServiceImpl =  new ApplicationLinksServiceImpl(mApplicationContext);
         mApplicationMap  = mApplicationLinksServiceImpl.getApplicationLinks();
    } catch(Exception e) {
        e.printStackTrace();
    }
    return mApplicationMap;

}


}