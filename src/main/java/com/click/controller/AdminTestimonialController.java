package com.click.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.click.entity.PicUploadData;
import com.click.entity.PictureUpload;
import com.click.entity.UserTestimonial;
import com.click.service.TestimonialService;
import com.click.service.UserService;
import com.click.utils.SecurityLibrary;

@Controller
@RequestMapping(value = "/admin")
public class AdminTestimonialController {
	

	private static final Logger LOG = Logger.getLogger(AdminTestimonialController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	TestimonialService testimonialService;  
			 
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value = "/admingetTestimonial")
	protected String getTestimonialInfo(Model model) throws Exception {
		LOG.info("Admin getting list of Testimonial data from getTestimonialInfo controller");
		try {
			 List<UserTestimonial>  listoftestimonial = testimonialService.gettestimonial();
			 model.addAttribute("testimonial",listoftestimonial);
		   } catch (Exception e) {
			   LOG.error(e.getMessage(),e);
				e.printStackTrace();
		}
		
		return "adminsendtestimonial";
	}
	
	@RequestMapping(value = "/admindeletetestimonial/{id}")
	protected String deleteTesrimonialInfo(@PathVariable(name ="id")  String id,Model model) throws Exception {
		LOG.info("Admin removing Testimonial  data based on id from deleteTesrimonialInfo controller");
		try {
			UserTestimonial testimonialdata=new UserTestimonial();
			testimonialdata.setId(id);
			testimonialService.deletetestimonial(testimonialdata);
		 model.addAttribute("success", " Data Entered Successfully .");
		 return "redirect:/admin/admingetTestimonial";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While deleting Data .");
			 return "redirect:/admin/admingetTestimonial";
		}
	}
	
	@RequestMapping(value = "/savetestimonialPic", method = RequestMethod.POST)
	public String uploadprDocuments(@RequestParam("picImg") MultipartFile file, @RequestParam("desc") String desc, @RequestParam("name") String name, @RequestParam("email") String email,Model model) {
		LOG.info(" Inside uploadprDocuments controller save pic called");
		String fileName = null;
		HttpHeaders headers = new HttpHeaders();
		if (!file.isEmpty()) {
			try {
				fileName = file.getOriginalFilename();
				LOG.debug("file name :" + fileName);
				byte[] bytes = file.getBytes();
				UserTestimonial testimonialdata=new UserTestimonial();
				testimonialdata.setFileData(bytes);
				testimonialdata.setTestimonial_desc(desc);
				testimonialdata.setName(name);
				testimonialdata.setCreatedDate(new Date());
				if(email==null){
					testimonialdata.setEmail_id("Not Know");
				}else{
					testimonialdata.setEmail_id(email);
				}
				testimonialService.savetestimonial(testimonialdata);
				LOG.debug("uploaded");
				model.addAttribute("success", " Data Entered Successfully .");
				
				 return "redirect:/admin/admingetTestimonial";
				
			} catch (Exception e) {
				LOG.error(e.getMessage(),e);
				e.printStackTrace();
				model.addAttribute("error", "Something went wrong .");
				 return "redirect:/admin/admingetTestimonial";
			}
		} else {
			 return "redirect:/admin/admingetTestimonial";
		}
	}


	
}
