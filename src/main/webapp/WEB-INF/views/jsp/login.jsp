<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign-Up/Login Form</title>
<link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/css/style.css">
 
<style>
body {
	background:
		url(${pageContext.request.contextPath}/resources/images/login_bck.jpg);
	color: white;
}
</style>

<script type="text/javascript">
$(document).ready(function(){
	alert("hi");
    /* Get iframe src attribute value i.e. YouTube video url and store it in a variable */
    var url = $("#cartoonVideo").attr('src');
    
    /* Assign empty url value to the iframe src attribute when
    modal hide, which stop the video playing */
    $("#myModal").on('hide.bs.modal', function(){
    	alert("hello");
        $("#cartoonVideo").attr('src', '');
    });
    
    /* Assign the initially stored url back to the iframe src
    attribute when modal is displayed again */
    $("#myModal").on('show.bs.modal', function(){
    	alert("bye");
        $("#cartoonVideo").attr('src', url);
    });
});

</script>
</head>

<body>
<div style="margin-top: 0.5%; width: 30%; height: 50%; background-color: grey">

	<%-- 	<center>
			<p>
				<span style="font-size: 50px; font-family: Parchment;">kheecho Dalo</span>
			</p>
		</center> --%>
		
			<center>
			<p>
				<img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Avatar" class="page_pic">
			</p>
		</center>

	</div>
	<div style="float: right; margin-right: 1%">
		<button class="buttonvideo" data-tooltip="Visit Here For Site Tour">
			<span id="myBtn">Video </span>
		</button>

	</div>

   <i style="color:yellow">Sign-Up is free and always will be.</br></i>
   <i style="color:red">In-Order to win Prize (Please Complete your profile as soon as you create account).</i>
	
	<!-- The Modal -->
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content" style="display: block;">
			<div class="modal-header">
			 <button type="button" class="close" data-dismiss="modal" aria-l >×</button>
				<!-- <span class="close" data-dismiss="modal">&times;</span> -->
				<h2>Modal Header</h2>
			</div>
			<div class="modal-body" data-reveal data-reset-on-close="true">
				<%-- <iframe  width="700" height="450"  src="${pageContext.request.contextPath}/resources/mtr.mp4" frameborder="0" allowfullscreen></iframe> --%>
				<iframe  id="cartoonVideo" width="740" height="450" src="https://www.youtube.com/embed/Ood3teygwh8?" frameborder="0" allowfullscreen> </iframe>
				<%--          <video width="700" height="450" controls id="myVideoPlay" >
                 <source src="${pageContext.request.contextPath}/resources/mtr.mp4" type="video/mp4"  >
                 </video> --%>

			</div>
			<div class="modal-footer">
				<h3>Modal Footer</h3>
			</div>
		</div>
	</div><br/>
		<div style="color:red;margin-left:50%;background:white; width:10%; "><jsp:include page="/WEB-INF/views/jsp/message.jsp" /></div>
	<div class="form">

		<ul class="tab-group">

			<li class="tab active "><a href="#login">Log In</a></li>
			<li class="tab "><a href="#signup">Sign Up</a></li>

		</ul>

		<div class="tab-content">


			<div id="login">
				<h1>Welcome Back!</h1>

				<form name="loginForm" action="${pageContext.request.contextPath}/login" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

					<div class="field-wrap">
						<label>
							Email Address<span class="req">*</span>
						</label>
						<input name="userName" value="" type="text" />
					</div>

					<div class="field-wrap">
						<label>
							Password<span class="req">*</span>
						</label>
						<input name="password" type="password" />
					</div>

					<p class="forgot">
						<a href="forgetPassword">Forgot Password?</a>
					</p>

					<button type="submit" class="button button-block">Log In</button>
				</form>

			</div>
			<div id="signup">
				<h1>Sign Up for Free</h1>

				<form action="saveUser" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					<div class="top-row">
						<div class="field-wrap">
							<label>
								First Name<span class="req">*</span>
					</label>
							<input type="text" id="firstName" name="firstName" />
						</div>

						<div class="field-wrap">
							<label>
								Last Name<span class="req"></span>
							</label>
							<input type="text" id="lastName" name="lastName" />
						</div>
					</div>

					<div class="field-wrap">
						<label>
							Email Address<span class="req">*</span>
						</label>
						<input type="email" id="email" name="email" />
					</div>

					<div class="field-wrap">
						<label>
							Set A Password<span class="req">*</span>
						</label>
						<input type="password" id="password" name="password" />
					</div>	
										
					<button type="submit" class="button button-block">Get Started</button>

				</form>

			</div>
		</div>
		<!-- tab-content -->

	</div>
	<!-- /form -->

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/js/view/index.js"></script>

	<script src="${pageContext.request.contextPath}/resources/js/view/video.js"></script>
	<div style="margin-top: 10%; margin-left: 2%; width: 20%;">

		<img src="${pageContext.request.contextPath}/resources/images/itg.jpg" alt="Avatar" style="width: 313px; height: 320px; margin: 4px">

	</div>

	<div class="chip">
		<img src="${pageContext.request.contextPath}/resources/images/icon-prize.jpg" alt="Person" width="96" height="96"> Winner
	</div>


	<div style="margin-top: 7%; width: 100%; height: auto; background-color:">
		<div style="margin-bottom: 0px; background-color: #06ccb3;" align="center">&copy; 2018 All rights reserved</div>
		&nbsp;
		<div style="color: black">
			<a href="${pageContext.request.contextPath}/user/privacyOuter">Privacy</a>
			&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
			<a href="${pageContext.request.contextPath}/user/termsConditionOuter">Terms & Condition</a>
			&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
			<a href="${pageContext.request.contextPath}/user/signupdataOuter">Signup -Data</a>
			&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
			<a href="${pageContext.request.contextPath}/user/rulesouter">Rules</a>
			&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
			<a href="${pageContext.request.contextPath}/user/contactusOuter">Contact</a>
			&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
			<%-- <a href="">Cookies</a> --%>
		</div>
	</div>

</body>
</html>