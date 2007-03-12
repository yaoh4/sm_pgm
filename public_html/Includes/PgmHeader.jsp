  <%@ page import="gov.nih.nci.iscs.oracle.util.CommonUtil" %>
  <%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants" %>
  <%@ page import="gov.nih.nci.iscs.i2e.oracle.common.userlogin.NciUser" %> 
  <%@ page import="gov.nih.nci.iscs.oracle.common.helper.ApplicationInfo" %>
  <%@ taglib  uri="/WEB-INF/taglib/ncilink.tld"  prefix="ncilink" %>
<%
  ApplicationInfo pgmApplInfo =ApplicationInfo.getInstance(ApplicationConstants.APPLICATION_KEY);
  NciUser nciuser = (NciUser) session.getAttribute(NciUser.NCI_USER);
  String applicationName = (String) session.getAttribute("applicationName");
  String subject= "";
%>

 <table width="100%" border="0" cellspacing="0" cellpadding="0" >
   <tr>
      <td width="35%">
         <% if(applicationName.equalsIgnoreCase("Referral")){ %>
             <img src="images/ReferralActivity.gif" alt="Referral Activity Logo" />
         <% subject = "mailto:nci-now-l@list.nih.gov?subject=Referral Activity";
         } %>
         <% if(applicationName.equalsIgnoreCase("PD")){ %>
             <img src="images/Logo_PDAssignment.gif" alt="PD Assignment (Non-Referral) Logo" />
         <% subject = "mailto:nci-now-l@list.nih.gov?subject=PD Assignment";
         } %>
         
      </td>
      <td width="65%">
         <table>
            <tr>
                 
                   <% if(nciuser != null ) { %>
                      <td nowrap width=10%>User: <b><%=nciuser.getAttribute("givenName") + " " +nciuser.getAttribute("lastName")%></b></td>
                   <% } else {%>  
                      <td nowrap width=10%>&nbsp;</td>
                   <%}%>
                   <td nowrap width=1%>&nbsp;</td>
                   <td nowrap width=10%>Env: <b><%=pgmApplInfo.getApplicationKey("ENVIRONMENT_INSTANCE")%></b></td>
                   <td nowrap width=1%>&nbsp;</td>
                   <td nowrap width=10%>Version: <b><%=pgmApplInfo.getApplicationKey("VERSION")%></b></td>
                   <td nowrap width=1%>&nbsp;</td>
                   <td width=10%> <a href="<%= subject %>">Send Comments</a></td>
                   <td nowrap width=1%>&nbsp;</td>
                   <td width=10%>
                   <% if(applicationName.equalsIgnoreCase("Referral")){ %>
                       <a href="#" onClick=window.open('/pgm/pgmhelp.pdf')>Help</A>
                   <% } %>
                   <% if(applicationName.equalsIgnoreCase("PD")){ %>
                       <a href="#" onClick=window.open('/pgm/PDAssignment.pdf')>Help</A>
                   <% } %>
                   </td>
               
            </tr>
         </table>
      </td>
    </tr>
 </table>
 <table width="100%" border="0" cellspacing="0" cellpadding="0" >
   <tr>
     <td  bgcolor="#3F7EFF"><img src="images/spacer.gif" alt="" width="100" height="3"></td>
  </tr>
 
</table>
 <%@include file="YGLinks.jsp"%>

