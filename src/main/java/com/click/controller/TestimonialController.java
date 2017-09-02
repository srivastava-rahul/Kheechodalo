package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.click.entity.UserTestimonial;
import com.click.service.TestimonialService;

@Controller
@RequestMapping(value = "/user")
public class TestimonialController {
	
	
	@Autowired
	TestimonialService gettestimonial;

	private static final Logger LOG = Logger.getLogger(TestimonialController.class);
	
	/*@RequestMapping(value = "/testimonials")
	protected String getAllTestimonial(Model model) throws Exception {
		LOG.info("Fetchig testimonial page from getAllTestimonial controller");
		List<UserTestimonial>  listoftestimonial=gettestimonial.gettestimonial();
		 model.addAttribute("testimonial",listoftestimonial);
		return "testimonials";
	}*/
	
	
	/**
	 * Get All testimonial 
	 * @param model
	 * @return to testimonials page
	 * @throws Exception if data does not exist
	 */
	@RequestMapping(value = "/testimonials")
	protected String getAllTestimonial(Model model) throws Exception {
		LOG.info("Fetchig testimonial page from getAllTestimonial controller");
		List<UserTestimonial>  listoftestimonial=gettestimonial.gettestimonial(1);
		 model.addAttribute("testimonial",listoftestimonial);
		return "testimonials";
	}
	
	/**
	 * Get All testimonial page by page
	 * @param pageNo
	 * @param model
	 * @return to testimonials page
	 * @throws Exception if data does not exist
	 */
	@RequestMapping(value = "/testimonialsPagination/{page}")
	protected String getAllTestimonialPagination(@PathVariable("page") int pageNo, Model model) throws Exception {
		LOG.info("Fetchig testimonial page from getAllWinnersPagination() controller");
		List<UserTestimonial>  listoftestimonial=gettestimonial.gettestimonial(pageNo);
		model.addAttribute("testimonial",listoftestimonial);
		int rem = pageNo % 4;
		rem = 4 - rem;
		if (rem != 0) {
			pageNo = pageNo + rem;
		}
		model.addAttribute("pageNo", pageNo);
		return "testimonials";
	}
}
