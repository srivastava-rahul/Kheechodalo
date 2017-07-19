/**
 * 
 */
package com.click.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.AdminGetUserInfoDao;
import com.click.entity.ProfileSetting;
import com.click.entity.User;
import com.click.entity.UserPrize;
import com.click.service.AdminGetUserInfoService;

/**
 * @author vipul
 */

@Component
@Transactional(readOnly = true)
public class AdminGetUserInfoServiceImpl implements AdminGetUserInfoService {

    @Autowired
    AdminGetUserInfoDao adminGetUserInfoDao;  

	@Override
	public List<User> getAllUserInfo() {
		List<User> userinfo = adminGetUserInfoDao.getAllUserInfo();
		return userinfo;
	}

	@Override
	public User getUserInfoByEmailId(String email_id) {
		User userdata = adminGetUserInfoDao.getlUserInfoByEmailId(email_id);
		return userdata;
	}

	@Override
	public ProfileSetting getProfileInfoByEmailId(String email_id) {
		ProfileSetting profiledata = adminGetUserInfoDao.getProfileInfoByEmailId(email_id);
		return profiledata;
	}

	

	

}
