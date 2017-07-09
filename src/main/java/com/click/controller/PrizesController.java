package com.click.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.click.entity.UserPrize;
import com.click.service.PrizeService;

@Controller
@RequestMapping(value = "/user")
public class PrizesController {

	@Autowired
	PrizeService prizeService;

	@RequestMapping(value = "/prizes")
	protected String getPrizeRecord(Model model) throws Exception {
		System.out.println("In user getPrizeRecord controller");
		try {
			List<UserPrize> userPrize = prizeService.getAllPrizeRecord();
			model.addAttribute("prize",userPrize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "prizes";
	}

}
