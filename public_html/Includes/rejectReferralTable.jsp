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
              <table summary="Grants Table" cellpadding="1" cellspacing="1" width="800" >
                <tr> 
                  
                  <td colspan="2" align="left"><B> Select a Rejection Comment from the list below or select &#39;Other&#39; to enter a different Rejection Comment</B>
	          </td>         
                </tr> 
                <tr> 
                  
                  <td width="40%" align="left">
                        <ncijsp:RejectReferral action='formatcomments'/>  
                        <% Boolean disbaleComments = (Boolean) request.getAttribute("DisbaleComments");
                           if(disbaleComments.booleanValue()){ %>
			      <html:textarea property="commentsToApply" disabled="true" cols="50" rows="3"/>
			   <%}else { %>   
			      <html:textarea property="commentsToApply"  cols="50" rows="3"/>
			   <%}
			%>
                  </td>
                  <td width="40%" align="left">
                        <input class="button2a" type="button" value="Apply To Selected Grants" onclick="applyForReject();">
	          </td>
         
                </tr> 
              </table>           
            </td>
         </tr> 

         <tr>
          <table border="0" cellspacing="0" cellpadding="0" width="800" >
            <tr><td width="6%" align="right">&nbsp;</td>
            </tr>       
            <tr> 
             
              <td width="50%" colspan="2"> <b>Comments are required to reject a referral </b> </td>
           
              </td>
              <td width="15%">&nbsp;</td>
            </tr>
            <tr>
	            <td>&nbsp;</td>	          
            </tr>
            <tr>
              <td width="6%">&nbsp;</td>
              <%@include file="actionSelectionButtons.jsp"%>
              <td width="15%">&nbsp;</td>
            </tr>
            </table>
          </tr>
  <table border="0" cellspacing="0" cellpadding="0" width="800" align="left">

        <tr>
          
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
                  <ncijsp:rejectReferralHeader />
                  <td headers="header05" width="30%" class=listCellHead>Rejection Comments</td>
              </tr>
                <%Iterator mIterator = referralQueryResults.iterator();
                 int index = 0;
                 String grantsUrl = (String) session.getAttribute("GRANTS_DETAILS_URL");
                 String className = "listCell";
                 String borderClassName = "listCell5";
                 
      	         while (mIterator.hasNext() ) { 
      	         ReferralSearchResultObject obj = (ReferralSearchResultObject) mIterator.next(); 
      	         if (obj.getMarked() )  {
      	             className = "listCellError";
      	             borderClassName = "listCell5Error";
      	         }else{
      	             className = "listCell";
      	             borderClassName = "listCellError";
      	         }
  	         
      	         %>
      	          <tr> 
                        <ncijsp:RejectReferral indx='<%= index %>' action='selection' cancerActivity= '<%= obj.getCancerActivity().toUpperCase()%>' applId= '<%= obj.getApplId() %>' selected= '<%= obj.getSelected() %>'/> 
                        <td headers="header01" width="17%" class='<%= className %>' ><a href="javascript:openYourGrantsWindow('<%=obj.getApplId() %>', '<%=grantsUrl %>');"><%=obj.getGrantNumber() %>&nbsp;</a></td>
                        <td headers="header02" width="6%" class='<%= className %>'><%=obj.getCancerActivity() %>&nbsp;</td>
                        <td headers="header03" width="23%" class='<%= className %>'><%=obj.getPiLastName() %>&nbsp;</td>
                        <td headers="header04" width="24%" class='<%= className %>'><%=obj.getInstName() %>&nbsp;</td>
                        <td headers="header05" width="30%" class='<%= borderClassName %>'>
                           <ncijsp:RejectReferral indx='<%= index %>' action='comments' cancerActivity= '<%= obj.getCancerActivity().toUpperCase()%>' applId= '<%= obj.getApplId() %>' selected= '<%= obj.getSelected() %>'/>  
                         </td>
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

  <%@include file="endRejectReferral.jsp"%>
  <table><tr> 
        <td">&nbsp;</td>
     </tr>  </table>
          

<% } } %>
<!--End List Table -->

