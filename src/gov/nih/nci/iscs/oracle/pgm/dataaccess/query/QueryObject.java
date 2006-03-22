package gov.nih.nci.iscs.oracle.pgm.dataaccess.query;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import gov.nih.nci.iscs.oracle.pgm.service.GrantQueryObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import gov.nih.nci.iscs.oracle.pgm.forms.PaginationObject;


import java.util.*;


public class QueryObject implements  GrantQueryObject {
   /**
     * GrantsQueryObject encapsulates the processing required for the core Grants search
     * criteria used by the application.
     *
     * @author Michelle Engermann
     * @version 1.0
     */
   /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());


    private String[] tp;
    private String[] mech;
    private String[] icd;
    private String[] srl;
    private String[] year;
    private String[] suffix;
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
    private String action;
    private String grantsFromCriteria;
    private String sortColumn;
    private String sortOrder;
    private PaginationObject paginationObject;
    private List queryResults;

    public static String PERCENT_SYMBOL = "%";

   /*
    * Class constructor
    */
    public QueryObject() {
		// set the default sort colunm for the search criteria
        super();
        this.sortColumn = "applId";
        this.sortOrder = ApplicationConstants.SORT_ASC;
        this.paginationObject = new PaginationObject();
	    this.grantsFromCriteria = ApplicationConstants.ALL_GRANTS;
	}

   public String[] getTp() {

	 return tp;
    }

    public void setTp(String[] tp) {
	  this.tp = tp;
    }

    public String[] getMech() {
      return mech;
    }

    public void setMech(String[] mech) {
      this.mech = mech;
    }

    public String[] getIcd() {
      return icd;
    }

    public void setIcd(String[] icd) {
      this.icd = icd;
    }

    public String[] getSrl() {
      return srl;
    }

    public void setSrl(String[] srl) {
      this.srl = srl;
    }

    public String[] getYear() {
      return year;
    }

    public void setYear(String[] year) {
      this.year = year;
    }

    public String[] getSuffix() {
      return suffix;
    }

    public void setSuffix(String[] suffix) {
      this.suffix = suffix;
    }

    /*
     * Accessor methods for the applId column
     * @return String - Query applId
     */
    public String getApplId() {
		return this.applId;
    }
    /*
     * Mutator method for the GrantNumber column
     * @param aGrantNumber - GrantNumber column
     */
    public void setApplId( String applId) {
		this.applId = applId.trim() + PERCENT_SYMBOL;
    }

    /*
     * Accessor methods for the ipf column
     * @return String - Query ipf
     */

    public String getIpf() {
      if (ipf==null)
   		  return ApplicationConstants.EMPTY_STRING;
      return ipf;
    }

    /*
     * Mutator method for the ipf column
     * @param ipf - ipf column
     */
    public void setIpf(String ipf) {
      if (ipf==null)
    		  ipf = ApplicationConstants.EMPTY_STRING;
      this.ipf = ipf;
   }

    /*
     * Accessor methods for the CancerActivity column
     * @return String - Query CancerActivity
     */
    public String getCancerActivity() {
		return cancerActivity;
	}
    /*
     * Mutator method for the CancerActivity column
     * @param aCancerActivity - CancerActivity column
     */
	public void setCancerActivity(String cancerActivity) {
	     this.cancerActivity = cancerActivity.trim() + PERCENT_SYMBOL;
	}

    /*
     * Accessor methods for the ncabFromDate column
     * @return String - Query ncabFromDate
     */
    public String getNcabFromDate() {
		return this.ncabFromDate;
	}
    /*
     * Mutator method for the NCABFromDate column
     * @param aNCABFromDate - NCABFromDate column
     */
	public void setNcabFromDate(String ncabFromDate) {
	     this.ncabFromDate = ncabFromDate;
	}

    /*
     * Accessor methods for the ncabToDate column
     * @return String - Query ncabToDate
     */
    public String getNcabToDate() {
		return this.ncabToDate;
	}
    /*
     * Mutator method for the NCABFromTo column
     * @param aNCABFromTo - NCABFromTo column
     */
	public void setNcabToDate(String ncabToDate) {
	     this.ncabToDate = ncabToDate;
	}

    public String getProjectTitle() {
	  if (applId==null)
		  return ApplicationConstants.EMPTY_STRING;
      return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
      this.projectTitle = projectTitle;
    }


    /*
     * Accessor methods for the RfaPaNumber column
     * @return String - Query RfaPaNumber
     */
    public String getRfaPa() {
		return this.rfaPa;
	}
    /*
     * Mutator method for the rfaPa column
     * @param aRfaPaNumber - rfaPa column
     */
	public void setRfaPa (String rfaPa) {
	     rfaPa = rfaPa.trim() + PERCENT_SYMBOL;
	}

    /*
     * Accessor methods for the FiscalYearFrom column
     * @return Integer - Query FiscalYearFrom
     */
    public String getFyFrom() {
		return this.fyFrom;
	}
    /*
     * Mutator methods for the FiscalYearFrom column
     * @param aFiscalYearFrom - Query aFiscalYearFrom
     */
	public void setFyFrom(String fyFrom) {
	     this.fyFrom = fyFrom;
	}

   /*
     * Accessor methods for the fyTo column
     * @return oFiscalYearTo - Query fyTo
     */
    public String getFyTo() {
		return this.fyTo;
	}
    /*
     * Mutator methods for the setFiscalYearTo column
     * @param asetFiscalYearTo - Query setFiscalYearTo
     */
	public void setFyTo(String fyTo) {
	     this.fyTo = fyTo;
	}

    /*
     * Accessor methods for the PILastName column
     * @return oPILastName - Query PILastName
     */
    public String getPiLastName() {
		return this.piLastName;
	}
    /*
     * Mutator methods for the PILastName column
     * @param PILastName - Query PILastName
     */
	public void setPiLastName(String piLastName) {
	     this.piLastName = piLastName.trim() + PERCENT_SYMBOL;
	}

    /*
     * Accessor methods for the PILastName column
     * @return oPILastName - Query PILastName
     */
    public String getPiFirstName() {
		return this.piFirstName;
	}
    /*
     * Mutator methods for the PIFirstName column
     * @param PIFirstName - Query PIFirstName
     */
	public void setPiFirstName(String piFirstName) {
	     this.piFirstName = piFirstName.trim() + PERCENT_SYMBOL;
	}

    /*
     * Accessor methods for the InstitutionName column
     * @return oInstitutionName - Query InstitutionName
     */
    public String getInstName() {
		return this.instName;
	}

    /*
     * Mutator methods for the InstitutionName column
     * @param InstitutionName - Query InstitutionName
     */
	public void setInstName(String instName) {
	     this.instName = instName.trim() + PERCENT_SYMBOL;
	}

    /*
     * Accessor methods for the InstitutionCity column
     * @return oInstitutionCity - Query InstitutionCity
     */
    public String getInstCity() {
		return this.instCity;
	}
    /*
     * Mutator methods for the InstitutionCity column
     * @param InstitutionCity - Query InstitutionCity
     */

	public void setInstCity(String instCity) {
	     this.instCity = instCity.trim() + PERCENT_SYMBOL;
	}

    /*
     * Accessor methods for the InstitutionState column
     * @return oInstitutionState - Query InstitutionState
     */
    public String getInstState() {
		return this.instState;
	}
    /*
     * Mutator methods for the InstitutionState column
     * @param InstitutionState - Query InstitutionState
     */
	public void setInstState(String instState) {
	     instState = instState.trim() + PERCENT_SYMBOL;
	}

    /*
     * Accessor methods for the PageNumber column
     * @return PageNumber - Query PaginationObject
     */
    public PaginationObject getPaginationObject() {
		return this.paginationObject;
    }
    /*
     * Mutator methods for the PageNumber column
     * @param PageNumber - Query PageNumber
     */
    public void setPaginationObject( PaginationObject paginationObject) {
		this.paginationObject = paginationObject;
    }


    public String getGrantsFromCriteria() {
	  if (grantsFromCriteria==null)
		  return ApplicationConstants.EMPTY_STRING;
      return grantsFromCriteria;
    }

    public void setGrantsFromCriteria(String grantsFromCriteria) {
      this.grantsFromCriteria = grantsFromCriteria;
    }

    /*
     * Accessor methods for the SortColumn column
     * @return SortColumn - Query SortColumn
     */
    public String getSortColumn() {
		return this.sortColumn;
    }
    /*
     * Mutator methods for the SortColumn column
     * @param SortColumn - Query SortColumn
     */
    public void setSortColumn( String sortColumn) {
		this.sortColumn = sortColumn;
    }

     /*
     * Accessor methods for the SortOrder column
     * @return SortOrder - Query SortOrder
     */
    public String getSortOrder() {
		return this.sortOrder;
    }
    /*
     * Mutator methods for the SortOrder column
     * @param SortOrder - Query SSortOrder
     */
    public void setSortOrder( String sortOrder) {
		this.sortOrder = sortOrder;
    }

   public void setQueryResults(List queryResults) {
		this.queryResults = queryResults;
	}

	public List getQueryResults() {
		return queryResults;
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
            .append("rfaPa ", getRfaPa())
            .append("paginationObject ", getPaginationObject())
            .toString();

 	 }

     /*
      * Checks all the search columns, and returns null if they are all null
      * @return boolean - false if any of the search column is not null;
      */
     public boolean isNull() {
         System.out.println("*** now in the parent method  isNull ****");

 		if (applId != null )
 		    return false;

 		if (cancerActivity != null )
 		    return false;

 		if (ncabFromDate != null )
 		    return false;

 		if (ncabToDate != null )
 		    return false;

 	    if (rfaPa != null )
 		    return false;

 		if (fyFrom != null )
 		    return false;

 		if (fyTo != null )
 		    return false;

 	    if (piLastName != null )
 		    return false;

 		if (piFirstName != null )
 		    return false;

 		if (instName != null )
 		    return false;

 		if (instCity != null )
 		    return false;

 		if (instState != null )
 		    return false;

         return true;

 	}

}