<%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants" %>
<%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants" %>
<%@ page import="gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject" %>
<%@ page import="java.util.*" %>
<!--Start List Table -->
<A NAME="grants">&nbsp;</A>
<% ArrayList referralQueryResults = (ArrayList) session.getAttribute(ApplicationConstants.REFERRAL_ACTION_LIST);
 if(referralQueryResults != null ) {
    if(referralQueryResults.size() > 0 ) { %>
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
    
     
        <logic:messagesPresent name="message" property="executereferralaction" message="true">
           <html:messages message="true" id="message" property="executereferralaction" header="executereferralaction.header" footer="executereferralaction.footer">
             <li><b><bean:write name="message"/></b></li>
           </html:messages>
        </logic:messagesPresent>

        <tr>
           <td> 
              <table summary="Grants Table" cellpadding="1" cellspacing="1" width="950" >
                <tr> 
                  
                  <ncijsp:acceptReferralCA />
                </tr> 
                <tr> 
                 
                  <td align="left"><B>Assign To:</B></td>
                </tr> 
                <tr> 
                  
                  <td align="left">
                           <ncijsp:applyToAll />
                  
                </tr> 
              </table>           
            </td>
         </tr> 
         <tr> 
	        <td width="20"><img src="images/spacer.gif" alt="" width="20" height="10"></td>
	        <td><img src="images/spacer.gif" width="20" height="10"></td>
	        <td width="20"><img src="images/spacer.gif" alt="" width="20" height="10"></td>
     	 </tr>
         <tr>
        <!--Start Search/Clear Buttons-->
	      <table border="0" cellspacing="0" cellpadding="0" width="800" >
	        <tr> 
	          <td width="730" align="right">
	               <input class="button2a" type="button" value="Accept"  onclick="setCurrentReferralAction('executeAccept');"/></td>
		  </td> 
	          <td nowrap width="5">&nbsp;</td>
	         <td align="left">
	               <input class="button2a" type="button" value="Cancel"  onclick="setCurrentReferralAction('cancel');"/></td>
	         </td>               
	        </tr>
  </table>
  </tr>
         <tr>
          <table border="0" cellspacing="0" cellpadding="0" width="800" >
            <tr><td width="7%" align="right">&nbsp;</td>
            </tr>         
            <tr>
           
             <%@include file="actionSelectionButtons.jsp"%>
             <td width="25%">&nbsp;</td>
            
           </tr>
          </table>
        </tr>
    
         <tr>
           <td>
            <table border="0" cellspacing="0" cellpadding="0" width="800" >
               <tr>
                    <ncijsp:acceptReferralHeader />
                    <td headers="header05" width="27%" class=listCellHead>Assign To</td>
                </tr>
                  <%Iterator mIterator = referralQueryResults.iterator();
                   int index = 0;
                   String grantsUrl = (String) session.getAttribute("GRANTS_DETAILS_URL");
      	           while (mIterator.hasNext() ) { 
      	           ReferralSearchResultObject obj = (ReferralSearchResultObject) mIterator.next(); %>
      	        <tr> 
                           <ncijsp:AcceptReferral action='selection' indx='<%= index %>' cancerActivity= '<%= obj.getCancerActivity().toUpperCase()%>' applId= '<%= obj.getApplId() %>' selected= '<%= obj.getSelected() %>'/> 
                        
                        <td headers="header01" width="20%" class=listCell><a href="javascript:openYourGrantsWindow('<%=obj.getApplId() %>', '<%=grantsUrl %>');"><%=obj.getGrantNumber() %>&nbsp;</a></td>
                        <td headers="header02" width="6%" class=listCell><%=obj.getCancerActivity() %>&nbsp;</td>
                        <td headers="header03" width="23%" class=listCell><%=obj.getPiLastName() %>&nbsp;</td>
                        <td headers="header04" width="24%" class=listCell><%=obj.getInstName() %>&nbsp;</td>
                        <td headers="header05"  width="27%" class=listCell5>
                           <ncijsp:AcceptReferral action='dropdown' indx='<%= index %>' cancerActivity= '<%= obj.getCancerActivity().toUpperCase() %>' applId= '<%= obj.getApplId() %>'/> 
                        </td>
                 </tr>
                      
                   <% obj.setSelected(false);
                     index=index + 1;
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
  <%@include file="endAcceptReferral.jsp"%>
  <table><tr> 
        <td">&nbsp;</td>
          
     </tr>  </table>

<% } } %>
<!--End List Table -->

