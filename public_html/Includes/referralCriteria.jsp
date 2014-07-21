<jsp:useBean id="referralForm" scope="request"
     class="gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForReferralForm" />
  <logic:equal value="<%= ApplicationConstants.ACTION_COLLAPSE_CRITERIA %>" name="retrieveGrantsForReferralForm" property="requestAction">
  <%@include file="plusButton.jsp"%>
</table> 
</logic:equal>
<logic:notEqual value="<%= ApplicationConstants.ACTION_COLLAPSE_CRITERIA %>" name="retrieveGrantsForReferralForm" property="requestAction">
  <%@include file="minusButton.jsp"%>
</table>
  <table border="0" cellspacing="0" cellpadding="0" width="800" align="center">
    <tr> 
      <td align="left" class="DefaultTextBold">A NCAB date range is required to perform a 
      search.</td>
    </tr>
    <tr> 
      <td align="left">&nbsp;</td>
    </tr>
    
  </table>  
  
  <%@include file="searchCriteriaLeft.jsp"%>
  <%@include file="searchCriteriaRightforReferral.jsp"%>
  <%@include file="searchCriteriaReferral.jsp"%>
  <%@include file="endSearchCriteria.jsp"%>
</logic:notEqual>