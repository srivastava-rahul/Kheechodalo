package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.UserPrize;
import com.click.service.PrizeService;
import com.click.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class AdminPrizeController {
	

	private static final Logger LOG = Logger.getLogger(QuickHelpController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	PrizeService prizeService;  
	
	
	@RequestMapping(value = "/adminsaveprize", method = RequestMethod.POST)
	public String saveNotificationData(@RequestParam UserPrize prize , Model model)
			throws Exception {
		LOG.info("Admin adding prize controller");
		try {
			LOG.info("Notification :- " + prize);
			/*User userDetails = userService.findUserById(SecurityLibrary.getLoggedInUser().getEmailId());*/
			/*LOG.info("Admin Email - Id :" + userDetails.getEmailId());*/
			
			UserPrize prizedata=new UserPrize();
			prizedata.setPrizeDate(prize.getPrizeDate());			
			prizedata.setPrizeAmount(prize.getPrizeAmount());
			
			prizeService.savePrizeRecord(prizedata);
			List<UserPrize>  listofprize=prizeService.getAllPrizeRecord();
			model.addAttribute("prize",listofprize);
			 model.addAttribute("success", " Data Entered Successfully .");			
			return "adminsendprize";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While Sending Data .");
			return "adminsendprize";
		}
	}

	@RequestMapping(value = "/admingetAllPrize")
	protected String getNotificationInfo(Model model) throws Exception {
		System.out.println("Admin getting list of prize controller");
		try {
			List<UserPrize>  listofprize=prizeService.getAllPrizeRecord();
			model.addAttribute("prize",listofprize);
		   } catch (Exception e) {
			e.printStackTrace();
		}
		
		return "adminsendprize";
	}
	
	@RequestMapping(value = "/admindeleteprize")
	protected String deleteNotificationInfo(@RequestParam String id,Model model) throws Exception {
		System.out.println("Admin removing prize based on id controller");
		try {
			
			UserPrize prizedata=new UserPrize();
			prizedata.setId(id);
			prizeService.deletePrizeRecord(prizedata);
			
			List<UserPrize>  listofprize=prizeService.getAllPrizeRecord();
			 model.addAttribute("prize",listofprize);
			 model.addAttribute("success", " Data Deleted Successfully .");
			return "adminsendprize";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While deleting Data .");
			return "adminsendprize";
		}
	}
}
