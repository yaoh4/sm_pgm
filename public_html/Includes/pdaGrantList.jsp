<%@ page import="gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="PaginationObject" scope="session" type="gov.nih.nci.iscs.oracle.pgm.forms.PaginationObject" />
<!--Start List Table -->

<table> <tr>
  <td> &nbsp; </td>
</tr></table>
 <table border="0" cellspacing="0" cellpadding="0" width="800" align="center">
    <tr>
      <td width="20" align="right"><img src="images/CriteriaOpen.gif" width="18" height="13"></td>
      <td class="TitlePrimary">Grants</td>
      <td valign="top" width="20">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="3"><img src="images/spacer.gif" alt="" width="20" height="10"></td>
    </tr>
  </table>
    <tr><td >&nbsp;</td></tr>
        <%@include file="grantListHeader.jsp"%>
        <%@include file="pdaActionButtons.jsp"%>
        <%@include file="selectionButtons.jsp"%>

        </table>
        <logic:messagesPresent name="message" property="referralaction" message="true">
           <html:messages message="true" id="message" property="referralaction" header="referalaction.header" footer="referalaction.footer">
             <li><b><bean:write name="message"/></b></li>
           </html:messages>
        </logic:messagesPresent>
        <table border="0" cellspacing="0" cellpadding="0" width="820" align="center">

        <tr>
          <td width="20">&nbsp;</td>
          <td valign="top" colspan="5">
            <script language="JavaScript" type="text/javascript">
              // define table with border attribute for Netscape 4.7x browsers 
              if (ns4 == 1) {
                document.write('<table summary="Grants Table" border="1" cellpadding="1" cellspacing="1" width="100%">'); 
              } else {
                // otherwise no border is required
                document.write('<table summary="Grants Table" cellpadding="1" cellspacing="1" width="100%">'); 
              } 
           </script>
           <script language="JavaScript" type="text/javascript">
             // define table with border attribute for Netscape 4.7x browsers 
            if (ns4 == 1) {
              document.write('<table summary="Grants Table" border="1" cellpadding="1" cellspacing="1" width="100%">'); 
            } else {
              // otherwise no border is required
              document.write('<table summary="Grants Table" cellpadding="1" cellspacing="1" width="100%">'); 
            } 
          </script>
          
           <noscript>
             <table summary="Grants Table" cellpadding="1" cellspacing="1" width="100%">
           </noscript>	  
              <tr> 
                <ncijsp:pdaHeader />         
              </tr>
              <ncijsp:formatGrantList  formName='retrieveGrantsForPDAForm'/> </td>
             </table>
          </td>
          <td width="20">&nbsp;</td>
        </tr>
        <tr> 
          <td width="20" height="20">&nbsp;</td>
          <td nowrap align="right" colspan="5" height="20">&nbsp;</td>
          <td width="20" height="20">&nbsp;</td>
        </tr>
      </table>
 

  <%@include file="grantListHeaderLo.jsp"%>
<!--End List Table -->

