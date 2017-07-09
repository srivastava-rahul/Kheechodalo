package com.click.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.click.dao.ProfileSettingDao;
import com.click.entity.ProfileSetting;

@Repository
public class ProfileSettingDaoImpl implements ProfileSettingDao {

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	@Override
	public ProfileSetting findById(String userId) {
		System.out.println("profile dao :" + userId);
		Query query = entityManager.createQuery("from ProfileSetting p where p.id = :Id").setParameter("Id", userId);
		return (ProfileSetting) query.getSingleResult();
	}

/*	@Override
	public User saveUser(User user) {
		System.out.println("user dao :" + user.toLogString());
		return entityManager.merge(user);
	}*/


    @Override
	public ProfileSetting updateUserProfile(ProfileSetting userprofileDetails) {
		System.out.println("user dao :" + userprofileDetails.toLogString());
		return entityManager.merge(userprofileDetails);
	}

	@Override
	public ProfileSetting findByEmailId(String emailId) {
		System.out.println("profile dao  emailId :" + emailId);
		ProfileSetting profSet = null;
		try {
			Query query = entityManager.createQuery("from ProfileSetting p where p.email_id = :emailId").setParameter("emailId", emailId);
			 profSet = (ProfileSetting) query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return profSet;
}


}
