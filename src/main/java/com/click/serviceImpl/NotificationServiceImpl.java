/**
 * 
 */
package com.click.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.NotificationDao;
import com.click.entity.Notification;
import com.click.service.NotificationService;

/**
 * @author rahul
 */

@Component
@Transactional(readOnly = true)
public class NotificationServiceImpl implements NotificationService {

	private static final Logger LOG = Logger.getLogger(NotificationServiceImpl.class);
	
    @Autowired
    NotificationDao notificationDao;
	
	@Override
	@Transactional(readOnly = false)
	public void saveNotification(Notification notify) {	
		
		LOG.info("Inside  saveNotification() serviceImpl "); 
		try{
		notificationDao.saveNotification(notify);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Notification> getNotification() {	
		LOG.info("Inside  getNotification() serviceImpl ");
		List<Notification> listofNotification=null;
		try{
		 listofNotification=notificationDao.getNotification();
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();	
		}
		
		return listofNotification;
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteNotification(Notification notify) {
		LOG.info("Inside  deleteNotification() serviceImpl ");
		try{
		notificationDao.deleteNotification(notify);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();	
		}
		
	}

}
