package gov.nih.nci.iscs.oracle.pgm.forms;


import java.util.*;
import java.util.Date;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm ;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.servlet.http.HttpServletRequest;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.GrantQueryObject;
import gov.nih.nci.iscs.oracle.pgm.actions.helper.SearchGrantsActionHelper;

import java.sql.Timestamp;


public class RetrieveGrantsForm extends ValidatorForm  implements GrantQueryObject {


    private String[]  tp;
    private String[] mech;
    private String[]  icd;
    private String[]  srl;
    private String[]  year;
    private String[]  suffix;
    private String tpIndexed;
    private String mechIndexed;
    private String icdIndexed;
    private String srlIndexed;
    private String yearIndexed;
    private String suffixIndexed;

    private String applId;
    private String projectTitle;
    private String piLastName;
    private String piFirstName;
    private String instName;
    private String instCity;
    private String instState;
    private String rfaPa;
    private String ncabFromDate;
    private String ncabToDate;
    private String fyFrom;
    private String fyTo;
    private String ipf;
    private String cancerActivity;
    private String requestAction;
    private String grantsFromCriteria;
    private String sortColumn;
    private String sortOrder;
    private String pageAction;
    private String gotoPageNumber;
    private  List queryResults;
    private String selectedKey;
    private boolean grantSelected;
    private String selectedPageSize;
    private String listGenerated;
    private boolean sortActionSelected;
    private boolean searchButtonInitiated;;
    private  Integer[] selectedIndx;
    private String reportSelected;
    private String formatSelected;
    private String reportSelectedLo;
    private String formatSelectedLo;
    private String timestamp;
    private boolean sortAscendingIndicator;

    public RetrieveGrantsForm() {
        super();
        this.requestAction = "initialize";
        this.sortOrder = ApplicationConstants.SORT_ASC;
        this.sortColumn = ApplicationConstants.FULL_GRANT_NUMBER_SORT;
        Integer pageSize = new Integer(ApplicationConstants.DEFAULT_PAGE_SIZE);
        this.selectedPageSize = new Integer(ApplicationConstants.DEFAULT_PAGE_SIZE).toString();
  	    this.listGenerated = "N";
  	    this.sortAscendingIndicator = true;
  	    this.queryResults = (List) new ArrayList();
  	    this.sortActionSelected = false;
		Timestamp ts = new Timestamp(new Date().getTime());
		timestamp = ts.toString();
		initializeArrays();

	}
    /*
    public ActionErrors validate(ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
        ActionErrors aes = null;
        boolean noErrors = true;
        aes = super.validate(mapping, request);
        System.out.println("**** now in validate method ****" + aes.toString() );
        if (aes.empty())
            return null;
         return aes;
    } */

    public void reset(ActionMapping mapping, HttpServletRequest request){
		super.reset(mapping, request);
		setToNull();
	}


    public String getTpIndexed(int index) {
      return  tp[index];
    }

    public void setTpIndexed(int index, String tp) {
      this.tp[index] = tp;
    }

    public String[] getTp() {
      return tp;
    }

    public void setTp(String[] tp) {
	  this.tp = tp;
    }

    public String getMechIndexed(int index) {
      return mech[index];
    }

    public void setMechIndexed(int index, String mech) {
      this.mech[index] = mech;
    }

    public String[] getMech() {
      return mech;
    }

    public void setMech(String[] mech) {
      this.mech = mech;
    }

    public String getIcdIndexed(int index) {
      return icd[index];
    }

    public void setIcdIndexed(int index, String icd) {
      this.icd[index] = icd;
    }

    public String[] getIcd() {
      return icd;
    }

    public void setIcd(String[] icd) {
      this.icd = icd;
    }

    public String getSrlIndexed(int index) {
      return srl[index];
    }

    public void setSrlIndexed(int index, String srl) {
      this.srl[index] = srl;
    }


    public String[] getSrl() {
      return srl;
    }

    public void setSrl(String[] srl) {
      this.srl = srl;
    }

    public String getYearIndexed(int index) {
      return year[index];
    }

    public void setYearIndexed(int index, String year) {
      this.year[index] = year;
    }

    public String[] getYear() {
      return year;
    }

    public void setYear(String[] year) {
      this.year = year;
    }

    public String getSuffixIndexed(int index) {
      return suffix[index];
    }

