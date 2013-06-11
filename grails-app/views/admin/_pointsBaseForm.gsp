<%@ page import="com.uk.leftyleague.domain.PointBase" %>
<div id="pointsBaseDiv">
<h1>Points Base</h1>

<g:if test="${request.message}">
			<div class="message" role="status">${request.message}</div>
</g:if>
<g:elseif test="${request.error}">
<div class="errors" role="status">${request.error}</div>
</g:elseif>

<p>Please specify the number of points used to calculate the players points for a individual game.</p>
<g:field id="pointsBase" name="pointsBase" min="0" type="number" value="${pointsBase?.basePoints}" required=""/>
<g:remoteLink action="editPointBase" controller="PointBase" update="pointBaseDiv" 
			params="\'version=\'+${pointsBase?.version}+\'&basePoints=\'+document.getElementById(\'pointsBase\').value">
				<g:img class="tableButton" title="Delete Date Muliplier." dir="images/skin" file="database_edit.png" />
			</g:remoteLink>
</div>
