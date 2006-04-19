<jsp:useBean id="referralForm" scope="request"
     class="gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForPDAForm" />
  <logic:equal value="<%= ApplicationConstants.ACTION_COLLAPSE_CRITERIA %>" name="retrieveGrantsForPDAForm" property="requestAction">
  <%@include file="plusButton.jsp"%>

</logic:equal>
<logic:notEqual value="<%= ApplicationConstants.ACTION_COLLAPSE_CRITERIA %>" name="retrieveGrantsForPDAForm" property="requestAction">
  <%@include file="minusButton.jsp"%>

  <table border="0" cellspacing="0" cellpadding="0" width="800" align="center">
      <tr> 
        <td align="left" class="DefaultTextBold">A grant serial number (Srl #) or Program Director is required to perform a 
        search.</td>
      </tr>
      <tr> 
        <td align="left">&nbsp;</td>
      </tr>
  </table>
  <%@include file="searchCriteriaLeft.jsp"%>
  <%@include file="searchCriteriaRightforPDA.jsp"%>
  <%@include file="searchCriteriaPDA.jsp"%>
  <%@include file="endSearchCriteria.jsp"%>
</logic:notEqual>
