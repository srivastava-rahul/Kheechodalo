package com.click.controller;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.click.entity.PictureUpload;
import com.click.entity.ProfileSetting;
import com.click.entity.User;
import com.click.pojo.PictureUploadPojo;
import com.click.service.PicsService;
import com.click.service.ProfileSettingService;
import com.click.utils.SecurityLibrary;
import com.click.utils.StringUtils;

@Controller
@RequestMapping(value = "/user")
public class SearchController {

	private static final Logger LOG = Logger.getLogger(SearchController.class);
	
	@Autowired
	ProfileSettingService profileSettingService;
	
	@Autowired
	PicsService picsService;
	
	/**
	 * Fetching user  through search box
	 * @param search
	 * @param model
	 * @return to searchpage page
	 * @throws Exception if data does not exist
	 */
	@RequestMapping(value = "/search", method = { RequestMethod.POST})
	protected String getSearchPage(@RequestParam String search,Model model) throws Exception {
		LOG.info("Fetching search page from getSearchPage  controller"+search);
		
		try{
			if(search==null ){
				 model.addAttribute("error", "Please provide valid Data");
				 return"searchpage";
			}
			List<ProfileSetting> profileSetting =  profileSettingService.findByEmailAndName(StringUtils.checkString(search));
			LOG.info("Fetching search page from getSearchPage  controller"+profileSetting.size());
			
			
			
		     if (profileSetting.isEmpty()) {
			   model.addAttribute("error", "User Does not exit");
			}else{
				for (ProfileSetting profileSetting2 : profileSetting) {
					if(profileSetting2.getFileData() !=null){
					byte[] encodeBase64 = Base64.encodeBase64(profileSetting2.getFileData());
					String base64Encoded = new String(encodeBase64, "UTF-8");
					profileSetting2.setPicImg(base64Encoded);
					}
				}
					
				//model.addAttribute("picImglist", piclist);	
			model.addAttribute("viewprofile", profileSetting);
				
		}
		 }catch( Exception e){
			 LOG.error(e.getMessage(),e);
				e.printStackTrace();
			 model.addAttribute("error", "Invalid Data ");
		 }
		
		return "searchpage";
	}

	
	/**
	 * Getting pics of user based on email_id
	 * @param email_id
	 * @param model
	 * @return to uploadPic page
	 * @throws Exception if data does not exist
	 */
/*	@RequestMapping(value = "/searchpicbyemailId/{email_id}",  method = RequestMethod.GET)
	protected String getpicbyEmailId(@PathVariable(name="email_id") String email_id,Model model) throws Exception {
		LOG.info("Fetching pic depend on email id for search page controller"+email_id);
		long maxVoteCount = picsService.findPicMaxVoteCount();
		PictureUpload pictureUpload = picsService.findPicByUserId(email_id);
		model.addAttribute("maxVoteCount", maxVoteCount);
		model.addAttribute("picData", pictureUpload);
		try {
			if (pictureUpload != null && pictureUpload.getPicUploadData() != null
					&& pictureUpload.getPicUploadData().getFileData() != null) {
				byte[] encodeBase64 = Base64.encodeBase64(pictureUpload.getPicUploadData().getFileData());
				String base64Encoded = new String(encodeBase64, "UTF-8");
				model.addAttribute("picImg", base64Encoded);
			}else{
				model.addAttribute("error","No pic Found");
				return "searchpage";
			}
		} catch (Exception e) {
            LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return "uploadPic";
		
		
	}*/
	
	@RequestMapping(value = "/picsearchbyemailid")
	protected String getPicsbyemail_id(String email_id,Model model) throws Exception {
		LOG.info("Fetching pic depend on email id for search page controller==>"+email_id);
		if(email_id == null && email_id.equals("")){
			model.addAttribute("error","Invalid data");
			return "searchpage";
		}else{
		LOG.info(" LOG User Dashboard from getPicsbyemail_id controlller==>"+email_id);
		User u = SecurityLibrary.getLoggedInUser();
		PictureUploadPojo searchPic = picsService.findPicsbyemail(email_id);
		if(searchPic.getId()!=null){
			model.addAttribute("searchPic", searchPic);
			return "dashboard";
		}else{
			model.addAttribute("error","No pic Found");
			return "searchpage";
		}
		}
	}
	
}
