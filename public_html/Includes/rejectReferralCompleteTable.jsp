<%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants" %>
<%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants" %>
<%@ page import="gov.nih.nci.iscs.oracle.pgm.service.ReferralSearchResultObject" %>
<%@ page import="gov.nih.nci.iscs.oracle.pgm.service.ReferralActionObject" %>
<%@ page import="java.util.*" %>
<!--Start List Table -->
<A NAME="grants">&nbsp;</A>
<% Map  mReferralActionObjects = (Map) session.getAttribute(ApplicationConstants.REFERRAL_ACTION_HASH);
 ArrayList referralQueryResults = (ArrayList) session.getAttribute(ApplicationConstants.REFERRAL_ACTION_LIST);
 if(referralQueryResults != null ) {
    if(referralQueryResults.size() > 0 ) { %>
    
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
                  <td headers="header00" width="17%" class=listCellHead>Grant Number</td>
                  <td headers="header01" width="3%" class=listCellHead>CA</td>
                  <td headers="header02" width="25%" class=listCellHead>PI Name</td>
                  <td headers="header03" width="25%" class=listCellHead>Institution</td>
                  <td headers="header04" width="30%" class=listCellHead>Rejection Results</td>
              </tr>
              <%
                String mKey = new String("");
                Set mReferralActionSet = mReferralActionObjects.entrySet();
                Iterator mIterator = mReferralActionSet.iterator();
                while (mIterator.hasNext()) {
                   Map.Entry mReferralActionMapEntry =  (Map.Entry) mIterator.next();
                   mKey =  (String) mReferralActionMapEntry.getKey();
                   String mCA = mKey.substring(0,2);
                   String mApplId = mKey.substring(3,mKey.length());
       
      	           ReferralActionObject actionObj = (ReferralActionObject) mReferralActionMapEntry.getValue();
      	           ReferralSearchResultObject obj = new ReferralSearchResultObject();
      	           Iterator mIterator_obj = referralQueryResults.iterator();
      	           while(mIterator_obj.hasNext()) {
      	                obj = (ReferralSearchResultObject) mIterator_obj.next(); 
      	                if(obj.getCancerActivity().equalsIgnoreCase(mCA) & 
      	                   mApplId.equalsIgnoreCase(obj.getApplId().toString())){
      	                   break;
      	                }
      	           }
      	       %>

      	          <tr> 
                        <td headers="header00" width="17%" class=listCell><%=obj.getGrantNumber() %>&nbsp;</td>
                        <td headers="header01" width="3%" class=listCell><%=obj.getCancerActivity() %>&nbsp;</td>
                        <td headers="header02" width="25%" class=listCell><%=obj.getPiLastName() %>&nbsp;</td>
                        <td headers="header03" width="25%" class=listCell><%=obj.getInstName() %>&nbsp;</td>
                        <td headers="header04" width="30%" class=listCell5>
		          <ncijsp:formatResult result="<%=actionObj.getResults() %>" />
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
  <%@include file="endAcceptReferralComplete.jsp"%>
  <table><tr> 
        <td">&nbsp;</td>
     </tr>  </table>

<% } } %>
<!--End List Table -->

