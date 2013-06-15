package com.uk.leftyleague.domain

class LastRankUpdate {

	int id
	Date lastRankUpdate
	
	def LastRankUpdate(int idValue, Date lastUpdateValue){
		this.id = idValue
		this.lastRankUpdate = lastUpdateValue
	}
	
    static constraints = {
		lastRankUpdate nullable:false, blank:false
    }
	
	static mapping = {
		id generator:'assigned'
	}
}
