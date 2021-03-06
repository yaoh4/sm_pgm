package gov.nih.nci.iscs.oracle.pgm.service.impl;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

import gov.nih.nci.iscs.oracle.pgm.service.impl.BaseServiceImpl;
import gov.nih.nci.iscs.oracle.pgm.util.ActiveLabelValueBean;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveProgamDirectorInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveProgamDirectorsInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrievePDOrgInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrievePDCancerActivityInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrievePDInfoForAssignmentCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.resources.RetrieveActivePDInfoCommand;
import gov.nih.nci.iscs.oracle.pgm.dataaccess.query.QueryPage;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.exceptions.*;
import gov.nih.nci.iscs.oracle.pgm.hibernate.PdCaAsgnmtVw;
import gov.nih.nci.iscs.oracle.pgm.hibernate.PdOrgVw4;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;
import org.apache.commons.lang.StringUtils;

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

	public List getPDForTransfer(String cancerActivity, boolean showInactivePDs) {
		logger.debug("getPDForTransfer('" + cancerActivity + "', " + showInactivePDs + ")");
		List<LabelValueBean> mLabelValueBeanList = new ArrayList<LabelValueBean>();
		List<LabelValueBean> mActiveList = new ArrayList<LabelValueBean>();
		List<LabelValueBean> mInactiveList = new ArrayList<LabelValueBean>();
		
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

			String pdName = ApplicationConstants.EMPTY_STRING;
			String pdCode = ApplicationConstants.EMPTY_STRING;
			String personId = ApplicationConstants.EMPTY_STRING;
			Iterator mIterator = mList.iterator();
			Set<String> activeSet = new HashSet<String>();
			while (mIterator.hasNext()) {
				HashSet mTempSet = new HashSet();
				PdOrgVw4 mPdOrgVw4 = (PdOrgVw4) mIterator.next();
				if(mPdOrgVw4.isActive()) {
					activeSet.add(mPdOrgVw4.getPdName());
				}
				pdName = mPdOrgVw4.getPdName();
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

			ActiveLabelValueBean mLabelValueBean = null;
			String tmp = null;
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
					tmp = (String) mIter.next();
					if(tmp == null) {
						continue;
					}
					if (firstTime) {
						pdCode = pdCode + tmp;
						firstTime = false;
					} else {
						pdCode = pdCode + ", " + tmp;
					}

				}
				
				mLabelValueBean = new ActiveLabelValueBean(pdName + pdCode + ")", personId);
				tmp = mLabelValueBean.getLabel();
				if(tmp != null && tmp.endsWith("()")) {
					tmp = tmp.substring(0, tmp.length() - 3);
					mLabelValueBean.setLabel(tmp);
				}
				if(activeSet.contains(pdName)) {
					mLabelValueBean.setActive(true);
					mActiveList.add(mLabelValueBean);
				} else {
					mLabelValueBean.setActive(false);
					mInactiveList.add(mLabelValueBean);
				}

				//mLabelValueBeanList.add(mLabelValueBean);
			}
		} catch (Exception ex) {
			throw new ServiceImplException("ProgamDirectorServiceImpl", "getAllProgramDirectors",
					"Unable to obtain Program Director from the database!!! " + ex.toString());
		}
		mLabelValueBeanList.addAll(mActiveList);
		if(showInactivePDs) {
			mLabelValueBeanList.add(new ActiveLabelValueBean("-------- Inactive PDs --------", "-1", false));
			mLabelValueBeanList.addAll(mInactiveList);
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
		logger.info("getCancerActivityForPD('" + key + "')");
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