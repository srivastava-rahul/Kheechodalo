/**
 * 
 */
package com.click.service;

import java.util.List;

import com.click.entity.QuickHelp;
import com.click.entity.UserFeedback;

/**
 * @author rahul
 */
public interface QuickHelpService {

	/**
	 * Save the quick help (problem) data of user
	 * @param quickHelp
	 */
	void saveQuickHelpData(QuickHelp quickHelp);

	/**
	 * Save the feedback data of user
	 * @param quickHelp
	 */
	void saveFeedbackData(UserFeedback feed);
	
	
	/**
	 * Get the quick help (problem) data For Admin
	 * @param quickHelp
	 */
	List<QuickHelp> getQuickHelpData();
	
	/**
	 * Get the feedback data for Admin
	 * @param quickHelp
	 */
	List<UserFeedback> getFeedbackData();

}
