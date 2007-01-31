

     
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
                               <td nowrap width="18%"</td>
                               <td nowrap width="22%"></td>
                             </tr>
                           </table>
                       </td>
                   </tr> 
                        
                  <tr>
                      <td nowrap>
                           <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                             <tr>
                               <td nowrap width="18%"</td>
                               <td nowrap width="22%"></td>
                             </tr>
                           </table>
                       </td>
                   </tr>
                   </table>


                <table border=0 cellpadding=0 cellspacing=0 width="350">
                  <tr> 
                    <td nowrap> 
                      <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                        <tr width="73%"> 
                          <td nowrap ><b>Fiscal Year (YYYY)</b></td>
                        </tr>
                       </table>
                    </td>
                   </tr>
                   <tr> 
                    <td nowrap> 
                      <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                        <tr> 
                          <td nowrap width="73%"><label for="fyFrom"><b><bean:message key="labels.search.field.fyFrom" /></b>
                          
                             <html:text property="fyFrom" size="10" maxlength="10" onblur="copyFY()"/> </label>
                          
                            &nbsp;<label for="fyTo"><b><bean:message key="labels.search.field.fyTo" /></b> 
                          
                             <html:text property="fyTo" size="10" maxlength="10" onblur="copyFY()"/> </label>
                          </td>          
                        </tr>
                       </table>
                    </td>
                   </tr>
                </table>

 



    <!--End Criteria-->