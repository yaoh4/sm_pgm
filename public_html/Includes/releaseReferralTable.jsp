<%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants" %>
<%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants" %>
<%@ page import="gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject" %>
<%@ page import="java.util.*" %>
<!--Start List Table -->
<A NAME="grants">&nbsp;</A>
<% ArrayList referralQueryResults = (ArrayList) session.getAttribute(ApplicationConstants.REFERRAL_ACTION_LIST);
 if(referralQueryResults != null ) {
    if(referralQueryResults.size() > 0 ) { %>
     
        <logic:messagesPresent name="message" property="executereferralaction" message="true">
           <html:messages message="true" id="message" property="executereferralaction" header="executereferralaction.header" footer="executereferralaction.footer">
             <li><b><bean:write name="message"/></b></li>
           </html:messages>
        </logic:messagesPresent>
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
                  <ncijsp:releaseReferralHeader />
              </tr>
                <%Iterator mIterator = referralQueryResults.iterator();
                 int index = 0;
                 String grantsUrl = (String) session.getAttribute("GRANTS_DETAILS_URL");
      	         while (mIterator.hasNext() ) { 
      	         ReferralSearchResultObject obj = (ReferralSearchResultObject) mIterator.next(); %>
      	          <tr> 
                        <td headers="header00" width="17%" class=listCell><a href="javascript:openYourGrantsWindow('<%=obj.getApplId() %>', '<%=grantsUrl %>');"><%=obj.getGrantNumber() %>&nbsp;</a></td>
                        <td headers="header01" width="21%" class=listCell><%=obj.getInstName() %>&nbsp;</td>
                        <td headers="header02" width="21%" class=listCell><%=obj.getPiLastName() %>&nbsp;</td>
                        <td headers="header03" width="10%" class=listCell><%=obj.getCancerActivity() %>&nbsp;</td>
                        <td headers="header04" width="10%" class=listCell><%=obj.getDualCA() %>&nbsp;</td>
                        <td headers="header05" width="21%" class=listCell5><%=obj.getDualPoc() %>&nbsp;</td>
                       
                     </tr>
                      
                <% index=index + 1;
                } %>	      
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
  <%@include file="endReleaseReferral.jsp"%>
  <table><tr> 
        <td">&nbsp;</td>
     </tr>  </table>

<% } } %>
<!--End List Table -->

