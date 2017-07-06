<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>USER</title>
</head>
<body>
<form:form modelAttribute="user" action="saveUser">
User Name : <form:input path="userName" type="text"/>
Password : <form:input path="password" type="password"/>
<!-- admin : <input type="checkbox" value="true"/>  -->
<form:button type="submit">create</form:button>
</form:form>


</body>
</html>