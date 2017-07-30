package com.click.utils;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.click.entity.User;
import com.click.pojo.AuthenticatedUser;

public class SecurityLibrary {

	// static Logger log = Logger.getLogger(SecurityLibrary.class);

	private static Set<String> parseAuthorities(String grantedRoles) {
		System.out.println(" parseAuthorities ");
		Set<String> parsedAuthorities = new TreeSet<String>();
		if (grantedRoles == null || grantedRoles.isEmpty()) {
			return parsedAuthorities;
		}

		String[] parsedAuthoritiesArr;
		if (grantedRoles.contains(",")) {
			parsedAuthoritiesArr = grantedRoles.split(",");
		} else {
			parsedAuthoritiesArr = new String[] { grantedRoles };
		}

		// adding authorities to set (could pssible be done better!)
		for (String auth : parsedAuthoritiesArr)
			parsedAuthorities.add(auth.trim());
		return parsedAuthorities;
	}

	@SuppressWarnings("unchecked")
	private static GrantedAuthority[] getUserAuthorities() {
		System.out.println(" GrantedAuthority[] getUserAuthorities() ");
		if (SecurityContextHolder.getContext() == null) {
			// //LOG.error("security context is empty, this seems to be a
			// bug/misconfiguration!");
			return new GrantedAuthority[0];
		}
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		if (currentUser == null)
			return new GrantedAuthority[0];

		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) currentUser.getAuthorities();
		if (authorities == null)
			return new GrantedAuthority[0];

		return authorities.toArray(new GrantedAuthority[] {});
	}

	/**
	 * Method that checks if the user holds <b>any</b> of the given roles.
	 * Returns <code>true, when the first match is found, <code>false</code> if
	 * no match is found and also <code>false</code> if no roles are given
	 * 
	 * @param grantedRoles
	 *            a comma seperated list of roles
	 * @return true if any of the given roles are granted to the current user,
	 *         false otherwise
	 */
	public static boolean ifAnyGranted(final String grantedRoles) {
		System.out.println(" ifAnyGranted ");
		Set<String> parsedAuthorities = parseAuthorities(grantedRoles);
		if (parsedAuthorities.isEmpty())
			return false;

		GrantedAuthority[] authorities = getUserAuthorities();

		for (GrantedAuthority authority : authorities) {
			if (parsedAuthorities.contains(authority.getAuthority()))
				return true;
		}
		return false;
	}

	/**
	 * Method that checks if the user holds <b>all</b> of the given roles.
	 * Returns <code>true</code>, iff the user holds all roles,
	 * <code>false</code> if no roles are given or the first non-matching role
	 * is found
	 * 
	 * @param requiredRoles
	 *            a comma seperated list of roles
	 * @return true if all of the given roles are granted to the current user,
	 *         false otherwise or if no roles are specified at all.
	 */
	public static boolean ifAllGranted(final String requiredRoles) {
		System.out.println("  ifAllGranted ");
		// parse required roles into list
		Set<String> requiredAuthorities = parseAuthorities(requiredRoles);
		if (requiredAuthorities.isEmpty())
			return false;

		// get granted roles
		GrantedAuthority[] authoritiesArray = getUserAuthorities();

		Set<String> grantedAuthorities = new TreeSet<String>();
		for (GrantedAuthority authority : authoritiesArray) {
			grantedAuthorities.add(authority.getAuthority());
		}

		// iterate over required roles,
		for (String requiredAuthority : requiredAuthorities) {
			// check if required role is inside granted roles
			// if not, return false
			if (!grantedAuthorities.contains(requiredAuthority)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Method that checks if <b>none</b> of the given roles is hold by the user.
	 * Returns <code>true</code> if no roles are given, or none of the given
	 * roles match the users roles. Returns <code>false</code> on the first
	 * matching role.
	 * 
	 * @param notGrantedRoles
	 *            a comma seperated list of roles
	 * @return true if none of the given roles is granted to the current user,
	 *         false otherwise
	 */
	public static boolean ifNotGranted(final String notGrantedRoles) {
		System.out.println(" ifNotGranted ");
		Set<String> parsedAuthorities = parseAuthorities(notGrantedRoles);
		if (parsedAuthorities.isEmpty())
			return true;

		GrantedAuthority[] authorities = getUserAuthorities();

		for (GrantedAuthority authority : authorities) {
			if (parsedAuthorities.contains(authority.getAuthority()))
				return false;
		}
		return true;
	}

	/**
	 * This method returns the login id of the logged-in user through spring
	 * security {@link SecurityContextHolder}
	 * 
	 * @return the Login Id of the logged in user or an empty string if
	 *         logged-in user could not be identified.
	 */
	public static String getLoggedInUserLoginId() {
		System.out.println(" getLoggedInUserLoginId() ");
		if (SecurityContextHolder.getContext() == null) {
			// //LOG.error("security context is empty, this seems to be a
			// bug/misconfiguration!");
			return "";
		}
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		if (currentUser == null)
			return "";

		if (currentUser instanceof UsernamePasswordAuthenticationToken) {
			AuthenticatedUser user = (AuthenticatedUser) currentUser.getPrincipal();
			if (user != null) {
				System.out.println("Logged In User : " + currentUser.getName() + "   -> " + user.getUsername());
				return user.getId();
			} else
				return "";
		} else
			return "";

	}
	
	public static String getLoggedInUserLoginEmailId() {
		System.out.println(" getLoggedInUserLoginEmailId() called ");
		if (SecurityContextHolder.getContext() == null) {
			// //LOG.error("security context is empty, this seems to be a
			// bug/misconfiguration!");
			return "";
		}
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		if (currentUser == null)
			return "";

		if (currentUser instanceof UsernamePasswordAuthenticationToken) {
			AuthenticatedUser user = (AuthenticatedUser) currentUser.getPrincipal();
			if (user != null) {
				System.out.println("Logged In User : " + currentUser.getName() + "   -> " + user.getUsername());
				return user.getEmailId();
			} else
				return "";
		} else
			return "";

	}

	/**
	 * This method returns the {@link User} instance of the logged-in user
	 * through spring security {@link SecurityContextHolder}
	 * 
	 * @return the {@link User} instance of the logged in user or an empty
	 *         string if logged-in user could not be identified.
	 */
	public static User getLoggedInUser() throws Exception {
		if (SecurityContextHolder.getContext() == null) {
			// //LOG.error("security context is empty, this seems to be a
			// bug/misconfiguration!");
			System.out.println("security context is empty, this seems to be a bug/misconfiguration!");
			// throw new SecurityRuntimeException();
		}
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		if (currentUser == null)
			System.out.println("current user is null");
		// throw new SecurityRuntimeException();

		if (currentUser instanceof UsernamePasswordAuthenticationToken) {
			User loggedInUser = new User();
			AuthenticatedUser user = (AuthenticatedUser) currentUser.getPrincipal();
			if (user != null) {
				System.out.println("Logged In User : " + currentUser.getName() + "  -> " + user.getEmailId());
				loggedInUser.setId(user.getId());
				loggedInUser.setEmailId(user.getEmailId());
				return loggedInUser;
			} else {
				System.out.println("else (user == null) ");
				 throw new Exception();
			}
		} else {
			System.out.println("else not instance of UsernamePasswordAuthenticationToken");
			 throw new Exception();
		}
	}

	public SecurityLibrary() {
	}
}
