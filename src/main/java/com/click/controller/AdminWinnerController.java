package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.Winner;
import com.click.service.UserService;
import com.click.service.WinnerService;

@Controller
@RequestMapping(value = "/admin")
public class AdminWinnerController {
	

	private static final Logger LOG = Logger.getLogger(AdminWinnerController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	WinnerService winnerService;  
			 
	
	@RequestMapping(value = "/admingetwinner")
	protected String getWinnerInfo(Model model) throws Exception {
		LOG.info("Admin getting list of Winner from getWinnerInfo controller");
		try {
			 List<Winner>  listofWinner = winnerService.getWinner();			
			 model.addAttribute("winner",listofWinner);
		   } catch (Exception e) {
			   LOG.error(e.getMessage(),e);
				e.printStackTrace();
		}
		return "adminViewWinner";
	}
	
	@RequestMapping(value = "/admindeletewinner")
	protected String deleteWinnerInfo(@RequestParam String id,Model model) throws Exception {
		LOG.info("Admin removing notification based on id from deleteWinnerInfo controller");
		try {
			 Winner  winnerdata=new Winner();
			 winnerdata.setId(id);
			 winnerService.deleteWinner(winnerdata); 
			 List<Winner>  listofWinner = winnerService.getWinner();			
			 model.addAttribute("winner",listofWinner);
			 model.addAttribute("success", " Data Deleted Successfully .");
			return "adminViewWinner";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While deleting Data .");
			return "adminViewWinner";
		}
	}
}
