package com.uk.leftyleague.domain

class PointBase {

	int id
	int basePoints
	
	def PointBase(int idValue, int basePointsValue){
		this.id = idValue
		this.basePoints = basePointsValue
	}
		
	String toString(){
		return this.basePoints.toString()
	}
	
    static constraints = {
		id nullable:false, blank:false
		basePoints nullable:false, blank:false
    }
	
	static mapping = {
		id generator:'assigned'		
	}
}
