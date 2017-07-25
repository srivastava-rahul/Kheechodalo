package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class SearchController {

	private static final Logger LOG = Logger.getLogger(SearchController.class);
	
	
	@RequestMapping(value = "/search", method = { RequestMethod.POST})
	protected String getSearchPage(Model model) throws Exception {
		LOG.info("Fetching search page from getSearchPage  controller");
		return "searchpage";
	}

	
}
