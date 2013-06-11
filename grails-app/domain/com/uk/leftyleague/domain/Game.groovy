package com.uk.leftyleague.domain

class Game {

	Date date
	Player winner
	Player loser
	int loserRank	
	
	def Game(def dateValue, def winnerValue, def loserValue, def loserRankValue){
		this.date = dateValue
		this.winner	= winnerValue
		this.loser = loserValue
		this.loserRank = loserRankValue
	}
	
    static constraints = {
		date nullable:false, blank:false
		winner nullable:false, blank:false
		loser nullable:false, blank:false
		loserRank nullable:false, blank:false
    }
}
