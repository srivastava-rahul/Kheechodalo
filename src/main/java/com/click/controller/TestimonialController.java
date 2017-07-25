package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class TestimonialController {

	private static final Logger LOG = Logger.getLogger(TestimonialController.class);
	
	@RequestMapping(value = "/testimonials")
	protected String getAllTestimonial(Model model) throws Exception {
		LOG.info("Fetchig testimonial page from getAllTestimonial controller");
		return "testimonials";
	}
}
