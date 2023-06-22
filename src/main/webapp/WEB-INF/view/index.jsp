
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>User</title>
	<script src="<c:url value="/resources/jquery/jquery-3.7.0.min.js" />"></script>
	<link href="<c:url value='/resources/css/style.css' />" rel="stylesheet">
	<script src="<c:url value="/resources/js/addUser.js" />"></script>
</head>
<body>
	<form:form method="post" action="" modelAttribute="userForm">
		<label for="username">Username</label>
		<br/>
		<form:input type="text" name="username" id="username" path="username"/>
		<br/>
		<label for="password">Password</label>
		<br/>
		<form:input type="password" name="password" id="password" path="password"/>
		<br/>
		<input type="submit" value="Login"/>
	</form:form>
</body>
</html>