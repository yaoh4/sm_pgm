                      <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                        <tr> 
                          <td nowrap ><label for="cancerActivity"><b>Activity:</label></b></td>
                          <td>
                             <html:select property="cancerActivity"  >
			          <html:options collection="<%= LookUpTableConstants.CANCER_ACTIVITIES_T_LOOKUP[0] %>" property="value"  labelProperty="value" />
			     </html:select>
                          </td>
                          <td nowrap ><label for="ncabFromDate"><b>From:</label></b></td>
                          <td nowrap> 
                             <html:select property="ncabFromDate"  onblur="copyNcab()">
			          <html:options collection="<%= LookUpTableConstants.BOARDS_T_LOOKUP[0] %>" property="value"  labelProperty="label" />
			     </html:select>
                          </td>
                          <td nowrap><label for="ncabToDate"><b>To:</b></label></td>
                          <td nowrap> 
                             <html:select property="ncabToDate"  onblur="copyNcab()">
			          <html:options collection="<%= LookUpTableConstants.BOARDS_T_LOOKUP[0] %>" property="value"  labelProperty="label" />
			     </html:select>
                          </td>
                         </tr>
                       </table>