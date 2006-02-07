  <%@ page import="gov.nih.nci.iscs.oracle.util.CommonUtil" %>
  <%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants" %>
  <%@ page import="gov.nih.nci.iscs.oracle.login.constants.LoginConstants" %>
  <%@ page import="gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser" %>
  <%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants" %>  
  <%@ page import="gov.nih.nci.iscs.oracle.common.helper.ApplicationInfo" %>
  <%@ taglib  uri="/WEB-INF/taglib/ncilink.tld"  prefix="ncilink" %>
<%
  ApplicationInfo pgmApplInfo =ApplicationInfo.getInstance(ApplicationConstants.APPLICATION_KEY);
  NciUser nciuser = (NciUser) session.getAttribute(NciUser.NCI_USER);
%>

<table cellspacing="0" >
   <tr>
      <td width="35%">
	 <img src="images/ReferralActivity.gif" alt="Referral Activity Logo" />
      </td>
      <td width="65%">
         <table>
            <tr>
                 <% if (nciuser != null) { %>
                   <td nowrap>User: <b><%=nciuser.getFullName()%></b></td>
                   <td nowrap >&nbsp;</td>
                   <td nowrap>Env: <b><%=pgmApplInfo.getApplicationKey("ENVIRONMENT_INSTANCE")%></b></td>
                   <td nowrap >&nbsp;</td>
                   <td nowrap >Version: <b><%=pgmApplInfo.getApplicationKey("VERSION")%></b></td>
                   <td nowrap >&nbsp;</td>
                   <td> <a href="mailto:nci-now-l@list.nih.gov?subject=Referral Activity">Send Comments</a></td>
                   <td nowrap >&nbsp;</td>
                   <td><a href="#" onClick=window.open('/pgm/pgmhelp.pdf')>Help</A></td>
                <% } %> 
            </tr>
         </table>
      </td>
    </tr>
 </table>
 <table width="100%" border="0" cellspacing="0" cellpadding="0" >
   <tr>
     <td  bgcolor="#3F7EFF"><img src="images/spacer.gif" width="100" height="3"></td>
  </tr>
 
</table>
 <%@include file="YGLinks.jsp"%>

