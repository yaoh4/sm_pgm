<!--Start selection buttons -->

        <table border="0" cellspacing="0" cellpadding="0" width="800" align="center">
        <tr><td width="15" align="right">&nbsp;</td>
        </tr>         
        <tr>
           <td align="left" width="4%">&nbsp;</td>
           <td align="left" width="15%">
               <a link href="#grants" onclick="selectionType('selectAll');"> Check All Boxes</a>&nbsp;
           </td>
           <td  align="left" width="22%">
               <a link href="#grants" onclick="selectionType('selectAllOnPage');"> Check All Boxes on Page</a>&nbsp;
           </td>
           <td width="15%" align="left" >
               <a link href="#grants" onclick="selectionType('clearAll');"> Clear All Boxes</a>&nbsp;
           </td>
           <td  width="22%" align="left" >
               <a link href="#grants" onclick="selectionType('clearAllOnPage');"> Clear All Boxes on Page</a>&nbsp;
           </td>
          <td  width="5%" align="left" >&nbsp;</td>
          <td class="DefaultText" width=15%" nowrap><label for="selectedPageSize"><b>Change Page Size:</b></label> 
              <html:select property="selectedPageSize" >
	        <html:options collection="<%= ApplicationConstants.PAGE_SIZES %>" property="value"  labelProperty="label" />
	      </html:select>
          </td>
         <td  align="left" >
            <a link href="#grants" onclick="selectionType('changePageSize');">  Go </a>
         </td>
         
        </tr>
        </table> 
<!--End selection buttons -->
