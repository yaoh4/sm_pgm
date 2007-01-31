package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;


public interface AcceptReferalCommand extends ActionCommand {

    public Object execute(Long aApplId, Long oNpeId, String oUserId);
    //public void setApplId(Long aApplId);
    //public void setNpeId (Long aNpeId);

}