/**
 * 
 */
package com.click.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.ProfileSettingDao;
import com.click.entity.ProfileSetting;
import com.click.service.ProfileSettingService;
import com.click.service.UserService;
import com.click.utils.StringUtils;

@Component
@Transactional(readOnly = true)
public class ProfileSettingServiceImpl implements ProfileSettingService {

	private static final Logger LOG = Logger.getLogger(ProfileSettingServiceImpl.class);
	
	@Autowired
	ProfileSettingDao profileSettingDao;

	@Autowired
	UserService userService;

	@Override
	@Transactional(readOnly = false)
	public ProfileSetting adduserprofiledata(ProfileSetting userprofiledata) {
		LOG.info("Inside  profile adduserprofiledata()  serviceImpl");
		ProfileSetting dbProfiledetails = null;

		if (StringUtils.checkString(userprofiledata.getId()).length() > 0) {

			dbProfiledetails = profileSettingDao.findById(userprofiledata.getId());

			if (StringUtils.checkString(userprofiledata.getName_surname()).length() > 0) {
				dbProfiledetails.setName_surname(userprofiledata.getName_surname());

			}
			if (userprofiledata.getDob() != null) {
				dbProfiledetails.setDob(userprofiledata.getDob());

			}

			if (userprofiledata.getPhone() >0 ) {
				dbProfiledetails.setPhone(userprofiledata.getPhone());
				dbProfiledetails.setPhone_flage(userprofiledata.isPhone_flage());

			}

			if (StringUtils.checkString(userprofiledata.getGender()).length() > 0) {
				dbProfiledetails.setGender(userprofiledata.getGender());

			}

			if (StringUtils.checkString(userprofiledata.getDaily_status()).length() > 0) {
				dbProfiledetails.setDaily_status(userprofiledata.getDaily_status());

			}
			if (StringUtils.checkString(userprofiledata.getNative_place()).length() > 0) {
				dbProfiledetails.setNative_place(userprofiledata.getNative_place());

			}
			if (StringUtils.checkString(userprofiledata.getLive_in()).length() > 0) {
				dbProfiledetails.setLive_in(userprofiledata.getLive_in());

			}
			if (StringUtils.checkString(userprofiledata.getCountry()).length() > 0) {
				dbProfiledetails.setCountry(userprofiledata.getCountry());

			}
			if (StringUtils.checkString(userprofiledata.getRelationship()).length() > 0) {
				dbProfiledetails.setRelationship(userprofiledata.getRelationship());

			}
			if (StringUtils.checkString(userprofiledata.getPost_graduration()).length() > 0) {
				dbProfiledetails.setPost_graduration(userprofiledata.getPost_graduration());

			}

			if (StringUtils.checkString(userprofiledata.getGraduration()).length() > 0) {
				dbProfiledetails.setGraduration(userprofiledata.getGraduration());

			}

			if (StringUtils.checkString(userprofiledata.getSecondary_school()).length() > 0) {
				dbProfiledetails.setSecondary_school(userprofiledata.getSecondary_school());

			}

			if (StringUtils.checkString(userprofiledata.getHigh_school()).length() > 0) {
				dbProfiledetails.setHigh_school(userprofiledata.getHigh_school());

			}
			if (StringUtils.checkString(userprofiledata.getWork_place()).length() > 0) {
				dbProfiledetails.setWork_place(userprofiledata.getWork_place());

			}
			if (StringUtils.checkString(userprofiledata.getWork_experience()).length() > 0) {
				dbProfiledetails.setWork_experience(userprofiledata.getWork_experience());

			}
			if (StringUtils.checkString(userprofiledata.getSkill()).length() > 0) {
				dbProfiledetails.setSkill(userprofiledata.getSkill());

			}
			if (StringUtils.checkString(userprofiledata.getBirth_place()).length() > 0) {
				dbProfiledetails.setBirth_place(userprofiledata.getBirth_place());

			}
			if (StringUtils.checkString(userprofiledata.getReligious_view()).length() > 0) {
				dbProfiledetails.setReligious_view(userprofiledata.getReligious_view());

			}
			if (StringUtils.checkString(userprofiledata.getPaytm()).length() > 0) {
				dbProfiledetails.setPaytm(userprofiledata.getPaytm());
				dbProfiledetails.setPaytm_flage(userprofiledata.isPaytm_flage());

			}
			if (StringUtils.checkString(userprofiledata.getAddress()).length() > 0) {
				dbProfiledetails.setAddress(userprofiledata.getAddress());
				dbProfiledetails.setAddress_flage(userprofiledata.isAddress_flage());

			}

			if (StringUtils.checkString(userprofiledata.getHobbies()).length() > 0) {
				dbProfiledetails.setHobbies(userprofiledata.getHobbies());

			}
			if (StringUtils.checkString(userprofiledata.getFavourite_food()).length() > 0) {
				dbProfiledetails.setFavourite_food(userprofiledata.getFavourite_food());

			}
			if (StringUtils.checkString(userprofiledata.getFavourite_singer()).length() > 0) {
				dbProfiledetails.setFavourite_singer(userprofiledata.getFavourite_singer());

			}
			if (StringUtils.checkString(userprofiledata.getFavourite_movies()).length() > 0) {
				dbProfiledetails.setFavourite_movies(userprofiledata.getFavourite_movies());

			}
			if (StringUtils.checkString(userprofiledata.getFavourite_daily_soap()).length() > 0) {
				dbProfiledetails.setFavourite_daily_soap(userprofiledata.getFavourite_daily_soap());

			}
			if (StringUtils.checkString(userprofiledata.getFavourite_author()).length() > 0) {
				dbProfiledetails.setFavourite_author(userprofiledata.getFavourite_author());

			}

			dbProfiledetails = profileSettingDao.updateUserProfile(dbProfiledetails);

		} else {

			StringUtils.checkString(userprofiledata.getName_surname());
			StringUtils.checkString(userprofiledata.getGender());
			StringUtils.checkString(userprofiledata.getDaily_status());
			StringUtils.checkString(userprofiledata.getNative_place());
			StringUtils.checkString(userprofiledata.getLive_in());
			StringUtils.checkString(userprofiledata.getCountry());
			StringUtils.checkString(userprofiledata.getRelationship());
			StringUtils.checkString(userprofiledata.getPost_graduration());
			StringUtils.checkString(userprofiledata.getGraduration());
			StringUtils.checkString(userprofiledata.getSecondary_school());
			StringUtils.checkString(userprofiledata.getHigh_school());
			StringUtils.checkString(userprofiledata.getWork_place());
			StringUtils.checkString(userprofiledata.getWork_experience());
			StringUtils.checkString(userprofiledata.getSkill());
			StringUtils.checkString(userprofiledata.getBirth_place());
			StringUtils.checkString(userprofiledata.getReligious_view());
			StringUtils.checkString(userprofiledata.getPaytm());
			StringUtils.checkString(userprofiledata.getAddress());
			StringUtils.checkString(userprofiledata.getHobbies());
			StringUtils.checkString(userprofiledata.getFavourite_food());
			StringUtils.checkString(userprofiledata.getFavourite_singer());
			StringUtils.checkString(userprofiledata.getFavourite_movies());
			StringUtils.checkString(userprofiledata.getFavourite_daily_soap());
			StringUtils.checkString(userprofiledata.getFavourite_author());
			dbProfiledetails = profileSettingDao.updateUserProfile(userprofiledata);
		}
		return dbProfiledetails;

	}

	@Override
	public ProfileSetting findByEmailId(String emailId) {
		LOG.info("Inside  profile findByEmailId()  serviceImpl");
		return profileSettingDao.findByEmailId(emailId);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateProfile(ProfileSetting profileSetting) {
		LOG.info("Inside  profile updateProfile()  serviceImpl");
		profileSettingDao.updateUserProfile(profileSetting);
	}

}
