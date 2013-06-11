package com.uk.leftleague.command

import org.codehaus.groovy.grails.validation.Validateable;

import com.uk.leftyleague.domain.DateMultiplier;

@Validateable
class SettingsCommand {

	int pointBase
	List<DateMultiplier> dateMultipliers
	
	static constraints = {
		
		pointBase nullable:false
	}
}
