/**
 * 
 */
package com.click.serviceImpl;

import org.apache.log4j.Logger;
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

	private static Logger LOG = Logger.getLogger(CustomUserDetailsService.class);

	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		if (userName.length() == 0)
			throw new UsernameNotFoundException("Invalid username of password specified. Bad credentials.");

		AuthenticatedUser authenticatedUser = null;
		System.out.println("0");
		User user = userDao.findUserByName(userName.toUpperCase());
		LOG.info(" authenticatedUser dsadawd:" + user);
		System.out.println("1");
		if (user == null) {
			LOG.info(" dadsdsasdad dsadad authenticatedUser :" + user);
			System.out.println("fdsfdsfs");
			throw new UsernameNotFoundException("Invalid username of password specified. Bad credentials.");
		}
		LOG.info(" authenticatedUser :" + user.toLogString());
		user = userDao.findById(user.getId());
		LOG.info(" user===== :" + user.toLogString());
		if (user != null) {
			authenticatedUser = new AuthenticatedUser(user);
		}
		return authenticatedUser;
	}

}
