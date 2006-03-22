package gov.nih.nci.iscs.oracle.pgm.constants;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

public class LookUpTableConstants {

	public static final String[] CANCER_ACTIVITIES_T_LOOKUP = {"CANCER_ACTIVITIES_T_1", "select CODE, DESCRIPTION from CANCER_ACTIVITIES_T order by CODE asc"};
	public static final String[] APPL_STATUS_GROUPS_MV_LOOKUP = {"APPL_STATUS_GROUPS_MV_1", "select appl_status_group_code, descrip from appl_status_groups_mv order by appl_status_group_code asc"};
	public static final String[] APPL_STATUS_MV_LOOKUP = {"APPL_STATUSES_MV_1", "select appl_status_code, appl_status_descrip from appl_statuses_mv order by appl_status_code asc"};
	public static final String[] BOARDS_T_LOOKUP = {"BOARDS_T_1", "SELECT  (meeting_year || meeting_month), (meeting_month || '/' || meeting_year) FROM boards_t ORDER BY meeting_year desc, meeting_month DESC"};
	public static final String[] PD_NAME_VW3_LOOKUP = {"PD_ORG_VW3_1", "select  person_id, (pd_name || ' (' || Max(pd_code) || ')') from pd_ca_asgnmt_vw group by person_id, pd_name order by person_id"};
	public static final String[] PD_ORG_VW3_LOOKUP = {"PD_ORG_VW3_2", "select  distinct org_id, org_desc from pd_org_vw3 order by org_id"};
	public static final String[] PD_CA_ASGNMT_VW_LOOKUP = {"PD_CA_ASGNMT_VW_1", "select distinct pd_name, cay_code from pd_ca_asgnmt_vw order by pd_name"};
	public static final String[] PD_NAME_VW4_LOOKUP = {"PD_ORG_VW4_1", "select   person_id, (pd_name || ' (' || Max(pd_code) || ')')   from pd_org_vw4 group by person_id, pd_name order by pd_name"};
	public static final String  LOOKUP_TABLE_HASH = "lookupTableHash";


}
