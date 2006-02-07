

 function Reset_Screen() {

     resetHitListPage();

     document.Hit_List_Page.resetdetailsAction.value='reset';

     document.Hit_List_Page.target="_self";

     document.Hit_List_Page.submit();

 }



 function searchYg() {



     if (checkSearchParameters()) {

         resetHitListPage();

         document.Hit_List_Page.grantdetailsAction.value='search';

         document.Hit_List_Page.target="_self";

         document.Hit_List_Page.action = document.Hit_List_Page.action+"#Grants";

         document.Hit_List_Page.submit();

     }

 }

 

 function resetHitListPage() {

     document.Hit_List_Page.grantdetailsAction.value='';

     document.Hit_List_Page.resetdetailsAction.value='';

     document.Hit_List_Page.savenewstoredqueryAction.value='';

     document.Hit_List_Page.deleteGrantListPageAction.value='';

     document.Hit_List_Page.saveExistingQueryPageAction.value='';

 }

 

 function resetHitListForm() {

    document.HitListForm.addgrantToListPageAction.value='';

    document.HitListForm.deleteFromListPageAction.value='';

    document.HitListForm.savenewgrantListPageAction.value='';

    document.HitListForm.generateReportAction.value='';
    
    document.HitListForm.piEmailAction.value='';

 }



 function saveExistingStoredQuery() {

     resetHitListPage();

     document.Hit_List_Page.saveExistingQueryPageAction.value='save existing';

     window.open('','MYwinName','scrollbars=yes,resizable=yes,width=630,height=500');

     document.Hit_List_Page.target='MYwinName';

     document.Hit_List_Page.submit();

 }



 function saveNewStoredQuery() {

     resetHitListPage();

     document.Hit_List_Page.savenewstoredqueryAction.value='save';

     window.open('','MYwinName','scrollbars=yes,resizable=yes,width=630,height=500');

     document.Hit_List_Page.target='MYwinName';

     document.Hit_List_Page.submit();

 }



 function deleteStoredQuery(checkedList) {

        resetHitListPage();

        document.Hit_List_Page.deleteGrantListPageAction.value='delete';     

        window.open('','MYwinName','scrollbars=yes,resizable=yes,width=630,height=500');

        document.Hit_List_Page.target='MYwinName';

        document.Hit_List_Page.submit();

 }



 function sortDetailList(actionType) {

     resetHitListForm();

     document.HitListForm.pageDirection.value='first';

     document.HitListForm.pSortBy.value=actionType;

     document.HitListForm.sortAction.value=actionType;

     document.HitListForm.target='_self';

     document.HitListForm.submit();

 }



 function checkListYG(status) {

     resetHitListForm();

     document.HitListForm.checkBoxesStatus.value=status;

     document.HitListForm.checklistAction.value='checklistStatus';

     document.HitListForm.target='_self';

     document.HitListForm.submit();

 }



 function loadQuery(selectItem) {

     document.StoreList.loadqueryAction.value='loadQuery';

     document.StoreList.pStoredQueryId.value=selectItem.options[selectItem.selectedIndex].value;

     document.StoreList.submit();

 }



 function loadGrantList(selectItem) {

     document.GrantList.pStoredQueryId.value=selectItem.options[selectItem.selectedIndex].value;

     document.GrantList.submit();

 }



 function saveNewGrantListPage() {

     resetHitListForm();

     document.HitListForm.savenewgrantListPageAction.value='save';

     window.open('','MYwinName','scrollbars=yes,resizable=yes,width=630,height=500');

     document.HitListForm.target='MYwinName';

     document.HitListForm.submit();

 }



 function addGrantToListPage() {

     resetHitListForm();

     document.HitListForm.addgrantToListPageAction.value='addTo';

     window.open('','MYwinName','scrollbars=yes,resizable=yes,width=630,height=500');

     document.HitListForm.target='MYwinName';

     document.HitListForm.submit();

 }

