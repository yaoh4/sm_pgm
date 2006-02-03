
<!-- Hide from old browsers
// This script is for today's date which appears on every page.

today = new Date() 
 
function CreateArray(n) {this.length = n
return this } 
 
day = new CreateArray(7)
day[0]="Sunday"
day[1]="Monday"
day[2]="Tuesday"
day[3]="Wednesday"
day[4]="Thursday"
day[5]="Friday"
day[6]="Saturday" 
 
month = new CreateArray(12)
month[0]="January"
month[1]="February"
month[2]="March"
month[3]="April"
month[4]="May"
month[5]="June"
month[6]="July"
month[7]="August"
month[8]="September"
month[9]="October"
month[10]="November"
month[11]="December"
modifier = new CreateArray(31)
var modifierSt = new String("thstndrdthththththththththththththththththstndrdthththththththst")
var loop = 0
do {
    modifier[loop] = modifierSt.substring(loop * 2, 2 + (loop * 2));
    loop = loop + 1;
} while (loop < 32);
myDate = new String(today.getDate())
mySuffix = modifier[today.getDate()]
myYear = new String(today.getFullYear())



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



// These are Dreamweaver-generated functions.

function MM_goToURL() { //v3.0
  var i, args=MM_goToURL.arguments; document.MM_returnValue = false;
  for (i=0; i<(args.length-1); i+=2) eval(args[i]+".location='"+args[i+1]+"'");
}
 

// This function pops up a new window
// if window loses focus and link is clicked, window will come to front
// if window was closed and link is clicked, window is re-generated
function MM_openBrWindow(theURL,winName,features,focus) { //v2.0
 if(typeof this.newWindow == 'undefined'){
  this.newWindow = window.open(theURL,winName,features);
    if (focus == "true") {
	this.newWindow.focus();
    }
 }
 else{
  if(this.newWindow.closed){
    this.newWindow = window.open(theURL,winName,features);
      if (focus == "true") {
	this.newWindow.focus();
      }  
    }
    this.newWindow.location.reload();
    if (focus == "true") {
      this.newWindow.focus();
    }
 } 
}

// This function pops up a new window
// if window loses focus and link is clicked, window will come to front
// if window was closed and link is clicked, window is re-generated
// keeps window focused
function MM_openBrDetailsWindow(theURL,winName,features,focus) { //v2.0
 if(typeof this.newWindow == 'undefined'){
  this.newWindow = window.open(theURL,winName,features);
    if (focus == "true") {
	this.newWindow.focus();
    }
 }
 else{
  if(this.newWindow.closed){
    this.newWindow = window.open(theURL,winName,features);
      if (focus == "true") {
	this.newWindow.focus();
      }  
    }
    else {
      //Just open the window again else the grant number selected does not refresh
      this.newWindow = window.open(theURL,winName,features);  
    }
    if (focus == "true") {
      this.newWindow.focus();
    }
 } 
}

function MM_closeBrWindow(theURL,winName,features) { //v2.0
  window.close(theURL,winName,features);
}


// This function toggles the actual criteria (Search parameters) piece.

function WM_toggle(id){
  if (document.all){
    if(document.all[id].style.display == 'none'){
      document.all[id].style.display = '';
    } else {
      document.all[id].style.display = 'none';
    }
  } else if (document.getElementById){
    if(document.getElementById(id).style.display == 'none'){
      document.getElementById(id).style.display = 'block';
    } else {
      document.getElementById(id).style.display = 'none';
    }
  }
}


// This function is used to pop up the Grant Detail Pages.

/**
 * Method: popUpSolo
 * @param theURL: url to be opened in new window
 * @param theParameters: attributes of new window
 * @param myName: name for this window
 * Function opens a new window. If window loses focus and link is clicked, window is re-generated.
 * If window was closed and link is clicked, window is re-generated.
 * Each window opened by this function is unique -- numerous windows can be opened by this function.
 * Each time function is called, a new window will appear (or be re-focused).  */ 
 
 function popUpSolo(theURL, myname, theParameters) {
  var myWindow = "this." + myname;
	if(typeof eval(myWindow) == 'undefined'){
		myWindow = window.open(theURL,myname,theParameters);
    myWindow.focus();
	}
	else{
		if(eval(myWindow + ".closed")) {
			myWindow = window.open(theUrl,myname,theParameters);
      myWindow.focus();
		}
    myWindow.focus();
	}
}



// This folling 4 functions are generated through Dreamweaver, 
// and are used for the image swap for the criteria piece.

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.0
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && document.getElementById) x=document.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}




// This function does the toggling of the HEADING IMAGE for the criteria piece.
// Use this function if you want to start with the criteria piece initially open (regular query).


	var theImage = "Plus"; // The state of the image when the page first loads
function pva_imageToggle() 
{
	if (theImage == "Plus") {  // The image is currently "Plus"
		MM_swapImage('ToggleImage','','images/HeadingCriteriaClosed.gif',1); // Change the image with the name "ToggleImage" to "Minus"
		theImage = "Minus"; // reset the variable
	}
	else if (theImage == "Minus") { // The image is currently "Minus"
		MM_swapImage('ToggleImage','','images/HeadingCriteriaOpen.gif',1); // Change the image with the name "ToggleImage" to "Plus"
		theImage = "Plus"; // reset the variable
	}
} 



// This function does the toggling of the HEADING IMAGE for the criteria piece.
// Use this function if you want to start with the criteria piece initially closed (stored query).


	var theImage2 = "Minus"; // The state of the image when the page first loads
function pva_imageToggle2() 
{
	if (theImage2 == "Plus") {  // The image is currently "Plus"
		MM_swapImage('ToggleImage','','images/HeadingCriteriaClosed.gif',1); // Change the image with the name "ToggleImage" to "Minus"
		theImage2 = "Minus"; // reset the variable
	}
	else if (theImage2 == "Minus") { // The image is currently "Minus"
		MM_swapImage('ToggleImage','','images/HeadingCriteriaOpen.gif',1); // Change the image with the name "ToggleImage" to "Plus"
		theImage2 = "Plus"; // reset the variable
	}
} 

//-->

