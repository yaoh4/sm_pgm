function setGrantsFromCriteria(oSelectObj, oHiddenObj)
{
   
   var selIndex = oSelectObj.selectedIndex;
   oHiddenObj.value = oSelectObj.options[selIndex].value;
}
function setOtherCriteria(oClickObj, oHiddenObj)
{
   oHiddenObj.value = ""
   if(oClickObj.checked == 1){
      oHiddenObj.value = oClickObj.name;
   }
   

}

function sendErrorMessage(oValue)
{
   document.forms[0].requestAction.value = oValue;
   document.forms[0].submit();
   
}

function setAction(oValue, oSort)
{

   document.forms[0].requestAction.value = oValue;
   if(oValue=="Search"){
      document.forms[0].searchButtonInitiated.value = true;
   } else {
      document.forms[0].searchButtonInitiated.value = false;
   }
   
   document.forms[0].sortColumn.value = oSort;
   document.forms[0].submit();
   
}
function clearPDCriteria(oAction) 
{
   document.forms[0].pdId.value = "";
   document.forms[0].cancerActivity.value = "";
   document.forms[0].pdOrg.value = "";
   document.forms[0].requestAction.value = oAction;
   document.forms[0].submit();
}
function sortReferralList(sortColumn, sortOrder) 
{
   document.forms[0].sortColumn.value = sortColumn;
   document.forms[0].sortAscendingIndicator.value = sortOrder;
   document.forms[0].requestAction.value = "sortList";
   document.forms[0].submit();
}

function LoseIt(oValue)
{

   document.forms[0].requestAction.value = oValue;
   document.forms[0].submit();
   
}

function setPdId(indx, selIndex, value) 
{
 document.forms[0].requestAction.value= "updateSelected";
 if(selIndex == 0){
   document.forms[0].pdId.value= "removed";
 }else{
   document.forms[0].pdId.value= value;
 }
 document.forms[0].selectedIndex.value= indx;
 document.forms[0].submit();
}

function setAssignPdId(indx, selIndex, value) 
{
 document.forms[0].pdId.value= value;
}


function setCA(indx, value, comments) 
{
   document.forms[0].requestAction.value = "updateSelected";
   document.forms[0].selectedIndex.value = indx;
   document.forms[0].rereferCA.value = value;
   document.forms[0].comments.value = comments;
   document.forms[0].submit();
}

function transferview() 
{
     window.open("/pgm/ViewProgramDir.jsp","PDView","height=400,width=500,scrollbars=yes,resizable=yes,statusbar=yes,menubar=no,toolbar=no,dependent=yes");
}
function setRereferComments(indx, value, ca) 
{

 document.forms[0].requestAction.value= "updateSelected";
 document.forms[0].selectedIndex.value= indx;
 document.forms[0].comments.value= value;
 document.forms[0].rereferCA.value = ca;
 document.forms[0].submit();
 document.forms[0].comments.setFocus();
}

function applyForAccept(value)
{

      document.forms[0].requestAction.value = "applyToSelected";
      document.forms[0].pdId.value= value;
      document.forms[0].submit();
}
function checkAllBoxes()
{
 var count = document.forms[0].count.value;
 var index;
 for(index=0; index<=count; index++){
   document.forms[0].selectedIndx[index].checked = true;
 }
    
}

function clearAllBoxes()
{
 var count = document.forms[0].count.value;
 var index;
 for(index=0; index<=count; index++){
   document.forms[0].selectedIndx[index].checked = false;
 }
    
}

function applyForReject()
{
      document.forms[0].requestAction.value = "applyToSelected";
      document.forms[0].submit();
}

function selectByCA()
{

   document.forms[0].requestAction.value = "filterCA";
   document.forms[0].submit();
   
}

function setCurrentReferralAction(oValue)
{  

   document.forms[0].requestAction.value = oValue;
   document.forms[0].submit();
   
}

function setCurrentReferralAction(oValue)
{  

   document.forms[0].requestAction.value = oValue;
   document.forms[0].submit();
   
}

function setAssignmentAction(oValue, oAction)
{  

     var count = document.forms[0].count.value;
     document.forms[0].requestAction.value = oValue;
     document.forms[0].submit();
   
}

function refreshComments(comment, controltoUpdate)
{  
  var control= eval ('document.forms[0].' + controltoUpdate.name);
  //control.value = comment;
  if(comment=="Other"){
    control.disabled=false;
  }else{
    control.disabled=true;
    control.value = "";
  }
}

function refreshSelComments(comment, controltoUpdate, index, mKey)
{  
  
}
function refreshSelComments1()
{  
  
var form = document.forms[0];
  alert( "*** form is *** " + form);
  form.sortColumn.value = 'YYYYYYY';
  form.CommentMapped("ttt", "ffffff");
  alert( "*** sortColumn is *** " + form.sortColumn.value);
}
    

