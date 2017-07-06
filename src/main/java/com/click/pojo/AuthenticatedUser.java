package com.click.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.click.entity.User;

public class AuthenticatedUser extends User implements UserDetails {

	private static final long serialVersionUID = -725429104108486873L;

	private List<String> grantedAuthorities = new ArrayList<String>();

	private boolean passwordExpired;

	private Boolean isAdmin = Boolean.FALSE;

	/**
	 * @param user
	 *            the authenticated user instance
	 */
	public AuthenticatedUser(User user) {
		try {
			this.setId(user.getId());
			this.setPassword(user.getPassword());
			this.setEmailId(user.getEmailId());

			if (user.getUserRole() != null) {
				setUserRole(user.getUserRole());
				if (user.getUserRole().getRoleName() != null) {
					grantedAuthorities.add(user.getUserRole().getRoleName());
					if (user.getUserRole().getRoleName().equals("ROLE_ADMIN")) {
						this.isAdmin = Boolean.TRUE;
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		for (String role : grantedAuthorities) {
			list.add(new SimpleGrantedAuthority(role));
		}
		return list;
	}

	/*@Override
	public String getEmailId() {
		return this.getEmailId();
	}
*/
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public List<String> getGrantedAuthorities() {
		return grantedAuthorities;
	}

	public void setGrantedAuthorities(List<String> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}

	public boolean isPasswordExpired() {
		return passwordExpired;
	}

	public void setPasswordExpired(boolean passwordExpired) {
		this.passwordExpired = passwordExpired;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String getUsername() {
		return this.getFirstName();
	}

}
