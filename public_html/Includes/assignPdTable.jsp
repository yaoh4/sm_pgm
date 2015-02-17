<%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants" %>
<%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants" %>
<%@ page import="gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject" %>
<%@ page import="java.util.*" %>
<!--Start List Table -->
<A NAME="grants">&nbsp;</A>
     
        <logic:messagesPresent name="message" property="executereferralaction" message="true">
           <html:messages message="true" id="message" property="executereferralaction" header="executereferralaction.header" footer="executereferralaction.footer">
             <li><b><bean:write name="message"/></b></li>
           </html:messages>
        </logic:messagesPresent>

        <table cellpadding="1" cellspacing="1" width="100%">
              <logic:equal name="pdAssignmentForm" property="requestAction" value="<%= ApplicationConstants.ASSIGN_PORTFOLIO%>">
                   <tr>
                     <td colspan="2" align="left" class="DefaultTextBold"> New Program Director </td>
                  </tr>
              </logic:equal>
              <tr>
                <td width="55%" align="left">
                  <ncijsp:formatPDAssignmentList action='<%= ApplicationConstants.FORMAT_SELECT %>'/> 
                </td>
                <logic:notEqual name="pdAssignmentForm" property="requestAction" value="<%= ApplicationConstants.ASSIGN_PORTFOLIO%>">
                   <td align="left" width="45%"><input class="button2a" type="button" value="Apply To Selected Grants"  onclick="setAssignmentAction('<%= ApplicationConstants.LOAD_ASSIGNMENTS %>');"/></td>
                </logic:notEqual>
                <logic:equal name="pdAssignmentForm" property="requestAction" value="<%= ApplicationConstants.ASSIGN_PORTFOLIO%>">
                    <td align="left" width="30%"><input class="button2a" type="button" value="Assign To All Grants"  onclick="setAssignmentAction('<%= ApplicationConstants.EXECUTE_PORTFOLIO_ASSIGNMENT %>');"/></td>
                </logic:equal>
	    <tr>
	    <tr><td colspan="2">&nbsp;</td></tr>
         </table>

          <table border="0" cellspacing="1" cellpadding="1" width="800" >       
            <tr>
                <logic:equal name="pdAssignmentForm" property="requestAction" value="<%= ApplicationConstants.ASSIGN_PORTFOLIO %>">
                  <td colspan="2" align="left" class="ErrorTextBoldItalics"> All <bean:write name="pdAssignmentForm" property="count" /> grants will be assigned to the New Program Director </td></tr>
	        </logic:equal>
                <logic:notEqual name="pdAssignmentForm" property="requestAction" value="<%= ApplicationConstants.ASSIGN_PORTFOLIO%>">
                  <td align="left" width="15%">
               		<a link href="#" onclick="checkAllBoxes();"> Check All Boxes</a>&nbsp;
           		</td>
          		 <td width="15%" align="left" >
               		<a link href="#" onclick="clearAllBoxes();"> Clear All Boxes</a>&nbsp;
           		</td>
                  <td width="59%">&nbsp;</td>
                </tr>
                   <tr>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td align="right">
                     <input class="button2a" type="button" value="Assign"  onclick="setAssignmentAction('executeAssignment');"/></td>
                  <td>&nbsp;</td>
                  <td width="15%"align="left">
                     <input class="button2a" type="button" value="Cancel"  onclick="setCurrentReferralAction('cancel');"/></td>
                  </tr>                  
	        </logic:notEqual>
          </table>
          
      <table summary="Grants Table" cellpadding="1" cellspacing="1" width="800">
              <tr> 
                 <ncijsp:assignPDTableHeader />  
             </tr>
              <ncijsp:formatPDAssignmentList action='<%= ApplicationConstants.FORMAT_TABLE %>'/> </td>
      </table>
  
  <%@include file="endAssignPD.jsp"%>

<!--End List Table -->

