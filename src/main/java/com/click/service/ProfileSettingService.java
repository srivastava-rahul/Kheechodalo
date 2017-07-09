package com.click.service;

import com.click.entity.ProfileSetting;

public interface ProfileSettingService {
	
	/**
	 * @param user profile data
	 * @param userprofiledata
	 * @param map
	 * @param template
	 */
	public ProfileSetting adduserprofiledata( ProfileSetting userprofiledata);

	/**
	 * @param emailId
	 * @return
	 */
	public ProfileSetting findByEmailId(String emailId);

}
