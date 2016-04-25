package gov.nih.nci.iscs.oracle.pgm.actions.helper;

import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;

public class ActiveLabelValueBean extends LabelValueBean implements Comparable<ActiveLabelValueBean> {
	
	private static final Logger log = Logger.getLogger(ActiveLabelValueBean.class);
	private static final long serialVersionUID = -6697653280333349603L;
	private Boolean active;

	/**
	 * Instantiates a new active label value bean.
	 *
	 * @param label the label
	 * @param value the value
	 */
	public ActiveLabelValueBean(String label, String value, Boolean active) {
		super(label, value);
		this.active = active;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ActiveLabelValueBean arg0) {
		//log.info("Comparing " + arg0 + " " + this);
		if (arg0 == null) {
			//log.info("1. Returning -1");
			return -1;
		}

		// Sort active before inactive
		if (getActive() && !arg0.getActive() ) {
			//log.info("2. Returning -1");
			return -1;
		}

		if (!getActive() && arg0.getActive()) {
			//log.info("3. Returning 1");
			return 1;
		}
		
		// if both are active or inactive, sort by label
		//log.info("4. Returning " + getLabel().compareTo(arg0.getLabel()));
		return getLabel().compareTo(arg0.getLabel());
	}

	/**
	 * Gets the active.
	 *
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

}
