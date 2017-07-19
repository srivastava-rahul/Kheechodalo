package com.click.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.click.dao.AdminGetUserInfoDao;
import com.click.entity.ProfileSetting;
import com.click.entity.User;

/**
 * @author rahul
 */
@Repository
public class AdminGetUserInfoDaoImpl implements AdminGetUserInfoDao{

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUserInfo() {
		System.out.println(" Get  All User Infomation ");
		Query query = entityManager.createQuery("from User");
		return (List<User>) query.getResultList();
	}

	@Override
	public User getlUserInfoByEmailId(String email_id) {
		System.out.println(" Get   User Infomation by Email-Id");		
		Query query = entityManager.createQuery("from User u where u.emailId = :EMAIL_Id").setParameter("EMAIL_Id", email_id);
		return (User) query.getSingleResult();
	}

	@Override
	public ProfileSetting getProfileInfoByEmailId(String email_id) {
		System.out.println(" Get   User profile Infomation by Email-Id");		
		Query query = entityManager.createQuery("from ProfileSetting  p where p.email_id = :EMAIL_Id").setParameter("EMAIL_Id", email_id);
		return (ProfileSetting ) query.getSingleResult();
	}
	


}
