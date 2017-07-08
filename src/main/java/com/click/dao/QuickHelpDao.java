package com.click.dao;

import com.click.entity.QuickHelp;
import com.click.entity.UserFeedback;

public interface QuickHelpDao {

	void saveQuickHelp(QuickHelp quickHelp);

	void saveFeedback(UserFeedback feed);

}
