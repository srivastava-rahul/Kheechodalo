<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">

<div style="margin-left: 25%">
<h3 style="color: yellow">Please tell What to be search enter here... </h3>
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search By Email..." title="Type in Email" style = "width: 452px; height: 38px;">
	</div>
	</br>
	


	<jsp:include page="/WEB-INF/views/jsp/message.jsp" />
	<div class="Changepassword_password_form">
		<!-- header -->
		<div class="Changepasswordformheader">
			<center>
				<b><h1>Admin Set Prize Form</h1>
					<b>
			</center>
		</div>

		<form name="prizeform" action="adminsaveprize" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<div class="Changepasswordformboby">
				<h2 style="color: red">Please Provide Date......!!!</h2>
				<div style="margin-left: 1%">
					<textarea name= "createddate" id="createddate" rows="1" cols="30" style="color: black"
						placeholder="Please provide a date."
						 aria-required="true"></textarea>
				</div>
			</div>
			
			<div class="Changepasswordformboby">
				<h2 style="color: red">Please Provide Prize......!!!</h2>
				<div style="margin-left: 1%">
					<textarea name= "prizevalue" id="prizevalue" rows="2" cols="50" style="color: black"
						placeholder="Please provide a detailed description prize."
						 aria-required="true"></textarea>
				</div>
			</div>	
			
			<div class="Changepasswordformboby">
				<h2 style="color: red">Please Provide Sponsor Name.....!!!</h2>
				<div style="margin-left: 1%">
					<textarea name= "sponsorby" id="sponsorby" rows="2" cols="50" style="color: black"
						placeholder="Please Provide Sponsor Name."
						 aria-required="true"></textarea>
				</div>
			</div>	
			

			<br />
			<div class="Changepasswordformfooter" align="right">
				<button type="submit" class="button_submit  submit">Send</button>&nbsp;&nbsp;

				<c:url value="/user/dashboard" var="dashUrl" />
				<a href="${pageContext.request.contextPath}/admin/admingetAllPrize" class="button_submit  submit" style="margin-right: 12px;" style="margin-right: 12px;"> Cancel </a>
			</div>
		</form>
	</div>
		
	<br/><br/><br/><br/>
	
	<table id="myTable" style="margin-left: 5%; width: 90%; padding: 5%; color: white" border="1">
		<tr class="header">
			<th height="40"><center>Date</center></th>
			<th height="40"><center>Sponsor-By</center></th>
			<th height="40"><center>Prize</center></th>
			<th height="40"><center>Action Button</center></th>
			
		</tr>
		<c:forEach var="prz" items="${prize}">
			<tr>
				<td><center>${prz.prizeDate}</center></td>
				<td><center>${prz.sponsor}</center></td>
				<td><center>${prz.prizeAmount}</center></td>
				<td><center>
						<a href="${pageContext.request.contextPath}/admin/admindeleteprize/${prz.id}">Delete</a>
					</center></td>
			</tr>
		</c:forEach>

	</table>
	
	
	
</div>

<style>
.Changepassword_password_form{
margin-bottom: auto; !important;
}

</style>

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