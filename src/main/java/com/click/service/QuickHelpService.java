/**
 * 
 */
package com.click.service;

import com.click.entity.QuickHelp;
import com.click.entity.UserFeedback;

/**
 * @author vipul
 */
public interface QuickHelpService {

	void saveQuickHelpData(QuickHelp quickHelp);

	void saveFeedbackData(UserFeedback feed);

}
