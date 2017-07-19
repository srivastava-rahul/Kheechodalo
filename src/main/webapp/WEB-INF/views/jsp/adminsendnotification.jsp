<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">
	<jsp:include page="/WEB-INF/views/jsp/message.jsp" />
	<div class="Changepassword_password_form">
		<!-- header -->
		<div class="Changepasswordformheader">
			<center>
				<b><h1>Admin Notification Form</h1>
					<b>
			</center>
		</div>

		<form name="feedbackForm" action="feedbackData" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<div class="Changepasswordformboby">
				<h2 style="color: red">Please Provide your Notification......!!!</h2>
				<div style="margin-left: 1%">
					<textarea name= "feedback" id="feedback" rows="5" cols="66" style="color: black"
						placeholder="Please provide a detailed description of your notification."
						 aria-required="true"></textarea>
				</div>
			</div>

			<br />
			<div class="Changepasswordformfooter" align="right">
				<button type="submit" class="button_submit  submit">Send</button>&nbsp;&nbsp;

				<c:url value="/user/dashboard" var="dashUrl" />
				<a href="${dashUrl}" class="button_submit  submit" style="margin-right: 12px;" style="margin-right: 12px;"> Cancel </a>
			</div>
		</form>
	</div>
</div>

<style>
.Changepassword_password_form{
margin-bottom: auto; !important;
}

</style>