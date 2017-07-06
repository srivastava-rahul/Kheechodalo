<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<head>
  <meta charset="UTF-8">
  <title>Forget Password</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/css/style.css">
  
</head>

<body> 
			    <div  class="Forgett_password_form" >
                                                <!-- header -->
					<div class="forgetformheader" align="center">  
					<h1>Recover Your Password</h1>
					</div>
        		      <br/>
					 <form name="forgetForm" action="recoverPassword" method="post">
					  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					<div class="forgetformboby">
				    <h2>Please enter your email address </h2>
					<input type="email" id="email" name="email" class ="form-control" placeholder="Please Enter your email-id"/></p>
					</div>	
				<br/><br/>
			<div class="forgetformfooter" align="right">
			<button type="submit" class="button_submit  submit">Send</button>
			<button class="button_submit  submit" style="width: 98px;margin-right: 12px">Cancel</button>
		</div>
		</form>
	</div>

</body>

</html>