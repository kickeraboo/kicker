<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<tag:notloggedin>
		<a href="SignInServlet">Sign in with Facebook</a>
	</tag:notloggedin>
	<tag:loggedin>
		<h1>Welcome ${LoggedUser.getEmail()}</h1>
		<a href="./SignOutServlet">logout</a>
	</tag:loggedin>
</body>
</html>