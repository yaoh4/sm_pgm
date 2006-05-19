package gov.nih.nci.iscs.oracle.pgm.businessobject;

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


public interface GrantReferal  {

    //public List getAllAcceptedReferals();
    //public List getAllRejectedReferals();
    public String acceptReferal(Long aApplId, Long aNpeId);
    //public boolean rejectReferal(Long aApplId);
}