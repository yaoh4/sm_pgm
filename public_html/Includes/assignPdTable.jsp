<%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants" %>
<%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants" %>
<%@ page import="gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject" %>
<%@ page import="java.util.*" %>
<!--Start List Table -->
<A NAME="grants">&nbsp;</A>
   <tr><td width="20" align="right">&nbsp;</td>
        </tr>
        <tr><td width="20" align="right">&nbsp;</td>
        </tr>
     
        <logic:messagesPresent name="message" property="executereferralaction" message="true">
           <html:messages message="true" id="message" property="executereferralaction" header="executereferralaction.header" footer="executereferralaction.footer">
             <li><b><bean:write name="message"/></b></li>
           </html:messages>
        </logic:messagesPresent>

        <table cellpadding="1" cellspacing="1" width="100%">
            <tr> 
              <td width="70%" align="right">
                <ncijsp:formatPDAssignmentList action='<%= ApplicationConstants.FORMAT_SELECT %>'/> 
              </td>
              <td align="left" width="30%"><input class="button2a" type="button" value="Apply To Selected Grants"  onclick="setAssignmentAction('<%= ApplicationConstants.LOAD_ASSIGNMENTS %>');"/></td>
	    </tr>

	    <tr><td colspan="2">&nbsp;</td></tr>
         </table>

          <table border="0" cellspacing="0" cellpadding="0" width="800" >
            <tr><td width="7%" align="right">&nbsp;</td>
            </tr>         
            <tr>
             <td width="8%">&nbsp;</td>
             <%@include file="actionSelectionButtons.jsp"%>
             <td width="25%">&nbsp;</td>
            
           </tr>
          </table>
        <table border="0" cellspacing="0" cellpadding="0" width="800" align="center">

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
     
          
           <noscript>
             
             <table summary="Grants Table" cellpadding="1" cellspacing="1" width="100%">
           </noscript>	  
              <tr> 
                 <ncijsp:assignPDTableHeader />  
             </tr>
              <ncijsp:formatPDAssignmentList action='<%= ApplicationConstants.FORMAT_TABLE %>'/> </td>
      </table>
  
  <%@include file="endAssignPD.jsp"%>

<!--End List Table -->

