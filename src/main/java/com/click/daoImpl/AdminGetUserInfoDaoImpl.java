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
public class AdminGetUserInfoDaoImpl implements AdminGetUserInfoDao {

	private static final Logger LOG = Logger.getLogger(AdminGetUserInfoDaoImpl.class);

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	
	/**
	 * Getting List Of All User
	 * @param 
	 * @return  List of All User
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUserInfo() {
		LOG.info(" Inside Get getAllUserInfo() DaoImpl All User Infomation ");
		Query query = null;
		try {
			query = entityManager.createQuery("from User where isAdmin = 0");
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return (List<User>) query.getResultList();
	}

	/**
	 * Getting Information of User by passing email Id
	 * @param email- id of user
	 * @return Single User info based on email_id
	 */
	@Override
	public User getlUserInfoByEmailId(String email_id) {
		LOG.info(" Inside getlUserInfoByEmailId() DaoImpl   Get   User Infomation by Email-Id");
		Query query = null;
		try {
			query = entityManager.createQuery("from User u where u.emailId = :EMAIL_Id").setParameter("EMAIL_Id",
					email_id);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return (User) query.getSingleResult();
	}


	/**
	 * Getting Information of User Profile by passing email Id
	 * @param email- id of user
	 * @return Single User profile info based on email_id
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ProfileSetting getProfileInfoByEmailId(String email_id) {
		LOG.info("Inside DaoImpl User profile Infomation by Email-Id :" + email_id);
		Query query = null;
		try {
			query = entityManager.createQuery("from ProfileSetting  p where (upper(p.email_id) like :EMAIL_Id)");
			query.setParameter("EMAIL_Id", "%" + email_id + "%");
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		LOG.info(" ProfileSetting Size For Admin : " + query.getResultList().size());
		List<ProfileSetting> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	 /**
	  * Function to count total user of the application
	  * @return user count to admin dashboard
	  */
	@Override
	public int countAllTotalUser() {
		Query query = null;
		try {
			query = entityManager.createQuery("select count(u) from User u where isAdmin = false)");
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		Object obj = (Number) query.getSingleResult();
		return obj != null ? ((Number) obj).intValue() : 0;
	}

}
