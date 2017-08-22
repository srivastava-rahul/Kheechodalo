package com.click.dao;

import java.util.List;

import com.click.entity.ProfileSetting;
import com.click.entity.User;

/**
 * @author rahul
 */

public interface AdminGetUserInfoDao {

	
	/**
	 * Getting List Of All User
	 * @param 
	 * @return  List of All User
	 */
	List<User> getAllUserInfo();
	
	
	/**
	 * Getting Information of User by passing email Id
	 * @param email- id of user
	 * @return Single User info based on email_id
	 */
	User getlUserInfoByEmailId(String email_id);
	
	
	
	/**
	 * Getting Information of User Profile by passing email Id
	 * @param email- id of user
	 * @return Single User profile info based on email_id
	 */
	ProfileSetting getProfileInfoByEmailId(String email_id);


	/**
	 * 
	 * @return
	 */
	int countAllTotalUser();

}
