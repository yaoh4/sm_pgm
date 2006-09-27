package gov.nih.nci.iscs.oracle.pgm.service;

import java.text.DateFormat;

import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class GrantSearchResultObject {


    /** identifier field */
    private boolean selected;
    private String cancerActivity;
    private String grantNumber;
    private String pdFullName;
    private Long   applId;
    private boolean withdrawn = false;
    private boolean marked = false;
    protected DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT);
    private int sortIndex;



    public String getGrantNumber() {
		return this.grantNumber;
	}
    public void setGrantNumber(String grantNumber) {
		this.grantNumber = grantNumber;
	}

    public void setCancerActivity(String cancerActivity) {
		this.cancerActivity = cancerActivity;
	}
    public String getCancerActivity() {
		return this.cancerActivity;
	}

    public void setApplId(Long applId) {
		this.applId = applId;
	}
    public Long getApplId() {
		return this.applId;
	}

    public String getPdFullName() {
		return this.pdFullName;
	}
    public void setPdFullName(String pdFullName) {
		this.pdFullName = pdFullName;
	}

   public void setSelected(boolean selected) {
	   this.selected = selected;
   }
   public boolean getSelected() {
	   return this.selected;
   }

    public boolean getMarked() {
		return this.marked;
	}
    public void setMarked(boolean marked) {
		this.marked = marked;
	}


    public boolean getWithdrawn() {
		return this.withdrawn;
	}
    public void setWithdrawn(boolean withdrawn) {
		this.withdrawn = withdrawn;
	}


    public int getSortIndex() {
		return this.sortIndex;
	}
    public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}


  public String toString() {
        return new ToStringBuilder(this)
            .append("CanacerActivity ", getCancerActivity())
            .append("ApplId ", getApplId())
            .append("PdFullName ", getPdFullName())
            .append("Selected ", getSelected())
            .append("marked ", getMarked())
            .append("withdrawn ", getWithdrawn())
            .append("sortIndex ", getSortIndex())
            .toString();
    }
}