function refresh(oValue, index, rusId)
{  
   
     if(index!=null){
       document.forms[0].formatSelectedLo.options.length=0;
       document.forms[0].formatSelected.options.length=0;
     }
           
     
     if(index>0){
         selectIndex=document.forms[0].formatSelectedLo.options.length;
         document.forms[0].formatSelectedLo.options[selectIndex]=new Option("Choose a Format..... ", "");
         document.forms[0].formatSelected.options[selectIndex]=new Option("Choose a Format..... ", "");
         var formats = document.forms[0].reportFormats.value;
         var reportFormatArray = formats.split("/");
         var reportFormatIndex = 0;
         while (reportFormatIndex < reportFormatArray.length){
            var selFormatArray = reportFormatArray[reportFormatIndex];
            var rusIdArray = selFormatArray.split("=");
            if(rusIdArray[0]==rusId){
                var formatText = rusIdArray[1];
                var formatArray = formatText.split("*");
                selectIndex=document.forms[0].formatSelectedLo.options.length;
                document.forms[0].formatSelectedLo.options[selectIndex]=new Option(formatArray[1], formatArray[0]);
                document.forms[0].formatSelected.options[selectIndex]=new Option(formatArray[1], formatArray[0]);
            }
	    reportFormatIndex++;
         }
      }else{
         if(index==0){
           selectIndex=document.forms[0].formatSelectedLo.options.length;
           document.forms[0].formatSelectedLo.options[selectIndex]=new Option("Select Format.....", " ");
           document.forms[0].formatSelected.options[selectIndex]=new Option("Select Format.....", " ");
         }
      }
  
   
  


   if(oValue=='top'){
      document.forms[0].reportSelectedLo.value=document.forms[0].reportSelected.value;
      document.forms[0].formatSelectedLo.value=document.forms[0].formatSelected.value;
   }else{
      document.forms[0].reportSelected.value=document.forms[0].reportSelectedLo.value;
      document.forms[0].formatSelected.value=document.forms[0].formatSelectedLo.value;
   }
   document.forms[0].requestAction.value = "refresh";;
   //document.forms[0].submit();
   
}


function copyFY()
{
   
      if(document.forms[0].fyTo.value=="" || null) {
         if(document.forms[0].fyFrom.value!="") {
           document.forms[0].fyTo.value=document.forms[0].fyFrom.value;
         }
      }
  

 
}

function copyNcab()
{
      if(document.forms[0].ncabToDate.value=="" || document.forms[0].ncabToDate.value==null) {
         if(document.forms[0].ncabFromDate.value!="") {
           document.forms[0].ncabToDate.value=document.forms[0].ncabFromDate.value;
           document.forms[0].requestAction.value = "expand";
         }
      }
 
}
function setReferralAction(oAction)
{


   document.forms[0].requestAction.value = oAction;
   document.forms[0].submit();
    
}

function setPDAction(oAction)
{


   document.forms[0].requestAction.value = oAction;
   document.forms[0].submit();
    
}

function selectionType(value)
{

  document.forms[0].requestAction.value = value;
  document.forms[0].submit();
    
}


function getAnchorName () {
  
  var tag = document.forms[0].listGenerated.value;
    if(tag=="Y"){
        location.hash="listTop";
    } 
    if(tag=="M"){
        location.hash="msgTop";
    }
   var currWindow = window.self;
   currWindow.focus();
}


function setPagination(oValue)
{

   document.forms[0].requestAction.value = oValue;
   document.forms[0].submit();
}


function sortGrantList(sortCriteria, sortOrder)
{

   document.forms[0].sortColumn.value=sortCriteria;
   document.forms[0].sortAscendingIndicator.value = sortOrder;
   document.forms[0].requestAction.value = "search";
   document.forms[0].sortActionSelected.value = true;
   document.forms[0].submit(); 
}

function openYourGrantsWindow(applId, grantsUrl)
{ 

  var url = grantsUrl + "/yourgrants/jsp/GrantDetails.jsp?applId=" + applId;
  var winName = "YourGrants";
  var features = "menubar=yes,scrollbars=yes,resizable=yes,width=850,height=700";
 
  var newWin = window.open(url, winName ,features);
  newWin.focus();
 
}

function openEGrantsWindow(eGrantId)
{ 
  var url = "https://i2e.nci.nih.gov/egrants/egrants.asp?str=" + eGrantId;
  var winName = "eGrants";
  var features = "menubar=yes,scrollbars=yes,resizable=yes,width=850,height=700";
 
  var newWin = window.open(url, winName ,features);
  newWin.focus();
 
}

function openCAHistWindow(applId, grantNumber)
{ 
  var url = "/pgm/ApplCAHist.jsp?applId=" + applId + "&grantNumber=" + grantNumber;
  var winName = "ApplCAHist";
  var features = "menubar=no,scrollbars=no,resizable=no,toolbar=no,status=no,width=350,height=280,top=300,left=300";
 
  var newWin = window.open(url, winName ,features);
  newWin.focus();
 
}

