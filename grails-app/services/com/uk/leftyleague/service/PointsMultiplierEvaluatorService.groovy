package com.uk.leftyleague.service

import java.util.Calendar;

import com.uk.leftleague.utils.DateMarkerManager;
import com.uk.leftleague.utils.DateMarkerManager.DateMarker
import com.uk.leftyleague.domain.DateMultiplier;

class PointsMultiplierEvaluatorService {

	def getDateMultiplier(Date gameDate, DateMarkerManager markerManager) {

		def multiplier = 0
		
		for(i in markerManager.markers.reverse()){
			
			Date markerDate = i.markerDate
			
			if(gameDate > markerDate || gameDate == markerDate){
				multiplier = i.factor
				break
			}
		}
		
		return multiplier	
    }	 
}
