package com.click.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.click.entity.ProfileSetting;
import com.click.entity.User;
import com.click.service.ProfileSettingService;
import com.click.service.UserService;
import com.click.utils.SecurityLibrary;

@Controller
@RequestMapping(path = "/user")
public class ProfileSettingsController {

	private static final Logger LOG = Logger.getLogger(ProfileSettingsController.class);

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, true));
	}

	@Autowired
	UserService userService;

	@Autowired
	ProfileSettingService profileSettingService;

	@RequestMapping(value = "/getProfileSettings", method = RequestMethod.GET)
	public String getProfile(Model model) {
		LOG.info("Inside getProfile controller where user set  profile data Or user information");
		try {
			ProfileSetting profileSetting = profileSettingService.findByEmailId(SecurityLibrary.getLoggedInUser().getEmailId());
			if (profileSetting == null) {
				profileSetting = new ProfileSetting();
			} else {
				try {
					if (profileSetting.getFileData() != null) {
						byte[] encodeBase64 = Base64.encodeBase64(profileSetting.getFileData());
						String base64Encoded = new String(encodeBase64, "UTF-8");
						model.addAttribute("picImg", base64Encoded);
					}
				} catch (Exception e) {
					LOG.error(e.getMessage(), e);
					e.printStackTrace();
					System.out.println("Error while encoded ");
				}
			}
			model.addAttribute("profileSetting", profileSetting);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Invalid Data ");
		}
		return "settings";
	}

	@RequestMapping(value = "/basicInformation", method = RequestMethod.POST)
	public String addbasicinformation(@ModelAttribute ProfileSetting userprofiledata, Model model) {
		LOG.info("Inside addbasicinformation controller where user set  profile data Or user information");
		try {
			userprofiledata.setEmail_id(SecurityLibrary.getLoggedInUser().getEmailId());
			userprofiledata = profileSettingService.adduserprofiledata(userprofiledata);
			model.addAttribute("profileSetting", userprofiledata);
			model.addAttribute("success", "Data  SuccessFully Updated");
		} catch (NullPointerException e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
			model.addAttribute("error", "Error " + e.getMessage());
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
			model.addAttribute("error", "Error " + e.getMessage());
		}
		return "settings";
	}

	@RequestMapping(value = "/uploadprofilepic", method = RequestMethod.GET)
	public String uploadprofilepic() {
		LOG.info("Inside uploadprofilepic controller to Fetch the upload pic page");
		return "UploadProfilePic";
	}

	@RequestMapping(value = "/saveProfilePic", method = RequestMethod.POST)
	public String savePic(@RequestParam("picImg") MultipartFile uploadPic, Model model) {
		LOG.info("Inside savepic controller to save the pic ");
		String fileName = null;
		if (!uploadPic.isEmpty()) {
			try {
				ProfileSetting profileSetting = profileSettingService
						.findByEmailId(SecurityLibrary.getLoggedInUser().getEmailId());
				byte[] bytes = uploadPic.getBytes();
				profileSetting.setFileData(bytes);
				User user = new User();
				profileSettingService.updateProfile(profileSetting);
				LOG.debug("uploaded");
				byte[] encodeBase64 = Base64.encodeBase64(profileSetting.getFileData());
				String base64Encoded = new String(encodeBase64, "UTF-8");
				model.addAttribute("picImg", base64Encoded);
				return "UploadProfilePic";
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
				e.printStackTrace();
				return "UploadProfilePic";
			}
		} else {
			return "UploadProfilePic";
		}
	}
}
