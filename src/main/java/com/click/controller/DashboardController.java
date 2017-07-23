package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.User;
import com.click.pojo.PictureUploadPojo;
import com.click.service.PicsService;
import com.click.service.UserService;
import com.click.utils.SecurityLibrary;

/**
 * 
 * @author Vipul
 *
 */
@Controller
@RequestMapping(value = "/user")
public class DashboardController {

	private static final Logger LOG = Logger.getLogger(DashboardController.class);

	@Autowired
	UserService userService;

	@Autowired
	PicsService picsService;

	@RequestMapping(value = "/dashboard")
	protected String getAllPics(Model model) throws Exception {
		LOG.info(" LOG User Dashboard ");
		User u = SecurityLibrary.getLoggedInUser();
		LOG.info("Email Id :" + u.getEmailId());
		List<PictureUploadPojo> picsList = picsService.findAllPics(1);
		model.addAttribute("picsList", picsList);
		return "dashboard";
	}

	@RequestMapping(value = "/dashboardPagination/{page}")
	protected String getAllPicsPagination(@PathVariable("page") int pageNo, Model model) throws Exception {
		LOG.info(" LOG User Dashboard ");
		User u = SecurityLibrary.getLoggedInUser();
		LOG.info("Email Id :" + u.getEmailId());
		List<PictureUploadPojo> picsList = picsService.findAllPics(pageNo);
		model.addAttribute("picsList", picsList);

		int rem = pageNo % 4;
		rem = 4 - rem;
		if (rem != 0) {
			pageNo = pageNo + rem;
		}
		model.addAttribute("pageNo", pageNo);
		return "dashboard";
	}

	@RequestMapping(value = "/newUserPassword", method = RequestMethod.GET)
	public String forgetPassword() {
		return "newUserPassword";
	}

	@RequestMapping(value = "/changeNewPassword", method = RequestMethod.POST)
	public String changeNewPassword(@RequestParam String oldPassword, @RequestParam String newPassword,
			@RequestParam String confirmPassword, Model model) {
		try {
			LOG.info("changeNewPassword : " + SecurityLibrary.getLoggedInUser().getId());
			LOG.info("oldPassword : " + oldPassword + " newPassword : " + oldPassword + " confirmPassword :"
					+ confirmPassword);
			User userDetails = userService.findUserById(SecurityLibrary.getLoggedInUser().getId());
			LOG.info("User Password :" + userDetails.getPassword());
			if (userDetails.getPassword().trim().equals(oldPassword.trim())) {
				LOG.info("  Both Equal ");
				if (!(newPassword.trim().equals(confirmPassword.trim()))) {
					LOG.info(" Same Password ");
					model.addAttribute("error", "New password And Confirm Password Must Be Same");
					return "newUserPassword";
				} else {
					userDetails.setPassword(confirmPassword);
					userService.updateUserDetails(userDetails);
					model.addAttribute("success", "Your password has been Changed Successfully .");
					return "dashboard";
				}
			}
		} catch (Exception e) {
			LOG.error("Error Changing user Password");
			e.printStackTrace();
		}
		model.addAttribute("error", "Your entered Old Password Is Incorrect");
		return "newUserPassword";
	}

}
