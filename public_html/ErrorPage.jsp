<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <%@ taglib  uri="/WEB-INF/taglib/NCITaglib.tld"  prefix="ncijsp" %>
  <%@ include file="Includes/PgmGlobalInclude.jsp"%>
  <%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants" %>
  <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
  <%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
  <%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> 
  <%@ page import="org.apache.struts.action.ActionMessage" %> 
  <%@ page import="org.apache.struts.action.ActionMessages" %>
  <%@ page isErrorPage="true" %>
  <%@ page import="java.io.PrintWriter" %>


<html>

<head>
    <title>Error</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="Stylesheets/PgmStyleSheet.css" type="text/css">

    <SCRIPT language=JavaScript src="pgm.js" type="text/javascript">
    </SCRIPT>
        <SCRIPT LANGUAGE=JAVASCRIPT>
          function EmailErrorWindow() {
               document.ErrorEmailForm.requestAction = "email";
               document.ErrorEmailForm.submit();
            }
          function openMessageSentWindow() {
               window.open('','MessageSent', 'width=450, height=200, resizable=yes');
               return true;
          }
        </SCRIPT> </head>
<body  " bgcolor="#FFFFFF" leftmargin="10" topmargin="10" marginwidth="10" marginheight="10">


<form  >

<!--Start Header -->
<!--Include the header -->
  <% String titleImage = "<img src=\"images/TitleQueries.gif\" width=\"98\" height=\"18\" alt=\"Queries\">"; %>
  <%@ include file="Includes/PgmHeader.jsp"%>
 
<!--End Your Grants Header -->


  <!--Start Info-->
  <table width="800" border="0" cellspacing="0" cellpadding="0" align="center">
      <tr>
        <td valign="top" align="left">&nbsp;</td>
        <td valign="top" align="left" width="100%">
              <br>
              <br>
            <span class="Body"><b><font color="#009999">Description</font></b><br><br>
            <%String errorMessage = (String) request.getSession().getAttribute(ApplicationConstants.ERROR_MESSAGE);%>
            <%= errorMessage %>
            <br><br>
	    <span class="Body">
	    	<html:form action="GrantSearchError.do" scope="request" > 
	    	   <b><font color="#009999">Error Message Notification</font></b>
	    	   <br>
	    	    Please report unusual errors to Application Support by explaining the action 
	    	    that you took when <br> the error occurred including details.<br><br>
	            <html:textarea property="userMessage" cols="50" rows="7"/>
	    	    <br><br>
	    	     Notify Application Support of the error by clicking on the "Send Email" button below.
	    	    <br><br>
            <html:submit styleClass="button" onclick="javascript: EmailErrorWindow();" tabindex="1" value="Send Email" />
	    	</html:form>
	   </span> 
           <br><br>
           <html:submit styleClass="button" onclick="javascript: history.go(-1);" tabindex="2" value="Back" />
      </span>
      </td>
    </tr>
  </table>
  <br>
  <br>
<!--End Info-->
</form>
<%@ include file="Includes/StandardFooter.jsp"%>

</body>

</html>