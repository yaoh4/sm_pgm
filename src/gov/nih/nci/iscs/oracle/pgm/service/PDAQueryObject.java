package gov.nih.nci.iscs.oracle.pgm.service;

  public interface PDAQueryObject extends GrantQueryObject {


    public String getIrgCode();

    public void setIrgCode(String irgCode);

    public String getIrgFlexCode();

    public void setIrgFlexCode(String irgCode);



    public boolean getBarFlag();

    public void setBarFlag(boolean barFlag);
    public boolean getUnAssignedGrantsCriteria();

    public void setUnAssignedGrantsCriteria(boolean unAssignedGrantsCriteria) ;

    public boolean getInactiveGrantsCriteria();


    public void setInactiveGrantsCriteria(boolean inactiveGrantsCriteria);


   public String getIpf();

    public void setIpf(String ipf);

    public String getI2Status();

    public void setI2Status(String i2Status);

    public String getPercentileFrom();

    public void setPercentileFrom(String percentileFrom);
    public String getPercentileTo() ;

    public void setPercentileTo(String percentileTo) ;


    public String getPriorityScoreFrom();

    public void setPriorityScoreFrom(String priorityScoreFrom);
    public String getPriorityScoreTo();

    public void setPriorityScoreTo(String priorityScoreTo);


    public String getGroupCode() ;
    public void setGroupCode(String groupCode);

    public String getPdOrg();
    public void setPdOrg(String pdOrg) ;

    public String getPdId();
    public void setPdId(String pdId);    public String toString();

    public boolean isNull();




}




