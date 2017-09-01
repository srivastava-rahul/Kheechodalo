package com.click.controller;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.ProfileSetting;
import com.click.entity.User;
import com.click.pojo.PictureUploadPojo;
import com.click.service.AdminGetUserInfoService;
import com.click.service.PicsService;
import com.click.service.UserService;
import com.click.utils.SecurityLibrary;

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

	/**
	 * Getting the user information
	 * @param model
	 * @return page to admin dashboard with user information
	 * @throws Exception throw message user does not exist 
	 */
	@RequestMapping(value = "/adminDashboard")
	protected String getUserInfo(Model model) throws Exception {
		LOG.info("Admin getting user information from getUserInfo controller");
		try {
			List<User> userInfo = adminGetUserInfoService.getAllUserInfo();
			int total = adminGetUserInfoService.countAllTotalUser();
			model.addAttribute("total", total);
			model.addAttribute("user", userInfo);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return "adminDashboard";
	}

	/**
	 * Getting the user information based on email id
	 * @param model
	 * @param email_id
	 * @return to Admin Dashboard page with particular user information
	 * @throws Exception throw message user does not exist 
	 */
	@RequestMapping(value = "/adminSingleUserInfo")
	protected String searchUserbyEmailId(Model model, @RequestParam String email_id) throws Exception {
		LOG.info("Admin searching user information based on email id from searchUserbyEmailId controller");
		try {
			User userInfo = adminGetUserInfoService.getUserInfoByEmailId(email_id);
			model.addAttribute("user", userInfo);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return "adminDashboard";
	}

	
	/**
	 * Search the profile information of particular user based on email_id for Admin
	 * @param model
	 * @param email_id
	 * @return  to adminViewProfileSetting
	 * @throws Exception throw profile information does not exist error
	 */
	@RequestMapping(value = "/adminSingleProfileInfo/{email_id}")
	public String searchProfilebyEmailId(Model model, @PathVariable(name = "email_id") String email_id)
			throws Exception {
		LOG.info("Admin getting profile information based on email-id from searchProfilebyEmailId controller"
				+ email_id);
		try {
			ProfileSetting profileInfo = adminGetUserInfoService.getProfileInfoByEmailId(email_id);
			if (profileInfo.getFileData() != null) {
				byte[] encodeBase64 = Base64.encodeBase64(profileInfo.getFileData());
				String base64Encoded = new String(encodeBase64, "UTF-8");
				model.addAttribute("picImg", base64Encoded);
			}

			model.addAttribute("profile", profileInfo);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return "adminViewProfileSetting";
	}

	
	/**
	 * Delete all the pic at 11.55pm when scheduler start  from pic table
	 * @param model
	 * @return to the Admin dashboard page
	 * @throws Exception data does not exist
	 */
	@RequestMapping(value = "/deleteAllPics")
	protected String deleteAllPics(Model model) throws Exception {
		LOG.info("deleteAllPics called");
		try {
			picsService.deleteAllPics();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return "dashboard";
	}

	/**
	 * Get Vote Increment page
	 * @param model
	 * @return to  adminVoteIncrement page
	 * @throws Exception page does not exist
	 */
	@RequestMapping(value = "/adminVoteIncrement")
	protected String getVoteIncrement(Model model) throws Exception {
		LOG.info("Fetching the Quick Help Form  from getAboutUs controller");
		
		return "adminVoteIncrement";
	}

	
	
	
	/**
	 * Increase the vote by admin
	 * @param emailId
	 * @param model
	 * @return to adminVoteIncrement page 
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminVoteIncrementCount", method = RequestMethod.POST)
	public String adminVoteIncrementCount(@RequestParam String emailId, Model model) throws Exception {
		LOG.info("In-side Admin Search Vote controller" + emailId);
		try {
			long voteConut = picsService.findVoteCountForAdminOfSpecificEmail(emailId);
			LOG.info(" Vote Count :" + voteConut);
			model.addAttribute("voteConut", voteConut);
			model.addAttribute("emailId",emailId);
			return "adminVoteIncrement";
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured Whie Sending Data .");
			return "adminVoteIncrement";
		}
	}

	/**
	 * Increment  the vote count on a pic based on email id
	 * @param model
	 * @param voteConut
	 * @param emailId
	 * @return adminVoteIncrement page
	 * @throws Exception throw pic does not exist
	 */
	@RequestMapping(value = "/increment/{voteConut}/{emailId}", method = RequestMethod.GET)
	public String incrementCount(Model model,@PathVariable(name = "voteConut") String voteConut ,@PathVariable(name = "emailId") String emailId) throws Exception {
		try {
			long vote= Long.parseLong(voteConut);
			long voteConut1 = picsService.incrementVoteCountForEmail(vote,emailId);
			model.addAttribute("voteConut", voteConut1);
			return "adminVoteIncrement";
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured Whie Sending Data .");
			return "adminVoteIncrement";
		}
	}
	

	/**
	 * Render the forget password screen
	 * @return
	 */
	@RequestMapping(value = "/newUserPassword", method = RequestMethod.GET)
	public String forgetPassword() {
		return "newUserPassword";
	}

	
	/**
	 * change old password to new password
	 * @param oldPassword
	 * @param newPassword
	 * @param confirmPassword
	 * @param model
	 * @return admin dashboard page
	 */
	@RequestMapping(value = "/changeNewPassword", method = RequestMethod.POST)
	public String changeNewPassword(@RequestParam String oldPassword, @RequestParam String newPassword,
			@RequestParam String confirmPassword, Model model) {
		LOG.info("Inside changeNewPassword controller");
		try {
			User userDetails = userService.findUserById(SecurityLibrary.getLoggedInUser().getId());

			BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
			LOG.info(" Pass : "+enc.matches(oldPassword, userDetails.getPassword()) +" old pass : "+userDetails.getPassword());
			
			if (enc.matches(oldPassword, userDetails.getPassword())) {
//			if (userDetails.getPassword().trim().equals(oldPassword.trim())) {
				LOG.debug("  Both Equal ");
				if (!(newPassword.trim().equals(confirmPassword.trim()))) {
					LOG.debug(" Same Password ");
					model.addAttribute("error", "New password And Confirm Password Must Be Same");
					return "newUserPassword";
				} else {
					String conPass = enc.encode(confirmPassword);
					userDetails.setPassword(conPass);
					userService.updateUserDetails(userDetails);
					model.addAttribute("success", "Your password has been Changed Successfully .");
					return "dashboard";
				}
			}else{
				model.addAttribute("error", "Your entered Old Password Is Incorrect");
				return "newUserPassword";
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		model.addAttribute("error", "Your entered Old Password Is Incorrect");
		return "newUserPassword";
	}
	
	
	
	/**
	 * Delete the pic by admin based on pic id
	 * @param picId
	 * @param model
	 * @return to adminpicinfo page
	 * @throws Exception pic does not exist 
	 */
	@RequestMapping(value = "/adminDeletePic", method = RequestMethod.POST)
	public String adminDeletePic(@RequestParam String picId, Model model) throws Exception {
		LOG.info("In-side Admin Search Vote controller" + picId);
		try {
			picsService.adminDeletePicByPicId(picId);
			List<PictureUploadPojo> picsList = picsService.findAllPicsbyAdmin();
			model.addAttribute("picsList", picsList);

			model.addAttribute("success", "Image Deleted Successfully");
			return "adminpicinfo";
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
			model.addAttribute("error", "Error Occured Whie Image Deleted  .");
			return "adminpicinfo";
		}
	}
}
