/**
 * 
 */
package com.click.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.click.dao.NotificationDao;
import com.click.entity.Notification;

/**
 * @author rahul
 */
@Repository
public class NotificationDaoImpl implements NotificationDao {

	private static final Logger LOG = Logger.getLogger(NotificationDaoImpl.class);
	
	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	@Override
	public void saveNotification(Notification notify) {
		LOG.info("Inside saveNotification() daoImpl ");
		try{
		entityManager.merge(notify);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Notification> getNotification() {
		LOG.info("Inside getNotification() daoImpl ");
		Query query=null;
		try{
		    query = entityManager.createQuery("from Notification");
		   }catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return (List<Notification>) query.getResultList();
		
	}

	@Override
	public void deleteNotification(Notification notify) {
		LOG.info("Inside deleteNotification() daoImpl ");
		try{
		entityManager.remove(notify.getId());
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();	
		}
	}



	

}
