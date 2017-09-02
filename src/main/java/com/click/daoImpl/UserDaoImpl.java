package com.click.daoImpl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.UserDao;
import com.click.entity.User;
import com.click.utils.CollectionUtil;

@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	/**
	 * finding user information  by email id
	 * @param userId
	 * @return user information
	 */
	@Override
	public User findById(String userId) {
		LOG.info("Inside findById() DaoImpl user dao ");
		Query query = null;
		try {
			query = entityManager.createQuery("from User u where u.id = :Id").setParameter("Id", userId);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
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
	@Transactional(propagation = Propagation.REQUIRED)
	public User saveDefaultAdmin(User adminDetail) {
		LOG.info("Inside saveUser() DaoImpl user dao ");
//		return entityManager.merge(adminDetail);
		this.entityManager.persist(adminDetail);
		return adminDetail;
	}

	
	@Override
	public User findUserByName(String emailId) {
		LOG.info("Inside findUserByName() DaoImpl user dao email ");
		Query query = null;
		User user = null;
		try {
			query = entityManager.createQuery("from User u where upper(u.emailId) = :emailId").setParameter("emailId",
					emailId);
			user = (User) query.getSingleResult();
			LOG.info("user :" + user.toLogString());
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * Activate user
	 * @param id
	 */
	@Override
	public void activateUser(String id) {
		LOG.info("Inside activateUser() DaoImpl user dao email ");
		try {
			Query query = entityManager.createQuery("update User u set u.status = :status where u.id = :id");
			query.setParameter("status", true);
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}

	
	/**
	 * Get user details based on email id
	 * @param email
	 * @return user info
	 */
	@SuppressWarnings("unchecked")
	@Override
	public User findByEmailId(String email) {
		LOG.info("Inside findByEmailId() DaoImpl user dao email ");
		Query query = null;
		try {
			query = entityManager.createQuery("from User u where upper(u.emailId) = :emailId");
			query.setParameter("emailId", email.toUpperCase());
			List<User> uList = query.getResultList();
			LOG.info(" ULIst : " + uList.size());
			if (CollectionUtil.isNotEmpty(uList)) {
				return uList.get(0);
			} else {
				return null;
			}
		} catch (NoResultException nr) {
			LOG.info("Error while getting user : " + nr.getMessage(), nr);
			return null;
		}
	}


	@Override
	public void updateUser(User userDetails) {
		LOG.info("Inside updateUser() DaoImpl user dao email ");
		try {
			entityManager.merge(userDetails);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}

	@Override
	public User findByProperty(String name, Object value) {
		try {
			return entityManager.createQuery(createQueryByProperty(name, value)).getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Class<User> returnEntityClass() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<User>) genericSuperclass.getActualTypeArguments()[0];
	}

	private CriteriaQuery<User> createQueryByProperty(String property, Object value) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(returnEntityClass());
		Root<User> root = cq.from(returnEntityClass());
		cq = cq.where(cb.equal(root.get(property), value));
		return cq;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findByUser(String email) {
		try {
			LOG.info(" Enail From Startup : "+email);
			final Query query = entityManager.createQuery("from User a where upper(a.emailId) =:emailId");
			query.setParameter("emailId", email.toUpperCase());
			List<User> uList = query.getResultList();
			LOG.info(" ULIst : "+uList.size());
			if (CollectionUtil.isNotEmpty(uList)) {
				return uList.get(0);
			} else {
				return null;
			}
		} catch (NoResultException nr) {
			LOG.info("Error while getting user : " + nr.getMessage(), nr);
			return null;
		}
	}

}
