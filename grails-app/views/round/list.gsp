
<%@ page import="com.richardadamdean.golfer.Round" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'round.label', default: 'Round')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-round" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-round" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="round.course.label" default="Course" /></th>
					
						<g:sortableColumn property="created_at" title="${message(code: 'round.created_at.label', default: 'Createdat')}" />
					
						<g:sortableColumn property="handicap" title="${message(code: 'round.handicap.label', default: 'Handicap')}" />
					
						<g:sortableColumn property="updated_at" title="${message(code: 'round.updated_at.label', default: 'Updatedat')}" />
					
						<th><g:message code="round.user.label" default="User" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${roundInstanceList}" status="i" var="roundInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${roundInstance.id}">${fieldValue(bean: roundInstance, field: "course")}</g:link></td>
					
						<td><g:formatDate date="${roundInstance.created_at}" /></td>
					
						<td>${fieldValue(bean: roundInstance, field: "handicap")}</td>
					
						<td><g:formatDate date="${roundInstance.updated_at}" /></td>
					
						<td>${fieldValue(bean: roundInstance, field: "user")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${roundInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
