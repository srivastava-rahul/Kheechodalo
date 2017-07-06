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
</script>
<!-- 
<script type="text/javascript">
	var images = [ "1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg",
			"7.jpg" ];
	$(function() {
		var i = 0;
		$(".dvImage").css(
				"background",
				"url(${pageContext.request.contextPath}/resources/images/bck/" + images[i]
						+ ")no-repeat center center fixed");
		$(".dvImage").css("background-size", "cover");
		setInterval(function() {
			i++;
			if (i == images.length) {
				i = 0;
			}
			$(".dvImage").fadeOut(
					"slow",
					function() {
						$(this).css(
								"background",
								"url(${pageContext.request.contextPath}/resources/images/bck/" + images[i]
										+ ")no-repeat center center fixed");
						$(".dvImage").css("background-size", "cover");
						$(this).fadeIn("slow");
					});
		}, 100000);
	});
</script>
 -->	<br>

<div class="body-area">

<c:if test="${not empty success}">
		<div class="alert alert-success" id="idGlobalSuccess">
			<div class="">
				<!-- <i class="fa fa-key" aria-hidden="true"></i> -->
			</div>
			<div class="alert-content" style="text-align: left; padding-bottom: 12px; font-size: 16px; color: blue">
				<!-- <h4 class="alert-title">Success</h4> -->
				<c:choose>
					<c:when test="${!empty success && success.getClass().simpleName eq 'String'}">
					${success}
				</c:when>
					<c:otherwise>
						<c:forEach var="msg" items="${success}">
						${msg}<br />
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</c:if>



	<div >
		<div class="row">
			<div class="column">
				<div class="card">
					<img
						src="${pageContext.request.contextPath}/resources/images/pro.jpg"
						alt="Jane" style="width: 100%; height: auto">
					<div class="">
						<h2>Jane Doe</h2>
						<p class="title">CEO & Founder</p>
						<p>Some text that describes me lorem ipsum ipsum lorem.</p>
						<p>example@example.com</p>
						<p align="center">
							<button class="marg-bottom-10 button_submit  submit">Contact</button>
						</p>
					</div>
				</div>
			</div>
			<div class="column">
				<div class="card">
					<img
						src="${pageContext.request.contextPath}/resources/images/pro.jpg"
						alt="Jane" style="width: 100%; height: auto">
					<div class="">
						<h2>Jane Doe</h2>
						<p class="title">CEO & Founder</p>
						<p>Some text that describes me lorem ipsum ipsum lorem.</p>
						<p>example@example.com</p>
						<p align="center">
							<button class=" marg-bottom-10 button_submit  submit">Contact</button>
						</p>
					</div>
				</div>
			</div>
			<div class="column">
				<div class="card">
					<img
						src="${pageContext.request.contextPath}/resources/images/pro.jpg"
						alt="Jane" style="width: 100%; height: auto">
					<div class="">
						<h2>Jane Doe</h2>
						<p class="title">CEO & Founder</p>
						<p>Some text that describes me lorem ipsum ipsum lorem.</p>
						<p>example@example.com</p>
						<p align="center">
							<button class="marg-bottom-10 button_submit  submit">Contact</button>

						</p>
					</div>
				</div>
			</div>
			<div class="column">
				<div class="card">
					<img
						src="${pageContext.request.contextPath}/resources/images/pro.jpg"
						alt="Jane" style="width: 100%; height: auto">
					<div class="">
						<h2>Jane Doe</h2>
						<p class="title">CEO & Founder</p>
						<p>Some text that describes me lorem ipsum ipsum lorem.</p>
						<p>example@example.com</p>
						<p align="center">
							<button class=" marg-bottom-10 button_submit  submit">Contact</button>

						</p>
					</div>
				</div>
			</div>
			<div class="column">
				<div class="card">
					<img
						src="${pageContext.request.contextPath}/resources/images/pro.jpg"
						alt="Jane" style="width: 100%; height: auto">
					<div class="">
						<h2>Jane Doe</h2>
						<p class="title">CEO & Founder</p>
						<p>Some text that describes me lorem ipsum ipsum lorem.</p>
						<p>example@example.com</p>
						<p align="center">
							<button class=" marg-bottom-10 button_submit  submit">Contact</button>

						</p>
					</div>
				</div>
			</div>
			<div class="column">
				<div class="card">
					<img
						src="${pageContext.request.contextPath}/resources/images/pro.jpg"
						alt="Jane" style="width: 100%; height: auto">
					<div class="">
						<h2>Jane Doe</h2>
						<p class="title">CEO & Founder</p>
						<p>Some text that describes me lorem ipsum ipsum lorem.</p>
						<p>example@example.com</p>
						<p align="center">
							<button class="marg-bottom-10button_submit  submit">Contact</button>

						</p>
					</div>
				</div>
			</div>

		</div>

	</div>
</div>

