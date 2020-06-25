package net.najiboulhouch.leavesmanagers.utils;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;

public class Dates {
		
	/**
	 * Check if finalDate is great than startDate
	 * @param date
	 * @param dateDebut
	 * @return true or false 
	 */
	public static boolean isAfter(Date date, Date dateDebut) {
		if(date.compareTo(dateDebut) < 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * Calculate number of days between two dates
	 * @param dateDebut
	 * @param dateFin
	 * @return int
	 */
	public static int getNbJoursBetween(Date dateStart, Date dateEnd) {
		DateTimeZone.setDefault(DateTimeZone.UTC);
	    DateTime startDate = DateTime.parse(dateStart.toString());
	    DateTime endDate = DateTime.parse(dateEnd.toString());
	    Days dateResult = Days.daysBetween(startDate, endDate);
		return dateResult.getDays();
	}

}
