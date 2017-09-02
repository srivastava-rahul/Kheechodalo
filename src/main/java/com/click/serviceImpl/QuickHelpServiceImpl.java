/**
 * 
 */
package com.click.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
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
	
	private static final Logger LOG = Logger.getLogger(QuickHelpServiceImpl.class);

	@Autowired
	QuickHelpDao quickHelpDao;

	/**
	 * Save the quick help (problem) data of user
	 * @param quickHelp
	 */
	@Override
	@Transactional(readOnly = false)
	public void saveQuickHelpData(QuickHelp quickHelp) {
		LOG.info("Inside saveQuickHelpData() serviceImpl"); 
		try{
		quickHelpDao.saveQuickHelp(quickHelp);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}

	}

	/**
	 * Save the feedback data of user
	 * @param quickHelp
	 */
	@Override
	@Transactional(readOnly = false)
	public void saveFeedbackData(UserFeedback feed) {
		LOG.info("Inside saveFeedbackData() serviceImpl");
		try{
		quickHelpDao.saveFeedback(feed);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();	
		}

	}

	
	/**
	 * Get the quick help (problem) data For Admin
	 * @param quickHelp
	 */
	@Override
	public List<QuickHelp> getQuickHelpData() {
		LOG.info("Inside getQuickHelpData() service");
		List<QuickHelp> quickhelp=null;
		try{
		quickhelp = quickHelpDao.getQuickHelpData();
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();	
		}
		return quickhelp;
	}

	@Override
	public List<UserFeedback> getFeedbackData() {
		LOG.info("Inside getFeedbackData() serviceImpl");
		List<UserFeedback> quickhelp=null;
		try{
		      quickhelp = quickHelpDao.getFeedbackData();
	       }catch(Exception e){
		   LOG.error(e.getMessage(),e);
			e.printStackTrace();	
	   }
		return quickhelp;
	}

	/**
	 * Delete the quick help (problem) data by Admin based on id
	 * @param quickHelp
	 */
	@Override
	@Transactional(readOnly = false)
	public void deleteQuickHelpData(QuickHelp quickhelp) {
		LOG.info("Inside deleteQuickHelpData() serviceImpl");
		try{
		quickHelpDao.deleteQuickHelpData(quickhelp);
		}catch(Exception e){
			 LOG.error(e.getMessage(),e);
				e.printStackTrace();	
		}

	}

	/**
	 * Delete the feedback data by Admin based on id
	 * @param quickHelp
	 */
	@Override
	@Transactional(readOnly = false)
	public void deleteFeedbackData(UserFeedback userfeedback) {
		LOG.info("Inside deleteFeedbackData() serviceImpl");
		try{
		quickHelpDao.deleteFeedbackData(userfeedback);
		}catch(Exception e){
			 LOG.error(e.getMessage(),e);
				e.printStackTrace();	
		}

	}

}
