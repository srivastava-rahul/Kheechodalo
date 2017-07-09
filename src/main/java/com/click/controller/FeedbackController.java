package com.click.controller;

import java.util.HashMap;

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
public class FeedbackController {

	@Autowired
	UserService userService;
	
	@Autowired	
	QuickHelpService quickHelpService;

	@Autowired
	SendMailService sendMailService;
	
	/*@RequestMapping(value = "/quickHelp")
	protected String getAboutUs(Model model) throws Exception {
		System.out.println("In user QuickHelp controller");
		return "quickhelp";
	}

	@RequestMapping(value = "/quickHelpData", method = RequestMethod.POST)
	public String quickHelpData(@RequestParam String problem, @RequestParam String quickDesc,Model model) throws Exception {
		System.out.println("In user quickHelpData controller");
		System.out.println("oldPassword : " + problem + " quickDesc : " + quickDesc);
		User userDetails = userService.findUserById(SecurityLibrary.getLoggedInUser().getId());
		System.out.println("User Password :" + userDetails.getFirstName());
			
			QuickHelp quickHelp = new QuickHelp();
			quickHelp.setUser(userDetails);
			quickHelp.setQuickProblem(problem);
			quickHelp.setQuickDesc(quickDesc);
			
			sendRegistrationEmail(new String[] { "click8me@gmail.com" }, userDetails.getFirstName(), userDetails.getId(),"I "+userDetails.getEmailId() +" Want Some Help In "+problem+" And Short Description"+quickDesc);
			quickHelpService.saveQuickHelpData(quickHelp);
			model.addAttribute("success", "Please Wait We Will Assist You Shortly .");
			return "dashboard";
	}
	
	
	@RequestMapping(value = "/feedbackData", method = RequestMethod.POST)
	public String feedbackData(@RequestParam String feedback,Model model) throws Exception {
		System.out.println("In user feedbackData controller");
		System.out.println("feedbackData : " + feedback);
		User userDetails = userService.findUserById(SecurityLibrary.getLoggedInUser().getId());
		System.out.println("User Password :" + userDetails.getFirstName());
			
			UserFeedback feed = new UserFeedback();
			feed.setUser(userDetails);
			feed.setFeedDesc(feedback);
			
			sendRegistrationEmail(new String[] { "vipul061993@gmail.com" }, userDetails.getFirstName(), userDetails.getId(),"I "+userDetails.getEmailId() +" My Feedback "+feedback);
			quickHelpService.saveFeedbackData(feed);
			model.addAttribute("success", "Please Wait We Will Assist You Shortly .");
			return "dashboard";
	}
	
	
	private void sendRegistrationEmail(String[] mailTo, String userName, String id, String message) {
		String subject = "Quick Help";
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userName);
		map.put("message", message);
		sendMailService.sendEmailTemplate(mailTo, subject, map, Global.PROBLEM_MAIL_TEMPLATE);
	}*/
	
	@RequestMapping(value = "/feedback")
	protected String getAboutUs(Model model) throws Exception {
		System.out.println("In user aboutus controller");
		return "feedback";
	}
	
	
	

}
