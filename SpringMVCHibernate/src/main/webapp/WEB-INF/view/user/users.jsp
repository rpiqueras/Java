<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
			<div class="jumbotron">
				<h1><s:message code='users.title'></s:message></h1>
				<p><s:message code='users.description'></s:message></p>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th><s:message code='users.login'></s:message></th>
						<th><s:message code='users.descriptions'></s:message></th>
						<th><s:message code='users.actions'></s:message></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.login }</td>
							<td>${user.description }</td>
							<td>
								<a class="btn btn-sm btn-primary" href="<s:url value='/users/${user.id }' />" title="<s:message code='users.detail'></s:message>"><s:message code='users.detail'></s:message></a>
								<a class="btn btn-sm btn-success" href="<s:url value='/users/update/${user.id }' />" title="<s:message code='users.update'></s:message>"><s:message code='users.update'></s:message></a>
								<a class="btn btn-sm btn-danger" href="<s:url value='/users/delete/${user.id }' />" title="<s:message code='users.delete'></s:message>"><s:message code='users.delete'></s:message></a>	
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</tiles:putAttribute>
</tiles:insertDefinition>