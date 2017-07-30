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
<style>
body
 body
 {
  font-family: Verdana, sans-serif;
  margin: 0;
}

* {
  box-sizing: border-box;
}

.row > .column {
  padding: 0 8px;
}

.row:after {
  content: "";
  display: table;
  clear: both;
}

.column {
  float: left;
  width: 25%;
}

/* The Modal (background) */
.modal {
  display: none;
  position: fixed;
  z-index: 1;
  padding-top: 10px;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: black;
}

/* Modal Content */
.modal-content {
  position: relative;
  background-color: #fefefe;
  margin: auto;
  padding: 0;
  width:80%;
  max-width: 1200px;
}

/* The Close Button */
.close {
  color: white;
  position: absolute;
  top: 10px;
  right: 25px;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #999;
  text-decoration: none;
  cursor: pointer;
}

.mySlides {
  display: none;
}

.cursor {
  cursor: pointer
}

/* Next & previous buttons */
.prev,
.next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width:4%;
  padding: 16px;
  margin-top: -50px;
  color: white;
  font-weight: bold;
  font-size: 20px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
  -webkit-user-select: none;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover,
.next:hover {
  background-color: rgba(0, 0, 0, 0.8);
}


img {
  margin-bottom: -4px;
}

.caption-container {
  text-align: center;
  background-color: black;
  padding: 2px 16px;
  color: black;
}

.demo {
  opacity: 0.6;
}

.active,
.demo:hover {
  opacity: 1;
}

img.hover-shadow {
  transition: 0.3s
}
</style>
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
					<img src="data:image/jpeg;base64,${pic.base64Encoded}"	alt="Picture" style="width: 291px; height: 320px;" onclick="openModal();currentSlide(1)" class="hover-shadow cursor">
					<a href="#"><span style="margin-left: 50%;color: red">${pic.picVote}</span></a>
					<div class="">
						<b><h2 style="color:blue">${pic.userName}</h2></b>
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
	
	
<div id="myModal" class="modal">
  <span class="close cursor" onclick="closeModal()">&times;</span>
  <div class="modal-content">

       <c:forEach var="pic" items="${picsList}">
			<div class="mySlides">
					<img src="data:image/jpeg;base64,${pic.base64Encoded}"	style="width:100%;height:90%">
					<span style="margin-left: 50%;color: red">${pic.picVote}</span>
					<div class="">
						<b><h2 style="color:blue">${pic.userName}</h2></b>
						<p>${pic.picDescription}</p>
						<p align="center">
							<button class=" marg-bottom-10 button_submit  submit">Vote</button>
						</p>
					</div>
				</div>
			
			</c:forEach>
    
      

    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
    <a class="next" onclick="plusSlides(1)">&#10095;</a>

    <div class="caption-container">
      <p id="caption"></p>
    </div>
	
	</div>
	
	
</div>