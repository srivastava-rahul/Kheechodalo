/**
 * 
 */
package com.click.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.click.dao.TestimonialDao;
import com.click.dao.WinnerDao;
import com.click.entity.UserTestimonial;
import com.click.entity.Winner;

/**
 * @author rahul
 */
@Repository
public class WinnerDaoImpl implements WinnerDao {

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;
	

	@Override
	public List<Winner> getWinner() {
		Query query = entityManager.createQuery("from Winner");
		return (List<Winner>) query.getResultList();
	}

	@Override
	public void deleteWinner(Winner winnerdata) {
		entityManager.remove(winnerdata.getId());
		
	}


}
