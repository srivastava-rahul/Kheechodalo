package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.click.entity.UserTestimonial;
import com.click.service.TestimonialService;

@Controller
@RequestMapping(value = "/user")
public class TestimonialController {
	
	
	@Autowired
	TestimonialService gettestimonial;

	private static final Logger LOG = Logger.getLogger(TestimonialController.class);
	
	@RequestMapping(value = "/testimonials")
	protected String getAllTestimonial(Model model) throws Exception {
		LOG.info("Fetchig testimonial page from getAllTestimonial controller");
		List<UserTestimonial>  listoftestimonial=gettestimonial.gettestimonial();
		 model.addAttribute("testimonial",listoftestimonial);
		return "testimonials";
	}
}
