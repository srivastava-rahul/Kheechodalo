<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<c:if test="${param.error == true}">
Invalid user name and password.
</c:if>

<c:if test="${param.logout == true}">
you have logged out successfully.
</c:if>
	<form name="loginForm" action="login" method="post">
		User Name : <input name="userName" value="" type="text" /> 
		Password :  <input name="password" type="password" /> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="submit" value="Submit">
	</form>
</body>
</html>
