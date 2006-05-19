package gov.nih.nci.iscs.oracle.pgm.service;
//**************************************
// Name: A simple universal comparator
// Description:You can use this class to sort an array of Objects without creating custom
// Comparators for each field. For example, if you have a class Employee,
// with methods getName() and getSalary(),
// you can simply do Arrays.sort(myEmployeeArray, new UniversalComparator("getName", 1)) or Arrays.sort(myEmployeeArray, new UniversalComparator("getSalary", -1)). The first statement would sort your array in ascending order by the value of getName() method, the second would sort it in descending order by the value of getSalary() method. The class uses the reflection API to accomplish this task.
// By: Lone Deranger
//
//
// Inputs:None
//
// Returns:None
//
//Assumes:You need to import java.util.Arrays, java.util.Comparator in order to use Arrays.sort(). The return value of your Object's methods MUST implement the Comparable interface.
//
//Side Effects:None
//This code is copyrighted and has limited warranties.
//Please see http://www.1JavaStreet.com/xq/ASP/txtCodeId.3308/lngWId.2/qx/vb/scripts/ShowCode.htm
//for details.
//**************************************

import java.lang.Object;
import java.lang.reflect.*;
import java.util.Comparator;


    public class UniversalComparator extends Object implements Comparator {
    	private String methodName = "toString";
    	private int descAscIndicator = 1;

    	public static final int ASCENDING = 1;
    	public static final int DESCENDING = -1;



        	public UniversalComparator(int descAscIndicator) {
        		this.descAscIndicator = descAscIndicator;
        	}



            	public UniversalComparator(String methodName, int descAscIndicator) {
            		this(descAscIndicator);
            		this.methodName = methodName;
            	}



                	public int compare(Object o1, Object o2) {
                		Object comp1 = null;
                		Object comp2 = null;


                    		try {
                    		Method o1_Method = o1.getClass().getMethod(methodName, null);
                    		Method o2_Method = o2.getClass().getMethod(methodName, null);
                    		comp1 = o1_Method.invoke(o1, null);
                    		comp2 = o2_Method.invoke(o2, null);



                        		} catch (NoSuchMethodException e) {


                            		} catch (IllegalAccessException e) {
                            		} catch (InvocationTargetException e) {}
                            		Comparable c1 = (Comparable) comp1;
                            		Comparable c2 = (Comparable) comp2;
                            		return c1.compareTo(c2) * descAscIndicator;
                            	}



                                	public boolean equals(Object obj) {
                                		return this.equals(obj);
                                	}
                            }

