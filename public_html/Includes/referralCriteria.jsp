<jsp:useBean id="referralForm" scope="request"
     class="gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForReferralForm" />
  <logic:equal value="<%= ApplicationConstants.ACTION_COLLAPSE_CRITERIA %>" name="retrieveGrantsForReferralForm" property="requestAction">
   <table border="0" cellspacing="0" cellpadding="0" width="800" align="center">
    <tr> 
      <td colspan="2" align="left" background="images/HeadingBG2.gif"><img src="images/HeadingCriteriaClosed.gif" width="99" height="13" border="0" name="ToggleImage" alt="Show/Hide Criteria" onclick="javascript:LoseIt('expand');"></a></td>
      <td valign="top" width="20">&nbsp;</td>
    </tr>
    <tr> 
      <td width="20"><img src="images/spacer.gif" alt="" width="20" height="10"></td>
      <td><img src="images/spacer.gif" width="20" height="10"></td>
      <td width="20"><img src="images/spacer.gif" alt="" width="20" height="10"></td>
    </tr>
  </table></table> 
</logic:equal>
<logic:notEqual value="<%= ApplicationConstants.ACTION_COLLAPSE_CRITERIA %>" name="retrieveGrantsForReferralForm" property="requestAction">
  <table border="0" cellspacing="0" cellpadding="0" width="800" align="center">
    <tr> 
      <td colspan="2" align="left" background="images/HeadingBG2.gif"><img src="images/HeadingCriteriaOpen.gif"  width="99" height="13" border="0" name="ToggleImage" alt="Show/Hide Criteria" onclick="javascript:LoseIt('collapse');"></a></td>
      <td valign="top" width="20">&nbsp;</td>
    </tr>
    <tr> 
      <td width="20"><img src="images/spacer.gif" alt="" width="20" height="10"></td>
      <td><img src="images/spacer.gif" width="20" height="10"></td>
      <td width="20"><img src="images/spacer.gif" alt="" width="20" height="10"></td>
    </tr>
  </table></table>
  <table border="0" cellspacing="0" cellpadding="0" width="800" align="center">
    <tr> 
      <td align="left">A NCAB date range is required to perform a 
      search.</td>
    </tr>
    <tr> 
      <td align="left">&nbsp;</td>
    </tr>
    
  </table>  <%@include file="searchCriteriaLeft.jsp"%>
  <%@include file="searchCriteriaRightforReferral.jsp"%>
  <%@include file="searchCriteriaReferral.jsp"%>
  <%@include file="endSearchCriteria.jsp"%>
</logic:notEqual>