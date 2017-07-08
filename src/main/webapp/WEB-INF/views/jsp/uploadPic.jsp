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

		<div class="MyownpicBodyleft">
			<img src="${pageContext.request.contextPath}/resources/images/itg.jpg" alt="Avatar" style="width: 304px; height: 320px; margin: 1px">
		</div>

		<div class="MyownpicBodyright">
			<h2>Description</h2>
			<h5>Today 12:00</h5>
			<h3>Its a aswome view that i click Its a aswome view that i click Its a aswome view that i click</h3>
			<p style="color: red; font-size: 25px">Remaning vote to win</p>
			<img src="${pageContext.request.contextPath}/resources/images/arrow.gif" style="margin-top: 1%;" src="arrow.gif" width="12%" height="5%" />
			100

			<div style="margin-top: 20%">

				<p class="btn success">
					<i class="glyphicon glyphicon-thumbs-up" style="font-size: 28px; color: blue"></i> 10000000000000000000
				</p>

			</div>
			<%-- <div class="fileinput fileinput-new input-group"
				data-provides="fileinput">
				<form action="" method="post" id="uploadPicForm">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}">
					<div data-trigger="fileinput" class="form-control">
						<span class="fileinput-filename show_name"></span>
					</div>
					<input name="uploadPic" id="uploadPic" type="file"> <input
						type="button" id="uploadPicBtnId" value="Apply">
				</form>
			</div> --%>
			<br /> <br /> <br /> <br /> <br /> <br />
			<form action="${pageContext.request.contextPath}/user/savePic" method="post" id="uploadPicForm" enctype="multipart/form-data">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				<div class="profile">
					<img id="picImageHolder" src="${pageContext.request.contextPath}/resources/images/logo-image.png" alt="Logo" width="400px" height="400px" onclick="$('#picImg').click()" />
					<div class="col-md-8">
						<a href="javascript:" onclick="$('#picImg').click()">Upload Pic</a>
					</div>
					<div class="col-md-4">
						<a href="javascript:" id="removeLogo">Remove Pic</a>
					</div>
					<%-- <c:if test="${not empty picImg}">
						<img id="picImageHolder" src="data:image/jpeg;base64,${picImg}" alt="Logo" onclick="$('#picImg').click()" />
						<div class="col-md-8">
							<a href="javascript:" onclick="$('#picImg').click()" >Upload Logo</a>
						</div>
						<div class="col-md-4">
							<a href="javascript:" id="removeLogo" >Remove Logo</a>
						</div>
						</c:if> --%>
					<input type="file" accept="image/*" style="visibility: hidden" name="picImg" id="picImg">
					<input type="hidden" id="removeFile" name="removeFile" value="false">
					<input type="submit" id="uploadPicBtnId" value="Apply">
				</div>
			</form>

		</div>


	</div>

</div>


<script>
	$(document).ready(
			function() {
				$("body").delegate("#picImg", "change",	function() {
							if (typeof (FileReader) == null) {
								var image_holder = document
										.getElementById("picImageHolder").src;
								console.log("=====");
								image_holder.attr('src', getContextPath()+ '/resources/images/logo-image.png');
							} else if (typeof (FileReader) != "undefined") {
								$("#removeFile").val(false);
								var image_holder = $("#picImageHolder");
								image_holder.empty();
								var reader = new FileReader();
								reader.onload = function(e) {
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
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> -->

<%-- <script type="text/javascript"	src="${pageContext.request.contextPath}/resources/js/view/file-input/file-input.js"></script> --%>
