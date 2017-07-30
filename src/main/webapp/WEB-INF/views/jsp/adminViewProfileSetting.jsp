<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">
		<c:if test="${not empty picImg}">
	<img id="picImageHolder" src="data:image/jpeg;base64,${picImg}" alt="Picture"  style="width: 180px;height:180px;border-radius: 20%; " class="page_pic">
	</c:if>
	<div class="information">
		<p class="header_information">Profile Information for Admin</p>
	</div>
		
		
<a href="${pageContext.request.contextPath}/admin/adminDashboard"><img src="${pageContext.request.contextPath}/resources/images/download.jpg" style="margin-top: 1%;margin-left:2% ;background-color: transparent;" src="arrow.gif" width="5%" height="4%"/>&nbsp;Back to User Info</a>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
	
        <table style="margin-left: 5%;width:90%;padding: 5%;color:white;">
		<%-- <c:forEach var="profileinfo" items="${profile}"> --%>
		<%-- <c:if test="${not empty picImg}">
		<tr><td>Profile Pic</td><td><img id="picImageHolder" src="data:image/jpeg;base64,${picImg}" alt="Picture"  style="width: 180px;height:180px;border-radius: 20%; " /></td></tr>
		</c:if> --%>
        <tr><td>Name</td><td>${profile.name_surname}</td></tr>
        <tr><td>Date-of-birth</td><td>${profile.dob}</td></tr>
       <tr> <td>Emai_id</td><td>${profile.email_id}</td></tr>
        <tr><td>Phone</td><td>${profile.phone}</td></tr>
        <tr><td>Phone_flage</td><td>${profile.phone_flage}</td></tr>
        <tr><td>Gender</td><td>${profile.gender}</td></tr>
       <tr> <td>Daliy Status</td><td>${profile.daily_status}</td></tr>
       <tr> <td>Native_place</td><td>${profile.native_place}</td></tr>
       <tr> <td>Live-in</td><td>${profile.live_in}</td></tr>
       <tr> <td>Country</td><td>${profile.country}</td></tr>
       <tr> <td>Relationship</td><td>${profile.relationship}</td></tr>
        <tr><td>Post-graduration</td><td>${profile.post_graduration}</td></tr>
	   <tr> <td>Graduration</td><td>${profile.graduration}</td></tr>
	    <tr><td>Secondary-school</td><td>${profile.secondary_school}</td></tr>
	    <tr><td>High-school</td><td>${profile.high_school}</td></tr>
        <tr><td>Work-Place</td><td>${profile.work_place}</td></tr>
	   <tr> <td>Work-Experience</td><td>${profile.work_experience}</td></tr>
	   <tr> <td>Skill</td><td>${profile.skill}</td></tr>
       <tr> <td>Birth-Place</td><td>${profile.birth_place}</td></tr>
	   <tr> <td>Religious_view</td><td>${profile.religious_view}</td></tr>
	   <tr> <td>Paytm</td><td>${profile.paytm}</td></tr>
	   <tr> <td>Paytm-flage</td><td>${profile.paytm_flage}</td></tr>
       <tr> <td>Address</td><td>${profile.address}</td></tr>
	   <tr> <td>Address-flage</td><td>${profile.address_flage}</td></tr>
	   <tr> <td>Hobbies</td><td>${profile.hobbies}</td></tr>
	   <tr> <td>Favourite-Food</td><td>${profile.favourite_food}</td></tr>
	   <tr> <td>Favourite-Singer</td><td>${profile.favourite_singer}</td></tr>
	    <tr> <td>Favourite-Movies</td><td>${profile.favourite_movies}</td></tr>
	    <tr> <td>Favourite-Daily-Soap</td><td>${profile.favourite_daily_soap}</td></tr>
	    <tr> <td>Favourite-Author</td><td>${profileinfo.favourite_author}</td></tr>	 
	   <%--  </c:forEach> --%>  
	   </table>
	
	</p>
</div>