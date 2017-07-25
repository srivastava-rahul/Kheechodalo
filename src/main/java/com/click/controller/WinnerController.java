package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class WinnerController {

	private static final Logger LOG = Logger.getLogger(WinnerController.class);
	
	@RequestMapping(value = "/winner")
	protected String getWinners(Model model) throws Exception {
		LOG.info("Fetching winner page from  getWinners controller");
		return "winner";
	}

	
}
