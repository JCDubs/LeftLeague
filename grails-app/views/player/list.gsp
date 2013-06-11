
<%@ page import="com.uk.leftyleague.domain.Player" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'player.label', default: 'Player')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-player" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-player" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'player.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="gamesPlayed" title="${message(code: 'player.gamesPlayed.label', default: 'Games Played')}" />
					
						<g:sortableColumn property="gameWon" title="${message(code: 'player.gameWon.label', default: 'Game Won')}" />
					
						<g:sortableColumn property="gamesLost" title="${message(code: 'player.gamesLost.label', default: 'Games Lost')}" />
					
						<g:sortableColumn property="currentPoints" title="${message(code: 'player.currentPoints.label', default: 'Current Points')}" />
					
						<g:sortableColumn property="currentRank" title="${message(code: 'player.currentRank.label', default: 'Current Rank')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${playerInstanceList}" status="i" var="playerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${playerInstance.id}">${fieldValue(bean: playerInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: playerInstance, field: "gamesPlayed")}</td>
					
						<td>${fieldValue(bean: playerInstance, field: "gameWon")}</td>
					
						<td>${fieldValue(bean: playerInstance, field: "gamesLost")}</td>
					
						<td>${fieldValue(bean: playerInstance, field: "currentPoints")}</td>
					
						<td>${fieldValue(bean: playerInstance, field: "currentRank")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${playerInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
