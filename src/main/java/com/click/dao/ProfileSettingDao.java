package com.click.dao;

import java.util.List;

import com.click.entity.ProfileSetting;

public interface ProfileSettingDao {

	

	ProfileSetting findById(String userId);
	
	ProfileSetting findByEmailId(String emailId);

	ProfileSetting updateUserProfile(ProfileSetting userprofileDetails);
	
	List<ProfileSetting> findByEmailAndName(String emailIdAndName);

	ProfileSetting findUserProfileByEmailId(String emailId);

}
