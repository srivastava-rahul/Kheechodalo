<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">

<jsp:include page="/WEB-INF/views/jsp/message.jsp" />

	<%-- <img src="${pageContext.request.contextPath}/resources/images/aboutUs.jpg" alt="Avatar" class="page_pic"> --%>
	<div class="information">
		<p class="header_information">Search--Page</p>
	</div>
	
	
	
	<%-- <c:forEach var="pic" items="${picsList}"> --%>
	          <div class="containersearch">
	          <%-- <img src="${pageContext.request.contextPath}/resources/images/itg.jpg" alt="Avatar" style="width:90px"> --%>
	          
		    <c:if test="${not empty picImg}">
				<img id="picImageHolder" src="data:image/jpeg;base64,${picImg}" alt="Picture" style="width:90px">
			</c:if>
			<c:if test="${empty picImg}">
			<img src="${pageContext.request.contextPath}/resources/images/profileupload.png" alt="Avatar" style="width:90px">
			</c:if></a>
						  <p><span><a href="#">Chris Fox.</a></span></p>
						  <p style="margin-left:10%;color:black">${viewprofile.daily_status}${viewprofile.email_id}
						  </p>
						 <!--  <button class="view_today_pic">View--Profile</button>&nbsp;&nbsp;&nbsp;&nbsp; -->
		 <a class="view_today_pic"  href="${pageContext.request.contextPath}/user/viewProfile/'${viewprofile.email_id}'">View--Profile</a>	  &nbsp;&nbsp;&nbsp;&nbsp;
						 <!--  <button class="view_profile" style="margin-right:2%">Today--Pic</button> -->
		 <a class="view_profile" style="margin-right:2%" href="${pageContext.request.contextPath}/user/searchpicbyemailId" >Today--Pic</a>
						 </div>
		 
		 
		 <%-- </c:forEach> --%>
	
</div>