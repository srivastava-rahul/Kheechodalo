<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal.isAdmin" var="isAdmin" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
<style>
table, th, td {
	border: 1px solid black;
}
</style>

<div class="body-area">

	<div class="information">
		<p class="header_information">User Information for Admin <span style="margin-left:910px;">Total User : ${total}</span> </p>
	</div>
	<p>
	<%-- <form name="deleteForm" action="" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}">

		<div class="Changepasswordformboby">
			<h3 style="color: yellow">Please tell What you want to search
				enter the id...</h3>
			<input type="text" name="problem" id="problem" style="width: 30%"
				placeholder="Please Enter id or email-id" />

			<button type="submit" class="button_submit  submit">Search</button>

			<c:url value="/user/dashboard" var="dashUrl" />
		</div>
	</form> --%>
	<div style="margin-left:25%">
	<h3 style="color: blue">Please tell What to be search enter here... </h3>
	<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search By Email..." title="Type in Email" style = "width: 452px; height: 38px;">
	</div>
	</br>
	</br>
	

	<table id="myTable" style="margin-left: 5%; width: 90%; padding: 5%; color: white"
		border="1">
		<tr class="header">
			<th height="40"><center>Name</center></th>
			<th height="40"><center>Email-Id</center></th>
			<th height="40"><center>Created Date</center></th>
			<th height="40"><center>Account Active</center></th>
			<th height="40"><center>Account Deleted</center></th>
			<th height="40"><center>Action Button</center></th>

		</tr>
		<c:forEach var="userinfo" items="${user}">
			<tr>
				<td><center>${userinfo.firstName} ${userinfo.lastName}</center></td>
				<td><center>${userinfo.emailId}</center></td>
				<td><center>${userinfo.createdDate}</center></td>
				<td><center>${userinfo.status}</center></td>
				<td><center>${userinfo.deleted}</center></td>
				<td><center>
						<a
							href="${pageContext.request.contextPath}/admin/adminSingleProfileInfo/${userinfo.emailId}">View
							profile Info</a>
					</center></td>
			</tr>
		</c:forEach>

	</table>



</div>

<script>
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  console.log("tr : "+tr)
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>
