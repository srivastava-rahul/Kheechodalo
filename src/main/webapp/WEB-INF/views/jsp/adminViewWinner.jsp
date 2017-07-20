<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">
		<img src="${pageContext.request.contextPath}/resources/images/Adminimg.png" alt="Avatar" class="page_pic">
	<div class="information">
		<p class="header_information">Winner Information for Admin</p>
	</div>
		
	
	         <form name="deleteForm" action="" method="post">
			   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			
			<div class="Changepasswordformboby">
				<h3 style="color: yellow">Please tell What to be deleted enter the id... </h3>
				<input type="text"  name="problem" id="problem" style="width:30% "
					placeholder="Please Enter id" />
					
					<button type="submit" class="button_submit  submit" style="background-color:red">Delete</button>
				
				    <c:url value="/user/dashboard" var="dashUrl" />
			</div>
		</form>
		</br></br>
		
		
		<table style="margin-left: 5%;width:90%;padding: 5%;">
		<tr>
		<th> Id</th>
		<th> Date</th>
		<th> prize</th>
		<th> Description</th>
		<th> Pic</th>
		<th> Vote</th>
		</tr>
		
		<tr>
		<td>111</td>
		<td>11-jul-2017</td>
		<td>Rs200</td>
		<td>Hinenccwjcjbjcbbcbhbchhcb</td>
		<td>pic</td>
		<td>4000000</td>
				
		</tr>
		
		
		</table>
		
</div>