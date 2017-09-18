<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
	
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

<div class="body-area">
	<jsp:include page="/WEB-INF/views/jsp/message.jsp" />
	
	<div class="information">
		<p class="header_information">Testimonials Information for Admin</p>
	</div>
	
	
	
	<h3 style="color: blue;margin-left: 25%">Please tell What to be search enter here... </h3>
    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search By Email..." title="Type in Email" style = "width: 452px; height: 38px;;margin-left: 25%"/>
	</br></br>
	
	
			<table id="myTable" style="margin-left: 5%; width: 90%; padding: 5%; color: white"
		border="1">
		<tr class="header">
			<th height="40"><center>Id</center></th>
			<th height="40"><center>Created-Date</center></th>
			<th height="40"><center>Email_id</center></th>
			<th height="40"><center>name</center></th>
			<th height="40"><center>Description</center></th>
			<th height="40"><center>Pic</center></th>
			<th height="40"><center>Action Button</center></th>
		</tr>
		
		<c:forEach var="testimonials" items="${testimonial}" varStatus="index">
			<tr>
				<td><center>${testimonials.id}</center></td>
				<td><center>${testimonials.createdDate}</center></td>
				<td><center>${testimonials.email_id}</center></td>
				<td><center>${testimonials.name}</center></td>
				<td><center>${testimonials.testimonial_desc}</center></td>
				<td><center><img src="data:image/jpeg;base64,${testimonials.base64Encoded}" alt="Avatar" style="width:10%;height:10%" onclick="openModal();currentSlide(${index.index +1})"></center></td>
				<td><center>
						<a
							href="${pageContext.request.contextPath}/admin/admindeletetestimonial/${testimonials.id}">Delete</a>
					</center></td>
			</tr>
		</c:forEach>

	</table>
	
<!-- model pop-up begim here -->
	<div id="myModal" class="modal">
  <b><a href="#" onclick="closeModal()"><img src="${pageContext.request.contextPath}/resources/images/crossSign.png" alt="Avatar" style="float: right;width:3%;height:5%;margin-right:18% "></a></b>
  <div class="modal-content">
<c:if test="${empty searchPic}">
       <c:forEach var="pic" items="${testimonial}">
			<div class="mySlides">
					<%-- <img src="data:image/jpeg;base64,${pic.base64Encoded}"	style="width:100%;height:90%">
					<span style="margin-left: 50%;color: red">${pic.picVote}</span>
					<div class="">
						<b><h2 style="color:blue">${pic.userName}</h2></b>
						<p>${pic.picDescription}</p>
						<p align="center">
							<button class=" marg-bottom-10 button_submit  submit">Vote</button>
						</p>
					</div> --%>
					<div class="card">
					<img src="data:image/jpeg;base64,${pic.base64Encoded}"	style="width:100%;height:90%">
					
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