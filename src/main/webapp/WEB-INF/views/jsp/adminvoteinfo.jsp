<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">
	<jsp:include page="/WEB-INF/views/jsp/message.jsp" />
	<div class="information">
		<p class="header_information">Vote Information for Admin</p>
	</div>
	
		</br></br>

<div style="margin-left:25%">

<h3 style="color: yellow">Please tell What to be search enter here... </h3>
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search By Email..." title="Type in Email" style = "width: 452px; height: 38px;">
	</div>
	</br>
	</br>
	
	<div class="Changepassword_password_form">
		<!-- header -->
		<div class="Changepasswordformheader">
			<center>
				<b><h1>Admin Set Form</h1>
					<b>
			</center>
		</div>
	<form name="prizeform" action="adminsavevote" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			
			<div class="Changepasswordformboby">
				<h2 style="color: red">Please Provide Pic Id......(Rs...)</h2>
				<div style="margin-left: 1%">
					<textarea name= "picid" id="picid" rows="2" cols="50" style="color: black"
						placeholder="Please provide a detailed pic id..(RS..)."
						 aria-required="true"></textarea>
				</div>
			</div>	
			
			<div class="Changepasswordformboby">
				<h2 style="color: red">Please Provide vote ...!!!</h2>
				<div style="margin-left: 1%">
					<textarea name= "picvote" id="picvote" rows="2" cols="50" style="color: black"
						placeholder="Please Provide vote "
						 aria-required="true"></textarea>
				</div>
			</div>	
			

			<br />
			<div class="Changepasswordformfooter" align="right">
				<button type="submit" class="button_submit  submit">Send</button>&nbsp;&nbsp;

				<c:url value="/user/dashboard" var="dashUrl" />
				<a href="${pageContext.request.contextPath}/admin/adminDashboard" class="button_submit  submit" style="margin-right: 12px;" style="margin-right: 12px;"> Cancel </a>
			</div>
		</form>

	<%-- <table id="myTable" style="margin-left: 5%; width: 90%; padding: 5%; color: white"
		border="1">
		<tr class="header">
			<th height="40"><center>Id</center></th>
			<th height="40"><center>Created Date</center></th>
			<th height="40"><center>Feedback-Message</center></th>
			<th height="40"><center>Action Button</center></th>
			
		</tr>
		<c:forEach var="fdbk" items="${feedback}">
			<tr>
				<td><center>${fdbk.id}</center></td>
				<td><center>${fdbk.createdDate}</center></td>
				<td><center>${fdbk.feedDesc}</center></td>
				<td><center>
						<a
							href="${pageContext.request.contextPath}/admin/admindeletefeedback/${fdbk.id}">Delete</a>
					</center></td>
			</tr>
		</c:forEach>

	</table>
 --%>


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





	