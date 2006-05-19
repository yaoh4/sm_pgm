package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;


public interface RejectReferalCommand extends ActionCommand {

    //public void setApplId(Long aApplId);
    //public void setComments (String aComments);
    public Object execute(Long aApplId, String aComments, String oUserId);



}