function openReferralOfficeCommentsWindow(applId, grantNumber)
{ 
  var url = "/pgm/ReferralOfficeComments.jsp?applId=" + applId + "&grantNumber=" + grantNumber;
  var winName = "Referral Office Comments";
  var features = "menubar=no,scrollbars=no,resizable=no,toolbar=no,status=no,width=350,height=280,top=300,left=300";
 
  var newWin = window.open(url, winName ,features);
  newWin.focus();
 
}

function gotoPage(pageNumber)
{

   document.forms[0].gotoPageNumber.value=pageNumber;
   document.forms[0].requestAction.value = "gotoPage";
   document.forms[0].submit();
 
}

function moveOver(innerHtml, indx)
{
    var curLeft = 2;
    var curTop = 0;
    var selName = "selected" + indx;
    var sel = document.getElementById(selName);
    if (sel.offsetParent)
    { 
       while (sel.offsetParent)
       {
    	   curLeft = curLeft +  sel.offsetLeft;
    	   curTop = curTop + sel.offsetTop;
    	   sel = sel.offsetParent;
        }
    
     }

    var divID = document.getElementById("TheTip");
    if( !divID ) {
            window.alert('Nothing works in this browser');
            return false; 
     }
    divID.innerHTML = innerHtml;
    divID.style.top=curTop + 20;
    divID.style.left=curLeft + 10;
    
    //now we have a reference to it
    if( divID.style ) { //DOM & proprietary DOM
        divID.style.visibility = 'visible';
    } else {
        if( divID.visibility ) { //Netscape
            divID.visibility = 'show';
        } else {
            window.alert('Nothing works in this browser');
            return false; //don't go any further
        } 
    }
    return true;
}

function moveOut(divName)
{
    var divID = document.getElementById("TheTip");
    if( !divID ) {
            window.alert('Nothing works in this browser');
            return false; 
     }
    divID.innerHTML = "";
    
    //now we have a reference to it
    if( divID.style ) { //DOM & proprietary DOM
        divID.style.visibility = 'hidden';
    } else {
        if( divID.visibility ) { //Netscape
            divID.visibility = 'hide';
        } else {
            window.alert('Nothing works in this browser');
            return false; //don't go any further
        }
    }
    return true;
}
function validateFiscalYearFrom() {
   
   if ((document.forms[0].fyFrom.value.length==0) ||
   (document.forms[0].fyFrom.value==null)) {
      return true;
   }
   
   if((document.forms[0].fyFrom.value.length > 4) ||
   (document.forms[0].fyFrom.value.length < 4)) {
         alert("Invalid fiscal year");
         document.forms[0].fyFrom.focus();
         document.forms[0].fyFrom.select;
         return false;
   }
   
   if (parseInt(document.forms[0].fyFrom.value) != document.forms[0].fyFrom.value) { 
       alert("Numeric values only!!"); 
       document.forms[0].fyFrom.focus();
       document.forms[0].fyFrom.select;
       return false;
   }
    
    return validateFyRange();

     
}	
function validateFiscalYearTo() {
   
   if ((document.forms[0].fyTo.value.length==0) ||
   (document.forms[0].fyTo.value==null)) {
      return true;
   }
   
   if((document.forms[0].fyTo.value.length > 4) ||
   (document.forms[0].fyTo.value.length < 4)) {
         alert("Invalid fiscal year");
         document.forms[0].fyTo.focus();
         document.forms[0].fyTo.select;
         return false;
   }
   
   if (parseInt(document.forms[0].fyTo.value) != document.forms[0].fyTo.value) { 
       alert("Numeric values only!!"); 
       document.forms[0].fyTo.focus();
       document.forms[0].fyTo.select;
       return false;
   }
    
    return validateFyRange();

     
}	

function validateFyRange() {

  if (document.forms[0].fyFrom.value == null ||
      document.forms[0].fyFrom.value.length==0) {
      return true;
  }
  if (document.forms[0].fyTo.value == null ||
      document.forms[0].fyTo.value.length==0) {
      return true;
  }
  
  if(document.forms[0].fyFrom.value > document.forms[0].fyTo.value) {
     alert("invalid Fiscal Year Range");
     document.forms[0].fyFrom.focus();
     document.forms[0].fyFrom.select;
     return false;
  }
  return true;
  
 }
  function validateNcabRange() {
  
    if (document.forms[0].ncabFromDate.value == null ||
        document.forms[0].ncabFromDate.value.length==0) {
        return true;
    }
    if (document.forms[0].ncabToDate.value == null ||
        document.forms[0].ncabToDate.value.length==0) {
        return true;
    }
    
    if(document.forms[0].ncabFromDate.value > document.forms[0].ncabToDate.value) {
       alert("invalid NCAB meeting date Year Range");
       document.forms[0].ncabFromDate.focus();
       document.forms[0].ncabFromDate.select;
       return false;
    }
  return true;

}


// This script tests for Netscape 4 
// which determines whether we're going to apply table cell styles or not
/*
 * BROWSER SNIFF FOR THE APPLICATION
 * Sets true/falses based on browser being used
 */
var ns6=document.getElementById&&!document.all;
var ns4=0;
if(document.layers) {
  ns4=1;
}
var ie=document.all; // ie5+ should read getElementById 

