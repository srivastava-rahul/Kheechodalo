package com.click.dao;

import java.util.List;

import com.click.entity.ProfileSetting;

public interface ProfileSettingDao {

	ProfileSetting findById(String userId);

	/**
	 * getting profile information of user based on emailId
	 * @param emailId
	 * @return profile information of user based on email id
	 */
	ProfileSetting findByEmailId(String emailId);

	/**
	 * updating basic information in user profile
	 * @param userprofileDetails
	 * @return basic information data
	 */
	ProfileSetting updateUserProfile(ProfileSetting userprofileDetails);

	/**
	 * fetching information based on email id
	 * @param emailId
	 * @return list user profile information
	 */
	List<ProfileSetting> findByEmailAndName(String emailIdAndName);

	/**
	 * getting profile information of user to show other user based on email id
	 * @param emailId
	 * @return user profile information based on email id
	 */
	ProfileSetting findUserProfileByEmailId(String emailId);

}
