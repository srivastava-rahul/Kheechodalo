package com.click.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.click.dao.ProfileSettingDao;
import com.click.entity.ProfileSetting;

@Repository
public class ProfileSettingDaoImpl implements ProfileSettingDao {
	
	private static final Logger LOG = Logger.getLogger(ProfileSettingDao.class);

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	@Override
	public ProfileSetting findById(String userId) {
		
		LOG.info("Inside findById() DaoImpl"); 
		Query query=null;
		try{
		      query = entityManager.createQuery("from ProfileSetting p where p.id = :Id").setParameter("Id", userId);
		   }catch(Exception e){
             LOG.error(e.getMessage(),e);
			  e.printStackTrace();
		   }
		return (ProfileSetting) query.getSingleResult();
	}

/*	@Override
	public User saveUser(User user) {
		System.out.println("user dao :" + user.toLogString());
		return entityManager.merge(user);
	}*/


    @Override
	public ProfileSetting updateUserProfile(ProfileSetting userprofileDetails) {
    	LOG.info("Inside updateUserProfile() DaoImpl");
		return entityManager.merge(userprofileDetails);
	}

	@Override
	public ProfileSetting findByEmailId(String emailId) {
		LOG.info("Inside findByEmailId() DaoImpl");
		ProfileSetting profSet = null;
		try {
			Query query = entityManager.createQuery("from ProfileSetting p where p.email_id = :emailId").setParameter("emailId", emailId);
			 profSet = (ProfileSetting) query.getSingleResult();
		} catch (NoResultException e) {
			 LOG.error(e.getMessage(),e);
			  e.printStackTrace();
		}
		return profSet;
}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProfileSetting> findByEmailAndName(String emailIdAndName) {
		LOG.info("Inside findByEmailAndName() DaoImpl"+emailIdAndName);
		Query query=null;
	/*	try{*/
		     query = entityManager.createQuery("from ProfileSetting p where (upper(p.email_id) like :emailIdAndName) or (upper(p.name_surname) like :emailIdAndName)");
		     query.setParameter("emailIdAndName","%"+emailIdAndName.toUpperCase()+"%" );
		 //  }
		     /*catch(Exception e){
           LOG.error(e.getMessage(),e);
			  e.printStackTrace();
		   }*/
        
        List<ProfileSetting> list = query.getResultList();
        LOG.info(" REsult :"+list.size());
		return  list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ProfileSetting findUserProfileByEmailId(String emailId) {
		LOG.info("Inside findUserProfileByEmailId() DaoImpl");
		ProfileSetting profSet = null;
		try {
			Query query = entityManager.createQuery("from ProfileSetting p where (upper(p.email_id) like  :emailId)");
			query.setParameter("emailId","%"+ emailId+"%");
			List<ProfileSetting> list = query.getResultList();
			if(list.isEmpty()){
				return null;
			}else{
				return list.get(0);
			}
		} catch (NoResultException e) {
			 LOG.error(e.getMessage(),e);
			  e.printStackTrace();
		}
		return profSet;
}

}
