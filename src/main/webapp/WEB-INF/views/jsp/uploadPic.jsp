<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
<div class="body-area">

	<img src="${pageContext.request.contextPath}/resources/images/myownpicvote.jpg" alt="Avatar" class="page_pic">
	<div class="information">
		<p class="header_information">
			<b>My Todays Photo</b>
		</p>
	</div>

	<div class="Myown_pic_header">
		<!-- header -->
		<div class="forgetformheader">
			<center>
				<b><h1>Find Your Todays Photo</h1> <b>
			</center>
		</div>
		<form action="${pageContext.request.contextPath}/user/savePic" method="post" id="uploadPicForm" enctype="multipart/form-data">
			<div class="MyownpicBodyleft">
				<%-- <img src="${pageContext.request.contextPath}/resources/images/itg.jpg" alt="Avatar" style="width: 304px; height: 320px; margin: 1px"> --%>
				<c:if test="${empty picImg}">
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

				</c:if>
				<c:if test="${not empty picImg}">
					<img id="picImageHolder" src="data:image/jpeg;base64,${picImg}" alt="Picture" style="width: 304px; height: 320px; margin: 1px" onclick="$('#picImg').click()" />
				</c:if>

			</div>

			<div class="MyownpicBodyright">
				<span style="color: #eee;">
					<h2>Description</h2>
					<h5>Today 12:00</h5>
					<c:if test="${empty picImg}">
						<textarea name="desc" id="desc" rows="6" cols="35" style="color: black" placeholder="Please provide a detailed description of your Pic." aria-required="true"></textarea>
					</c:if>
					<c:if test="${not empty picImg}">
						<h3>${picData.description}</h3>
					</c:if>
				</span>
				<c:if test="${not empty picImg}">
					<p style="color: red; font-size: 25px">Remaning vote to win(${maxVoteCount})</p>
					<img src="${pageContext.request.contextPath}/resources/images/arrow.gif" style="margin-top: 1%;" src="arrow.gif" width="12%" height="5%" />
					<span style="color: red; font-size: 25px">${maxVoteCount - picData.picVote}</span>
					<div style="margin-top: 19%">

						<p class="btn success">
							<i class="glyphicon glyphicon-thumbs-up" style="font-size: 28px; color: blue"></i> &nbsp;
							<span>${picData.picVote}</span>
						</p>
					</div>
				</c:if>
				<c:if test="${empty picImg}">

					<div style="margin-top: 24%">
						<input type="submit" id="uploadPicBtnId" class="btn success" value="Upload">
					</div>
				</c:if>
				<br /> <br /> <br /> <br /> <br /> <br />


			</div>

		</form>

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
	/* // upload Pr files
	 $('#uploadPicBtnId').click(function(e) {
	 e.preventDefault();
	 alert("aa gaya");
	 var header = $("meta[name='_csrf_header']").attr("content");
	 var token = $("meta[name='_csrf']").attr("content");
	
	 console.log("header :" + header);
	 console.log("token :" + token);

	 var file_data = $('#picImg')[0].files[0];
	 //	var file_data = $('#uploadPic').prop('files')[0];
	 //var docDescription = $('#docDescription').val();
	 //var form_data = new FormData(document.getElementById("uploadPic"));
	 console.log("file data : " + file_data);
	 var form_data = new FormData();
	 form_data.append('uploadPic', file_data);
	 //	form_data.append("desc", "");

	 var uploadUrl = '${pageContext.request.contextPath}/user/savePic';
	 $.ajax({
	 url : uploadUrl,
	 data : form_data,
	 cache : false,
	 xhr : function() {
	 myXhr = $.ajaxSettings.xhr();
	 return myXhr;
	 },

	 type : "POST",
	 //enctype : 'multipart/form-data',
	 contentType: 'multipart/form-data',
	 processData : false,
	 contentType : false,
	 beforeSend : function(xhr) {
	 xhr.setRequestHeader(header, token);
	 $('#loading').show();
	 },
	 success : function(data, textStatus, request) {
	 var info = request.getResponseHeader('success');
	 console.log("Success message : " + info);
	 },
	 error : function(request, textStatus, errorThrown) {
	 var error = request.getResponseHeader('error');
	 },
	 complete : function() {
	 }
	 });
	 }); */
</script>