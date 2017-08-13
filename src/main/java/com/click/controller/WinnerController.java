package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	protected String getAllWinners(Model model) throws Exception {
		LOG.info("Fetching winner page from  getWinners controller");
		List<Winner> winnerList = winnerService.getAllWinner(1);
		model.addAttribute("winnerList", winnerList);
		return "winner";
	}

	@RequestMapping(value = "/winnerPagination/{page}")
	protected String getAllWinnersPagination(@PathVariable("page") int pageNo, Model model) throws Exception {
		LOG.info(" LOG User Dashboard from getAllWinnersPagination controller");
		List<Winner> winnerList = winnerService.getAllWinner(pageNo);
		model.addAttribute("winnerList", winnerList);
		int rem = pageNo % 4;
		rem = 4 - rem;
		if (rem != 0) {
			pageNo = pageNo + rem;
		}
		model.addAttribute("pageNo", pageNo);
		return "winner";
	}

}
