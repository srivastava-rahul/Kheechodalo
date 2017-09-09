<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.form-validator.min.js"></script> 

<div class="body-area">
<br/><br/>
		<jsp:include page="/WEB-INF/views/jsp/message.jsp" />
	<div class="Changepassword_password_form">
		<!-- header -->
		<div class="Changepasswordformheader">
			<center>
				<b><h1>Quick Help</h1>
					<b>
			</center>
		</div>

		<form name="quickhelpForm" action="quickHelpData" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<div class="Changepasswordformboby">
				<h3 style="color: blue">Please tell the Problem you are facing... </h3>
				<input type="text" class="Changepassword_form-control" name="problem" id="problem" required="true"
					placeholder="Please Enter Page or button name" data-validation="length" data-validation-length="3-20" />
			</div>

			<div class="Changepasswordformboby">
				<h3 style="color: blue">Please Provide Decsription of your Problem...</h3>
				<div style="margin-left: 1%">
					<textarea name= "quickDesc" id="quickDesc" rows="5" cols="29" style="color: black"
						placeholder="Please provide a detailed description of your Problems or suggestions."
						 aria-required="true" data-validation="length" data-validation-length="2-800"></textarea>
				</div>
			</div>

			<br />
			<div class="Changepasswordformfooter" align="right">
				<button type="submit" class="button_submit  submit">Send</button>
				
				<!-- <a href="" class="button_submit  submit"> Send </a> --> &nbsp;&nbsp;
				&nbsp;&nbsp;

				<c:url value="/user/dashboard" var="dashUrl" />
				<a href="${dashUrl}" class="button_submit  submit"  style="margin-right: 12px;"> Cancel </a>
			</div>
		</form>
	</div>
</div>

<script>
  $.validate({
    lang: 'en'
  });
</script>