package com.uk.leftyleague.domain

class DateMultiplier {

	int numOfDays
	double multiplier
	
	def DateMultiplier(int numberOfDays, double multiplierValue){
		this.numOfDays = numberOfDays
		this.multiplier = multiplierValue
	}
	
	String toString(){
		return "${this.numOfDays} days:${this.multiplier}"
	}
	
    static constraints = {
		numOfDays unique:true, nullable:false, blank:false
		multiplier nullable:false, blank:false
    }
}
