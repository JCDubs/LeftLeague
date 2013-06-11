<%@ page import="com.uk.leftyleague.domain.Player" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'player.label', default: 'Player')}" />
		<g:javascript library="jquery" />
<g:javascript library="jquery-ui" />
  		<g:javascript>
$(document).ready(function() {	
        $("#playerOne").autocomplete({
            source: function(request, response){
                $.ajax({
                    url:"${createLink(controller: 'player', action: 'autocompleteSearch')}",
                    data: {
                    term : request.term,
                    selectedPlayer : $("#playerTwoName").val()
                	},
                    success: function(data){
                        response(data);
                    }
                });
            },
            minLength: 2,
            select: function(event, ui) {               
                $("#playerOneName").val(ui.item.value);            
            }
        });
        $("#playerTwo").autocomplete({
            source: function(request, response){
                $.ajax({
                    url:"${createLink(controller: 'player', action: 'autocompleteSearch')}",
                    data: {
                    term : request.term,
                    selectedPlayer : $("#playerOneName").val()
                	},
                    success: function(data){
                        response(data);
                    }
                });
            },
            minLength: 2,
            select: function(event, ui) {               
                $("#playerTwoName").val(ui.item.value);               
            }
        });
    }(jQuery));
</g:javascript>
		<title>League Admin</title>
	</head>
	<body>
				
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
				<div id="newGameDiv">	
				<g:render template="addGameForm"/>			
				</div>
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
