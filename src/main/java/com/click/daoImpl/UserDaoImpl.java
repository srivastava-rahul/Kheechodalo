package com.click.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.click.dao.UserDao;
import com.click.entity.User;
import com.click.enums.Status;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	@Override
	public User findById(String userId) {
		System.out.println("user dao :" + userId);
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
		System.out.println("user dao :" + emailId);
		Query query = entityManager.createQuery("from User u where upper(u.emailId) = :emailId").setParameter("emailId", emailId);
		return (User) query.getSingleResult();
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
		Query query = entityManager.createQuery("from User u where upper(u.emailId) = :emailId").setParameter("emailId", email);
		return (User) query.getSingleResult();
	}

	@Override
	public void updateUser(User userDetails) {
		System.out.println("user dao :" + userDetails.toLogString());
		entityManager.merge(userDetails);
	}

}
