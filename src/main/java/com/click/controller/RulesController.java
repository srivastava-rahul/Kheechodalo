package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class RulesController {
	
	private static final Logger LOG = Logger.getLogger(RulesController.class);

	@RequestMapping(value = "/rules")
	protected String getAllRules(Model model) throws Exception {
		LOG.info("Fetching  rules page from getAllRules controller");
		return "rules";
	}
	
	
	
}
