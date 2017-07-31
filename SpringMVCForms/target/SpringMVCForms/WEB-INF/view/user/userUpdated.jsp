<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring forms :: Users</title>
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">Users app</a>
				</div>
				<div id=navbar class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li><a href="<s:url value='/assignments/' />" title="View assignments">View assignments</a></li>
						<li><a href="<s:url value='/users/' />" title="View users">View users</a></li>
						<li><a href="<s:url value='/users/new' />" title="New user">New user</a></li>
					</ul>
				</div>
			</div>
		</nav>
		
		<div class="container">
			<div class="jumbotron">
				<h1>User created</h1>
			</div>
			<div class="alert alert-success">The following user has been created successfully</div>
			
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
		</div>
		
		<footer class="footer">
			<div class="container">
				<p>&copy; 2017 Roberto</p>
			</div>
		</footer>
	</body>
</html>