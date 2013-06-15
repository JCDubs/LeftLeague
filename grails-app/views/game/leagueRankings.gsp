<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Lefty Squash League</title>

</head>
<body>
	<a href="#page-body" class="skip"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div id="page-body" role="main">
	<div id="adminPage">
	<g:link class="buttons nav" controller="Admin" action="settings">Administration</g:link>
	<g:link class="buttons nav" controller="Game" action="recordGame">Record Games</g:link>
	</div>
		<div id="leagueTableHeader">
			<h1>League current rankings</h1>
		</div>
		<div id="leagueTableDiv">

			<table id="leagueTable">
				<thead>
					<tr>
						<th class="numColumn">Rank</th>
						<th>Player</th>
						<th class="numColumn">Played</th>
						<th class="numColumn">Won</th>
						<th class="numColumn">Lost</th>
						<th class="numColumn">Points</th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${playerList}" status="i" var="leaguePlayer">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
							<td class="numColumn">
								${fieldValue(bean: leaguePlayer, field: "currentRank")}
							</td>
							<td>
								${fieldValue(bean: leaguePlayer, field: "name")}
							</td>
							<td class="numColumn">
								${fieldValue(bean: leaguePlayer, field: "gamesPlayed")}
							</td>
							<td class="numColumn">
								${fieldValue(bean: leaguePlayer, field: "gamesWon")}
							</td>
							<td class="numColumn">
								${fieldValue(bean: leaguePlayer, field: "gamesLost")}
							</td>
							<td class="numColumn">
								${fieldValue(bean: leaguePlayer, field: "currentPoints")}
							</td>
						</tr>
					</g:each>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
