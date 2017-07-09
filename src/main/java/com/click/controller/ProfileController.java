package com.click.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.click.entity.ProfileSetting;
import com.click.service.ProfileSettingService;
import com.click.utils.SecurityLibrary;

@Controller
@RequestMapping(value = "/user")
public class ProfileController {

	@Autowired
	ProfileSettingService profileSettingService;
	
	/*@RequestMapping(value = "/profile")
	protected String getAboutUs(Model model) throws Exception {
		
		
		System.out.println("In user aboutus controller");
		return "profile";
	}*/

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String getUser( Model model) {
		 try{
		
			 ProfileSetting profileSetting =  profileSettingService.findByEmailId(SecurityLibrary.getLoggedInUser().getEmailId());
			 if (profileSetting == null) {
				profileSetting = new ProfileSetting();
			}
			model.addAttribute("profileSetting", profileSetting);
				
		 }catch( Exception e){
			 e.printStackTrace();
			 model.addAttribute("error", "Invalid Data ");
		 }
		 
		return "profile";
	}
	
}
