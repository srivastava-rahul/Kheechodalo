/**
 * 
 */
package com.click.service;

import com.click.entity.User;


public interface UserService {
	/**
	 * @param userId
	 * @return
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
