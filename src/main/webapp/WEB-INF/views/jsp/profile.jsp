<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
<div class="body-area">


         
				<div>
				  <img src="${pageContext.request.contextPath}/resources/images/itg.jpg" alt="Avatar" class="page_pic">
				 </div>
				 
				 
			    <div class="information">
				     <p class="header_information"><b>Basic information</b></p>
				   
				   
				   <br/><br/>
				   <div style="margin-left:20%;">
				   <table>
				   <tr><td>Name</td><td></td></tr>
				   <tr><td>email_id</td><td></td></tr>
				   <tr><td>phone</td><td></td></tr>
				   
				   <tr><td>Gender</td><td></td></tr>
										  
				   
				   <tr><td>From</td><td></td></tr>
				   <tr><td>Live In</td><td></td></tr>
				   <tr><td>country</td><td></td></tr>
				   <tr><td>Relationship</td><td></td></tr>
				   <tr><td>PostGraduation</td><td></td></tr>
				   <tr><td>Graduation</td><td></tr>
				   <tr><td>Secondary School</td><td></td></tr>
				   <tr><td>High School</td><td></td></tr>
				   
				  
				   
				   
				   <tr><td>Work Place</td><td></td></tr>
				   <tr><td>Work Experience</td><td></td></tr>
				   <tr><td>Skill</td><td></td></tr>
				   </table>
				    </div>
				
				   <br/><br/>click here
		       <img src="${pageContext.request.contextPath}/resources/images/animatedArrow.gif" width="3%"height="3%" />
			   <button class="accordion"><b>Advance information</b></button>
				 
				 
				  <div class="pannel">
 
                  
				   <br/><br/>
				
				   <table>
				   <tr><td>Birth-Place</td><td></td></tr>
				   <tr><td>religious_Views</td><td></tr>
				   <tr><td>address</td><td></td></tr>
				   <tr><td>paytm</td><td></td></tr>
				   </table>
				     </center>
				     
					 <br/><br/>
				   <table>
				   <tr><td>Hobbies</td><td></td></tr>
				   <tr><td>Favourite-Food</td><td></td></tr>
				   <tr><td>Favourite-Singer</td><td></td></tr>
				   <tr><td>Favourite-Movies</td><td></td></tr>
				   <tr><td>Favourite-Daily-Soap</td></tr>
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