<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <%@ page contentType="text/html;charset=UTF-8"%>
  <%@ taglib  uri="/WEB-INF/taglib/NCITaglib.tld"  prefix="ncijsp" %>
  <%@ include file="Includes/PgmGlobalInclude.jsp"%>
  <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
  <%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
  <%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> 
  <%@ page import="org.apache.struts.action.Action" %> 
  <%@ page import="org.apache.struts.action.ActionErrors" %>
  <%@ page import="gov.nih.nci.iscs.oracle.pgm.forms.PdAssignmentForm" %>

<html>
<head>
    <title>Program Director Assignment Results</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="Stylesheets/PgmStyleSheet.css" type="text/css">

    <SCRIPT language=JavaScript src="pgm.js" type="text/javascript">
    </SCRIPT>
</head>
<body  " bgcolor="#FFFFFF" leftmargin="10" topmargin="10" marginwidth="10" marginheight="10">

<logic:messagesPresent name="message" property="validation" message="true">
   <html:messages message="true" id="message" property="validation" header="validation.header" footer="validation.footer">
        <li><b><bean:write name="message"/></b></li>
  </html:messages>
</logic:messagesPresent>

<html:form action="PdAssignment.do" method="POST" >
<html:hidden property="requestAction" />
  <% String titleImage = "<img src=\"images/TitleQueries.gif\" width=\"98\" height=\"18\" alt=\"Queries\">"; %>
  <%@ include file="Includes/PgmHeader.jsp"%>
<!--End Your Grants Header -->

<table border="0" cellspacing="0" cellpadding="0" width="800" >
  <tr>
      <td colspan="2"> &nbsp; </td>
  </tr>
  <tr>
      <td width="20" align="right">
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <!--Include the drop down to select additional Creiteria -->
       <%@include file="Includes/pdAssignmentButton.jsp"%>
      </td>
  </tr>
  <tr>
      <td width="20" align="right">&nbsp;</td>
  </tr>
  <tr>
      <td width="600" align="left"><H3> Program Director Assignment Results </H3></td>
  </tr>
  <tr>
      <td width="20" align="right">&nbsp;</td>
  </tr>
   <tr>
     <td>
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <!--Include the drop down to select additional Creiteria -->
       <%@include file="Includes/assignPdCompleteTable.jsp"%>
     </table>
    </td>
  </tr>
</table>
 
 </html:form>
<%@ include file="Includes/StandardFooter.jsp"%>
 
 </body>
 
</html>