package com.click.controller;

import java.util.Date;

/**
 * @author vipul
 */

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.QuickHelp;
import com.click.entity.User;
import com.click.entity.UserFeedback;
import com.click.service.QuickHelpService;
import com.click.service.SendMailService;
import com.click.service.UserService;
import com.click.utils.Global;
import com.click.utils.SecurityLibrary;

@Controller
@RequestMapping(value = "/user")
public class QuickHelpController {
	
	private static final Logger LOG = Logger.getLogger(QuickHelpController.class);

	@Autowired
	UserService userService;

	@Autowired
	QuickHelpService quickHelpService;

	@Autowired
	SendMailService sendMailService;

	@RequestMapping(value = "/quickHelp")
	protected String getAboutUs(Model model) throws Exception {
		LOG.info("Fetching the Quick Help Form  from getAboutUs controller");
		return "quickhelp";
	}

	@RequestMapping(value = "/feedback")
	protected String getFeedback(Model model) throws Exception {
		LOG.info("Fetching the Feedback Form");
		return "feedback";
	}

	@RequestMapping(value = "/quickHelpData", method = RequestMethod.POST)
	public String quickHelpData(@RequestParam String problem, @RequestParam String quickDesc, Model model)
			throws Exception {
		LOG.info("In-side QuickHelp controller to save data of  quickHelp from quickHelpData controller");
		try {			
			User userDetails = userService.findUserById(SecurityLibrary.getLoggedInUser().getId());
			QuickHelp quickHelp = new QuickHelp();
			quickHelp.setUser(userDetails);
			quickHelp.setQuickProblem(problem);
			quickHelp.setQuickDesc(quickDesc);
			quickHelp.setCreatedDate(new Date());
			sendProblemEmail(new String[] { "click8me@gmail.com" }, userDetails.getFirstName(), userDetails.getId(),
					"I " + userDetails.getEmailId() + " Want Some Help In " + problem + " And Short Description"
							+ quickDesc);
			quickHelpService.saveQuickHelpData(quickHelp);
			model.addAttribute("success", "Please Wait We Will Assist You Shortly .");
			return "dashboard";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured Whie Sending Data .");
			return "quickhelp";
		}
	}

	@RequestMapping(value = "/feedbackData", method = RequestMethod.POST)
	public String feedbackData(@RequestParam String feedback, Model model) throws Exception {
		LOG.info("In-side Feedback controller to save data of  feedback form by  feedbackData data");
		try {
			User userDetails = userService.findUserById(SecurityLibrary.getLoggedInUser().getId());
			UserFeedback feed = new UserFeedback();
			feed.setUser(userDetails);
			feed.setFeedDesc(feedback);
			feed.setCreatedDate(new Date());
			quickHelpService.saveFeedbackData(feed);
			model.addAttribute("success", "Thank You For Providing Us Yours Views .");
			return "dashboard";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured Whie Giving Feedback .");
			return "feedback";
		}
	}

	private void sendProblemEmail(String[] mailTo, String userName, String id, String message) {
		String subject = "Quick Help";
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userName);
		map.put("message", message);
		sendMailService.sendEmailTemplate(mailTo, subject, map, Global.PROBLEM_MAIL_TEMPLATE);
	}

}
