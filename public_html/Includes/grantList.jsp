<!--Start List Table -->
<logic:notEmpty name="retrieveGrantsForReferralForm" property="queryResults" >
  <table border="0" cellspacing="0" cellpadding="0" width="800" align="center">
    <tr><td width="20" align="right">&nbsp;</td>
    </tr>
    <tr><td width="20" align="right">&nbsp;</td>
    </tr>
    <tr><td width="20" align="right">&nbsp;</td>
    </tr>
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
            <th id="header00" width="3%" align=middle class=listCellHead>Sel</th>
            <th id="header01" width="17%" align=middle class=listCellHead>Grant Number</th>
            <th id="header02" width="3%" align=middle class=listCellHead>CA</th>
            <th id="header03" width="20%" align=middle class=listCellHead>Institution</th>
            <th id="header04" width="10%" align=middle class=listCellHead>PI</th>
            <th id="header05" width="30%" align=middle class=listCellHead>Title</th>
            <th id="header06" width="10%" align=middle class=listCellHead>Notes</th>
          </tr>

          <logic:iterate id="ReferralSearchResultObject" name="retrieveGrantsForReferralForm" property="queryResults">

          <tr valign="top"> 
             <td headers="header00" width="3%" class=listCell><html:checkbox name="ReferralSearchResultObject"  property="selected"/></td>
             <td headers="header01" width="17%" class=listCell><bean:write name="ReferralSearchResultObject" property="grantNumber"/></td>
             <td headers="header02" width="3%" class=listCell><bean:write name="ReferralSearchResultObject" property="cancerActivity"/></td>
             <td headers="header03" width="20%" class=listCell><bean:write name="ReferralSearchResultObject" property="instName"/></td>
             <td headers="header04" width="10%" class=listCell><bean:write name="ReferralSearchResultObject" property="piLastName"/></td>
             <td headers="header05" width="30%" class=listCell><bean:write name="ReferralSearchResultObject" property="projectTitle"/></td>
             <td headers="header06" width="10%" class=listCell5><bean:write name="ReferralSearchResultObject" property="notes"/></td>

           </tr>
          </logic:iterate>
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
</logic:notEmpty>
<!--End List Table -->

