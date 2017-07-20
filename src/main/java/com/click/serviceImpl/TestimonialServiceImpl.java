/**
 * 
 */
package com.click.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.TestimonialDao;
import com.click.entity.UserTestimonial;
import com.click.service.TestimonialService;

/**
 * @author rahul
 */

@Component
@Transactional(readOnly = true)
public class TestimonialServiceImpl implements TestimonialService {

    @Autowired
    TestimonialDao testimonialDao;
	
	
	@Override
	public void savetestimonial(UserTestimonial testimonialdata) {
		testimonialDao.savetestimonial(testimonialdata);
		
	}

	@Override
	public List<UserTestimonial> gettestimonial() {
		List<UserTestimonial> listoftestimonial=testimonialDao.gettestimonial();
		return listoftestimonial;
	}

	@Override
	public void deletetestimonial(UserTestimonial testimonialdata) {
		testimonialDao.deletetestimonial(testimonialdata);;
		
	}

}
