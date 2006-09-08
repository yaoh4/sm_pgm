<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <%@ page contentType="text/html;charset=windows-1252"%>
  <%@ taglib  uri="/WEB-INF/taglib/NCITaglib.tld"  prefix="ncijsp" %>
  <%@ include file="Includes/PgmGlobalInclude.jsp"%>
  <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
  <%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
  <%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> 
  <%@ page import="org.apache.struts.action.ActionMessage" %> 
  <%@ page import="org.apache.struts.action.ActionMessages" %>
  <%@ page isErrorPage="true" %>
  <%@ page import="java.io.PrintWriter" %>

<%
   String applId = request.getParameter("applId");
   String grantNumber = request.getParameter("grantNumber");
%> 

<html>

<head>
    <title>Referred to Other CA Information</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

    <link rel="stylesheet" href="Stylesheets/PgmStyleSheet.css" type="text/css">

    <SCRIPT language=JavaScript src="pgm.js" type="text/javascript">
    </SCRIPT>
</head>
<body  " bgcolor="#FFFFFF" leftmargin="10" topmargin="10" marginwidth="10" marginheight="10">


<form  >

<!--Start Header -->
<!--Include the header -->
  <% String titleImage = "<img src=\"images/TitleQueries.gif\" width=\"98\" height=\"18\" alt=\"Queries\">"; %>
<table cellspacing="0" cellspacing = "0" class="logoTitle">
   <tr>
      <td  class="TitleSecondary" width="100%">
	 Referred to Other CA Information
      </td>
    </tr>
   <tr>
      <td width="5%">
	 Grant: &nbsp; <%= grantNumber %>
      </td>
    </tr>
  <tr>
    <td colspan="2" bgcolor="3F7EFF"><img src="images/spacer.gif" width="320" height="2"></td>
  </tr>
  <tr valign="top">
    <td width="100%" colspan="2" align="top"><INPUT type="button" class="button2a" value="Close Window" onclick="window.close();"/> 
     </td>
  </tr>
</table>

 
<!--End Your Grants Header -->


  <br>
  <ncijsp:applCAHistory  applId='<%= applId %>'/> </td>
  

  <br>
  <br>
  
<!--End Header -->
 
<table cellspacing="0" cellspacing = "0" class="logoTitle">
   <tr>
     <td   bgcolor="3F7EFF"><img src="images/spacer.gif" width="320" height="2"></td>
   </tr>
  <tr valign="top">
    <td align="top"><INPUT type="button" class="button2a" value="Close Window" onclick="window.close();"/> </td>
  </tr>
</table>
<!--End Info-->
</form>

</body>

</html>