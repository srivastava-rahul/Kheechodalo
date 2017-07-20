package com.click.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.click.dao.PrizeDao;
import com.click.entity.UserPrize;

/**
 * @author rahul
 */
@Repository
public class PrizeDaoImpl implements PrizeDao {

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<UserPrize> getAllPrizeRecord() {
		System.out.println(" GetAllPrizeRecord ");
		Query query = entityManager.createQuery("from UserPrize");
		return (List<UserPrize>) query.getResultList();
	}

	@Override
	public void savePrizeRecord(UserPrize prizedata) {
		System.out.println("Prize dao :" + prizedata.toLogString());
		entityManager.merge(prizedata);
		
	}

	@Override
	public void deletePrizeRecord(UserPrize prizedata) {
		System.out.println("Prize dao :" + prizedata.toLogString());
		entityManager.remove(prizedata.getId());
		
	}
}
