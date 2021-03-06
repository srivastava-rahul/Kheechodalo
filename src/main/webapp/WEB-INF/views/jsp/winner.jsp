<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
<script>
$(document).ready(function() {
	var num2 = 4;
	<c:if test="${not empty pageNo}">
	num2 = parseInt('${pageNo}');
	</c:if>
	var html2 = "";
	html2 += '<li><a href="#" class="previousPage">�</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/winnerPagination/'+(num2 - 3)+ '" >'+(num2 - 3)+ '</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/winnerPagination/'+(num2 - 2)+ '">'+(num2 - 2)+ '</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/winnerPagination/'+(num2 - 1)+ '">'+(num2 - 1)+ '</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/winnerPagination/'+(num2)+ '">'+(num2)+ '</a></li>';
	html2 += '<li><a href="#" class="nextPage">�</a></li>';
	$('.pagination').html(html2);
	
	
	
			$("body").delegate(	".previousPage",	"click",	function() {
							var num = parseInt($('.pagination li:nth-last-child(2)').text())-3;
						if (num >= 5) {
							var html1 = "";
							console.log("num  :"+ num);
							html1 += '<li><a href="#" class="previousPage">�</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/winnerPagination/'+(num - 4)+ '" >'+(num - 4)+ '</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/winnerPagination/'+(num - 3)+ '">'+(num - 3)+ '</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/winnerPagination/'+(num - 2)+ '">'+(num - 2)+ '</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/winnerPagination/'+(num - 1)+ '">'+(num - 1)+ '</a></li>';
							html1 += '<li><a href="#" class="nextPage">�</a></li>';
							$('.pagination').html(html1);
						}
						
						
			});
			
			$("body").delegate(	".nextPage",	"click",	function() {
				var number = parseInt($('.pagination li:nth-last-child(2)').text());
				var html = "";
				html += '<li><a href="#" class="previousPage">�</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/winnerPagination/'+(number + 1)+ '" >'+(number + 1)+ '</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/winnerPagination/'+(number + 2)+ '">'+(number + 2)+ '</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/winnerPagination/'+(number + 3)+ '">'+(number + 3)+ '</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/winnerPagination/'+(number + 4)+ '">'+(number + 4)+ '</a></li>';
				html += '<li><a href="#" class="nextPage">�</a></li>';
				$('.pagination').html(html)
	});
						
					});


</script>
<div class="body-area">

	
	<div class="information">
		<p class="header_information">
			<b>Prizes for participants</b>
		</p>
	</div>
	
	<center>
	 <ul class="pagination">
     </ul>
  </center>
  <br/>
  
  <div>
  
      <div style="width: 5%;height:0%;margin-left:78%;margin-top: 3%">
		<div  data-WRID="WRID-150325419568943179" data-widgetType="staticBanner" data-responsive="yes" data-class="affiliateAdsByFlipkart" height="250" width="500"></div><script async src="//affiliate.flipkart.com/affiliate/widgets/FKAffiliateWidgets.js"></script></script>
		</div>
		
	 <div>
		<c:forEach items="${winnerList}" var="winner">
			<div class="containerwinner">
				<div class="container_img_header">
					<img src="data:image/jpeg;base64,${winner.base64Encoded}" alt="Avatar" style="width: 200px;height: 200px;" />
						<fmt:formatDate value="${winner.createdDate}" pattern="dd/MMM/yyyy"
						var="myValue" />
					<font style="color: red; float: left;margin-left: 2%">${myValue}</font>
					&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
					<font style="color: red;margin-left: 25%">Prize :${winner.prize_desc}</font>
					&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
					<font style="color: red; float: right;margin-right: 15%">Vote:${winner.picVote}</font>
				 </div>
				<div style="background: black;">
					<span>
						<center>
							<a href="${pageContext.request.contextPath}/user/viewProfile/${winner.email_id}">${winner.winner_name}</a>
						</center>
					</span>
					<br />
					<center><span>${winner.winner_desc}</span></center>
				</div>
			</div>
		</c:forEach>
		</div>
		
		
		</div>
		
	
					<center>
	                     <ul class="pagination"></ul>
                    </center>
     
     
     
</div>