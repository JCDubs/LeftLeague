<%@ page import="com.uk.leftyleague.domain.Player"%>

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
	<g:field id="playerOneGameWon" name="playerOneGameWon" type="number" required=""/></td>
	</tr>
	<tr>
	<td><label for="playerTwo">Player Two:</label></td>
	<td><g:hiddenField id="playerTwoName" name="playerTwoName" />
		<g:textField id="playerTwo" name="playerTwo" required=""/></td>
	<td><label for="playerTwoGameWon">Games Won:</label>
	<g:field id="playerTwoGameWon" name="playerTwoGameWon" type="number" required=""/></td>
	</tr>	
</table>