<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:if test="${not empty success}">
		<div class="alert alert-success" id="idGlobalSuccess">
			<div class="">
				<!-- <i class="fa fa-key" aria-hidden="true"></i> -->
			</div>
			<div class="alert-content" style="text-align: left; padding-bottom: 12px; font-size: 16px; color: blue">
				<!-- <h4 class="alert-title">Success</h4> -->
				<c:choose>
					<c:when test="${!empty success && success.getClass().simpleName eq 'String'}">
					${success}
				</c:when>
					<c:otherwise>
						<c:forEach var="msg" items="${success}">
						${msg}<br />
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</c:if>
 

<c:if test="${not empty info}">
	<div class="alert alert-notice" id="idGlobalInfo">
		<div class="">
		</div>
		<div class="alert-content">
			<h4 class="alert-title">Info</h4>
			<c:choose>
				<c:when test="${!empty info && info.getClass().simpleName eq 'String'}">
					${info}
				</c:when>
				<c:otherwise>
					<c:forEach var="msg" items="${info}" >
						${msg}<br />
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</c:if>

	<c:if test="${not empty error}">
		<div class="alert alert-danger" id="idGlobalError">
			<div class="">
				<!-- <i class="glyph-icon icon-times"></i> -->
			</div>
			<div class="alert-content">
				<!-- <h4 class="alert-title">Error</h4> -->
				<c:choose>
					<c:when
						test="${!empty error && error.getClass().simpleName eq 'String'}">
					${error}
				</c:when>
					<c:otherwise>
						<c:forEach var="msg" items="${error}">
						${msg}<br />
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</c:if>

