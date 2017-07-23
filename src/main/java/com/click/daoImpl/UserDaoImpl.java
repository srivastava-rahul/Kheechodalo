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
		LOG.info("user dao :" + userId);
		Query query = entityManager.createQuery("from User u where u.id = :Id").setParameter("Id", userId);
		return (User) query.getSingleResult();
	}

	@Override
	public User saveUser(User user) {
		System.out.println("user dao :" + user.toLogString());
		return entityManager.merge(user);
	}

	@Override
	public User findUserByName(String emailId) {
		LOG.info("user dao email :" + emailId);
		Query query = entityManager.createQuery("from User u where upper(u.emailId) = :emailId").setParameter("emailId",emailId);
		User user = (User) query.getSingleResult();
		LOG.info("user :" + user.toLogString());
		return user;
	}

	@Override
	public void activateUser(String id) {
		Query query = entityManager.createQuery("update User u set u.status = :status where u.id = :id");
		query.setParameter("status", true);
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public User findByEmailId(String email) {
		Query query = entityManager.createQuery("from User u where upper(u.emailId) = :emailId").setParameter("emailId",
				email);
		return (User) query.getSingleResult();
	}

	@Override
	public void updateUser(User userDetails) {
		System.out.println("user dao :" + userDetails.toLogString());
		entityManager.merge(userDetails);
	}

}
