package com.click.controller;

import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.click.entity.ProfileSetting;
import com.click.entity.User;
import com.click.entity.UserRole;
import com.click.service.AdminGetUserInfoService;
import com.click.service.ProfileSettingService;
import com.click.service.SendMailService;
import com.click.service.UserService;
import com.click.utils.Global;
import com.click.utils.StringUtils;

@Controller
public class UserController {

	private static final Logger LOG = Logger.getLogger(UserController.class);

	@Value("${app.url}")
	String APP_URL;

	@Autowired
	SendMailService sendMailService;

	@Autowired
	UserService userService;

	@Autowired
	AdminGetUserInfoService adminGetUserInfoService;

	@Autowired
	ProfileSettingService profileSettingService;

	/**
	 * Get user information to land him to the user panel
	 * 
	 * @param userId
	 * @param model
	 * @return to user page
	 */
	@RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
	public String getUser(@PathVariable String userId, Model model) {
		LOG.info("Fetching the data based on email_id from getUser controller");
		try {
			User user = userService.findUserById(userId);
			System.out.println("user object :" + user.toLogString());
			model.addAttribute("user", user);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return "user";
	}

	/**
	 * View user
	 * 
	 * @param model
	 * @return to user page
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String viewUser(Model model) {
		LOG.info("view user information from viewUser controller");
		try {
			System.out.println("view user");
			User user = new User();
			model.addAttribute("user", user);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return "user";
	}

	/**
	 * Save user singup data
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param model
	 * @return to login page
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam String password, Model model, RedirectAttributes redir) {
		LOG.info("Inside saveUser controller");

		//System.out.println("helllllooooooooooo" + firstName + "" + lastName + "" + email + "" + password);
		String str = null;
		if (firstName.equals(null) || firstName.equals("") || lastName.equals(null) || lastName.equals("")
				|| email.equals(null) || email.equals("") || password.equals(null) || password.equals("")) {
			if (firstName.equals(null) || firstName.equals("") || lastName.equals(null) || lastName.equals("")) {
				str = "Please Provide Name...!";
			} else if (email.equals(null) || email.equals("")) {
				str = "Please Provide Email-Id...!";
			} else if (password.equals(null) || password.equals("")) {
				str = "Please Provide Password...!";
			}
			redir.addFlashAttribute("error", str);
			return "redirect:/login";
		} else {

			try {
				User userexit = userService.getUserDeatilsByEmailId(email);
				if (userexit != null) {
					redir.addFlashAttribute("error", "Email-id Already Exit...!");
					return "redirect:/login";
				}
				BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
				String pass = enc.encode(password);
				User user = new User();
				user.setFirstName(StringUtils.checkString(firstName));
				user.setLastName(StringUtils.checkString(lastName));
				user.setEmailId(StringUtils.checkString(email));
				user.setPassword(pass);
				user.setCreatedDate(new Date());
				user.setAdmin(false);
				UserRole role = new UserRole();
				role.setId("111");
				user.setUserRole(role);
				user.setStatus(true);
				user = userService.saveUser(user);

				/*sendRegistrationEmail(new String[] { user.getEmailId() }, user.getFirstName(), user.getId(),
						"Thanks For Registration");*/
				/*redir.addFlashAttribute("success", "Please Visit Your Email Id For Activation .");*/
				redir.addFlashAttribute("success", "Thanks For Registration Please Login to Activate Your Account.");
				LOG.info("user object :" + user.toLogString());
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
				e.printStackTrace();
				redir.addFlashAttribute("error", "Error Sending Mail.");
			}
			return "redirect:/login";
		}
	}

	/**
	 * Activating the user
	 * 
	 * @param id
	 * @param model
	 * @return to login page only
	 */
	@RequestMapping(value = "/activateUser/{id}", method = RequestMethod.GET)
	public String activateUser(@PathVariable String id, Model model) {
		LOG.info("Inside activateUser contoller ");
		try {
			userService.activateUser(id);
			model.addAttribute("success", "Your Account Activated Successfully .");
			LOG.info("user activated successfully");
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
			model.addAttribute("error", "Error While Activation.");

		}
		return "WEB-INF/views/jsp/login";
	}

	/**
	 * fetching the forgot password form
	 * 
	 * @return to forgetPassword page
	 */
	@RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
	public String forgetPassword() {
		LOG.info("Inside forgetPassword controller ");

		System.out.println(" forgetPassword() ");
		return "forgetPassword";
	}

	/**
	 * fetching the change password form based on id
	 * 
	 * @param id
	 * @param model
	 * @return to changePassword page
	 */
	@RequestMapping(value = "/changePassword/{id}", method = RequestMethod.GET)
	public String changePassword(@PathVariable String id, Model model) {
		LOG.info(" Inside  changePassword controller");
		model.addAttribute("id", id);
		return "changePassword";
	}

	/**
	 * recovering the password
	 * 
	 * @param email
	 * @param model
	 * @return to login page
	 */
	@RequestMapping(value = "/recoverPassword", method = RequestMethod.POST)
	public String recoverPassword(@RequestParam String email, @RequestParam long phone, Model model,
			RedirectAttributes redir) {
		LOG.info(" Inside recoverPassword controller " + email + " Phone :" + phone);
		try {
			User user = userService.getUserDeatilsByEmailId(email);
			if (user != null) {
				ProfileSetting profileSetting = profileSettingService.findByEmailId(email);
				if (profileSetting != null && profileSetting.getPhone() != 0 && profileSetting.getPhone() == phone) {
					LOG.info("Checking Phone No. Is same or different");
					return "redirect:/changePassword/" + user.getId();
				} else {
					redir.addFlashAttribute("error", "Your entered Phone Number is wrong");
					return "redirect:/login";
				}
			}else{
				redir.addFlashAttribute("error", "Account Does Not Exist ,please Sign Up first ");
				return "redirect:/login";
			}

			// sendForgrtPasswordEmail(new String[] { email },
			// user.getFirstName(), user.getId(),"Change Password Request");

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Newly recovery password
	 * 
	 * @param password
	 * @param id
	 * @return to login page
	 */
	@RequestMapping(value = "/newRecoverPassword", method = RequestMethod.POST)
	public String newRecoverPassword(@RequestParam String password, @RequestParam String id ,RedirectAttributes redir) {
		LOG.info(" newRecoverPassword() " + password);
		try {
			BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
			String forPass = enc.encode(password);
			User persistObject = userService.findUserById(id);
			LOG.info(" User FirstName :" + persistObject.getPassword());
			persistObject.setPassword(forPass);
			userService.updateUserDetails(persistObject);
			redir.addFlashAttribute("success", "Your password changed successfully");

		} catch (Exception e) {
			LOG.error("Error activate user");
			e.printStackTrace();
		}
		return "redirect:/login";
	}

	private void sendForgrtPasswordEmail(String[] mailTo, String userName, String id, String message) {
		String url = APP_URL;
		String subject = "Forgot Password";
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userName);
		map.put("message", message);
		map.put("loginUrl", url);
		map.put("appUrl", url + "/changePassword/" + id);
		sendMailService.sendEmailTemplate(mailTo, subject, map, Global.REGISTRATION_MAIL_TEMPLATE);
	}

	private void sendRegistrationEmail(String[] mailTo, String userName, String id, String message) {
		String url = APP_URL;
		String subject = "Registration";
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userName);
		map.put("message", message);
		map.put("loginUrl", url);
		map.put("appUrl", url + "/activateUser/" + id);
		sendMailService.sendEmailTemplate(mailTo, subject, map, Global.REGISTRATION_MAIL_TEMPLATE);
	}

}
