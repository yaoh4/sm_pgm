<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <%@ taglib  uri="/WEB-INF/taglib/NCITaglib.tld"  prefix="ncijsp" %>
  <%@ include file="Includes/PgmGlobalInclude.jsp"%>
  <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
  <%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
  <%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> 
  <%@ page import="org.apache.struts.action.Action" %> 
  <%@ page import="org.apache.struts.action.ActionErrors" %>
  <%@ page import="gov.nih.nci.iscs.oracle.pgm.forms.PdAssignmentForm" %>
<jsp:useBean id="pdAssignmentForm" scope="request"
                           class="gov.nih.nci.iscs.oracle.pgm.forms.PdAssignmentForm" />

<html>
<head>
    <logic:notEqual name="pdAssignmentForm" property="requestAction" value="<%= ApplicationConstants.ASSIGN_PORTFOLIO%>">
       <title>Individual Assignment</title>
    </logic:notEqual>
    <logic:equal name="pdAssignmentForm" property="requestAction" value="<%= ApplicationConstants.ASSIGN_PORTFOLIO%>">
       <title>Portfolio Assignment</title>
    </logic:equal>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="Stylesheets/PgmStyleSheet.css" type="text/css">

    <SCRIPT language=JavaScript src="pgm.js" type="text/javascript">
    </SCRIPT>
    <SCRIPT language="JavaScript" src="date-picker.js">
    </SCRIPT>
    <SCRIPT language=JavaScript src="FieldChek.js">
    </SCRIPT>
    <SCRIPT language=JavaScript src="JavascriptFiles.js">
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
<html:hidden property="selected" />
<html:hidden property="index" />
<html:hidden property="count" />
<html:hidden property="sortColumn" />
<html:hidden property="sortAscendingIndicator" />
  <% String titleImage = "<img src=\"images/TitleQueries.gif\" width=\"98\" height=\"18\" alt=\"Queries\">"; %>
  <%@ include file="Includes/PgmHeader.jsp"%>
<!--End Your Grants Header -->

<table border="0" cellspacing="0" cellpadding="0" width="800">
  <tr>
     <td>
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <!--Include the drop down to select additional Creiteria -->
       <%@include file="Includes/pdAssignmentButton.jsp"%>
     </table>
    </td>
  </tr>
  <tr>
    <logic:notEqual name="pdAssignmentForm" property="requestAction" value="<%= ApplicationConstants.ASSIGN_PORTFOLIO%>">
       <td width="600" align="left"><H3>Individual Assignment</H3></td>
    </logic:notEqual>
    <logic:equal name="pdAssignmentForm" property="requestAction" value="<%= ApplicationConstants.ASSIGN_PORTFOLIO%>">
       <td width="600" align="left"><H3>Portfolio Assignment</H3></td>
    </logic:equal>

  </tr>
  <tr>
      <td width="20" align="right">&nbsp;</td>

   <tr>
     <td>
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
         <!--Include the drop down to select additional Creiteria -->
         <%@include file="Includes/assignPdTable.jsp"%>
       </table>
     </td>
  </tr>
  <tr><td > &nbsp; </td></tr>
</table>
 
 </html:form>
 
<%@ include file="Includes/StandardFooter.jsp"%>
 
 </body>
<!--  PopCalendar(tag name and id must match) Tags should sit at the page bottom -->
<iframe title="Calendar" width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;">
<LAYER name="gToday:normal:agenda.js" src="npopeng.htm">     </LAYER>
</iframe> 
 
</html>