package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;


public interface ReleaseReferalCommand extends ActionCommand {

    //public void setApplId(Long aApplId);
    //public void setCancerActicityCode (String aCancerActicityCode);
    public Object execute(Long aApplId, String aCancerActicityCodes, String oUserId,String readOnly);



}