<%@ page import="com.uk.leftyleague.domain.Player"%>

<h1>Add New Game</h1>
<br />
<g:if test="${request.message}">
	<div class="message" role="status">
		${request.message}
	</div>
</g:if>
<g:elseif test="${request.error}">
	<div class="errors" role="status">
		${request.error}
	</div>
</g:elseif>
<h5>Record a new game event.</h5>
<table>
	<tr>
		<td><label for="gameDate"> Game Date: </label></td>
		<td colspan="2"><g:datePicker id="gameDate" name="gameDate" precision="day" required=""/></td>
	</tr>
	<tr>
	<td><label for="playerOne">Player One:</label></td>
	<td><g:hiddenField id="playerOneName" name="playerOneName" />
		<g:textField id="playerOne" name="playerOne" required=""/></td>
	<td><label for="playerOneGameWon">Games Won:</label>
	<g:field id="playerOneGameWon" name="playerOneGameWon" type="number" value="0" required=""/></td>
	</tr>
	<tr>
	<td><label for="playerTwo">Player Two:</label></td>
	<td><g:hiddenField id="playerTwoName" name="playerTwoName" />
		<g:textField id="playerTwo" name="playerTwo" required=""/></td>
	<td><label for="playerTwoGameWon">Games Won:</label>
	<g:field id="playerTwoGameWon" name="playerTwoGameWon" type="number" value="0" required=""/></td>
	</tr>
	<tr>
		<td colspan="3" class="centeredColumn">
		<g:remoteLink action="addGame" controller="Game" update="newGameDiv" params="\'gameDay=\'+document.getElementById(\'gameDate_day\').value+\'&gameMonth=\'+document.getElementById(\'gameDate_month\').value+\'&gameYear=\'+document.getElementById(\'gameDate_year\').value+\'&playerOne=\'+document.getElementById(\'playerOneName\').value+\'&playerTwo=\'+document.getElementById(\'playerTwoName\').value+\'&playerOneWon=\'+document.getElementById(\'playerOneGameWon\').value+\'&playerTwoWon=\'+document.getElementById(\'playerTwoGameWon\').value">
		

				<g:img class="tableButton add" title="Add a new League Game." dir="images" file="add.png" />
			</g:remoteLink></td>
	</tr>
</table>