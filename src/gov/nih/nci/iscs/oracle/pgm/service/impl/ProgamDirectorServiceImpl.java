package gov.nih.nci.iscs.oracle.pgm.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;

import gov.nih.nci.iscs.oracle.pgm.actions.helper.ActiveLabelValueBean;
import gov.nih.nci.iscs.oracle.pgm.actions.helper.LabelValueBeanComparator;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveActivePDInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrievePDCancerActivityInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrievePDInfoForAssignmentCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrievePDOrgInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveProgamDirectorInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveProgamDirectorsInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.exceptions.ServiceImplException;
import gov.nih.nci.iscs.oracle.pgm.hibernate.PdCaAsgnmtVw;
import gov.nih.nci.iscs.oracle.pgm.hibernate.PdOrgVw4;

/**
 * A jdbc implementation of the UserHandler interface.
 * 
 * @author Oracle
 */
public class ProgamDirectorServiceImpl extends BaseServiceImpl {
	static Logger logger = LogManager.getLogger(ProgamDirectorServiceImpl.class);

	public ProgamDirectorServiceImpl(Object oContextFactory) {
		super(oContextFactory);
	}

	public List getProgamDirectorForCA(String cancerActivity) {
		ArrayList mLabelValueBeanList = new ArrayList();
		try {
			RetrieveProgamDirectorInfoCommand oRetrieveProgamDirectorInfoCommand = (RetrieveProgamDirectorInfoCommand) getBean(
					"retrieveProgamDirectorInfoCommandDao");

			QueryPage aPDQueryPage = oRetrieveProgamDirectorInfoCommand.execute(cancerActivity, super.getUserId());
			// get the list from the page
			List mList = (ArrayList) aPDQueryPage.getList();
			Iterator mIterator = mList.iterator();
			while (mIterator.hasNext()) {
				PdCaAsgnmtVw mPdCaAsgnmtVw = (PdCaAsgnmtVw) mIterator.next();
				LabelValueBean mLabelValueBean;
				if (cancerActivity == null) {
					mLabelValueBean = new LabelValueBean(
							mPdCaAsgnmtVw.getPdName() + "/" + mPdCaAsgnmtVw.getOrgDesc() + "/"
									+ mPdCaAsgnmtVw.getCayCode(),
							mPdCaAsgnmtVw.getCayCode() + mPdCaAsgnmtVw.getNpeId().toString());
				} else {
					mLabelValueBean = new LabelValueBean(mPdCaAsgnmtVw.getPdName() + "/" + mPdCaAsgnmtVw.getOrgDesc(),
							mPdCaAsgnmtVw.getNpeId().toString());
				}
				mLabelValueBeanList.add(mLabelValueBean);
			}

		} catch (Exception ex) {
			throw new ServiceImplException("ProgamDirectorServiceImpl", "getProgamDirectorForCA",
					"Unable to obtain Program Director from the database!!! " + ex.toString());
		}
		return mLabelValueBeanList;
	}

	public List getProgamDirectorForAllCAs(TreeSet cancerActivities) {
		ArrayList mLabelValueBeanList = new ArrayList();
		try {
			RetrieveProgamDirectorsInfoCommand oRetrieveProgamDirectorsInfoCommand = (RetrieveProgamDirectorsInfoCommand) getBean(
					"retrieveProgamDirectorsInfoCommandDao");

			QueryPage aPDQueryPage = oRetrieveProgamDirectorsInfoCommand.execute(cancerActivities, super.getUserId());
			// get the list from the page
			List mList = (ArrayList) aPDQueryPage.getList();
			Iterator mIterator = mList.iterator();
			while (mIterator.hasNext()) {
				PdCaAsgnmtVw mPdCaAsgnmtVw = (PdCaAsgnmtVw) mIterator.next();
				LabelValueBean mLabelValueBean;
				mLabelValueBean = new LabelValueBean(mPdCaAsgnmtVw.getPdName() + "/" + mPdCaAsgnmtVw.getOrgDesc(),
						mPdCaAsgnmtVw.getNpeId().toString());
				mLabelValueBeanList.add(mLabelValueBean);
			}

		} catch (Exception ex) {
			throw new ServiceImplException("ProgamDirectorServiceImpl", "getProgamDirectorForAllCAs",
					"Unable to obtain Program Director from the database!!! " + ex.toString());
		}
		return mLabelValueBeanList;
	}

