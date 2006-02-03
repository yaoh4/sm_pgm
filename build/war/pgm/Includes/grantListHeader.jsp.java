<jsp:useBean id="PaginationObject" scope="session" type="gov.nih.nci.iscs.oracle.pgm.forms.PaginationObject" />
<div class="results">
<table cellspacing="0" class="box2">
<tr>
<td width="70%">
<table cellspacing="0" class="box2">
<caption>Results</caption>
<tr>
<td class="label">Results Shown:</td>
<td><bean:write name="PaginationObject" property="indexOfFirstGrant" /> &nbsp; to <bean:write name="PaginationObject" property="indexOfLastGrant" &nbsp; of <bean:write name="PaginationObject" property="totalResultsCount"/> <td>
</tr>
<tr>
<td class="label">View Results Page:</td>
<td><ncijsp:pagination /></td>
<tr>
<td class="label">Current Sort:</td>
<td><ncijsp:formatSortCriteria  formName='retrieveGrantsForReferralForm'/> </td>
</td>
</tr>
</table>
</td>
<td width="30%" align="right">
<table>
 <tr>
   <td class="align1">
     <span class="label">Report:</span>
 <enter report dropdown>
   </td>
 </tr>
 <tr>
   <td>
     <span class="label">Format:</span>
     <enter format dropdown>

   </td>
 </tr>
 <tr>
   <td>
    <input type="hidden"  value="4=PDF*4=Report*3=PDF*3=Report*1=Excel*1=PDF*1=Report*" name="formats" >
    <input type="button" class="button" value="Generate" onclick="javascript:generateReportFromLog(document.SuppListPageFlowForm.reportSelectUpper,document.SuppListPageFlowForm.formatSelectUpper); ">
   </td>
 </tr>
</table>
</td>
</table>