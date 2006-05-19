          <!-- Start Action Criteria -->
  <%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants" %>
             <table>
               <td nowrap align="left"> Grants From: </td>
               <td>
                   <html:select property="grantsFromCriteria">
		        <html:options collection="<%= ApplicationConstants.USER_FILTER_INFO %>" property="value"  labelProperty="label" />
		   </html:select>
               </td>
               <td height="5" nowrap><img src="images/spacer.gif" width="10" height="5"></td>
             </table>
       