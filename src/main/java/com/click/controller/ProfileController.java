package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.click.entity.ProfileSetting;
import com.click.service.ProfileSettingService;
import com.click.utils.SecurityLibrary;
import com.click.utils.StringUtils;

@Controller
@RequestMapping(value = "/user")
public class ProfileController {

	private static final Logger LOG = Logger.getLogger(ProfileController.class);
	
	@Autowired
	ProfileSettingService profileSettingService;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String getUser( Model model) {
		LOG.info("Fetching  profile  page from getUser controller ");
		 try{
			 ProfileSetting profileSetting =  profileSettingService.findByEmailId(SecurityLibrary.getLoggedInUser().getEmailId());
			 if (profileSetting == null) {
				profileSetting = new ProfileSetting();
			}
			model.addAttribute("profileSetting", profileSetting);
		 }catch( Exception e){
			 LOG.error(e.getMessage(),e);
				e.printStackTrace();
			 model.addAttribute("error", "Invalid Data ");
		 }
		return "profile";
	}
	
	@RequestMapping(value = "/viewProfile/{emailid}", method = RequestMethod.GET)
	public String viewOtherProfile(@PathVariable(name="emailid") String email_id ,Model model) {
		LOG.info("Fetching the profile data on the basis of email_id from viewOtherProfile controller"+email_id);
		 try{
			 if(StringUtils.checkString(email_id).length() > 0)
			 {
		        ProfileSetting profileSetting =  profileSettingService.findProfileByEmailId(email_id);
		        
		        if(profileSetting.isPhone_flage()==true)
		        {
		        	profileSetting.setPhone(0);
		        }
		        if(profileSetting.isPaytm_flage()==true)
		        {
		        	profileSetting.setPaytm("Hidden");
		        }
		        
		        if(profileSetting.isAddress_flage()==true)
		        {
		        	profileSetting.setAddress("Hidden");
		        }
		        
		        LOG.debug("Show only the data which is not hidden");
		        model.addAttribute("profileSetting", profileSetting);
			 }
				
		 }catch( Exception e){
			 LOG.error(e.getMessage(),e);
				e.printStackTrace();
			 model.addAttribute("error", "Invalid Data ");
		 }
		 
		return "profile";
	}
	
}
