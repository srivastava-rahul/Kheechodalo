/**
 * 
 */
package com.click.service;

import com.click.entity.QuickHelp;
import com.click.entity.UserFeedback;


public interface QuickHelpService {

	void saveQuickHelpData(QuickHelp quickHelp);

	void saveFeedbackData(UserFeedback feed);

}
