<%@ page import="com.uk.leftyleague.domain.Player" %>



<div class="fieldcontain ${hasErrors(bean: playerInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="player.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${playerInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: playerInstance, field: 'gamesPlayed', 'error')} required">
	<label for="gamesPlayed">
		<g:message code="player.gamesPlayed.label" default="Games Played" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="gamesPlayed" type="number" value="${playerInstance.gamesPlayed}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: playerInstance, field: 'gameWon', 'error')} required">
	<label for="gameWon">
		<g:message code="player.gameWon.label" default="Game Won" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="gameWon" type="number" value="${playerInstance.gameWon}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: playerInstance, field: 'gamesLost', 'error')} required">
	<label for="gamesLost">
		<g:message code="player.gamesLost.label" default="Games Lost" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="gamesLost" type="number" value="${playerInstance.gamesLost}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: playerInstance, field: 'currentPoints', 'error')} required">
	<label for="currentPoints">
		<g:message code="player.currentPoints.label" default="Current Points" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="currentPoints" type="number" value="${playerInstance.currentPoints}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: playerInstance, field: 'currentRank', 'error')} required">
	<label for="currentRank">
		<g:message code="player.currentRank.label" default="Current Rank" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="currentRank" type="number" value="${playerInstance.currentRank}" required=""/>
</div>

