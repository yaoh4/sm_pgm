package gov.nih.nci.iscs.oracle.pgm.actions.helper;

import java.util.Comparator;

import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;

public class LabelValueBeanComparator implements Comparator<LabelValueBean> {
	private static final Logger log = Logger.getLogger(LabelValueBeanComparator.class);

	@Override
	public int compare(LabelValueBean arg0, LabelValueBean arg1) {
		log.info("Comparing " + arg0 + " " + arg1);
		if ((arg0 == null) && (arg1 != null)) {
			log.info("1. Returning -1");
			return -1;
		}
		if ((arg1 == null) && (arg0 != null)) {
			log.info("2. Returning 1");
			return 1;
		}
		if ((arg1 == null) && (arg0 == null)) {
			log.info("3. Returning 0");
			return 0;
		}

		if (arg0.getLabel().contains("Inactive") && !arg1.getLabel().contains("Inactive")) {
			log.info("4. Returning 1");
			return 1;
		}

		if (arg1.getLabel().contains("Inactive") && !arg0.getLabel().contains("Inactive")) {
			log.info("5. Returning -1");
			return -1;
		}
		log.info("6. Returning " + arg0.getLabel().compareTo(arg1.getLabel()));
		return arg0.getLabel().compareTo(arg1.getLabel());
	}

}
