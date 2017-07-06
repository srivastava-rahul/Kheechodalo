<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<body>
	<sec:authorize access="hasRole('BUYER') or hasRole('ADMIN')">
Welcome to Admin home page : ${pageContext.request.userPrincipal.name}
</sec:authorize>
	<br />

	<sec:authorize access="hasRole('SUPPLIER')">
Welcome to Supplier home page : ${pageContext.request.userPrincipal.name}
</sec:authorize>
	<br />

	<sec:authorize access="hasRole('BUYER') or hasRole('ADMIN')">
Welcome to Buyer home page : ${pageContext.request.userPrincipal.name}
</sec:authorize>
	<br />

	<sec:authentication var="userName" property="principal.userName" />
	User Name : ${userName}
	<br />
	<sec:authentication var="password" property="principal.password" />
	password : ${password}

	<form action="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> <input type="submit" value="LOGOUT">
	</form>
</body>
</html>
