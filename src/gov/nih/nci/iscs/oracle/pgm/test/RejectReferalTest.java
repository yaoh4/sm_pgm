package gov.nih.nci.iscs.oracle.pgm.test;


import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RejectReferalCommand;
import gov.nih.nci.iscs.oracle.pgm.factory.*;


public class RejectReferalTest {

   private RejectReferalCommand oGrantReferal;

   public RejectReferalTest(){}

   public String rejectReferal(Long aAppliId, String aComments){

	   String mResults = new String ("");

	   try {

		   oGrantReferal = (RejectReferalCommand)  InitContext.getBean("rejectReferalCommandDao");
		   //oGrantReferal.setApplId(aAppliId);
		   //oGrantReferal.setComments(aComments);
           mResults = (String) oGrantReferal.execute(aAppliId, aComments, "");

           System.out.println("******* REJECT REFERAL MESSAGE IS ******" + mResults );

       } catch (Exception ex) {
		   System.out.println("**** exceptions  is ****" + ex.toString() );

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
	    	System.out.println("Usage : java RejectReferal \n"+
			                            "       Appl Id\n"+
			                            "       NPE Id\n");

	    	System.exit(0);
      }
      // 1. set the values

	  mApplId = new Long(args[0]);
	  mComments  = new String(args[1]);
      try{
          results = GRTest.rejectReferal(mApplId, mComments);
          System.out.println("******* REJECT REFERAL MESSAGE IS ******" + results);
      } catch (Exception e) {
          System.out.println("***** exception is ****" + e.toString());
      }


  }


}
