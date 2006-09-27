package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;


public interface AssignPDCommand extends ActionCommand {

    public Object execute(Long oApplId, Long oNpeId, String oCancerActivity,
                           java.sql.Timestamp oAssignmentDate, String oPdTransferCode, String oUserId);


}