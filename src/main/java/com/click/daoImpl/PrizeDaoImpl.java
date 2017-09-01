package com.click.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.click.dao.PrizeDao;
import com.click.entity.UserPrize;

/**
 * @author rahul
 */
@Repository
public class PrizeDaoImpl implements PrizeDao {
	
	private static final Logger LOG = Logger.getLogger(PrizeDaoImpl.class);

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	/**
	 * Get The list of All Prize by User
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserPrize> getAllPrizeRecord() {
		LOG.info(" Inside getAllPrizeRecord() DaoImpl GetAllPrizeRecord ");
		Query query=null;
		try{
		     query = entityManager.createQuery("from UserPrize");
		   }catch(Exception e){
			   LOG.error(e.getMessage(),e);
				 e.printStackTrace();
		   }
		return (List<UserPrize>) query.getResultList();
	}

	/**
	 * Saving The prize by Admin
	 * @param prizedata
	 */
	@Override
	public void savePrizeRecord(UserPrize prizedata) {
		LOG.info(" Inside savePrizeRecord() DaoImpl GetAllPrizeRecord ");
		 try{
		      entityManager.merge(prizedata);
		    }catch(Exception e){
		    	LOG.error(e.getMessage(),e);
				 e.printStackTrace();
		    }
		
	}

	/**
	 * Delete The prize by Admin
	 * @param prizedata
	 */
	@Override
	public void deletePrizeRecord(UserPrize prizedata) {
		LOG.info(" Inside deletePrizeRecord() DaoImpl GetAllPrizeRecord ");
		try{
			Query query = entityManager.createQuery("DELETE FROM UserPrize pz where pz.id = :id").setParameter("id", prizedata.getId());
			int deleteprizedata = query.executeUpdate(); 
			LOG.info("deleteFeedBack :"+ deleteprizedata);
		   }catch(Exception e){
             LOG.error(e.getMessage(),e);
			 e.printStackTrace();
		   }   
		
	}
}
