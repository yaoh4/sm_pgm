<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib  uri="/wbportlettags"  prefix="portlet" %>
<%@ page import="java.util.*"%>
<%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants" %>
<%
  List prevList = (List)request.getAttribute(ApplicationConstants.PREV_REFERRAL_ACTIVITY);
  List currentList = (List)request.getAttribute(ApplicationConstants.CURRENT_REFERRAL_ACTIVITY);
  List nextList = (List)request.getAttribute(ApplicationConstants.NEXT_REFERRAL_ACTIVITY);
  String prevCouncil = (String)request.getAttribute(ApplicationConstants.PREV_COUNCIL);
  String currentCouncil = (String)request.getAttribute(ApplicationConstants.CURRENT_COUNCIL);
  String nextCouncil = (String)request.getAttribute(ApplicationConstants.NEXT_COUNCIL);
  String referralActivityUrl = (String)request.getAttribute(ApplicationConstants.REFERRAL_ACTIVITY_URL);
  String externalReferralUrl = referralActivityUrl.substring(0, referralActivityUrl.indexOf("/pgm/")+5)+"externalReferralSearch.do";
%>
<SCRIPT>

  function popUpReferralActivity(theURL, myname, theParameters) {
     var myname = 'ReferralActivityJAVA';
     var myWindow = "this." + myname;
	if(typeof eval(myWindow) == 'undefined'){
		myWindow = window.open(theURL,myname,theParameters);
                myWindow.focus();
	}
	else{
	     if (typeof eval(myWindow) == 'window') {	
		if(eval(myWindow + ".closed")) {
			myWindow = window.open(theUrl,myname,theParameters);
                        myWindow.focus();
	        }
	        else {
	            myWindow = window.open(theURL,myname,theParameters);
                    myWindow.focus();
                }
	     }
	     else {  
		myWindow = window.open(theURL,myname,theParameters);
                myWindow.focus();	     
	     }
	}
     

}
  
   function popUpQueryReferralActivity(cancerActivity, councilDate)
   {
     document.externalReferralSearchForm.cancerActivity.value=cancerActivity;
     document.externalReferralSearchForm.ncabFromDate.value=councilDate;
     document.externalReferralSearchForm.ncabToDate.value=councilDate;
     document.externalReferralSearchForm.action='<%=externalReferralUrl%>';
     document.externalReferralSearchForm.submit();
   }
   
   
</SCRIPT>
<!-- Start Referral Activity Module Header -->
<table class="ModuleHeader" align="center" border="0" cellpadding="0" cellspacing="0" width="820">
  <tbody><tr>
    <td class="ModuleHeaderTitleBar" nowrap="nowrap"> <table border="0" cellpadding="1" cellspacing="0" width="820">
          <tbody><tr>
            <td align="right"><img src="images/spacer.gif" alt="" height="10" width="7"><a href="#" onclick="WM_Submit_toggle('ModuleReferralActivityBody'); return false"><img src="images/IconModuleOpened.gif" alt="Show/Hide Module" name="ModuleReferralActivityToggleImage" id="ModuleReferralActivityToggleImage" border="0" height="13" width="13"></a></td>
            <td width="100%">&nbsp;<a class="ModuleHeaderTitleBar" href="javascript:popUpReferralActivity('<%=referralActivityUrl%>','ReferralActivity','statusbar=yes,scrollbars=yes,toolbar=yes,location=yes,menubar=yes,resizable=yes,width=750,height=550')" title="Open Application">Outstanding Referrals by Board</a></td>
            <td align="right" valign="bottom"> <table border="0" cellpadding="0" cellspacing="0">
                <tbody><tr>
                  <td><img src="images/ButtonLeft.gif" alt="" height="15" width="5"></td>
                  <td class="Button" background="images/ButtonBG.gif" valign="top"><a class="Button" href="javascript:popUpReferralActivity('<%=referralActivityUrl%>','ReferralActivity','statusbar=yes,scrollbars=yes,toolbar=yes,location=yes,menubar=yes,resizable=yes,width=750,height=550')" title="Open Application">OPEN</a></td>
                  <td><img src="images/ButtonRight.gif" alt="" height="15" width="5"></td>
                </tr>
              </tbody></table></td>
            <td><img src="images/spacer.gif" alt="" height="10" width="20"></td>
          </tr>
        </tbody></table></td>
  </tr>
