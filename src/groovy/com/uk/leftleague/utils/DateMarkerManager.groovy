package com.uk.leftleague.utils

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.uk.leftyleague.domain.DateMultiplier;

/**
 * Date Marker class.
 * Used to store specific dates which are used to evaluate player points.
 * 
 * @author Jason Conway-Williams.
 *
 */
class DateMarkerManager {

	def markers = []
	
	/**
	 * DateMarkers constructor.
	 * On creation markers are created in three week blocks.
	 */
	def DateMarkerManager(){
		
		setUpDates()
	}
	
	private setUpDates(){
		
		def multipliers = DateMultiplier.all.sort({ a, b -> 
			a.numOfDays <=> b.numOfDays 
			} as Comparator)
		
		multipliers.each {DateMultiplier dateMultiplier->
			
			Calendar currentDate = getTime()
			currentDate.add(Calendar.DATE, dateMultiplier.numOfDays)
			
			markers.add(new DateMarker([markerDate:currentDate.getTime(), factor: dateMultiplier.multiplier]))			
		}		
	}
	
	private def getTime(){
		
		Calendar currentDate = Calendar.getInstance()
		currentDate.set(Calendar.HOUR,0);
		currentDate.set(Calendar.MINUTE,0);
		currentDate.set(Calendar.SECOND,0);
		currentDate.set(Calendar.MILLISECOND,0);
		
		return currentDate
	}
	
	static final class DateMarker{
		
		Date markerDate
		double factor
		
	}
}
