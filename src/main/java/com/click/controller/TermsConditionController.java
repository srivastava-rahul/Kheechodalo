package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class TermsConditionController {
	
	private static final Logger LOG = Logger.getLogger(TermsConditionController.class);

	@RequestMapping(value = "/termsandcondition")
	protected String getTermAndCondition(Model model) throws Exception {
		LOG.info("Fetching terms and condition page from getTermAndCondition controller");
		return "termsandcondition";
	}
	
	
	
}
