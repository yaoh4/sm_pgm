package gov.nih.nci.iscs.oracle.pgm.test;


import gov.nih.nci.iscs.oracle.pgm.actions.SearchGrantsAction;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveGrantsForPDACommand;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class RetrieveGrantsForPDATest {

   private RetrieveGrantsForPDACommand oGrantRetrieval;
   private static Logger logger = LogManager.getLogger(RetrieveGrantsForPDATest.class);

   public RetrieveGrantsForPDATest(){}

   public String retrieveGrantsForPDA(String aGrantNumber, String aGroupCode, int aPageNumber){

	   String mResults = new String ("");

	   try {
		   /*
		   oGrantRetrieval = (RetrieveGrantsForPDACommand)  InitContext.getBean("retrieveGrantsForPDACommandDao");
		   GrantsForPDAQueryObject mGrantsForPDAQueryObject = new GrantsForPDAQueryObject();
		   mGrantsForPDAQueryObject.setApplId(aGrantNumber);
		   mGrantsForPDAQueryObject.setGroupCode(aGroupCode);
		   mGrantsForPDAQueryObject.getPaginationObject().setPageNumber(new Integer(aPageNumber));
           QueryPage  aGrantsQueryPage = oGrantRetrieval.execute(null, mGrantsForPDAQueryObject,
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

      RetrieveGrantsForPDATest GRTest = new RetrieveGrantsForPDATest();
      String results = null;
      String mGrantNumber = null;
      int  mPageNumber  = 0;


	  if (args.length < 2) {

	    	System.exit(0);
      }
      // 1. set the values

	  mGrantNumber = new String (args[0]);
	  mPageNumber  = new Integer (args[1]).intValue();
	  String mGroupCode = new String (args[2]);
      try{
          results = GRTest.retrieveGrantsForPDA(mGrantNumber, mGroupCode, mPageNumber);
      } catch (Exception e) {
          logger.error("***** exception is ****" + e.toString());
      }


  }


}
