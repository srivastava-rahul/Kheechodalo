package com.click.controller;

import java.util.HashMap;

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
@RequestMapping(path="/user")
public class ProfileSettingsController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/getProfileSettings", method = RequestMethod.GET)
	public String getUser() {
		/*try {
			User user = userService.findUserById(userId);
			System.out.println("user object :" + user.toLogString());
			model.addAttribute("user", user);
		} catch (Exception e) {
			System.out.println("Error getUser");
			e.printStackTrace();
		}*/
		return "settings";
	}

	
}
