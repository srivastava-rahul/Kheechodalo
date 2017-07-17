package com.click.controller;

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
			@RequestParam String password) {
		try {
			System.out.println("first name -" + firstName + "lastName- " + lastName + "email -" + email + "password -" + password);
			
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmailId(email);
			user.setPassword(password);
			UserRole role = new UserRole();
			role.setId("111");
			user.setUserRole(role);
			user = userService.saveUser(user);
			sendRegistrationEmail(new String[] { user.getEmailId() }, user.getFirstName(), user.getId(),"Thanks For Registration");
			System.out.println("user object :" + user.toLogString());
		} catch (Exception e) {
			System.out.println("Error saveUser");
			e.printStackTrace();
		}
		return "WEB-INF/views/jsp/login";
	}

	@RequestMapping(value = "/activateUser/{id}", method = RequestMethod.GET)
	public String activateUser(@PathVariable String id) {
		try {
			userService.activateUser(id);
			System.out.println("user activated successfully");
		} catch (Exception e) {
			System.out.println("Error activate user");
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
