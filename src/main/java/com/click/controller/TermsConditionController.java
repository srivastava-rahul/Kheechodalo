package com.click.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class TermsConditionController {

	@RequestMapping(value = "/termsandcondition")
	protected String getTermAndCondition(Model model) throws Exception {
		System.out.println("In termsandcondition controller");
		return "termsandcondition";
	}
	
	
	
}
