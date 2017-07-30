package com.click.controller;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.PictureUpload;
import com.click.entity.ProfileSetting;
import com.click.service.PicsService;
import com.click.service.ProfileSettingService;
import com.click.utils.SecurityLibrary;

@Controller
@RequestMapping(value = "/user")
public class SearchController {

	private static final Logger LOG = Logger.getLogger(SearchController.class);
	
	@Autowired
	ProfileSettingService profileSettingService;
	
	@Autowired
	PicsService picsService;
	
	@RequestMapping(value = "/search", method = { RequestMethod.POST})
	protected String getSearchPage(@RequestParam String search,Model model) throws Exception {
		LOG.info("Fetching search page from getSearchPage  controller"+search);
		
		try{
			if(search==null){
				 model.addAttribute("error", "Please provide valid Data");
				 return"searchpage";
			}
			List<ProfileSetting> profileSetting =  profileSettingService.findByEmailAndName(search);
			LOG.info("Fetching search page from getSearchPage  controller"+profileSetting.size());
			model.addAttribute("viewprofile", profileSetting);
//		     if (profileSetting.isEmpty()) {
//			   model.addAttribute("error", "User Does not exit");
//			}else{
//				
//					byte[] encodeBase64 = Base64.encodeBase64(profileSetting.get(0).getFileData());
//					String base64Encoded = new String(encodeBase64, "UTF-8");
//					model.addAttribute("picImg", base64Encoded);
//				 model.addAttribute("viewprofile", profileSetting);
//			}
		 }catch( Exception e){
			 LOG.error(e.getMessage(),e);
				e.printStackTrace();
			 model.addAttribute("error", "Invalid Data ");
		 }
		
		return "searchpage";
	}

	
	@RequestMapping(value = "/searchpicbyemailId",  method = RequestMethod.GET)
	protected String getpicbyEmailId(Model model) throws Exception {
		LOG.info("Fetching pic depend on email id for search page controller");
		long maxVoteCount = picsService.findPicMaxVoteCount();
		PictureUpload pictureUpload = picsService.findPicByUserId(SecurityLibrary.getLoggedInUser().getId());
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
		
	}
	
}
