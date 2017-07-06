<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="body-area">

	<c:if test="${not empty error}">
		<div class="alert alert-danger" id="idGlobalError">
			<div class="">
				<!-- <i class="glyph-icon icon-times"></i> -->
			</div>
			<div class="alert-content">
				<!-- <h4 class="alert-title">Error</h4> -->
				<c:choose>
					<c:when test="${!empty error && error.getClass().simpleName eq 'String'}">
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
	<div class="Changepassword_password_form">
		<!-- header -->
		<div class="Changepasswordformheader">
			<center>
				<b><h1>Find Your Account</h1>
					<b>
			</center>
		</div>

		<form name="newChangeForm" action="changeNewPassword" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<div class="Changepasswordformboby">
				<h3 style="color: red">Please Enter old Password</h3>
				<input type="text" id="oldPassword" name="oldPassword" class="Changepassword_form-control" placeholder="Enter your old Password" />
			</div>

			<div class="Changepasswordformboby">
				<h3 style="color: blue">Enter new Password</h3>
				<input type="text" id="newPassword" name="newPassword" class="Changepassword_form-control" placeholder="Enter new Password" />
			</div>

			<div class="Changepasswordformboby">
				<h3 style="color: blue">Confirm new Password</h3>
				<input type="text" id="confirmPassword" name="confirmPassword" class="Changepassword_form-control" placeholder="Confirm new Password" />
			</div>


			<br />

			<!-- footer -->
			<div class="Changepasswordformfooter" align="right">
				<button type="submit" class="button_submit  submit">Reset</button>
				<c:url value="/user/dashboard" var="dashUrl" />
							<a href="${dashUrl}" class="">
								cancel
							</a>
				
				<!-- <button class="button_submit  submit" style="width: 98px; margin-right: 12px">Cancel</button> -->
			</div>

		</form>


	</div>



























</div>