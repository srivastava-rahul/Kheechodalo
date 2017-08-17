package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	protected String getWinnerInfobyAdmin(Model model) throws Exception {
		LOG.info("Admin getting list of Winner from getWinnerInfobyAdmin() controller");
		try {
			 List<Winner>  listofWinner = winnerService.getAllWinnerbyadmin();			
			 model.addAttribute("winner",listofWinner);
		   } catch (Exception e) {
			   LOG.error(e.getMessage(),e);
				e.printStackTrace();
		}
		return "adminViewWinner";
	}
	
	@RequestMapping(value = "/admindeletewinner/{id}")
	protected String deleteWinnerInfo(@PathVariable(name ="id")  String id,Model model) throws Exception {
		LOG.info("Admin removing notification based on id from deleteWinnerInfo controller");
		try {
			 Winner  winnerdata=new Winner();
			 winnerdata.setId(id);
			 winnerService.deleteWinner(winnerdata); 
			 model.addAttribute("success", " Data Deleted Successfully .");
			 return "redirect:/admin/admingetwinner";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While deleting Data .");
			return "redirect:/admin/admingetwinner";
		}
	}
}
