package gov.nih.nci.iscs.oracle.pgm.test;


import java.io.InputStream;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.AcceptReferalCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.AcceptReferalCommandDao;
import gov.nih.nci.iscs.oracle.pgm.factory.*;

import java.text.*;
import java.util.*;


public class AcceptReferalTest {

   private AcceptReferalCommand oGrantReferal;

   public AcceptReferalTest(){}

   public String AcceptReferal(Long aAppliId, Long aNpeId){

	   String mResults = "false";

	   try {

		   oGrantReferal = (AcceptReferalCommand)  InitContext.getBean("AcceptReferalCommandDao");
		   //oGrantReferal.setApplId(aAppliId);
		   //oGrantReferal.setNpeId(aNpeId);
           mResults = (String) oGrantReferal.execute(aAppliId, aNpeId, "");

           System.out.println("******* Accept REFERAL MESSAGE IS ******" + mResults );

       } catch (Exception ex) {
		   System.out.println("**** exceptions  is ****" + ex.toString() );

       }

       return mResults;
  }


  public static void main(String[] args)
						throws Exception {

      AcceptReferalTest GRTest = new AcceptReferalTest();
      String results = "false";
      Long mApplId = null;
      Long  mNpeId  = null;


	  if (args.length < 2) {
	    	System.out.println("Usage : java AcceptReferal \n"+
			                            "       Appl Id\n"+
			                            "       NPE Id\n");

	    	System.exit(0);
      }
      // 1. set the values

	  mApplId = new Long(args[0]);
	  mNpeId  = new Long(args[1]);
      try{
          results =  GRTest.AcceptReferal(mApplId, mNpeId);
          System.out.println("******* Accept REFERAL MESSAGE IS ******" + results);
      } catch (Exception e) {
          System.out.println("***** exception is ****" + e.toString());
      }


  }


}
