package com.uk.leftyleague.service

import com.uk.leftleague.utils.AppConstants;
import com.uk.leftleague.utils.DateMarkerManager
import com.uk.leftyleague.domain.ArchivedLeagueScore;
import com.uk.leftyleague.domain.Game
import com.uk.leftyleague.domain.Player
import com.uk.leftyleague.domain.PointBase;

class PointsCalculatorService {

	PointsMultiplierEvaluatorService pointsMultiplierEvaluatorService
	
    def calculatePlayersPoints() {

		DateMarkerManager dateManager = new DateMarkerManager()
		PointBase pointBase = PointBase.get(AppConstants.POINT_BASE_ID)
		
		Player.all.each {Player currentPlayer->
			
			int playersPoints = 0			
			
			Game.findAllByWinner(currentPlayer).each {Game currentGame ->
								
				def multiplier = pointsMultiplierEvaluatorService.getDateMultiplier(currentGame.date, dateManager)
				int gamePoints = pointBase.basePoints - currentGame.loserRank
				playersPoints += gamePoints * multiplier
			}
			
			currentPlayer.setCurrentPoints(playersPoints)
			currentPlayer.save()
		}		
    }
	
	def calculateAllPlayersRank() {
		
		def rankedPlayers = Player.all.sort{it.currentPoints}.reverse()
		
		rankedPlayers.eachWithIndex { Player currentPlayer, i->
			
			currentPlayer.setCurrentRank(i+1)
			currentPlayer.save()
			
			ArchivedLeagueScore newArchive = new ArchivedLeagueScore([leaguePlayer:currentPlayer, resultsDate: new Date()])
			newArchive.save()
		}
	}
}
