
              <td width="20" valign="top" bgcolor="#99CCFF"><img src="images/spacer.gif" alt="" width="20" height="12"></td>
              
              <td colspan="3" valign="top" bgcolor="#99CCFF"><b><font color="#FFFFFF" size="2">Program Director 
                Information</font></b><br>
                <table border=0 cellpadding=0 cellspacing=0 width="470">
		   <tr>
		      <td nowrap width="70%"><b>Program Director:</b></td>
		      <td width="15%"><b>Show Inactive PDs:</b></td>
		            
		      <td width="15%"><b>Cancer Activity:</b></td>
                      <td width="15%" align="right">                     
                      </td>
		   </tr>
		   <tr>
		       <td nowrap width="70%">
                           <ncijsp:formatProgramDirectorSelectTag /> 
		        </td>
		        <td width="15%"><html:checkbox property="showInactivePDs" onchange="toggleShowInactivePDs()"/></td>
	                <td width="15%" align="left">
                           <ncijsp:formatCancerActivitySelectTag /> 
                        </td>
                        <td width="15%" align="right">
                            <input class="button2a" type="button" value="Clear PD"  onclick="clearPDCriteria('continue');"/>
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
                           <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                             <tr>
                               <td nowrap ><b>I2 Status:</b> 
                               
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
                      <table  border=0 cellpadding=0 cellspacing=0 width="100%" >
                        <tr> 
                          <td nowrap width="75%" ><b>NCAB</b></td>
                          <td title="RFA/PA"  nowrap width="25%" >
                          <label for "rfaPa"><b>RFA/PA  </b></label></td>
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
                             <html:text property="rfaPa" size="10" maxlength="10"/>
                          </td>
                         </tr>
                       </table>
                    </td>
                   </tr>
                </table>


 
 


    
 

   
    <!--End Criteria-->