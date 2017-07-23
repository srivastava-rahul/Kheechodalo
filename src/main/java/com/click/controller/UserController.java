package com.click.controller;

import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.entity.User;
import com.click.entity.UserRole;
import com.click.service.SendMailService;
import com.click.service.UserService;
import com.click.utils.Global;

@Controller
public class UserController {
	
	private static final Logger LOG = Logger.getLogger(UserController.class);
	
	@Value("${app.url}")
	String APP_URL;

	@Autowired
	SendMailService sendMailService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
	public String getUser(@PathVariable String userId, Model model) {
		try {
			User user = userService.findUserById(userId);
			System.out.println("user object :" + user.toLogString());
			model.addAttribute("user", user);
		} catch (Exception e) {
			System.out.println("Error getUser");
			e.printStackTrace();
		}
		return "user";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String viewUser(Model model) {
		try {
            LOG.info("view user");
			System.out.println("view user");
			User user = new User();
			model.addAttribute("user", user);
		} catch (Exception e) {
			System.out.println("Error viewUser");
			e.printStackTrace();
		}
		return "user";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam String password ,Model model) {
		try {
			System.out.println("first name -" + firstName + "lastName- " + lastName + "email -" + email + "password -" + password);
			
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmailId(email);
			user.setPassword(password);
			user.setCreatedDate(new Date());
			UserRole role = new UserRole();
			role.setId("111");
			user.setUserRole(role);
			user = userService.saveUser(user);
			sendRegistrationEmail(new String[] { user.getEmailId() }, user.getFirstName(), user.getId(),"Thanks For Registration");
			model.addAttribute("success", "Please Visit Your Email Id For Activation .");
			LOG.info("user object :" + user.toLogString());
		} catch (Exception e) {
      		LOG.info("Error saveUser"+e.getMessage(),e);
      		model.addAttribute("error", "Error Sending Mail.");
		}
		return "WEB-INF/views/jsp/login";
	}

	@RequestMapping(value = "/activateUser/{id}", method = RequestMethod.GET)
	public String activateUser(@PathVariable String id,Model model) {
		try {
			userService.activateUser(id);
			model.addAttribute("success", "Your Account Activated Successfully .");
			LOG.info("user activated successfully");
		} catch (Exception e) {
			LOG.error("Error activate user");
			model.addAttribute("error", "Error While Activation.");
			e.printStackTrace();
		}
		return "WEB-INF/views/jsp/login";
	}
	
	
	@RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
	public String forgetPassword() {
		LOG.info("view user");
		System.out.println(" forgetPassword() ");
		return "forgetPassword";
	}
	
	

	@RequestMapping(value = "/changePassword/{id}", method = RequestMethod.GET)
	public String changePassword() {
	    LOG.info(" changePassword() LOGGER");
		System.out.println(" changePassword() ");
		
		return "changePassword";
	}

	
	@RequestMapping(value = "/recoverPassword", method = RequestMethod.POST)
	public String recoverPassword(@RequestParam String email,Model model) {
		System.out.println(" recoverPassword() " +email);
		try {
			User user = userService.getUserDeatilsByEmailId(email);
			System.out.println(" User FirstName :"+user.getFirstName());
			sendForgrtPasswordEmail(new String[] { email }, user.getFirstName(), user.getId() ,"Change Password Request");	
			model.addAttribute("success", "Recovery mail send to your Registered E-mail Id");
			} 
		catch (Exception e) {
			System.out.println("Error activate user");
			e.printStackTrace();
		}
		return "login";
	}
	
	/*@RequestMapping(value = "/newRecoverPassword", method = RequestMethod.POST)
	public String newRecoverPassword(@RequestParam String password) {
		System.out.println(" newRecoverPassword() " +password);
		try {
			User persistObject = userService.findUserById(id);
			System.out.println(" User FirstName :"+persistObject.getPassword());
			persistObject.setPassword(password);
			
			//userService
			} 
		catch (Exception e) {
			System.out.println("Error activate user");
			e.printStackTrace();
		}
		return "login";
	}
	*/
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
