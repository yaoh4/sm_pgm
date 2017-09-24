<%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants"%>
  <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
  <%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
  <%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> 
  <%@ page import="org.apache.struts.action.Action" %> 
  <%@ page import="org.apache.struts.action.ActionErrors" %>
  <%@ page import="gov.nih.nci.iscs.oracle.pgm.forms.SearchNedUsersForm" %>

<html>
<head>
    <title>Change User </title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta http-equiv="Expires" CONTENT="0">
      <meta http-equiv="Cache-Control" CONTENT="no-cache">
      <meta http-equiv="Pragma" CONTENT="no-cache">

    <link rel="stylesheet" href="Stylesheets/PgmStyleSheet.css" type="text/css">
    <link rel="stylesheet" href="Stylesheets/ChangeUserStylesheet.css" type="text/css">
</head>
<body bgcolor="#FFFFFF" leftmargin="10" topmargin="10" marginwidth="10"
	marginheight="10">
  <%@ include file="Includes/PgmHeader.jsp"%>
   <div id="content" style="width: 1000px;">
	<h4>Change User</h4>
	<ul class="links" style="float:right;">
	<li class="linksHeader"><a href="cancelUser.do">Return to Home Page</a></li>
	<li class="linksHeader last"><a href="restoreUser.do">Restore To the User Login</a></li>
	</ul>
	<div id="box2">
		<fieldset style="width: 1000px;">
		<logic:messagesPresent name="message" property="validation" message="true">
   <html:messages message="true" id="message" property="validation" header="validation.header" footer="validation.footer">
        <li><b><bean:write name="message"/></b></li>
  </html:messages>
</logic:messagesPresent>
		<html:form action="/SearchUsers">
		 <html:errors/>
     <div style="font-size: 13px; margin: 0 0; font-weight: bold; color: #6A6A6A;">
	Search for a user whose view of the system you would like to experience.
    </div> 
    <br/> 
    <div style="float: left; margin: 5px 25px">
     <fieldset style="width: 700px;">
        <legend style="font-size: 12px; font-weight: bold; color: #6A6A6A;">Criteria</legend>
        <label for="lastName"
             style="text-align: left; width: auto; padding-right: 5px; font-size:10px;">
       <span>&nbsp;</span>
      <strong>Last Name:</strong> 
      </label>
  <html:text property="lastName" maxlength="30" size="20"/> <br><br>
      <label for="firstName"
             style="text-align: left; width: auto; padding-right: 5px; font-size:10px;"> <strong> First Name: </strong> </label>
             <span>&nbsp;</span>
               <html:text property="firstName" maxlength="30" size="20"/>
             <div class="btn_display" style="padding: 0px; margin-top: 10px;">
       <html:submit styleClass="button2a" >Search</html:submit>
      </div>
        </fieldset>
        </div>
   </html:form>
    <br>
    <br>

<html:form action="/SelectUser">
<logic:notEmpty name ="neduserslist">
<table class="searchUsersTable">
		<thead>
		  <tr>
			<th>&nbsp;</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>User Name</th>
			<th>Organization</th>
		  </tr>
		</thead>
		<logic:iterate name="neduserslist" id="listUserId">
		<tr>
        <td>  <bean:define id="nihNetworkId" name="listUserId"  property="nihNetworkId" />
          <html:radio property="selectedUser" value="${nihNetworkId}"></html:radio>
          </td>
        <td> <bean:write name="listUserId" property="firstName"/></td>
        <td><bean:write name="listUserId" property="lastName"/></td>
        <td><bean:write name="listUserId" property="nihNetworkId"/></td>
        <td><bean:write name="listUserId" property="parentNedOrgPath"/></td>
        </tr>
        </logic:iterate>
</table>
<br>
<br>
<html:submit styleClass="button2a" >Assume the Selected User&apos;s View</html:submit>
</logic:notEmpty>
</html:form>

  <logic:empty name="neduserslist">
      <logic:present name="searchresults">
       <strong><bean:write name="searchresults"/></strong>
       </logic:present>
  </logic:empty> 
    </fieldset>
    </div>
</div>
    <br>
    <br>
    <%@ include file="Includes/StandardFooter.jsp"%>
    </body>
</html>