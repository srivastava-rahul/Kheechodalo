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
				   
				   <form name="Basic_information">
				    <br/>
				  <p style="color:red"> *(Note if you select Hidden option than Data of that field is not visible to others )</p>
				   <br/>
				   <center>
				   <table>
				   <tr><td>Name</td><td><input type="text" placeholder="Name    Surname"/></td></tr>
				   <tr><td>email_id</td><td><input type="text"placeholder="email address"/></td></tr>
				   <tr><td>phone</td><td><input type="text"placeholder="mobile number"/></td><td><input type="checkbox" name="phone_hidden" value="true"/>Hidden</td></tr>
				   <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
				   <tr><td>Gender</td><td><input type="radio" name="gender" value="male" checked> Male<br>
                                          <input type="radio" name="gender" value="female"> Female<br>
                                          <input type="radio" name="gender" value="other"> Other </td></tr>
										  
				   <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>					  
				   <tr><td>From</td><td><input type="text"placeholder="city name"/></td></tr>
				   <tr><td>Live In</td><td><input type="text" placeholder="curren city name"/></td></tr>
				   <tr><td>country</td><td><input type="text"placeholder="country"/></td></tr>
				   <tr><td>Relationship</td><td><input type="text"placeholder="relationship status"/></td><td><input type="checkbox" name="relationship_hidden" value="true">Hidden</td></tr>
				   <tr><td>PostGraduation</td><td><input type="text" placeholder="college name"/></td></tr>
				   <tr><td>Graduation</td><td><input type="text" placeholder="college name"/></td></tr>
				   <tr><td>Secondary School</td><td><input type="text"placeholder="school name"/></td></tr>
				   <tr><td>High School</td><td><input type="text" placeholder="school name"/></td></tr>
				   
				  
				   
				   
				   <tr><td>Work Place</td><td><input type="text" placeholder="company name"/></td></tr>
				   <tr><td>Work Experience</td><td><input type="text" placeholder="experience of work"/></td></tr>
				   <tr><td>Skill</td><td><input type="text"placeholder="skill or talent"/></td></tr>
				   </table>
				     <button class="btn_setting success">Submit</button>
				     </center>
				   </form>
				   
				
				   
			   <p class="header_information"><b>Advance information</b></p>
				 
				   <br/>
				  <form name="Advance_information"> 
				  
				  <p style="color:red"> *(Note if you select Hidden option than Data of that field is not visible to others )</p>
				  <br/>
				  <center>
				   <table>
				   <tr><td>Birth-Place</td><td><input type="text"placeholder="city or village name"/></td></tr>
				   <tr><td>religious_Views</td><td><input type="text"placeholder="religion"/></td></tr>
				   <tr><td>address</td><td><input type="text"placeholder="local address,city,pincode"/></td></td><td><input type="checkbox" name="address_hidden" value="true">Hidden</td></tr>
				   <tr><td>paytm</td><td><input type="text"placeholder="paytm number"/></td></td><td><input type="checkbox" name="paytm_hidden" value="true">Hidden </td></tr>
				   </table>
				     
					 <br/><br/>
				   <table>
				   <tr><td>Hobbies</td><td><textarea rows="4" cols="50" placeholder="Describe yourself here..."></textarea></td></tr>
				   <tr><td>Favourite-Food</td><td><textarea rows="4" cols="50" placeholder="Describe yourself here..."></textarea></td></tr>
				   <tr><td>Favourite-Singer</td><td><textarea rows="4" cols="50" placeholder="Describe yourself here..."></textarea></td></tr>
				   <tr><td>Favourite-Movies</td><td><textarea  rows="4" cols="50" placeholder="Describe yourself here..."></textarea></td></tr>
				   <tr><td>Favourite-Daily-Soap</td><td><textarea  rows="4" cols="50" placeholder="Describe yourself here..."></textarea></td></tr>
				   </table>
				  	  <button class="btn_setting success">Submit</button>
				    </center>	  
	              </form>
	
	 
							
				  </div>			
			
				 
				 
   
	</div>