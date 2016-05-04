package gov.nih.nci.iscs.oracle.pgm.tag;

import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;

import gov.nih.nci.iscs.oracle.pgm.actions.helper.ActiveLabelValueBean;
//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForPDAForm;
import gov.nih.nci.iscs.oracle.pgm.service.impl.ProgamDirectorServiceImpl;
import org.springframework.context.ApplicationContext;
import java.util.*;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
//Application imports

public class FormatProgramDirectorSelectTagDual extends TagSupport {
	
	private static final Logger logger = Logger.getLogger(FormatProgramDirectorSelectTagDual.class);

	private String key;
	private String key2;
	private String cancerActivity;
	private ApplicationContext mApplicationContext;
	boolean disableSelect = false;
	boolean active = false;
	private String myid;

	public void setKey(String key) {

		logger.debug("setKey('" + key + "'");
		this.key = key;
	}
	
	public void setKey2(String key2) {
		logger.debug("setKey2('" + key2 + "'");
		this.key2 = key2;
	}

	public int doStartTag() {
		try {
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			JspWriter out = pageContext.getOut();
			ServletContext sc = pageContext.getServletContext();
			mApplicationContext = (ApplicationContext) sc.getAttribute(ApplicationConstants.PGM_CONTEXT_FACTORY);
			RetrieveGrantsForPDAForm mRetrieveGrantsForPDAForm = (RetrieveGrantsForPDAForm) request
					.getAttribute("retrieveGrantsForPDAForm");
			this.cancerActivity = mRetrieveGrantsForPDAForm.getCancerActivity();
			this.key = mRetrieveGrantsForPDAForm.getPdId();
			this.key2 = mRetrieveGrantsForPDAForm.getPdId2();
			StringBuffer buf = new StringBuffer();
			if (cancerActivity == null) {
				cancerActivity = ApplicationConstants.EMPTY_STRING;
			}

			if (!cancerActivity.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)) {
				List mList = getPDListForCancerActivity(cancerActivity);
				if (mList.size() > 0) {
					formatEmptySelect(buf, mList);
				} else {
					disableSelect = true;
				}
			}

			if (cancerActivity.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) || disableSelect) {
				List mList = (List) request.getSession().getAttribute(LookUpTableConstants.PD_NAME_VW4_LOOKUP[0]);
				if (mList == null) {
					mList = getPDListForCancerActivity(ApplicationConstants.EMPTY_STRING);
					request.getSession().setAttribute(LookUpTableConstants.PD_NAME_VW4_LOOKUP[0], mList);
				}
				//List mList = (List) request.getAttribute(LookUpTableConstants.PD_NAME_VW4_LOOKUP[0]);
				formatEmptySelect(buf, mList);
			}

			out.print(buf.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	private StringBuffer formatEmptySelect(StringBuffer buf, List mList) {

		if (disableSelect) {
			buf.append("<SELECT style=\"width: 100%\" NAME=\"" + myid + "\" SIZE=\"1\" DISABLED=true>");
			disableSelect = false;
		} else {
			buf.append("<SELECT style=\"width: 100%\" NAME=\"" + myid
					+ "\" SIZE=\"1\" onchange=\"setPDAction('continue')\">");
		}
		buf.append("<option SELECTED value=");
		buf.append(ApplicationConstants.EMPTY_STRING);
		buf.append(">");
		buf.append(ApplicationConstants.EMPTY_STRING);
		buf.append("</option>\n");
		Iterator mIterator = mList.iterator();

		while (mIterator.hasNext()) {
			ActiveLabelValueBean mLookUpValueBean = (ActiveLabelValueBean) mIterator.next();
			if (!(mLookUpValueBean.getActive()) == active)
				continue;
			String mValue = mLookUpValueBean.getValue();
			String mLabel = mLookUpValueBean.getLabel();
			if ((mValue.equalsIgnoreCase(key) && active) || (mValue.equalsIgnoreCase(key2) && !active)) {
				buf.append("<option SELECTED value=");
			} else {
				buf.append("<option value=");
			}
			buf.append(mValue);
			buf.append(">");
			buf.append(mLabel);
			buf.append("</option>");
		}

		return buf;
	}

	private StringBuffer formatSelectForCA(String cancerActivity, StringBuffer buf, List mList) {

		buf.append("<SELECT NAME=\"pdId\" SIZE=\"1\" onchange=\"setPDAction('continue')\">");
		buf.append("<option SELECTED value=");
		buf.append(ApplicationConstants.EMPTY_STRING);
		buf.append(">");
		buf.append(ApplicationConstants.EMPTY_STRING);
		buf.append("</option>\n");

		Iterator mIterator = mList.iterator();

		while (mIterator.hasNext()) {
			LabelValueBean mLookUpValueBean = (LabelValueBean) mIterator.next();
			String mValue = mLookUpValueBean.getValue();
			String mLabel = mLookUpValueBean.getLabel();
			if (mValue.equalsIgnoreCase(key)) {
				buf.append("<option SELECTED value=");
			} else {
				buf.append("<option value=");
			}
			buf.append(mValue);
			buf.append(">");
			buf.append(mLabel);
			buf.append("</option>");
		}

		return buf;
	}

	private List getPDListForCancerActivity(String cancerActivity) {

		// get the lookup infomation
		ProgamDirectorServiceImpl mProgamDirectorServiceImpl = new ProgamDirectorServiceImpl(mApplicationContext);
		List mList = mProgamDirectorServiceImpl.getPDForTransfer(cancerActivity, false, false);
		return mList;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getMyid() {
		return myid;
	}

	public void setMyid(String myid) {
		this.myid = myid;
	}

}