function wait(milliseconds)
{
    d = new Date();
	   while (1)
	   {
	      mill=new Date();
	      diff = mill-d //difference in milliseconds
	      if( diff > milliseconds )
	      {
	         break;
	      }
	   }
}
    
 function  sendPiEmail() 
 {
    resetHitListForm();
    document.HitListForm.piEmailAction.value='piEmail';
    document.HitListForm.submit();
 }


 function deleteGrantFromListPage() {

     resetHitListForm();

     document.HitListForm.deleteFromListPageAction.value='addTo';

     window.open('','MYwinName','scrollbars=yes,resizable=yes,width=630,height=500');

     document.HitListForm.target='MYwinName';

     document.HitListForm.submit();

 }

 

 function submitAddIndividual() {

   if (document.AddIndividualGrant.pGrantNumber.value=='') {

     alert('YOU MUST ENTER A VALID GRANT NUMBER');

   } else {

    document.AddIndividualGrant.submit();   

   }

 }





 function editManagePage() {

     window.open('','MYwinName','scrollbars=yes,resizable=yes,width=630,height=500');

     document.EditForm.target='MYwinName';

     document.EditForm.submit();

 }

 

 function popUpListFormPage() {

        window.open('','MYwinName','scrollbars=yes,resizable=yes,width=630,height=500');

        document.PopUpListForm.target='MYwinName';

        document.PopUpListForm.submit();

 }



 function popUpListPage() {

      if (isItemChecked(document.PopUpListForm.pStoredQueryId)) {

	popUpListFormPage()

      }

 }



 function popUpQueryFormPage() {

      if (isItemChecked(document.PopUpQueryForm.pStoredQueryId)) {

      	window.open('','MYwinName','scrollbars=yes,resizable=yes,width=630,height=500');

      	document.PopUpQueryForm.target='MYwinName';

      	document.PopUpQueryForm.submit();

      }

  }



 function resetPopUpListForm() {

      document.PopUpListForm.saveGrantListAsPageAction.value='';

      document.PopUpListForm.deleteGrantListPageAction.value='';

      document.PopUpListForm.newListPageAction.value='';

      document.PopUpListForm.addIndividualGrantPageAction.value='';

      document.PopUpListForm.reportsQueryAction.value='';

      document.PopUpListForm.reportid.value='';

      document.PopUpListForm.target='_parent';

      return true;

  }



 function resetPopUpQueryForm() {

      document.PopUpQueryForm.deleteGrantListPageAction.value='';

      document.PopUpQueryForm.reportsQueryAction.value='';

      document.PopUpQueryForm.reportid.value='';

      return true;

  }

  

 function setReportParameters(ReportType, ReportFormat, ReportTypeSelect,ReportFormatSelect) {

      //alert(document.PopUpQueryForm.pStoredQueryId.checked.value);

      ReportType.value = ReportTypeSelect[ReportTypeSelect.selectedIndex].value;

      ReportFormat.value = ReportFormatSelect[ReportFormatSelect.selectedIndex].value;

      return true;

 }

 



function getCheckCount(checkedList) {

      numChecked = 0;

      if (checkedList != null) {

         if (checkedList.type == "checkbox") {

            if (checkedList.checked) {

               numChecked = 1;

            }

         }

         else {

            for(j=0;j<checkedList.length;j++){

              if (checkedList[j].checked){

                 numChecked = numChecked+1;

              }

            }

         }

      }

      return numChecked;

} 



function generateQueryReport(queryCheckedList, ReportType, ReportFormat, ReportTypeSelect, ReportFormatSelect) {

     if (ReportTypeSelect.selectedIndex == 0) {

         alert('Please select a report to generate.');

         return;

     }

     if (ReportFormatSelect.selectedIndex == 0) {

          alert('Please select a report format.');

          return;

     }

     checkCount = getCheckCount(queryCheckedList);

     if (checkCount == 0) {

        alert('Please check a query to generate the report.');

     }

     else {

        resetPopUpQueryForm();

        setReportParameters(ReportType,ReportFormat, ReportTypeSelect, ReportFormatSelect);

        document.PopUpQueryForm.reportsQueryAction.value='reports';

        document.PopUpQueryForm.target='_self';

        document.PopUpQueryForm.submit();

     }

}



function generateListReport(listCheckedList, ReportType, ReportFormat, ReportTypeSelect, ReportFormatSelect) {

     if (ReportTypeSelect.selectedIndex == 0) {

         alert('Please select a report to generate.');

         return;

     }  

     if (ReportFormatSelect.selectedIndex == 0) {

        alert('Please select a report format.');

        return;

     } 

     checkCount = getCheckCount(listCheckedList);

     if (checkCount == 0) {

        alert('Please check a list to generate the report.');

     }

     else {

        resetPopUpListForm();

        setReportParameters(ReportType,ReportFormat, ReportTypeSelect, ReportFormatSelect);

        document.PopUpListForm.reportsQueryAction.value='reports';

        document.PopUpListForm.target='_self';

        document.PopUpListForm.submit();

     }

}



