package gov.nih.nci.iscs.oracle.pgm.businessobject;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.GrantReferalDao;

public class GrantReferalImpl implements  GrantReferal{

   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    private GrantReferalDao grantReferalDao;

    public String acceptReferal(Long aApplId, Long aNpeId) {
       System.out.println("**** passed step 2 ****" + grantReferalDao);

       //return grantReferalDao.acceptReferal(aApplId, aNpeId);
       return "test";

    }

    public GrantReferalDao getGrantReferalDao(){
		return grantReferalDao;
    }

    public  void setGrantReferalDao(GrantReferalDao grantReferalDao){
		this.grantReferalDao = grantReferalDao;
    }

}