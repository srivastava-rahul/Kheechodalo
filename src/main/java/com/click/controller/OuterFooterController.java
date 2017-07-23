package com.click.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class OuterFooterController {
	

	 
			 
	@RequestMapping(value = "/rulesouter")
	protected String getRuleOuter(Model model) throws Exception {
		System.out.println("In outer rule  controller");
		return "rulesouter";
	}
	
	
	@RequestMapping(value = "/contactusOuter")
	protected String getcontactusOuter(Model model) throws Exception {
		System.out.println("In outer contactus  controller");
		return "contactusOuter";
	}
	
	@RequestMapping(value = "/termsConditionOuter")
	protected String gettermsConditionOuter(Model model) throws Exception {
		System.out.println("In outer terms  And Condition  controller");
		return "termsConditionOuter";
	}
	
	
	

	
}
