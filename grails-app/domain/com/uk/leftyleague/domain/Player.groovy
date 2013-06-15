package com.uk.leftyleague.domain

import org.springframework.aop.aspectj.RuntimeTestWalker.ThisInstanceOfResidueTestVisitor;

class Player {

	String name
	int gamesPlayed
	int gamesWon
	int gamesLost
	int currentPoints
	int currentRank
	
	def Player(String playerName, int rank){
		this.name = playerName
		this.currentRank = rank
		this.gamesWon = 0
		this.gamesLost = 0
		this.gamesPlayed = 0
		this.currentPoints = 0
	}
	
    static constraints = {
		name nullable:false, blank:false, unique:true
		gamesPlayed nullable:false
		gamesWon nullable:false
		gamesLost nullable:false
    }
}
