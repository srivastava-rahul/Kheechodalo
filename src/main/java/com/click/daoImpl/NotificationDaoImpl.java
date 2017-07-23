/**
 * 
 */
package com.click.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.click.dao.NotificationDao;
import com.click.entity.Notification;

/**
 * @author rahul
 */
@Repository
public class NotificationDaoImpl implements NotificationDao {

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	@Override
	public void saveNotification(Notification notify) {
		System.out.println("Notification dao :" + notify.toLogString());
		entityManager.merge(notify);
		
	}

	@Override
	public List<Notification> getNotification() {
		Query query = entityManager.createQuery("from Notification");
		return (List<Notification>) query.getResultList();
		
	}

	@Override
	public void deleteNotification(Notification notify) {
		System.out.println("Notification dao :" + notify.toLogString());
		entityManager.remove(notify.getId());
	}



	

}
