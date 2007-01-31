package gov.nih.nci.iscs.oracle.pgm.service;

import java.util.*;

  public interface GrantQueryObject   {


    public String[] getTp();
    public void setTp(String[] tp);

    public String[] getMech();
    public void setMech(String[] mech);


    public String[] getIcd();
    public void setIcd(String[] icd);

    public String[] getSrl();
    public void setSrl(String[] srl);

    public String[] getYear();
    public void setYear(String[] year);

    public String[] getSuffix();
    public void setSuffix(String[] suffix);

    public String getApplId();
    public void setApplId(String applId);

    public String getProjectTitle();
    public void setProjectTitle(String projectTitle);

    public String getPiLastName();
    public void setPiLastName(String piLastName);

    public String getPiFirstName();
    public void setPiFirstName(String piFirstName);

    public String getInstName();
    public void setInstName(String instName) ;

    public String getInstCity() ;
    public void setInstCity(String instCity);

    public String getInstState();
    public void setInstState(String instState);

    public String getNcabFromDate();
    public void setNcabFromDate(String ncabFromDate);

    public String getNcabToDate();
    public void setNcabToDate(String ncabToDate);

    public String getFyFrom();
    public void setFyFrom(String fyFrom);

    public String getFyTo();
    public void setFyTo(String fyTo);

    public String getIpf();
    public void setIpf(String ipf);

    public String getCancerActivity();
    public void setCancerActivity(String cancerActivity);


    public String getRfaPa();
    public void setRfaPa(String rfaPa);

    public String getGrantsFromCriteria();
    public void setGrantsFromCriteria(String grantsFromCriteria);

    public String getSortColumn();
    public void setSortColumn(String sortColumn);

    public String getSortOrder();
    public void setSortOrder(String sortOrder);

    public void setQueryResults(List queryResults);
	public List getQueryResults();

    public boolean isNull();

  }




