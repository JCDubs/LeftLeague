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

    void testSomething() {
        
		mockDomain(DateMultiplier, [
			new DateMultiplier(numOfDays:-21, multiplier:1.0),
			new DateMultiplier(numOfDays:-42, multiplier:0.5),
			new DateMultiplier(numOfDays:-63, multiplier:0.3),
			new DateMultiplier(numOfDays:-84, multiplier:0.2)			
		])
		
		requiredTime.add(Calendar.DATE, -14)
		Date lessthreeWeeksAgo = requiredTime.getTime()
		requiredTime.add(Calendar.DATE, -7)
		Date threeWeeksAgo = requiredTime.getTime()
		requiredTime.add(Calendar.DATE, -14)
		Date lesssixWeeksAgo = requiredTime.getTime()
		requiredTime.add(Calendar.DATE, -7)
		Date sixWeeksAgo = requiredTime.getTime()
		requiredTime.add(Calendar.DATE, -14)
		Date lessnineWeeksAgo = requiredTime.getTime()
		requiredTime.add(Calendar.DATE, -7)
		Date nineWeeksAgo = requiredTime.getTime()
		requiredTime.add(Calendar.DATE, -14)
		Date lesstwelveWeeksAgo = requiredTime.getTime()
		requiredTime.add(Calendar.DATE, -7)
		Date twelveWeeksAgo = requiredTime.getTime()
		requiredTime.add(Calendar.DATE, -1)
		Date oneMoreThanTwelveWeeksAgo = requiredTime.getTime()
		requiredTime.add(Calendar.DATE, -10)
		Date alotMoreThanTwelveWeeksAgo = requiredTime.getTime()
		
		DateMarkerManager markers = new DateMarkerManager()
		
		def multipliers = DateMultiplier.all.sort({ a, b ->
			a.numOfDays <=> b.numOfDays
			} as Comparator).reverse()
		
		multipliers.each{DateMultiplier dateMultiplier->
			
			
			
			
		}
		
		assert service.getDateMultiplier(lessthreeWeeksAgo, markers) == 1.0
		assert service.getDateMultiplier(threeWeeksAgo, markers) == 1.0
		assert service.getDateMultiplier(lesssixWeeksAgo, markers) == 0.5
		assert service.getDateMultiplier(sixWeeksAgo, markers) == 0.5
		assert service.getDateMultiplier(lessnineWeeksAgo, markers) == 0.3
		assert service.getDateMultiplier(nineWeeksAgo, markers) == 0.3
		assert service.getDateMultiplier(lesstwelveWeeksAgo, markers) == 0.2
		assert service.getDateMultiplier(twelveWeeksAgo, markers) == 0.2
		assert service.getDateMultiplier(oneMoreThanTwelveWeeksAgo, markers) == 0
		assert service.getDateMultiplier(alotMoreThanTwelveWeeksAgo, markers) == 0
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
