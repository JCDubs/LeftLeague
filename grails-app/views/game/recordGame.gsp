<%@ page import="com.uk.leftyleague.domain.Game"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">

<title><g:message code="default.create.label"
		args="[entityName]" /></title>
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
</head>
<body>

	<div id="create-game" class="content scaffold-create" role="main">
        <g:link class="buttons nav" controller="Game" action="leagueRankings">League Rankings</g:link>
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

		<g:form action="addGame">
			<fieldset class="form">
				<div id="newGameDiv">
					<g:render template="addGameForm" />
				</div>
			</fieldset>
			<fieldset class="buttons">
				<g:submitButton name="create" class="save" value="Save Games" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>
