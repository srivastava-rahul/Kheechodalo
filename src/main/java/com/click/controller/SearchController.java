package com.click.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class SearchController {

	
	//@RequestMapping(value = "/search")
	@RequestMapping(value = "/search", method = { RequestMethod.POST})
	protected String getAboutUs(Model model) throws Exception {
		System.out.println("In user search controller");
		return "searchpage";
	}

	
}