</tbody></table>
<!-- End Referral Activity Module Header -->
<div id="ModuleReferralActivityBody" style="display: block">
<table class="ModuleBody" cellspacing="0" cellpadding="0" width="820" align="center" border="1">
  <tr>
    <td valign="top">
      <table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
        <tr>
          <td height="10" colspan="3">&nbsp;</td>
        </tr>      
        <tr>
          <td width="33.33%" valign="top"  align="center">
            <table summary="Referral Activity Previous Council"  width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr>
               <td nowrap="nowrap">
               <img src="images/spacer.gif" alt="" width="10" height="10" />
               <img src="images/Bullet.gif" alt="" width="10" height="12" />
               </td>
              <td valign="bottom">
             <table width="100%" border="0" cellspacing="0" cellpadding="0">
               <tr>
                  <td nowrap="nowrap" valign="bottom" class="TitleTab">&nbsp;<%=prevCouncil.substring(4)+"/"+prevCouncil.substring(0,4)%>
                        Board</td>
                  <td nowrap="nowrap" valign="bottom" class="BoldText">&nbsp;</td>
                  <td width="100%" nowrap="nowrap"><img src="images/spacer.gif" alt="" width="20" height="10" /></td>
               </tr>
              <tr>
                  <td><img src="images/spacer.gif" alt="" width="10" height="1" /></td>
                  <td><img src="images/spacer.gif" alt="" width="10" height="1" /></td>
              <td  width="100%"><img src="images/spacer.gif" alt="" width="10" height="1" /></td>
              </tr>
             </table>          
             </td>
             </tr>
              <tr>
                <td width="20">&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table>      
            <table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
              <tr>
                <td width="20" valign="top">&nbsp; </td>
                <td> 
                 <script language="JavaScript" type="text/javascript">
                   // define table with border attribute for Netscape 4.7x browsers
                   if (ns4 == 1) {
                      document.write('<table summary="Previous Council Referral Activity Table" border="1" cellpadding="2" cellspacing="0" width="100%">'); } 
                    else {
                      // otherwise no border is required
                      document.write('<table summary="Previous Council Referral Activity Table" cellpadding="2" cellspacing="0" width="100%">'); }
                 </script>
                 <noscript>
                    <table summary="Previous Council Referral Activity Table" border="1" cellpadding="2" cellspacing="0" width="100%">
                  </noscript>   
                      <portlet:ReferralActivity referralActivity="<%=prevList%>" />
                  </table></td>
                <td width="20">&nbsp;</td>
              </tr>
              <tr>
                <td valign="top">&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
           </table>
          </td>
          <td width="33.33%" valign="top" align="center">
            <table summary="Referral Activity Current Council"  width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr>
               <td nowrap="nowrap">
               <img src="images/spacer.gif" alt="" width="10" height="10" />
               <img src="images/Bullet.gif" alt="" width="10" height="12" />
               </td>
              <td valign="bottom">
             <table width="100%" border="0" cellspacing="0" cellpadding="0">
               <tr>
                  <td nowrap="nowrap" valign="bottom" class="TitleTab">&nbsp;<%=currentCouncil.substring(4)+"/"+currentCouncil.substring(0,4)%>
                        Board</td>
                  <td nowrap="nowrap" valign="bottom" class="BoldText">&nbsp;</td>
                  <td width="100%" nowrap="nowrap"><img src="images/spacer.gif" alt="" width="20" height="10" /></td>
               </tr>
              <tr>
                  <td><img src="images/spacer.gif" alt="" width="10" height="1" /></td>
                  <td><img src="images/spacer.gif" alt="" width="10" height="1" /></td>
              <td width="100%"><img src="images/spacer.gif" alt="" width="10" height="1" /></td>
              </tr>
             </table>          
             </td>
             </tr>
              <tr>
                <td width="20">&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table>             
            <table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
              <tr>
                <td width="20" valign="top">&nbsp; </td>
                <td> 
                 <script language="JavaScript" type="text/javascript">
                   // define table with border attribute for Netscape 4.7x browsers
                   if (ns4 == 1) {
                      document.write('<table summary="Previous Council Referral Activity Table" border="1" cellpadding="2" cellspacing="0" width="100%">'); } 
                    else {
                      // otherwise no border is required
                      document.write('<table summary="Previous Council Referral Activity Table" cellpadding="2" cellspacing="0" width="100%">'); }
                 </script>
                 <noscript>
                    <table summary="Previous Council Referral Activity Table" border="1" cellpadding="2" cellspacing="0" width="100%">
                  </noscript>                                           
                       <portlet:ReferralActivity referralActivity="<%=currentList%>" />
                  </table></td>
                <td width="20">&nbsp;</td>
              </tr>
              <tr>
                <td valign="top">&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
           </table>                       
          </td>          
          <td width="33.33%" valign="top" align="center">
            <table summary="Referral Activity Next Council"  width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr>
               <td nowrap="nowrap">
               <img src="images/spacer.gif" alt="" width="10" height="10" />
               <img src="images/Bullet.gif" alt="" width="10" height="12" />
               </td>
              <td valign="bottom">
             <table width="100%" border="0" cellspacing="0" cellpadding="0">
               <tr>
                  <td nowrap="nowrap" valign="bottom" class="TitleTab">&nbsp;<%=nextCouncil.substring(4)+"/"+nextCouncil.substring(0,4)%>
                        Board</td>
                  <td nowrap="nowrap" valign="bottom" class="BoldText">&nbsp;</td>
                  <td width="100%" nowrap="nowrap"><img src="images/spacer.gif" alt="" width="20" height="10" /></td>
               </tr>
              <tr>
                  <td><img src="images/spacer.gif" alt="" width="10" height="1" /></td>
                  <td><img src="images/spacer.gif" alt="" width="10" height="1" /></td>
              <td  width="100%"><img src="images/spacer.gif" alt="" width="10" height="1" /></td>
              </tr>
             </table>          
             </td>
             </tr>
              <tr>
                <td width="20">&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table>          
            <table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
              <tr>
                <td width="20" valign="top">&nbsp; </td>
                <td> 
                 <script language="JavaScript" type="text/javascript">
                   // define table with border attribute for Netscape 4.7x browsers
                   if (ns4 == 1) {
                      document.write('<table summary="Previous Council Referral Activity Table" border="1" cellpadding="2" cellspacing="0" width="100%">'); } 
                    else {
                      // otherwise no border is required
                      document.write('<table summary="Previous Council Referral Activity Table" cellpadding="2" cellspacing="0" width="100%">'); }
                 </script>
                 <noscript>
                    <table summary="Previous Council Referral Activity Table" border="1" cellpadding="2" cellspacing="0" width="100%">
                  </noscript>   
                     <portlet:ReferralActivity referralActivity="<%=nextList%>" />
                  </table></td>
                <td width="20">&nbsp;</td>
              </tr>
              <tr>
                <td valign="top">&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
           </table>            
          </td>
        </tr>
      </table>
     </td>
  </tr>
</table>
 </div>
<html:form action="externalReferralSearch.do" method="POST" target="ReferralActivityJAVA">

<html:hidden property="requestAction" value="<%=ApplicationConstants.EXT_SEARCH_ACTION%>" />
<html:hidden property="cancerActivity" />
<html:hidden property="ncabFromDate" />
<html:hidden property="ncabToDate" />
<html:hidden property="grantsFromCriteria" value="<%=ApplicationConstants.ALL_GRANTS%>"/>
</body>
</html:form>