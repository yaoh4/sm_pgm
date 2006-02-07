

     
                 <table border=0 cellpadding=0 cellspacing=0 width="350">
                    <tr>
                         <td nowrap>
                           <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                             <tr>
                               <td nowrap width="54%"><b>Percentile</b></td>
                               <td nowrap width="46%"><b>Priority Score</b></td>
                             </tr>
                            </table>
                         </td>
                        </tr>
                        <tr>
                         <td nowrap>
                           <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                             <tr>
                               <td nowrap width="54%"><label for="percentileFrom"><b>From:</label></b>
                                  <html:text property="percentileFrom" size="5"/>
                               &nbsp;<label for="percentileTo"><b>To:</b></label>
                                 <html:text property="percentileTo" size="5"/>
                               </td>
                               <td nowrap width="46%"><label for="priorityScoreFrom"><b>From:</b></label>
                                   <html:text property="priorityScoreFrom" size="3"/>
                               &nbsp;<label for="priorityScoreTo"><b>To:</b></label>
                                <html:text property="priorityScoreTo" size="3"/></td>
                             </tr>
                            </table>
                           </td>
                        </tr>
                     </table>
                <table border=0 cellpadding=0 cellspacing=0 width="400">
                  <tr>
                      <td nowrap>
                           <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                             <tr>
                               <td nowrap width="23%"><b>IRG</b></td>
                               <td nowrap width="21%"><b>IRG Flex</b></td>
                               <td nowrap width="56%"><b>I2 Status:</b></td>
                             </tr>
                           </table>
                       </td>
                   </tr> 
                        <tr>
                         <td nowrap>
                           <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                             <tr>
                               <td nowrap width="23%"><label for="irgCode"><b>Code:</label></b>
                                 <html:text property="irgCode" size="4"/>
                               </td>
                               <td nowrap width="21%"><label for="irgFlexCode"><b>Code</b></label>
                                 <html:text property="irgFlexCode" size="1"/>
                               </td>
                               <td nowrap width="56%">
                                  <html:select property="i2Status" name="retrieveGrantsForPDAForm">
     			          <html:options collection="<%= LookUpTableConstants.APPL_STATUS_GROUPS_MV_LOOKUP[0] %>" property="value"  labelProperty="label" />
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
                               <td nowrap ><b>Grants With BARS:</b> 
                               
                                 <html:checkbox property="barFlag"/>
                               </td>
                             </tr>
                            </table>
                         </td>
                    </tr>

                 </table>
 




    <!--End Criteria-->