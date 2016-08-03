package gov.nih.nci.iscs.oracle.pgm.util;

import org.apache.struts.util.LabelValueBean;

// TODO: Auto-generated Javadoc
/**
 * The Class ActiveLabelValueBean.
 */
public class ActiveLabelValueBean extends LabelValueBean {

	/** The active. */
	private boolean active;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1911338942838960537L;

	/**
	 * Instantiates a new active label value bean.
	 *
	 * @param label the label
	 * @param value the value
	 */
	public ActiveLabelValueBean(String label, String value) {
		super(label, value);
	}
	
	/**
	 * Instantiates a new active label value bean.
	 *
	 * @param label the label
	 * @param value the value
	 * @param active the active
	 */
	public ActiveLabelValueBean(String label, String value, boolean active) {
		super(label, value);
		this.active = active;
	}
	
	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

}
