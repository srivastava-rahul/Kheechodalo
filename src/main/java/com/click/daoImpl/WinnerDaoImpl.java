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

import com.click.dao.WinnerDao;
import com.click.entity.Winner;
import com.click.utils.CollectionUtil;

/**
 * @author rahul
 */
@Repository
public class WinnerDaoImpl implements WinnerDao {

	private static final Logger LOG = Logger.getLogger(WinnerDaoImpl.class);

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	
	/**
	 * Get List of the Winner data for User
	 * @param pageNo TODO
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Winner> getWinner(int pageNo) {
		LOG.info("Inside getWinner() DaoImpl");
		Query query = null;
		try {
			query = entityManager.createQuery("from Winner w order by w.createdDate DESC");
			query.setFirstResult(pageNo == 1 ? 0 : ((pageNo-1)*5));
			query.setMaxResults(5);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return (List<Winner>) query.getResultList();
	}
	
	/**
	 * Get List of the Winner data by Admin
	 * @param pageNo TODO
	 * return winner information list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Winner> getAllWinnerbyadmin() {
		LOG.info("Inside getAllWinnerbyadmin() DaoImpl");
		Query query = null;
		try {
			query = entityManager.createQuery("from Winner w order by w.createdDate DESC");
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return (List<Winner>) query.getResultList();
	}

	/**
	 * Delete Single Winner data by Admin based on id
	 */
	@Override
	public void deleteWinner(Winner winnerdata) {
		LOG.info("Inside getWinner() DaoImpl");
		try {
			Query query = entityManager.createQuery("DELETE FROM Winner w where w.id = :id").setParameter("id", winnerdata.getId());
		    int deletewinnerdata = query.executeUpdate(); 
	    	LOG.info("deleteFeedBack :"+ deletewinnerdata);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}

	}

	@Override
	public void saveWinner(Winner winner) {
		entityManager.merge(winner);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Winner getLastWinner() {
		Query query = entityManager.createQuery("from Winner w order by w.createdDate DESC");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<Winner> winnerList = query.getResultList();
		if (CollectionUtil.isNotEmpty(winnerList)) {
			return winnerList.get(0);
		}
		return null;
	}

}
