package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class MyOwnPicController {

	private static final Logger LOG = Logger.getLogger(MyOwnPicController.class);
	
	/**
	 * Getting myownpic page
	 * @param model
	 * @return to 
	 * @throws Exception
	 */
	@RequestMapping(value = "/myownpic")
	protected String getmyownpic(Model model) throws Exception {
		LOG.info("Fetching own pic page  from getAboutUs controller");
		return "myownpic";
	}

	
}
