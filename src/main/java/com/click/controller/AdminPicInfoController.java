package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.click.entity.PicUploadData;
import com.click.entity.PictureUpload;
import com.click.entity.User;
import com.click.pojo.PictureUploadPojo;
import com.click.service.PicsService;
import com.click.service.UserService;
import com.click.utils.SecurityLibrary;

@Controller
@RequestMapping(value = "/admin")
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
	
	
	/*@RequestMapping(value = "/adminpicinfo")
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
	}*/
	
	
	/**
	 * Get list of All the pics for Admin 
	 * @param model
	 * @return to adminpicinfo page
	 * @throws Exception throw pics does not if table is empty 
	 */ 
	@RequestMapping(value = "/adminpicinfo")
	protected String getAllPicsforAdmin(Model model) throws Exception {
		LOG.info(" LOG Admin  pic information controller  from getAllPics controlllergetAllPicsforAdmin() ");
		//User u = SecurityLibrary.getLoggedInUser();
		List<PictureUploadPojo> picsList = picsService.findAllPicsbyAdmin();
		model.addAttribute("picsList", picsList);
		return "adminpicinfo";
	}
	
	
	/**
	 * Get Single pic information based on picid
	 * @param picid
	 * @param model
	 * @return to adminpicinfofull page
	 * @throws Exception throw data does not exist 
	 */
	@RequestMapping(value = "/adminpicinfofull/{picid}")
	protected String getSinglepicInfo(@PathVariable(name="picid") String picid,Model model) throws Exception {
    LOG.info("Admin getting pic information from getSinglepicInfo() controller"+picid);
    try {
    	 PictureUpload picInfo=picsService.getSinglepicInfo(picid);
    	 model.addAttribute("picinfo",picInfo);
    	 
		//List<PictureUpload> picInfodetails = picsService.getPicDetails();
		//.addAttribute("picinfodetails",picInfodetails);
	   } catch (Exception e) {
		   LOG.error(e.getMessage(),e);
			e.printStackTrace();
	}
		return "adminpicinfofull";
	}
	
	
	/**
	 * Get the single pic information  based on pic id 
	 * @param picid
	 * @param model
	 * @return to adminviewVoter page
	 * @throws Exception data does not exist
	 */
	@RequestMapping(value = "/adminviewVoter/{picid}")
	protected String getSinglepicInVoteInfo(@PathVariable(name="picid") String picid,Model model) throws Exception {
    LOG.info("Admin getting pic information from getSinglepicInfo() controller"+picid);
    try {
    	 PictureUpload picInfo=picsService.getSinglepicInfo(picid);
    	 model.addAttribute("picinfo",picInfo);
    	 
		//List<PictureUpload> picInfodetails = picsService.getPicDetails();
		//.addAttribute("picinfodetails",picInfodetails);
	   } catch (Exception e) {
		   LOG.error(e.getMessage(),e);
			e.printStackTrace();
	}
		return "adminviewVoter";
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

