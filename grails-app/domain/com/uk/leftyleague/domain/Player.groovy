package com.uk.leftyleague.domain

import org.springframework.aop.aspectj.RuntimeTestWalker.ThisInstanceOfResidueTestVisitor;

class Player {

	String name
	int gamesPlayed
	int gameWon
	int gamesLost
	int currentPoints
	int currentRank
	
	def Player(String playerName, int rank){
		this.name = playerName
		this.currentRank = rank
		this.gameWon = 0
		this.gamesLost = 0
		this.gamesPlayed = 0
		this.currentPoints = 0
	}
	
    static constraints = {
		name nullable:false, blank:false, unique:true
		gamesPlayed nullable:false
		gameWon nullable:false
		gamesLost nullable:false
    }
}
