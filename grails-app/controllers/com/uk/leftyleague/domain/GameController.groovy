package com.uk.leftyleague.domain

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.dao.DataIntegrityViolationException

class GameController {

	    def addGame() {
			
			if(!(params.gameDay || params.gameMonth || params.gameYear || params.playerOne || params.playerTwo || params.playerOneWon || params.playerTwoWon)){
				request.error = "A problem occurred while attempting to save the game."
				render(template:"/admin/addGameForm")
			}
					
			
		Date gameDate = getGameDate(params.gameDay.toInteger(), params.gameMonth.toInteger(), params.gameYear.toInteger()).getTime()
		//SimpleDateFormat.parse(params.gameDate)
		Player playerOne = Player.findByName(params.playerOne)	
		Player playerTwo = Player.findByName(params.playerTwo)
		int playerOneGamesWon = params.playerOneWon.toInteger()
		int playerTwoGamesWon = params.playerTwoWon.toInteger()
		
		int totalGames = playerOneGamesWon + playerTwoGamesWon
		
		playerOne.gamesPlayed += totalGames
		playerTwo.gamesPlayed += totalGames
		playerOne.gamesLost += playerTwoGamesWon
		playerTwo.gamesLost += playerOneGamesWon
		playerOne.gameWon += playerOneGamesWon
		playerTwo.gamesLost += playerTwoGamesWon
		
		if(!playerOne.save() || !playerTwo.save()){
			request.error = "A problem occurred while attempting to save the game."
			render(template:"/admin/addGameForm")
		}
		
		def newGames = []
		
		playerOneGamesWon.each {
			
		}
		
		playerTwoGamesWon.each {
			
		}
		
        def gameInstance = new Game(params)
        if (!gameInstance.save(flush: true)) {
            render(view: "create", model: [gameInstance: gameInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'game.label', default: 'Game'), gameInstance.id])
        redirect(action: "show", id: gameInstance.id)
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
