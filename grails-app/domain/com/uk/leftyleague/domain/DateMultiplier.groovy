package com.uk.leftyleague.domain

class DateMultiplier {

	int numOfDays
	double multiplier
	
    static constraints = {
		numOfDays unique:true, nullable:false, blank:false
		multiplier unique:true, nullable:false, blank:false
    }
}
