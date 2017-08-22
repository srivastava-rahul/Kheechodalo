package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.click.entity.Winner;
import com.click.service.WinnerService;

@Controller
public class LoginController {

	private static final Logger LOG = Logger.getLogger(LoginController.class);

	@Autowired
	WinnerService winnerService;

	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	protected String showLogin(Model model) {
		LOG.info("Login called  from  showLogin controller");

		try {
			Winner winner = winnerService.getLastWinner();
			model.addAttribute("winner", winner);
		} catch (Exception e) {
			LOG.error("Error while fetching winner pic for login :" + e.getMessage(), e);
		}

		return "WEB-INF/views/jsp/login";
	}
}
