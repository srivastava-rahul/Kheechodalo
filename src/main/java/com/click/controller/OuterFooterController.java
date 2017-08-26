package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class OuterFooterController {
	
	private static final Logger LOG = Logger.getLogger(OuterFooterController.class);
	 
			 
	@RequestMapping(value = "/rulesouter")
	protected String getRuleOuter(Model model) throws Exception {
		LOG.info("Fetching rule page from getRuleOuter controller ");
		return "rulesouter";
	}
	
	
	@RequestMapping(value = "/contactusOuter")
	protected String getcontactusOuter(Model model) throws Exception {
		LOG.info("Fetching  contactus page from getcontactusOuter controller");
		return "contactusOuter";
	}
	
	@RequestMapping(value = "/termsConditionOuter")
	protected String gettermsConditionOuter(Model model) throws Exception {
		LOG.info("Fetching  terms  And Condition page  from  gettermsConditionOuter controller");
		return "termsConditionOuter";
	}	
	
	
	@RequestMapping(value = "/signupdataOuter")
	protected String getsignupdataOuter(Model model) throws Exception {
		LOG.info("Fetching sign-up  data page from getsignupdataOuter() controller");
		return "signupdataOuter";
	}
	
	@RequestMapping(value = "/privacyOuter")
	protected String getPrivacyOuter(Model model) throws Exception {
		LOG.info("Fetching Privacy page from getPrivacyOuter() controller");
		return "privacyOuter";
	}
	
	@RequestMapping(value = "/aboutusOuter")
	protected String getAboutusOuter(Model model) throws Exception {
		LOG.info("Fetching Privacy page from getAboutusOuter() controller");
		return "aboutusOuter";
	}
	
}
