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
<br>

<div class="body-area">

<jsp:include page="/WEB-INF/views/jsp/message.jsp" />
	<div >
		<div class="row">
			<c:forEach var="pic" items="${picsList}">
			<div class="column">
				<div class="card">
					<img
						src="${pageContext.request.contextPath}/resources/images/earth.jpg"	alt="Picture" style="width: 291px; height: 320px;">
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
			<div class="column">
				<div class="card">
					<img src="${pageContext.request.contextPath}/resources/images/earth.jpg" alt="Picture" style="width: 291px; height: 320px;">
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
		</div>
	</div>
</div>