function generateReportFromQuery(grantCheckedList,ReportType, ReportFormat, ReportTypeSelect, ReportFormatSelect)  {

   if (ReportTypeSelect.selectedIndex == 0) {

         alert('Please select a report to generate.');

         return;

   }

   if (ReportFormatSelect.selectedIndex == 0) {

      alert('Please select a report format to generate.');

      return;

   }

   checkCount = getCheckCount(grantCheckedList);

   if (checkCount == 0) {

      alert('Please check a grant to generate the report.');

   }

   else {

      resetHitListForm();

      setReportParameters(ReportType,ReportFormat, ReportTypeSelect, ReportFormatSelect);

      document.HitListForm.generateReportAction.value='reports';

      document.HitListForm.submit();

   }

}

function generateDetailsReport(pDetailsReportForm) {

   if (pDetailsReportForm.pReportType.selectedIndex == 0) {

      alert('Please select a report to generate.');

      return;

   }

   if (pDetailsReportForm.pReportFormat.selectedIndex == 0) {

      alert('Please select a report format to generate.');

      return;

   }

   pDetailsReportForm.submit();

}

function isItemChecked(checkedList) {

      if (checkedList.type == "checkbox") {

         if (checkedList.checked) {

             return true;

         }

      }

      else {

         for(j=0;j<checkedList.length;j++){

            if (checkedList[j].checked){

              return true;

            }

         }

      }

      

      alert('You did not check anything. Please check an item.');

      return false;

}



function submitIfNameNotNull(queryNameForm) {

      if (queryNameForm.pQueryName.value == '') {

        alert('You did not enter a valid name for the query -- Please enter a valid name');

      } else {

        queryNameForm.submit();

      }

}





