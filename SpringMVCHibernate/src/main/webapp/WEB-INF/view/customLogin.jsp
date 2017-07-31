<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>My custom login</title>
	</head>
	<body>
		<h1>My custom login</h1>
		<h2>This has been tailored</h2>
		<form name="loginForm" action="<c:url value='j_spring_security_check'/>" method="POST">
			<table>
				<tr>
					<td>Username:</td>
					<td><input type='text' name='username' value=''/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password'/></td>
				</tr>
				<tr>
					<td colspan='2'><input type='submit' name='submit' value='submit'/></td>
				</tr>
			</table>
			<input type='hidden' name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
		<p><a href="<c:url value='/public'/>">Go to public</a></p>
		<p><a href="<c:url value='/admin'/>">Go to admin</a></p>
		<p><a href="<c:url value='/j_spring_security_logout'/>">Logout</a></p>
	</body>
</html>