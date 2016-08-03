package gov.nih.nci.iscs.oracle.pgm.util;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class TimeInsensitiveDateComparator implements Comparator<Date> {

	@Override
	public int compare(Date arg0, Date arg1) {
		if (arg0 == null && arg1 != null)
			return 1;
		if (arg0 != null && arg1 == null)
			return -1;
		if (arg0 == null && arg1 == null)
			return 0;

		Calendar cal0 = Calendar.getInstance();
		cal0.setTime(arg0);
		cal0.set(Calendar.HOUR, 0);
		cal0.set(Calendar.MINUTE, 0);
		cal0.set(Calendar.SECOND, 0);
		cal0.set(Calendar.MILLISECOND, 0);

		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(arg1);
		cal1.set(Calendar.HOUR, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);

		return cal0.compareTo(cal1);
	}
}
