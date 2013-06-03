package com.uk.leftyleague.domain

class Game {

	Date date
	Player winner
	Player loser	
	
    static constraints = {
		date nullable:false, blank:false
		winner nullable:false, blank:false
		loser nullable:false, blank:false
    }
}
