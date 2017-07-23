<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal.isAdmin" var = "isAdmin"/>

<style>
.topnav {
	overflow: hidden;
	position: absolute;
	padding: 0 300 0 260;
	top: 35px
}

/* Style the links inside the navigation bar */
.topnav a {
	float: left;
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 12px 40px;
	text-decoration: none;
	font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
	background-color: #ddd;
	color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
	background-color: #4CAF50;
	color: white;
}


.searchBox {
	/* margin-right: 60px; */
	float: right;
	margin-top: 20px;
	width: 270px;
	height: 35px;
	/* box-sizing: border-box; */
	/* 	border: 2px solid #ccc;
 */
	/* background-image: url('${pageContext.request.contextPath}/resources/assets/images/searchicon.png'); */
	/*     border-radius: 4px; */
	font-size: 16px; /* 
    background-color: white;
   background-image: url('${pageContext.request.contextPath}/resources/assets/images/searchicon.png');
    background-position: 10px 10px; 
    background-repeat: no-repeat;
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out; */
}
</style>
<div id="page-wrapper" align="left">

<c:if test="${!isAdmin}">
	<!-------------------------------------------------------Code for Right Menu------------------------------------------------------------------------->
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <hr/>
			  <table>
			  <tr><td><span>&nbsp; &nbsp;<i class="fa fa-home" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/dashboard">Home</a></span></td></tr>
			  <tr><td><span>&nbsp; &nbsp;<i class="fa fa-gear fa-spin" style="font-size:24px;color:red"></i><a href="${pageContext.request.contextPath}/user/getProfileSettings">Settings</a></span></td></tr>
			   <!-- <tr><td><span>&nbsp; &nbsp;<i class="material-icons" style="font-size:28px;color:red">add_alert</i><a href="#">Notifications</a></span></td></tr> -->
			   <tr><td><span>&nbsp; &nbsp;<i class="fa fa-diamond" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/rules">Rules</a></span></td></tr>
			   <tr><td><span>&nbsp; &nbsp;<i class="fa fa-gift" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/prizes">Prize</a></span></td></tr>
			   <tr><td><span>&nbsp; &nbsp;<i class="fa fa-pencil-square-o" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/testimonials">Testimonials</a></span></td></tr>
              <tr><td><span>&nbsp; &nbsp;<i class="fa fa-envelope-o" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/feedback">feedback</a></span></td></tr>

		
		<tr><td><span>&nbsp; &nbsp;<i class="fa fa-info-circle" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/aboutUs">About_Us</a></span></tr></td>
        <tr><td><span>&nbsp; &nbsp;<i class="fa fa-phone" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/contactus">Contact_us</a></span></tr></td>
        <tr><td><span>&nbsp; &nbsp;<i class="fa fa-key" style="font-size:28px;color:red"><a href="${pageContext.request.contextPath}/user/newUserPassword">Change Password</a></span></tr></td>
		<tr><td><span>&nbsp; &nbsp;<i class="fa fa-question-circle" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/quickHelp">Quick Help</a></span></td></tr>
		
	  </table>
	</div>
	</c:if>
	
<c:if test="${isAdmin}">
	<!-------------------------------------------------------Code for Right Menu------------------------------------------------------------------------->
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <hr/>
			  <table>
			  <tr><td><span>&nbsp; &nbsp;<i class="fa fa-home" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/dashboard">Home</a></span></td></tr>
			  <tr><td><span>&nbsp; &nbsp;<i class="fa fa-gear fa-spin" style="font-size:24px;color:red"></i><a href="${pageContext.request.contextPath}/user/getProfileSettings">Get</a></span></td></tr>
			   <tr><td><span>&nbsp; &nbsp;<i class="fa fa-diamond" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/rules">Set</a></span></td></tr>
			   <tr><td><span>&nbsp; &nbsp;<i class="fa fa-gift" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/prizes">Prize</a></span></td></tr>
			   <tr><td><span>&nbsp; &nbsp;<i class="fa fa-pencil-square-o" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/testimonials">Testimonials</a></span></td></tr>
              <tr><td><span>&nbsp; &nbsp;<i class="fa fa-envelope-o" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/feedback">feedback</a></span></td></tr>

		
		<tr><td><span>&nbsp; &nbsp;<i class="fa fa-info-circle" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/aboutUs">About_Us</a></span></tr></td>
        <tr><td><span>&nbsp; &nbsp;<i class="fa fa-phone" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/contactus">Contact_us</a></span></tr></td>
        <tr><td><span>&nbsp; &nbsp;<i class="fa fa-key" style="font-size:28px;color:red"><a href="${pageContext.request.contextPath}/user/newUserPassword">Change Password</a></span></tr></td>
		<tr><td><span>&nbsp; &nbsp;<i class="fa fa-question-circle" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/quickHelp">Quick Help</a></span></td></tr>
		
	  </table>
	</div>
	</c:if>
	



	<!-- PAGE HEADER BLOCK -->
	<div id="page-header" class="bg-gradient-9" style="padding-left: 10px;">
		<!-----------------------------------------------Code for left navigator menu---------------------------------------------------------------- -->
		<div class="row">
			<div class="col-md-3">
				<span style="font-size: 25px; float: left; cursor: pointer; padding-top: 20; color: #fff; font-style: bold; font-family: Charcoal;" onclick="openNav()">&#9776; Open</span>
			</div>
			<div class="col-md-5 row">


				<form id="search" method="post" action="${pageContext.request.contextPath}/user/search">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					<div class="col-md-10" style="padding-right: 0px;">
						<p align="right">
							<input type="text" name="search" class="fa fa-search searchBox" placeholder="&nbsp; Search Your Loved One...." style="color:black;">
						</p>
					</div>

					<div class="col-md-2" style="padding-left: 5px;padding-top: 20px;height: 34px;">
						<p align="left">
							<button class="btn btn-default" style="border-radius: 0;height: 32px;" type="submit">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</p>
					</div>
				</form>

			</div>
			<div class="col-md-4">
				<a id="logout-btn" href="${pageContext.request.contextPath}/logout" title="Logout">
					<img class="mrg_none" width="30" align="right" src="${pageContext.request.contextPath}/resources/assets/images/logoutbtn.png" style="margin: 18px !important" alt="Profile image">
				</a>

			</div>

		</div>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/view/home.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.css"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
</div>
