<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">
	<img src="${pageContext.request.contextPath}/resources/images/aboutUs.jpg" alt="Avatar" class="page_pic">
	<div class="information">
		<p class="header_information">Get User Information for Admin</p>
	</div>
	
	
	
	<div style="margin-left: 20%; margin-top: 5%;">
		<table style="">
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
			</tr>
			
			<%-- <c:forEach var="userinfo" items="${user}">
			<tr>
			    <td><center>${userinfo.id}</center></td>   
				<td><center>${userinfo.firstName} &nbsp; &nbsp; </center></td>
				<td><center>${userinfo.emailId}</center></td>
				<td><center>${userinfo.gender}</center></td>
				<td><center>${userinfo.phone}</center></td>
				<td><center>${userinfo.dob}</center></td>
				<td><center>${userinfo.createdDate}</center></td>
				<td><center>${userinfo.modifiedDate}</center></td>
				<td><center>${userinfo.status}</center></td>
				<td><center>${userinfo.userRole}</center></td>				
			</tr>
          </c:forEach> --%>
					</table>

	</div>
		<p>	
	
          Get the user  info
	
	</p>
</div>