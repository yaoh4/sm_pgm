package gov.nih.nci.iscs.oracle.pgm.service.impl;

import java.util.*;

import gov.nih.nci.iscs.oracle.pgm.service.impl.BaseServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveAppLinksCommand;
import gov.nih.nci.iscs.oracle.pgm.hibernate.GwbLinksT;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/**
 * A jdbc implementation of the UserHandler interface.
 * @author Oracle
 */
public class ApplicationLinksServiceImpl extends BaseServiceImpl
{
    static Logger logger = LogManager.getLogger(ApplicationLinksServiceImpl.class);



    public ApplicationLinksServiceImpl(Object oContextFactory) {
		super(oContextFactory);
	}


    public Map getApplicationLinks() {
		HashMap mApplicationLinks = new HashMap();
		ArrayList mReturnList = new ArrayList();
		  try{
             RetrieveAppLinksCommand oRetrieveAppLinksCommand = (RetrieveAppLinksCommand) getBean("retrieveAppLinksCommandDao");
             QueryPage  aActiveCAQueryPage = oRetrieveAppLinksCommand.execute();
            // get the list from the page
             ArrayList mList =  (ArrayList) aActiveCAQueryPage.getList();
		     Iterator mIterator = mList.iterator();
		     while(mIterator.hasNext()){
				 GwbLinksT mGwbLinksT = (GwbLinksT) mIterator.next();
	             mApplicationLinks.put(mGwbLinksT.getName(), mGwbLinksT);
			 }
		  } catch (Exception ex) {
			 throw new ServiceImplException("ApplicationLinksServiceImpl", "getApplicationLinks", "Unable to obtain Application Links from the database!!! " + ex.toString());
	      }
	       return mApplicationLinks;
    }





}