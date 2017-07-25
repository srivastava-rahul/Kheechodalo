package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class AboutUsController {
	
	private static final Logger LOG = Logger.getLogger(AboutUsController.class);
			 
	@RequestMapping(value = "/aboutUs")
	protected String getAboutUs(Model model) throws Exception {
		LOG.info("Fetching AboutUs Page from getAboutUs Controller ");
		return "aboutUs";
	}

	
}
