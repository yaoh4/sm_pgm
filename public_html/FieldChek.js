// BOI, followed by one of these two patterns:
// (a) one or more digits, followed by ., followed by zero or more digits
// (b) zero or more digits, followed by ., followed by one or more digits
// ... followed by EOI.
var reFloat = /^((\d+(\.\d*)?)|((\d*\.)?\d+))$/

var defaultEmptyOK = true

// Check whether string s is empty.

function isEmpty(s)
{   return ((s == null) || (s.length == 0))
}


// isFloat (STRING s [, BOOLEAN emptyOK])
// 
// True if string s is an unsigned floating point (real) number. 
//
// Also returns true for unsigned integers. If you wish
// to distinguish between integers and floating point numbers,
// first call isInteger, then call isFloat.
//
// Does not accept exponential notation.
//
// For explanation of optional argument emptyOK,
// see comments of function isInteger.

function isFloat (s)

{   if (isEmpty(s)) 
       if (isFloat.arguments.length == 1) return defaultEmptyOK;
       else return (isFloat.arguments[1] == true);

    return reFloat.test(s)
}




