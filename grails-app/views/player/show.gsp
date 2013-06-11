
<%@ page import="com.uk.leftyleague.domain.Player" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'player.label', default: 'Player')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-player" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-player" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list player">
			
				<g:if test="${playerInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="player.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${playerInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${playerInstance?.gamesPlayed}">
				<li class="fieldcontain">
					<span id="gamesPlayed-label" class="property-label"><g:message code="player.gamesPlayed.label" default="Games Played" /></span>
					
						<span class="property-value" aria-labelledby="gamesPlayed-label"><g:fieldValue bean="${playerInstance}" field="gamesPlayed"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${playerInstance?.gameWon}">
				<li class="fieldcontain">
					<span id="gameWon-label" class="property-label"><g:message code="player.gameWon.label" default="Game Won" /></span>
					
						<span class="property-value" aria-labelledby="gameWon-label"><g:fieldValue bean="${playerInstance}" field="gameWon"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${playerInstance?.gamesLost}">
				<li class="fieldcontain">
					<span id="gamesLost-label" class="property-label"><g:message code="player.gamesLost.label" default="Games Lost" /></span>
					
						<span class="property-value" aria-labelledby="gamesLost-label"><g:fieldValue bean="${playerInstance}" field="gamesLost"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${playerInstance?.currentPoints}">
				<li class="fieldcontain">
					<span id="currentPoints-label" class="property-label"><g:message code="player.currentPoints.label" default="Current Points" /></span>
					
						<span class="property-value" aria-labelledby="currentPoints-label"><g:fieldValue bean="${playerInstance}" field="currentPoints"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${playerInstance?.currentRank}">
				<li class="fieldcontain">
					<span id="currentRank-label" class="property-label"><g:message code="player.currentRank.label" default="Current Rank" /></span>
					
						<span class="property-value" aria-labelledby="currentRank-label"><g:fieldValue bean="${playerInstance}" field="currentRank"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${playerInstance?.id}" />
					<g:link class="edit" action="edit" id="${playerInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
