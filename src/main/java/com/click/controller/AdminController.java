package com.click.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.ProfileSetting;
import com.click.entity.QuickHelp;
import com.click.entity.User;
import com.click.entity.UserFeedback;
import com.click.service.AdminGetUserInfoService;
import com.click.service.QuickHelpService;

@Controller
@RequestMapping(value = "/user")
public class AdminController {
	
	@Autowired
	AdminGetUserInfoService adminGetUserInfoService;
	
	
	@Autowired
	QuickHelpService quickHelpsrv;
	 
			 
	@RequestMapping(value = "/adminDashboard")
	protected String getUserInfo(Model model) throws Exception {
    System.out.println("In user aboutus controller");
    
    try {
		List<User> userInfo = adminGetUserInfoService.getAllUserInfo();
		
		System.out.println(userInfo.get(0).getEmailId());
		System.out.println(userInfo.get(0).getFirstName()+""+userInfo.get(0).getLastName());
		System.out.println(userInfo.get(0).getId());
		
		model.addAttribute("user",userInfo);
	   } catch (Exception e) {
		e.printStackTrace();
	}
		return "adminDashboard";
	}
	
	
	@RequestMapping(value = "/adminSingleUserInfo")
	protected String searchUserbyEmailId(Model model ,@RequestParam String email_id) throws Exception {
    System.out.println("In user aboutus controller");
     try {
		User userInfo = adminGetUserInfoService.getUserInfoByEmailId(email_id);
		
		System.out.println(userInfo.getEmailId());
		System.out.println(userInfo.getFirstName()+""+userInfo.getLastName());
		System.out.println(userInfo.getId());
		
		model.addAttribute("user",userInfo);
	   } catch (Exception e) {
		e.printStackTrace();
	}
		return "adminDashboard";
	}
	
	@RequestMapping(value = "/adminSingleProfileInfo")
	protected String searchProfilebyEmailId(Model model ,@RequestParam String email_id) throws Exception {
    System.out.println("In user aboutus controller");
     try {
		ProfileSetting profileInfo = adminGetUserInfoService.getProfileInfoByEmailId(email_id);
		
		System.out.println(profileInfo.getEmail_id());
		System.out.println(profileInfo.getGender());
		System.out.println(profileInfo.getId());
		
		model.addAttribute("profile",profileInfo);
	   } catch (Exception e) {
		e.printStackTrace();
	}
		return "adminDashboard";
	}
	
	
	@RequestMapping(value = "/adminpicinfo")
	protected String getPicInfo(Model model) throws Exception {
		System.out.println("In user aboutus controller");
		
		return "adminpicinfo";
	}
	
	@RequestMapping(value = "/adminfeedbackinfo")
	protected String getFeedbackInfo(Model model) throws Exception {
		System.out.println("In user aboutus controller");
		try {
			 List<UserFeedback>  feedbacklist = quickHelpsrv.getFeedbackData();			
			model.addAttribute("feedback",feedbacklist);
		   } catch (Exception e) {
			e.printStackTrace();
		}
		
		return "adminfeedbackinfo";
	}
	
	@RequestMapping(value = "/adminquickhelpinfo")
	protected String getQuickHelpInfo(Model model) throws Exception {
		System.out.println("In user aboutus controller");
		try {
			
			 List<QuickHelp>  quickhelplist = quickHelpsrv.getQuickHelpData();
			
			model.addAttribute("quickhelp",quickhelplist);
		   } catch (Exception e) {
			e.printStackTrace();
		}
		return "adminquickhelpinfo";
	}
	
	
	@RequestMapping(value = "/adminsendnotification")
	protected String sendNotificationbyAdmin(Model model) throws Exception {
		System.out.println("In user aboutus controller");
		return "adminsendnotification";
	}
	
	@RequestMapping(value = "/adminsendtestimonial")
	protected String sendtestimonialbyAdmin(Model model) throws Exception {
		System.out.println("In user aboutus controller");
		return "adminsendtestimonial";
	}

	
	@RequestMapping(value = "/adminsendprize")
	protected String sendprizebyAdmin(Model model) throws Exception {
		System.out.println("In user aboutus controller");
		return "adminsendprize";
	}
	
	
	
}
