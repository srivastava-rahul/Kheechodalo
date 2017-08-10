<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
	<style>
table, th, td {
    border: 1px solid white;
}
</style>
<div class="body-area">

	<img
		src="${pageContext.request.contextPath}/resources/images/prize2.jpg"
		alt="Avatar" class="page_pic">
	<div class="information">
		<p class="header_information">
			<b>Prizes for participants</b>
		</p>
	</div>

	<div style="margin-left: 20%; margin-top: 5%;">
		<table style="">
          <col width="300">
          <col width="300">
			<tr>
				<th height="40"><center>Date</center></th>
				<th height="40"><center>Sponsor-By</center></th>
				<th height="40"><center>Prize</center></th>
			</tr>
			
			<c:forEach var="prize" items="${prize}">
			<tr>
				<td><center>${prize.prizeDate}</center></td>
				<td><center>${prize.sponsor}</center></td>
				<td><center>${prize.prizeAmount}</center></td>
			</tr>
          </c:forEach>
					</table>

	</div>


</div>