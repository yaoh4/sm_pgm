package gov.nih.nci.iscs.oracle.pgm.test;


import gov.nih.nci.iscs.oracle.pgm.test.*;
import org.springframework.orm.hibernate.LocalSessionFactoryBean;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.orm.hibernate.SessionHolder;
import net.sf.hibernate.Session;

import java.text.*;
import java.util.*;
import gov.nih.nci.iscs.oracle.pgm.context.ApplicationContextFactory;

public class MultiAcceptReferal extends Thread {

    private int delay;
    private Long oApplId;
    private Long oNpeId;


    public MultiAcceptReferal(int delayTime, Long aAppliId, Long aNpeId) {
       delay = delayTime;
       oApplId = aAppliId;
       oNpeId = aNpeId;
    }

    public void run() {

        int i=0;
        try {
            for (i=0;i<20;i++) {
              //AcceptReferalTest mAcceptReferalTest = new AcceptReferalTest();
              //mAcceptReferalTest.acceptReferal(oApplId + i, oNpeId + i , i);
              //mAcceptReferalTest.acceptReferal(oApplId, oNpeId, i);
              sleep(delay); // wait until next time
		    }
        } catch (InterruptedException e) {
            return; // end this thread;
        } catch (Exception e) {
		    System.out.println("***** exception is ****" + e.toString());
	    }

    }
    public static void main(String[] args) {
		 Long mApplId = null;
         Long  mNpeId  = null;
         mApplId = new Long(args[0]);
	     mNpeId  = new Long(args[1]);
        new MultiAcceptReferal(3, mApplId, mNpeId).start(); // 1/30 second
    }
}


