package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.click.entity.UserPrize;
import com.click.service.PrizeService;

@Controller
@RequestMapping(value = "/user")
public class PrizesController {

	private static final Logger LOG = Logger.getLogger(PrizesController.class);
	
	@Autowired
	PrizeService prizeService;

	/**
	 * Fetching the prize page for user
	 * @param model
	 * @return to prize list to prize page to user dashboard 
	 * @throws Exception if page does not exist
	 */
	@RequestMapping(value = "/prizes")
	protected String getPrizeRecord(Model model) throws Exception {
		LOG.info("Fetching the prize information from getPrizeRecord controller ");
		try {
			List<UserPrize> userPrize = prizeService.getAllPrizeRecord();
			model.addAttribute("prize",userPrize);
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return "prizes";
	}

}
