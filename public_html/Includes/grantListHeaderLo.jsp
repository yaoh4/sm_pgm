   <table class="DefaultText" border="0" align="center" cellspacing="0" cellpadding="0" width="1000" align="center" bgcolor="#99CCFF">
      <tr>
        <td width="75%">
            <table  cellspacing="0">
                   <tr>
                      <td nowrap width="12">&nbsp;</td>
                      <td class="DefaultText" nowrap align="right"><b>Results Shown:</b></td>
                      <logic:equal name= "PaginationObject" property= "indexOfLastGrant" value = "0">
                          <td class="DefaultText">&nbsp; No records for this criteria!! </td>
                      </logic:equal>  
                      <logic:notEqual name= "PaginationObject" property= "indexOfLastGrant" value = "0">
                          <td class="DefaultText">&nbsp;<bean:write name="PaginationObject" property="indexOfFirstGrant" /> &nbsp; to <bean:write name="PaginationObject" property="indexOfLastGrant"/> &nbsp; of <bean:write name="PaginationObject" property="totalResultsCount"/> </td>
                      </logic:notEqual>
                   </tr>
                   <tr>
                      <td nowrap width="12">&nbsp;</td>
                      <td class="DefaultText" nowrap align="right"><b>View Results Page:</b></td>
                      <logic:equal name= "PaginationObject" property= "indexOfLastGrant" value = "0">
                          <td class="DefaultText">&nbsp; first < prev next > last </td>
                      </logic:equal>  
                      <logic:notEqual name= "PaginationObject" property= "indexOfLastGrant" value = "0">
                          <td class="DefaultText"><ncijsp:pagination /></td>
                      </logic:notEqual>
                   </tr>
                   <tr>
                      <td nowrap width="12">&nbsp;</td>
                      <td class="DefaultText" nowrap align="right"><b>Current Sort:</b></td>
                      <td class="DefaultText">&nbsp;<ncijsp:formatSortCriteria/> </td>
                   <tr>
           </TABLE>
        </td>
        <td width="25%" >
            <table  cellspacing="0">
                   <tr>
                      <td class="DefaultText" nowrap><b>Report:</b></td>
                      <td class="DefaultText"><ncijsp:reportSelector  applicationName='Pgm Management'  action='reports' controlName='reportSelectedLo'/> </td>
                   </tr>
                   <tr>
                      
                      <td class="DefaultText" nowrap><b>Format:</b></td>
                      <td class="DefaultText" ><ncijsp:reportSelector  applicationName='Pgm Management' action='formats' controlName='formatSelectedLo'/> </td>
                   </tr>
           </table>
        </td>
      </tr>
  </table>
