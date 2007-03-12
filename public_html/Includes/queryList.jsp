
<table border="0" cellspacing="0" cellpadding="0" width="800" align="center">
<FORM ACTION="<%=cleBean.getInfo("controller")%>#Grants" METHOD="post" NAME="StoreList">
  <INPUT type="HIDDEN" name="PageId" value="<%=cleBean.getPageId()%>">
  <INPUT type="HIDDEN" name="loadqueryAction" value="loadquery">
  <INPUT type="HIDDEN" name="pagenumber" value="1">
  <INPUT type="HIDDEN" name="pageDirection" value="first">
  <INPUT type="HIDDEN" name="pSortBy" value="oDefaultOrderBy">
  <INPUT type="HIDDEN" name="<%=YGConstants.TOGGLE_SEARCH_VIEW%>" value="<%=YGConstants.OPEN_WINDOW%>">
    <tr> 
      <td width="20">&nbsp;</td>
      <td colspan="5"> 
        <table border="0" cellspacing="0" cellpadding="0">
          <tr valign="top"> 
            <td nowrap align="right" valign="middle"><b>Load Stored Query:</b></td>
            <td width="5" valign="middle"><img src="images/spacer.gif" alt="" width="5" height="10"></td>
            <td valign="middle"> 
		    <ncijsp:UserQueryList jsString="loadQuery(this)" selectedValue="<%=(String)cleBean.getInfo("pStoredQueryId")%>" queryType="QUERY" ldapUserId="<%=usernameOra%>" oracleUserId="<%=userOracleId%>" fieldName="pStoredQueryId"/>
            </td>
            <td><img src="images/spacer.gif" alt="" alt="" width="20" height="12"></td>
            <td width="100%"> 
              <table border="0" cellspacing="0" cellpadding="0">
                <tr> 
                  <td nowrap valign="top" height="2" colspan="3"><img src="images/spacer.gif" width="10" height="2"></td>
                </tr>
                <tr> 
              	
                  <% if(storedQuery != null) {%>
                    <td nowrap align="right" valign="top"><b>Description:</b></td>
                    <td width="5" valign="top">&nbsp;</td>
                    <td valign="top"> <%=CommonUtil.getEmptyIfNull(storedQuery.getQueryDesc())%></td>
                  <%}%>
                </tr>
              </table>
            </td>
          </tr>
          <tr valign="top"> 
            <td nowrap height="10" colspan="5"><img src="images/spacer.gif" alt="" width="10" height="10"></td>
          </tr>
          <tr valign="middle"> 
            <td nowrap align="right">&nbsp;</td>
            <td>&nbsp;</td>
            <td colspan="3">
          
              <% if(storedQuery == null) {%>
                <a href="javascript:saveNewStoredQuery()"><img src="images/ButtonSaveNewQuery.gif" width="108" height="20" border="0" alt="Save New Query"></a>
	      <%} else {%> 
                <a href="javascript:saveExistingStoredQuery('<%=cleBean.getInfo("pStoredQueryId")%>')"><img src="images/ButtonSaveQuery.gif" width="80" height="20" border="0" alt="Save Query"></a><img src="images/spacer.gif" width="10" height="10">
                <a href="javascript:saveNewStoredQuery();"><img src="images/ButtonSaveAsNewQuery.gif" width="127" height="20" alt="Save As New Query" border="0"></a><img src="images/spacer.gif" width="10" height="10">
                <a href="javascript:deleteStoredQuery(document.StoreList.pStoredQueryId);"><img src="images/ButtonDeleteQuery.gif" width="92" height="20" alt="Delete Query" border="0"></a>
	      <%}%>
 	     </td>

 </tr>
          <tr valign="top"> 
            <td nowrap height="10" colspan="5"><img src="images/spacer.gif" alt="" width="10" height="10"></td>
          </tr>
          <tr valign="middle" align="center"> 
            <td nowrap colspan="5"><b>--- Or Search Below ---</b></td>
          </tr>
          <tr> 
            <td colspan="5" height="10">&nbsp;</td>
          </tr>
        </table>
      </td>
      <td width="20">&nbsp;</td>
    </tr>
</FORM>
</table>

