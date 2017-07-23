<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
<script>
var myIndex = 0;
carousel();
function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000); // Change image every 2 seconds
}

$(document).ready(function() {
	var num2 = 4;
	<c:if test="${not empty pageNo}">
	num2 = parseInt('${pageNo}');
	</c:if>
	var html2 = "";
	console.log("num  :"+ num2);
	html2 += '<li><a href="#" class="previous">«</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num2 - 3)+ '" >'+(num2 - 3)+ '</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num2 - 2)+ '">'+(num2 - 2)+ '</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num2 - 1)+ '">'+(num2 - 1)+ '</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num2)+ '">'+(num2)+ '</a></li>';
	html2 += '<li><a href="#" class="next">»</a></li>';
	$('.pagination').html(html2);
	
	
	
			$("body").delegate(	".previous",	"click",	function() {
							var num = parseInt($('.pagination li:nth-last-child(2)').text())-3;
						if (num >= 5) {
							var html1 = "";
							console.log("num  :"+ num);
							html1 += '<li><a href="#" class="previous">«</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num - 4)+ '" >'+(num - 4)+ '</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num - 3)+ '">'+(num - 3)+ '</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num - 2)+ '">'+(num - 2)+ '</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num - 1)+ '">'+(num - 1)+ '</a></li>';
							html1 += '<li><a href="#" class="next">»</a></li>';
							$('.pagination').html(html1);
							console.log(html1);
						}
						
						
			});
			
			$("body").delegate(	".next",	"click",	function() {
				var number = parseInt($('.pagination li:nth-last-child(2)').text());
				var html = "";
				html += '<li><a href="#" class="previous">«</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(number + 1)+ '" >'+(number + 1)+ '</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(number + 2)+ '">'+(number + 2)+ '</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(number + 3)+ '">'+(number + 3)+ '</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(number + 4)+ '">'+(number + 4)+ '</a></li>';
				html += '<li><a href="#" class="next">»</a></li>';
				$('.pagination').html(html)
	});
						
					});


</script>
<br>

<div class="body-area">



<div class="">
  <ul class="pagination">
  </ul>
</div>



<jsp:include page="/WEB-INF/views/jsp/message.jsp" />
	<div >
		<div class="row">
			<c:forEach var="pic" items="${picsList}">
			<div class="column">
				<div class="card">
					<img src="data:image/jpeg;base64,${pic.base64Encoded}"	alt="Picture" style="width: 291px; height: 320px;">
					<span style="margin-left: 50%;">${pic.picVote}</span>
					<div class="">
						<h2>${pic.userName}</h2>
						<p>${pic.picDescription}</p>
						<p align="center">
							<button class=" marg-bottom-10 button_submit  submit">Vote</button>
						</p>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
</div>