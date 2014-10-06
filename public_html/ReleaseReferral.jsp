<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <%@ taglib  uri="/WEB-INF/taglib/NCITaglib.tld"  prefix="ncijsp" %>
  <%@ include file="Includes/PgmGlobalInclude.jsp"%>
  <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
  <%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
  <%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> 
  <%@ page import="org.apache.struts.action.Action" %> 
  <%@ page import="org.apache.struts.action.ActionErrors" %>
  <%@ page import="gov.nih.nci.iscs.oracle.pgm.forms.RejectReferralForm" %>

<html>
<head>
    <title>Referral Release Dual </title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta http-equiv="Expires" CONTENT="0">
      <meta http-equiv="Cache-Control" CONTENT="no-cache">
      <meta http-equiv="Pragma" CONTENT="no-cache">

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

<html:form action="ReleaseReferral.do" method="POST" >
<html:hidden property="requestAction" />
<html:hidden property="selectedIndex" />
<html:hidden property="sortColumn" />
<html:hidden property="sortAscendingIndicator" />
  <% String titleImage = "<img src=\"images/TitleQueries.gif\" width=\"98\" height=\"18\" alt=\"Queries\">"; %>
  <%@ include file="Includes/PgmHeader.jsp"%>
<!--End Your Grants Header -->

<table border="0" cellspacing="0" cellpadding="0" width="800" >
  <tr>
      <td width="20" align="right">
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <!--Include the drop down to select additional Creiteria -->
       <%@include file="Includes/referralActivityButton.jsp"%>
     </table>
      
      </td>
  </tr>
  <tr>
      <td width="600" align="left"><H3>Referral Release Dual  </H3></td>
  </tr>
  <tr>
      <td width="20" align="right">&nbsp;</td>
  </tr>
   <tr>
     <td>
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <!--Include the drop down to select additional Creiteria -->
       <%@include file="Includes/releaseReferralTable.jsp"%>
     </table>
    </td>
  </tr>
</table>
 
 </html:form>
 
 </body>
<%@ include file="Includes/StandardFooter.jsp"%>
 
</html>