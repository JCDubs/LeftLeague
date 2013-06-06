<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Lefty Squash League</title>
		
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="page-body" role="main">
			<h1>League current rankings</h1>
			
			<table>
		<thead>
			<tr>
				<th>Rank</th>
				<th>Player</th>
				<th>Played</th>
				<th>Won</th>
				<th>Lost</th>
				<th>Points</th>
			</tr>
		</thead>
		<tbody>
			<g:each in="${playerList}" status="i" var="leaguePlayer">
				<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					<td>${fieldValue(bean: leaguePlayer, field: "currentRank")}</td>
					<td>${fieldValue(bean: leaguePlayer, field: "name")}</td>
					<td>${fieldValue(bean: leaguePlayer, field: "gamesPlayed")}</td>	
					<td>${fieldValue(bean: leaguePlayer, field: "gamesWon")}</td>
					<td>${fieldValue(bean: leaguePlayer, field: "gamesLost")}</td>		
					<td>${fieldValue(bean: leaguePlayer, field: "currentPoints")}</td>					
				</tr>
			</g:each>
		</tbody>
	</table>			
		</div>
	</body>
</html>
