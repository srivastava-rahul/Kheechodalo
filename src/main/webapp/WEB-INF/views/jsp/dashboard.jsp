<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
<script>
/* var myIndex = 0;
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
} */

$(document).ready(function() {
	var num2 = 4;
	<c:if test="${not empty pageNo}">
	num2 = parseInt('${pageNo}');
	</c:if>
	var html2 = "";
	html2 += '<li><a href="#" class="previousPage">�</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num2 - 3)+ '" >'+(num2 - 3)+ '</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num2 - 2)+ '">'+(num2 - 2)+ '</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num2 - 1)+ '">'+(num2 - 1)+ '</a></li>';
	html2 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num2)+ '">'+(num2)+ '</a></li>';
	html2 += '<li><a href="#" class="nextPage">�</a></li>';
	$('.pagination').html(html2);
	
	
	
			$("body").delegate(	".previousPage",	"click",	function() {
							var num = parseInt($('.pagination li:nth-last-child(2)').text())-3;
						if (num >= 5) {
							var html1 = "";
							console.log("num  :"+ num);
							html1 += '<li><a href="#" class="previousPage">�</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num - 4)+ '" >'+(num - 4)+ '</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num - 3)+ '">'+(num - 3)+ '</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num - 2)+ '">'+(num - 2)+ '</a></li>';
							html1 += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(num - 1)+ '">'+(num - 1)+ '</a></li>';
							html1 += '<li><a href="#" class="nextPage">�</a></li>';
							$('.pagination').html(html1);
						}
						
						
			});
			
			$("body").delegate(	".nextPage",	"click",	function() {
				var number = parseInt($('.pagination li:nth-last-child(2)').text());
				var html = "";
				html += '<li><a href="#" class="previousPage">�</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(number + 1)+ '" >'+(number + 1)+ '</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(number + 2)+ '">'+(number + 2)+ '</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(number + 3)+ '">'+(number + 3)+ '</a></li>';
				html += '<li><a href="${pageContext.request.contextPath}/user/dashboardPagination/'+(number + 4)+ '">'+(number + 4)+ '</a></li>';
				html += '<li><a href="#" class="nextPage">�</a></li>';
				$('.pagination').html(html)
	});
						
					});


</script>

<!-- Description button drop down -->
<style>
.dropbtn {
    background-color:lightseagreen;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropdown {
    float:right;
    display: inline-block;
}

.dropdown-content {
    display: none;   
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}
</style>



<!-- Css for dashboard card structure -->
<style>
/* body
 body
 {
  font-family: Verdana, sans-serif;
  margin: 0;
} */

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
   /* width: auto; */
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
  background-color: rgb(23, 23, 23);
}

