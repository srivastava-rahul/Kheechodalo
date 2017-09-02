package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class PrivacyController {
	
	private static final Logger LOG = Logger.getLogger(PrivacyController.class);

	/**
	 * Fetching the privacy page for user dashboard page footer
	 * @param model
	 * @return to privacy page to user dashboard footer
	 * @throws Exception if page does not exist
	 */
	@RequestMapping(value = "/privacy")
	protected String getPrivacy(Model model) throws Exception {
		LOG.info("Fetching Privacy page from getPrivacy() controller");
		return "privacy";
	}
	
	
	
}
