/**
 * 
 */
package com.click.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.QuickHelpDao;
import com.click.entity.QuickHelp;
import com.click.entity.UserFeedback;
import com.click.service.QuickHelpService;

/**
 * @author vipul
 */

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

	@Override
	public List<QuickHelp> getQuickHelpData() {
		List<QuickHelp> quickhelp=quickHelpDao.getQuickHelpData();
		return quickhelp;
	}

	@Override
	public List<UserFeedback> getFeedbackData() {
		List<UserFeedback> quickhelp=quickHelpDao.getFeedbackData();
		return null;
	}



	


}
