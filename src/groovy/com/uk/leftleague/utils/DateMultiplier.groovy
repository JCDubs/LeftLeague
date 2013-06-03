package com.uk.leftleague.utils

/**
 * Date Multiplier provides enum values
 * containing the multiplier for the different
 * number of weeks.
 * 
 * @author Jason Conway-Williams.
 */
enum DateMultiplier {

	THREE_WEEKS(1, 21),
	THREE_TO_SIX_WEEKS(0.5, 42),
	SIX_TO_NINE_WEEKS(0.3, 63),
	NINE_TO_TWELVE_WEEKS(0.2, 84)
	
	double multiplier
	int daysAgo
	
	/**
	 * Constructor for the date multiplier objects.
	 * @param multiplierValue. The multiplier of the Date Multiplier object.
	 * @param daysAgoValue. The number of days.
	 */
	def DateMultiplier(double multiplierValue, int daysAgoValue){
		this.multiplier = multiplierValue
		this.daysAgo = daysAgoValue
	}
}
