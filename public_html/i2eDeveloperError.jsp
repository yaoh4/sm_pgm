<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html>
<head>
<title>Access Denied</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="Stylesheets/PgmStyleSheet.css"
	type="text/css">
</head>
<body bgcolor="#FFFFFF" leftmargin="10" topmargin="10" marginwidth="10"
	marginheight="10">
	<!--Start Header -->
	<!--Include the header -->
	<%
		String titleImage = "<img src=\"images/TitleQueries.gif\" width=\"98\" height=\"18\" alt=\"Queries\">";
	%>
	<%@ include file="Includes/PgmHeader.jsp"%>
	<!--End Your Grants Header -->
	<!--Start Info-->


	<div style="width: 1000px; margin: 0px auto;">
		<fieldset class="loginError">
			<div>
				<b><font color="#009999">Description</font></b><br /> <br>User is not authorized to Change User.
				 <br> If you
				have any questions, please send an email to List NCI-NOW-L <a
					href="mailto:NCI-NOW-L@LIST.NIH.GOV?subject=Referral Activity/ PD Assignment Access">&lt;NCI-NOW-L&#64;LIST.NIH.GOV&gt;</a>
			</div>
		</fieldset>
	</div>
	
	<%@ include file="Includes/StandardFooter.jsp"%>
</body>
</html>