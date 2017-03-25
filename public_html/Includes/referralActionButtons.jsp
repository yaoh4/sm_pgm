<!--Start referral action buttons -->
        <table  width="1000" align="center">
          <tr>
             <td nowrap width="10%">&nbsp;</td>
             <td nowrap align="right" width="15%"><b>Selected Grants:</b></td>
             <td width="8%"><INPUT type="button" class="button2a" value="Accept" onclick="setReferralAction('<%=ApplicationConstants.ACCEPT_REFERRAL %>');"/> 
             </td>
	     <td width="8%"><INPUT type="button" class="button2a" value="Reject" onclick="setReferralAction('<%=ApplicationConstants.REJECT_REFERRAL %>');"/>
             </td>
	     <td width="10%"><INPUT type="button"  class="button2a" value="Refer to Other Program" onclick="setReferralAction('<%=ApplicationConstants.REREFER_REFERRAL %>');"/>
             </td>
	     <td width="8%"><INPUT type="button" class="button2a" value="Release Dual" onclick="setReferralAction('<%=ApplicationConstants.RELEASE_DUAL_REFERRAL %>');"/>
             <td nowrap width="8%">&nbsp;</td>
             <td align="right"><INPUT type="button" class="button2a" value="Generate" onclick="setReferralAction('generateReport');"/>
             </td>
          </tr>

        </table>
<!--End referral action buttons -->
