
<%@ page import="com.richardadamdean.golfer.Round" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'round.label', default: 'Round')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-round" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-round" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list round">
			
				<g:if test="${roundInstance?.course}">
				<li class="fieldcontain">
					<span id="course-label" class="property-label"><g:message code="round.course.label" default="Course" /></span>
					
						<span class="property-value" aria-labelledby="course-label"><g:link controller="course" action="show" id="${roundInstance?.course?.id}">${roundInstance?.course?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${roundInstance?.created_at}">
				<li class="fieldcontain">
					<span id="created_at-label" class="property-label"><g:message code="round.created_at.label" default="Createdat" /></span>
					
						<span class="property-value" aria-labelledby="created_at-label"><g:formatDate date="${roundInstance?.created_at}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${roundInstance?.handicap}">
				<li class="fieldcontain">
					<span id="handicap-label" class="property-label"><g:message code="round.handicap.label" default="Handicap" /></span>
					
						<span class="property-value" aria-labelledby="handicap-label"><g:fieldValue bean="${roundInstance}" field="handicap"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${roundInstance?.round_holes}">
				<li class="fieldcontain">
					<span id="round_holes-label" class="property-label"><g:message code="round.round_holes.label" default="Roundholes" /></span>
					
						<g:each in="${roundInstance.round_holes}" var="r">
						<span class="property-value" aria-labelledby="round_holes-label"><g:link controller="roundHole" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${roundInstance?.updated_at}">
				<li class="fieldcontain">
					<span id="updated_at-label" class="property-label"><g:message code="round.updated_at.label" default="Updatedat" /></span>
					
						<span class="property-value" aria-labelledby="updated_at-label"><g:formatDate date="${roundInstance?.updated_at}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${roundInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="round.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${roundInstance?.user?.id}">${roundInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${roundInstance?.id}" />
					<g:link class="edit" action="edit" id="${roundInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
