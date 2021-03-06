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

import com.click.dao.TestimonialDao;
import com.click.entity.UserTestimonial;

/**
 * @author rahul
 */
@Repository
public class TestimonialDaoImpl implements TestimonialDao {
	
	private static final Logger LOG = Logger.getLogger(TestimonialDaoImpl.class);

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;
	


	/**
	 * Save the Testimonial data by Admin
	 */
	@Override
	public void savetestimonial(UserTestimonial testimonialdata) {
		LOG.info("Inside savetestimonial() DaoImpl"); 
		try{
		      entityManager.merge(testimonialdata);
		   }catch(Exception e){
			   LOG.error(e.getMessage(),e);
				e.printStackTrace();
		   }   
	}

	/**
	 * Get List of the Testimonial data for user dashboard
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserTestimonial> gettestimonial(int pageNo) {
		LOG.info("Inside gettestimonial(int pageNo) DaoImpl");
		Query query=null;
		try{
			 query = entityManager.createQuery("from UserTestimonial");
			 
			 query = entityManager.createQuery("from UserTestimonial ut order by ut.createdDate DESC");
				query.setFirstResult(pageNo == 1 ? 0 : ((pageNo-1)*5));
				query.setMaxResults(5);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		
		return (List<UserTestimonial> ) query.getResultList();
	}

	/**
	 * Delete Single Testimonial data by Admin  based on id 
	 */
	@Override
	public void deletetestimonial(UserTestimonial testimonialdata) {
		LOG.info("Inside deletetestimonial() DaoImpl");
		 try{
			 Query query = entityManager.createQuery("DELETE FROM UserTestimonial ut where ut.id = :id").setParameter("id", testimonialdata.getId());
			    int deleteTestimonial = query.executeUpdate(); 
		    	LOG.info("deleteFeedBack :"+ deleteTestimonial);
		    }catch(Exception e){
		    	LOG.error(e.getMessage(),e);
				e.printStackTrace();
		    }
		
	}

	/**
	 * Get List of the Testimonial data by Admin
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserTestimonial> gettestimonial() {
		LOG.info("Inside gettestimonial() DaoImpl");
		Query query=null;
		try{
			 query = entityManager.createQuery("from UserTestimonial");
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		
		return (List<UserTestimonial> ) query.getResultList();
	}




	

	

}
