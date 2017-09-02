package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class SignupDataController {
	
	private static final Logger LOG = Logger.getLogger(SignupDataController.class);

	/**
	 * Fetching the Sign up data page for user dashboard page footer
	 * @param model
	 * @return to signupdata page to user dashboard footer
	 * @throws Exception if page does not exist
	 */
	@RequestMapping(value = "/signupdata")
	protected String getsignupdata(Model model) throws Exception {
		LOG.info("Fetching sign-up  data page from getsignupdata() controller");
		return "signupdata";
	}
	
	
	
}
