<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">
	

	<div class="information">
		<p class="header_information">Pics Information for Admin</p>
	</div>
		<p>	
	
           Admin View Full Information of Photos
	
	</p>
	<a href="${pageContext.request.contextPath}/admin/adminpicinfo"><img src="${pageContext.request.contextPath}/resources/images/download.jpg" style="margin-top: 1%;margin-left:2% ;background-color: transparent;" src="arrow.gif" width="5%" height="4%"/>&nbsp;Back to Pics Info Page</a>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
	
	<div style="margin-left:25%">

<h3 style="color: yellow">Please tell What to be search enter here... </h3>
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search By Email..." title="Type in Email" style = "width: 452px; height: 38px;">
	</div>
	</br>
	</br>
	

	<table id="myTable" style="margin-left: 5%; width: 90%; padding: 5%; color: white"
		border="1">
		<tr class="header">
			<th height="40"><center>Voter List of Particular Pic</center></th>
			
			
		</tr>
		  <c:forEach var="voter" items="${picsList}">
			<tr>
				<td><center>${voter.friendEmail}</center></td>
				
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