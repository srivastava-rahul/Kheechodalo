/**
 * 
 */
package com.click.service;

import java.util.List;

import com.click.entity.ProfileSetting;
import com.click.entity.User;

/**
 * @author rahul
 */

public interface AdminGetUserInfoService {

	
	 /**
	  * Get All User Information
	 * @return All User Data
	 */
	List<User> getAllUserInfo();
	
	/**
	 *Get Single User Information by passing the email id
	 * @return Single User Data
	 */
	User getUserInfoByEmailId(String email_id);
	
	
	/**
	 * Get Single User Profile  Information by passing the email id
	 * @return Single User Profile Data
	 */
	 ProfileSetting  getProfileInfoByEmailId(String email_id);

	 /**
	  * 
	  * @return
	  */
	int countAllTotalUser();

}
