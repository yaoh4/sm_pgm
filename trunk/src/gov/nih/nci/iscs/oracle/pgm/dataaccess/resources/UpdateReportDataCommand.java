package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;


public interface UpdateReportDataCommand extends ActionCommand {

    public Object execute(String mSessionId, Long mReportId, Long mApplId, String mAction, String oUserId, 
        String reportType);
    //public void setApplId(Long aApplId);
    //public void setNpeId (Long aNpeId);

}