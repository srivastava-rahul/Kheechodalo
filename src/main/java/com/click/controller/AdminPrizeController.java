package com.click.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.UserPrize;
import com.click.service.PrizeService;
import com.click.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminPrizeController {
	

	private static final Logger LOG = Logger.getLogger(AdminPrizeController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	PrizeService prizeService;  
	
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, true));
	}

	
	
	/**
	 * Admin Save  prize
	 * @param createddate
	 * @param prizevalue
	 * @param sponsorby
	 * @param model
	 * @return to admingetAllPrize page
	 * @throws Exception throw data does not exist
	 */
	@RequestMapping(value = "/adminsaveprize", method = RequestMethod.POST)
	public String savePrizebyAdmin(@RequestParam Date createddate,@RequestParam String prizevalue,@RequestParam String sponsorby, Model model)
			throws Exception {
		LOG.info("Admin adding prize from savePrizebyAdmin() controller");
		try {
			System.out.println("rahul============>>>>"+createddate+""+prizevalue+"sponsorby");
			UserPrize prizedata=new UserPrize();
			prizedata.setPrizeDate(createddate);			
			prizedata.setPrizeAmount(prizevalue);
			prizedata.setSponsor(sponsorby);
			prizeService.savePrizeRecord(prizedata);
			model.addAttribute("success", " Data Entered Successfully .");
			return "redirect:/admin/admingetAllPrize";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While Sending Data .");
			return "redirect:/admin/admingetAllPrize";
		}
	}

	/**
	 * Get all the prize information
	 * @param model
	 * @return to adminsendprize page
	 * @throws Exception throw data does not exist
	 */
	@RequestMapping(value = "/admingetAllPrize")
	protected String getAllprizeInfo(Model model) throws Exception {
		LOG.info("Admin getting list of prize from getNotificationInfo controller");
		try {
			List<UserPrize>  listofprize=prizeService.getAllPrizeRecord();
			model.addAttribute("prize",listofprize);
		   } catch (Exception e) {
			   LOG.error(e.getMessage(),e);
				e.printStackTrace();
		}
		
		return "adminsendprize";
	}
	
	/**
	 * Delete the prize information by admin based on id
	 * @param id
	 * @param model
	 * @return to admingetAllPrize page
	 * @throws Exception throw data does not exist
	 */
	@RequestMapping(value = "/admindeleteprize/{id}")
	protected String deleteprizeInfo(@PathVariable(name ="id") String id,Model model) throws Exception {
		LOG.info("Admin removing prize based on id from deleteNotificationInfo controller"+id);
		
		try {
			UserPrize prizedata=new UserPrize();
			prizedata.setId(id);
			prizeService.deletePrizeRecord(prizedata);
			model.addAttribute("success", " Data Deleted Successfully .");
			return "redirect:/admin/admingetAllPrize";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While deleting Data .");
			return "redirect:/admin/admingetAllPrize";
		}
	}
}
