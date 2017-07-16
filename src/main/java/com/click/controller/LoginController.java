package com.click.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.click.entity.User;
import com.click.pojo.AuthenticatedUser;
import com.click.utils.SecurityLibrary;


@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = { RequestMethod.GET})
	protected String showLogin(Model model) {
		System.out.println("Login called");
		return "WEB-INF/views/jsp/login";
	}
	@RequestMapping(value = "/login", method = { RequestMethod.POST})
	protected String showDashboard(Model model) {
		System.out.println("Login post called");
		return "redirect:/user/dashboard";
	}

	 
	@RequestMapping(value = "/buyer", method = { RequestMethod.GET })
	protected String showBuyer() {
		try {

			Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
			User user = (User) currentUser.getPrincipal();
			System.out.println("currentUser.getPrincipal() :" + currentUser.getPrincipal());
			System.out.println("authorties :" + currentUser.getAuthorities().toString());
			System.out.println("currentUser.getName() :" + currentUser.getName());
			System.out.println("currentUser.getClass() :" + currentUser.getClass());
			System.out.println("currentUser.getCredentials() :" + currentUser.getCredentials());
			System.out.println("currentUser.getDetails() :" + currentUser.getDetails());
			System.out.println("Buyer called" + user.getEmailId() + "== pass == " + user.getPassword());
			System.out.println("Buyer called" + SecurityLibrary.getLoggedInUser().toLogString());
			System.out.println();
			System.out.println();
			AuthenticatedUser authenticatedUser = (AuthenticatedUser) currentUser.getPrincipal();
			System.out.println("suthenticated user is Admin :" + authenticatedUser.getIsAdmin());
			System.out.println("suthenticated user :" + authenticatedUser.getGrantedAuthorities());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "home";
	}

	@RequestMapping(value = "/supplier", method = { RequestMethod.GET })
	protected String showSupplier() {
		try {
			System.out.println("Supplier called" + SecurityLibrary.getLoggedInUser().toLogString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "home";
	}

	@RequestMapping(value = "/admin", method = { RequestMethod.GET })
	protected String showAdmin() {
		try {
			System.out.println("Admin called" + SecurityLibrary.getLoggedInUser().toLogString());
			Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
			AuthenticatedUser authenticatedUser = (AuthenticatedUser) currentUser.getPrincipal();
			System.out.println("suthenticated user is Admin :" + authenticatedUser.getIsAdmin());
			System.out.println("suthenticated user :" + authenticatedUser.getGrantedAuthorities());
			System.out.println("suthenticated user :" + authenticatedUser.getAuthorities().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "home";
	}
}
