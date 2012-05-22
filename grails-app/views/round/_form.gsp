<%@ page import="com.richardadamdean.golfer.Round" %>



<div class="fieldcontain ${hasErrors(bean: roundInstance, field: 'course', 'error')} required">
	<label for="course">
		<g:message code="round.course.label" default="Course" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="course" name="course.id" from="${com.richardadamdean.golfer.Course.list()}" optionKey="id" required="" value="${roundInstance?.course?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: roundInstance, field: 'created_at', 'error')} required">
	<label for="created_at">
		<g:message code="round.created_at.label" default="Createdat" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="created_at" precision="day"  value="${roundInstance?.created_at}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: roundInstance, field: 'handicap', 'error')} required">
	<label for="handicap">
		<g:message code="round.handicap.label" default="Handicap" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="handicap" required="" value="${fieldValue(bean: roundInstance, field: 'handicap')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: roundInstance, field: 'round_holes', 'error')} ">
	<label for="round_holes">
		<g:message code="round.round_holes.label" default="Roundholes" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${roundInstance?.round_holes?}" var="r">
    <li><g:link controller="roundHole" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="roundHole" action="create" params="['round.id': roundInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'roundHole.label', default: 'RoundHole')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: roundInstance, field: 'updated_at', 'error')} required">
	<label for="updated_at">
		<g:message code="round.updated_at.label" default="Updatedat" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="updated_at" precision="day"  value="${roundInstance?.updated_at}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: roundInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="round.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${com.richardadamdean.golfer.User.list()}" optionKey="id" required="" value="${roundInstance?.user?.id}" class="many-to-one"/>
</div>

