package com.click.service;

import java.util.List;

import com.click.entity.ProfileSetting;

public interface ProfileSettingService {

	/**
	 * Add user basic information
	 * @param user
	 * profile data
	 * @param userprofiledata
	 * @param map
	 * @param template
	 */
	public ProfileSetting adduserprofiledata(ProfileSetting userprofiledata);

	/**
	 * getting profile information of user based on emailId
	 * @param emailId
	 * @return profile information of user based on email id
	 */
	public ProfileSetting findByEmailId(String emailIdAndName);
	
	
	/**
	 * fetching information based on email id
	 * @param emailId
	 * @return list user profile information
	 */
	public List<ProfileSetting> findByEmailAndName(String emailId);

	/**
	 * save profile pic of user
	 * @param profileSetting
	 */
	public void updateProfile(ProfileSetting profileSetting);

	/**
	 * getting profile information of user to show other user based on email id
	 * @param emailId
	 * @return user profile information based on email id
	 */
	ProfileSetting findProfileByEmailId(String emailId);

}
