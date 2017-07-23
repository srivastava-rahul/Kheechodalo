/**
 * 
 */
package com.click.handler;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.click.dao.UserDao;
import com.click.entity.User;
import com.click.pojo.AuthenticatedUser;

/**
 * @author vipul
 */
@Component
public class AppAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private static Logger LOG = Logger.getLogger(AppAuthenticationSuccessHandler.class);

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	UserDao userDao;

	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {

		AuthenticatedUser user = (AuthenticatedUser) authentication.getPrincipal();

		User dbUser = userDao.findById(user.getId());

		LOG.info(" DbUser " + dbUser.toLogString());

		SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);

		LOG.info("Auth success request : " + (savedRequest == null ? null : savedRequest.getRedirectUrl()));
		String targetUrl = determineTargetUrl(authentication,(savedRequest == null ? null : savedRequest.getRedirectUrl()));

		if (response.isCommitted()) {
			LOG.warn("Response has already been committed. Unable to redirect to " + targetUrl);
			return;
		}
		LOG.info("Redirecting user to : " + targetUrl);
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(Authentication authentication, String originalRequestUrl) {
		LOG.info("Checking user type to redirect to respective dashboards...");
		try {
			boolean isAdmin = false;
			LOG.info(" isAdmin" + isAdmin);
			Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
			for (GrantedAuthority grantedAuthority : authorities) {
				LOG.info("Granted Access : " + grantedAuthority.getAuthority());
				if (grantedAuthority.getAuthority().equals("USER_ROLE")) {
				} else if (grantedAuthority.getAuthority().equals("USER_ADMIN")) {
					isAdmin = true;
				}
			}
			if (isAdmin) {
				LOG.info("User type is Super Admin!!!!");
			}

			AuthenticatedUser user = (AuthenticatedUser) authentication.getPrincipal();
			LOG.info(" User " + user);

			if (isAdmin) {
				LOG.info("User type is Admin.....");
				return originalRequestUrl != null ? originalRequestUrl : "/admin/adminDashboard";
			} else {
				return originalRequestUrl != null ? originalRequestUrl : "/user/dashboard";
			}
		} catch (Exception e) {
			LOG.error("Error while determining the target URL after login : " + e.getMessage(), e);
			throw new IllegalStateException();
		}
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao
	 *            the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
