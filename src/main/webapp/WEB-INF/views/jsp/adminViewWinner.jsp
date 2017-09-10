<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">
		<jsp:include page="/WEB-INF/views/jsp/message.jsp" />
	<div class="information">
		<p class="header_information">Winner Information for Admin</p>
	</div>
		
	
	        <%--  <form name="deleteForm" action="" method="post">
			   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			
			<div class="Changepasswordformboby">
				<h3 style="color: yellow">Please tell What to be deleted enter the id... </h3>
				<input type="text"  name="problem" id="problem" style="width:30% "
					placeholder="Please Enter id" />
					
					<button type="submit" class="button_submit  submit" style="background-color:red">Delete</button>
				
				    <c:url value="/user/dashboard" var="dashUrl" />
			</div>
		</form> --%>
		</br></br>
		
		
		<h3 style="color: blue;margin-left: 25%">Please tell What to be search enter here... </h3>
    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search By Email..." title="Type in Email" style = "width: 452px; height: 38px;;margin-left: 25%"/>
	</br></br>
	
		
		
		
		<table id="myTable" style="margin-left: 5%; width: 90%; padding: 5%; color: white"
		border="1">
		<tr class="header">
			<th height="40"><center>Id</center></th>
			<th height="40"><center>Created Date</center></th>
			<th height="40"><center>prize</center></th>
			<th height="40"><center>Description</center></th>
			<th height="40"><center>Pic</center></th>
			<th height="40"><center>Vote</center></th>
			<th height="40"><center>email-id</center></th>
			<th height="40"><center>Action Button</center></th>
			
		</tr>
		
		<c:forEach var="win" items="${winner}">
			<tr>
				<td><center>${win.id}</center></td>
				<td><center>${win.createdDate}</center></td>
				<td><center>${win.prize_desc}</center></td>
				<td><center>${win.winner_desc}</center></td>
				<td><center><img src="data:image/jpeg;base64,${win.base64Encoded}" alt="Avatar" style="width: 250px"></center>
				</td>
				<td><center>${win.picVote}</center></td>
				<td><center>${win.email_id}</center></td>
				<td><center>
						<a
							href="${pageContext.request.contextPath}/admin/admindeletewinner/${win.id}">Delete</a>
					</center></td>
			</tr>
		</c:forEach>

	</table>
</div>