<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <%@ page contentType="text/html;charset=UTF-8"%>
  <%@ taglib  uri="/WEB-INF/taglib/NCITaglib.tld"  prefix="ncijsp" %>
  <%@ include file="Includes/PgmGlobalInclude.jsp"%>
  <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
  <%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
  <%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> 
  <%@ page import="org.apache.struts.action.ActionMessage" %> 
  <%@ page import="org.apache.struts.action.ActionMessages" %>


<html>
<head>
    <title>Program Director / Cancer Activities</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="Stylesheets/PgmStyleSheet.css" type="text/css">
     <SCRIPT language="Javascript" src="pgm.js" type="text/javascript">
     </SCRIPT>

</head>
<body >


<form >
<ncijsp:ProgramDirCA />

</form>
</body>

</html>