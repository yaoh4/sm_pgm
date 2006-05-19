package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;


public interface ReReferReferalCommand extends ActionCommand {

    //public void setApplId(Long aApplId);
    //public void setCancerActicityCode (String aCancerActicityCode);
    //public void setComments (String aComments);
    public Object execute(Long aApplId, String aCancerActicityCode, String aComments, String oUserId);



}