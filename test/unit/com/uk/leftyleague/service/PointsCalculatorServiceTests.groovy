package com.uk.leftyleague.service

import static org.junit.Assert.*
import com.uk.leftyleague.domain.Player;
import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

import com.uk.leftleague.utils.AppConstants;
import com.uk.leftyleague.domain.ArchivedLeagueScore;
import com.uk.leftyleague.domain.DateMultiplier;
import com.uk.leftyleague.domain.Game;
import com.uk.leftyleague.domain.Player
import com.uk.leftyleague.domain.PointBase;

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Mock([PointBase, Player, Game, DateMultiplier, ArchivedLeagueScore])
@TestFor(PointsCalculatorService)
@TestMixin(GrailsUnitTestMixin)
class PointsCalculatorServiceTests {

	Date dateOne
	Date dateTwo
	Date dateThree
	Date dateFour
	
	Player playerOne
	Player playerTwo
	Player playerThree
	Player playerFour
	
    void setUp() {
        
		PointsMultiplierEvaluatorService eval = new PointsMultiplierEvaluatorService()
		
		service.pointsMultiplierEvaluatorService = eval
		
		mockDomain(DateMultiplier, [
			new DateMultiplier(numOfDays:-21, multiplier:1.0),
			new DateMultiplier(numOfDays:-42, multiplier:0.5),
			new DateMultiplier(numOfDays:-63, multiplier:0.3),
			new DateMultiplier(numOfDays:-84, multiplier:0.2)
		])
		
		setUpGameDates()
		
		mockDomain(PointBase, [new PointBase(id:AppConstants.POINT_BASE_ID,basePoints:50)])
		
		mockDomain(Player, [new Player(name:"player 1", gamesPlayed:0, gamesWon:0, gamesLost:0, currentPoints:0,currentRank:1),
			new Player(name:"player 2", gamesPlayed:0, gamesWon:0, gamesLost:0, currentPoints:0,currentRank:2),
			new Player(name:"player 3", gamesPlayed:0, gamesWon:0, gamesLost:0, currentPoints:0,currentRank:3),
			new Player(name:"player 4", gamesPlayed:0, gamesWon:0, gamesLost:0, currentPoints:0,currentRank:4)])
		
		playerOne = Player.findByName("player 1")
		playerTwo = Player.findByName("player 2")
		playerThree = Player.findByName("player 3")
		playerFour = Player.findByName("player 4")
		
		mockDomain(Game, [new Game(date:dateOne, winner:playerOne, loser:playerFour, loserRank: playerFour.getCurrentRank()),
			new Game(date:dateTwo, winner:playerOne, loser:playerThree, loserRank: playerThree.getCurrentRank()),
			new Game(date:dateTwo, winner:playerTwo, loser:playerThree, loserRank: playerThree.getCurrentRank()),
			new Game(date:dateThree, winner:playerTwo, loser:playerOne, loserRank: playerOne.getCurrentRank()),
			new Game(date:dateThree, winner:playerThree, loser:playerTwo, loserRank: playerTwo.getCurrentRank()),
			new Game(date:dateFour, winner:playerThree, loser:playerFour, loserRank: playerFour.getCurrentRank()),
			new Game(date:dateFour, winner:playerFour, loser:playerOne, loserRank: playerOne.getCurrentRank()),
			new Game(date:dateOne, winner:playerFour, loser:playerTwo, loserRank: playerTwo.getCurrentRank())
			])
    }

    void tearDown() {
        // Tear down logic here
    }

    void testCalculatePlayersPoints() {
        
		service.calculatePlayersPoints()
		
		assert playerOne.currentPoints == 69
		assert playerTwo.currentPoints == 37
		assert playerThree.currentPoints == 23
		assert playerFour.currentPoints == 57
    }
	
	void testCalculateAllPlayersRank(){
		
		playerOne.setCurrentPoints(42)
		playerOne.save()
		playerTwo.setCurrentPoints(69)
		playerTwo.save()
		playerThree.setCurrentPoints(0)
		playerThree.save()
		playerFour.setCurrentPoints(71)
		playerFour.save()
		
		service.calculateAllPlayersRank()
		
		assertEquals(playerFour.getCurrentRank(), 1)
		assertEquals(playerTwo.getCurrentRank(), 2)
		assertEquals(playerOne.getCurrentRank(), 3)
		assertEquals(playerThree.getCurrentRank(), 4)
	}
	
	private setUpGameDates(){
		
		Calendar currentTime = Calendar.getInstance()
		currentTime.set(Calendar.HOUR,0);
		currentTime.set(Calendar.MINUTE,0);
		currentTime.set(Calendar.SECOND,0);
		currentTime.set(Calendar.MILLISECOND,0);
		
		currentTime.add(Calendar.DATE, -20)		
		dateOne = currentTime.getTime()
		
		currentTime.add(Calendar.DATE, -20)
		dateTwo = currentTime.getTime()
		
		currentTime.add(Calendar.DATE, -20)
		dateThree = currentTime.getTime()
		
		currentTime.add(Calendar.DATE, -20)
		dateFour = currentTime.getTime()
	}	
}