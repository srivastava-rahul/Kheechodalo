package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.click.entity.Winner;
import com.click.service.WinnerService;

@Controller
@RequestMapping(value = "/user")
public class WinnerController {
	
	@Autowired
	WinnerService winnerService; 

	private static final Logger LOG = Logger.getLogger(WinnerController.class);
	
	@RequestMapping(value = "/winner")
	protected String getWinners(Model model) throws Exception {
		LOG.info("Fetching winner page from  getWinners controller");
		List<Winner> winnerList = winnerService.getAllWinner();
		model.addAttribute("winnerList", winnerList);
		return "winner";
	}

	
	
	
}
