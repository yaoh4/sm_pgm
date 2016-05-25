package gov.nih.nci.iscs.oracle.pgm.service;


public interface AssignPDService {

    public Object execute(Long oApplId, Long oNpeId, String oCancerActivity,
                           java.sql.Timestamp oAssignmentDate, String oPdTransferCode, String oUserId);


}