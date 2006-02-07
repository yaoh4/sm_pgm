package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.orm.hibernate.support.HibernateDaoSupport;
import net.sf.hibernate.Session;

public interface GrantReferalDao {

    //public List getAllAcceptedReferals();
    //public List getAllRejectedReferals();
    public String acceptReferal(Long aApplId, Long aNpeId);
    public String rejectReferal(Long aApplId, Long aOrgId);
    public String acceptReferralSP(Long aApplId, Long aNpeId);
    public void setThisSession(Session aSession);
    public Session getThisSession();


    //public String rejectReferralSP(Long aApplId, Long aNpeId);
}