<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
<%-- 
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.form-validator.min.js"></script>  --%>


<div class="body-area">
<jsp:include page="/WEB-INF/views/jsp/message.jsp" />
	<div id="overlay"></div>
	<img
		src="${pageContext.request.contextPath}/resources/images/myownpicvote.jpg"
		alt="Avatar" class="page_pic">
	<div class="information">
		<p class="header_information">
			<b>My Todays Photo</b>
		</p>
	</div>
	
	<center style="color:red">** Note:-Photo size should not be more than 5 MB</center>

	<!-- <button onclick="on()">Turn on overlay effect</button> -->

	<div class="loader" style="display: none"></div>
	<div class="Myown_pic_header">
		<!-- header -->
	<%-- 	<div class="forgetformheader">
			<center>
				<b>Find Your Todays Photo <b>
			</center>
		</div> --%>
		
		<form action="${pageContext.request.contextPath}/user/savePic"
			method="post" id="uploadPicForm" enctype="multipart/form-data">
			<div class="MyownpicBodyleft">
				<%-- <img src="${pageContext.request.contextPath}/resources/images/itg.jpg" alt="Avatar" style="width: 304px; height: 320px; margin: 1px"> --%>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}"> <input type="hidden" name="picId"
					value="${picData.id}">
				<c:if test="${empty picImg}">
					<img id="picImageHolder"
						src="${pageContext.request.contextPath}/resources/images/logo-image.png"
						alt="Picture" style="width: 304px; height: 320px; margin: 1px"
						onclick="$('#picImg').click()" />
				</c:if>

				<c:if test="${not empty picImg}">
					<img id="picImageHolder" src="data:image/jpeg;base64,${picImg}"
						alt="Picture" style="width: 304px; height: 320px; margin: 1px"
						onclick="$('#picImg').click()" />
				</c:if>
				<div class="row">
					<div class="col-md-12">
						<a href="javascript:" onclick="$('#picImg').click()"
							style="color: black;" class="${not empty picImg ? ' changePic ': ''}">${not empty picImg ? ' Change ': 'Select '}Pic</a>
					</div>
				</div>
				<input type="file" accept="image/*" style="visibility: hidden"
					name="picImg" id="picImg">


			</div>

			<div class="MyownpicBodyright">
				<c:if test="${empty picImg}">
					<span style="color: black;">
						<h2>Description</h2> <!-- <h5>Today 12:00</h5> --> <textarea
							name="desc" id="desc" rows="6" cols="35" style="color: black"
							placeholder="Please provide a detailed description of your Pic...Only 45 charcter is allowed"
							aria-required="true" maxlength="45"></textarea>
					</span>
					<div style="margin-top: 24%">
						<input type="submit" id="uploadPicBtnId" class="btn success"
							value="Upload" onclick="on()">
					</div>
				</c:if>
				<span id="picImgEmpty" style="display: none"> <span style="color: black;">
						<h2>Description</h2> <!-- <h5>Today 12:00</h5> --> <textarea
							name="desc" id="desc" rows="6" cols="35" style="color: black"
							placeholder="Please provide a detailed description of your Pic...Only 45 charcter is allowed"
							aria-required="true" maxlength="45">${picData.description}</textarea>
				</span>
					<div style="margin-top: 24%">
						<input type="submit" id="uploadPicBtnId" class="btn success"
							value="Upload" onclick="on()">
					</div>
				</span>
				<c:if test="${not empty picImg}">
					<span id="picImgNotEmpty"> <span style="color: black;">
					<h3>${picData.description}</h3>
					</span>
						<p style="color: green; font-size: 25px">Winner vote
							(${maxVoteCount})</p>
						<p style="color: red; font-size: 25px">Remaning vote to win</p> <img
						src="${pageContext.request.contextPath}/resources/images/arrow.gif"
						style="margin-top: 1%;" src="arrow.gif" width="12%" height="5%" />
						<span style="color: red; font-size: 25px">${maxVoteCount - picData.picVote}</span>
						<div style="margin-top: 19%">

							<p class="btn success">
								<i class="glyphicon glyphicon-thumbs-up"
									style="font-size: 28px; color: blue"></i> &nbsp; <span>${picData.picVote}</span>
							</p>
						</div>
					</span>
				</c:if>




				<br /> <br /> <br /> <br />
				<div>
				<!-- 	<span data-WRID="WRID-150329794559992600"
						data-widgetType="productBanner"
						data-class="affiliateAdsByFlipkart" height="240px" width="120px"></span>
					<script async
						src="//affiliate.flipkart.com/affiliate/widgets/FKAffiliateWidgets.js"></script>
					<span data-WRID="WRID-150329878052136571"
						data-widgetType="productBanner"
						data-class="affiliateAdsByFlipkart" height="240px" width="120px"></span>
					<script async
						src="//affiliate.flipkart.com/affiliate/widgets/FKAffiliateWidgets.js"></script> -->
					<span data-WRID="WRID-150143503619477538" data-widgetType="staticBanner" 
					data-responsive="yes" data-class="affiliateAdsByFlipkart" height="90" width="728"></span>
					<script async src="//affiliate.flipkart.com/affiliate/widgets/FKAffiliateWidgets.js"></script>
				</div>
			</div>
		</form>
	</div>

</div>
<script>
	$(document).ready(
			function() {
				$('.body-area').fadeIn(10);
					$('.changePic').click(function() {
					$('#picImgEmpty').css('display','block');
					$('#picImgNotEmpty').css('display','none');
				});
				
				
				$("body").delegate(
						"#picImg",
						"change",
						function() {
							/* if($('#uploadPicForm').isValid()){
								return false;
							} */
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


<!-- <script>
$.validate({
  modules : 'file',
  lang: 'en'
});
</script> -->

<style>
#overlay {
	position: fixed; /* Sit on top of the page content */
	display: none; /* Hidden by default */
	width: 100%; /* Full width (cover the whole page) */
	height: 100%; /* Full height (cover the whole page) */
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: rgba(0, 0, 0, 0.5);
	/* Black background with opacity */
	z-index: 2;
	/* Specify a stack order in case you're using a different order for other elements */
	cursor: pointer; /* Add a pointer on hover */
}

.loader {
	border: 16px solid #f3f3f3;
	border-radius: 50%;
	border-top: 16px solid #3498db;
	width: 120px;
	height: 120px;
	-webkit-animation: spin 2s linear infinite;
	animation: spin 2s linear infinite;
	margin: auto;
}

@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

</style>


<script>
	function on() {
		document.getElementById("overlay").style.display = "block";
		$(".loader").css('display', 'block');
	}

	function off() {
		document.getElementById("overlay").style.display = "none";
	}
</script>
