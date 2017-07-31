<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
			<div class="jumbotron">
				<h1>Users list</h1>
				<p>These are the users currently in the system.</p>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>Login</th>
						<th>Description</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.login }</td>
							<td>${user.description }</td>
							<td>
								<a class="btn btn-sm btn-primary" href="<s:url value='/users/${user.id }' />" title="Detailed info">See detail</a>
								<a class="btn btn-sm btn-success" href="<s:url value='/users/update/${user.id }' />" title="Update">Update</a>
								<a class="btn btn-sm btn-danger" href="<s:url value='/users/delete/${user.id }' />" title="Delete">Delete</a>	
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</tiles:putAttribute>
</tiles:insertDefinition>