function submitIfSelected(queryNameForm) {



      if (queryNameForm.pStoredQueryId.options[queryNameForm.pStoredQueryId.selectedIndex].value == '') {

          alert('You did not make a selection -- Please make a selection');

      } else {

        queryNameForm.submit();

      }

}





 function checkSearchParameters() {

     if (document.Hit_List_Page.pApplTypeCode.value.indexOf("%") > -1) {

       alert('TYPE CODE CANNOT CONTAIN A "%"');

       return false;

     }else 

     if (document.Hit_List_Page.pAdminPhsOrgCode.value.indexOf("%") > -1) {

       alert('ICD CANNOT CONTAIN A "%"');

       return false;

     }else 

     if (document.Hit_List_Page.pSerialNum.value.indexOf("%") > -1 || 

         !isNumber(document.Hit_List_Page.pSerialNum.value)) {

       alert('SERIAL NUMBER MUST BE A NUMERIC NUMBER');

       return false;

     }else 

     if (document.Hit_List_Page.pSupportYear.value.indexOf("%") > -1 ||

         !isNumber(document.Hit_List_Page.pSupportYear.value)) {

       alert('SUPPORT YEAR MUST BE A NUMERIC NUMBER');

       return false;

     }else 

     if (document.Hit_List_Page.pSuffixCode.value.indexOf("%") > -1) {

       alert('SUFFIX CODE CANNOT CONTAIN A "%"');

       return false;

     }else 

     if (document.Hit_List_Page.pState.value.indexOf("%") > -1) {

       alert('STATE CANNOT CONTAIN A "%"');

       return false;

     }else 

     if (document.Hit_List_Page.pIpfCode.value.indexOf("%") > -1 ||

         !isNumber(document.Hit_List_Page.pIpfCode.value)) {

       alert('IPF MUST BE A NUMERIC NUMBER');

       return false;

     }else 

     if (document.Hit_List_Page.pApplId.value.indexOf("%") > -1 ||

         !isNumber(document.Hit_List_Page.pApplId.value)) {

       alert('APPLICATION ID MUST BE A NUMERIC NUMBER');

       return false;

     }else      

     if (document.Hit_List_Page.pPriorityFrom.value.indexOf("%") > -1 ||

         !isNumber(document.Hit_List_Page.pPriorityFrom.value)) {

       alert('PRIORITY SCORE FROM MUST BE A NUMERIC NUMBER');

       return false;

     }else     

     if (document.Hit_List_Page.pPriorityTo.value.indexOf("%") > -1 ||

         !isNumber(document.Hit_List_Page.pPriorityTo.value)) {

       alert('PRIORITY SCORE TO MUST BE A NUMERIC NUMBER');

       return false;

     }else  

     if (document.Hit_List_Page.pPercentileFrom.value.indexOf("%") > -1 ||

         !isFloat(document.Hit_List_Page.pPercentileFrom.value)) {

       alert('PERCENTILE FROM MUST BE A NUMERIC NUMBER');

       return false;

     }else      

     if (document.Hit_List_Page.pPercentileTo.value.indexOf("%") > -1 ||

         !isFloat(document.Hit_List_Page.pPercentileTo.value)) {

       alert('PERCENTILE TO MUST BE A NUMERIC NUMBER');

       return false;

     }else      

     if (document.Hit_List_Page.pFiscalYearTo.value.indexOf("%") > -1 ||

         !isNumber(document.Hit_List_Page.pFiscalYearTo.value)) {

       alert('FISCAL YEAR MUST BE A NUMERIC NUMBER');

       return false;

     }else      

     if (document.Hit_List_Page.pFiscalYearFrom.value.indexOf("%") > -1 ||

         !isNumber(document.Hit_List_Page.pFiscalYearFrom.value)) {

       alert('FISCAL YEAR MUST BE A NUMERIC NUMBER');

       return false;

     }else 

     if (document.Hit_List_Page.pRfaPa.value.indexOf("%") > -1) {

       alert('RFA/PA CANNOT CONTAIN A "%"');

       return false;

     }else 

     if (document.Hit_List_Page.pIrgCode.value.indexOf("%") > -1) {

       alert('IRG CODE CANNOT CONTAIN A "%"');

       return false;

     }else 

     if (document.Hit_List_Page.pIrgFlexCode.value.indexOf("%") > -1) {

       alert('IRG FLEX CODE CANNOT CONTAIN A "%"');

       return false;

     }else 

     if (document.Hit_List_Page.pGroupCode.value.indexOf("%") > -1) {

       alert('REVIEW CODE CANNOT CONTAIN A "%"');

       return false;

     }else 

     if (document.Hit_List_Page.pPdCode.value.indexOf("%") > -1) {

       alert('PD CODE CANNOT CONTAIN A "%"');

       return false;

     }

     

     return true;

  }

  

  function setRange(fromObj, toObj) {

    if (toObj.value == '') {

        if (fromObj.value.indexOf("%") == -1) {

           if (isNumber(fromObj.value)) {

              toObj.value = fromObj.value;

           }

        }       

    }

  }

  

  

  function setRangeSelect(fromObj, toObj) {

    if (toObj.options[toObj.selectedIndex].text == '') {

       if (!(fromObj.options[fromObj.selectedIndex].text == '')) {

          toObj.options[fromObj.selectedIndex].selected = true;

       }

    }

  }

  

  function isNumber(inputStr) {

    if (inputStr.length==0) {

      return true;

    }

    for (var i = 0; i < inputStr.length; i++) {

      var oneChar = inputStr.substring(i, i+1);

      if (oneChar < "0" || oneChar > "9") {

        return false;

      }

    }

    return true;  

  }



  function callALink(pUrl, pTarget, pParams, pAdditionalParams) {

     var myWindow = "this."+pTarget;

     if (typeof eval(myWindow) == 'undefined'){

        document.ApplicationLinkForm.action = pUrl;

        document.ApplicationLinkForm.target = pTarget;

        if (pAdditionalParams == 'true') {

           myWindow = window.open('',pTarget, pParams);

           document.ApplicationLinkForm.submit();

           myWindow.focus();

        }

        else {

           myWindow = window.open(pUrl,pTarget, pParams);

           myWindow.focus();        

        }

     }

     else {

        document.ApplicationLinkForm.action = pUrl;

        document.ApplicationLinkForm.target = pTarget;

        if (pAdditionalParams == 'true') {

           document.ApplicationLinkForm.submit();

           myWindow.focus();

        }

        else {

           myWindow.focus();        

        }

     }

  }  

  

  function setCheckBoxProxy(checkField,hiddenField) {

    if (checkField.checked) {

       hiddenField.value = 'Y';

    }

    else {

       hiddenField.value = '';

    }

  }

  

