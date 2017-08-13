package com.click.controller;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.ProfileSetting;
import com.click.entity.User;
import com.click.service.AdminGetUserInfoService;
import com.click.service.PicsService;
import com.click.service.UserService;

/**
 * @author Vipul
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminDashboardController {

	private static final Logger LOG = Logger.getLogger(AdminDashboardController.class);

	@Autowired
	UserService userService;

	@Autowired
	AdminGetUserInfoService adminGetUserInfoService;
	
	@Autowired
	PicsService picsService;

	/*
	 * @RequestMapping(value = "/adminDashboard") protected String
	 * getAboutUs(Model model) throws Exception {
	 * LOG.info("In Admin Dashboard controller"); return "adminDashboard"; }
	 */

	@RequestMapping(value = "/adminDashboard")
	protected String getUserInfo(Model model) throws Exception {
		LOG.info("Admin getting user information from getUserInfo controller");
		try {
			List<User> userInfo = adminGetUserInfoService.getAllUserInfo();
			model.addAttribute("user", userInfo);
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return "adminDashboard";
	}

	@RequestMapping(value = "/adminSingleUserInfo")
	protected String searchUserbyEmailId(Model model, @RequestParam String email_id) throws Exception {
		LOG.info("Admin searching user information based on email id from searchUserbyEmailId controller");
		try {
			User userInfo = adminGetUserInfoService.getUserInfoByEmailId(email_id);
			model.addAttribute("user", userInfo);
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return "adminDashboard";
	}

	@RequestMapping(value = "/adminSingleProfileInfo/{email_id}")
	public String searchProfilebyEmailId(Model model, @PathVariable(name ="email_id") String email_id) throws Exception {
		LOG.info("Admin getting profile information based on email-id from searchProfilebyEmailId controller"+email_id);
		try {
			ProfileSetting profileInfo = adminGetUserInfoService.getProfileInfoByEmailId(email_id);
			LOG.info("File Data :" + profileInfo.getFileData());
			if(profileInfo.getFileData() !=null){
				byte[] encodeBase64 = Base64.encodeBase64(profileInfo.getFileData());
				String base64Encoded = new String(encodeBase64, "UTF-8");
				model.addAttribute("picImg", base64Encoded);
			}

			model.addAttribute("profile", profileInfo);
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return "adminViewProfileSetting";
	}


	@RequestMapping(value = "/deleteAllPics")
	protected String deleteAllPics(Model model) throws Exception {
		LOG.info("deleteAllPics called");
		try {
			picsService.deleteAllPics();
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return "dashboard";
	}

}
