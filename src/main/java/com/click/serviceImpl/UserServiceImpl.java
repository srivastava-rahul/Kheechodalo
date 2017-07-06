/**
 * 
 */
package com.click.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.UserDao;
import com.click.entity.User;
import com.click.service.UserService;

@Component
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public User findUserById(String userId) {
		System.out.println("user service :" + userId);
		return userDao.findById(userId);
	}

	@Override
	@Transactional(readOnly = false)
	public User saveUser(User user) {
		System.out.println("save user service");
		return userDao.saveUser(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void activateUser(String id) {
		userDao.activateUser(id);
	}

	@Override
	public User getUserDeatilsByEmailId(String email) {
		return userDao.findByEmailId(email);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateUserDetails(User userDetails) {
		userDao.updateUser(userDetails);

	}

}
