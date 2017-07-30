package com.click.service;

import java.util.List;

import com.click.entity.ProfileSetting;

public interface ProfileSettingService {

	/**
	 * @param user
	 *            profile data
	 * @param userprofiledata
	 * @param map
	 * @param template
	 */
	public ProfileSetting adduserprofiledata(ProfileSetting userprofiledata);

	/**
	 * @param emailId
	 * @return
	 */
	public ProfileSetting findByEmailId(String emailIdAndName);
	
	
	/**
	 * @param emailId
	 * @return
	 */
	public List<ProfileSetting> findByEmailAndName(String emailId);

	/**
	 * 
	 * @param profileSetting
	 */
	public void updateProfile(ProfileSetting profileSetting);

	/**
	 * 
	 * @param emailId
	 * @return
	 */
	ProfileSetting findProfileByEmailId(String emailId);

}
