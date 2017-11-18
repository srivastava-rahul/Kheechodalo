package com.click.handler;

/**
 * 
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.click.dao.UserDao;

/**
 * @author Vipul
 *
 */
@Component
public class AppAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private static final Logger log = Logger.getLogger(AppAuthenticationFailureHandler.class);

	@Autowired
	UserDao userDao;

	@Autowired
	private UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.
	 * AuthenticationFailureHandler#onAuthenticationFailure(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.core.AuthenticationException)
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		HttpSession session = request.getSession(false);

		if (session != null) {
			log.info("sdsdsdsdsdsddsssds");
			request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
		}

		// Get the authenticated principle
		// String loginId = (String)
		// exception.getAuthentication().getPrincipal();

		String usernameParameter = usernamePasswordAuthenticationFilter.getUsernameParameter();
		String loginId = request.getParameter(usernameParameter);

		log.warn("AUTH FAILURE HANDLER for user : " + loginId + " - " + exception.getMessage());
		if(exception.getMessage().equalsIgnoreCase("Bad credentials") ){
		request.getSession().setAttribute("error", "UserName Password Entered is incorrect");
		}else{
			request.getSession().setAttribute("error", "");
		}
		
		new DefaultRedirectStrategy().sendRedirect(request, response, "/login?error=true");
	}

}