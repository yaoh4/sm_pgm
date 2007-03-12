
              <td width="20" valign="top" bgcolor="#99CCFF"><img src="images/spacer.gif" alt="" width="20" height="12"></td>
              
              <td colspan="3" valign="top" bgcolor="#99CCFF"><b><font color="#FFFFFF" size="2">Other 
                Codes/Dates/Status</font></b><br>
                <table border=0 cellpadding=0 cellspacing=0 width="350">
                  <tr> 
                    <td nowrap> 
                      <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                        <tr> 
                          <td nowrap width="33%"><b>Cancer</b></td>
                          <td nowrap ><b>NCAB</b></td>
                        </tr>
                       </table>
                    </td>
                   </tr>
                   <tr> 
                    <td nowrap> 
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
                    </td>
                   </tr>
                </table>

                <table border=0 cellpadding=0 cellspacing=0 width="350">
                  <tr> 
                    <td nowrap> 
                      <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                        <tr> 
                          <td nowrap width="27%"><label for "rfaPa"><b>RFA/PA</b></label></td>
                          <td nowrap ><b>Fiscal Year (YYYY)</b></td>
                        </tr>
                       </table>
                    </td>
                   </tr>
                   <tr> 
                    <td nowrap> 
                      <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                        <tr> 
                          <td>
                             <html:text property="rfaPa" size="10" maxlength="10"/> 
                          </td>
                          <td nowrap><label for="fyFrom"><b><bean:message key="labels.search.field.fyFrom" /></b></td>
                          <td nowrap> 
                             <html:text property="fyFrom" size="10" maxlength="10" onblur="copyFY()"/> </label>
                          </td>
                          <td nowrap><label for="fyTo"><b><bean:message key="labels.search.field.fyTo" /></b></td>
                          <td nowrap> 
                             <html:text property="fyTo" size="10" maxlength="10" onblur="copyFY()"/> </label>
                          </td>          
                        </tr>
                       </table>
                    </td>
                   </tr>
                </table>

 
 


    
 

   
    <!--End Criteria-->