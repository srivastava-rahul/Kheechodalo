<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">

<br/><br/><br/><br/>
		<jsp:include page="/WEB-INF/views/jsp/message.jsp" />

		
		
		<div style="margin-left:25%">
	
	<form name="adminVoteIncreForm" action="${pageContext.request.contextPath}/admin/adminVoteIncrementCount" method="post">
			   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			
			<div class="Changepasswordformboby">
				<h3 style="color: blue;">Please Tell The Id To Increase The Vote Count... </h3>
				<input type="text"  name="emailId" id="emailId" style = "width: 452px; height: 40px;" placeholder="Please Enter id" />
					
					<button type="submit" class="button_submit  submit" style="background-color:gray">Search</button>
			</div>
		</form>
		
		
	<table id="myTable" style="margin-left: 5%; width: 90%; padding: 5%; color: white"
		border="1">
		<tr class="header">
			 <th height="40"><center>Count</center></th> 
			<th height="40"><center>Increse</center></th>
		</tr>
			<tr>
				<td><center>${voteConut}</center></td>
				<td><center><a href="${pageContext.request.contextPath}/admin/increment/200/${emailId}" style="color: white">Increment</a></center></td>
			
			</tr>
			
			

	</table>
	
	<%-- <form action ="<c:url value="/admin/increment/${voteConut}"/>">
	<button type="submit">Increment</button>
	</form> --%>

		
	
		
		<%-- 
		<form name="quickhelpForm" action="quickHelpData" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<div class="Changepasswordformboby">
				<h3 style="color: yellow">Please tell Problem you A are facing... </h3>
				<input type="text" class="Changepassword_form-control" name="problem" id="problem" required="true"
					placeholder="Please Enter Page or button name" />
			</div>

			<div class="Changepasswordformboby">
				<h3 style="color: yellow">Please Provide Some Problem Decsription...</h3>
				<div style="margin-left: 1%">
					<textarea name= "quickDesc" id="quickDesc" rows="5" cols="62" style="color: black"
						placeholder="Please provide a detailed description of your Problems or suggestions."
						 aria-required="true"></textarea>
				</div>
			</div>

			<br />
			<div class="Changepasswordformfooter" align="right">
				<button type="submit" class="button_submit  submit">Send</button>
				
				<!-- <a href="" class="button_submit  submit"> Send </a> --> &nbsp;&nbsp;
				&nbsp;&nbsp;

				<c:url value="/user/dashboard" var="dashUrl" />
				<a href="${dashUrl}" class="button_submit  submit"  style="margin-right: 12px;"> Cancel </a>
			</div>
		</form>
 --%>	</div>
</div>