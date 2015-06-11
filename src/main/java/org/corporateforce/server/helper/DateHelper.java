package org.corporateforce.server.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateHelper {

	public static Date removeTimeZoneOffset(Date date) {
		Calendar cday = new GregorianCalendar();
		cday.setTime(date);
		cday.add(Calendar.MILLISECOND,-cday.get(Calendar.ZONE_OFFSET));
		cday.setTimeZone(TimeZone.getTimeZone("Etc/GMT"));
		return cday.getTime();
	}
	
}
