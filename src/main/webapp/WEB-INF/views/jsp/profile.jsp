<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
<div class="body-area">


         
				<%-- <div>
				  <img src="${pageContext.request.contextPath}/resources/images/itg.jpg" alt="Avatar" class="page_pic">
				 </div> --%>
				 
				  <div>
		                 
		<c:if test="${not empty picImg}">
				<img id="picImageHolder" src="data:image/jpeg;base64,${picImg}" alt="Picture"  class="page_pic"  data-tooltip="Click Here"     />
			</c:if>
			<c:if test="${empty picImg}">
			<img src="${pageContext.request.contextPath}/resources/images/profileupload.png" alt="Avatar" class="page_pic" data-tooltip="Click here">
			</c:if>
	
	</div>
				 <h1><a href="${pageContext.request.contextPath}/user/dashboard"  style="margin-top:10%;color:red "><span><img src="${pageContext.request.contextPath}/resources/images/download.jpg" style="margin-top: 1%; background-color: transparent;" src="arrow.gif" width="5%" height="4%"/>&nbsp;BACK</span></a></h1>
				 
			    <div class="information">
				     <p class="header_information"><b>Basic information</b></p>
				   
				   
				   <br/><br/>
				   <div style="margin-left:20%;">
				   
				   <fmt:formatDate value="${profileSetting.dob}" pattern="dd/MMM/yyyy"
						var="myValue" />
				   <table>
				   <tr><td>Name</td><td>${profileSetting.name_surname} </p></td></tr>
				   <tr><td>Birth-Date</td><td>${myValue}</td></tr>
				   <tr><td>email_id</td><td>${profileSetting.email_id}</td></tr>
				   <tr><td>phone</td><td>${profileSetting.phone}</td></tr>
				   <tr><td>Gender</td><td>${profileSetting.gender}</td></tr>
										  
				   <tr><td>Daily-Status</td><td>${profileSetting.daily_status}</td></tr>
				   <tr><td>Native-Place</td><td>${profileSetting.native_place}</td></tr>
				   <tr><td>Current-City</td><td>${profileSetting.live_in}</td></tr>
				   <tr><td>Country</td><td>${profileSetting.country}</td></tr>
				   
				   <tr><td>Relationship</td><td>${profileSetting.relationship}</td></tr>
				   <tr><td>PostGraduation</td><td>${profileSetting.post_graduration}</td></tr>
				   <tr><td>Graduation</td><td>${profileSetting.graduration}</td></tr>
				   <tr><td>Secondary School</td><td>${profileSetting.secondary_school}</td></tr>
				   <tr><td>High School</td><td>${profileSetting.high_school}</td></tr>
				  
				   <tr><td>Work Place</td><td>${profileSetting.work_place}</td></tr>
				   <tr><td>Work Experience</td><td>${profileSetting.work_experience}</td></tr>
				   <tr><td>Skill</td><td>${profileSetting.skill}</td></tr>
				   
				   </table>
				    </div>
				
				   <br/><br/>click here
		       <img src="${pageContext.request.contextPath}/resources/images/animatedArrow.gif" width="3%"height="3%" />
			   <button class="accordion"><b>Advance information</b></button>
				 
				 
				  <div class="pannel">
 
                  
				   <br/><br/>
				
				   <table>
				   <tr><td>Birth-Place</td><td>${profileSetting.birth_place}</td></tr>
				   <tr><td>religious_Views</td><td>${profileSetting.religious_view}</td></tr>
				   <%-- <tr><td>address</td><td>${profileSetting.paytm}</td></tr> --%>
				   <tr><td>paytm</td><td>${profileSetting.paytm}</td></tr>
				   </table>
				     </center>
				     
					 <br/><br/>
				   <table>
				   <tr><td>Address</td><td>${profileSetting.address}</td></tr>
				   <tr><td>Hobbies</td><td>${profileSetting.hobbies}</td></tr>
				   <tr><td>Favourite-Food</td><td>${profileSetting.favourite_food}</td></tr>
				   <tr><td>Favourite-Singer</td><td>${profileSetting.favourite_singer}</td></tr>
				   <tr><td>Favourite-Movies</td><td>${profileSetting.favourite_movies}</td></tr>
				   <tr><td>Favourite-Daily-Soap</td><td>${profileSetting.favourite_daily_soap}</td></tr>
				   <tr><td>Favourite-Daily-Soap</td><td>${profileSetting.favourite_author}</td></tr>
				   </table>
				  	
					
	             
	
	             </div>
	

				  <script>
							var acc = document.getElementsByClassName("accordion");
						var i;

						for (i = 0; i < acc.length; i++) {
							acc[i].onclick = function(){
								this.classList.toggle("active");
								var panel = this.nextElementSibling;
								if (panel.style.display === "block") {
									panel.style.display = "none";
								} else {
									panel.style.display = "block";
								}
							}
						}
						</script>

							
				  </div>			
			 </div>
				 
				 
   
	</div>