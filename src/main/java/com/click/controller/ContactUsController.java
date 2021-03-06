package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class ContactUsController {

	private static final Logger LOG = Logger.getLogger(ContactUsController.class);
	
	/**
	 * fetching the contact information form
	 * @param model
	 * @return to contact us page
	 * @throws Exception throw  if page does not exist
	 */
	@RequestMapping(value = "/contactus")
	protected String getContactUs(Model model) throws Exception {
		LOG.info("Fetching Contact Us information from getContactUs controller");
		return "contactus";
	}

	
}
