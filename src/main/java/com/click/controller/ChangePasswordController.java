package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class ChangePasswordController {

	private static final Logger LOG = Logger.getLogger(ChangePasswordController.class);
	
	
	/**
	 * fetching the form for change password
	 * @param model
	 * @return to changePassword page
	 * @throws Exception throw error if page does not exist
	 */
	@RequestMapping(value = "/changePassword")
	protected String getChangePassword(Model model) throws Exception {
		LOG.info("Fetching Change Password  form getChangePassword controller");
		return "changePassword";
	}

	
}
