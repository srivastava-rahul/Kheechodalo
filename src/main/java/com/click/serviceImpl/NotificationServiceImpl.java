/**
 * 
 */
package com.click.serviceImpl;

import java.util.List;

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

    @Autowired
    NotificationDao notificationDao;
	
	@Override
	public void saveNotification(Notification notify) {		
		notificationDao.saveNotification(notify);
		
	}

	@Override
	public List<Notification> getNotification() {		
		List<Notification> listofNotification=notificationDao.getNotification();
		return listofNotification;
	}

	@Override
	public void deleteNotification(Notification notify) {
		notificationDao.deleteNotification(notify);
		
	}

}
