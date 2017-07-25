package com.click.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.click.dao.AdminGetUserInfoDao;
import com.click.entity.ProfileSetting;
import com.click.entity.User;

/**
 * @author rahul
 */
@Repository
public class AdminGetUserInfoDaoImpl implements AdminGetUserInfoDao{
	
	private static final Logger LOG = Logger.getLogger(AdminGetUserInfoDaoImpl.class);

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUserInfo() {
		LOG.info(" Inside Get getAllUserInfo() DaoImpl All User Infomation ");
		Query query=null;
		try{
		 query = entityManager.createQuery("from User");
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return (List<User>) query.getResultList();
	}

	@Override
	public User getlUserInfoByEmailId(String email_id) {
		LOG.info(" Inside getlUserInfoByEmailId() DaoImpl   Get   User Infomation by Email-Id");
		Query query =null;
		try{
		 query = entityManager.createQuery("from User u where u.emailId = :EMAIL_Id").setParameter("EMAIL_Id", email_id);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return (User) query.getSingleResult();
	}

	@Override
	public ProfileSetting getProfileInfoByEmailId(String email_id) {
		LOG.info("Inside getProfileInfoByEmailId() DaoImpl Get   User profile Infomation by Email-Id");
		Query query=null;
		try{
		 query = entityManager.createQuery("from ProfileSetting  p where p.email_id = :EMAIL_Id").setParameter("EMAIL_Id", email_id);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return (ProfileSetting ) query.getSingleResult();
	}
	


}
