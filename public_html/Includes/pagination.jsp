<!--Start pagination button -->
<jsp:useBean id="PaginationObject" scope="session" type="gov.nih.nci.iscs.oracle.pgm.forms.PaginationObject" />  
    <!--Start Search/Clear Buttons-->
      <table border="0" cellspacing="0" cellpadding="0" width="800" align="right">
        <tr> 
          <td width="40%"  align="right"> Page ( <bean:write name="PaginationObject" property="pageNumber" /> &nbsp; of <bean:write name="PaginationObject" property="lastPageNumber" /> ) </td>
          <td width "10%" align="left" > &nbsp; </td>
          <td width "50%" align="left" > 
               <ncijsp:pagination />
	   </td>
          
        </tr>
  </table>
<!--End pagination button -->
