/**
 * 
 */
package com.click.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.UserDao;
import com.click.entity.User;
import com.click.pojo.AuthenticatedUser;

/**
 * @author parveen
 *
 */
@Service("customUserDetailsService")
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		if (userName.length() == 0)
			throw new UsernameNotFoundException("Invalid username of password specified. Bad credentials.");

		AuthenticatedUser authenticatedUser = null;
		User user = userDao.findUserByName(userName.toUpperCase());

		if (user == null)
			throw new UsernameNotFoundException("Invalid username of password specified. Bad credentials.");
		user = userDao.findById(user.getId());
		if (user != null) {
			authenticatedUser = new AuthenticatedUser(user);
		}
		return authenticatedUser;
	}
	

}
