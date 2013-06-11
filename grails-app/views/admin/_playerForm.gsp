<%@ page import="com.uk.leftyleague.domain.Player"%>

<h1>League Players</h1>
<br/>
<g:if test="${request.message}">
			<div class="message" role="status">${request.message}</div>
</g:if>
<g:elseif test="${request.error}">
<div class="errors" role="status">${request.error}</div>
</g:elseif>
<h5>Add a new player.</h5>
<table>
<tr>
<td><label for="playerName"> Players: </label></td>
<td><g:field id="playerName" name="playerName" type="text" required=""/></td>
<td><label for="newRank"> Rank: </label></td>
<td><g:field id="newRank" name="newRank" type="number" value="0" min="0" required=""/></td>
<td><g:remoteLink action="addPlayer" controller="player" update="playersDiv" params="\'playerName=\'+document.getElementById(\'playerName\').value+\'&rank=\'+document.getElementById(\'newRank\').value">

					<g:img class="tableButton add" title="Add a new League Player."
							dir="images" file="add.png"/></g:remoteLink></td>
				</tr>
				</table>
				<h5>Existing Players.</h5>
				<br/>
<table>
	<thead>
		<tr>
			<g:sortableColumn property="name" title="${message(code: 'player.name.label', default: 'Name')}" />		
			<g:sortableColumn property="rank" title="${message(code: 'player.currentRank.label', default: 'Rank')}" />
		</tr>
	</thead>
	<tbody>
		<g:each in="${leaguePlayerList}" status="i" var="playerInstance">
			<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
				<td>
					${playerInstance.name }
				</td>
				<td>
					${playerInstance.currentRank }
				</td>
				<td><g:remoteLink action="deletePlayer" controller="player" update="playersDiv" params="\'id=\'+${playerInstance.id }">

					<g:img class="tableButton add" title="Delete League Player."
							dir="images" file="delete.png"/></g:remoteLink></td>
			</tr>
		</g:each>
	</tbody>
</table>