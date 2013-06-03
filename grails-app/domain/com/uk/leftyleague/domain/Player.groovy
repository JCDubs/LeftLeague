package com.uk.leftyleague.domain

class Player {

	String name
	int gamesPlayed
	int gameWon
	int gamesLost
	int currentPoints
	int currentRank
	
	static hasMany = [games: Game]
	
    static constraints = {
		games nullable:true, blank:true
		name nullable:false, blank:false, unique:true
		gamesPlayed nullable:false
		gameWon nullable:false
		gamesLost nullable:false
    }
}
