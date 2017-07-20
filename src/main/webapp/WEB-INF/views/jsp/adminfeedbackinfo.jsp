<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">
	<img src="${pageContext.request.contextPath}/resources/images/aboutUs.jpg" alt="Avatar" class="page_pic">
	<div class="information">
		<p class="header_information">User   Feedback    Information</p>
	</div>
		<p>	
	
	         <form name="deleteForm" action="" method="post">
			   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			
			<div class="Changepasswordformboby">
				<h3 style="color: yellow">Please tell What to be deleted enter the id... </h3>
				<input type="text" class="Changepassword_form-control" name="problem" id="problem"
					placeholder="Please Enter Page or button name" />
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
               
	
	</p>
</div>