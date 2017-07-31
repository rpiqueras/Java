<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="jumbotron">
			<h1><s:message code='error.error'></s:message></h1>
		</div>
		<div class="alert alert-danger">${errorMessage }</div>
	</tiles:putAttribute>
</tiles:insertDefinition>