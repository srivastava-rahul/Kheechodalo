package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.click.entity.UserTestimonial;
import com.click.service.TestimonialService;
import com.click.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminTestimonialController {
	

	private static final Logger LOG = Logger.getLogger(AdminTestimonialController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	TestimonialService testimonialService;  
			 
	
	@RequestMapping(value = "/adminsavetestimonial", method = RequestMethod.POST)
	public String savetestimonialData(@RequestParam UserTestimonial testimonial ,@RequestParam("picImg") MultipartFile uploadPic, Model model)
			throws Exception {
		LOG.info("Admin adding Testimonial information from savetestimonialData controller");
		try {
			
			/*User userDetails = userService.findUserById(SecurityLibrary.getLoggedInUser().getEmailId());
			LOG.info("Admin Email - Id :" + userDetails.getEmailId());*/
			
			UserTestimonial testimonialdata=new UserTestimonial();
			//testimonialdata.setEmail_id(userDetails.getEmailId());
			testimonialdata.setTestimonial_desc(testimonial.getTestimonial_desc());
			
			byte[] bytes = uploadPic.getBytes();
			testimonialdata.setFileData(bytes);
			testimonialService.savetestimonial(testimonialdata);;	
			
			 List<UserTestimonial>  listoftestimonial = testimonialService.gettestimonial();
			    /*byte[] encodeBase64 = Base64.encodeBase64(listoftestimonial.getFileData());
				String base64Encoded = new String(encodeBase64, "UTF-8");
				model.addAttribute("picImg", base64Encoded);*/
			 
			 model.addAttribute("testimonial",listoftestimonial);
			 model.addAttribute("success", " Data Entered Successfully .");			
			return "adminsendtestimonial";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While Sending Data .");
			return "adminsendtestimonial";
		}
	}

	@RequestMapping(value = "/admingetTestimonial")
	protected String getTestimonialInfo(Model model) throws Exception {
		LOG.info("Admin getting list of Testimonial data from getTestimonialInfo controller");
		try {
			 List<UserTestimonial>  listoftestimonial = testimonialService.gettestimonial();
			    /*byte[] encodeBase64 = Base64.encodeBase64(listoftestimonial.getFileData());
				String base64Encoded = new String(encodeBase64, "UTF-8");
				model.addAttribute("picImg", base64Encoded);*/
			 
			 model.addAttribute("testimonial",listoftestimonial);
		   } catch (Exception e) {
			   LOG.error(e.getMessage(),e);
				e.printStackTrace();
		}
		
		return "adminsendtestimonial";
	}
	
	@RequestMapping(value = "/admindeletetestimonial")
	protected String deleteTesrimonialInfo(@RequestParam String id,Model model) throws Exception {
		LOG.info("Admin removing Testimonial  data based on id from deleteTesrimonialInfo controller");
		try {
			UserTestimonial testimonialdata=new UserTestimonial();
			testimonialdata.setId(id);
			testimonialService.deletetestimonial(testimonialdata);
			List<UserTestimonial>  listoftestimonial = testimonialService.gettestimonial();
		    /*byte[] encodeBase64 = Base64.encodeBase64(listoftestimonial.getFileData());
			String base64Encoded = new String(encodeBase64, "UTF-8");
			model.addAttribute("picImg", base64Encoded);*/
		 model.addAttribute("testimonial",listoftestimonial);
		 model.addAttribute("success", " Data Entered Successfully .");
			return "adminsendtestimonial";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While deleting Data .");
			return "adminsendtestimonial";
		}
	}
	

	
}
