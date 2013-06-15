<%@ page import="com.uk.leftyleague.domain.Player" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'player.label', default: 'Player')}" />
		<g:javascript library="jquery" />
<g:javascript library="jquery-ui" />
  		
		<title>League Admin</title>
	</head>
	<body>
    <g:link class="buttons nav" controller="Game" action="leagueRankings">League Rankings</g:link>
		<div id="settingsDiv"  role="main">

			<h1>League Admin</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${playerInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${playerInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form method="post" >
				<fieldset class="form">
				<div class="rowContainer">				
				<div id="pointBaseDiv">
				<g:render template="pointsBaseForm"/>
				</div>
				</div>
				<div class="rowContainer">
				<div id="dateMultiplierDiv">
				<g:render template="dateMultipliersForm"/>
				</div>
				<div id="playersDiv">
				<g:render template="playerForm"/>
				</div>
				</div>
				</fieldset>
				
			</g:form>
		</div>
	</body>
</html>
