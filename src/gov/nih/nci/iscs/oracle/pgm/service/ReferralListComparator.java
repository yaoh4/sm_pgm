package gov.nih.nci.iscs.oracle.pgm.service;

import java.lang.Object;
import java.lang.reflect.*;
import java.util.Comparator;
import java.util.*;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;


    public class ReferralListComparator extends Object implements Comparator {
    	private String columnName = "grantNumber";
    	private boolean sortAscIndicator = true;
    	private String invokeMethodName;

    	public static final int ASCENDING = 1;
    	public static final int DESCENDING = -1;
    	public static HashMap columnMethodMap;

       // Here's a static initializer that fills in the hashtable
       static {
       columnMethodMap = new HashMap();
       columnMethodMap.put("cancerActivity", "getCancerActivity");
       columnMethodMap.put("grantNumber", "getGrantNumber");
       columnMethodMap.put("fullGrantNum", "getGrantNumber");
       columnMethodMap.put("default", "getGrantNumber");
       columnMethodMap.put("instName", "getInstName");
       columnMethodMap.put("pdOrgName", "getInstName");
       columnMethodMap.put("pdFullName", "getPdFullName");
       columnMethodMap.put("projectTitle", "getProjectTitle");
       columnMethodMap.put("currentPoc", "getCurrentPoc");
       columnMethodMap.put("dualCA", "getDualCA");
       columnMethodMap.put("dualPoc", "getDualPoc");
       columnMethodMap.put("sortIndex", "getSortIndex");
       columnMethodMap.put("dualCA", "getDualCA");
       columnMethodMap.put("lastName", "getLastName");
       columnMethodMap.put("orgName", "getInstName");
       columnMethodMap.put("projectTitle", "getProjectTitle");
       columnMethodMap.put("araStatusCode", "getAraStatusCode");
       columnMethodMap.put("councilMeetingDate", "getNcabDate");
       columnMethodMap.put("dualCayCode", "getDualCA");
       columnMethodMap.put("cayCode", "getCancerActivity");
       columnMethodMap.put("fy", "getFy");
       columnMethodMap.put("lastName", "getPiLastName");
       columnMethodMap.put("pdStartDate", "getPdStartDate");
       columnMethodMap.put("currentReferralActivityDate", "getCurrentReferralActivityDatey");

      }


      public ReferralListComparator(boolean sortAscIndicator) {
      	this.sortAscIndicator = sortAscIndicator;
      }


   	 public ReferralListComparator(String columnName, boolean sortAscIndicator) {
    	this.sortAscIndicator = sortAscIndicator;
    	this.columnName = columnName;
     }

   	 public ReferralListComparator(String columnName, boolean sortAscIndicator, String invokeMethodName) {
    	this.sortAscIndicator = sortAscIndicator;
    	this.columnName = columnName;
    	this.invokeMethodName = invokeMethodName;
     }

     public int compare(Object o1, Object o2) {
     	Object comp1 = null;
     	Object comp2 = null;
     	String rslt1 = null;
     	String rslt2 = null;
     	String methodName = null;
     	if(columnName==null) {
			methodName = invokeMethodName;
		} else {
			methodName = (String) columnMethodMap.get(columnName);
		}
       	try {

            Method o1_Method = o1.getClass().getMethod(methodName, null);
            Method o2_Method = o2.getClass().getMethod(methodName, null);

            if(o1_Method.getReturnType().getName().equalsIgnoreCase("java.util.Date")){

              Date temp1 = (Date) o1_Method.invoke(o1, null);
              Date temp2 = (Date) o2_Method.invoke(o2, null);
              rslt1 = convertToString(temp1);
              rslt2 = convertToString(temp1);
		    }else{
              if(o1_Method.getReturnType().getName().equalsIgnoreCase("java.lang.Integer")){
                  Integer temp1 = (Integer) o1_Method.invoke(o1, null);
                  Integer temp2 = (Integer) o2_Method.invoke(o2, null);
                  rslt1 = convertToString(temp1);
                  rslt2 = convertToString(temp1);
		      }else{
			      rslt1 = (String) o1_Method.invoke(o1, null);
                  rslt2 = (String) o2_Method.invoke(o2, null);
		      }
		    }


            if(rslt1==null) {
				rslt1 = ApplicationConstants.EMPTY_STRING;
			}
            if(rslt2==null) {
				rslt2 = ApplicationConstants.EMPTY_STRING;
			}
            comp1 = rslt1.toUpperCase().trim();
            comp2 = rslt2.toUpperCase().trim();
        } catch (NoSuchMethodException e) {
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {}
                 Comparable c1 = (Comparable) comp1;
                 Comparable c2 = (Comparable) comp2;
                 if(sortAscIndicator) {
					 return c1.compareTo(c2) * ASCENDING;
				 }else{
					 return c1.compareTo(c2) * DESCENDING;
				 }
        }


       	public boolean equals(Object obj) {
             return this.equals(obj);
        }

  private String convertToString(Object temp){
	  String returnVal;
	  try{
		  returnVal = temp.toString();
	  }catch(NullPointerException ex) {
		  returnVal = ApplicationConstants.EMPTY_STRING;
	  }

	  return returnVal;
  }

  public void showMethods(Object o) {
      Class c = o.getClass();
      Method[] theMethods = c.getMethods();
      for (int i = 0; i < theMethods.length; i++) {
         String methodString = theMethods[i].getName();
         System.out.println("Name: " + methodString);
         String returnString =
           theMethods[i].getReturnType().getName();
         System.out.println("   Return Type: " + returnString);
         Class[] parameterTypes = theMethods[i].getParameterTypes();
         System.out.print("   Parameter Types:");
         for (int k = 0; k < parameterTypes.length; k ++) {
            String parameterString = parameterTypes[k].getName();
            System.out.print(" " + parameterString);
         }
         System.out.println();
      }
   }

   }

