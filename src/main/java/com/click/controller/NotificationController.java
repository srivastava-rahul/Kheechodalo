package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.click.entity.Notification;
import com.click.service.NotificationService;

@Controller
@RequestMapping(value = "/user")
public class NotificationController {

	private static final Logger LOG = Logger.getLogger(NotificationController.class);
	
	@Autowired
	NotificationService notifi;

	/**
	 * Getting Notification for User
	 * @param model
	 * @return to notification page
	 * @throws Exception if page does not exist
	 */
	@RequestMapping(value = "/notification")
	protected String getNotificationforuser(Model model) throws Exception {
		LOG.info("Fetching the prize information from getPrizeRecord controller ");
		try {
			List<Notification> notifiy = notifi.getNotification();
			model.addAttribute("notifiy",notifiy);
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return "notification";
	}

}
