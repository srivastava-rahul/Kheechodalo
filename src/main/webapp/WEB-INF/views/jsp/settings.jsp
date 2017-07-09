<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
<div class="body-area">
	<c:if test="${not empty error}">
		<div class="alert alert-danger" id="idGlobalError">
			<div class="">
				<!-- <i class="glyph-icon icon-times"></i> -->
			</div>
			<div class="alert-content">
				<!-- <h4 class="alert-title">Error</h4> -->
				<c:choose>
					<c:when
						test="${!empty error && error.getClass().simpleName eq 'String'}">
					${error}
				</c:when>
					<c:otherwise>
						<c:forEach var="msg" items="${error}">
						${msg}<br />
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</c:if>
	<c:if test="${not empty success}">
		<div class="alert alert-success" id="idGlobalSuccess">
			<div class="">
				<!-- <i class="fa fa-key" aria-hidden="true"></i> -->
			</div>
			<div class="alert-content" style="text-align: left; padding-bottom: 12px; font-size: 16px; color: blue">
				<!-- <h4 class="alert-title">Success</h4> -->
				<c:choose>
					<c:when test="${!empty success && success.getClass().simpleName eq 'String'}">
					${success}
				</c:when>
					<c:otherwise>
						<c:forEach var="msg" items="${success}">
						${msg}<br />
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</c:if>
	<div>
		<img src="${pageContext.request.contextPath}/resources/images/itg.jpg" alt="Avatar" class="page_pic">
	</div>
	<div class="information">
		<p class="header_information">
			<b>Basic information </b>
		</p>

		<form:form name="Basic_information" action="basicInformation" method="post" modelAttribute="profileSetting">
			<form:hidden path="id" />
			<br />
			<p style="color: red">*(Note if you select Hidden option than Data of that field is not visible to others )</p>
			<br />
			<center>
				<table>
					<tr>
						<td>Name</td>
						<td>
							<form:input placeholder="Name     Surname" style="color:black" path="name_surname" />
						</td>
					</tr>
					<tr>
						<td>Birthday</td>
						<td>
							<form:input placeholder="dd/MM/YYYY" style="color:black" path="dob" />
						</td>
					</tr>
					<tr>
						<td>email_id</td>
						<td>
							<form:input placeholder="email address" style="color:black" path="email_id" />
						</td>
					</tr>
					<tr>
						<td>phone</td>
						<td>
							<form:input placeholder="mobile number" style="color:black" path="phone" />
						</td>
						<td>
							<form:checkbox path="phone_flage" value="true" />
							Hidden
						</td>
					</tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr>
						<td>Gender</td>
						<td>
							<form:radiobutton path="gender" value="male" checked="true" />
							Male<br>
							<form:radiobutton path="gender" value="female" />
							Female<br>
							<form:radiobutton path="gender" value="other" />
							Other
						</td>
					</tr>

					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr>
						<td>Daliy Status</td>
						<td>
							<form:input placeholder="Daliy Status" style="color:black" path="daily_status" />
						</td>
					</tr>
					<tr>
						<td>Native Place</td>
						<td>
							<form:input placeholder="city name" style="color:black" path="native_place" />
						</td>
					</tr>
					<tr>
						<td>Live In</td>
						<td>
							<form:input placeholder="current city name" style="color:black" path="live_in" />
						</td>
					</tr>
					<tr>
						<td>country</td>
						<td>
							<form:input placeholder="country" style="color:black" path="country" />
						</td>
					</tr>
					<tr>
						<td>Relationship</td>
						<td>
							<form:input placeholder="relationship status" style="color:black" path="relationship" />
						</td>
					</tr>
					<tr>
						<td>PostGraduation</td>
						<td>
							<form:input placeholder="college name" style="color:black" path="post_graduration" />
						</td>
					</tr>
					<tr>
						<td>Graduation</td>
						<td>
							<form:input placeholder="college name" style="color:black" path="graduration" />
						</td>
					</tr>
					<tr>
						<td>Secondary School</td>
						<td>
							<form:input type="text" placeholder="school name" style="color:black" path="secondary_school" />
						</td>
					</tr>
					<tr>
						<td>High School</td>
						<td>
							<form:input type="text" placeholder="school name" style="color:black" path="high_school" />
						</td>
					</tr>
					<tr>
						<td>Work Place</td>
						<td>
							<form:input placeholder="company name" style="color:black" path="work_place" />
						</td>
					</tr>
					<tr>
						<td>Work Experience</td>
						<td>
							<form:input placeholder="experience of work" style="color:black" path="work_experience" />
						</td>
					</tr>
					<tr>
						<td>Skill</td>
						<td>
							<form:input placeholder="skill or talent" style="color:black" path="skill" />
						</td>
					</tr>
				</table>
				<button class="btn_setting success">Submit</button>
			</center>
		</form:form>



		<p class="header_information">
			<b>Advance information</b>
		</p>

		<br />
		<form:form name="Advance_information" action="basicInformation" method="post" modelAttribute="profileSetting">
		<form:hidden path="id" />
			<p style="color: red">*(Note if you select Hidden option than Data of that field is not visible to others )</p>
			<br />
			<center>
				<table>
					<tr>
						<td>Birth-Place</td>
						<td>
							<form:input placeholder="city or village name" style="color:black" path="birth_place" />
						</td>
					</tr>
					<tr>
						<td>religious_Views</td>
						<td>
							<form:input placeholder="religion" style="color:black" path="religious_view" />
						</td>
					</tr>
					<tr>
						<td>paytm</td>
						<td>
							<form:input placeholder="paytm number" style="color:black" path="paytm" />
						</td>
						</td>
						<td>
							<form:checkbox path="paytm_flage" value="true" />
							Hidden
						</td>
					</tr>
				</table>

				<br /> <br />
				<table>
					<tr>
						<td>Address</td>
						<td>
							<form:textarea rows="4" cols="50" placeholder="Describe your local address,city,pincode here..." style="color:black" path="address"></form:textarea>
						</td>
						<td>
							<form:checkbox path="address_flage" value="true" />
							Hidden
						</td>
					</tr>
					<tr>
						<td>Hobbies</td>
						<td>
							<form:textarea rows="4" cols="50" placeholder="Describe yourself here..." style="color:black" path="hobbies"></form:textarea>
						</td>
					</tr>
					<tr>
						<td>Favourite-Food</td>
						<td>
							<form:textarea rows="4" cols="50" placeholder="Describe yourself here..." style="color:black" path="favourite_food"></form:textarea>
						</td>
					</tr>
					<tr>
						<td>Favourite-Singer</td>
						<td>
							<form:textarea rows="4" cols="50" placeholder="Describe yourself here..." style="color:black" path="favourite_singer"></form:textarea>
						</td>
					</tr>
					<tr>
						<td>Favourite-Movies</td>
						<td>
							<form:textarea rows="4" cols="50" placeholder="Describe yourself here..." style="color:black" path="favourite_movies"></form:textarea>
						</td>
					</tr>
					<tr>
						<td>Favourite-Daily-Soap</td>
						<td>
							<form:textarea rows="4" cols="50" placeholder="Describe yourself here..." style="color:black" path="favourite_daily_soap"></form:textarea>
						</td>
					</tr>
					<tr>
						<td>Favourite-Author</td>
						<td>
							<form:textarea rows="4" cols="50" placeholder="Describe yourself here..." style="color:black" path="favourite_author"></form:textarea>
						</td>
					</tr>
				</table>
				<button class="btn_setting success">Submit</button>
			</center>
		</form:form>



	</div>




</div>