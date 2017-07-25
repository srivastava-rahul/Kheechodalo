/**
 * 
 */
package com.click.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.AdminGetUserInfoDao;
import com.click.entity.ProfileSetting;
import com.click.entity.User;
import com.click.service.AdminGetUserInfoService;

/**
 * @author vipul
 */

@Component
@Transactional(readOnly = true)
public class AdminGetUserInfoServiceImpl implements AdminGetUserInfoService {

	private static final Logger LOG = Logger.getLogger(AdminGetUserInfoServiceImpl.class);
	
    @Autowired
    AdminGetUserInfoDao adminGetUserInfoDao;  

	@Override
	public List<User> getAllUserInfo() {
		LOG.info("Inside  getAllUserInfo() serviceImpl");
		List<User> userinfo=null;
		try{
		    userinfo = adminGetUserInfoDao.getAllUserInfo();		
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return userinfo;
	}

	@Override
	public User getUserInfoByEmailId(String email_id) {
		LOG.info("Inside  getUserInfoByEmailId() serviceImpl");
		User userdata=null;
		try{
		 userdata = adminGetUserInfoDao.getlUserInfoByEmailId(email_id);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return userdata;
	}

	@Override
	public ProfileSetting getProfileInfoByEmailId(String email_id) {
		LOG.info("Inside  getProfileInfoByEmailId() serviceImpl");
		ProfileSetting profiledata=null;
		try{
		   profiledata = adminGetUserInfoDao.getProfileInfoByEmailId(email_id);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return profiledata;
	}

	

	

}
