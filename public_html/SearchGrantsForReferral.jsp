<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
   response.setHeader("Pragma","no-cache"); //HTTP 1.0 
   response.setDateHeader ("Expires", 0); //prevents caching 
   response.setHeader("Cache-Control","no-store"); //HTTP 1.1 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <%@ page contentType="text/html;charset=windows-1252"%>
  <%@ taglib  uri="/WEB-INF/taglib/NCITaglib.tld"  prefix="ncijsp" %>
  <%@ include file="Includes/PgmGlobalInclude.jsp"%>
  <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
  <%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
  <%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> 
  <%@ page import="org.apache.struts.action.ActionMessage" %> 
  <%@ page import="org.apache.struts.action.ActionMessages" %>


<html>
<head>
    <title>Referral Activity</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <meta http-equiv="Expires" CONTENT="0">
      <meta http-equiv="Cache-Control" CONTENT="no-cache">
      <meta http-equiv="Pragma" CONTENT="no-cache">

    <link rel="stylesheet" href="Stylesheets/PgmStyleSheet.css" type="text/css">
     <SCRIPT language="Javascript" src="pgm.js" type="text/javascript">
     </SCRIPT>

</head>
<body bgcolor="#FFFFFF" leftmargin="10" topmargin="10" marginwidth="10" marginheight="10" onload="getAnchorName()";>
<a name="top"></a>
<html:form action="SearchGrantsForReferral.do" method="POST" >
<html:hidden property="sortColumn" />
<html:hidden property="sortOrder" />
<html:hidden property="requestAction" />
<html:hidden property="gotoPageNumber" />
<html:hidden property="selectedKey" />
<html:hidden property="grantSelected" />
<html:hidden property="listGenerated" value='<%= (String) session.getAttribute("listGenerated")%>' />
<html:hidden property="sortActionSelected" />
<html:hidden property="searchButtonInitiated" />
<html:hidden property="timestamp" />
<html:hidden property="sortAscendingIndicator" />

<!--Start Header -->
<!--Include the header -->
  <% String titleImage = "<img src=\"images/TitleQueries.gif\" width=\"98\" height=\"18\" alt=\"Queries\">"; %>
  <% request.setAttribute(ApplicationConstants.SEARCH_ACTION, ApplicationConstants.REFERRAL); %>
  <% request.getSession().setAttribute("applicationName", "Referral");%>
  <%@ include file="Includes/PgmHeader.jsp"%>
<!--End Your Grants Header -->
<!--Start Tabs/Load -->
<table border="0" cellspacing="0" cellpadding="0" width="800" align="center">
   <tr>
      <td width="20" align="right">&nbsp;</td>
      <td colspan="5" background="images/TabBG.gif">
        <td height="5" nowrap><img src="images/spacer.gif" alt="" width="2" height="5"></td>
       </td>
        <td height="5" nowrap><img src="images/spacer.gif" alt="" width="2" height="5"></td>
       <td>
        <td height="5" nowrap><img src="images/spacer.gif" alt="" width="2" height="5"></td>
      </td>
      <td valign="top" width="20">&nbsp;</td>
    </tr>
</table>
<BR>
<!--Start Load/Description-->
<!--End Load/Description-->
<table border="0" cellspacing="0" cellpadding="0" width="800" align="center">
<tr><td>
<DIV ID="searchMessages" class="ErrorTextBoldItalics" >
  <logic:messagesPresent name="message" property="validation" message="true">
   <html:messages message="true" id="message" property="validation" header="validation.header" footer="validation.footer">
        <li><b><bean:write name="message"/></b></li>
  </html:messages>
  </logic:messagesPresent>

  <logic:messagesPresent name="message" property="search" message="true">
   <html:messages message="true" id="message" property="search" header="search.header" footer="search.footer">
        <li><b><bean:write name="message"/></b></li>
  </html:messages>
  </logic:messagesPresent>
</div>
</td></tr>
</table>
<!--Start Criteria -->
<!--Include the search criteria form -->
  <%@include file="Includes/referralCriteria.jsp"%>

<!--End Criteria -->

  <!--%@include file="Includes/Queries.jsp"%-->

<!--End Criteria -->
<a name="msgTop"></a>

<a name="listTop"></a>
<%@include file="Includes/referralGrantList.jsp"%>

<!--End Grant List -->

<!--Start Your Grants Footer -->
	<!--Include the footer -->
	
<!--End Your Grants Footer -->
<!--  PopCalendar(tag name and id must match) Tags should sit at the page bottom -->
<ncijsp:crystalReport/>
</html:form>
  <%@ include file="Includes/StandardFooter.jsp"%>
</body>

</html>
