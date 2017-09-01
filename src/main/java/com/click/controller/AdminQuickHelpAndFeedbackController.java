package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.click.entity.QuickHelp;
import com.click.entity.UserFeedback;
import com.click.service.QuickHelpService;

@Controller
@RequestMapping(value = "/admin")
public class AdminQuickHelpAndFeedbackController {
	

	private static final Logger LOG = Logger.getLogger(AdminQuickHelpAndFeedbackController.class);
	
    @Autowired
	QuickHelpService quickHelpsrv;
			 
	
	/**
	 * Get all the feedback by Admin
	 * @param model
	 * @return to adminfeedbackinfo page 
	 * @throws Exception throw data does not exist
	 */
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
	
	/**
	 * Get all the quick help information by admin
	 * @param model
	 * @return to adminquickhelpinfo page
	 * @throws Exception throw data does not exist 
	 */
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
	
	/**
	 * Quick help deleted by Admin based on id 
	 * @param id
	 * @param model
	 * @return to adminquickhelpinfo page
	 * @throws Exception throw data does not exist
	 */
	@RequestMapping(value = "/admindeleteQuickhelp/{id}")
	protected String deleteQuickHelp(@PathVariable(name ="id")  String id,Model model) throws Exception {
		LOG.info("Admin delete QuickHelp information based on id from deleteQuickHelp controller");
		try {
			QuickHelp quickhelp=new QuickHelp();
			quickhelp.setId(id);
			quickHelpsrv.deleteQuickHelpData(quickhelp);
			 model.addAttribute("success", " Data Deleted Successfully .");
			 return "redirect:/admin/adminquickhelpinfo";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While deleting Data .");
			return "redirect:/admin/adminquickhelpinfo";
		}
	}
	
	
	/**
	 * feedback deleted by Admin based on id
	 * @param id
	 * @param model
	 * @return to adminfeedbackinfo page
	 * @throws Exception throw data does not exist
	 */
	@RequestMapping(value = "/admindeletefeedback/{id}")
	protected String deletefeedback(@PathVariable(name ="id")  String id,Model model) throws Exception {
		LOG.info("Admin delete Feedback information based on id from deletefeedback controller");
		try {
			UserFeedback fedback=new UserFeedback();
			fedback.setId(id);
			quickHelpsrv.deleteFeedbackData(fedback);
			 model.addAttribute("success", " Data Deleted Successfully .");
			return "redirect:/admin/adminfeedbackinfo";
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured While deleting Data .");
			return "redirect:/admin/adminfeedbackinfo";
		}
	}
	
}
