<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">

<jsp:include page="/WEB-INF/views/jsp/message.jsp" />

	<%-- <img src="${pageContext.request.contextPath}/resources/images/aboutUs.jpg" alt="Avatar" class="page_pic"> --%>
	<div class="information">
		<p class="header_information">Notification--Page</p>
	</div>
	
	
	
	 <c:forEach var="notify" items="${notifiy}">
	    <div class="containersearch">       
		    <p><span style="color:red">${notify.createdDate}</span><br/><br/>
		    <span style="margin-left:2%;color:black">${notify.notification_desc}</span></p>
		</div>
	 </c:forEach> 
</div>