    public void setSuffixIndexed(int index, String suffix) {
      this.suffix[index] =  suffix;
    }

    public String[] getSuffix() {
      return suffix;
    }

    public void setSuffix(String[] suffix) {
      this.suffix = suffix;
    }

    public String getApplId() {
	  if (applId==null)
		  return ApplicationConstants.EMPTY_STRING;
      return applId;
    }

    public void setApplId(String applId) {
      this.applId = applId;
    }

    public String getProjectTitle() {
	  if (projectTitle==null)
		  return ApplicationConstants.EMPTY_STRING;
      return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
      this.projectTitle = projectTitle;
    }

    public String getIpf() {
      if (ipf==null)
   		  return ApplicationConstants.EMPTY_STRING;
      return ipf;
    }

    public void setIpf(String ipf) {
      if (ipf==null)
    		  ipf = ApplicationConstants.EMPTY_STRING;
      this.ipf = ipf;
   }


    public String getPiLastName() {
      if (piLastName==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return piLastName;
    }

    public void setPiLastName(String piLastName) {
      this.piLastName = piLastName;
    }

    public String getPiFirstName() {
      if (piFirstName==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return piFirstName;
    }

    public void setPiFirstName(String piFirstName) {
      this.piFirstName = piFirstName;
    }

    public String getInstName() {
      if (instName==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return instName;
    }

    public void setInstName(String instName) {
      this.instName = instName;
    }

    public String getInstCity() {
      if (instCity==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return instCity;
    }

    public void setInstCity(String instCity) {
      this.instCity = instCity;
    }

    public String getInstState() {
      if (instCity==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return instState;
    }

    public void setInstState(String instState) {
      this.instState = instState;
    }

    public String getNcabFromDate() {
      if (ncabFromDate==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return ncabFromDate;
    }

    public void setNcabFromDate(String ncabFromDate) {
      this.ncabFromDate = ncabFromDate;
    }

    public String getNcabToDate() {
      if (ncabToDate==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return ncabToDate;
    }

    public void setNcabToDate(String ncabToDate) {
      this.ncabToDate = ncabToDate;
    }

    public String getFyFrom() {
      if (fyFrom==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return fyFrom;
    }

    public void setFyFrom(String fyFrom) {
      this.fyFrom = fyFrom;
    }

    public String getFyTo() {
      if (fyTo==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return fyTo;
    }

    public void setFyTo(String fyTo) {
      this.fyTo = fyTo;
    }


    public String getCancerActivity() {
      if (cancerActivity==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return cancerActivity;
    }

    public void setCancerActivity(String cancerActivity) {
      this.cancerActivity = cancerActivity;
    }


   public String getRfaPa() {
      if (rfaPa==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return rfaPa;
    }

    public void setRfaPa(String rfaPa) {
      this.rfaPa = rfaPa;
    }


    public String getRequestAction() {
      if (requestAction==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return requestAction;
    }

    public void setRequestAction(String requestAction) {
      this.requestAction = requestAction;
    }

    public String getGrantsFromCriteria() {
      if (grantsFromCriteria==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return grantsFromCriteria;
    }

    public void setGrantsFromCriteria(String grantsFromCriteria) {
      this.grantsFromCriteria = grantsFromCriteria;
    }

    public String getSortColumn() {
      if (sortColumn==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
      this.sortColumn = sortColumn;
    }


    public String getSortOrder() {
      if (sortOrder==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
      this.sortOrder = sortOrder;
    }

    public String getPageAction() {
      if (pageAction==null)
    		  return ApplicationConstants.EMPTY_STRING;
      return pageAction;
    }

    public void setPageAction(String pageAction) {
      this.pageAction = pageAction;
    }

    public String getGotoPageNumber() {
	  if (gotoPageNumber==null)
		  return ApplicationConstants.EMPTY_STRING;
      return gotoPageNumber;
    }

    public void setGotoPageNumber(String gotoPageNumber) {
      this.gotoPageNumber = gotoPageNumber;
    }


    public void setQueryResults(List queryResults) {
		this.queryResults = queryResults;
	}

	public List getQueryResults() {
		return queryResults;
	}


    public void setSelectedKey(String selectedKey) {
		this.selectedKey = selectedKey;
	}

	public String getSelectedKey() {
	  if (selectedKey==null)
		  return ApplicationConstants.EMPTY_STRING;
		return selectedKey;
	}

    public void setSelectedPageSize(String selectedPageSize) {
		this.selectedPageSize = selectedPageSize;
	}

	public String getSelectedPageSize() {
	  if (selectedPageSize==null)
		  return ApplicationConstants.EMPTY_STRING;
		return selectedPageSize;
	}
	public int getSelectedPageSize_int() {
	  if (selectedPageSize==null || this.selectedPageSize.equalsIgnoreCase(ApplicationConstants.EMPTY_STRING))
		  new Integer(ApplicationConstants.DEFAULT_PAGE_SIZE).intValue();
		return new Integer(selectedPageSize).intValue();
	}

    public void setGrantSelected(boolean grantSelected) {
		this.grantSelected = grantSelected;
	}

	public boolean getGrantSelected() {
		return grantSelected;
	}

    public void setSortActionSelected(boolean sortActionSelected) {
		this.sortActionSelected = sortActionSelected;
	}

	public boolean getSortActionSelected() {
		return sortActionSelected;
	}

    public void setSearchButtonInitiated(boolean searchButtonInitiated) {
		this.searchButtonInitiated = searchButtonInitiated;
	}

	public boolean getSearchButtonInitiated() {
		return searchButtonInitiated;
	}

    public void setSelectedIndx(Integer[] selectedIndx) {
		this.selectedIndx = selectedIndx;
	}

	public Integer[] getSelectedIndx() {
		return selectedIndx;
	}

    public void setListGenerated(String listGenerated) {
		this.listGenerated = listGenerated;
	}

	public String getListGenerated() {
	  if (listGenerated==null)
		  return ApplicationConstants.EMPTY_STRING;
		return listGenerated;
	}

    public void setReportSelected(String reportSelected) {
		this.reportSelected = reportSelected;
	}

	public String getReportSelected() {
	  if (reportSelected==null)
		  return ApplicationConstants.EMPTY_STRING;
		return reportSelected;
	}

    public void setFormatSelected(String formatSelected) {
		this.formatSelected = formatSelected;
	}

	public String getFormatSelected() {
	  if (formatSelected==null)
		  return ApplicationConstants.EMPTY_STRING;
		return formatSelected;
	}


     public void setReportSelectedLo(String reportSelectedLo) {
		this.reportSelectedLo = reportSelectedLo;
	}

	public String getReportSelectedLo() {
	  if (reportSelectedLo==null)
		  return ApplicationConstants.EMPTY_STRING;
		return reportSelectedLo;
	}

    public void setFormatSelectedLo(String formatSelectedLo) {
		this.formatSelectedLo = formatSelectedLo;
	}

	public String getFormatSelectedLo() {
	  if (formatSelectedLo==null)
		  return ApplicationConstants.EMPTY_STRING;
		return formatSelectedLo;
	}

    public String getTimestamp(){
		return timestamp;
	}

    public void setIcdIndexed(String icdIndexed) {
      this.icdIndexed = icdIndexed;
    }
    public String getIcdIndexed() {
      return icdIndexed;
    }

    public void setSortAscendingIndicator(boolean sortAscendingIndicator) {
		this.sortAscendingIndicator = sortAscendingIndicator;
	}

	public boolean getSortAscendingIndicator() {
		return sortAscendingIndicator;
	}


    public void reset(){
	}


    public void copyForms (RetrieveGrantsForm destForm) {

		 int arraySize  = this.mech.length;
		 destForm.tp = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
		 destForm.mech = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
		 destForm.icd = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
		 destForm.srl = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
		 destForm.year = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
		 destForm.suffix = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
		 for(int index = 0; index<arraySize; index++ ) {
			 destForm.tp[index] = (String) this.tp[index];
			 destForm.icd[index] = this.icd[index];
			 destForm.mech[index] = this.mech[index];
			 destForm.srl[index] = this.srl[index];
			 destForm.year[index] = this.year[index];
			 destForm.suffix[index] = this.suffix[index];
		 }

		 destForm.applId = this.applId;
		 destForm.projectTitle = this.projectTitle;
		 destForm.piLastName = this.piLastName;
		 destForm.piFirstName  = this.piFirstName;
		 destForm.instName = this.instName;
		 destForm.instCity = this.instCity;
		 destForm.instState = this.instState;;
		 destForm.rfaPa = this.rfaPa;
		 destForm.ncabFromDate = this.ncabFromDate;
		 destForm.ncabToDate = this.ncabToDate;
		 destForm.fyFrom = this.fyFrom;
		 destForm.fyTo = this.fyTo;
		 destForm.ipf = this.ipf;
		 destForm.cancerActivity = this.cancerActivity;
		 destForm.requestAction = this.requestAction;
		 destForm.grantsFromCriteria = this.grantsFromCriteria;
		 destForm.sortColumn = this.sortColumn;
		 destForm.sortOrder = this.sortOrder;
		 destForm.pageAction = this.pageAction;
		 destForm.gotoPageNumber = this.gotoPageNumber;
		 destForm.queryResults = this.queryResults;
		 destForm.selectedKey = this.selectedKey;
		 destForm.grantSelected = this.grantSelected;
		 destForm.selectedPageSize = this.selectedPageSize;
		 destForm.listGenerated = this.gotoPageNumber;
		 destForm.sortActionSelected = this.sortActionSelected;
		 destForm.searchButtonInitiated = this.searchButtonInitiated;

		 arraySize = this.selectedIndx.length;
		 destForm.selectedIndx = new Integer[arraySize];
		 for(int index = 0; index<arraySize; index++ ) {
		     destForm.selectedIndx[index] = this.selectedIndx[index];
	     }

	     destForm.reportSelected = this.reportSelected;
		 destForm.formatSelected = this.formatSelected;
		 destForm.reportSelectedLo = this.reportSelectedLo;
		 destForm.formatSelectedLo = this.formatSelectedLo;

	}

	public void setToNull(){

		 tp = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
		 mech = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
		 icd = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
		 srl = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
		 year = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
		 suffix = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
		 applId = ApplicationConstants.EMPTY_STRING;
		 projectTitle = ApplicationConstants.EMPTY_STRING;
		 piLastName = ApplicationConstants.EMPTY_STRING;
		 piFirstName = ApplicationConstants.EMPTY_STRING;
		 instName = ApplicationConstants.EMPTY_STRING;
		 instCity = ApplicationConstants.EMPTY_STRING;
		 instState = ApplicationConstants.EMPTY_STRING;
		 rfaPa = ApplicationConstants.EMPTY_STRING;
		 ipf = ApplicationConstants.EMPTY_STRING;
		 ncabFromDate = ApplicationConstants.EMPTY_STRING;
		 ncabToDate = ApplicationConstants.EMPTY_STRING;
		 fyFrom = ApplicationConstants.EMPTY_STRING;
		 fyTo = ApplicationConstants.EMPTY_STRING;
		 cancerActivity = ApplicationConstants.EMPTY_STRING;
		 requestAction = ApplicationConstants.EMPTY_STRING;
		 grantsFromCriteria = ApplicationConstants.EMPTY_STRING;
		 sortColumn = ApplicationConstants.EMPTY_STRING;
		 sortOrder = ApplicationConstants.EMPTY_STRING;
		 pageAction = ApplicationConstants.EMPTY_STRING;
		 gotoPageNumber = ApplicationConstants.EMPTY_STRING;
         selectedPageSize = new Integer(ApplicationConstants.DEFAULT_PAGE_SIZE).toString();
		 listGenerated = ApplicationConstants.EMPTY_STRING;
		 reportSelected = ApplicationConstants.EMPTY_STRING;
		 formatSelected = ApplicationConstants.EMPTY_STRING;
		 reportSelectedLo = ApplicationConstants.EMPTY_STRING;
		 formatSelectedLo = ApplicationConstants.EMPTY_STRING;
  	     selectedIndx = new Integer[new Integer(ApplicationConstants.DEFAULT_PAGE_SIZE).intValue()];
         queryResults = new ArrayList();
    }


    public String toString() {
       return new ToStringBuilder(this)
           .append("tp ", getTp())
           .append("icd ", getIcd())
           .append("srl ", getSrl())
           .append("year ", getYear())
           .append("suffix ", getSuffix())
           .append("applId ", getApplId())
           .append("projectTitle ", getProjectTitle())
           .append("piLastName ", getPiLastName())
           .append("piFirstName ", getPiFirstName())
           .append("instName ", getInstName())
           .append("instCity ", getInstCity())
           .append("instState ", getInstState())
           .append("ncabFromDate ", getNcabFromDate())
           .append("ncabToDate ", getNcabToDate())
           .append("fyFrom ", getFyFrom())
           .append("fyTo ", getFyTo())
           .append("ipf ", getIpf())
           .append("cancerActivity ", getCancerActivity())
           .append("RequestAction ", getRequestAction())
           .append("SortColumn ", getSortColumn())
           .append("SortOrder ", getSortOrder())
           .append("GotoPageNumber ", getGotoPageNumber())
           .append("selectedKey ", getSelectedKey())
           .append("selectedPageSize ", getSelectedPageSize())
           .append("GrantSelected ", getGrantSelected())
           .append("SortActionSelected ", getSortActionSelected())
           .append("SearchButtonInitiated ", getSearchButtonInitiated())
           .append("listGenerated ", getListGenerated())
           .append("selectedIndx ", getSelectedIndx())
           .append("selectedIndx size", getSelectedIndx().length)
           .append("queryResults ", getQueryResults())
           .append("reportSelected ", getReportSelected())
           .append("formatSelected ", getFormatSelected())
           .append("reportSelectedLo ", getReportSelectedLo())
           .append("formatSelectedLo ", getFormatSelectedLo())
           .append("sortAscendingIndicator ", getSortAscendingIndicator())
           .append("timestamp ", getTimestamp())
           .toString();

	 }

    /*
     * Checks all the search columns, and returns null if they are all null
     * @return boolean - false if any of the search column is not null;
     */
    public boolean isNull() {
	   return false;
	  // never return true
	  /*

      try{

		if (applId != null & applId.trim().length() > 0)
		    return false;

		if (cancerActivity != null & cancerActivity.trim().length() > 0 )
		    return false;

		if (ncabFromDate != null & ncabFromDate.trim().length() > 0)
		    return false;

		if (ncabToDate != null & ncabToDate.trim().length() > 0 )
		    return false;

	    if (rfaPa != null & rfaPa.trim().length() > 0 )
		    return false;

		if (fyFrom != null & fyFrom.trim().length() > 0 )
		    return false;

		if (fyTo != null & fyTo.trim().length() > 0 )
		    return false;

	    if (projectTitle != null & projectTitle.trim().length() > 0)
		    return false;

	    if (piLastName != null & piLastName.trim().length() > 0)
		    return false;

		if (piFirstName != null  & piFirstName.trim().length() > 0 )
		    return false;

		if (instName != null   & instName.trim().length() > 0)
		    return false;

		if (instCity != null   & instCity.trim().length() > 0)
		    return false;

		if (instState != null  & instState.trim().length() > 0 )
		    return false;

		if (ipf != null  & ipf.trim().length() > 0 )
		    return false;

		if (tp != null  & tp.trim().length() > 0 )
		    return false;

		if (mech != null  & mech.trim().length() > 0 )
		    return false;

		if (icd != null  & icd.trim().length() > 0 )
		    return false;

		if (srl != null  & srl.trim().length() > 0 )
		    return false;

		if (year != null  & year.trim().length() > 0 )
		    return false;

		if (suffix != null  & suffix.trim().length() > 0 )
		    return false;

      } catch (Exception ex) {
		  return false;
	  }

        return true;
      */
	}
public List validate(List validationMessages) {


	   //ArrayList validationMessages = new ArrayList();
	   boolean validateFyRange = true;
	   boolean valiadateNcabRange = true;

       /*if( this.fyFrom.length() > 0) {
           if(!SearchGrantsActionHelper.validateFiscalYear(this.fyFrom )) {
			   validationMessages.add("errors.search.fyFrom.format");
			   validateFyRange = false;
		   }
	   }*/

       /*if( this.srl.length() > 0 ) {
           if(!SearchGrantsActionHelper.validateIntegerFields(this.srl )) {
			   validationMessages.add("errors.search.serialnumber.format");
			   validateFyRange = false;
		   }
	   }

       if( this.year.length() > 0 ) {
           if(!SearchGrantsActionHelper.validateIntegerFields(this.year)) {
			   validationMessages.add("errors.search.supportyear.format");
			   validateFyRange = false;
		   }
	   }*/

       if( this.applId.length() > 0 ) {
           if(!SearchGrantsActionHelper.validateLongFields(this.applId)) {
			   validationMessages.add("errors.search.applid.format");
			   validateFyRange = false;
		   }
	   }

       if( this.ipf.length() > 0 ) {
           if(!SearchGrantsActionHelper.validateLongFields(this.ipf)) {
			  validationMessages.add("errors.search.ipf.format");
			   validateFyRange = false;
		   }
	   }

       if( this.fyFrom.length() > 0) {
           if(!SearchGrantsActionHelper.validateFiscalYear(this.fyFrom) ) {
			  validationMessages.add("errors.search.fyFrom.format");
			   validateFyRange = false;
		   }
          if( this.fyTo.length() <= 0) {
			  setFyTo(fyFrom);
		  }
	   }

       if( this.fyTo.length() > 0) {
           if(!SearchGrantsActionHelper.validateFiscalYear(this.fyTo) ) {
			  validationMessages.add("errors.search.fyTo.format");
			   validateFyRange = false;
		   }
          /*if( this.fyFrom.length() <= 0) {
			  setFyFrom(fyTo);
		  }*/

	   }


       if(validateFyRange) {
          if( this.fyTo.length() > 0  & this.fyFrom.length() > 0) {
              if(!SearchGrantsActionHelper.validateFiscalYearRange(this.fyFrom, this.fyTo) ){
			     validationMessages.add("errors.search.fy.daterange");
		      }
	      }
	   }

       if( this.ncabFromDate.length() > 0) {
          if( this.ncabToDate.length() <= 0) {
			  setNcabToDate(ncabFromDate);
		  }
	   }

       if( this.ncabToDate.length() > 0) {
          /*if( this.ncabFromDate.length() <= 0) {
			  setNcabFromDate(ncabToDate);
		  }*/
	   }

	   if(this.ncabFromDate.length() > 0 & this.ncabToDate.length() > 0) {
           if(!SearchGrantsActionHelper.validateNcabRange(this.ncabFromDate, this.ncabToDate) ){
			   validationMessages.add("errors.search.ncab.daterange");
	      }
	   }

       return validationMessages;
   }


   private void initializeArrays() {

        this.tp = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
        this.mech = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
        this.icd = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
        this.srl = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
        this.year = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];
        this.suffix = new String[ApplicationConstants.MAX_GRANT_NUM_INDEX];

  	    for (int indx=0; indx<ApplicationConstants.MAX_GRANT_NUM_INDEX; indx++) {
			this.tp[indx] =  new String(ApplicationConstants.EMPTY_STRING);
			this.mech[indx] =  new String(ApplicationConstants.EMPTY_STRING);
			this.icd[indx] =  new String(ApplicationConstants.EMPTY_STRING);
			this.srl[indx] =  new String(ApplicationConstants.EMPTY_STRING);
			this.year[indx] =  new String(ApplicationConstants.EMPTY_STRING);
			this.suffix[indx] =  new String(ApplicationConstants.EMPTY_STRING);
		}
  	    this.selectedIndx = new Integer[new Integer(ApplicationConstants.DEFAULT_PAGE_SIZE).intValue()];
  	    for (int indx=0; indx<selectedIndx.length; indx++) {
			this.selectedIndx[indx] = new Integer("0");
		}

	}

	protected boolean validGrantNumber() {
  	    for (int indx=0; indx<ApplicationConstants.MAX_GRANT_NUM_INDEX; indx++) {
			if(this.tp[indx].equalsIgnoreCase(ApplicationConstants.EMPTY_STRING)   &&
			   this.mech[indx].equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) &&
			   this.icd[indx].equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) &&
			   this.srl[indx].equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) &&
			   this.year[indx].equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) &&
			   this.suffix[indx].equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ) {

		    }else {
				return true;
			}
		}
	    return false;

	}
	protected boolean validSrlNumber() {
  	    for (int indx=0; indx<ApplicationConstants.MAX_GRANT_NUM_INDEX; indx++) {
			if(this.srl[indx].equalsIgnoreCase(ApplicationConstants.EMPTY_STRING) ) {
		    }else {
				return true;
			}
		}
	    return false;

	}


}