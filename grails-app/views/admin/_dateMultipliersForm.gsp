<%@ page import="com.uk.leftyleague.domain.DateMultiplier"%>
<h1>Date Multipliers</h1>
<br/>
<g:if test="${request.message}">
			<div class="message" role="status">${request.message}</div>
</g:if>
<g:elseif test="${request.error}">
<div class="errors" role="status">${request.error}</div>
</g:elseif>

<h5>New Date Multiplier</h5>
<br/>
<table>
<tr>
	<td><label for="newNumOfDays"> Number of Days: </label></td>
	<td><g:field name="newNumOfDays" type="number" value="0" required=""/></td>
	<td><label for="newMultiplier"> Multiplier: </label></td>
	<td><g:field name="newMultiplier" type="number decimal" value="0.0" required=""/></td>
	<td><g:remoteLink action="newDateMultiplier" controller="dateMultiplier" update="dateMultiplierDiv"
					params="\'newNumOfDays=\'+document.getElementById(\'newNumOfDays\').value+\'&newMultiplier=\'+document.getElementById(\'newMultiplier\').value">

					<g:img class="tableButton add" title="Add a new Date Multiplier."
							dir="images" file="add.png"/></g:remoteLink></td>

</tr>
</table>
<br/>		
<h5>Existing Date Multipliers</h5>
<br/>	
<table>
	<tr>
		<th>Number of Days</th>
		<th>Multiplier</th>
		<th></th>
	</tr>	
	<g:each in="${dateMultipliersList}" status="i" var="dateMultiplierInstance">
		<tr>
			<td><g:field id="numOfDays${i}" name="numOfDays${i}" type="number"
					value="${dateMultiplierInstance.numOfDays}" required="" /></td>
			<td><g:field id="multiplier${i}" name="multiplier${i}" type="number decimal"
					value="${dateMultiplierInstance.multiplier}" required="" /></td>
			<td class="button-column">
			<g:remoteLink action="editDateMultiplier" controller="DateMultiplier" update="dateMultiplierDiv" 
			params="\'id=\'+${dateMultiplierInstance.id}+\'&version=\'+${dateMultiplierInstance.version}+\'&numOfDays=\'+document.getElementById(\'numOfDays\'+${i}).value+\'&multiplier=\'+document.getElementById(\'multiplier\'+${i}).value">
				<g:img class="tableButton" title="Edit Date Muliplier." dir="images/skin" file="database_edit.png" />
			</g:remoteLink>
			&nbsp;
			<g:remoteLink action="deleteDateMultiplier" before="if(!confirm('Are you sure you want to delete this date multiplier?')) return false" controller="DateMultiplier" update="dateMultiplierDiv" params="\'id=\'+${dateMultiplierInstance.id }">
				<g:img class="tableButton" title="Delete Date Muliplier." dir="images" file="delete.png" />
			</g:remoteLink>			
			</td>
		</tr>
	</g:each>
</table>