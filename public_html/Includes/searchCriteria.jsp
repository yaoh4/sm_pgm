  <%@ page import="gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants" %>
  <table border="0" cellspacing="0" cellpadding="0" width="800" align="center">
    <tr>
     <td>
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
         <!--Include the drop down to select additional Creiteria -->
         <%@include file="PgmAdditionalCriteria.jsp"%>
       </table>
     </td>
    </tr>
  </table>
  <br>
  <% String action = (String) request.getAttribute(ApplicationConstants.SEARCH_ACTION); %>

   <table border="0" align="center" cellspacing="0" cellpadding="0" width="800"  bgcolor="#99CCFF">
      <tr> 
        <td width="20">&nbsp;</td>
        <td valign="top"> 
          <table border="0" cellspacing="0" cellpadding="2">
            <tr> 
              <% if(action.equalsIgnoreCase(ApplicationConstants.REFERRAL)) { %>
                 <td colspan="3" valign="top" bgcolor="#99CCFF"><b><font size="2" color="#FFFFFF">Grant 
                   Number</font></b><br>
              <% } else { %>
                 <td colspan="3" valign="top" bgcolor="#99CCFF"><b><font size="2" color="#FFFFFF">Grant 
                   Numbers</font></b><br>
              <% } %>
                <table border=0 cellpadding=0 cellspacing=1 >
                 <tr> 
                  <td nowrap><b>Tp:</b><br>
                    <html:text property="tpIndexed[0]" size="1" maxlength="1"/>
                  </td>
                  <td nowrap width="5"><img src="images/spacer.gif" alt="" width="5" height="10"></td>
                  <td nowrap><b>Mech:</b><br>
                    <html:text property="mechIndexed[0]" size="3" maxlength="3"/>
                  </td>
                  <td nowrap width="5">&nbsp;</td>
                  <td nowrap><b>ICD:</b><br>
                    <html:text property="icdIndexed[0]" size="2" maxlength="2"/>
                  </td>
                  <td nowrap width="5">&nbsp;</td>
                  <td nowrap><b>Srl #:</b><br>
                    <html:text property="srlIndexed[0]"  size="8" maxlength="6"/>
                  </td>
                  <td nowrap width="5">&nbsp;</td>
                  <td nowrap><b>Yr:</b><br>
                    <html:text property="yearIndexed[0]" size="2" maxlength="2"/>
                  </td>
                  <td nowrap width="5">&nbsp;</td>
                  <td nowrap><b>Sfx:</b><br>
                    <html:text property="suffixIndexed[0]" size="4" maxlength="4"/>
                  </td>
                </tr>
                <% if(action.equalsIgnoreCase(ApplicationConstants.PD_ASSIGNMENT)) { 
                  %>
                     <tr> 
                       <td nowrap>
                         <html:text property="tpIndexed[1]" size="1" maxlength="1"/>
                       </td>
                       <td nowrap width="5"><img src="images/spacer.gif" alt="" width="5" height="10"></td>
                       <td nowrap>
                          <html:text property="mechIndexed[1]" size="3" maxlength="3"/>
                       </td>
                       <td nowrap width="5">&nbsp;</td>
                       <td nowrap>
                          <html:text property="icdIndexed[1]" size="2" maxlength="2"/>
                       </td>
                       <td nowrap width="5">&nbsp;</td>
                       <td nowrap>
                          <html:text property="srlIndexed[1]"  size="6" maxlength="6"/>
                       </td>
                       <td nowrap width="5">&nbsp;</td>
                       <td nowrap>
                          <html:text property="yearIndexed[1]" size="2" maxlength="2"/>
                       </td>
                       <td nowrap width="5">&nbsp;</td>
                       <td nowrap>
                          <html:text property="suffixIndexed[1]" size="4" maxlength="4"/>
                       </td>
                     </tr>
                     <tr> 
                       <td nowrap>
                         <html:text property="tpIndexed[2]" size="1" maxlength="1"/>
                       </td>
                       <td nowrap width="5"><img src="images/spacer.gif" alt="" width="5" height="10"></td>
                       <td nowrap>
                          <html:text property="mechIndexed[2]" size="3" maxlength="3"/>
                       </td>
                       <td nowrap width="5">&nbsp;</td>
                       <td nowrap>
                          <html:text property="icdIndexed[2]" size="2" maxlength="2"/>
                       </td>
                       <td nowrap width="5">&nbsp;</td>
                       <td nowrap>
                          <html:text property="srlIndexed[2]"  size="6" maxlength="6"/>
                       </td>
                       <td nowrap width="5">&nbsp;</td>
                       <td nowrap>
                          <html:text property="yearIndexed[2]" size="2" maxlength="2"/>
                       </td>
                       <td nowrap width="5">&nbsp;</td>
                       <td nowrap>
                          <html:text property="suffixIndexed[2]" size="4" maxlength="4"/>
                       </td>
                     </tr>
                       <tr> 
                       <td nowrap>
                         <html:text property="tpIndexed[3]" size="1" maxlength="1"/>
                       </td>
                       <td nowrap width="5"><img src="images/spacer.gif" alt="" width="5" height="10"></td>
                       <td nowrap>
                          <html:text property="mechIndexed[3]" size="3" maxlength="3"/>
                       </td>
                       <td nowrap width="5">&nbsp;</td>
                       <td nowrap>
                          <html:text property="icdIndexed[3]" size="2" maxlength="2"/>
                       </td>
                       <td nowrap width="5">&nbsp;</td>
                       <td nowrap>
                          <html:text property="srlIndexed[3]"  size="6" maxlength="6"/>
                       </td>
                       <td nowrap width="5">&nbsp;</td>
                       <td nowrap>
                          <html:text property="yearIndexed[3]" size="2" maxlength="2"/>
                       </td>
                       <td nowrap width="5">&nbsp;</td>
                       <td nowrap>
                          <html:text property="suffixIndexed[3]" size="4" maxlength="4"/>
                       </td>
                     </tr>
                    <% } %>
                <table border=0 cellpadding=0 cellspacing=1 >
                  <tr> 
                    <td nowrap><label for="applId"><b>Appl Id:</b></label> 
                      <br> 
                       <html:text property="applId" size="8" maxlength="8"/>
                    </td>
                    <td nowrap width="5">&nbsp;</td>
                    <td nowrap><label for="projectTitle"><b>Project Title:</b></label> 
                      <br> 
                      <html:text property="projectTitle" size="30" maxlength="30"/> 
                    </td>
                  </tr>
                </table>
                <b><font size="2" color="#FFFFFF">Principal Investigator</font></b><br>
                <table title="Principal Investigator" border=0 cellpadding="0" cellspacing="1">
                <tr> 
                  <td nowrap align="right"><b>Last Name:</b></td>
                  <td nowrap width="5">&nbsp;</td>
                  <td nowrap> 
                    <html:text property="piLastName" size="30" maxlength="30"/>
                  </td>
                </tr>
                <tr> 
                  <td nowrap align="right"><b>First Name:</b></td>
                  <td nowrap width="5">&nbsp;</td>
                  <td nowrap> 
                    <html:text property="piFirstName" size="30" maxlength="30"/>
                  </td>
                </tr>
                </table>

                <b><font size="2" color="#FFFFFF">Institution</font></b><br>
                <table title="Institution" border=0 cellpadding="0" cellspacing="1">


                <tr> 
                  <td nowrap align="right"><b>Name:</b></td>
                  <td nowrap width="5"><img src="images/spacer.gif" alt="" width="5" height="10"></td>
                  <td nowrap> 
                    <html:text property="instName" size="30" maxlength="120"/>
                  </td>
                </tr>
                <tr> 
                  <td nowrap align="right"><b>City:</b></td>
                  <td nowrap width="5">&nbsp;</td>
                  <td nowrap> 
                    <html:text property="instCity" size="25" maxlength="25"/>
                    <b>St:</b> 
                    <html:text property="instState" size="2" maxlength="2"/>
                  </td>
                </tr>

                <tr> 
                  <td nowrap align="right"><b>IPF:</b></td>
                  <td nowrap width="5"><img src="images/spacer.gif" alt="" width="5" height="10"></td>
                  <td nowrap> 
                    <html:text property="ipf" size="10" maxlength="10"/>
                  </td>
                </tr>
  
                </table>
              </td>
              <td width="20" valign="top" bgcolor="#99CCFF"><img src="images/spacer.gif" alt="" width="20" height="12"></td>
              
              <td colspan="3" valign="top" bgcolor="#99CCFF"><b><font color="#FFFFFF" size="2">Other 
                Codes/Dates/Status</font></b><br>
                <table border=0 cellpadding=0 cellspacing=0 width="350">
                  <tr> 
                    <td nowrap> 
                      <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                        <tr> 
                          <td nowrap width="33%"><b>Cancer</b></td>
                          <td nowrap ><b>NCAB</b></td>
                        </tr>
                       </table>
                    </td>
                   </tr>
                   <tr> 
                    <td nowrap> 
                       <%@include file="searchCriteriaCA.jsp"%>

                    </td>
                   </tr>
                </table>

                <table border=0 cellpadding=0 cellspacing=0 width="350">
                  <tr> 
                    <td nowrap> 
                      <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                        <tr> 
                          <td nowrap width="27%"><label for "rfaPa"><b>RFA/PA</b></label></td>
                          <td nowrap ><b>Fiscal Year (YYYY)</b></td>
                        </tr>
                       </table>
                    </td>
                   </tr>
                   <tr> 
                    <td nowrap> 
                      <table border=0 cellpadding=0 cellspacing=0 width="100%" >
                        <tr> 
                          <td>
                             <html:text property="rfaPa" size="10" maxlength="10"/> 
                          </td>
                          <td nowrap><label for="fyFrom"><b><bean:message key="labels.search.field.fyFrom" /></b></td>
                          <td nowrap> 
                             <html:text property="fyFrom" size="10" maxlength="10" onblur="copyFY()"/> </label>
                          </td>
                          <td nowrap><label for="fyTo"><b><bean:message key="labels.search.field.fyTo" /></b></td>
                          <td nowrap> 
                             <html:text property="fyTo" size="10" maxlength="10" onblur="copyFY()"/> </label>
                          </td>          
                        </tr>
                       </table>
                    </td>
                   </tr>
                </table>

 
 


    
 

   
    <!--End Criteria-->