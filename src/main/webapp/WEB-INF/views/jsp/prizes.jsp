<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>



<style>
table, th, td {
	border: 1px solid black;
	
}
 
</style>
<div class="body-area">
<br/><br/><br/><br/>
	<%-- <img
		src="${pageContext.request.contextPath}/resources/images/prize2.jpg"
		alt="Avatar" class="page_pic">
	<div class="information"> --%>

	<img
		src="${pageContext.request.contextPath}/resources/images/giftimage.gif"
		alt="Avatar" class="page_pic"> <br />
	<p class="header_information">
		<b>Prizes for participants</b>
	</p>

        <i style="color: red;margin-left: 1%;">Note: Please complete your profile as soon as possible in order to get prize</i> 

	<div style="margin-left: 10%; margin-top: 5%;">
		<table style="">
			<col width="300">
			<col width="300">
			<col width="300">
			<tr>
				<th height="40"><center>Date</center></th>
				<th height="40"><center>Sponsor-By</center></th>
				<th height="40"><center>Prize</center></th>
			</tr>

			<c:forEach var="prize" items="${prize}">
				<tr>	
						 <fmt:formatDate value="${prize.prizeDate}" pattern="dd/MMM/yyyy"
						var="myValue" />
		   
					<td><center>${myValue}</center></td>
					<td><center>${prize.sponsor}</center></td>
					<td><center>${prize.prizeAmount}</center></td>
				</tr>
			</c:forEach>
		</table>




		<div style="margin-top: 6%; margin-left: 5%">
			<span data-WRID="WRID-150143535395538190"
				 data-widgetType="Push Content"  data-class="affiliateAdsByFlipkart"
				height="350px" width="400px"></span>
			<script async
				src="//affiliate.flipkart.com/affiliate/widgets/FKAffiliateWidgets.js"></script>

			<span  data-WRID="WRID-150143479608384177"  data-widgetType="staticBanner" 
				data-class="affiliateAdsByFlipkart"
				height="280px" width="280px"></span>
				
			<script async
				src="//affiliate.flipkart.com/affiliate/widgets/FKAffiliateWidgets.js"></script>

			<!-- <span data-WRID="WRID-150325567273950214"
				data-widgetType="productBanner" data-class="affiliateAdsByFlipkart"
				height="350px" width="200px"></span>
			<script async
				src="//affiliate.flipkart.com/affiliate/widgets/FKAffiliateWidgets.js"></script>

			<span data-WRID="WRID-150325698005019858"
				data-widgetType="productBanner" data-class="affiliateAdsByFlipkart"
				height="250px" width="300px"></span>
			<script async
				src="//affiliate.flipkart.com/affiliate/widgets/FKAffiliateWidgets.js"></script> -->
		</div>


	</div>