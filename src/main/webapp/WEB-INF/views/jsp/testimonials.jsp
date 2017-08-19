<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
<div class="body-area">

				<div class="information">
						<p class="header_information"><b>Testimonials for participants</b></p>
					</div>
         
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
						
	</div>