/**
 * 
 */
package com.click.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.click.dao.QuickHelpDao;
import com.click.entity.QuickHelp;
import com.click.entity.User;
import com.click.entity.UserFeedback;

/**
 * @author vipul
 */
@Repository
public class QuickHelpDaoImpl implements QuickHelpDao {

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	@Override
	public void saveQuickHelp(QuickHelp quickHelp) {
		System.out.println("Quick dao :" + quickHelp.toLogString());
		entityManager.merge(quickHelp);

	}

	@Override
	public void saveFeedback(UserFeedback feed) {
		System.out.println("feed :" + feed.toLogString());
		entityManager.merge(feed);
	}

	@Override
	public List<QuickHelp> getQuickHelpData() {
		System.out.println("get Quick help data ");
		Query query = entityManager.createQuery("from QuickHelp");
		return (List<QuickHelp>) query.getResultList();
	}

	@Override
	public List<UserFeedback> getFeedbackData() {
		System.out.println("get Quick help data ");
		Query query = entityManager.createQuery("from UserFeedback");		
		return (List<UserFeedback>) query.getResultList();
	}

}
