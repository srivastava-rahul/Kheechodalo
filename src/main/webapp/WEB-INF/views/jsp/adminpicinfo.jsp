<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">
	
	<div class="information">
		<p class="header_information">Pics Information for Admin</p>
	</div>
		<p>	
           Admin Pic info
	</p>
	<div style="margin-left:25%">
	
	<form name="deleteForm" action="${pageContext.request.contextPath}/admin/adminDeletePic" method="post">
			   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			
			<div class="Changepasswordformboby">
				<h3 style="color: yellow;margin-left: 334px;">Please tell What to be deleted enter the id... </h3>
				<input type="text"  name="picId" id="picId" style = "width: 452px; height: 40px;margin-left: 334px;" placeholder="Please Enter id" />
					
					<button type="submit" class="button_submit  submit" style="background-color:gray">Delete</button>
				
			</div>
		</form>
		
<h3 style="color: yellow">Please tell What to be search enter here... </h3>
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search By Email..." title="Type in Email" style = "width: 452px; height: 38px;">
	</div>
	</br>
	</br>

	<table id="myTable" style="margin-left: 5%; width: 90%; padding: 5%; color: white"
		border="1">
		<tr class="header">
			<th height="40"><center>Pic Id</center></th>
			<th height="40"><center>Name</center></th>
			<th height="40"><center>Email_id</center></th>
			<th height="40"><center>Pic description</center></th>
			<th height="40"><center>Pic</center></th>
			<th height="40"><center>Vote</center></th>
			<th height="40"><center>Action Button</center></th>
		</tr>
		<c:forEach var="pic" items="${picsList}">
			<tr>
				<td><center>${pic.id}</center></td>
				<td><center>${pic.userName}</center></td>
				<td><center>${pic.userEmailId}</center></td>
				<td><center>${pic.picDescription}</center></td>
				<td><center><img src="data:image/jpeg;base64,${pic.base64Encoded}"	style="width:30%;height:30%"></center></td>
				<td><center>${pic.picVote}</center></td>
				<td><center>
						<a
							href="${pageContext.request.contextPath}/admin/adminpicinfofull/${pic.id}">View More Info</a>
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