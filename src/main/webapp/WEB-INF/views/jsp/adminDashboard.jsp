<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal.isAdmin" var = "isAdmin"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">
	<img src="${pageContext.request.contextPath}/resources/images/Adminimg.png" alt="Avatar" class="page_pic">
	<div class="information">
		<p class="header_information">



User Information for Admin
		
		
		</p>
	</div>
		<p>	
	
	         <form name="deleteForm" action="" method="post">
			   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			
			<div class="Changepasswordformboby">
				<h3 style="color: yellow">Please tell What you want to search enter the id... </h3>
				<input type="text"  name="problem" id="problem" style="width:30% "
					placeholder="Please Enter id or email-id" />
					
					<button type="submit" class="button_submit  submit">Search</button>
				
				    <c:url value="/user/dashboard" var="dashUrl" />
			</div>
		</form>
		</br></br>
		
		<table style="margin-left: 5%;width:90%;padding: 5%;">
		<tr>
		 <th height="40"><center>ID</center></th>
			    <th height="40"><center>Name</center></th>
			    <th height="40"><center>Email-Id</center></th>
			    <th height="40"><center>Gender</center></th>
			    <th height="40"><center>Phone</center></th>
			    <th height="40"><center>Dob</center></th>
				<th height="40"><center>Created Date</center></th>
				<th height="40"><center>Modified Date</center></th>
				<th height="40"><center>status</center></th>
				<th height="40"><center>User Role</center></th>
				<th height="40"><center>Action Button</center></th>
				
		</tr>
		
		<tr>
		<td>111</td>
		<td>Name</td>
		<td>r@gmail.com</td>
		<td>Male</td>
		<td>999999999</td>
		<td>18-12-1991</td>
		<td>11-july-2017</td>
		<td>12-july-2017</td>
		<td>1</td>
		<td>111</td>
		<td><a href="${pageContext.request.contextPath}/user/adminSingleProfileInfo">View profile Info</a></td>		
		</tr>
		
		
		</table>
			
	
		
</div>