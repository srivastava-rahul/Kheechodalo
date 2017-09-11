<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

<div class="body-area">
	
	
	<%-- <img src="${pageContext.request.contextPath}/resources/images/myownpicvote.jpg" alt="Avatar" class="page_pic"> --%>
	
	
	<c:if test="${not empty picImg}">
				<img id="picImageHolder" src="data:image/jpeg;base64,${picImg}" alt="Picture"  class="page_pic"/>
			</c:if>
			<c:if test="${empty picImg}">
			<img src="${pageContext.request.contextPath}/resources/images/profile.jpg" alt="Avatar" class="page_pic">
			</c:if>
			
	<div class="information">
		<p class="header_information">
			<b>My Todays Photo</b>
		</p>
	</div>

	<div class="Myown_pic_header">
		<!-- header -->
		<div class="forgetformheader">
			<center>
				<b><h1>Upload Your Profile Photo</h1> <b>
			</center>
		</div>

		<div class="MyownpicBodyleft">
			<%-- <img src="${pageContext.request.contextPath}/resources/images/itg.jpg" alt="Avatar" style="width: 304px; height: 320px; margin: 1px"> --%>
			<c:if test="${empty picImg}">
				<form action="${pageContext.request.contextPath}/user/saveProfilePic" method="post" id="uploadPicForm" enctype="multipart/form-data">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					<img id="picImageHolder" src="${pageContext.request.contextPath}/resources/images/logo-image.png" alt="Picture" style="width: 304px; height: 320px; margin: 1px" onclick="$('#picImg').click()" />
					<div class="row">
						<div class="col-md-6">
							<a href="javascript:" onclick="$('#picImg').click()" style="color:black;">Select Pic</a>
						</div>
						<div class="col-md-6">
							<a href="javascript:" id="removeLogo" style="float: right; color: black;">Remove Pic</a>
						</div>
					</div>
					<input type="file" accept="image/*" style="visibility: hidden" name="picImg" id="picImg">
					<input type="hidden" id="removeFile" name="removeFile" value="false">
					<input type="submit" id="uploadPicBtnId" class="btn success" value="Upload">
				</form>
			</c:if>
			<c:if test="${not empty picImg}">
				<img id="picImageHolder" src="data:image/jpeg;base64,${picImg}" alt="Picture" style="width: 304px; height: 320px; margin: 1px" onclick="$('#picImg').click()" />
			</c:if>

		</div>
		
		                
		
	</div>
	
	 <%-- <div >	
	 <a href="${pageContext.request.contextPath}/user/getProfileSettings"  style="margin-top:10%; ">BACK</a>
     </div> --%>
     
     <div class="MyownpicBodyright">
     
     
			<h1><a href="${pageContext.request.contextPath}/user/getProfileSettings"  style="margin-top:10%;color:red "><span><img src="${pageContext.request.contextPath}/resources/images/download.jpg" style="margin-top: 1%; background-color: transparent;" src="arrow.gif" width="5%" height="4%"/>&nbsp;BACK</span></a></h1>

			</div>
			
			
			<br /> <br /> <br /> <br /> <br /> <br />


		</div>
     
     
</div>


<script>
	$(document).ready(
			function() {
				$("body").delegate(
						"#picImg",
						"change",
						function() {
							if (typeof (FileReader) == null) {
								var image_holder = document
										.getElementById("picImageHolder").src;
								console.log("=====");
								image_holder.attr('src', getContextPath()
										+ '/resources/images/logo-image.png');
							} else if (typeof (FileReader) != "undefined") {
								$("#removeFile").val(false);
								var image_holder = $("#picImageHolder");
								var reader = new FileReader();
								reader.onload = function(e) {
								image_holder.empty();
									image_holder.attr('src', e.target.result);
								}
								//console.log("=====");
								image_holder.show();
								reader.readAsDataURL($(this)[0].files[0]);
							} else {
								//alert("This browser does not support FileReader.");
							}
						});
			});
</script>