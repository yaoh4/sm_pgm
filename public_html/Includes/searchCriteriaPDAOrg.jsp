                       <%@include file="searchCriteriaCA.jsp"%>
                     <table border=0 cellpadding=0 cellspacing=0 width="350">
                       <tr>
                         <td nowrap>
                           <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                             <tr>
                               <td nowrap width="62%"><b>Program Director Name:</b></td>
                             </tr>
                            </table>
                         </td>
                        </tr>
                        <tr>
                         <td nowrap>
                           <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                             <tr>
                               <td>
                                  <html:select property="pdId" name="retrieveGrantsForPDAForm">
     			          <html:options collection="<%= LookUpTableConstants.PD_NAME_VW3_LOOKUP[0] %>" property="value"  labelProperty="label" />
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
                               <td nowrap width="62%"><b>Program Director Org:</b></td>
                             </tr>
                            </table>
                         </td>
                        </tr>
                        <tr>
                         <td nowrap>
                           <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                             <tr>
                               <td>
                                  <html:select property="pdOrg" name="retrieveGrantsForPDAForm">
     			          <html:options collection="<%= LookUpTableConstants.PD_ORG_VW3_LOOKUP[0] %>" property="value"  labelProperty="label" />
     			     </html:select>
                               </td>
                             </tr>
                            </table>
                         </td>
                        </tr>
                        <tr> </tr>
                </table>                     