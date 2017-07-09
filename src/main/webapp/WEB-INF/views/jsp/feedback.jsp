<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">
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

	<div class="Changepassword_password_form">
		<!-- header -->
		<div class="Changepasswordformheader">
			<center>
				<b><h1>Feedback Form</h1>
					<b>
			</center>
		</div>

		<form name="quickhelpForm" action="feedbackData" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">>
		<!-- 	<div class="Changepasswordformboby">
				<h2 style="color: red">Please enter Button name or screen which
					is not working</h2>
				<input type="text" class="Changepassword_form-control" name="problem" id="problem"
					placeholder="Please Enter Page or button name" />
			</div>
 -->
			<div class="Changepasswordformboby">
				<h2 style="color: red">Please enter your Feedback......!!!</h2>
				<div style="margin-left: 8%">
					<textarea name= "quickDesc" id="quickDesc" rows="5" cols="62" style="color: black"
						placeholder="Please provide a detailed description of your Problems or suggestions."
						 aria-required="true"></textarea>
				</div>
			</div>

			<br />
			<div class="Changepasswordformfooter" align="right">
				<button type="submit" class="button_submit  submit">Send</button>
				
				<!-- <a href="" class="button_submit  submit"> Send </a> --> &nbsp;&nbsp;
				&nbsp;&nbsp;

				<c:url value="/user/dashboard" var="dashUrl" />
				<a href="${dashUrl}" class="button_submit  submit"> Cancel </a>
				<!-- <button class="Changepassword_button_submit  submit">Send</button> -->
			</div>
		</form>
	</div>
</div>