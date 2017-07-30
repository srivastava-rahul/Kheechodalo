<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/icons/fontawesome/font-awesome.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/icons/fontawesome/fontawesome.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/icons/fontawsome-4.7/css/font-awesome.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/themes/admin/slideshow.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/themes/admin/color-schemes/Kheecho-theme.css"/>">
<%-- <link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/themes/admin/kheecholayout.css"/>"> --%>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/bootstrap/css/bootstrap.css"/>">
<title>Kheecho</title>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
</head>

<style>
    body { 
		  background: url(${pageContext.request.contextPath}/resources/images/login_bck.jpg);
		  /* color: white;  */
        }
</style>

<body style="margin: auto;">

	<!-- <div id="loading" class="opacity-60">
		<div class="spinner">
			<div class="bounce1"></div>
			<div class="bounce2"></div>
			<div class="bounce3"></div>
		</div>
	</div>
	 -->
	 
	 <header id="header">
		<tiles:insertAttribute name="header" />
	</header>
	<section id="sidemenu">
		<tiles:insertAttribute name="menu" />
	</section>
	<section id="site-content" class="dvImage">
			<tiles:insertAttribute name="body" />
	</section>
	<footer id="footer">
		<tiles:insertAttribute name="footer" />
	</footer>
