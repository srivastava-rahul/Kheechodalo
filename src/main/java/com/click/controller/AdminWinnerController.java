package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
			 
	
	/**
	 * Admin Fetching the winner information
	 * @param model
	 * @return to adminViewWinner page
	 * @throws Exception throw exception if winner does not exist
	 */
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
	
	/**
	 * Winner information deleted by Admin  based on pi id
	 * @param id
	 * @param model
	 * @return to admingetwinner page
	 * @throws Exception  throw if pic id does not exist 
	 */
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
