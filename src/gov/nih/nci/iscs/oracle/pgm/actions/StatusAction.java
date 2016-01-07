package gov.nih.nci.iscs.oracle.pgm.actions;


import gov.nih.nci.iscs.oracle.pgm.forms.StatusForm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
public class StatusAction extends Action {

    private Logger logger = LogManager.getLogger(gov.nih.nci.iscs.oracle.pgm.actions.StatusAction.class);
    StatusForm mStatusForm =  new StatusForm();
  String mAction = null;

  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {


       mStatusForm = (StatusForm) form;
       mAction = mStatusForm.getRequestAction();
        try {
           checkPGMStatus(request, response);
        }
        catch(Exception e)
        {
           logError(e, response);
           response.sendError(response.SC_INTERNAL_SERVER_ERROR);
        }
       return mapping.findForward("continue");

   }  

    /**
     * This method uses the app connection pool to query the main application view.
     */
    private void checkPGMStatus(HttpServletRequest request,
        HttpServletResponse response) throws Exception  {

        try {

           response.setStatus(response.SC_OK);
        } catch (Exception e) {
            logError((Throwable)new Exception("Error verifying the database connection and query."), response);
            throw e;
        }
    } 

  private void logError(Throwable t, HttpServletResponse response)
  {
     logger.error("******* Program Management Status Error ******");
     logger.error(t.getMessage());
     logger.error(t);
     try { //Try writing the error message to the response
       PrintWriter writer = response.getWriter();
       writer.print("\nMessage :"+t.getMessage()+"\n");
       writer.print("***************************************************\n");
       t.printStackTrace(writer);
       response.flushBuffer();
     }
     catch(IOException ie)
     {
        //ignore the exception
     }
  }

}