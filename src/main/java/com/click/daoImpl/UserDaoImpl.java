package com.click.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.click.dao.UserDao;
import com.click.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	@Override
	public User findById(String userId) {
		LOG.info("Inside findById() DaoImpl user dao ");
		Query query =null;
		try{
		     query = entityManager.createQuery("from User u where u.id = :Id").setParameter("Id", userId);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return (User) query.getSingleResult();
	}

	@Override
	public User saveUser(User user) {
		System.out.println("Inside saveUser() DaoImpl user dao ");
		return entityManager.merge(user);
	}

	@Override
	public User findUserByName(String emailId) {
		LOG.info("Inside findUserByName() DaoImpl user dao email ");
		Query query=null;
		User user=null;
		try{
		    query = entityManager.createQuery("from User u where upper(u.emailId) = :emailId").setParameter("emailId",emailId);
		    user = (User) query.getSingleResult();
		LOG.info("user :" + user.toLogString());
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void activateUser(String id) {
		LOG.info("Inside activateUser() DaoImpl user dao email ");
		try{
		Query query = entityManager.createQuery("update User u set u.status = :status where u.id = :id");
		query.setParameter("status", true);
		query.setParameter("id", id);
		query.executeUpdate();
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
	}

	@Override
	public User findByEmailId(String email) {
		LOG.info("Inside findByEmailId() DaoImpl user dao email ");
		Query query=null;
		try{
		    query = entityManager.createQuery("from User u where upper(u.emailId) = :emailId").setParameter("emailId",
				email);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return (User) query.getSingleResult();
	}

	@Override
	public void updateUser(User userDetails) {
		LOG.info("Inside updateUser() DaoImpl user dao email ");
		try{
	           entityManager.merge(userDetails);
		   }catch(Exception e){
			   LOG.error(e.getMessage(),e);
				e.printStackTrace();
		   }
	}

}
