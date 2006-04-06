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
        <tr>
           <td> 
              <table summary="Grants Table" cellpadding="1" cellspacing="1" width="800">
                <tr> 
                  <td width="13%"> &nbsp;</td>
                  <td width="32%" align="left"><B> Refer to Comments</B>
	          </td>
                  <td width="12%" align="left" 	><B> Refer to CA</B>
	          </td>
         
                </tr> 

                <tr> 
                  <td width="13%"> &nbsp;</td>
                  <td width="32%" align="left" valign="top">
			<html:textarea property="commentsToApply" cols="50" rows="3"/>
	          </td>
                  <td width="12%" align="center" valign="top">
                        <ncijsp:RereferReferral indx='0' action='caForApply'  /> 
	          </td>
                  <td width="20%" align="left" valign="top">
	               <input class="button2a" type="button" value="Apply To Selected Grants" onclick="applyForReject();">
	          </td>
         
                </tr> 
              </table>      
              </table>           
            </td>
         </tr> 


         <tr>
          <table border="0" cellspacing="0" cellpadding="0" width="800" >
           <tr><td width="7%" align="right">&nbsp;</td>
           </tr>         
           <tr>
             <td width="8%">&nbsp;</td>
             <%@include file="actionSelectionButtons.jsp"%>
             <td width="25%">&nbsp;</td>
            
          </tr>
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
                  <ncijsp:rereferReferralHeader />
                  <td headers="header06" width="4%" class=listCellHead>Refer to CA</td>
                  <td headers="header07" width="20%" class=listCellHead>Comments</td>
              </tr>
               <%
                  int index = 0;
       	         String className;
                 String grantsUrl = (String) session.getAttribute("GRANTS_DETAILS_URL");
       	         Iterator mIterator = referralQueryResults.iterator();
       	         while (mIterator.hasNext() ) { 
       	         ReferralSearchResultObject obj = (ReferralSearchResultObject) mIterator.next(); 
       	         if(obj.getMarked() ) {
       	           className= "listCellError";
       	         }else {
       	           className = "listCell";
      	         }%>
      	          <tr> 
                        <ncijsp:RereferReferral indx='<%= index %>' action='selection' cancerActivity= '<%= obj.getCancerActivity().toUpperCase()%>' applId= '<%= obj.getApplId() %>' selected= '<%= obj.getSelected() %>'/> 
                        <td headers="header01" width="20%" class='<%= className %>'><a href="javascript:openYourGrantsWindow('<%=obj.getApplId() %>', '<%=grantsUrl %>');"><%=obj.getGrantNumber() %>&nbsp;</a></td>
                        <td headers="header02" width="6%" class='<%= className %>'><%=obj.getCancerActivity() %>&nbsp;</td>
                        <td headers="header03" width="18%" class='<%= className %>'><%=obj.getPiLastName() %>&nbsp;</td>
                        <td headers="header04" width="18%" class='<%= className %>'><%=obj.getInstName() %>&nbsp;</td>
                        <td headers="header05" width="18%" class='<%= className %>'><%=obj.getCurrentPoc() %>&nbsp;</td>
                        <ncijsp:RereferReferral indx='<%= index %>' action='comments' cancerActivity= '<%= obj.getCancerActivity().toUpperCase()%>' applId= '<%= obj.getApplId() %>' selected= '<%= obj.getSelected() %>'/>  
                     </tr>
                      
                <% index=index + 1;
                obj.setMarked(false);
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
  <%@include file="endRereferReferral.jsp"%>
  <table><tr> 
        <td">&nbsp;</td>
     </tr>  </table>
  <table><tr> 
        <td">&nbsp;</td>
     </tr>  </table>

<% } } %>
<!--End List Table -->

