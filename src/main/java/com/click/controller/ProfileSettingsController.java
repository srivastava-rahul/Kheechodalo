package com.click.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.click.entity.User;
import com.click.entity.ProfileSetting;
import com.click.service.ProfileSettingService;
import com.click.service.UserService;
import com.click.utils.SecurityLibrary;

@Controller
@RequestMapping(path = "/user")
public class ProfileSettingsController {
	
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
	public String getUser( Model model) {
		
		 try{
		//	User user = userService.findUserById(SecurityLibrary.getLoggedInUser().getEmailId());
			 ProfileSetting profileSetting =  profileSettingService.findByEmailId(SecurityLibrary.getLoggedInUser().getEmailId());
			 if (profileSetting == null) {
				profileSetting = new ProfileSetting();
			}
			model.addAttribute("profileSetting", profileSetting);
				
		 }catch( Exception e){
			 e.printStackTrace();
			 model.addAttribute("error", "Invalid Data ");
		 }
		 
		return "settings";
	}

	@RequestMapping(value = "/basicInformation", method = RequestMethod.POST)
	public String addbasicinformation(@ModelAttribute ProfileSetting userprofiledata, Model model) {
		try {
			//User user = userService.findUserById(SecurityLibrary.getLoggedInUser().getId());
			System.out.println("user object :" + userprofiledata.toLogString());
			userprofiledata.setEmail_id(SecurityLibrary.getLoggedInUser().getEmailId());

			userprofiledata = profileSettingService.adduserprofiledata(userprofiledata);
            
			 model.addAttribute("profileSetting", userprofiledata);
			 model.addAttribute("success", "Data  SuccessFully Updated" );
		}catch (NullPointerException e) {
			System.out.println("Error getUser : " +e.getMessage());
			e.printStackTrace();
			model.addAttribute("error", "Error "+e.getMessage());
		} catch (Exception e) {
			System.out.println("Error getUser");
			e.printStackTrace();
			model.addAttribute("error", "Error "+e.getMessage());
		}
		return "settings";
	}

}
