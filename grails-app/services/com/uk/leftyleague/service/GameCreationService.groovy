package com.uk.leftyleague.service

import com.uk.leftyleague.domain.Game
import com.uk.leftyleague.domain.Player

class GameCreationService {

    def createGame(Player winner, Player loser, Date gameDate, int loserRank) {

        Game currentGame = new Game(gameDate, winner, loser, loserRank)

        if(!currentGame.save()){
            return false
        }

        return true
    }
}
