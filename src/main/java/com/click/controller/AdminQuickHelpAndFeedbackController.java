package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.QuickHelp;
import com.click.entity.UserFeedback;
import com.click.service.QuickHelpService;

@Controller
@RequestMapping(value = "/user")
public class AdminQuickHelpAndFeedbackController {
	

	private static final Logger LOG = Logger.getLogger(AdminQuickHelpAndFeedbackController.class);
	
    @Autowired
	QuickHelpService quickHelpsrv;
			 
	
	@RequestMapping(value = "/adminfeedbackinfo")
	protected String getFeedbackInfo(Model model) throws Exception {
		LOG.info("Admin fetching  feedback information from getFeedbackInfo controller");
		try {
			 List<UserFeedback>  feedbacklist = quickHelpsrv.getFeedbackData();	
			 
			 model.addAttribute("feedback",feedbacklist);
		   } catch (Exception e) {
			   LOG.error(e.getMessage(),e);
				e.printStackTrace();
		}
		
		return "adminfeedbackinfo";
	}
	
	@RequestMapping(value = "/adminquickhelpinfo")
	protected String getQuickHelpInfo(Model model) throws Exception {
		LOG.info("Admin fetching quick help information from getQuickHelpInfo controller");
		try {
			
			List<QuickHelp>  quickhelplist = quickHelpsrv.getQuickHelpData();
			model.addAttribute("quickhelp",quickhelplist);
		   } catch (Exception e) {
			   LOG.error(e.getMessage(),e);
				e.printStackTrace();
		}
		return "adminquickhelpinfo";
	}
	
	@RequestMapping(value = "/admindeleteQuickhelp")
	protected String deleteQuickHelp(@RequestParam String id,Model model) throws Exception {
		LOG.info("Admin delete QuickHelp information based on id from deleteQuickHelp controller");
		try {
			QuickHelp quickhelp=new QuickHelp();
			quickhelp.setId(id);
			quickHelpsrv.deleteQuickHelpData(quickhelp);
			List<QuickHelp>  quickhelplist = quickHelpsrv.getQuickHelpData();			
			 model.addAttribute("quickhelp",quickhelplist);
			 model.addAttribute("success", " Data Deleted Successfully .");
			return "adminquickhelpinfo";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While deleting Data .");
			return "adminquickhelpinfo";
		}
	}
	
	@RequestMapping(value = "/admindeletefeedback")
	protected String deletefeedback(@RequestParam String id,Model model) throws Exception {
		LOG.info("Admin delete Feedback information based on id from deletefeedback controller");
		
		try {
			UserFeedback fedback=new UserFeedback();
			fedback.setId(id);
			quickHelpsrv.deleteFeedbackData(fedback);
			 List<UserFeedback>  feedbacklist = quickHelpsrv.getFeedbackData();			
			 model.addAttribute("feedback",feedbacklist);
			 model.addAttribute("success", " Data Deleted Successfully .");
			return "adminfeedbackinfo";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While deleting Data .");
			return "adminfeedbackinfo";
		}
	}
	
}
