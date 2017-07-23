<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<title><tiles:insertAttribute name="title" /></title>

<script src="<c:url value="/resources/assets/widgets/jquery-ui.min/jquery-1.11.3.min.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/themes/admin/fonts/opensans-font.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/bootstrap/css/bootstrap.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/icons/fontawesome/fontawesome.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/helpers/colors.css"/>">
</head>

<body >
	<section id="site-content" > <tiles:insertAttribute name="body" /> </section>

</body>
</html>