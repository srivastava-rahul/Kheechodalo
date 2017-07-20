package com.click.dao;

import java.util.List;

import com.click.entity.QuickHelp;
import com.click.entity.UserFeedback;

/**
 * @author vipul
 */
public interface QuickHelpDao {

	/**
	 * Save the quick help (problem) data of user
	 * @param quickHelp
	 */
	void saveQuickHelp(QuickHelp quickHelp);

	/**
	 * Save the feedback data of user
	 * @param quickHelp
	 */
	void saveFeedback(UserFeedback feed);
	
	
	/**
	 * Get the quick help (problem) data For Admin
	 * @param quickHelp
	 */
	List<QuickHelp> getQuickHelpData();
	
	/**
	 * Get the feedback data for Admin
	 * @param quickHelp
	 */
	List<UserFeedback>  getFeedbackData();

	/**
	 * Delete the quick help (problem) data by Admin based on id
	 * @param quickHelp
	 */
	public void deleteQuickHelpData(QuickHelp quickhelp);
	
	/**
	 * Delete the feedback data by Admin based on id
	 * @param quickHelp
	 */
	public void deleteFeedbackData(UserFeedback userfeedback);
}
