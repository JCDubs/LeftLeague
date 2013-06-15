package com.uk.leftyleague.domain

import com.uk.leftyleague.service.GameCreationService

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.dao.DataIntegrityViolationException

import com.uk.leftleague.utils.AppConstants;
import com.uk.leftyleague.service.PointsCalculatorService

class GameController {

	PointsCalculatorService pointsCalculatorService
    GameCreationService gameCreationService

	def leagueRankings(){
		
		if(true){
            //timeToUpdateRankings()
			pointsCalculatorService.calculatePlayersPoints()
			pointsCalculatorService.calculateAllPlayersRank()
		}
		
		[playerList:Player.list().sort{it.currentRank}]
	}
	
	def recordGame(){
		[gameDate:new Date(), playerOneGamesWon:0,playerTwoGamesWon:0]
	}
	
	def addGame() {

		Date gameDate = getGameDate(params.gameDate_day.toInteger(), params.gameDate_month.toInteger(), params.gameDate_year.toInteger()).getTime()

		Player playerOne = Player.findByName(params.playerOne)
		Player playerTwo = Player.findByName(params.playerTwo)
		int playerOneGamesWon = params.playerOneGameWon.toInteger()
		int playerTwoGamesWon = params.playerTwoGameWon.toInteger()

		int totalGames = playerOneGamesWon + playerTwoGamesWon

		boolean unsavedGame = false

        playerOneGamesWon.times {

            if(!gameCreationService.createGame(playerOne, playerTwo, gameDate, playerTwo.currentRank)){
                unsavedGame = true
            }
        }

		playerTwoGamesWon.times {

            if(!gameCreationService.createGame(playerTwo, playerOne, gameDate, playerOne.currentRank)){
                unsavedGame = true
            }
		}

		if (unsavedGame) {
			request.error = "A problem occurred while attempting to save the games."
			render(view: "recordGame", model: [gameDate:new Date(), playerOneGamesWon:0,playerTwoGamesWon:0])
		}

		request.message = "${totalGames} games saved."
		render(view: "recordGame", model: [gameDate:new Date(), playerOneGamesWon:0,playerTwoGamesWon:0])
	}

	private def timeToUpdateRankings(){
		
		Calendar today = Calendar.getInstance()
		today.setTime(new Date())
		today.set(Calendar.HOUR,0);
		today.set(Calendar.MINUTE,0);
		today.set(Calendar.SECOND,0);
		today.set(Calendar.MILLISECOND,0);
		today.setFirstDayOfWeek(0)
		
		if(today.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY){
		
			Date lastRankingsUpdate = LastRankUpdate.get(AppConstants.LAST_RANK_UPDATE_ID).lastRankUpdate
			
			if(today.getTime() != lastRankingsUpdate){
				return true
			}			
		}
		
		return false		
	}
	
	private def getGameDate(int dayValue, int monthValue, int yearValue){

		Calendar gameDate = Calendar.getInstance()
		gameDate.set(Calendar.YEAR, yearValue)
		gameDate.set(Calendar.MONTH, monthValue)
		gameDate.set(Calendar.DATE, dayValue)
		gameDate.set(Calendar.HOUR,0);
		gameDate.set(Calendar.MINUTE,0);
		gameDate.set(Calendar.SECOND,0);
		gameDate.set(Calendar.MILLISECOND,0);

		return gameDate
	}
}
