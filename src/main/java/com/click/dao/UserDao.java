package com.click.dao;

import com.click.entity.User;

public interface UserDao {
	/**
	 * @param userId
	 * @return user
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
	 * @param id
	 */
	public void activateUser(String id);

	public User findByEmailId(String email);

	public void updateUser(User userDetails);
}
