package gov.nih.nci.iscs.oracle.pgm.businessobject;

import java.util.List;
import java.util.Iterator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.sql.DataSource;
import net.sf.hibernate.HibernateException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.core.SqlParameter;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.GrantReferalDao;
import org.springframework.orm.hibernate.HibernateTemplate;
import org.springframework.orm.hibernate.SessionFactoryUtils;
import org.springframework.orm.hibernate.support.HibernateDaoSupport;
import gov.nih.nci.iscs.oracle.pgm.hibernate.ProcessStatusesT;
import gov.nih.nci.iscs.oracle.pgm.hibernate.ProcessStatusesTPK;
import gov.nih.nci.iscs.oracle.pgm.hibernate.ApplProcessStatusesT;
import net.sf.hibernate.Hibernate;

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
		grantReferalDao = grantReferalDao;
    }

}