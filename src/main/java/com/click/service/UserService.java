/**
 * 
 */
package com.click.service;

import com.click.entity.User;


public interface UserService {
	/**
	 * finding user information  by email id
	 * @param userId
	 * @return user information
	 */
	public User findUserById(String userId);

	/**
	 * @param user
	 * @return
	 */
	User saveUser(User user);

	/**
	 * @param id
	 */
	public void activateUser(String id);

	public User getUserDeatilsByEmailId(String email);

	public void updateUserDetails(User userDetails);
}
