<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
<div class="body-area">

	<img src="${pageContext.request.contextPath}/resources/images/winner.jpg" alt="Avatar" class="page_pic">
	<div class="information">
		<p class="header_information">
			<b>Prizes for participants</b>
		</p>
	</div>
	<center>
		<c:forEach items="${winnerList}" var="winner">
			<div class="containerwinner">
				<div class="container_img_header">
					<img src="data:image/jpeg;base64,${winner.base64Encoded}" alt="Avatar" style="width: 250px" />
					<font style="color: red; float: left">${winner.createdDate}</font>
					&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
					<font style="color: red;">Prize :${winner.prize_desc}</font>
					&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
					<font style="color: red; float: right;">Vote:${winner.picVote}</font>
				</div>
				<div style="background: black;">
					<span>
						<center>
							<a href="#">${winner.winner_name}</a>
						</center>
					</span>
					<br />
					<span>${winner.winner_desc}</span>
				</div>
			</div>
		</c:forEach>
	</center>



</div>