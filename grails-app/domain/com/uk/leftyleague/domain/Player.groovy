package com.uk.leftyleague.domain

class Player {

	String name
	
	static hasMany = [games: Game]
	
    static constraints = {
		games nullable:true, blank:true
		name nullable:false, blank:false, unique:true
    }
}
