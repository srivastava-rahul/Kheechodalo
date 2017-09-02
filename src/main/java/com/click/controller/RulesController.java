package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class RulesController {
	
	private static final Logger LOG = Logger.getLogger(RulesController.class);

	/**
	 * Fetching the rule page for user dashboard page footer
	 * @param model
	 * @return to rule page to user dashboard footer
	 * @throws Exception if page does not exist
	 */
	@RequestMapping(value = "/rules")
	protected String getAllRules(Model model) throws Exception {
		LOG.info("Fetching  rules page from getAllRules controller");
		return "rules";
	}
	
	
	
}
