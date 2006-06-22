
              
              </td>
            </tr>
          </table>
        </td>
        <td width="20">&nbsp;</td>
      </tr>
      <tr> 
        <td width="20"><img src="images/spacer.gif" alt="" width="20" height="10"></td>
        <td><img src="images/spacer.gif" width="20" height="10"></td>
        <td width="20"><img src="images/spacer.gif" alt="" width="20" height="10"></td>
      </tr>
    </table>
    <!--Start Search/Clear Buttons-->
      <table border="0" cellspacing="0" cellpadding="0" width="800" align="left">
        <tr> 
                <logic:notEqual name="pdAssignmentForm" property="requestAction" value="<%= ApplicationConstants.ASSIGN_PORTFOLIO%>">
                   <td width="88%" align="right">
                     <input class="button2a" type="button" value="Assign"  onclick="setAssignmentAction('executeAssignment');"/></td>
                  <td>&nbsp;</td>
                  <td align="left">
                     <input class="button2a" type="button" value="Cancel"  onclick="setCurrentReferralAction('cancel');"/></td>              
	        </logic:notEqual> 
                <logic:equal name="pdAssignmentForm" property="requestAction" value="<%= ApplicationConstants.ASSIGN_PORTFOLIO%>">
                  <td align="right" width="75%">
                     <input class="button2a" type="button" value="Cancel"  onclick="setCurrentReferralAction('cancel');"/></td>              
                  <td align="right" width="25%"> &nbsp; </td>
	        </logic:equal> 
       </tr>
  </table>
    <!--End Criteria-->