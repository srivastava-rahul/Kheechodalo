package com.click.dao;

import com.click.entity.User;

public interface UserDao {
	/**
	 * finding user information  by email id
	 * @param userId
	 * @return user information
	 */
	public User findById(String userId);

	/**
	 * @param user
	 * @return
	 */
	User saveUser(User user);

	/**
	 * @param userId
	 * @return user
	 */
	public User findUserByName(String userName);

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
	public User findByEmailId(String email);

	public void updateUser(User userDetails);

	/**
	 * 
	 * @param string
	 * @param string2
	 * @return
	 */
	public User findByProperty(String name, Object value);

	/**
	 * 
	 * @param email
	 * @return
	 */
	public User findByUser(String email);

	/**
	 * 
	 * @param adminDetail
	 * @return
	 */
	User saveDefaultAdmin(User adminDetail);
}
