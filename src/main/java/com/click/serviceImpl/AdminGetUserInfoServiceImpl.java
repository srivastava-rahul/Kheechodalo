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

    
    /**
	  * Get All User Information
	 * @return All User Data
	 */
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

	/**
	 *Get Single User Information by passing the email id
	 * @return Single User Data
	 */
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

	/**
	 * Get Single User Profile  Information by passing the email id
	 * @return Single User Profile Data
	 */
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

	 /**
	  * Function to count total user of the application
	  * @return user count to admin dashboard
	  */
	@Override
	public int countAllTotalUser() {
		LOG.info(" Count User ");
		int total = adminGetUserInfoDao.countAllTotalUser();
		return total;
	}

	

	

}
