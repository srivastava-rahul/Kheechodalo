package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.click.entity.PicUploadData;
import com.click.entity.PictureUpload;
import com.click.service.PicsService;
import com.click.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class AdminPicInfoController {
	
	private static final Logger LOG = Logger.getLogger(QuickHelpController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	PicsService picsService;
	
			 
/*	@RequestMapping(value = "/adminpicinfo")
	protected String getPicInfo(Model model) throws Exception {
		System.out.println("In user aboutus controller");
		
		return "adminpicinfo";
	}*/
	
	
	@RequestMapping(value = "/adminpicinfo")
	protected String getpicInfo(Model model) throws Exception {
    LOG.info("Admin getting pic information from getpicInfo controller");
    try {
    	List<PicUploadData> picInfo=picsService.getPic();
		List<PictureUpload> picInfodetails = picsService.getPicDetails();
    	model.addAttribute("picinfo",picInfo);
		model.addAttribute("picinfodetails",picInfodetails);
	   } catch (Exception e) {
		   LOG.error(e.getMessage(),e);
			e.printStackTrace();
	}
		return "adminpicinfo";
	}
	
	/*
	@RequestMapping(value = "/adminSingleUserInfo")
	protected String searchUserbyEmailId(Model model ,@RequestParam String email_id) throws Exception {
    LOG.info("Admin searching user information based on email id controller");
     try {
		User userInfo = adminGetUserInfoService.getUserInfoByEmailId(email_id);
		
		LOG.info(userInfo.getEmailId());
		LOG.info(userInfo.getFirstName()+""+userInfo.getLastName());
		LOG.info(userInfo.getId());
		
		model.addAttribute("user",userInfo);
	   } catch (Exception e) {
		LOG.error(e.getMessage(),e);
			e.printStackTrace();
	}
		return "adminDashboard";
	}
	
	@RequestMapping(value = "/adminSingleProfileInfo")
	protected String searchProfilebyEmailId(Model model ,@RequestParam String email_id) throws Exception {
    LOG.info("Admin getting profile information based on email-id controller");
     try {
		ProfileSetting profileInfo = adminGetUserInfoService.getProfileInfoByEmailId(email_id);
		
		LOG.info(profileInfo.getEmail_id());
		LOG.info(profileInfo.getGender());
		LOG.info(profileInfo.getId());
		
		model.addAttribute("profile",profileInfo);
	   } catch (Exception e) {
		LOG.error(e.getMessage(),e);
			e.printStackTrace();
	}
		return "adminViewProfileSetting";
	}
	
	
	@RequestMapping(value = "/adminpicinfo")
	protected String getPicInfo(Model model) throws Exception {
		LOG.info("In user aboutus controller");
		
		return "adminpicinfo";
	}
	*/
	
		
	
}

