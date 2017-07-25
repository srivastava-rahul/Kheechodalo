/**
 * 
 */
package com.click.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.click.dao.QuickHelpDao;
import com.click.entity.QuickHelp;
import com.click.entity.UserFeedback;

/**
 * @author vipul
 */
@Repository
public class QuickHelpDaoImpl implements QuickHelpDao {

	private static final Logger LOG = Logger.getLogger(QuickHelpDaoImpl.class);
	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	@Override
	public void saveQuickHelp(QuickHelp quickHelp) {
		LOG.info("Inside saveQuickHelp() DaoImpl");
		try{
		      entityManager.merge(quickHelp);
		   }catch(Exception e){
            LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}

	}

	@Override
	public void saveFeedback(UserFeedback feed) {
		LOG.info("Inside saveFeedback() DaoImpl");
		try{
		     entityManager.merge(feed);
		   }catch(Exception e){
			   LOG.error(e.getMessage(),e);
				e.printStackTrace();
		   }  
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuickHelp> getQuickHelpData() {
		LOG.info("Inside getQuickHelpData() DaoImpl");
		Query query=null;
		try{
		     query = entityManager.createQuery("from QuickHelp");
		   }catch(Exception e){
			   LOG.error(e.getMessage(),e);
				e.printStackTrace(); 
		   }  
		return (List<QuickHelp>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserFeedback> getFeedbackData() {
		LOG.info("Inside getFeedbackData() DaoImpl");
		Query query=null;
		try{
		     query = entityManager.createQuery("from UserFeedback");
		   }catch(Exception e){
			   LOG.error(e.getMessage(),e);
				e.printStackTrace(); 
		   }  
		return (List<UserFeedback>) query.getResultList();
	}

	@Override
	public void deleteQuickHelpData(QuickHelp quickhelp) {
		LOG.info("Inside deleteQuickHelpData() DaoImpl");
		try{
		      entityManager.remove(quickhelp.getId());
		   }catch(Exception e){
			   LOG.error(e.getMessage(),e);
				e.printStackTrace();  
		   }   
		
	}

	@Override
	public void deleteFeedbackData(UserFeedback userfeedback) {
		LOG.info("Inside deleteFeedbackData() DaoImpl");
		try{
		     entityManager.remove(userfeedback.getId());
		   }catch(Exception e){
			   LOG.error(e.getMessage(),e);
				e.printStackTrace();  
		   }
		
	}

	

}
