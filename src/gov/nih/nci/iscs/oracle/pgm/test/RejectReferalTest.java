package gov.nih.nci.iscs.oracle.pgm.test;


import gov.nih.nci.iscs.oracle.pgm.actions.SearchGrantsAction;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RejectReferalCommand;
import gov.nih.nci.iscs.oracle.pgm.factory.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class RejectReferalTest {

   private RejectReferalCommand oGrantReferal;
   private static Logger logger = LogManager.getLogger(RejectReferalTest.class);
   
   public RejectReferalTest(){}

   public String rejectReferal(Long aAppliId, String aComments){

	   String mResults = new String ("");

	   try {

		   oGrantReferal = (RejectReferalCommand)  InitContext.getBean("rejectReferalCommandDao");
		   //oGrantReferal.setApplId(aAppliId);
		   //oGrantReferal.setComments(aComments);
           mResults = (String) oGrantReferal.execute(aAppliId, aComments, "");

       } catch (Exception ex) {
		   logger.error("**** exceptions  is ****" + ex.toString() );

       }

       return mResults;
  }


  public static void main(String[] args)
						throws Exception {

      RejectReferalTest GRTest = new RejectReferalTest();
      String results = null;
      Long mApplId = null;
      String  mComments  = null;


	  if (args.length < 2) {

	    	System.exit(0);
      }
      // 1. set the values

	  mApplId = new Long(args[0]);
	  mComments  = new String(args[1]);
      try{
          results = GRTest.rejectReferal(mApplId, mComments);
      } catch (Exception e) {
          logger.error("***** exception is ****" + e.toString());
      }


  }


}
