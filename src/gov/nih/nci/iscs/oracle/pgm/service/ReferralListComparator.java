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
    // the following is a fix for sorting grantNumber, fullGrantNum and default
    private String getAdminPhsOrgCode_Method = "getAdminPhsOrgCode";
    private String getActivityCode_Method = "getActivityCode";
    private String getSerialNum_Method = "getSerialNum";
    private String getSupportYear_Method = "getSupportYear";
    private String getSuffixCode_Method = "getSuffixCode";

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
        columnMethodMap.put("rfaPaNumber", "getRfapa");
        columnMethodMap.put("currentReferralActivityDate", 
                            "getCurrentReferralActivityDate");
    }


    public ReferralListComparator(boolean sortAscIndicator) {
        this.sortAscIndicator = sortAscIndicator;
    }


    public ReferralListComparator(String columnName, 
                                  boolean sortAscIndicator) {
        this.sortAscIndicator = sortAscIndicator;
        this.columnName = columnName;
    }

    public ReferralListComparator(String columnName, boolean sortAscIndicator, 
                                  String invokeMethodName) {
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
        if (columnName == null) {
            methodName = invokeMethodName;
        } else {
            methodName = (String)columnMethodMap.get(columnName);
        }
        try {
            Method o1_Method = o1.getClass().getMethod(methodName, null);
            Method o2_Method = o2.getClass().getMethod(methodName, null);
            Method o11_Method = 
                o1.getClass().getMethod(getAdminPhsOrgCode_Method, null);
            Method o21_Method = 
                o2.getClass().getMethod(getAdminPhsOrgCode_Method, null);
            Method o12_Method = 
                o1.getClass().getMethod(getActivityCode_Method, null);
            Method o22_Method = 
                o2.getClass().getMethod(getActivityCode_Method, null);

            Method o13_Method = 
                o1.getClass().getMethod(getSerialNum_Method, null);
            Method o23_Method = 
                o2.getClass().getMethod(getSerialNum_Method, null);
            Method o14_Method = 
                o1.getClass().getMethod(getSupportYear_Method, null);
            Method o24_Method = 
                o2.getClass().getMethod(getSupportYear_Method, null);
            Method o15_Method = 
                o1.getClass().getMethod(getSuffixCode_Method, null);
            Method o25_Method = 
                o2.getClass().getMethod(getSuffixCode_Method, null);

            if (o1_Method.getReturnType().getName().equalsIgnoreCase("java.util.Date")) {

                Date temp1 = (Date)o1_Method.invoke(o1, null);
                Date temp2 = (Date)o2_Method.invoke(o2, null);
                rslt1 = convertToString(temp1);
                rslt2 = convertToString(temp2);
            } else {
                if (o1_Method.getReturnType().getName().equalsIgnoreCase("java.lang.Integer")) {
                    Integer temp1 = (Integer)o1_Method.invoke(o1, null);
                    Integer temp2 = (Integer)o2_Method.invoke(o2, null);
                    rslt1 = convertToString(temp1);
                    rslt2 = convertToString(temp2);
                } else {
                    rslt1 = (String)o1_Method.invoke(o1, null);
                    rslt2 = (String)o2_Method.invoke(o2, null);


                }
            }


            if (rslt1 == null) {
                rslt1 = ApplicationConstants.EMPTY_STRING;
            }
            if (rslt2 == null) {
                rslt2 = ApplicationConstants.EMPTY_STRING;
            }

            if (methodName.equalsIgnoreCase("getGrantNumber")) {


                rslt1 = 
                        (String)o11_Method.invoke(o1, null) + (String)o12_Method.invoke(o1, 
                                                                                        null) + 
                        convertToStringForSerialNum((Integer)o13_Method.invoke(o1, 
                                                                               null)) + 
                        convertToStringForSupportYear((Integer)o14_Method.invoke(o1, 
                                                                                 null)) + 
                        convertToStringForSuffix((String)o15_Method.invoke(o1, 
                                                                           null));


                rslt2 = 
                        (String)o21_Method.invoke(o2, null) + (String)o22_Method.invoke(o2, 
                                                                                        null) + 
                        convertToStringForSerialNum((Integer)o23_Method.invoke(o2, 
                                                                               null)) + 
                        convertToStringForSupportYear((Integer)o24_Method.invoke(o2, 
                                                                                 null)) + 
                        convertToStringForSuffix((String)o25_Method.invoke(o2, 
                                                                           null));
            } else if (methodName.equalsIgnoreCase("getNcabDate")) {
                rslt1 = 
                        reformat(rslt1) + (String)o11_Method.invoke(o1, null) + (String)o12_Method.invoke(o1, 
                                                                                                          null) + 
                        convertToStringForSerialNum((Integer)o13_Method.invoke(o1, 
                                                                               null)) + 
                        convertToStringForSupportYear((Integer)o14_Method.invoke(o1, 
                                                                                 null)) + 
                        convertToStringForSuffix((String)o15_Method.invoke(o1, 
                                                                           null));
                rslt2 = 
                        reformat(rslt2) + (String)o21_Method.invoke(o2, null) + (String)o22_Method.invoke(o2, 
                                                                                                          null) + 
                        convertToStringForSerialNum((Integer)o23_Method.invoke(o2, 
                                                                               null)) + 
                        convertToStringForSupportYear((Integer)o24_Method.invoke(o2, 
                                                                                 null)) + 
                        convertToStringForSuffix((String)o25_Method.invoke(o2, 
                                                                           null));

            } else {

                rslt1 = 
                        rslt1 + (String)o11_Method.invoke(o1, null) + (String)o12_Method.invoke(o1, 
                                                                                                null) + 
                        convertToStringForSerialNum((Integer)o13_Method.invoke(o1, 
                                                                               null)) + 
                        convertToStringForSupportYear((Integer)o14_Method.invoke(o1, 
                                                                                 null)) + 
                        convertToStringForSuffix((String)o15_Method.invoke(o1, 
                                                                           null));
                rslt2 = 
                        rslt2 + (String)o21_Method.invoke(o2, null) + (String)o22_Method.invoke(o2, 
                                                                                                null) + 
                        convertToStringForSerialNum((Integer)o23_Method.invoke(o2, 
                                                                               null)) + 
                        convertToStringForSupportYear((Integer)o24_Method.invoke(o2, 
                                                                                 null)) + 
                        convertToStringForSuffix((String)o25_Method.invoke(o2, 
                                                                           null));
            }
            comp1 = rslt1.toUpperCase().trim();
            comp2 = rslt2.toUpperCase().trim();
        } catch (NoSuchMethodException e) {
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
        }
        Comparable c1 = (Comparable)comp1;
        Comparable c2 = (Comparable)comp2;
        if (sortAscIndicator) {
            return c1.compareTo(c2) * ASCENDING;
        } else {
            return c1.compareTo(c2) * DESCENDING;
        }
    }


    public boolean equals(Object obj) {
        return this.equals(obj);
    }

    private String convertToString(Object temp) {
        String returnVal;
        try {
            returnVal = temp.toString();
        } catch (NullPointerException ex) {
            returnVal = ApplicationConstants.EMPTY_STRING;
        }

        return returnVal;
    }

    private String convertToStringForSupportYear(Object temp) {
        String returnVal;
        try {
            if (temp.toString().length() == 1)
                returnVal = "0" + temp.toString();
            else
                returnVal = temp.toString();
        } catch (NullPointerException ex) {
            returnVal = ApplicationConstants.EMPTY_STRING;
        }

        return returnVal;
    }

    private String convertToStringForSuffix(String temp) {
        String returnVal;
        try {
            if (temp == null || temp.length() == 0) {
                returnVal = "ZZ";
            } else {
                returnVal = temp.toString();
            }
        } catch (NullPointerException ex) {
            returnVal = ApplicationConstants.EMPTY_STRING;
        }

        return returnVal;
    }

    private String convertToStringForSerialNum(Integer SerialNum) {
        String returnVal = null;
        int SerialNumLength = SerialNum.toString().length();

        switch (SerialNumLength) {
        case 1:
            returnVal = "00000" + SerialNum.toString();            
            break;
        case 2:
            returnVal = "0000" + SerialNum.toString();            
            break;
        case 3:
            returnVal = "000" + SerialNum.toString();            
            break;
        case 4:
            returnVal = "00" + SerialNum.toString();
            break;
        case 5:
            returnVal = "0" + SerialNum.toString();
            break;
        case 6:
            returnVal = SerialNum.toString();            
            break;
        }

        return returnVal;
    }

    public void showMethods(Object o) {
        Class c = o.getClass();
        Method[] theMethods = c.getMethods();
        for (int i = 0; i < theMethods.length; i++) {
            String methodString = theMethods[i].getName();
            System.out.println("Name: " + methodString);
            String returnString = theMethods[i].getReturnType().getName();
            System.out.println("   Return Type: " + returnString);
            Class[] parameterTypes = theMethods[i].getParameterTypes();
            System.out.print("   Parameter Types:");
            for (int k = 0; k < parameterTypes.length; k++) {
                String parameterString = parameterTypes[k].getName();
                System.out.print(" " + parameterString);
            }
            System.out.println();
        }
    }

    private String reformat(String temp) {
        if (temp != null && temp.length() != 0)
            temp = temp.substring(3, 7) + "/" + temp.substring(0, 2);
        else
            temp = "9000/12";
        return temp;
    }

}

