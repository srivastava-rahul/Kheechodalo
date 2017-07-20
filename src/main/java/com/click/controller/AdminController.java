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
import com.click.entity.ProfileSetting;
import com.click.entity.QuickHelp;
import com.click.entity.User;
import com.click.entity.UserFeedback;
import com.click.service.AdminGetUserInfoService;
import com.click.service.NotificationService;
import com.click.service.QuickHelpService;
import com.click.service.UserService;
import com.click.utils.SecurityLibrary;

@Controller
@RequestMapping(value = "/user")
public class AdminController {
	
	private static final Logger LOG = Logger.getLogger(QuickHelpController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	AdminGetUserInfoService adminGetUserInfoService;
	
			 
	@RequestMapping(value = "/adminDashboard")
	protected String getUserInfo(Model model) throws Exception {
    System.out.println("Admin getting user information controller");
    
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
    System.out.println("Admin searching user information based on email id controller");
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
    System.out.println("Admin getting profile information based on email-id controller");
     try {
		ProfileSetting profileInfo = adminGetUserInfoService.getProfileInfoByEmailId(email_id);
		
		System.out.println(profileInfo.getEmail_id());
		System.out.println(profileInfo.getGender());
		System.out.println(profileInfo.getId());
		
		model.addAttribute("profile",profileInfo);
	   } catch (Exception e) {
		e.printStackTrace();
	}
		return "adminViewProfileSetting";
	}
	
	
	@RequestMapping(value = "/adminpicinfo")
	protected String getPicInfo(Model model) throws Exception {
		System.out.println("In user aboutus controller");
		
		return "adminpicinfo";
	}
	
	
		
	
}

