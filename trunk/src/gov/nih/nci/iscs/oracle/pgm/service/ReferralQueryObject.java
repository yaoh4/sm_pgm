package gov.nih.nci.iscs.oracle.pgm.service;

  public interface ReferralQueryObject extends GrantQueryObject {

    public Boolean getAllowAraNotNull();
    public boolean getAllowAraNotNull_boolean();
	public void setAllowAraNotNull(Boolean allowAraNotNull);


	public Boolean getAllowDualsNotNull();
	public boolean getAllowDualsNotNull_boolean();
    public void setAllowDualsNotNull(Boolean allowDualsNotNull);

 }



