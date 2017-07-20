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
@RequestMapping(value = "/user")
public class AdminWinnerController {
	

	private static final Logger LOG = Logger.getLogger(QuickHelpController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	WinnerService winnerService;  
			 
	
	@RequestMapping(value = "/admingetwinner")
	protected String getWinnerInfo(Model model) throws Exception {
		System.out.println("Admin getting list of Winner controller");
		try {
			
			 List<Winner>  listofWinner = winnerService.getWinner();			
			 model.addAttribute("winner",listofWinner);
		   } catch (Exception e) {
			e.printStackTrace();
		}
		
		return "adminViewWinner";
	}
	
	@RequestMapping(value = "/admindeletewinner")
	protected String deleteNotificationInfo(@RequestParam String id,Model model) throws Exception {
		System.out.println("Admin removing notification based on id controller");
		try {
			 Winner  winnerdata=new Winner();
			 winnerdata.setId(id);
			 winnerService.deleteWinner(winnerdata);  
			 
			 List<Winner>  listofWinner = winnerService.getWinner();			
			 model.addAttribute("winner",listofWinner);
			 model.addAttribute("success", " Data Deleted Successfully .");
			return "adminViewWinner";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While deleting Data .");
			return "adminViewWinner";
		}
	}
}
