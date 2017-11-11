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
<div class="body-area">

<br/>

         
				<%-- <div>
				  <img src="${pageContext.request.contextPath}/resources/images/itg.jpg" alt="Avatar" class="page_pic">
				 </div> --%>
				 
				  <div>
		                 
		<c:if test="${not empty picImg}">
				<img id="picImageHolder" src="data:image/jpeg;base64,${picImg}" alt="Picture"  class="page_pic"  data-tooltip="Click Here" />
			</c:if>
			<c:if test="${empty picImg}">
			<img src="${pageContext.request.contextPath}/resources/images/profileupload.png" alt="Avatar" class="page_pic" data-tooltip="Click here">
			</c:if>
			
	
	</div>
				 
				 
			    <div class="information">
				     <p class="header_information"><b>Basic information</b></p>
				   
				   
				   <br/><br/>
				   <div style="margin-left:20%;">
				   
				   <fmt:formatDate value="${profileSetting.dob}" pattern="dd/MMM/yyyy"
						var="myValue" />
				   <table>
				   <tr><td>Name</td><td>${profileSetting.name_surname} </p></td></tr>
				   <tr><td>Birth-Date</td><td>${myValue}</td></tr>
				   <tr><td>email_id</td><td>${profileSetting.email_id}</td></tr>
				   <tr><td>phone</td><td>${profileSetting.phone}</td></tr>
				   <tr><td>Gender</td><td>${profileSetting.gender}</td></tr>
										  
				   <tr><td>Daily-Status</td><td>${profileSetting.daily_status}</td></tr>
				   <tr><td>Native-Place</td><td>${profileSetting.native_place}</td></tr>
				   <tr><td>Current-City</td><td>${profileSetting.live_in}</td></tr>
				   <tr><td>Country</td><td>${profileSetting.country}</td></tr>
				   
				   <tr><td>Relationship</td><td>${profileSetting.relationship}</td></tr>
				   <tr><td>PostGraduation</td><td>${profileSetting.post_graduration}</td></tr>
				   <tr><td>Graduation</td><td>${profileSetting.graduration}</td></tr>
				   <tr><td>Secondary School</td><td>${profileSetting.secondary_school}</td></tr>
				   <tr><td>High School</td><td>${profileSetting.high_school}</td></tr>
				  
				   <tr><td>Work Place</td><td>${profileSetting.work_place}</td></tr>
				   <tr><td>Work Experience</td><td>${profileSetting.work_experience}</td></tr>
				   <tr><td>Skill</td><td>${profileSetting.skill}</td></tr>
				   
				   </table>
				    </div>
				
				   <br/><br/><span style="color:red">click here</span>
		       <img src="${pageContext.request.contextPath}/resources/images/animatedArrow.gif" width="3%"height="3%" />
			   <button class="accordion"><b>Advance information</b></button>
				 
				 
				  <div class="pannel">
 
                  
				   <br/><br/>
				
				   <table>
				   <tr><td>Birth-Place</td><td>${profileSetting.birth_place}</td></tr>
				   <tr><td>religious_Views</td><td>${profileSetting.religious_view}</td></tr>
				   <%-- <tr><td>address</td><td>${profileSetting.paytm}</td></tr> --%>
				   <tr><td>paytm</td><td>${profileSetting.paytm}</td></tr>
				   </table>
				     </center>
				     
					 <br/><br/>
				   <table>
				   <tr><td>Address</td><td>${profileSetting.address}</td></tr>
				   <tr><td>Hobbies</td><td>${profileSetting.hobbies}</td></tr>
				   <tr><td>Favourite-Food</td><td>${profileSetting.favourite_food}</td></tr>
				   <tr><td>Favourite-Singer</td><td>${profileSetting.favourite_singer}</td></tr>
				   <tr><td>Favourite-Movies</td><td>${profileSetting.favourite_movies}</td></tr>
				   <tr><td>Favourite-Daily-Soap</td><td>${profileSetting.favourite_daily_soap}</td></tr>
				   <tr><td>Favourite-Daily-Soap</td><td>${profileSetting.favourite_author}</td></tr>
				   </table>
				  	
					
	             
	
	             </div>
	

				  <script>
							var acc = document.getElementsByClassName("accordion");
						var i;

						for (i = 0; i < acc.length; i++) {
							acc[i].onclick = function(){
								this.classList.toggle("active");
								var panel = this.nextElementSibling;
								if (panel.style.display === "block") {
									panel.style.display = "none";
								} else {
									panel.style.display = "block";
								}
							}
						}
						</script>

							
				  </div>			
			 </div>
				 
				 
   
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