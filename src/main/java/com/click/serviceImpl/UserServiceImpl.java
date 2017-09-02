/**
 * 
 */
package com.click.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.ProfileSettingDao;
import com.click.dao.UserDao;
import com.click.entity.ProfileSetting;
import com.click.entity.User;
import com.click.service.UserService;

@Component
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	UserDao userDao;

	@Autowired
	ProfileSettingDao profileSettingDao;

	/**
	 * finding user information  by email id
	 * @param userId
	 * @return user information
	 */
	@Override
	public User findUserById(String userId) {
		LOG.info("user service :" + userId);
		return userDao.findById(userId);
	}

	@Override
	@Transactional(readOnly = false)
	public User saveUser(User user) {
		LOG.info("Inside saveUser() serviceImpl");
		ProfileSetting pf = new ProfileSetting();
		pf.setName_surname(user.getFirstName());
		pf.setEmail_id(user.getEmailId());
		profileSettingDao.updateUserProfile(pf);

		return userDao.saveUser(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void activateUser(String id) {
		LOG.info("Inside activateUser() serviceImpl");
		try {
			userDao.activateUser(id);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}

	@Override
	public User getUserDeatilsByEmailId(String email) {
		LOG.info("Inside getUserDeatilsByEmailId() serviceImpl");
		return userDao.findByEmailId(email);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateUserDetails(User userDetails) {
		LOG.info("Inside updateUserDetails() serviceImpl");
		try {
			userDao.updateUser(userDetails);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}

	}

}
