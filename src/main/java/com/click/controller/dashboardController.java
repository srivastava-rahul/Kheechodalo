package com.click.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.User;
import com.click.service.UserService;
import com.click.utils.SecurityLibrary;

@Controller
@RequestMapping(value = "/user")
public class dashboardController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/dashboard")
	protected String getAllCourses(Model model) throws Exception {
		System.out.println("In user dashborad controller");
		User u = SecurityLibrary.getLoggedInUser();
		System.out.println(u.getEmailId());
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
			System.out.println("changeNewPassword : " + SecurityLibrary.getLoggedInUser().getId());
			System.out.println("oldPassword : " + oldPassword + " newPassword : " + oldPassword + " confirmPassword :"
					+ confirmPassword);
			User userDetails = userService.findUserById(SecurityLibrary.getLoggedInUser().getId());
			System.out.println("User Password :"+userDetails.getPassword());
			if (userDetails.getPassword().trim().equals(oldPassword.trim())) {
				System.out.println("  Both Equal ");
			if (!(newPassword.trim().equals(confirmPassword.trim()))) {
				System.out.println(" Same Password ");
				model.addAttribute("error", "New password And Confirm Password Must Be Same");
				return "newUserPassword";
			}else{
				userDetails.setPassword(confirmPassword);
				userService.updateUserDetails(userDetails);
				model.addAttribute("success", "Your password has been Changed Successfully .");
				return "dashboard";
			}
			}
		} catch (Exception e) {
			System.out.println("Error Changing user Password");
			e.printStackTrace();
		}
		model.addAttribute("error", "Your entered Old Password Is Incorrect");
		return "newUserPassword";
	}

}
