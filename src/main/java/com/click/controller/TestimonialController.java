package com.click.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class TestimonialController {

	@RequestMapping(value = "/testimonials")
	protected String getAllRules(Model model) throws Exception {
		System.out.println("In user rules controller");
		return "testimonials";
	}
}
