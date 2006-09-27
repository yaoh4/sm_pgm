package gov.nih.nci.iscs.oracle.pgm.businessobject;


public interface GrantReferal  {

    //public List getAllAcceptedReferals();
    //public List getAllRejectedReferals();
    public String acceptReferal(Long aApplId, Long aNpeId);
    //public boolean rejectReferal(Long aApplId);
}