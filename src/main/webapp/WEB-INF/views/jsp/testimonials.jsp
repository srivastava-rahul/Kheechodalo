<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
<script>
$(document).ready(function() {
	var num2 = 4;
	<c:if test="${not empty pageNo}">
	num2 = parseInt('${pageNo}');
	</c:if>
	var html2 = "";
	html2 += '<li><a href="#" class="previousPage">«</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/testimonialsPagination/'+(num2 - 3)+ '" >'+(num2 - 3)+ '</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/testimonialsPagination/'+(num2 - 2)+ '">'+(num2 - 2)+ '</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/testimonialsPagination/'+(num2 - 1)+ '">'+(num2 - 1)+ '</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/testimonialsPagination/'+(num2)+ '">'+(num2)+ '</a></li>';
	html2 += '<li><a href="#" class="nextPage">»</a></li>';
	$('.pagination').html(html2);
	
	
	
			$("body").delegate(	".previousPage",	"click",	function() {
							var num = parseInt($('.pagination li:nth-last-child(2)').text())-3;
						if (num >= 5) {
							var html1 = "";
							console.log("num  :"+ num);
							html1 += '<li><a href="#" class="previousPage">«</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/testimonialsPagination/'+(num - 4)+ '" >'+(num - 4)+ '</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/testimonialsPagination/'+(num - 3)+ '">'+(num - 3)+ '</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/testimonialsPagination/'+(num - 2)+ '">'+(num - 2)+ '</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/testimonialsPagination/'+(num - 1)+ '">'+(num - 1)+ '</a></li>';
							html1 += '<li><a href="#" class="nextPage">»</a></li>';
							$('.pagination').html(html1);
						}
						
						
			});
			
			$("body").delegate(	".nextPage",	"click",	function() {
				var number = parseInt($('.pagination li:nth-last-child(2)').text());
				var html = "";
				html += '<li><a href="#" class="previousPage">«</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/testimonialsPagination/'+(number + 1)+ '" >'+(number + 1)+ '</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/testimonialsPagination/'+(number + 2)+ '">'+(number + 2)+ '</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/testimonialsPagination/'+(number + 3)+ '">'+(number + 3)+ '</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/testimonialsPagination/'+(number + 4)+ '">'+(number + 4)+ '</a></li>';
				html += '<li><a href="#" class="nextPage">»</a></li>';
				$('.pagination').html(html)
	});
						
					});


</script>
<div class="body-area">

				<div class="information">
						<p class="header_information"><b>Testimonials for participants</b></p>
					</div>
         
			         <center>
				 <ul class="pagination">
			     </ul>
			  </center>
			  <br/>
			  
				<c:forEach items="${testimonial}" var="test">
                       <div class="testimonialcontainer">
						 <img src="data:image/jpeg;base64,${test.base64Encoded}" alt="Avatar" style="width:90px">
						  <p><span style="color:blue;">
						  
						  <%-- <c:if test="${not empty email_id}"> --%>
						  
						  <a href="${pageContext.request.contextPath}/user/viewProfile/${test.email_id}"><b>${test.name}</b></a>
						 <%--  </c:if> --%>
						  
						 <%--  <c:if test="${empty email_id}">
						   <b>${test.name}</b>
						  </c:if> --%>
						  
						  </span>
						  </p>
						  
						  <p>${test.testimonial_desc}</p>
						   <p><span style="color:red;">${test.createdDate}</span></p>
						</div>
						
				</c:forEach>
				
			<center>	<div data-WRID="WRID-150329772695166358" data-widgetType="searchBar" data-class="affiliateAdsByFlipkart" height="55" width="660" ></div><script async src="//affiliate.flipkart.com/affiliate/widgets/FKAffiliateWidgets.js"></script>
				</center>
						
	</div>
	
	
	