package com.click.dao;

import com.click.entity.ProfileSetting;

public interface ProfileSettingDao {

	

	ProfileSetting findById(String userId);
	
	ProfileSetting findByEmailId(String emailId);

	ProfileSetting updateUserProfile(ProfileSetting userprofileDetails);

}
