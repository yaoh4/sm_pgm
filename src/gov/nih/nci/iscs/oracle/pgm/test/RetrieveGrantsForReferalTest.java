package gov.nih.nci.iscs.oracle.pgm.test;


import gov.nih.nci.iscs.oracle.pgm.actions.SearchGrantsAction;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveGrantsForReferalCommand;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class RetrieveGrantsForReferalTest {

   private RetrieveGrantsForReferalCommand oGrantRetrieval;
   private static Logger logger = LogManager.getLogger(RetrieveGrantsForReferalTest.class);
   
   public RetrieveGrantsForReferalTest(){}

   public String retrieveGrantsForReferal(String aGrantNumber, Integer aFiscalYearFrom, int aPageNumber){

	   String mResults = new String ("");

	   try {
	       /*oGrantReferal = (AcceptReferalCommand) ApplicationContextFactory.getApplicationContext().getBean("acceptReferalCommandDao");
		   oGrantRetrieval = (RetrieveGrantsForReferalCommand)  InitContext.getBean("retrieveGrantsForReferalCommandDao");
		   GrantsForReferalQueryObject mGrantsForReferalQueryObject = new GrantsForReferalQueryObject();
		   mGrantsForReferalQueryObject.setApplId(aGrantNumber);
		   mGrantsForReferalQueryObject.setFyFrom(aFiscalYearFrom.toString());
		   mGrantsForReferalQueryObject.getPaginationObject().setPageNumber(new Integer(aPageNumber));
           QueryPage  aGrantsQueryPage = oGrantRetrieval.execute(null, mGrantsForReferalQueryObject,
                                         new Integer(aPageNumber), new Integer(aPageNumber));
           // get the list from the page
           List mList =  aGrantsQueryPage.getList();
           Iterator mIterator = mList.iterator();
           while (mIterator.hasNext() ) {
			   NciPdQueryVw mGrant = (NciPdQueryVw) mIterator.next();
			   System.out.println("*** the element is ****" + mGrant.getApplId() );
		   }

           System.out.println("******* RETRIEVAL  MESSAGE IS ******" + mResults + " " + aGrantsQueryPage );
            */
       } catch (Exception ex) {
		   logger.error("**** exceptions  is ****" + ex.toString() );

       }

       return mResults;
  }


  public static void main(String[] args)
						throws Exception {

      RetrieveGrantsForReferalTest GRTest = new RetrieveGrantsForReferalTest();
      String results = null;
      String mGrantNumber = null;
      int  mPageNumber  = 0;


	  if (args.length < 2) {

	    	System.exit(0);
      }
      // 1. set the values

	  mGrantNumber = new String (args[0]);
	  mPageNumber  = new Integer (args[1]).intValue();
	  Integer mFiscalYearFrom = new Integer (args[2]);
      try{
          results = 
                    GRTest.retrieveGrantsForReferal(mGrantNumber, mFiscalYearFrom, mPageNumber);
      } catch (Exception e) {
          logger.error("***** exception is ****" + e.toString());
      }


  }


}
