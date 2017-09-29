<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
<style>
#myImg {
    border-radius: 5px;
    cursor: pointer;
    transition: 0.3s;
}

#myImg:hover {opacity: 0.7;}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
}

/* Modal Content (image) */
.modal-content {
    margin: auto;
    display: block;
    width: 80%;
    max-width: 700px;
}

/* Caption of Modal Image */
#caption {
    margin: auto;
    display: block;
    width: 80%;
    max-width: 700px;
    text-align: center;
    color: #ccc;
    padding: 10px 0;
    height: 150px;
}

/* Add Animation */
.modal-content, #caption {    
    -webkit-animation-name: zoom;
    -webkit-animation-duration: 0.6s;
    animation-name: zoom;
    animation-duration: 0.6s;
}

@-webkit-keyframes zoom {
    from {-webkit-transform:scale(0)} 
    to {-webkit-transform:scale(1)}
}

@keyframes zoom {
    from {transform:scale(0)} 
    to {transform:scale(1)}
}

/* The Close Button */
.close {
    position: absolute;
    top: 15px;
    right: 35px;
    color: #f1f1f1;
    font-size: 40px;
    font-weight: bold;
    transition: 0.3s;
}

.close:hover,
.close:focus {
    color: #bbb;
    text-decoration: none;
    cursor: pointer;
}

/* 100% Image Width on Smaller Screens */
@media only screen and (max-width: 700px){
    .modal-content {
        width: 100%;
    }
}
</style>

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
			  
				<c:forEach items="${testimonial}" var="test" varStatus="index">
                       <div class="testimonialcontainer">
						 <img src="data:image/jpeg;base64,${test.base64Encoded}" alt="Avatar" style="width:90px" height="90px">
						  <p><span style="color:blue;">
						  
						  <%-- <c:if test="${not empty email_id}">
						  
						  <a href="${pageContext.request.contextPath}/user/viewProfile/${test.email_id}"><b>${test.name}</b></a>
						  </c:if> --%>
						  
						  <c:if test="${empty email_id}">
						   <b>${test.name}</b>
						  </c:if>
						  
						  </span>
						  </p>
						  
						  <p>${test.testimonial_desc}</p>
						  <fmt:formatDate value="${test.createdDate}" pattern="dd/MMM/yyyy"
						var="myValue" />
						   <p><span style="color:red;font-size: 12px">${myValue}</span></p>
						</div>
						
				</c:forEach>
				
			<center>	<div data-WRID="WRID-150329772695166358" data-widgetType="searchBar" data-class="affiliateAdsByFlipkart" height="55" width="660" ></div><script async src="//affiliate.flipkart.com/affiliate/widgets/FKAffiliateWidgets.js"></script>
				</center>
						
						
						
<!-- model pop-up begim here -->
			<div id="myModal" class="modal">
		  <b><a href="#" onclick="closeModal()"><img src="${pageContext.request.contextPath}/resources/images/crossSign.png" alt="Avatar" style="float: right;width:3%;height:5%;margin-right:18% "></a></b>
		  <div class="modal-content">
		<c:if test="${empty searchPic}">
       <c:forEach var="pic" items="${testimonial}">
			<div class="mySlides">
				<div class="card">
					<img src="data:image/jpeg;base64,${pic.base64Encoded}"	style="width:100%;height:90%">
					 <p style="color:blue">${pic.testimonial_desc}</p>
					 <fmt:formatDate value="${pic.createdDate}" pattern="dd/MMM/yyyy"
						var="myValue" />
						   <p><span style="color:red;float:right;margin-right: 2%">${myValue}</span></p>
					
				</div>
				
				
				</div>
			
			</c:forEach>
			</c:if>
				</div>
	</div>
	
	<!-- Modal pop-up End here -->
	
	</div>
	
	<script>
function openModal() {
  document.getElementById('myModal').style.display = "block";
}

function closeModal() {
  document.getElementById('myModal').style.display = "none";
}

var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demo");
  var captionText = document.getElementById("caption");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
  captionText.innerHTML = dots[slideIndex-1].alt;
}
</script>
	