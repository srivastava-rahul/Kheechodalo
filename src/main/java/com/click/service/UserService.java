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
	 * Save user
	 * @param user
	 * @return newly saved user info
	 */
	User saveUser(User user);

	/**
	 * Activate user
	 * @param id
	 */
	public void activateUser(String id);

	/**
	 * Get user details based on email id
	 * @param email
	 * @return user info
	 */
	public User getUserDeatilsByEmailId(String email);

	public void updateUserDetails(User userDetails);
}
