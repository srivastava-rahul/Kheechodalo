package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.Notification;
import com.click.service.NotificationService;
import com.click.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class AdminNotificationController {
	

	private static final Logger LOG = Logger.getLogger(AdminNotificationController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	NotificationService notificationService;  
			 
	
	@RequestMapping(value = "/adminsendnotification", method = RequestMethod.POST)
	public String saveNotificationData(@RequestParam String notification , Model model)
			throws Exception {
		LOG.info("Admin adding notification from saveNotificationData controller");
		try {
			
			/*User userDetails = userService.findUserById(SecurityLibrary.getLoggedInUser().getEmailId());
			LOG.info("Admin Email - Id :" + userDetails.getEmailId());*/
			
			Notification notify=new Notification();
			notify.setNotification_desc(notification);
			//notify.setEmail_id(userDetails.getEmailId());	
			
			notificationService.saveNotification(notify);	
			
			 List<Notification>  listofNotification = notificationService.getNotification();
			 model.addAttribute("notification",listofNotification);
			 model.addAttribute("success", " Data Entered Successfully .");			
			return "adminsendnotification";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While Sending Data .");
			return "adminsendnotification";
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
	
	@RequestMapping(value = "/admindeletenotification")
	protected String deleteNotificationInfo(@RequestParam String id,Model model) throws Exception {
		LOG.info("Admin removing notification based on id from deleteNotificationInfo controller");
		try {
			Notification notify=new Notification();
			 notify.setId(id);
			 notificationService.deleteNotification(notify);
			 List<Notification>  listofNotification = notificationService.getNotification();			
		     model.addAttribute("notification",listofNotification);
			 model.addAttribute("success", " Data Deleted Successfully .");
			return "adminsendnotification";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While deleting Data .");
			return "adminsendnotification";
		}
	}
}
