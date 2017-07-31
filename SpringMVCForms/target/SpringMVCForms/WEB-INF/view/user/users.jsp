<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring forms :: Users</title>
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Users app</a>
			</div>
			<div id=navbar class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<s:url value='/assignments/' />" title="<s:message code='navbar.assignments'></s:message>"><s:message code='navbar.assignments'></s:message></a></li>
					<li><a href="<s:url value='/users/' />" title="<s:message code='navbar.users'></s:message>"><s:message code='navbar.users'></s:message></a></li>
					<li><a href="<s:url value='/users/new' />" title="<s:message code='navbar.newUser'></s:message>"><s:message code='navbar.newUser'></s:message></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><s:message code='navbar.language'></s:message> <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="?locale=es"><img src="blank.gif" class="flag flag-es"/><s:message code='navbar.language.spanish'></s:message></a></li>
							<li><a href="?locale=en"><img src="blank.gif" class="flag flag-gb"/><s:message code='navbar.language.english'></s:message></a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
		
		<div class="container">
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
		</div>
		
		<footer class="footer">
			<div class="container">
				<p>&copy; 2017 Roberto</p>
			</div>
		</footer>
	</body>
</html>