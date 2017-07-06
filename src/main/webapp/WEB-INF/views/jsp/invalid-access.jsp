<html>
<body>
Welcome to Invalid page : ${pageContext.request.userPrincipal.name}
	<h2>You are not authorized to access this page</h2>
	<form action="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="submit" value="LOGOUT">
	</form>
</body>
</html>
