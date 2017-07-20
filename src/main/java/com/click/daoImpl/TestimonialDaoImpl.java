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
import com.click.entity.UserTestimonial;

/**
 * @author rahul
 */
@Repository
public class TestimonialDaoImpl implements TestimonialDao {

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;
	

	@Override
	public void savetestimonial(UserTestimonial testimonialdata) {
		System.out.println("Testimonial dao :" + testimonialdata.toLogString());
		entityManager.merge(testimonialdata);
	}

	@Override
	public List<UserTestimonial> gettestimonial() {
		Query query = entityManager.createQuery("from UserTestimonial");
		return (List<UserTestimonial> ) query.getResultList();
	}

	@Override
	public void deletetestimonial(UserTestimonial testimonialdata) {
		System.out.println("Notification dao :" + testimonialdata.toLogString());
		entityManager.remove(testimonialdata.getId());
		
	}




	

	

}
