package gov.nih.nci.iscs.oracle.pgm.tag;

import org.apache.struts.util.LabelValueBean;

//Jdk Imports
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.constants.LookUpTableConstants;
import gov.nih.nci.iscs.oracle.pgm.forms.RetrieveGrantsForPDAForm;
import gov.nih.nci.iscs.oracle.pgm.service.impl.ProgamDirectorServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.util.ActiveLabelValueBean;

import org.springframework.context.ApplicationContext;
import java.util.*;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;

import org.apache.log4j.*;
//Application imports

public class FormatProgramDirectorSelectTag extends TagSupport {

	private String key;
	private String cancerActivity;
	private ApplicationContext mApplicationContext;
	boolean disableSelect = false;
	private boolean showInactivePDs;
	
	private static final Logger log = Logger.getLogger(FormatProgramDirectorSelectTag.class);

	public void setKey(String key) {

		this.key = key;
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
			this.showInactivePDs = mRetrieveGrantsForPDAForm.getShowInactivePDs();

			StringBuffer buf = new StringBuffer();
			if (cancerActivity == null) {
				cancerActivity = ApplicationConstants.EMPTY_STRING;
			}
			
			// If user has selected a cancer activity, perform a search.  If there are no
			// results, set disableSelect to true.  See formatEmptySelect below for how
			// disableSelect is used.
			if (!cancerActivity.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)) {
				List mList = getPDListForCancerActivity(cancerActivity);
				if (mList.size() > 0) {
					formatEmptySelect(buf, mList);
				} else {
					// This happens if the search returns no results
					disableSelect = true;
				}
			}
			
			// If the cancer activity is empty, or we performed a search above and got no results,
			// check the list that we've stored in the session.  If that list is null or empty,
			// run a new search with an empty string.
			
			// NOTE: in order for the 'Show Inactive PDs' toggle to work correctly when no CA has been
			// selected, we have to force a new search each time. 
			if (cancerActivity.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) || disableSelect) {
				log.debug("if block: CA='" + cancerActivity + "', disableSelect: " + disableSelect);
				List mList = (List) request.getSession().getAttribute(LookUpTableConstants.PD_NAME_VW4_LOOKUP[0]);
				//if (mList == null || mList.isEmpty()) {
					mList = getPDListForCancerActivity(ApplicationConstants.EMPTY_STRING);
					request.getSession().setAttribute(LookUpTableConstants.PD_NAME_VW4_LOOKUP[0], mList);
				//}
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
			buf.append("<SELECT style=\"width: 100%\" NAME=\"pdId\" SIZE=\"1\" DISABLED=true>");
			disableSelect = false;
		} else {
			buf.append("<SELECT style=\"width: 100%\" NAME=\"pdId\" SIZE=\"1\" onchange=\"setPDAction('continue')\">");
		}
		buf.append("<option SELECTED value=");
		buf.append(ApplicationConstants.EMPTY_STRING);
		buf.append(">");
		buf.append(ApplicationConstants.EMPTY_STRING);
		buf.append("</option>\n");
		Iterator mIterator = mList.iterator();

		while (mIterator.hasNext()) {
			ActiveLabelValueBean mLookUpValueBean = (ActiveLabelValueBean) mIterator.next();
			String mValue = mLookUpValueBean.getValue();
			String mLabel = mLookUpValueBean.getLabel();
			String style = "";
			if (!mLookUpValueBean.isActive())
				style = "style=\"font-style: italic; font-weight: bold;\"";
			if (mValue.equalsIgnoreCase(key)) {
				buf.append("<option " + style + " SELECTED value=");
			} else if (mValue.equals("-1")) {
				buf.append("<option " + style + " DISABLED value=");
			} else {
				buf.append("<option " + style + " value=");
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
		List mList = mProgamDirectorServiceImpl.getPDForTransfer(cancerActivity, showInactivePDs);
		return mList;
	}

}