package com.click.dao;

import java.util.List;

import com.click.entity.UserTestimonial;

/**
 * @author vipul
 */
public interface TestimonialDao {


	/**
	 * Save the Testimonial data by Admin
	 */
	public void savetestimonial(UserTestimonial testimonialdata);
	
	/**
	 * Get List of the Testimonial data for user dashboard
	 */
	public List<UserTestimonial> gettestimonial(int pageNo);
	
	
	/**
	 * Get List of the Testimonial data by Admin
	 */
	public List<UserTestimonial> gettestimonial();
	
	/**
	 * Delete Single Testimonial data by Admin  based on id 
	 */
	public void deletetestimonial(UserTestimonial testimonialdata);
	

	

}
