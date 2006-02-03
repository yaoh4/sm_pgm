<%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants" %>
<%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants" %>
<%@ page import="gov.nih.nci.iscs.oracle.pgm.service.PDASearchResultObject" %>
<%@ page import="gov.nih.nci.iscs.oracle.pgm.service.PdAssignmentActionObject" %>
<%@ page import="java.util.*" %>
<!--Start List Table -->
<A NAME="grants">&nbsp;</A>
<% Map  mPdAssignmentActionObjects = (Map) session.getAttribute(ApplicationConstants.ASSIGNMENT_ACTION_HASH);
 ArrayList pdAssignmentQueryResults = (ArrayList) session.getAttribute(ApplicationConstants.PD_ASSIGNMENT_LIST);
 if(pdAssignmentQueryResults != null ) {
    if(pdAssignmentQueryResults.size() > 0 ) { %>
    <tr><td width="20" align="right">&nbsp;</td>
        </tr>
        <tr><td width="20" align="right">&nbsp;</td>
        </tr>
     
        <logic:messagesPresent name="message" property="executereferralaction" message="true">
           <html:messages message="true" id="message" property="executereferralaction" header="acceptaction.header" footer="acceptaction.footer">
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
                  <td headers="header00" width="20%" class=listCellHead>Grant Number</td>
                  <td headers="header01" width="20%" class=listCellHead>PD</td>
                  <td headers="header02" width="5%" class=listCellHead>CA</td>
                  <td headers="header03" width="10%" class=listCellHead>Start Date</td>
                  <td headers="header04" width="30%" class=listCellHead>Assignment Results</td>
              </tr>
              <%
                Integer index = new Integer("0");
                Set mPdAssignmentActionSet = mPdAssignmentActionObjects.entrySet();
                Iterator mIterator = mPdAssignmentActionSet.iterator();
                while (mIterator.hasNext()) {
                   Map.Entry mPdAssignmentActionMapEntry =  (Map.Entry) mIterator.next();
      	           PdAssignmentActionObject actionObj = (PdAssignmentActionObject) mPdAssignmentActionMapEntry.getValue();
      	           PDASearchResultObject obj = (PDASearchResultObject) pdAssignmentQueryResults.get(index.intValue()); 
      	       %>

      	          <tr> 
                        <td headers="header00" width="20%" class=listCell><%=actionObj.getGrantNumber() %>&nbsp;</td>
                        <td headers="header01" width="20%" class=listCell><%=actionObj.getProgramDirector() %>&nbsp;</td>
                        <td headers="header02" width="5%" class=listCell><%=actionObj.getCancerActivity() %>&nbsp;</td>
                        <td headers="header03" width="10%" class=listCell><%=actionObj.getAssignmentDate() %>&nbsp;</td>
                        <td headers="header04" width="30%" class=listCell5>
		          <ncijsp:formatResult result="<%=actionObj.getResults() %>" />&nbsp;
                         </td>
                     </tr>                      
                <% } %>	      
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
  <%@include file="endAssignPDComplete.jsp"%>

<% } } %>
<!--End List Table -->

