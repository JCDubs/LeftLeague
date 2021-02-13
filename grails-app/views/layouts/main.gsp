<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Left League</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}"
	type="text/css">
<g:set var="projectsLabel" value="Projects" />
<g:set var="permissionsLabel" value="Permissions" />
<g:set var="helpLabel" value="Help" />
<g:layoutHead />
<r:layoutResources />
</head>
<body>
	<div id="Header" role="banner">	
		<h1 id = "mainHeader">Lefty Squash League</h1>		
		<div class="loginDetails">
			<sec:ifLoggedIn>
				<p>You are logged in as</p> <h3><sec:loggedInUserInfo field="displayname" /></h3>
				
					<g:link controller="Logout">[Logout]</g:link>
				
			</sec:ifLoggedIn>
		</div>		
	</div>
	<div id="ContentDiv">
		<div id="page-content">
			<g:layoutBody />
		</div>

	</div>
	<div id="spinner" class="spinner" style="display: none;">
		<g:message code="spinner.alt" default="Loading&hellip;" />
	</div>
	<g:javascript library="application" />
	<r:layoutResources />
</body>
</html>
