<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
$(document).ready(function(){

    $("#oldPassword").focus();

    $("#pwcheck").click(function(){
        if ($("#pwcheck").is(":checked"))
        {
            $("#oldPassword").clone()
            .attr("type", "text").insertAfter("#oldPassword")
            .prev().remove();
        }
        else
        {
            $("#oldPassword").clone()
            .attr("type","password").insertAfter("#oldPassword")
            .prev().remove();
        }
    });
});
</script>


<div class="body-area">

<br/><br/>
	<jsp:include page="/WEB-INF/views/jsp/message.jsp" />
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
				<h3 style="color: blue">Please Enter old Password</h3>
				<input type="password" id="oldPassword" name="oldPassword" class="Changepassword_form-control" placeholder="Enter your old Password" required="true"/>
		       <div align="right" style ="margin-right: 18px;">
		        <input type="checkbox" id="pwcheck" />Show Password
	</div>
			</div>

			<div class="Changepasswordformboby">
				<h3 style="color: blue">Enter new Password</h3>
				<input type="password" id="newPassword" name="newPassword" class="Changepassword_form-control" placeholder="Enter new Password" required="true" />
			</div>

			<div class="Changepasswordformboby">
				<h3 style="color: blue">Confirm new Password</h3>
				<input type="password" id="confirmPassword" name="confirmPassword" class="Changepassword_form-control" placeholder="Confirm new Password" required="true"/>
			</div>


			<br />

			<!-- footer -->
			 <div class="Changepasswordformfooter" align="right">
			 
			<button type="submit" class="button_submit  submit">Reset</button>
				
				<c:url value="/user/dashboard" var="dashUrl" />
							<a href="${dashUrl}" class="button_submit  submit" style="margin-right: 12px;">
								Cancel
							</a>
				
			</div>

		</form>


	</div>



























</div>