/* Modal Content */
.modal-content {
  position: relative;
  background-color: #fefefe;
  margin: auto;
  margin-top:0.5%;
  padding: 0;
  width:50%;
  height:80%;
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
  <ul class="pagination" style="float:right;margin-right:3%">
  </ul>
     
 <%--  	<form name="searchFormuser" action="searchUserPicbyemailid" method="post" style="margin-left:30%;margin-top:2%">
			   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			
			<div class="Changepasswordformboby">
				<!-- <h3 style="color: yellow">Please Search your loved one Here... </h3> -->
				<input type="text"  name="email_id" id="email_id" style="width:30% "
					placeholder="Please Search your loved one Here....Email" />
					<button type="submit" class="button_submit  submit" style="background-color:red">Search</button>
				    <c:url value="/user/dashboard" var="dashUrl" />
			</div>
		</form> --%>
		<br/>
		</div>
		
		<br/><br/><br/><br/>
<jsp:include page="/WEB-INF/views/jsp/message.jsp" />
	<div >
	         <!-- /////////////////This for pics on dashboard\\\\\\\\\\\\\\\\\\\\\\\\ -->
		<div class="row">
		<c:if test="${empty searchPic}">
			<c:forEach var="pic" items="${picsList}" varStatus="index">
			<div class="column">
				<div class="card">
					<img src="data:image/jpeg;base64,${pic.base64Encoded}" style="width: 200px; height: 200px;border-radius: 72%;" onclick="openModal();currentSlide(${index.index +1})" class="hover-shadow cursor">
					<h2><span style="margin-left: 50%;color: red" class="voteCount${pic.id}">${pic.picVote}</span></h2>
					 <c:if test="${pic.allowToVote}"> 
						<p align="center" class="hideVote${pic.id}">
							<button class="marg-bottom-10 button_submit  submit votePic">Vote</button>
							<input type="hidden" id="picId" name="picId" value="${pic.id}">
						</p>
					</c:if>
					<div class="">
						<h4 style="color:blue;margin-left:2%;font-weight: bold;font-family: serif; "><a href="${pageContext.request.contextPath}/user/viewProfile/${pic.userEmailId}">${pic.userName}</a></h4>
					     
                         <div class="dropdown">
                                                  
                                 <button class="dropbtn">Description</button>
                                 <div class="dropdown-content">
                                 <br/>
                                 <p style="color:green">${pic.picDescription}</p><br/>
                               </div>
                               
                         </div>
				
						
					   <%--  <c:if test="${pic.allowToVote}"> 
						<p align="center" class="hideVote${pic.id}">
							<button class="marg-bottom-10 button_submit  submit votePic">Vote</button>
							<input type="hidden" id="picId" name="picId" value="${pic.id}">
						</p>
					</c:if> --%>
					</div>
				</div>
			</div>
			</c:forEach>
			</c:if>
			
			
			<!-- ////////////////This is the div for getting the pics on search ////////////////// -->
			<c:if test="${not empty searchPic}">
			<div class="column">
				<div class="card">
					<img src="data:image/jpeg;base64,${searchPic.base64Encoded}"	alt="Picture" style="width: 200px; height: 200px;border-radius: 72%;" onclick="openModal();currentSlide(${index.index +1})" class="hover-shadow cursor">
					<h2><span style="margin-left: 50%;color: red" class="voteCount${searchPic.id}">${searchPic.picVote}</span></h2>
					 <c:if test="${searchPic.allowToVote}"> 
						<p align="center" class="hideVote${searchPic.id}">
							<button class="marg-bottom-10 button_submit  submit votePic">Vote</button>
							<input type="hidden" id="picId" name="picId" value="${searchPic.id}">
						</p>
					</c:if>
					
					<div class="">
						<h4 style="color:blue;margin-left:2%;font-weight: bold;font-family: serif;"><a href="${pageContext.request.contextPath}/user/viewProfile/${searchPic.userEmailId}">${searchPic.userName}</a></h4>
						 <div class="dropdown">
                                 <button class="dropbtn">Description</button>
                                 
                                 <div class="dropdown-content">
                                 <br/>
                                 <p style="color:green;">${searchPic.picDescription}</p><br/>
                               </div>
                                
                         </div>
						
						<%-- <p>${searchPic.picDescription}</p> --%>
						
					<%--  <c:if test="${searchPic.allowToVote}"> 
						<p align="center" class="hideVote${searchPic.id}">
							<button class="marg-bottom-10 button_submit  submit votePic">Vote</button>
							<input type="hidden" id="picId" name="picId" value="${searchPic.id}">
						</p>
					</c:if> --%>
					</div>
				</div>
			</div>
			</c:if>
		</div>
	</div>
	
	
	                    <div>
                              <ul class="pagination" style="float:right;margin-right:3%;margin-top: 0%">
                              </ul>
      
 
		                 <br/>
		               </div>
	
	
	    <div style="margin-top: 5%;margin-left: 10%;">
		<div data-WRID="WRID-150325420505791119" data-widgetType="staticBanner" data-responsive="yes" data-class="affiliateAdsByFlipkart" height="90" width="728"></div><script async src="//affiliate.flipkart.com/affiliate/widgets/FKAffiliateWidgets.js"></script>
		
		
		</div>
		
		
<div id="myModal" class="modal">
  <b><a href="#" onclick="closeModal()"><img src="${pageContext.request.contextPath}/resources/images/crossSign.png" alt="Avatar" style="float: right;width:3%;height:5%;margin-right:18% "></a></b>
  <div class="modal-content">
<c:if test="${empty searchPic}">
       <c:forEach var="pic" items="${picsList}">
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
					<h2><span style="margin-left: 50%;color: red; " class="voteCount${pic.id}">${pic.picVote}</span></h2>
					<div class="">
						<b><h2 style="color:blue"><a href="${pageContext.request.contextPath}/user/viewProfile/${pic.userEmailId}">${pic.userName}</a></h2></b>
						<%-- <b><h2 style="color:blue">${pic.userEmailId}</h2></b> --%>
						<center><p style="color:green;">${pic.picDescription}</p></center>
					 <c:if test="${pic.allowToVote}"> 
						<p align="center" class="hideVote${pic.id}">
							<button class="marg-bottom-10 button_submit  submit votePic">Vote</button>
							<input type="hidden" id="picId" name="picId" value="${pic.id}">
						</p>
					</c:if>
					</div>
				</div>
				</div>
			
			</c:forEach>
			</c:if>
			<c:if test="${not empty searchPic}">
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
					<img src="data:image/jpeg;base64,${searchPic.base64Encoded}" style="width:100%;height:90%">
					<h2><span style="margin-left: 50%;color: red; " class="voteCount${searchPic.id}">${searchPic.picVote}</span></h2>
					<div class="">
						<b><h2 style="color:blue">${searchPic.userName}</h2></b>
						<%-- <b><h2 style="color:blue">${searchPic.userEmailId}</h2></b> --%>
						<p style="color:green">${searchPic.picDescription}</p>
					 <c:if test="${searchPic.allowToVote}"> 
						<p align="center" class="hideVote${searchPic.id}">
							<button class="marg-bottom-10 button_submit  submit votePic">Vote</button>
							<input type="hidden" id="picId" name="picId" value="${searchPic.id}">
						</p>
					</c:if>
					</div>
				</div>
				</div>
			</c:if>
    
      

    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
    <a class="next" onclick="plusSlides(1)">&#10095;</a>

    <div class="caption-container">
      <p id="caption"></p>
    </div>
	
	</div>
	
	</div>
</div>


<script>
 // Ajax for Vote 
		$('.votePic').click(function(e) {
			e.preventDefault();
		//	alert("aa gaya");
			var header = $("meta[name='_csrf_header']").attr("content");
			var token = $("meta[name='_csrf']").attr("content");
			var picId = $(this).closest("div.card").find("input[name='picId']").val();
			console.log("Pic Id :" + picId);

			var voteUrl = '${pageContext.request.contextPath}/user/saveVote';
			$.ajax({
				url : voteUrl,
				data : {'picId' : picId},
				type : "POST",
				beforeSend : function(xhr) {
				//	xhr.setRequestHeader(header, token);
					$('#loading').show();
				
					 $('.hideVote'+picId).addClass().hide();
				},
				success : function(data, textStatus, request) {
					console.log("Success  : " + data);
					$('.voteCount'+picId).html(data);
					/* $('.hideVote'+picId).addClass().hide(); */
				},
				error : function(request, textStatus, errorThrown) {
					var error = request.getResponseHeader('error');
				},
				complete : function() {
				}
			}); 
		});
</script>

<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].onclick = function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.maxHeight){
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = 130 + "px";
    } 
  }
}
</script>


