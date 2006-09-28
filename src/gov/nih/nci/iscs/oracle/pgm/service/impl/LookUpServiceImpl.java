package gov.nih.nci.iscs.oracle.pgm.service.impl;

import java.util.List;

import gov.nih.nci.iscs.oracle.pgm.service.impl.BaseServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveLookUpCommand;

import gov.nih.nci.iscs.oracle.pgm.exceptions.*;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * A jdbc implementation of the UserHandler interface.
 * @author Oracle
 */
public class LookUpServiceImpl extends BaseServiceImpl
{
    static Logger logger = LogManager.getLogger(LookUpServiceImpl.class);



    public LookUpServiceImpl(Object oContextFactory ) {
		super(oContextFactory);
	}


    public List getLookUpTable(String[] LookUpTableVales) {
	  try{
		  RetrieveLookUpCommand oRetrieveLookUpCommand = (RetrieveLookUpCommand) getBean("retrieveLookUpCommandDao");

          List oLookUpTableValues = 
                oRetrieveLookUpCommand.execute(LookUpTableVales[0], (String) LookUpTableVales[1], super.getUserId());
           // get the list from the page
          return oLookUpTableValues;

      } catch (Exception ex) {
			 throw new ServiceImplException("LookUpServiceImpl", "getLookUpTable", "An exception occurred in LookUp process!!! " + ex.toString());

	  }
  }


}