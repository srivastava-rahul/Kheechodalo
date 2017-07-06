<html>
<body>
Welcome to admin page : ${pageContext.request.userPrincipal.name}
	<form action="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="submit" value="LOGOUT">
	</form>
</body>
</html>
