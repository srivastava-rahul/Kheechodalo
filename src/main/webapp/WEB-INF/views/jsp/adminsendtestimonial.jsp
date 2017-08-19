<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">
	<jsp:include page="/WEB-INF/views/jsp/message.jsp" />
	
	<div class="information">
		<p class="header_information">Testimonials Information for Admin</p>
	</div>
	
	
	
	<h3 style="color: yellow;margin-left: 25%">Please tell What to be search enter here... </h3>
    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search By Email..." title="Type in Email" style = "width: 452px; height: 38px;;margin-left: 25%"/>
	</br></br>
	
		<div class="Myown_pic_header">
		<!-- header -->
		<div class="forgetformheader">
			<center>
				<b><h1>Find Your Todays Photo</h1> <b>
			</center>
		</div>
		<form action="${pageContext.request.contextPath}/admin/savetestimonialPic" method="post" id="uploadPicForm" enctype="multipart/form-data">
			<div class="MyownpicBodyleft">
			
				
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					<img id="picImageHolder" src="${pageContext.request.contextPath}/resources/images/logo-image.png" alt="Picture" style="width: 304px; height: 320px; margin: 1px" onclick="$('#picImg').click()" />
					<div class="row">
						<div class="col-md-12">
							<a href="javascript:" onclick="$('#picImg').click()" style="color: #eee;">Select Pic</a>
						</div>
						<!-- <div class="col-md-6">
							<a href="javascript:" id="removeLogo" style="float: right; color: #eee;">Remove Pic</a>
						</div> -->
					</div>
					<input type="file" accept="image/*" style="visibility: hidden" name="picImg" id="picImg">

				
				<c:if test="${not empty picImg}">
					<img id="picImageHolder" src="data:image/jpeg;base64,${picImg}" alt="Picture" style="width: 304px; height: 320px; margin: 1px" onclick="$('#picImg').click()" />
				</c:if>

			</div>

			<div class="MyownpicBodyright">
				<span style="color: #eee;">
					<h4>Description</h4>
						<textarea name="desc" id="desc" rows="6" cols="35" style="color: black" placeholder="Please provide a detailed description of your Pic." aria-required="true"></textarea>
					<h4>Name</h4>
						<textarea name="name" id="name" rows="2" cols="25" style="color: black" placeholder="Please provide a name." aria-required="true"></textarea>
				    <h4>Email_id</h4>
						<textarea name="email" id="email" rows="2" cols="25" style="color: black" placeholder="Please provide a email_id."></textarea>
				</span>
				<%-- <c:if test="${not empty picImg}">
				    <p style="color: green; font-size: 25px">Winner vote (${maxVoteCount})</p>
					<p style="color: red; font-size: 25px">Remaning vote to win</p>
					<img src="${pageContext.request.contextPath}/resources/images/arrow.gif" style="margin-top: 1%;" src="arrow.gif" width="12%" height="5%" />
					<span style="color: red; font-size: 25px">${maxVoteCount - picData.picVote}</span>
					<div style="margin-top: 19%">

						<p class="btn success">
							<i class="glyphicon glyphicon-thumbs-up" style="font-size: 28px; color: blue"></i> &nbsp;
							<span>${picData.picVote}</span>
						</p>
					</div>
				</c:if>
 --%>				

					<div style="margin-top: 24%">
						<input type="submit" id="uploadPicBtnId" class="btn success" value="Upload">
					</div>
				
				<br /> <br /> <br /> <br /> <br /> <br />


			</div>

		</form>

	</div>
	
	
	
	
	
	
	
	
	
	<!-- slcmsl,c;sc;,;s,c;s,c;,s -->
	
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
		
		<c:forEach var="testimonials" items="${testimonial}">
			<tr>
				<td><center>${testimonials.id}</center></td>
				<td><center>${testimonials.createdDate}</center></td>
				<td><center>${testimonials.email_id}</center></td>
				<td><center>${testimonials.name}</center></td>
				<td><center>${testimonials.testimonial_desc}</center></td>
				<td><center><img src="data:image/jpeg;base64,${testimonials.base64Encoded}" alt="Avatar" style="width: 250px;height: 250px"></center></td>
				<td><center>
						<a
							href="${pageContext.request.contextPath}/admin/admindeletetestimonial/${testimonials.id}">Delete</a>
					</center></td>
			</tr>
		</c:forEach>

	</table>
	
	
	
	
	
	
	
	
	
	
	
	</div>

	