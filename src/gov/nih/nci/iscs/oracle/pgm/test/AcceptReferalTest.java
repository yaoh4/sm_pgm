package gov.nih.nci.iscs.oracle.pgm.test;


import gov.nih.nci.iscs.oracle.pgm.actions.SearchGrantsAction;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.AcceptReferalCommand;
import gov.nih.nci.iscs.oracle.pgm.factory.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class AcceptReferalTest {

   private AcceptReferalCommand oGrantReferal;
   private static Logger logger = LogManager.getLogger(AcceptReferalTest.class);
   
   public AcceptReferalTest(){}

   public String AcceptReferal(Long aAppliId, Long aNpeId){

	   String mResults = "false";

	   try {

		   oGrantReferal = (AcceptReferalCommand)  InitContext.getBean("AcceptReferalCommandDao");
		   //oGrantReferal.setApplId(aAppliId);
		   //oGrantReferal.setNpeId(aNpeId);
           mResults = (String) oGrantReferal.execute(aAppliId, aNpeId, "","");


       } catch (Exception ex) {
		   logger.error("**** exceptions  is ****" + ex.toString() );

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
	    	System.exit(0);
      }
      // 1. set the values

	  mApplId = new Long(args[0]);
	  mNpeId  = new Long(args[1]);
      try{
          results =  GRTest.AcceptReferal(mApplId, mNpeId);
      } catch (Exception e) {
            logger.error("***** exception is ****" + e.toString());
      }


  }


}