	public List getAllProgramDirectors(String cancerActivity, boolean formatPds) {
		ArrayList mLabelValueBeanList = new ArrayList();
		String mViewName = "pdCaAsgnmtVw";
		try {
			RetrievePDInfoForAssignmentCommand oRetrievePDInfoForAssignmentCommand = (RetrievePDInfoForAssignmentCommand) getBean(
					"retrievePDInfoForAssignmentCommandDao");
			QueryPage aPDQueryPage = oRetrievePDInfoForAssignmentCommand.execute(cancerActivity, mViewName,
					super.getUserId());
			// get the list from the page
			List mList = (ArrayList) aPDQueryPage.getList();

			Iterator mIterator = mList.iterator();
			while (mIterator.hasNext()) {
				PdCaAsgnmtVw mPdCaAsgnmtVw = (PdCaAsgnmtVw) mIterator.next();
				LabelValueBean mLabelValueBean = null;
				if (cancerActivity == null || formatPds) {
					mLabelValueBean = new LabelValueBean(
							StringUtils.rightPad(mPdCaAsgnmtVw.getPdName(), 30, ";") + mPdCaAsgnmtVw.getCayCode()
									+ "&nbsp;&nbsp;&nbsp;&nbsp;" + mPdCaAsgnmtVw.getOrgDesc(),
							mPdCaAsgnmtVw.getCayCode() + mPdCaAsgnmtVw.getNpeId().toString());
					mLabelValueBeanList.add(mLabelValueBean);
				}
			}
		} catch (Exception ex) {
			throw new ServiceImplException("ProgamDirectorServiceImpl", "getAllProgramDirectors",
					"Unable to obtain Program Director from the database!!! " + ex.toString());
		}
		return mLabelValueBeanList;
	}

	@SuppressWarnings("unchecked")
	public List getPDForTransfer(String cancerActivity, boolean displayInactive, boolean sortInactive) {
		// TODO Area of Interest
		ArrayList mLabelValueBeanList = new ArrayList();
		TreeMap mTempMap;
		String mViewName = "pdOrgVw4";
		try {
			RetrievePDInfoForAssignmentCommand oRetrievePDInfoForAssignmentCommand = (RetrievePDInfoForAssignmentCommand) getBean(
					"retrievePDInfoForAssignmentCommandDao");
			QueryPage aPDQueryPage = oRetrievePDInfoForAssignmentCommand.execute(cancerActivity, mViewName,
					super.getUserId());
			// get the list from the page
			List mList = aPDQueryPage.getList();
			
			mTempMap = new TreeMap();
			Set<String> activePDs = new HashSet<String>(); 

			String pdName = ApplicationConstants.EMPTY_STRING;
			String pdCode = ApplicationConstants.EMPTY_STRING;
			String personId = ApplicationConstants.EMPTY_STRING;
			Iterator mIterator = mList.iterator();
			while (mIterator.hasNext()) {
				HashSet mTempSet = new HashSet();
				PdOrgVw4 mPdOrgVw4 = (PdOrgVw4) mIterator.next();
				logger.info(mPdOrgVw4);
				pdName = mPdOrgVw4.getPdName();
				if(mPdOrgVw4.isActive()) {
					activePDs.add(mPdOrgVw4.getPdName());
				}
				pdCode = mPdOrgVw4.getPdCode();
				personId = mPdOrgVw4.getPersonId().toString();
				if (mTempMap.containsKey(pdName + "*" + personId)) {
					mTempSet = (HashSet) mTempMap.get(pdName + "*" + personId);
					mTempSet.add(pdCode);
				} else {
					mTempSet.add(pdCode);
				}
				mTempMap.put(pdName + "*" + personId, mTempSet);
			}

			LabelValueBean mLabelValueBean = null;
			for (mIterator = mTempMap.entrySet().iterator(); mIterator.hasNext();) {
				Map.Entry entry = (Map.Entry) mIterator.next();
				String key = (String) entry.getKey();
				Set value = (Set) entry.getValue();
				int index = key.indexOf("*");
				pdName = key.substring(0, index);
				personId = key.substring(index + 1, key.length());
				pdCode = " (";
				boolean firstTime = true;
				for (Iterator mIter = value.iterator(); mIter.hasNext();) {
					if (firstTime) {
						pdCode = pdCode + (String) mIter.next();
						firstTime = false;
					} else {
						pdCode = pdCode + ", " + (String) mIter.next();
					}

				}
				String inactiveIndicator = displayInactive ? (activePDs.contains(pdName) ? "" : " [Inactive]") : "";
				mLabelValueBean = new ActiveLabelValueBean(pdName + pdCode + ")" + inactiveIndicator , personId, activePDs.contains(pdName));
				mLabelValueBeanList.add(mLabelValueBean);
			}
		} catch (Exception ex) {
			throw new ServiceImplException("ProgamDirectorServiceImpl", "getAllProgramDirectors",
					"Unable to obtain Program Director from the database!!! " + ex.toString());
		}
		if(sortInactive) {
			Collections.sort(mLabelValueBeanList);
			int index = 0;
			boolean foundInactive = false;
			for(Iterator i = mLabelValueBeanList.iterator(); i.hasNext();) {
				if(((ActiveLabelValueBean)i.next()).getActive() == false) {
					foundInactive = true;
					break;
				}
				index++;
			}
			if(foundInactive) mLabelValueBeanList.add(index, new ActiveLabelValueBean("-------- Inactive PDs --------", "-1", false));
		}
		return mLabelValueBeanList;
	}
	/*
	 * public List getAllProgramDirectors(String cancerActivity, boolean
	 * mFormatPDs) {
	 * 
	 * this.formatPds = true; List mList =
	 * getAllProgramDirectors(cancerActivity); this.formatPds = false; return
	 * mList; }
	 */

