package gov.nih.nci.iscs.oracle.pgm.service.impl;

import java.sql.Timestamp;

import gov.nih.nci.iscs.oracle.pgm.dataaccess.impl.AssignPDCommandDao;
import gov.nih.nci.iscs.oracle.pgm.service.AssignPDService;

public class AssignPDServiceImpl implements AssignPDService {

	private AssignPDCommandDao assignPDCommandDao;
	
	@Override
	public Object execute(Long oApplId, Long oNpeId, String oCancerActivity, Timestamp oAssignmentDate,
			String oPdTransferCode, String oUserId) {
		String actionResult = (String) assignPDCommandDao.execute(oApplId, oNpeId, oCancerActivity, oAssignmentDate, oPdTransferCode, oUserId);
		//TODO Call Web Service to update PCC Code.  In case of error, throw an exception and it will Roll back the DB also.
		return actionResult;
	}

	public AssignPDCommandDao getAssignPDCommandDao() {
		return assignPDCommandDao;
	}

	public void setAssignPDCommandDao(AssignPDCommandDao assignPDCommandDao) {
		this.assignPDCommandDao = assignPDCommandDao;
	}

}
