
              <td width="20" valign="top" bgcolor="#99CCFF"><img src="images/spacer.gif" alt="" width="20" height="12"></td>
              
              <td colspan="3" valign="top" bgcolor="#99CCFF"><b><font color="#FFFFFF" size="2">Program Director 
                Information</font></b><br>
                <table border=0 cellpadding=0 cellspacing=0 width="350">
		   <tr>
		      <td nowrap width="80%"><b>Program Director Name:</b></td>
		            
		      <td nowrap width="20%" align="right"><b>Cancer Activity:</b></td>
		   </tr>
		   <tr>
		       <td nowrap width="80%">
                           <ncijsp:formatProgramDirectorSelectTag /> 
		        </td>
	                <td width="20%" align="right">
                           <ncijsp:formatCancerActivitySelectTag /> 
                        </td>
	             </tr>
		</table>
                <table border=0 cellpadding=0 cellspacing=0 width="350">
                   <tr>
                     <td nowrap width="62%"><b>Program Director Org:</b></td>
                   </tr>
                   <tr>
                     <td>
                           <ncijsp:formatPDorgSelectTag /> 
                  </tr>
                </table>		
                <table border=0 cellpadding=0 cellspacing=0 width="350">
                  <tr><td colspan="3" valign="top" bgcolor="#99CCFF"><b><font color="#FFFFFF" size="2">Other 
                Codes/Dates/Status</font></b><br>
                   </td></tr>
                </table>
                <table border=0 cellpadding=0 cellspacing=0 width="350">
                  <tr> 
                    <td nowrap> 
                      <table  border=0 cellpadding=0 cellspacing=0 width="100%" >
                        <tr> 
                          <td nowrap width="75%" ><b>NCAB</b></td>
                          <td title="RFA/PA"  nowrap width="25%" >
                          <b>RFA/PA  </b></td>
                        </tr>
                       </table>
                    </td>
                   </tr>
                   <tr> 
                    <td nowrap> 
                      <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                        <tr> 
                          <td nowrap width="75%"><label for="ncabFromDate"><b>From:</label></b>
                          
                             <html:select property="ncabFromDate"  onblur="copyNcab()">
			          <html:options collection="<%= LookUpTableConstants.BOARDS_T_LOOKUP[0] %>" property="value"  labelProperty="label" />
			     </html:select>
                          &nbsp; <label for="ncabToDate"><b>To:</b></label>
                         
                             <html:select property="ncabToDate"  onblur="copyNcab()">
			          <html:options collection="<%= LookUpTableConstants.BOARDS_T_LOOKUP[0] %>" property="value"  labelProperty="label" />
			     </html:select>
                          </td>
                           <td nowrap align="left" width="25%">
                             <html:text property="rfaPa" size="10" maxlength="10"/> </label>
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
                        <tr width="73%"> 
                          <td nowrap ><b>Fiscal Year (YYYY)</b></td>
                          <td nowrap width="27%"><b>Group </b>   </td>
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
                          <td nowrap width="27%">
                              <b> Code: </b>  <html:text property="groupCode" size="5"/> </label>
                          </td>
                        </tr>
                       </table>
                    </td>
                   </tr>
                </table>

 
 


    
 

   
    <!--End Criteria-->