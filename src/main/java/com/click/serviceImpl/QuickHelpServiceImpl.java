/**
 * 
 */
package com.click.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.QuickHelpDao;
import com.click.entity.QuickHelp;
import com.click.entity.UserFeedback;
import com.click.service.QuickHelpService;

@Component
@Transactional(readOnly = true)
public class QuickHelpServiceImpl implements QuickHelpService {

	@Autowired
	QuickHelpDao quickHelpDao;
	
	@Override
	@Transactional(readOnly = false)
	public void saveQuickHelpData(QuickHelp quickHelp) {
		quickHelpDao.saveQuickHelp(quickHelp);
		
	}

	@Override
	public void saveFeedbackData(UserFeedback feed) {
		quickHelpDao.saveFeedback(feed);
		
	}

	


}
