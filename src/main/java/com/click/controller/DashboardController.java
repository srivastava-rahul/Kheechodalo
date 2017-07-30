package com.click.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		LOG.info(" LOG User Dashboard from getAllPics controlller ");
		User u = SecurityLibrary.getLoggedInUser();
		List<PictureUploadPojo> picsList = picsService.findAllPics(1);
		model.addAttribute("picsList", picsList);
		return "dashboard";
	}

	@RequestMapping(value = "/dashboardPagination/{page}")
	protected String getAllPicsPagination(@PathVariable("page") int pageNo, Model model) throws Exception {
		LOG.info(" LOG User Dashboard from getAllPicsPagination controller");
		User u = SecurityLibrary.getLoggedInUser();
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
		LOG.info("Inside changeNewPassword controller");
		try {
			User userDetails = userService.findUserById(SecurityLibrary.getLoggedInUser().getId());

			if (userDetails.getPassword().trim().equals(oldPassword.trim())) {
				LOG.debug("  Both Equal ");
				if (!(newPassword.trim().equals(confirmPassword.trim()))) {
					LOG.debug(" Same Password ");
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
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		model.addAttribute("error", "Your entered Old Password Is Incorrect");
		return "newUserPassword";
	}

	@RequestMapping(value = "/saveVote", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Long> saveUserVote(@RequestParam("picId") String picId) {
		LOG.info(" Inside save vote called pic Id : " + picId);
		long voteCount = 0;
		try {
			voteCount = picsService.updateVoteCount(picId, SecurityLibrary.getLoggedInUserLoginEmailId());
		} catch (Exception e) {
			LOG.error("Error While save Vote :" + e.getMessage(), e);
		}
		return new ResponseEntity<Long>(voteCount, HttpStatus.OK);
	}

}
