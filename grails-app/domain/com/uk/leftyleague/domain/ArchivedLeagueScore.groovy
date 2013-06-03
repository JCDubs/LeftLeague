package com.uk.leftyleague.domain

class ArchivedLeagueScore {

	Player leaguePlayer
	Date resultsDate
	
    static constraints = {
		
		leaguePlayer nullable:false, blank:false
		resultsDate nullable:false, blank:false
    }
}
