package com.uk.leftyleague.domain

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.dao.DataIntegrityViolationException

class GameController {

	    def addGame() {
			
		Date gameDate = new Date().parse("dd MM yy", params.gameDate)
		//SimpleDateFormat.parse(params.gameDate)
		Player playerOne = Player.findByName(params.playerOneName)	
		Player playerTwo = Player.findByName(params.playerTwoName)
		int playerOneGamesWon = String.toInteger(params.playerOneWon)
		int playerTwoGamesWon = String.toInteger(params.playerOneWon)
		
        def gameInstance = new Game(params)
        if (!gameInstance.save(flush: true)) {
            render(view: "create", model: [gameInstance: gameInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'game.label', default: 'Game'), gameInstance.id])
        redirect(action: "show", id: gameInstance.id)
    }    
		
		private Date getGameDate(){
			
			Calendar currentDate = Calendar.get
			currentDate.set(Calendar.HOUR,0);
			currentDate.set(Calendar.MINUTE,0);
			currentDate.set(Calendar.SECOND,0);
			currentDate.set(Calendar.MILLISECOND,0);
			
			
		}
}
