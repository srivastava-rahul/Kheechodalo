<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">
	
	<div class="information">
		<p class="header_information">Quick-Help Information for Admin</p>
	</div>
	       
		</br></br>
		
   <div style="margin-left:25%">

<h3 style="color: yellow">Please tell What to be search enter here... </h3>
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search By Email..." title="Type in Email" style = "width: 452px; height: 38px;">
	</div>
	</br>
	</br>
	

	<table id="myTable" style="margin-left: 5%; width: 90%; padding: 5%; color: white"
		border="1">
		<tr class="header">
			<th height="40"><center>Id</center></th>
			<th height="40"><center>Created Date</center></th>
			<th height="40"><center>Quick- Help-Problem</center></th>
			<th height="40"><center>Quick Help Description</center></th>
			<th height="40"><center>Action Button</center></th>
			
		</tr>
		<c:forEach var="quckhlp" items="${quickhelp}">
			<tr>
				<td><center>${quckhlp.id}</center></td>
				<td><center>${quckhlp.createdDate}</center></td>
				<td><center>${quckhlp.quickProblem}</center></td>
				<td><center>${quckhlp.quickDesc}</center></td>
				<td><center>
						<a href="${pageContext.request.contextPath}/admin/admindeleteQuickhelp/${quckhlp.id}">Delete</a>
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





	