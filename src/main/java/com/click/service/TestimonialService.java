/**
 * 
 */
package com.click.service;

import java.util.List;

import com.click.entity.UserTestimonial;

/**
 * @author vipul
 */

public interface TestimonialService {

	/**
	 * Save the Testimonial data by Admin
	 */
	public void savetestimonial(UserTestimonial testimonialdata);
	
	
	/**
	 * Get List of the Testimonial data by Admin
	 */
	public List<UserTestimonial> gettestimonial();
	
	/**
	 * Get List of the Testimonial data for user dashboard
	 */
	public List<UserTestimonial> gettestimonial(int pageNo);
	
	/**
	 * Delete Single Testimonial data by Admin  based on id 
	 */
	public void deletetestimonial(UserTestimonial testimonialdata);
	
	

}
