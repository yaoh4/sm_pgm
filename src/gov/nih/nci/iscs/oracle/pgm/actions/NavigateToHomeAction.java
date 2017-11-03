package gov.nih.nci.iscs.oracle.pgm.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class NavigateToHomeAction extends NciPgmAction {

	public ActionForward executeAction(ActionMapping actionmapping, ActionForm actionform,
			HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws Exception {
		return actionmapping.findForward("success");
	}

}
