package com.click.dao;

import com.click.entity.QuickHelp;
import com.click.entity.UserFeedback;

/**
 * @author vipul
 */
public interface QuickHelpDao {

	void saveQuickHelp(QuickHelp quickHelp);

	void saveFeedback(UserFeedback feed);

}
