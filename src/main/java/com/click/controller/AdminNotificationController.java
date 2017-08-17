package com.click.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.Notification;
import com.click.service.NotificationService;
import com.click.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminNotificationController {
	

	private static final Logger LOG = Logger.getLogger(AdminNotificationController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	NotificationService notificationService;  
			 
	
	@RequestMapping(value = "/adminsendnotification", method = RequestMethod.POST)
	public String saveNotificationData(@RequestParam String noty , Model model)
			throws Exception {
		LOG.info("Admin adding notification from saveNotificationData controller");
		try {
			 
			if(noty!=null && !noty.equals("")){
			Notification notify=new Notification();
			notify.setCreatedDate(new Date());
			notify.setNotification_desc(noty);
			notificationService.saveNotification(notify);	
			}
			 model.addAttribute("success", " Data Entered Successfully .");
			return "redirect:/admin/admingetnotification";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While Sending Data .");
			return "redirect:/admin/admingetnotification";
		}
	}

	@RequestMapping(value = "/admingetnotification")
	protected String getNotificationInfo(Model model) throws Exception {
		LOG.info("Admin getting list of notification from getNotificationInfo controller");
		try {
			 List<Notification>  listofNotification = notificationService.getNotification();			
			 model.addAttribute("notification",listofNotification);
		   } catch (Exception e) {
			   LOG.error(e.getMessage(),e);
				e.printStackTrace();
		}
		
		return "adminsendnotification";
	}
	
	@RequestMapping(value = "/admindeletenotification/{id}")
	protected String deleteNotificationInfo(@PathVariable(name ="id") String id,Model model) throws Exception {
		LOG.info("Admin removing notification based on id from deleteNotificationInfo controller");
		try {
			Notification notify=new Notification();
			 notify.setId(id);
			 notificationService.deleteNotification(notify);
			 model.addAttribute("success", " Data Deleted Successfully .");
			 return "redirect:/admin/admingetnotification";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While deleting Data .");
			return "redirect:/admin/admingetnotification";
		}
	}
}
