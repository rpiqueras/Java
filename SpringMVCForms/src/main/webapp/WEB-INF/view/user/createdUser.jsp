<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
			<div class="jumbotron">
				<h1>User updated</h1>
			</div>
			<div class="alert alert-success">The following user has been updated successfully</div>
			
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Login</th>
						<th>Description</th>
						<th>Password</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${user.id }</td>
						<td>${user.login }</td>
						<td>${user.description }</td>
						<td>${user.password }</td>
					</tr>
				</tbody>
			</table>
	</tiles:putAttribute>
</tiles:insertDefinition>