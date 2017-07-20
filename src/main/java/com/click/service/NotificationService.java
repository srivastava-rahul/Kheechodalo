/**
 * 
 */
package com.click.service;

import java.util.List;

import com.click.entity.Notification;

/**
 * @author vipul
 */

public interface NotificationService {

	/**
	 * Save the notification by Admin
	 */
	public void saveNotification(Notification notify);
	
	
	/**
	 * Get List of the notification by Admin
	 */
	public List<Notification> getNotification();
	
	/**
	 * Delete Single notification by Admin  based on id 
	 */
	public void deleteNotification(Notification notify);
	
	

}
