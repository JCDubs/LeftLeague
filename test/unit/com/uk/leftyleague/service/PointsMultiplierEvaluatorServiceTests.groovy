package com.uk.leftyleague.service



import java.util.Date;

import com.uk.leftleague.utils.DateMarkerManager
import com.uk.leftyleague.domain.DateMultiplier;

import grails.test.mixin.*
import org.junit.*
import grails.test.mixin.support.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(PointsMultiplierEvaluatorService)
@Mock([DateMultiplier])
@TestMixin(GrailsUnitTestMixin)
class PointsMultiplierEvaluatorServiceTests {

    void testGetDateMultiplier() {
        
		mockDomain(DateMultiplier, [
			new DateMultiplier(numOfDays:-21, multiplier:1.0),
			new DateMultiplier(numOfDays:-42, multiplier:0.5),
			new DateMultiplier(numOfDays:-63, multiplier:0.3),
			new DateMultiplier(numOfDays:-84, multiplier:0.2)			
		])
		
		DateMarkerManager markers = new DateMarkerManager()
		
		def multipliers = DateMultiplier.all.sort({ a, b -> a.numOfDays <=> b.numOfDays} as Comparator).reverse()
		
		multipliers.each{DateMultiplier dateMultiplier->
			
			def initialDate = getTime()
			initialDate.add(Calendar.DATE, dateMultiplier.numOfDays +7)
			Date testGameDate = initialDate.getTime()
			assert service.getDateMultiplier(testGameDate, markers) == dateMultiplier.multiplier
			initialDate.add(Calendar.DATE, -7)
			testGameDate = initialDate.getTime()
			assert service.getDateMultiplier(testGameDate, markers) == dateMultiplier.multiplier
		}		
    }
	
	private def getTime(){
		
		Calendar requiredTime = Calendar.getInstance()
		requiredTime.set(Calendar.HOUR,0);
		requiredTime.set(Calendar.MINUTE,0);
		requiredTime.set(Calendar.SECOND,0);
		requiredTime.set(Calendar.MILLISECOND,0);
		
		return requiredTime
	}
}
