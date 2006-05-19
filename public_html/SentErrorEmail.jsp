<html>
<head>
<title>Sent Error Email Page</title>
        <SCRIPT LANGUAGE=JAVASCRIPT>
          function resizewindow() {
              self.moveTo(0,0) ;
              self.resizeTo((screen.availWidth / 2) ,  (screen.availHeight / 2 )) ;
            }       
        </SCRIPT> 	
</head>
<body>
   <b><font color="#009999">An Email message with the error has been sent to Application Support</font></b>
   <P>
	    	<html:form action="/ErrorEmailAction.do" > 
            <html:submit styleClass="button" onclick="javascript: self.close();" tabindex="1" value="Close" />
	    	</html:form>
   <P>
</body>
</html>
