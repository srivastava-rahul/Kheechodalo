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

/**
 * @author rahul
 */
@Repository
public class WinnerDaoImpl implements WinnerDao {
	
	private static final Logger LOG = Logger.getLogger(WinnerDaoImpl.class);

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;
	

	@Override
	public List<Winner> getWinner() {
		LOG.info("Inside getWinner() DaoImpl"); 
		Query query=null;
		try{
		    query = entityManager.createQuery("from Winner");
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return (List<Winner>) query.getResultList();
	}

	@Override
	public void deleteWinner(Winner winnerdata) {
		LOG.info("Inside getWinner() DaoImpl");
		try{
		entityManager.remove(winnerdata.getId());
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		
	}


}
