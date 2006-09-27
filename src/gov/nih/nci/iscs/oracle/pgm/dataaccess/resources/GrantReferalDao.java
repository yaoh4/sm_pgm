package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;


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