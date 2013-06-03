package com.uk.leftyleague.controller

import javax.swing.text.View;

import com.uk.leftleague.utils.AppConstants;
import com.uk.leftyleague.domain.DateMultiplier;
import com.uk.leftyleague.domain.PointBase;

class SettingsController {

    def settings() { 
		
		PointBase pointBase = PointBase.get(AppConstants.POINT_BASE_ID)		
		[basePoints:pointBase, dateMultipliers:DateMultiplier.list().sort{a, b-> a.numOfDays <=> b.numOfDays}as Comparator]
	}
	
	def editSettings(){
		PointBase pointBase = PointBase.get(AppConstants.POINT_BASE_ID)
		render(view:"test", model:[basePoints:pointBase, dateMultipliers:DateMultiplier.list().sort{a, b-> a.numOfDays <=> b.numOfDays}as Comparator])
	}
	
	def saveSettings(){
		
		PointBase pointBase = PointBase.get(AppConstants.POINT_BASE_ID)		
		pointBase.setBasePoints(params.basePoints as Integer)
		
		
		
		params.dateMultipliers.each {multiplier->
			
			DateMultiplier existingMultiplier = DateMultiplier.get(multiplier.id)
			existingMultiplier.setNumOfDays(multiplier.numOfDays)
			existingMultiplier.setMultiplier(multiplier.multiplier)
			existingMultiplier.save()
		}
		
		pointBase.save(flush:true)
	}
	
	def newMultiplier(){
		
		DateMultiplier newMultiplier = new DateMultiplier([numOfDays:params.numOfDays, multiplier: params.multiplier])		
		newMultiplier.save(flush:true)
		
		
	}
	
	def deleteMultiplier(){
		DateMultiplier existingMultiplier = DateMultiplier.get(params.id)
		existingMultiplier.delete(flush:true)
	}
}
