package com.click.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class PrizesController {

	
	@RequestMapping(value = "/prizes")
	protected String getAboutUs(Model model) throws Exception {
		System.out.println("In user aboutus controller");
		return "prizes";
	}

	
}
