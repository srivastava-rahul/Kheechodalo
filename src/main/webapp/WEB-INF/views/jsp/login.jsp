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
<title>KheechoDalo Sign-Up/Login Form</title>
<meta name="description" content="Login to Kheecho-Dalo to share your pictures and win exicting prizes in daily photo contest for free.. | KheechoDalo.com">
<meta name="Keyword"  content="
cute ,cute baby, cute girls, earn money online, photographs, online photography ,Photo competion, indian competition, vote photo, vote pic, Beautiful pic , pic upload , photo upload, indian photography, photo contest, photo sharing, free |KheechoDalo.com
">
<meta name="author" content="Kheechodalo origination |KheechoDalo.com">


<link rel="icon"  type="image/jpg" href="${pageContext.request.contextPath}/resources/images/logo4.png"/>
<link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/css/style.css">

<style>
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content1 {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
     width: auto; 
     
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

body {
	background:
		    /*  url(${pageContext.request.contextPath}/resources/images/loginpagebackimage.jpeg); */   
		  url(${pageContext.request.contextPath}/resources/images/8.jpg); 
		   height:auto;
	       color: white;
	   
	   
}
</style>
</head>

<body>


     <!-- Code for header start here -->
     <div>
    <div style="background-color: darkturquoise;width:100%;height:100% " >
    
	     <span>
	          <img src="${pageContext.request.contextPath}/resources/images/logofinal.png" alt="Avatar" class="" style="width:3%;float:left;margin:0.1% "/>
	     </span> &nbsp;&nbsp;&nbsp;
	       <span>
	          <font style="margin-top: 30%;font-size: 44px;color:white;">kh��chodalo</font>
	      </span>
	      <span style="float:right;">
	            <button class="buttonvideo" data-tooltip="Visit Here For Site Tour">
		  <span id="myBtn">Demo </span>
		         </button>
		  </span><br/>
	</div>
	</div>
	
     <!-- Code for header end here -->
     
     <i style="color:blue;">Sign Up for free and Win Prize Money*. Note: Please Complete your profile as soon as you create account</i>
	
	
	<!-- The Modal -->
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content" style="display: block;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-l>�</button>
				<!-- <span class="close" data-dismiss="modal">&times;</span> -->
				<h2>Site Tour</h2>
			</div>
			<div class="modal-body" data-reveal data-reset-on-close="true">
				<%-- <iframe  width="700" height="450"  src="${pageContext.request.contextPath}/resources/mtr.mp4" frameborder="0" allowfullscreen></iframe> --%>
				<iframe id="cartoonVideo" width="700" height="450" src="https://www.youtube.com/embed/T36PCp3bttU" frameborder="0" allowfullscreen> </iframe>
				<%--          <video width="700" height="450" controls id="myVideoPlay" >
                 <source src="${pageContext.request.contextPath}/resources/mtr.mp4" type="video/mp4"  >
                 </video> --%>

			</div>
			<div class="modal-footer">
				<h3>Welcome To Kheechodalo.com  Stay Connected by SingUp</h3>
			</div>
		</div>
	</div>
	<br />
	<div style="color: red; margin-left: 8%; background: grey; width:15%;"><jsp:include page="/WEB-INF/views/jsp/message.jsp" /></div>

	
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
							Email Address
							<span class="req">*</span>
						</label>
						<input name="userName" value="" type="text" />
					</div>

					<div class="field-wrap">
						<label>
							Password
							<span class="req">*</span>
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
								First Name
								<span class="req">*</span>
							</label>
							<input type="text" id="firstName" name="firstName" />
						</div>

						<div class="field-wrap">
							<label>
								Last Name
								<span class="req"></span>
							</label>
							<input type="text" id="lastName" name="lastName" />
						</div>
					</div>
                  <font style="color:red"> Please provide a valid email-id otherwise your account will be deactivated in a day</font>
					<div class="field-wrap">
						<label>
							Email Address 
							<span class="req">*</span>
						</label>
						
						<input type="email" id="email" name="email" />
					</div>

					<div class="field-wrap">
						<label>
							Set A Password
							<span class="req">*</span>
						</label>
						<input type="password" id="password" name="password" />
					</div>					
					<button class="button button-block" id="myBtn">Get Started</button>
					
					 
					<div class="modal-content1">  
                     <p style="color:red">Before clicking Please Read below link..!!</p>  
                     <ul>
						  <li><a href="${pageContext.request.contextPath}/user/rulesouter" style="color:green"> Rule</a></li>
						  <li><a href="${pageContext.request.contextPath}/user/signupdataOuter" style="color:green">Signup-Data</a></li>
						  <li><a href="${pageContext.request.contextPath}/user/privacyOuter" style="color:green">Privacy</a></li>
						  <li><a href="${pageContext.request.contextPath}/user/termsConditionOuter" style="color:green">Terms & Condition</a></li>
					</ul> 
                  </div>

				</form>
                             
			</div>
		</div>
		<!-- tab-content -->
   
	</div>
	<!-- /form -->

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/js/view/index.js"></script>

	<script src="${pageContext.request.contextPath}/resources/js/view/video.js"></script>
	
	
	<div style="width: 20%;margin-left: 4%;margin-top:4%">
	<div style="margin-top: 6%; margin-left: 2%;">
	   <p style="color:yellowgreen;margin-left:8% "> Yesterday's  Winner...!</p>
		<c:if test="${not empty winner}">
				<img src="data:image/jpeg;base64,${winner.base64Encoded}" alt="Avatar" style="width: 250px; height: 250px; margin: 4px">
		</c:if>
		<c:if test="${empty winner}">
		<img src="${pageContext.request.contextPath}/resources/images/itg.jpg" alt="Avatar" style="width: 250px; height: 250px; margin: 4px;">
		</c:if>
		
		<div class="chip">
		<img src="${pageContext.request.contextPath}/resources/images/icon-prize.jpg" alt="Person" width="96" height="96">
		 ${winner.winner_name} 
	    </div>

	</div>
</div>

	

   <div style="margin-top: 0%">
		<div style="margin-top: 14.4%; width: 100%; height: auto;">
		<div style="padding-top:4px; background-color:#bbc4ef;color:black" align="center">&copy; 2017 All rights reserved<br/><br/>
		&nbsp;
		    <a href="${pageContext.request.contextPath}/user/privacyOuter"><font style="color:blue">Privacy</a>
			&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
			<a href="${pageContext.request.contextPath}/user/termsConditionOuter"><font style="color:blue"/>Terms & Condition</a>
			&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
			<a href="${pageContext.request.contextPath}/user/signupdataOuter"><font style="color:blue">Signup-Data</a>
			&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
			<a href="${pageContext.request.contextPath}/user/rulesouter"><font style="color:blue">Rules</a>
			&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
			<a href="${pageContext.request.contextPath}/user/contactusOuter"><font style="color:blue">Contact</a>
			&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
			<a href="${pageContext.request.contextPath}/user/aboutusOuter"><font style="color:blue">About Us</a>
			&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
	
		</div>
	  </div>
  </div>

</body>
</html>