	public List getCancerActivityForPD(String key) {
		ArrayList mLabelValueBeanList = new ArrayList();
		String mLastCayCode = ApplicationConstants.EMPTY_STRING;
		try {
			RetrievePDCancerActivityInfoCommand oRetrievePDCancerActivityInfoCommand = (RetrievePDCancerActivityInfoCommand) getBean(
					"retrievePDCancerActivityInfoCommandDao");
			QueryPage aPDQueryPage = oRetrievePDCancerActivityInfoCommand.execute(key, super.getUserId());
			// get the list from the page
			List mList = (ArrayList) aPDQueryPage.getList();
			if (mList.size() > 1) {
				HashMap mTempMap = new HashMap(mList.size());
				Iterator mIterator = mList.iterator();
				while (mIterator.hasNext()) {
					PdOrgVw4 mPdOrgVw4 = (PdOrgVw4) mIterator.next();
					mTempMap.put(mPdOrgVw4.getCayCode(), mPdOrgVw4);
				}
				mList = new ArrayList(mTempMap.values());
			}
			Iterator mIterator = mList.iterator();
			while (mIterator.hasNext()) {
				PdOrgVw4 mPdOrgVw4 = (PdOrgVw4) mIterator.next();
				if (mPdOrgVw4.getCayCode().equalsIgnoreCase(mLastCayCode)) {
				} else {
					LabelValueBean mLabelValueBean;
					mLabelValueBean = new LabelValueBean(mPdOrgVw4.getCayCode(), mPdOrgVw4.getCayCode());
					mLabelValueBeanList.add(mLabelValueBean);
				}
				mLastCayCode = mPdOrgVw4.getCayCode();
			}

		} catch (Exception ex) {
			throw new ServiceImplException("ProgamDirectorServiceImpl", "getCancerActivityForPD",
					"Unable to obtain Program Director from the database!!! " + ex.toString());
		}
		return mLabelValueBeanList;
	}

	public List getPDOrgForCA(String cancerActivity, String personId) {
		ArrayList mLabelValueBeanList = new ArrayList();
		try {
			RetrievePDOrgInfoCommand oRetrievePDOrgInfoCommand = (RetrievePDOrgInfoCommand) getBean(
					"retrievePDOrgInfoCommandDao");
			QueryPage aPDQueryPage = oRetrievePDOrgInfoCommand.execute(personId, cancerActivity, super.getUserId());
			// get the list from the page
			List mList = (ArrayList) aPDQueryPage.getList();

			Iterator mIterator = mList.iterator();
			while (mIterator.hasNext()) {
				PdOrgVw4 mPdOrgVw4 = (PdOrgVw4) mIterator.next();
				LabelValueBean mLabelValueBean;
				mLabelValueBean = new LabelValueBean(mPdOrgVw4.getOrgDesc(), new Long(mPdOrgVw4.getOrgId()).toString());
				mLabelValueBeanList.add(mLabelValueBean);
			}

		} catch (Exception ex) {
			throw new ServiceImplException("ProgamDirectorServiceImpl", "getCancerActivityForPD",
					"Unable to obtain Program Director from the database!!! " + ex.toString());
		}
		return mLabelValueBeanList;
	}

	public List getAllActiveProgramDirectors(String cancerActivity, boolean formatPds) {
		ArrayList mLabelValueBeanList = new ArrayList();
		try {
			RetrieveActivePDInfoCommand oRetrieveActivePDInfoCommand = (RetrieveActivePDInfoCommand) getBean(
					"retrieveActivePDInfoCommandDao");
			QueryPage aPDQueryPage = oRetrieveActivePDInfoCommand.execute(cancerActivity, super.getUserId());
			// get the list from the page
			List mList = (ArrayList) aPDQueryPage.getList();

			Iterator mIterator = mList.iterator();
			String mPreviousPd = ApplicationConstants.EMPTY_STRING;
			while (mIterator.hasNext()) {
				PdOrgVw4 mPdOrgVw4 = (PdOrgVw4) mIterator.next();
				LabelValueBean mLabelValueBean = null;
				if (cancerActivity == null || formatPds) {
					mLabelValueBean = new LabelValueBean(
							StringUtils.rightPad(mPdOrgVw4.getPdName(), 30, ";") + mPdOrgVw4.getCayCode()
									+ "&nbsp;&nbsp;&nbsp;&nbsp;" + mPdOrgVw4.getOrgDesc(),
							mPdOrgVw4.getCayCode() + mPdOrgVw4.getNpeId().toString());
					mLabelValueBeanList.add(mLabelValueBean);
				} else {
					if (!mPdOrgVw4.getPdName().equalsIgnoreCase(mPreviousPd)) {
						mLabelValueBean = new LabelValueBean(mPdOrgVw4.getPdName(), mPdOrgVw4.getPersonId().toString());
						mPreviousPd = mPdOrgVw4.getPdName();
						mLabelValueBeanList.add(mLabelValueBean);
					}
				}
			}

		} catch (Exception ex) {
			throw new ServiceImplException("ProgamDirectorServiceImpl", "getAllActiveProgramDirectors",
					"Unable to obtain active Program Director from the database!!! " + ex.toString());
		}
		return mLabelValueBeanList;
	}

}