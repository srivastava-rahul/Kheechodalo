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
	
	 <div style="margin-left: 80%">
	 <span data-WRID="WRID-150143479608384177" data-widgetType="staticBanner" data-responsive="yes" data-class="affiliateAdsByFlipkart" height="120" width="300"></span><script async src="//affiliate.flipkart.com/affiliate/widgets/FKAffiliateWidgets.js"></script>
	
	 
	 </div>
	 <c:forEach var="notify" items="${notifiy}">
	    <!-- <div class="containersearch">  -->
	    <div style="width:60%; height:15%; border: 2px solid black; background-color: white; border-radius: 10px; padding: 8px; margin: 12px 0; margin-left:5%;">      
		    <p><span style="color:red">${notify.createdDate}</span><br/><br/>
		    <span style="margin-left:2%;color:black">${notify.notification_desc}</span></p>
		</div>
	 </c:forEach> 

    
	 
    <div style="margin-left:40%;margin-top: 3%">
	<div data-WRID="WRID-150325420505791119" data-widgetType="staticBanner" data-responsive="yes" data-class="affiliateAdsByFlipkart" height="90" width="728"></div><script async src="//affiliate.flipkart.com/affiliate/widgets/FKAffiliateWidgets.js"></script>
	 </div>
	 
	 
	 
 
</div>