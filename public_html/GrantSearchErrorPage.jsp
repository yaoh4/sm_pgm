<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
   response.setHeader("Pragma","no-cache"); //HTTP 1.0 
   response.setDateHeader ("Expires", 0); //prevents caching 
   response.setHeader("Cache-Control","no-store"); //HTTP 1.1 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <%@ page contentType="text/html;charset=windows-1252"%>
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
    <title>Error </title>
     <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

    <link rel="stylesheet" href="Stylesheets/PgmStyleSheet.css" type="text/css">

    <SCRIPT language=JavaScript src="pgm.js" type="text/javascript">
    </SCRIPT>
</head>
<body  bgcolor="#FFFFFF" leftmargin="10" topmargin="10" marginwidth="10" marginheight="10">


<html:form action="GrantSearchError.do" method="POST" >

<!--Start Header -->
<html:hidden property="requestAction" />
<html:hidden property="returnAction" />
<!--Include the header -->
  <% String titleImage = "<img src=\"images/TitleQueries.gif\" width=\"98\" height=\"18\" alt=\"Queries\">"; %>
  <%@ include file="Includes/PgmHeader.jsp"%>
  <% String returnTag = (String) session.getAttribute("returnTag");
     String returnAction = (String) session.getAttribute("returnAction"); %>
    
  <table border="0" cellspacing="0" cellpadding="0" width="800">
        <tr> 
          <td width="10%" align="left">
               <input class="button2a" type="button" value='<%= returnTag %>'  onclick="setCurrentExceptionAction('return', '<%=returnAction%>');"/>
          </td>
	  <td width="90%">&nbsp;</td> 
        </tr>
  </table> 
<!--End Your Grants Header -->


  <!--Start Info-->
  <table width="800" border="0" cellspacing="0" cellpadding="0" align="center">
      <tr>
        <td valign="top" align="left">&nbsp;</td>
        <td valign="top" align="left" width="100%">
              <br>
              <br>
            <b><font color="#009999">Description</font></b><br><br>
            <%String errorMessage = (String) session.getAttribute(ApplicationConstants.ERROR_MESSAGE);%>
            <%= errorMessage %>
            <br><br>
	    <span class="Body">
               <html:form action="GrantSearchError.do" method="POST" >
	    	   <b><font color="#009999">Error Message Notification</font></b>
	    	   <br>
	    	    Please report unusual errors to Application Support by explaining the action 
	    	    that you took when <br> the error occurred including details.<br><br>
	            <html:textarea property="userMessage" cols="50" rows="7"/>
	    	    <br><br>
	    	     Notify Application Support of the error by clicking on the "Send Email" button below.
	    	    <br><br>
            	   <input class="button2a" type="button" value='<%= returnTag %>'  onclick="javascript: history.go(-1);"/>
                   <input class="button2a" type="button" value="Send"  onclick="sendErrorMessage('email');"/></td>
	    	</html:form>
	 
           <br><br>
      </span>
      </td>
    </tr>
  </table>
  <br>
  <br>
<!--End Info-->
 </html:form>
<%@ include file="Includes/StandardFooter.jsp"%>

</body>

</html>